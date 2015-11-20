package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import controle.util.JSFUtil;
import dominio.Aluno;
import dominio.dao.AlunoDAO;

@ManagedBean(name = "alunoMB")
public class AlunoMB {
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos = null;
	private AlunoDAO dao = new AlunoDAO();

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		if (this.alunos == null)
			this.alunos = this.dao.lerTodos();

		return this.alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String acaoEditar() {
		Long id = JSFUtil.getParametroLong("id");
		Aluno alunoBD = this.dao.lerPorId(id);
		this.setAluno(alunoBD);

		return "manterAluno";
	}

	public String acaoInfo(Aluno aluno) {
		this.aluno = aluno;
		return "infoAluno";
	}

	@Override
	public String toString() {
		StringBuilder sbAluno = new StringBuilder();
		for (Aluno aluno : this.alunos) {
			sbAluno.append(aluno.getNome() + " - " + aluno.getMatricula()
					+ ". ");
		}
		return sbAluno.toString();
	}

	public String salvar() {
		// EntityManager manager = JPAUtil.getEntityManager();
		// manager.getTransaction().begin();
		// manager.persist(this.getAluno());
		// manager.getTransaction().commit();
		// manager.close();
		this.dao.salvar(this.getAluno());
		this.setAluno(new Aluno());
		return "alunos";
	}
}
