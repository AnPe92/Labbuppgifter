package uppgift4;

class Counter{

    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }
}

class PrimeChecker implements Runnable{

    long start;
    long end;
    Counter count;


    public PrimeChecker(long start, long end, Counter c) {
        this.start = start;
        this.end = end;
        this.count = c;
    }

    @Override
    public void run() {

        for(long i = start; i <= end; i++){

            boolean prime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                count.increment();
        }
    }
}

public class Main{
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter(0);

        Thread thread1 = new Thread(new PrimeChecker(1,100000, counter));
        Thread thread2 = new Thread(new PrimeChecker(100001,200000, counter));
        Thread thread3 = new Thread(new PrimeChecker(200001,300000, counter));
        Thread thread4 = new Thread(new PrimeChecker(300001,400000, counter));
        Thread thread5 = new Thread(new PrimeChecker(400001,500000, counter));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();


        System.out.println(counter.getCount() - 1);

    }
}