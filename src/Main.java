import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        ThreadGroup group = new ThreadGroup("group");
        System.out.println("Start creating threads:");
        MyThread task = new MyThread();
        int size = 4;
        Thread[] threadsArray = createThreadArray(size, group, task);
        startThread(threadsArray);
        Thread.sleep(10000);
        stopGroupThread(group);
    }

    public static Thread[] createThreadArray(int size, ThreadGroup group, MyThread thread) {
        Thread[] newThreadArray = new Thread[size];
        for (int i = 0; i < size; i++) {
            newThreadArray[i] = new Thread(group, thread, String.format("thread # %d", i+1));
        }
        return newThreadArray;
    }

    public static void startThread(Thread[] thread) {
        for (int i = 0; i < thread.length; i++) {
            thread[i].start();
        }
    }

    public static void stopGroupThread(ThreadGroup group) {
        System.out.println("Interrupt all threads");
        group.interrupt();
    }
}
