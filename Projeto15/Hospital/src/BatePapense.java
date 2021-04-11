package hospital013;
import java.util.ArrayList;
import java.util.List;

class Mensagem{
	String Id;
	String texto;
	
	public Mensagem(String id, String texto) {
		this.Id = id;
		this.texto = texto;
	}
}

abstract class BatePapense {
	ArrayList<Mensagem> inbox;
	abstract String getId();
	
	List<Mensagem> getInbox(){
		List<Mensagem> saida = new ArrayList<Mensagem>(this.inbox);
		this.inbox.clear();
		
		return saida;
	}
	
	public void sendMessage(Mensagem msg, IBatePapense batePapense){
		batePapense.addMessage(msg);
	}
	
	abstract List<BatePapense> getDestinatarios();

}
