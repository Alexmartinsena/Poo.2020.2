package ContatoStar;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Agenda agenda = new AgendaPlus();

        agenda.addContato(new ContatoPlus("eva"), Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContato(new ContatoPlus("ana"), Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContato(new ContatoPlus("bia"), Arrays.asList(new Fone("viv", "5454")));
        agenda.addContato(new ContatoPlus("ana"), Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));

        System.out.println(agenda);

        agenda.Favoritos("eva");
        agenda.Favoritos("ana");
        agenda.Favoritos("ana");
        agenda.Favoritos("zac");
        agenda.Favoritos("rex");
        
        System.out.println(agenda);

        for(ContatoPlus favoriteds : agenda.getfavorited()){
            System.out.println(favoriteds);
        }
        
        agenda.rmContact("zac");
        System.out.println(agenda);

        for(ContatoPlus favoriteds : agenda.getfavorited()){
            System.out.println(favoriteds);
        }

        agenda.NaoFavoritos("ana");
        for(ContatoPlus favoriteds : agenda.getfavorited()){
            System.out.println(favoriteds);
        }
        
        System.out.println(agenda);

    
    }
}
