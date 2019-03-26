package 编程题;

/**
 * @author LIFAN
 * 2019/3/1 20:50
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/***
 * 集合类（List-LinkedList/ArrayList/Vector,Set,Map-HashTable/Map）
 *
 */
public class collect004 {

    public void map() {
        Map map = new HashMap();
        map.put("key1", "lisi1");
        map.put("key2", "lisi2");
        // 先获取map集合的所有键的set集合，keyset（）
        Iterator it = map.keySet().iterator();
        // 获取迭代器
        // 第一种遍历Iterator-keySet
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println(map.get(key));
        }
        // 第二种遍历(推荐，效率高)-entrySet
        // 将map集合中的映射关系取出，存入到set集合
        Iterator it1 = map.entrySet().iterator();// 创建迭代对象
        while (it1.hasNext()) {// hasNext判断是否还有下一个元素
            Entry e = (Entry) it1.next();
            System.out.println("键" + e.getKey() + "的值为" + e.getValue());
        }
        // foreach遍历方式-keySet
        Map<String, Integer> ma = new HashMap<String, Integer>();
        ma.put("二阳", 23);
        ma.put("二峥", 24);
        Set<String> keys = ma.keySet(); // 把键其中起来,存入到set集合中.
        for (String key : keys) { // 遍历键集合，获取每一个键
            Integer value = ma.get(key); // 让键去找值 get(Object key)
            System.out.println(key + "***" + value);
        }
        // entrySet
        Set<Map.Entry<String, Integer>> set = ma.entrySet();
        for (Map.Entry<String, Integer> me : set) { // 遍历键值对集合，获取到每一个键值对。增强for，迭代器
            String key = me.getKey(); // 通过键值对获取键getKey()
            Integer value = me.getValue(); // 通过键值对获取值getValue()
            System.out.println(key + "***" + value);
        }
    }

    public void List() {
        List<String> strList = new ArrayList<String>();// 动态数组-get/set快
        List<String> linkList = new LinkedList<String>();// 链表-插入/删除快
        //ArrayList<String> ast=new ArrayList<>();
        //LinkedList<String> list=new LinkedList<>();
        linkList.add("2");
        linkList.add("1");
        linkList.add("1");
        strList.add("1");// 添加元素
        strList.add("2");
        strList.toString();// 转换字符串
        strList.size();// 获取长度
        strList.get(0);// 获取索引为0的值
        strList.remove(0);// 移除索引为0的值
        Collections.sort(linkList);// 排序
        removeDuplicate(linkList);// 去重
        strList.contains("1");// 判断是否包含1
        strList.set(0, "1");// 替换索引为0的值
        strList.add(1, "2");// 添加索引为1的值
        strList.indexOf("1");// 获取第一个出现1的索引位置
        strList.lastIndexOf("2");// 获取最后一个出现2的索引位置
        strList.subList(0, 1);// 截取0<=index<1的值作为新的List
        // equals值比较相等，hashcode相等的对象就不一定是相等的对象
        strList.isEmpty();// 空为true,非空为false
        strList.iterator();// 返回iterator集合对象
        // for循环方式遍历
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }
        // foreach遍历list
        for (String obj : strList) {
            System.out.println(obj);
        }
        for (String obj : linkList) {
            System.out.println(obj);
        }
        // Iterator接口迭代遍历
        Iterator<String> it = strList.iterator();
        while (it.hasNext()) {
            String obj = it.next();
            System.out.println(obj);
        }
        // List转换为数组
        // 第一种for循环转换
        String string[] = new String[strList.size()];
        for (int i = 0, j = strList.size(); i < j; i++) {
            string[i] = strList.get(i);
        }
        // 第二种调用toArray函数转换
        String[] strings = new String[strList.size()];
        strList.toArray(strings);
        for (String str : strings) {
            System.out.println(str);
        }
        // 数组转换为List
        String[] s = { "a", "b", "c" };
        List<String> list = new ArrayList<String>(Arrays.asList(s));
        for (String st : list) {
            System.out.println(st);
        }
    }

    // 利用HashSet特性去重
    public static void removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        System.out.println(list);
    }

    // 前者与后者比较去重
    public static void removeDuplicate1(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list);
    }

    public void list1() {
        String a = "A", b = "B", c = "C", d = "D", e = "E";// 定义要插入集合的字符串对象
        List<String> list = new LinkedList<String>();// 创建List集合
        list.add(a);// 向集合中添加元素
        list.add(b);
        list.add(c);
        Iterator<String> iter = list.iterator();// 创建集合的迭代器
        System.out.println("修改后 前集合 中的元素是：");
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        list.set(0, e);// 将索引位置为0的对象修改为对象e
        list.set(2, d);// 将索引位置为2的对象修改为对象d
        Iterator<String> it = list.iterator();// 创建将集合对象修改后的迭代器对象
        System.out.println();
        System.out.println("修改后的集合中的元素是：");
        while (it.hasNext()) {// 循环获取集合中的元素
            System.out.print(it.next() + " ");
        }
        List list1 = new ArrayList();// 创建集合对象
        int i = (int) (Math.random() * (list.size() - 1));// 获得0-2之间的随机数
        list1.add("a");// 向集合中添加元素
        list1.add("b");
        list1.add("c");
        System.out.println("随机获取数组中的元素：" + list1.get(i));//
        list1.remove(2);// 将指定索引位置的元素从集合中移除
        System.out.println("将索引是'2'的元素从数组中移除后，数组中的元素是：");
        for (int j = 0; j < list1.size(); j++) {// 循环遍历数组
            System.out.print(list1.get(j) + " ");
        }
    }

    public static void main(String args[]) {
        collect004 c1 = new collect004();
        c1.map();
        c1.List();
        c1.list1();
        // 冒泡排序
        /***
         * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
         * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
         */
        int[] a = { 1, 3, 2 };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int k : a) {
            System.out.println(k);
        }
        int arr[] = { 23, 12, 6 };
        // 冒泡排序(比较相邻的两个元素，大的往后排，小的往前移动，第一层循环避免漏排，第二层循环比较排序)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        for (int k : arr) {
            System.out.println(k);
        }
        /***
         * 选择排序-比较第一个与第二个，以此类推，大的往后移，小的往前移 冒泡排序-相邻的比较，大的往后移，小的往前移
         * 快速排序-选择第一个或最后一个元素作为基准元素， 第一趟扫描分为两部分（一部分为比基准元素小的，一部分比基准元素大的），然后分别递归排序
         * 插入排序-选择一个记录元素，比较后排序插入新的数组
         */
        //插入排序
        int brr[] = {2, 3, 1, 5};
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < brr.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = brr[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < brr[j]) {
                brr[j + 1] = brr[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            brr[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
        for (int k : brr) {
            System.out.println(k);
        }
    }
}

