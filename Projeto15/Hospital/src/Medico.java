package hospital013;
import java.util.Collection;
import java.util.TreeMap;

class Medico implements IMedico{
	String id;
	String espec;
	TreeMap<String, IPaciente> pacientes;

	Medico(String id, String espec){
		this.id = id;
		this.espec = espec;
		this.pacientes = new TreeMap<String, IPaciente>();
	}

	public String getId() {
		return id;
	}

	public void addPaciente(IPaciente paciente) {
		IPaciente Xpaciente = pacientes.get(paciente.getId());
		if(Xpaciente != null)
			return;
		pacientes.put(paciente.getId(), paciente);
		paciente.addMedico(this);
	}

	public void removerPaciente(String idPaciente) {
		IPaciente Xpaciente = pacientes.get(idPaciente);
		if(Xpaciente == null)
			return;
		pacientes.remove(idPaciente);
		Xpaciente.removerMedico(this.id);
	}

	public Collection<IPaciente> getPacientes(){
		return pacientes.values();
	}

	public String getEspec(){
		return this.espec;
	}

	public String toString(){
		String pacientes = new String();
		for(IPaciente paciente: getPacientes()) pacientes += paciente.getId() + " ";
		return "Medicos: " + String.format("%-16.16s",getId() + ":" + getEspec()) + " Pacientes: [ " + pacientes + "] \n";
	}

	

}
