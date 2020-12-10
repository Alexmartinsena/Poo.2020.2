import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade){ 
        this.nome = nome;
        this.idade = idade;
    }

    public String toString(){
        return "[" + this.nome + ":" + this.idade + "]";
    }
}

class Motoca {
	Pessoa pessoa; //agregacao
    int potencia;
    int tempo;

	public Motoca(int potencia){
        this.potencia = potencia;
        this.tempo = 0;
	}
    
    void comprar(int tempo){
        this.tempo += tempo;
    }
	
	boolean embarcar(Pessoa pessoa) {
		if(this.pessoa == null){
			this.pessoa = pessoa;
			return true;
		}
		System.out.println("A moto esta lotada");
		return false;
	}
	
	Pessoa desembarcar() {
		if(this.pessoa != null){
			Pessoa pessoa = this.pessoa;
			this.pessoa = null;
			return pessoa;
		}
		else{
			System.out.println("A moto esta vazia");
			return null;
		}
	}

	void dirigir(int tempo){
		if(this.pessoa == null)
			System.out.println("A moto esta vazia");
		else if(this.pessoa.idade > 10)
			System.out.println("Já ta muito grandinho pra andar de moto");
        else if(this.tempo == 0)
			System.out.println("Acabou o Tempo");
        else if(this.tempo < tempo){
            System.out.println("Andou " + this.tempo + " min e acabou o tempo");
            this.tempo = 0;
		}
		else
            this.tempo -= tempo;
    }

	void buzinar(){
        if(this.pessoa == null){
            System.out.println("A moto esta vazia");
            return;
        }
		String saida = "";
		for(int i = 0; i < this.potencia; i++)
			saida += "e";
		System.out.println("P" + saida + "m");
    }
    
    public String toString(){
        return "potencia: " + this.potencia + ", minutos: " + this.tempo + ", pessoa: " + this.pessoa;
    }
}

public class Motoparque{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Motoca motoca  = new Motoca(1);
		while(true) {
			String line = scanner.nextLine();
            String ui[] = line.split(" "); 
            System.out.println("$" + line);
			if(ui[0].equals("end")) {
				break;
			}
			else if(ui[0].equals("init")) { //potencia
				Pessoa pessoa = motoca.pessoa;
				motoca = new Motoca(Integer.parseInt(ui[1]));
				motoca.embarcar(pessoa);
			}
			else if(ui[0].equals("in")) { //nome idade
				int idade = Integer.parseInt(ui[2]);
				Pessoa pessoa = new Pessoa(ui[1], idade);
				motoca.embarcar(pessoa);
			}
			else if(ui[0].equals("out")) {
				motoca.desembarcar();
			}
			else if(ui[0].equals("show")) {
				System.out.println(motoca);
			}
			else if(ui[0].equals("drive")) {
				motoca.dirigir(Integer.parseInt(ui[1]));
			}
			else if(ui[0].equals("buy")) {
				motoca.comprar(Integer.parseInt(ui[1]));
			}
			else if(ui[0].equals("buzinar")) {
				motoca.buzinar();
			}
			else {
				System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
}

