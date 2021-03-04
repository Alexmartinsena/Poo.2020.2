package ContatoStar;

import java.util.*;

class AgendaPlus extends Agenda {
    public static TreeMap<String, ContatoPlus> favoritos;

    public AgendaPlus() {
        favoritos = new TreeMap<>();
    }

    public static void Favoritar(String id) {
        favoritos = new TreeMap<>();

        if(contatos.containsKey(id)) {
            ContatoPlus contatoPlus = (ContatoPlus) contatos.get(id);
            contatoPlus.favorited = true;
            favoritos.put(contatoPlus.name, contatoPlus);
        } 
        else{
            System.out.println("Fail: O contato nao foi encontrado");
            return;
        }
    }

    public static void Desfavoritar(String id) {

        if(contatos.containsKey(id)) {
            ContatoPlus contatoPlus = (ContatoPlus) contatos.get(id);
            contatoPlus.favorited = false;
            favoritos.remove(id);
        } 
        else{
            System.out.println("Fail: O contato nao foi encontrado");
            return;
        }

    }

}
