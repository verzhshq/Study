package ThreadDemo;

public class MyThread extends Thread {
    private int threadSize = 0;

    @Override
    public void run() {
        // 重写run方法
        System.out.println("wtf man?" + threadSize);
        threadSize++;
    }

}
