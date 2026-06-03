
import java.util.HashMap;

class salaoMain {
    public static void main(String[] args) {
        start();
    }
    private static void start() {
        System.out.println("start");
        Mapa m = new Mapa(4);
        m.show();
        System.out.println("");
        System.out.println("add pistoleiro");
        Pistoleiro p1 = new Pistoleiro(1, "b");
        m.addPistoleiro(0, 0, p1);
        m.show();
    }
}

class Pistoleiro {
    int id;
    String g;

    public Pistoleiro(int id, String g) {
        this.id = id;
        this.g = g;
    }

    public int getId() {
        return id;
    }
    public String getG() {
        return g;
    }
}

class Mapa {
    private HashMap<Integer, HashMap<Integer, Pistoleiro>> d;

    public Mapa(int n) {
        HashMap<Integer, Pistoleiro> dlinha = new HashMap<Integer, Pistoleiro>();
        Pistoleiro pzero = new Pistoleiro(0, ".");
        //monta linha
        for (int i = 0; i < n; i++) {
            dlinha.put(i, pzero);
        }
        //monta mapa
        d = new HashMap<Integer, HashMap<Integer, Pistoleiro>>();
        for (int i = 0; i < n; i++) {
            d.put(i, dlinha);
        }
    }

    public boolean addPistoleiro(int x, int y, Pistoleiro p) {
        if (d.get(x).get(y).getId() == 0) {
            d.get(x).put(y, p);
            return true;
        }
        return false;
    }

    public void show() {
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < d.get(i).size(); j++) {
                System.out.print(d.get(i).get(j).getG());
            }
            System.out.println("");
        }
    }
}
