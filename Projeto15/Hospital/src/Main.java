
package hospital013;
import java.util.Collection;
import java.util.TreeMap;

public class Paciente implements IPaciente{
	protected String id;
	protected String diag; //diagnostico
	protected TreeMap<String, IMedico> medicos;

	Paciente(String id, String diag){
		this.id = id;
		this.diag = diag;
		this.medicos = new TreeMap<String, IMedico>();
	}

	public String getId() {
		return id;
	}

	public void addMedico(IMedico medico) {
		IMedico Xmedico = medicos.get(medico.getId());
		if(Xmedico != null)
			return;
		medicos.put(medico.getId(), medico);
		medico.addPaciente(this);
	}

	public void removerMedico(String idMedico) {
		IMedico Xmedico = medicos.get(idMedico);
		if(Xmedico == null)
			return;
		medicos.remove(idMedico);
		Xmedico.removerPaciente(this.id);
	}

	public Collection<IMedico> getMedicos(){
		return medicos.values();
	}

	public String getdiag(){
		return diag;
	}

	public String toString(){
		String ListMedicos = new String();
		for(IMedico medico: getMedicos()) ListMedicos += medico.getId()+" ";
		return "Pacientes: " + String.format(getId() + ":" + getdiag()) + " Medicos: [ " + ListMedicos + "] \n";
	};
}
