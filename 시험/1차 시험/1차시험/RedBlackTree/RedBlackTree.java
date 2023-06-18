package RedBlackTree;

import java.util.TreeSet;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RedBlackTree {

    //정수 합 메소드
    public static void getSum(TreeSet tree) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts = tree;
        int total = 0;
        for(int num: ts) {
            total += num; 
        }
        System.out.println("정수들의 합:" + total);

    }

    public static void main(String[] args) {
        Random random = new Random();
        TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        int total = 0; 


        for(int i=0; i<30; i++) {
            int rnum = random.nextInt();
            System.out.println("정수"+(i+1)+":"+ rnum);
            ts.add(rnum);
        }

        //내림차순 출력
        System.out.println("------ 정렬된 노드 -------");
        for(int num: ts){
            System.out.println(num);
        }

        //삽입 정수의 합
        getSum(ts);
        
            
    }
    
}
