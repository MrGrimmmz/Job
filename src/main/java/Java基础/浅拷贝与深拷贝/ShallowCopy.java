package Java基础.浅拷贝与深拷贝;

/**
 * @author LIFAN
 * 2019/5/7 14:50
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Age a=new Age(20);
        Student stu1=new Student("摇头耶稣",a,175);

        //通过调用重写后的clone方法进行浅拷贝
        Student stu2=(Student)stu1.clone();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());

        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        //stu1.setaAge(new Age(99));//使用这种方式修改age属性值的话，stu2是不会跟着改变的。
        // 因为创建了一个新的Age类对象而不是改变原对象的实例值

        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        //基本数据类型是值传递，所以修改值后不会影响另一个对象的该属性值；
        //
        //引用数据类型是地址传递（引用传递），所以修改值后另一个对象的该属性值会同步被修改。
        //
        //String类型非常特殊，所以我额外设置了一个字符串类型的成员变量来进行说明。
        // 首先，String类型属于引用数据类型，不属于基本数据类型，
        // 但是String类型的数据是存放在常量池中的，也就是无法修改的！
        // 也就是说，当我将name属性从“摇头耶稣”改为“大傻子"后，并不是修改了这个数据的值，
        // 而是把这个数据的引用从指向”摇头耶稣“这个常量改为了指向”大傻子“这个常量。
        // 在这种情况下，另一个对象的name属性值仍然指向”摇头耶稣“不会受到影响。

    }
}

/*
 * 创建年龄类
 */
class Age{
    //年龄类的成员变量（属性）
    private int age;
    //构造方法
    public Age(int age) {
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.age+"";
    }
}
/*
 * 创建学生类
 */
class Student implements Cloneable{
    //学生类的成员变量（属性）,其中一个属性为类的对象
    //基本数据类型的成员变量length，引用数据类型的成员变量aage和字符串String类型的name.
    private String name;
    private Age aage;
    private int length;
    //构造方法,其中一个参数为另一个类的对象
    public Student(String name,Age a,int length) {
        this.name=name;
        this.aage=a;
        this.length=length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getaAge() {
        return this.aage;
    }

    public void setaAge(Age age) {
        this.aage=age;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length=length;
    }

    //设置输出的字符串形式
    public String toString() {
        return "姓名是： "+this.getName()+"， 年龄为： "+this.getaAge().toString()+", 长度是： "+this.getLength();
    }

    //重写Object类的clone方法
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法，返回一个Object实例
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
