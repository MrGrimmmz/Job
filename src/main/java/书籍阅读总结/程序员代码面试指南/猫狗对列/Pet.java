package 书籍阅读总结.程序员代码面试指南.猫狗对列;

/**
 * 宠物超类
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Pet {
    private String type;
    public Pet(String type){
        this.type=type;
    }
    public String getPetType(){
        return this.type;
    }
}
