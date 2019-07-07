package threadTest;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/7 16:38
 * @description： 卖票小程序。
 * @modified By：
 * @version:
 */
public class Ticket implements Runnable{

    private Integer num = 200;

    @Override
    public void run() {
        while (num > 0){
            System.out.println(Thread.currentThread().getName()+"卖出NO."+num--);
        }
    }
}

class TicketDemo{

    /**
     * 创建线程的两种不同方式在启动线程时方式不一样。
     * 1.继承Thread类，直接new多个Thread对象，调用start方法即可；
     * 2.实现Runnable接口则需要在创建Thread时，将实现Runnable接口的类的对象作为参数传入到Thread对象中，
     *   然后调用start方法启动线程；
     *
     * 好处：1.避免了单继承的局限性；
     *      2.多个线程可共享一份资源。若卖票程序中，4个线程一共卖掉200张票，不会是每个线程各卖200张。
     * */
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
