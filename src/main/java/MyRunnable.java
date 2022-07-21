public class MyRunnable  extends  Thread{

    public static int counter = 1;
    public static int turn = 0;
    public static Object lock = new Object();

    @Override
    public void run() {
        while (counter <= 10) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " " + counter);
                try {
                    Thread.sleep(1000);
                    counter++;
                    lock.notifyAll();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread threadA = new Thread(new MyRunnable());
        Thread threadB = new Thread(new MyRunnable ());
        Thread threadC = new Thread( () -> {
            while (counter <= 10) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + counter);
                    try {
                        Thread.sleep(1000);
                        counter++;
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
