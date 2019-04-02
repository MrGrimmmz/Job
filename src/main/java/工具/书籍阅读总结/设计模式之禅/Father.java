package 工具.书籍阅读总结.设计模式之禅;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author ifcc
 * @Date 2018-05-21
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Father extends GrandFather{
    public int val=2;
    public void printVal(){
        System.out.println(super.getClass()+" "+this.getClass());
    }
    protected Father invoke(Son son){
        return new Father();
    }
    public static void add(){
        System.out.println("father static");
    }

  public Father(){
        super(1);
  }


    public void print(){
        System.out.println(super.toString());
        System.out.println(this.toString());
        System.out.println(super.getClass());
        System.out.println(this.getClass());
    }

    @Override
    public String toString(){
        return "father";
    }


    public static void main(String[] args){
      GrandFather grandFather= new Father();
        //grandFather.print();
        //Pattern.compile("//w+").matcher("rr").replaceAll("");
        Object[] str={1,2,3};
        System.out.println(Father.class.isAssignableFrom(GrandFather.class));
        System.out.println(Father.class.isAssignableFrom(Son.class));
    }
}

