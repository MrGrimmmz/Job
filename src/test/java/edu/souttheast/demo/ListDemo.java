package edu.souttheast.demo;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: ListDemo
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/22 10:28
 * Description:
 */
public class ListDemo {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception {
        Object[] s=new String[3];
        Field field = ListDemo.class.getDeclaredField("list");
        System.out.println(field.getType());
        Type genericType = field.getGenericType();
        System.out.println(genericType);
        ArrayList strings = new ArrayList<Integer>();
        //System.out.println(((ParameterizedType)((Type)strings.getClass())).getActualTypeArguments()[0]);
        strings.add("fd");
        System.out.println(strings);
        System.out.println(ListDemo.class.getGenericSuperclass());
        /*Integer[] integers = new Integer[2];
        Object[] objects=integers;
        objects[1]="dd";*/
        List<?>[] lists = new List<?>[2];
        lists[0]=new ArrayList<String>();
        List<String> list = (List<String>) lists[0];

       /* Integer[] obj = (Integer[])new Object[2];
        obj[0]=1;*/
        Test test = new Test();
        Test t = test.getT();
        List<? super Number> list1 = new ArrayList<Object>();
        list1.add(12.33);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        List<? extends Number> list3 = list2;
        list2.add(1);
        list2.add(2);
        System.out.println(list3.get(0));
        ArrayList<?> str=new ArrayList<String>();
        ArrayList<String> sss=(ArrayList<String>) str;
        //System.out.println(Arrays.toString(sss.getClass().getTypeParameters()));
    }

    public <T> void add(List<T> list){}

    public void delete(List<?> list){
        add(list);
    }

    static class Test{
        static Test t = new Test();
        Test getT(){
            return t;
        }
    }

}
