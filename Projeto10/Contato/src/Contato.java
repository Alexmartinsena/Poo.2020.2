import java.util.ArrayList;
import java.util.Scanner;

class Fone{
    public String id;
    public String number; 
    public Fone(String id, String number){
        this.id = id;
        this.number = number;
    }

    public String toString() {
        return id + ":" + number;
    }

    public static boolean validate(String number){
        String validos = "0123456789().-"; //caracteres validos
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(validos.indexOf(c) == -1)
                return false;
        }
        return true;
    }
}

class Contato{
    private String name;
    private ArrayList<Fone> fones; //arraylist

    public Contato(String name){
        this.name = name;
        fones = new ArrayList<>(); //array sem os telefones
    }
    
    public String getName(){
        return name;
    }

    public String toString(){
        String saida = "- " + this.name;
        if(fones.size() > 0)
            saida += " ";
        for(int i = 0; i < fones.size(); i++){
            Fone fone = fones.get(i);
            saida += "[" + i + ":" +  fone + "]";
        }
        return saida;
    }

    public void addFone(String id, String number){ 
        if(Fone.validate(number)){
            fones.add(new Fone(id, number));
            return;
        }
        throw new IllegalArgumentException();
    }
    
    
    public void removeFone(int index){
        if(index >= 0 || index < fones.size()){
        fones.remove(index);
        return;
        }
        
        throw new NullPointerException();
    }
}
    

public class Contatos{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contato contato = new Contato("");
        while(true){
            System.out.println("--------------Agenda de Contatos---------------");
            System.out.println("- Iniciar sua lista de contatos: 'init'");
            System.out.println("- Adicionar um numero: 'add'");
            System.out.println("- Remover um numero: 'rm'");
            System.out.println("- Mostrar sua lista: 'show'");
            System.out.println("- Sair da lista: 'end'\n");

            System.out.print("Escolha aqui sua opção: ");
            
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            
            if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("init")){
                contato = new Contato(ui[1]);
            }
            else if(ui[0].equals("add")){   
                try{
                    contato.addFone(ui[1], ui[2]);
                }
                catch(IllegalArgumentException e){
                    System.out.println("fail: Telefone Invalido");
                }
            }    
            else if(ui[0].equals("rm")){
                try{
                    contato.removeFone(Integer.parseInt(ui[1]));
                }
                catch(NullPointerException n){
                    System.out.println("fail: Telefone Invalido");
                }    
            }
            else if(ui[0].equals("show")){
                System.out.println(contato);
            }
            else{
                System.out.println("Comando Inválido");
            }
        }
        scanner.close();
    }
}
