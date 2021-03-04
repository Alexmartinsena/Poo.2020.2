package ContatoStar;

import java.util.*;

class Contato {
    public String name;
    public ArrayList<Fone> fones = new ArrayList<>();

    public Contato(String name) {
        this.name = name;
    }

    public String toString() {
        String out = "";
        out += name;
        for (int i = 0; i < fones.size(); i++) {
            out += "[" + i + ":" + fones.get(i).id + ":" + fones.get(i).number + "]";
        }
        return out;
    }

}
