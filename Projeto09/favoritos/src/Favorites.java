import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Phones{
    
    public String id;
    public String number;
    
    public Phones(String id, String number){
        this.id = id;
        this.number = number;
    }
    
    public String toString(){
        return id + ":" + number;
    }
    
    public boolean validar(String number){
        String validos = "0123456789().-";
        for(int i = 0; i < number.length();i++){
            char c = number.charAt(i);
            if(validos.indexOf(c) == -1){
                return false;
            }
        }
        return true;
    }    
}

class Contact{
    private String name;
    private ArrayList<Phones> Phoness  = new ArrayList<>();
    public boolean favorited;
    
    public Contact(String name){
        this.name = name;
        this.favorited = false;
    }
    
    public boolean addPhones(String id, String number){
        Phones Phones = new Phones(id, number);
        if(Phones.validar(number)){
            Phoness.add(new Phones(id, number));
            return true;
        }
        else{
            System.out.println("fail: Phones invalido");
        }
        return false;
    }
    
    public void rmPhones(int indice){
        for(int i = 0; i < Phoness.size(); i++){
            Phones Phones = Phoness.get(i);
            if(i == indice){
                Phoness.remove(Phoness.get(i));
            }
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setFavorited(boolean favorito){
        this.favorited = favorito;
    }
    
    public boolean isFavorited(){
        return this.favorited;
    }
    
    @Override
    public String toString(){
        String out =  "";
        if(isFavorited()){
            out += "@ " + this.name;
        }
        else{
            out += "- " + this.name;
        }
        if(Phoness.size() > 0)
            out += " ";
        for(int i = 0; i < Phoness.size(); i++){
            Phones Phones = Phoness.get(i);
            out += "[" + i + ":"+ Phones + "]";
        }
        return out;
    }
}

class Schedule03{
    
    TreeMap<String, Contact> Contact;
    TreeMap<String, Contact> favoritos;
    
    public Schedule03(){
        Contact = new TreeMap<>();
        favoritos = new TreeMap<>();
    }
    
    Contact getContact(String name) {
        for(Contact cont: Contact.values()){
            if(cont.getName().equals(name)){
                return cont;
            }
        }
        return null;
    }

    public boolean initContact(String nome){
        Contact cont = getContact(nome);
        if(cont != null) return false;
        Contact.put(nome, new Contact(nome));
        return true;
    }
    
    public void addContact(String name, String id, String number){
        Contact cont = getContact(name);
        if(cont == null){
            cont = new Contact(name);
            cont.addPhones(id, number);
        }
        else if(cont != null){
            cont.addPhones(id, number);    
        }
        
    }
    
    public boolean rmContact(String name){
        Contact cont = getContact(name);
        if(cont == null){
            return false;
        }
        if(cont.isFavorited())
            favoritos.remove(name);
        Contact.remove(name);
        return true;
    }
    
    public void rmPhonesindice(String name, int indice){
        Contact Contacts = getContact(name);
        if(Contacts != null)
            Contacts.rmPhones(indice);
    }
    
    public void search(String label){
        
        ArrayList<Contact> pesquisa = new ArrayList<>();
        
        for(Contact cont : Contact.values()){
            if(cont.toString().indexOf(label) != -1)
                pesquisa.add(cont);
        }
        
        for(int i = 0; i < pesquisa.size(); i++){
            System.out.println(pesquisa.get(i));
        }   
    }
    
    public void favoritar(String id){
        Contact cont = getContact(id);
        if(cont == null)
            return;
        if(cont.isFavorited())
            return;
        cont.setFavorited(true);
        favoritos.put(id, cont);
    }
    
    
    public void desfavoritar(String id){
        Contact cont = getContact(id);
        if(cont == null)
            return;
        if(!cont.isFavorited())
            return;
        cont.setFavorited(false);
        favoritos.remove(id);
    }
    
    public void favorited(){
        for(Contact cont: favoritos.values()){
            System.out.println(cont);
        }
    }
    
    public ArrayList<Contact> getContacts(){
        return (ArrayList<Contact>) Contact.values();
    }
    
    
    public void show(){
        for(Contact cont : Contact.values()){
            System.out.println(cont);
        }
    }
    
}
 
public class Favorites{
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        Schedule03 Schedule = new Schedule03();
        
        while(true){
            
            String line = scan.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            
            if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("add")){
                Schedule.initContact(ui[1]);
                
                for(int i = 2; i < ui.length; i++){
                    String partes[] = ui[i].split(":");
                    Schedule.addContact(ui[1], partes[0], partes[1]);
                }
            
            }
            else if(ui[0].equals("Schedule")){ 
                Schedule.show();
                
            }
            else if(ui[0].equals("rmContact")){ 
                Schedule.rmContact(ui[1]);
                
            }
            else if(ui[0].equals("rmPhones")){ 
                Schedule.rmPhonesindice(ui[1], Integer.parseInt(ui[2]));
                
            }
            else if(ui[0].equals("search")){ 
                Schedule.search(ui[1]);
                
            }
            else if(ui[0].equals("fav")){ 
                Schedule.favoritar(ui[1]);
                
            }
            else if(ui[0].equals("favorited")){ 
                Schedule.favorited();
                
            }
            else if(ui[0].equals("unfav")){ 
                Schedule.desfavoritar(ui[1]);
                
            }
            else{
                System.out.println("fail: comando inválido");
            }           
        }
        scan.close();
    }
}
