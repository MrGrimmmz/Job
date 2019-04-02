package 工具.书籍阅读总结.程序员代码面试指南.猫狗对列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 要求：
 * 用户可以调用add方法将cat类或dog类的实例放入对列中；
 * 用户可以调用pollAll方法，将对列中多有的实例按照对列先后顺序依次弹出
 * 用户可以调用pollDog方法，将对列中dog类的实例按照进队列的先后顺序依次弹出
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
 * 用户可以调用isEmpty方法，检查对列中是否还有dog或者cat的实例
 * 用户可以调用isDogEmpty方法，检查对列中是否还有dog类的实例
 * 用户可以嗲用isCatEmpty方法，检查队列中是否还有cat类的实例
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class DogCatQueue {
    private Queue<PetEnterQueue> dogs;
    private Queue<PetEnterQueue> cats;
    private long count;
    public DogCatQueue(){
        this.cats=new LinkedList<PetEnterQueue>();
        this.dogs=new LinkedList<PetEnterQueue>();
        this.count=0;
    }
    public void add(Pet pet){
        if (pet.getPetType().equals("dog")){
            this.dogs.add(new PetEnterQueue(pet,count++));
        }else if (pet.getPetType().equals("cat")){
            this.cats.add(new PetEnterQueue(pet,count++));
        }else {
            throw new RuntimeException("error,not dog or cat");
        }
    }
    public Pet pollAll(){
        if (!dogs.isEmpty()&&!cats.isEmpty()){
            if (dogs.peek().getCount()<cats.peek().getCount()){
                return dogs.poll().getPet();
            }else {
                return cats.poll().getPet();
            }
        }else if (!dogs.isEmpty()){
            return dogs.poll().getPet();
        }else if (!cats.isEmpty()){
            return cats.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public Dog pollDog(){
        if (!dogs.isEmpty()){
            return (Dog) dogs.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public Cat pollCat(){
        if (!cats.isEmpty()){
            return (Cat) cats.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public boolean isEmpty(){
        return cats.isEmpty()&&dogs.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogs.isEmpty();
    }
    public boolean isCatEmpty(){
        return cats.isEmpty();
    }

}
