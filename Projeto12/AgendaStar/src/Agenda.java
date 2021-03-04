package ContatoStar;

import java.util.*;

public class Agenda {

    static TreeMap<String, Contato> contatos;

    public Agenda(){
        contatos = new TreeMap<>();
    }

    private TreeMap<String, Contato> getContatos() {
        return contatos;
    }

    public void addContato(ContatoPlus contato, List<Fone> fones) {
        if(contatos.get(contato.name) == null || contatos.isEmpty()) {
            contatos.put(contato.name, new ContatoPlus(contato.name));
            for(int i = 0; i < fones.size(); i++) {
                if(Fone.validar(fones.get(i).number))
                    contatos.get(contato.name).fones.add(fones.get(i));
            }
            return;
        }
        if(contatos.get(contato.name).name.equals(contato.name)) {
            for(int i = 0; i < fones.size(); i++) {
                contatos.get(contato.name).fones.add(fones.get(i));
            }
            return;
        }
        contatos.put(contato.name, new ContatoPlus(contato.name));
        for(int i = 0; i < fones.size(); i++) {
            contatos.get(contato.name).fones.add(fones.get(i));
        }
    }
    
    public void rmContact(String name) {
        if(contatos.get(name) == null) {
            System.out.println("Fail: O contato nao existe \n");
            return;
        }
        contatos.remove(name);
        System.out.println("O contato foi removido \n");
    }

    public void rmFone(String name, int index) {

        int size = contatos.get(name).fones.size();

        if(index > size || index < 0) {
            System.out.println("Fail: O numero não foi encontrado \n");
            return;
        }
        contatos.get(name).fones.remove(index);
        System.out.println("O numero foi removido \n"); 
    }



    public TreeMap<String, Contato> search(String caracteres) {

        TreeMap<String, Contato> FiltraContatos = new TreeMap<>();

        for(Contato contato : contatos.values()) {
            if(contato.name.contains(caracteres)) {
                FiltraContatos.put(contato.name, contato);
            }
            else{
                for(int i = 0; i < contato.fones.size(); i++)
                    if(contato.fones.get(i).number.contains(caracteres))
                        FiltraContatos.put(contato.name, contato);
            }
        }

        if(!FiltraContatos.isEmpty())
            return FiltraContatos;
        System.out.println("Fail: Nenhum valor foi encontrado");
        return contatos;
    }

    public void Favoritos(String name) {
        if(getContatos().containsKey(name)) {
            AgendaPlus.Favoritar(name);
        }
    }

    public void NaoFavoritos(String name) {
        if(getContatos().containsKey(name)) {
            AgendaPlus.Desfavoritar(name);
        }
    }

    public Collection<ContatoPlus> getfavorited() {
        TreeMap<String, ContatoPlus> favoriteds = new TreeMap<>();
        for(Contato contact : contatos.values()) {
            if(contact instanceof ContatoPlus) {
                ContatoPlus contatoPlus = (ContatoPlus) contact;
                if(contatoPlus.favorited == true)
                    favoriteds.put(contatoPlus.name, contatoPlus);
            }
        }
        return favoriteds.values();
    }

    public String toString() {
        String out = "";
        for(Contato contato : contatos.values()) {
            out += contato + "\n";
        }
        return out;
    }
}
