package org.nhnacademy.tip;

public class Counter {
    //인스턴스를 구분하기 위해 name변수 작성
    String name;
    int count;
    public Counter(String name) {
        this.name = name;
        count = 0;
        //기본 생성자를 정의하지 않으면 0이나 null로 초기화 됨
    }

    public void run() {
        while(!Thread.interrupted()) {
            try {
                ++count;
                //System.out.println(this.getClass().getSimpleName() +": " + count);
                System.out.println(this.name +": " + count);

                Thread.sleep(1000);
            } catch(InterruptedException ignore) {
                //현재 thread가 아니기 때문에 이렇게 작성하지 않으면 에러뜸
                Thread.currentThread().interrupt();
            }
        }
    }
}
