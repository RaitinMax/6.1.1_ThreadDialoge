public class MyThread extends Thread {

    public String name;



    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println(String.format(" %s. Hello there!", Thread.currentThread().getName()));
                sleep(300);
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s has been finished\n", Thread.currentThread().getName());
        }
    }
}