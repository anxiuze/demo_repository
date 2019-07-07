package threadTest;

import lombok.Data;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/7 15:40
 * @description： TODO
 * @modified By：
 * @version:
 */
public class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+"_run_"+i);
        }
    }
}


class TreadDemoTest {
    public static void main(String[] args){
        ThreadDemo t1 = new ThreadDemo("one");
        ThreadDemo t2 = new ThreadDemo("two");

        t1.start();
        t2.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}
