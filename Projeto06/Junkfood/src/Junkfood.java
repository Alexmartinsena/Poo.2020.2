import java.util.ArrayList;
import java.util.Scanner;

class Espiral{
    public String name;
    public double value;
    public int qtd;
    
    public Espiral(String name, double value, int qtd){
        this.name = name;
        this.value = value;
        this.qtd = qtd;
    }
    
    public String toString(){
        return "[" + this.name + " : " + this.qtd + " : " + this.value + "]";
    }

    public void edit(String name, float value, int qtd) {
        this.name = name;
        this.value = value;
        this.qtd = qtd;
    }
}

class Maquina {
    public ArrayList<Espiral> espiral;
    public float balance;
    public float gain;
    

    public Maquina() {
        this.espiral = new ArrayList<>();
        this.balance = 0;
        this.gain = 0.0f;
        
    }

    public void addDinheiro(Float money){
        this.balance = money;
    }

    public void addProduto(String name, float value, int qtd){
        espiral.add(new Espiral(name, value, qtd));
    }

    public void troco(){
        if(balance > 0){
            System.out.println("O Seu troco é de " + balance + "$");
            this.balance = 0;
        }
        else System.out.println("Não há troco");
    }

    public void comprar(int index, int qtd){
        for(int i = 0; i < qtd; i++){
            if(index >= 0 && index < espiral.size()){
                
                if(espiral.get(index).value <= this.balance){
                    
                    if(espiral.get(index).qtd > 0){
                        this.balance -= espiral.get(index).value;
                        this.gain += espiral.get(index).value;
                        espiral.get(index).qtd --;
                    }
                    else {
                        System.out.println("Não há produtos na espiral");
                        break;
                    }
                }
                else {
                    System.out.println("Saldo Insuficiente");
                    break;
                }
            }
            else {
                System.out.println("index não encontrado");
                break;
            }
            
        }
        
    }

    public boolean alterarEspiral(int index, String name, float value, int qtd){
        if(index >= 0 && index < espiral.size()){
            espiral.get(index).edit(name, value, qtd);
            return true;
        }
        return false;
    }
    
    public float getbalance(){
        return balance;
    }

    
    public String toString() {
        String saida = "balance : " + this.balance + "\n";
        int i=0;
        for(Espiral espiral : espiral){
            saida += i + "[" + espiral + "]\n";
            i++;
        }
        return saida;
    }
}

public class Junkfood{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maquina1 = new Maquina();
    
        System.out.println("--------JUNKFOOD MACHINE--------");
        System.out.println("Ligar a Maquina: 'Init'");
        System.out.println("Desligar a Maquina: 'End'");
        System.out.println("Inserir Dinheiro: 'AddDinheiro'");
        System.out.println("Inserir um Produto: 'AddProduto'");
        System.out.println("Devolver Troco: 'Troco'");
        System.out.println("Comprar um Produto: 'Comprar'");
        System.out.println("Mostrar os Status: 'Show'\n");

        System.out.println("Escola aqui a sua opção: ");

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("Init")){
                maquina1 = new Maquina();
                System.out.println(maquina1);
            }

            if(ui[0].equals("End")){
                System.out.println("Fim do programa");
                break;
            }

            if(ui[0].equals("AddDinheiro")){
                maquina1.addDinheiro(Float.parseFloat(ui[1]));
                System.out.println(maquina1);
            }

            if(ui[0].equals("AddProduto")){
                maquina1.addProduto(ui[1], Float.parseFloat(ui[2]), Integer.parseInt(ui[3]));
                System.out.println(maquina1);
            }
            
            if(ui[0].equals("Troco")){
                maquina1.troco();
            }

            if(ui[0].equals("Comprar")){
                maquina1.comprar(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                System.out.println(maquina1);
            }

            if(ui[0].equals("SetEspiral")){
                maquina1.alterarEspiral(Integer.parseInt(ui[1]), ui[2], Float.parseFloat(ui[3]), Integer.parseInt(ui[4]));
                System.out.println(maquina1);
            }

            if(ui[0].equals("Show")){
                System.out.println(maquina1);
            }

            
        }
        scanner.close();

    }


}

    
