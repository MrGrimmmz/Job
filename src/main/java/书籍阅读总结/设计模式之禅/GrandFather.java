package 书籍阅读总结.设计模式之禅;

import java.util.*;

/**
 * @Author ifcc
 * @Date 2018-05-29
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class GrandFather {
    public int val=1;
    public int gg=2;
    private static Random random=new Random(47);
    private static  final int val1=random.nextInt(20);

    public GrandFather(int val){}
  /*  @Override
    public String toString() {
        return "grandFather";
    }*/

    public void print(){
        System.out.println("grandFather");
    }

    interface Base{
        int a=0;
        void bb();
    }

    class BB{
        int n=9;

    }

    public void saybb(){
        final GrandFather f=new GrandFather(1);
        new Base(){

            @Override
            public void bb() {
                f.print();
                System.out.println(f.toString());
            }
        }.bb();
        System.out.println("grandFather "+f.toString());
    }

    public static void main(String[] args) throws Exception {

       /* System.out.println(new GrandFather().val1);
        Thread.sleep(2000);
        System.out.println(new GrandFather().val1);
        new GrandFather().saybb();*/
        List<Integer> list = Arrays.asList(12, 13, 15, 16);
        //list.add(23);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            Integer value = entry.getValue();
        }
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        for (int i=0;i<10;i++){
            gai.put(i,i);
        }
        for (int i=0;i<10;i++){
            Integer a=gai.get(i);
            System.out.println(gai.get(i)+" ");
        }
        Integer[] ia = gai.rep();
    }

    public static class GenericArray<T>{
        private Object[] array;
        public GenericArray(int size){
            array=new Object[size];
        }
        public void put(int index,T item){
            array[index]=item;
        }
        @SuppressWarnings("unchecked")
        public T get(int index){
            return (T)array[index];
        }
        @SuppressWarnings("unchecked")
        public T[] rep(){
            return (T[])array;
        }
    }
}


