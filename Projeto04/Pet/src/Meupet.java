import java.util.Scanner;

class tamagotchi{
    private int hungry;
    private int energy;
    private int clean;
    private int maxhungry;
    private int maxenergy;
    private int maxclean;
    private int diamonds;
    private int age;
    private boolean Alive;

    tamagotchi(int maxhungry, int maxenergy, int maxclean, int diamonds, int age){
        this.hungry = maxhungry;
        this.energy = maxenergy;
        this.clean = maxclean;
        this.maxhungry = maxhungry;
        this.maxenergy = maxenergy;
        this.maxclean = maxclean;
        this.diamonds = diamonds;
        this.age = age;
        this.Alive = true;
    }
    
    private void setdiamonds(int value){
        diamonds = value;
    }

    private void setage(int value){
        age = value;
    }

    private void setclean(int value){
        clean = value;
        
        if(clean > maxclean){
            clean = maxclean;
        }
        
        if(clean < 0){
            clean = 0;
            this.Alive = false;
            System.out.println("Seu Pet sucumbiu pra sujeira");
        }
    }

    private void sethungry(int value){
        hungry = value;
        
        if(hungry > maxhungry){
            hungry = maxhungry;
        }
        
        if(hungry < 0){
            hungry = 0;
            this.Alive = false;
            System.out.println("Seu Pet sucumbiu pra fome");
        }
    }

    private void setenergy(int value){
        energy = value;
        
        if(energy > maxenergy){
            energy = maxenergy;
        }
        
        if(energy < 0){
            energy = 0;
            this.Alive = false;
            System.out.println("Seu Pet sucumbiu pro cansaço");
        }
    }

    public boolean isAlive(){
        return this.Alive;
    }
    
    public int getdiamonds(){
        return diamonds;
    }
    
    public int getage(){
        return age;
    }

    public int getenergy(){
        return energy;
    }
    
    public int getclean(){
        return clean;
    }
    
    public int gethungry(){
        return hungry;
    }
    
    public void getBrincar(){
        if(!this.Alive){
			System.out.println("Você nao pode interagir com o pet,ele está morto");
			return;
		}
        this.setenergy(getenergy() - 2);
        this.sethungry(gethungry() - 1);
        this.setclean(getclean() - 3);
        this.setdiamonds(getdiamonds() + 1);
        this.setage(getage() + 1);
    }
    
    public void getComer(){
        this.setenergy(getenergy() - 1);
        this.sethungry(gethungry() + 4);
        this.setclean(getclean() - 2);
        this.setage(getage() + 1);
    }

    public void getBanho(){
        this.setenergy(getenergy() - 3);
        this.sethungry(gethungry() - 1);
        this.setclean(getclean() + maxclean);
        this.setage(getage() + 2);
    }

    public void getDormir(int sleep){
        if(this.energy == maxenergy){
            System.out.println("Seu Pet não está com sono");
            return;
        }
        this.setenergy(getenergy() + maxenergy);
        this.setage(getage() + sleep);
    }

    public String toString(){
        return 
        ("E:" + this.energy + "/" + maxenergy + ", " +
        "S:" + this.hungry + "/" + maxhungry + ", " +
        "L:" + this.clean + "/" + maxclean + ", " +
        "D:" + this.diamonds + ", " + "I:" + this.age);
    }

    public static void main(String[] args) {

        tamagotchi tamagotchi = new tamagotchi(20, 10, 15, 0, 0);
        System.out.println(tamagotchi);
        
    }
}

public class Meupet{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        tamagotchi tamagotchi = new tamagotchi(20, 10, 15, 0, 0);   

        while(tamagotchi.isAlive()){
            System.out.println("Digite clean,para dar banho no pet");
            System.out.println("Digite play, para brincar com o pet");    
            System.out.println("Digite eat, para alimentar o pet");
            System.out.println("Digite sleep, para fazer o pet dormir");
            System.out.println("Digite end, para encerrar suas interações com o pet\n");
            
            System.out.println("Escolha sua Opção:");
            String input = scanner.nextLine();
            String[] value = input.split(" ");
            int sleep = value.length;

            if(input.equals("show")){
                System.out.println(tamagotchi);
            }
            else if(input.equals("play")){
                tamagotchi.getBrincar();
            }
            else if(input.equals("eat")){
                tamagotchi.getComer();
            }
            else if(value[0].equals("sleep")){
                tamagotchi.getDormir(sleep);
            }
            else if(input.equals("clean")){
                tamagotchi.getBanho();
            }
            else if(input.equals("end")){
                break;
            }
            else
                System.out.println("Fail: Comando inválido");
        }
        System.out.println(tamagotchi);
        System.out.println("\n");
        scanner.close();
    }
}
