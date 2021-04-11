package hospital013;

import java.util.Collection;

public interface IMedico{
	public String getId();

	public String getEspec();
	
	public Collection<IPaciente> getPacientes();

	public void addPaciente(IPaciente paciente);
	
	public void removerPaciente(String idPaciente);
	
	public String toString();
}
