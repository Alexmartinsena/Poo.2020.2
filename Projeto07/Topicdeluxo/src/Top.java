package topik;

import java.util.Scanner;

public class Top {
    public static void main(String[] args) {
        Topic topic = new Topic(0,0);
        Scanner ler = new Scanner(System.in);
        
        while (true) {
            String comando = ler.nextLine();
            String[] vetor = comando.split(" ");
            System.out.println("$"+ comando);
            
            if(vetor[0].equals("show")){
                System.out.println(topic.toString());
            }
            else if(vetor[0].equals("init")){
                topic = new Topic(Integer.parseInt(vetor[1]), Integer.parseInt(vetor[2]));
            }
            else if(vetor[0].equals("in")){
                if(vetor.length == 2){
                    topic.Passa(vetor[1]);
                }
                else{
                    topic.Passa(vetor[1], Integer.parseInt(vetor[2]));
                }
            }
            else if(vetor[0].equals("out")){
                topic.remover(vetor[1]);
            }
            else{
                break;
            }
        }
        
    }
}
