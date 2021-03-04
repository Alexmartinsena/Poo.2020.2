package ContatoStar;

class Fone {
    public String id;
    public String number;

    public Fone(String id, String number) {
        this.id = id;    
        this.number = number;     
    }
    
    public String toString() {
        return id + ":" + number;
    }

    public static boolean validar(String fone) {
        String validos = "0123456789().-";
        for (int i = 0; i < fone.length(); i++) {
            char c = fone.charAt(i);
            if (validos.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

}
