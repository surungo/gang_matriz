import java.util.HashMap;

class salao{
    public static void main(String[] args) {
        int n = 4;
        int b = 4;
        int c = 4;
        int x = 0;
        int y = 0;
        int z = 0;
        HashMap<Integer,HashMap<Integer,String>> m1 = new HashMap<>();
        for(int i=0;i<n;i++){
            m1.put(i,new HashMap<>()); 
        }
        HashMap<Integer,HashMap<Integer,String>> m2 = new HashMap<>();
        for(int i=0;i<n;i++){
            m2.put(i,new HashMap<>()); 
        }
        String g="b";
        int retorno = possibilidade(n,b,c,g,x,y,z,m1,m2);
        System.out.println("retorno: "+retorno);
    }
   
    private static int possibilidade(int n, int b, int c, String g, int x, int y,int z,
        HashMap<Integer,HashMap<Integer,String>> m1,
        HashMap<Integer,HashMap<Integer,String>> m2
    ) {
       if(m1.get(x).get(y)!=g && !m1.get(x).containsValue(g)&& !m2.get(x).containsValue(g)){
        m1.get(x).put(y,g);
        m2.get(y).put(x,g);
        z++;
       }

       if(x+1 >= n && y+1 >= n) {
        return z;
       }
       
       if(x+1 >= n){
        x=-1;
        y++;
       }
       x++;
       return possibilidade(n,b,c,g,x,y,z,m1,m2);
    }

}