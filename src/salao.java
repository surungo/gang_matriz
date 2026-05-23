import java.util.ArrayList;
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
        HashMap<Integer,ArrayList<String>> d = new HashMap<>();
        int inicio = (n-1)*-1; //3
        int fim = ((n*3)-2); //10
        
        for(int i=inicio;i<fim;i++){
            d.put(i,new ArrayList<>()); 
        }
        
        String g="b";
        int retorno = possibilidade(n,b,c,g,x,y,z,m1,m2,d);

        System.out.println("m1: " + m1);
        System.out.println("m2: " + m2);
        System.out.println("d: " + d);
        System.out.println("retorno: " + retorno);
    }
   
    private static int possibilidade(int n, int b, int c, String g, int x, int y,int z,
        HashMap<Integer,HashMap<Integer,String>> m1,
        HashMap<Integer,HashMap<Integer,String>> m2,
        HashMap<Integer,ArrayList<String>> d
    ) {
       int d1 = y-x;
       int d2 = y-x+((2*n)-1); 
       if(m1.get(x).get(y)!=g && 
       !m1.get(x).containsValue(g) && 
       !m2.get(y).containsValue(g) &&
       !d.get(d1).contains(g) && 
       !d.get(d2).contains(g)
    ){
        m1.get(x).put(y,g);
        m2.get(y).put(x,g);
        d.get(d1).add(g);
        d.get(d2).add(g);
                
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
       return possibilidade(n,b,c,g,x,y,z,m1,m2,d);
    }

}