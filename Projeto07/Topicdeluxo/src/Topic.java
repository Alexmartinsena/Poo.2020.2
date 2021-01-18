package topik;

import java.util.ArrayList;

public class Topic{
    private int NumAcentos;
    private int NumPref;
    private ArrayList<Passageiro> acentos = new ArrayList<Passageiro>();

    public Topic(int NumAcentos, int NumPref) {
        this.NumAcentos = NumAcentos;
        this.NumPref = NumPref;
        for(int i = 0; i < NumAcentos; i++){
            acentos.add(null);
        }
    }

    private boolean Presente(String nome){
        for(int i = 0; i < NumAcentos; i++){
            if(acentos.get(i) != null && acentos.get(i).getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public void Passa(String nome){
        if(Presente(nome)){
            System.out.println("fail: passageiro ja esta na topic");
        }
        else{
            System.out.println("fail: passageiro nao esta na topic");
        }

    }

    public void Passa(String nome, int idade){
        if(Presente(nome)){
            System.out.println("fail: passageiro ja esta na topic");
        }
        if(idade > 65){
            for(int i = 0; i < NumAcentos; i++){
                if(acentos.get(i) == null){
                    acentos.set(i ,new Passageiro(nome, idade));
                    return;
                }
            }
        }
        else{
            for(int i = NumPref; i < NumAcentos;i++){
                if(acentos.get(i) == null){
                    acentos.set(i ,new Passageiro(nome, idade));
                    return;
                }
            }
            for(int i = 0; i < NumAcentos;i++){
                if(acentos.get(i) == null){
                    acentos.set(i ,new Passageiro(nome, idade));
                    return;
                }
            }
        }
        System.out.println("fail: topic lotadassa");
    }

    public void remover(String nome){
        for(int i = 0; i < NumAcentos; i++){
            if(acentos.get(i) != null && acentos.get(i).getNome().equals(nome)){
                acentos.set(i, null);
                return;
            }
        }
        System.out.println("fail: passageiro nao esta na topic");
    }

    public String toString() {
        String tostring = "[ ";
        for(int i = 0; i < NumAcentos; i++){
            if(i < NumPref){
                if(acentos.get(i) != null){
                    tostring += "@"+ acentos.get(i).toString() +" ";
                }else{
                    tostring += "@ ";
                }
            }
            else{
                if(acentos.get(i) != null){
                    tostring += "="+ acentos.get(i).toString() +" ";
                }
                else{
                    tostring += "= ";
                }
            }
        }
        tostring += "]";
        return tostring;
    }
}
