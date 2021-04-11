package hospital013;

import java.util.Collection;

public interface IPaciente{
	public String getId();

	public String getdiag();
	
	public Collection<IMedico> getMedicos();

	public void addMedico(IMedico medico);
	
	public void removerMedico(String idMedico);
	
	public String toString();
}
