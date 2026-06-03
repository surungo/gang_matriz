
import java.util.HashMap;

class salaoMain {
    public static void main(String[] args) {
        start();
    }
    private static void start() {
        System.out.println("start");
        Mapa m = new Mapa(4);
        m.show();

        Pistoleiro p1 = new Pistoleiro(1, "b");
        Pistoleiro p2 = new Pistoleiro(2, "b");
        
        m.addPistoleiro(0, 0, p1);
        m.show();
        m.addPistoleiro(1, 2, p2);
        m.show();

        System.out.println("");
        System.out.println("end");
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
            HashMap<Integer, Pistoleiro> cloneDLinha = new HashMap<>(dlinha);
            d.put(i, cloneDLinha);
        }
    }

    public boolean addPistoleiro(int x, int y, Pistoleiro p) {
        System.out.println("");
        System.out.println("add pistoleiro");

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
