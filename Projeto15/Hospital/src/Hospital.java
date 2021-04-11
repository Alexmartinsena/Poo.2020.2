package hospital013;

import java.util.TreeMap;

public class Hospital{
	TreeMap<String, IPaciente> pacientes;
	TreeMap<String, IMedico> medicos;

	Hospital(){
        pacientes = new TreeMap<>();
        medicos = new TreeMap<>();
    }
	
	void addPaciente(Paciente paciente){
		pacientes.put(paciente.getId(), paciente);
	}

	void addMedico(Medico medico){
		medicos.put(medico.getId(), medico);
	}
	
	void rmPaciente(String id) {
		IPaciente paciente = pacientes.get(id);
		if(paciente == null)
			return;
		for(IMedico medico : paciente.getMedicos()) 
			medico.removerPaciente(id);
		pacientes.remove(id);
	}
	
	void rmMedico(String id) {
		IMedico medico = medicos.get(id);
		if(medico == null)
			return;
		for(IPaciente paciente : medico.getPacientes()) 
			paciente.removerMedico(id);
		medicos.remove(id);
	}

	void vincular(String nomeMedico, String nomePaciente){
		IMedico medico = medicos.get(nomeMedico);
		IPaciente paciente = pacientes.get(nomePaciente);
		
		if(medico == null)
			return;
		
		for(IMedico medc : paciente.getMedicos()){
			if(medico.getEspec().equals(medc.getEspec())){
				System.out.println("fail: Ja existe um medico para essa especialidade");
				return;
			}
		}
		
		medico.addPaciente(paciente);
		paciente.addMedico(medico);
	}

	String showAll(){
		StringBuilder List = new StringBuilder();
		
		for(IPaciente paciente : pacientes.values()) 
		List.append(paciente);
		
		for(IMedico medico : medicos.values()) 
		List.append(medico);
		
		return List.toString();
	}
}
