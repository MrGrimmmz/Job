package Java基础.浅拷贝与深拷贝;

import java.io.*;

/**
 * @author LIFAN
 * 2019/5/7 16:30
 */
public class DeepCopyBySerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        Age a=new Age(20);
        Student stu1=new Student("摇头耶稣",a,175);
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(stu1);
        oos.flush();
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Student stu2=(Student)ois.readObject();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println();
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }

    /*
     * 创建年龄类
     */
    static class Age implements Serializable{
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
    static class Student implements Serializable{
        //学生类的成员变量（属性）,其中一个属性为类的对象
        private String name;
        private Age aage;
        private int length;
        //构造方法,其中一个参数为另一个类的对象
        public Student(String name,Age a,int length) {
            this.name=name;
            this.aage=a;
            this.length=length;
        }
        //eclipe中alt+shift+s自动添加所有的set和get方法
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
    }
}



