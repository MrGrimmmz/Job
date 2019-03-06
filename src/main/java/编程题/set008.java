package 编程题;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * @author LIFAN
 * 2019/3/1 20:36
 */
public class set008 {
    public void set() {
        Set<String> set = new HashSet<String>();
        set.add("1");// 添加元素
        set.add("2");
        set.remove("1");//移除元素
        set.contains("2");//判断是否包含元素
        set.equals("2");//判断是否有与2相等的元素
        set.size();//获取set的尺寸
        set.isEmpty();//判断是否为空，为空-false
        set.hashCode();
        set.toArray();//转换为数组
        // Iterator迭代遍历
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // for增强遍历
        for (String st : set) {
            System.out.println(st);
        }
        // TreeSet默认排序
        Set<String> se = new TreeSet<String>();
        se.add("f");
        se.add("a");
        se.add("b");
        se.add("c");
        se.add("d");
        se.add("e");
        System.out.println(se);
    }

    // 倒序输出
    public void dxSort() {
        Set<String> set = new TreeSet<String>(new MyComparator());
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.add("A");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            System.out.print(iterator.next() + " ");
        }
    }

    // 定义新实例
    public void newSet() {
        Set<Person> set = new TreeSet<Person>(new PersonComparator());
        Person p1 = new Person(10);
        Person p2 = new Person(20);
        Person p3 = new Person(30);
        Person p4 = new Person(40);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        for (Iterator<Person> iterator = set.iterator(); iterator.hasNext();) {
            System.out.print(iterator.next().score + " ");
        }
    }
    public static void main(String args[]) {
        set008 set8 = new set008();
        set8.set();
        set8.dxSort();
        set8.newSet();
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);// 降序排列
    }
}

class Person {
    int score;

     public Person(int score) {
        this.score = score;
    }

    public String toString() {
        return String.valueOf(this.score);
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.score - o2.score;//升序排列
    }
}
