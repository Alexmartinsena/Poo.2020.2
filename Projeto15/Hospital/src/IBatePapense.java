package hospital013;

import java.util.List;

interface IBatePapense {
	String getId();

	void addMessage(Mensagem msg);
	
	void sendMessage(Mensagem msg, IBatePapense batePapense);
	
	List<Mensagem> getInbox();
}
