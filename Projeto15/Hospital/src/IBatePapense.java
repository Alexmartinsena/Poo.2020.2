package hospital013;

import java.util.List;

interface IBatePapense {
	String getId();

	List<Mensagem> getDirect();

	void addMessage(Mensagem msg);
	
	void sendMessage(Mensagem msg, IBatePapense batePapense);
	
	
}
