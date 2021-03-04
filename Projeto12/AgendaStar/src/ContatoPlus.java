package ContatoStar;

class ContatoPlus extends Contato {
    public boolean favorited;

    public ContatoPlus(String name) {
        super(name);
        favorited = false;
    }

    @Override
    public String toString() {
        String out = "";
        if(favorited == true)
            out += "@ " + name;
        else
            out += "- " + name;
        
        for (int i = 0; i < fones.size(); i++) {
            out += " [" + i + ":" + fones.get(i).id + ":" + fones.get(i).number + "]";
        }
        
        return out;
    }
}
