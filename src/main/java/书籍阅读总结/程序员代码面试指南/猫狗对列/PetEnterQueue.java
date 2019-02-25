package 书籍阅读总结.程序员代码面试指南.猫狗对列;

/**
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class PetEnterQueue {
    private Pet pet;
    private long count;
    public PetEnterQueue(Pet pet,long count){
        this.pet=pet;
        this.count=count;
    }
    public long getCount(){
        return this.count;
    }
    public Pet getPet(){
        return this.pet;
    }
    public String getEnterPetType(){
        return this.pet.getPetType();
    }


}
