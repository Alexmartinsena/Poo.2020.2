import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayList;

class Conta {
    int id;
    float saldo;
    String ClienteId;
    String Tipo;

    Conta(int id, String ClienteId){
        this.id = id;
        this.ClienteId = ClienteId;
        this.saldo = 0;
        
    }

    void sacar(float valor){
        if(saldo >= valor)
            saldo -= valor;
        else
            throw new RuntimeException("fail: Seu saldo é insuficiente");
    }

    void depositar(float valor){
        saldo += valor;
    }

    void transferir(Conta Other, float valor){
        this.sacar(valor);
        Other.depositar(valor);
    }

    public void attMensal(){
        
    }

    public String toString(){
        return id + ":" + ClienteId + ":" + saldo + ":" + Tipo;
    }
}

class ContaCorrente extends Conta {
    float tarifaMensal;

    ContaCorrente(int id, String ClienteId) {
        super(id, ClienteId);
        this.Tipo = "CC";
        
    }

    public void attMensal() {
        saldo -= 20;
    }
}
class ContaPoupança extends Conta{

    ContaPoupança(int id, String ClienteId) {
        super(id, ClienteId);
        this.Tipo = "CP";
        
    }

    public void atualizacaoMensal() {
        this.saldo *= 1.01;
    }
}
class Cliente {
    String id;
    TreeMap<String, Conta> contas;

    Cliente(String id){
        this.id = id;
        this.contas = new TreeMap<>();
    }
}
class Agencia {
    TreeMap<String, Cliente> clientes;
    ArrayList<Conta> contas;
    int NextConta;
    

    Agencia(){
        this.clientes = new TreeMap<>();
        this.contas = new ArrayList<>();
        this.NextConta = 0;
       
    }

    void adicionarCliente(String id){
        if(clientes.containsKey(id))
            throw new RuntimeException("fail: Esse cliente já esxite.");
        Cliente cliente = new Cliente(id);
        clientes.put(id, cliente);
        
        
        cliente.contas.put(id, new ContaCorrente(NextConta, id));
        this.contas.add(new ContaCorrente(NextConta, id));
        NextConta++;
        
        cliente.contas.put(id, new ContaPoupança(NextConta, id));
        this.contas.add(new ContaPoupança(NextConta, id));
        ++NextConta;
    }

    public String toString(){
        StringBuilder out = new StringBuilder();
        
        for (Conta conta : contas)
            out.append(conta + "\n");
        return out.toString();
    }
}
public class Cadastro {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agencia agencia = new Agencia();

        while(true){
            try{
                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] ui = line.split(" ");

                if(ui[0].equals("end")){
                    break;
                }
                
                else if(ui[0].equals("show")){
                    System.out.println(agencia);
                }
                
                else if(ui[0].equals("addcli")){
                    agencia.adicionarCliente(ui[1]);
                }
                
                else if(ui[0].equals("sacar")){
                    agencia.contas.get(Integer.parseInt(ui[1])).sacar(Integer.parseInt(ui[2]));
                }
                
                else if(ui[0].equals("depositar")){ 
                    agencia.contas.get(Integer.parseInt(ui[1])).depositar(Integer.parseInt(ui[2]));
                }
                
                else if(ui[0].equals("transferir")){
                    Conta Other = agencia.contas.get(Integer.parseInt(ui[2]));
                    if(agencia.contas.get(Integer.parseInt(ui[2])) == null){
                        System.out.println("fail: conta não encontrada");
                    }
                    
                    else 
                        agencia.contas.get(Integer.parseInt(ui[1])).transferir(Other, Integer.parseInt(ui[3]));
                }
                
                else if(ui[0].equals("update")){
                    for(Conta contas : agencia.contas)
                        contas.attMensal();
                }
                
                else    
                    System.out.println("fail: comando invalido");
            }
            
            catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
    }
}   
