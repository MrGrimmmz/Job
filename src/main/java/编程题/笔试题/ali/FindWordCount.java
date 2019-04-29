package 编程题.笔试题.ali;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;


/**
 * 使用多线程对file.txt进行英文单词统计，将结果按照出现次数从多到少以“单词,count“形式保存到wordcount.txt文件，每个单词一行
 * 备注：英文单词不区分大小写，最后统一小写字母输出
 */
public class FindWordCount {
    //读取文件
    public static void readTask(int start,int end,String path) throws Exception{
        Map<String,Integer> map = new HashMap<String,Integer>();
        LineNumberReader lr = new LineNumberReader(new FileReader(new File(path)));
        String line=null;
        while((line=lr.readLine())!=null) {
            int num=lr.getLineNumber();
            if(num>=start && num<=end) {
                String[] words = line.split("\\s");
                for (String word : words) {
                    word =word.toLowerCase();
                    if(map.containsKey(word)){
                        Integer n = map.get(word);
                        n++;
                        map.put(word, n);
                    }else{
                        map.put(word, 0);
                    }

                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("result.txt"))));
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        for (Entry<String, Integer> entry : entrySet) {

            bw.write(entry.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        lr.close();
    }

    //合并文件
    public static void combineTask(String path) throws Exception {
        Map<String,Integer> map = new HashMap<String,Integer>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        while((line = br.readLine())!=null) {

            String[] words = line.split("=");
            if(map.containsKey(words[0])){
                Integer count = map.get(words[0]);
                count+=Integer.parseInt(words[1]);
                map.put(words[0], count);
            }else{
                map.put(words[0], 0);
            }
        }


        Comparator<Map.Entry<String,Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };


        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(list, valueComparator);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("wordcount.txt"))));
        for (Entry<String, Integer> entry : list) {

            bw.write(entry.getKey().toString()+","+entry.getValue().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }


    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        // write your code here
        Thread t1=new Thread(new Runnable() {
            public void run() {
                try {
                    readTask(1,15,"file.txt");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            public void run() {
                try {
                    readTask(16,29,"file.txt");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

        Thread t3=new Thread(new Runnable() {
            public void run() {
                try {
                    combineTask("result.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            latch.await();
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
