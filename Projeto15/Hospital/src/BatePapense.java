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
	ArrayList<Mensagem> direct;
	abstract String getId();
	
	List<Mensagem> getDirect(){ //Mensagens Diretas
		List<Mensagem> saida = new ArrayList<Mensagem>(this.direct);
		this.direct.clear();
		
		return saida;
	}
	
	public void sendMessage(Mensagem msg, IBatePapense batePapense){
		batePapense.addMessage(msg);
	}
	
	abstract List<BatePapense> getDestinatarios();

}
