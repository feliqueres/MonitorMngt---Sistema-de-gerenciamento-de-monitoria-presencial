package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import dominio.Edital;

@ManagedBean(name = "editalMB")
public class EditaisMB {
	private List<Edital> editais;
	private Edital edital;

	@PostConstruct
	public void iniciar() {
		this.editais = new ArrayList<Edital>();
		Edital edital1 = new Edital(), edital2 = new Edital();

		edital1.setNumero(332);
		edital1.setEscola("Sa�de");
		edital1.setCurso("Medicina");
		edital1.setPeriodoLetivo("1� semestre");

		edital2.setNumero(3513);
		edital2.setEscola("Ci�ncia e Tecnologia");
		edital2.setCurso("Engenharia de Petr�leo e G�s");
		edital2.setPeriodoLetivo("2� semestre");

		edital = new Edital();
		
		this.editais.add(edital1);
		this.editais.add(edital2);
	}

	public List<Edital> getEditais() {
		return this.editais;
	}

	public void setEditais(List<Edital> editais) {
		this.editais = editais;
	}
	

	public Edital getEdital() {
		return edital;
	}

	public void setEdital(Edital edital) {
		this.edital = edital;
	}
	public String acaoAbrirInfo(Edital edital){
		this.edital = edital;
		return "editalInfo";
	}
	public String acaoAbrirAlterar(Edital edital){
		this.edital = edital;
		return "editalEditar";
	}
}