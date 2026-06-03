
import java.util.HashMap;

class salaoMain {
    public static void main(String[] args) {
        start();
    }
    private static void start() {
        System.out.println("start");
        Mapa m = new Mapa(4);
        m.show();

        int qtaPistoleirosB = 5;
        String gangB = "b";
        m.addPistoleiros(qtaPistoleirosB, gangB);
        m.show();

        int qtaPistoleirosC = 7;
        String gangC = "c";
        m.addPistoleiros(qtaPistoleirosC, gangC);
        m.show();

        System.out.println("");
        System.out.println("end");
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

class Coordenadas{
    private int x;
    private int y;
    
    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void atualizaCoordenadas(int sizeMapa) {
        if (y < sizeMapa-1) {
            y++;
        }else{
            y=0;
            if (x < sizeMapa-1) {
                x++;
            }else{
                x=0;
            }
        }
    }
}

class Mapa {
    private HashMap<Integer, HashMap<Integer, Pistoleiro>> d;
    private int size;
    
    public Mapa(int n) {
        size = n;
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

    public boolean addPistoleiros(int qtaPistoleiros, String g) {
        int qtaPistoleirosAdicionados = 0;
        Coordenadas coord = new Coordenadas(0, 0);
                
        while (qtaPistoleirosAdicionados < qtaPistoleiros) {
            if (addPistoleiro(coord.getX(), coord.getY(), new Pistoleiro(qtaPistoleirosAdicionados+1, g))) {
                qtaPistoleirosAdicionados++;
            }else{
                coord.atualizaCoordenadas(size);
                coord.getX();
                coord.getY();
            }
        }
        //verificar mapa
        return true;
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
