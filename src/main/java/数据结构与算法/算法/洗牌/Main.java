package 数据结构与算法.算法.洗牌;

import java.util.Scanner;

/**
 * @Author ifcc
 * @Date 2018-04-19
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] cards = new int[13];
        int n;
        for (int i=0;i<13;i++){
            cards[i]=scanner.nextInt();
        }
        n=scanner.nextInt();
        int[] leftNum = new int[n];
        for (int i=0;i<n;i++){
            leftNum[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            updateCards(cards,leftNum[i]);
        }
        System.out.print(cards[0]);
        for (int i=1;i<cards.length;i++){
            System.out.print(" "+cards[i]);
        }
    }

    private static void updateCards(int[] cards,int leftNum){
        int[] temp = new int[cards.length];
        int tempIndex=cards.length-1;
        int rightIndex=cards.length-1;
        int leftIndex=leftNum-1;
        while (leftIndex>=0&&rightIndex>=leftNum){
            temp[tempIndex--]=cards[leftIndex--];
            temp[tempIndex--]=cards[rightIndex--];
        }
        while (leftIndex>=0){
            temp[tempIndex--]=cards[leftIndex--];
        }
        while (rightIndex>=leftNum){
            temp[tempIndex--]=cards[rightIndex--];
        }

        for (int i=0;i<cards.length;i++){
            cards[i]=temp[i];
        }
    }
}
