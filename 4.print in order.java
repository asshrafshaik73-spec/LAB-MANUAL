import java.util.concurrent.CountDownLatch;

class Foo {

    private CountDownLatch firstDone;
    private CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();

        // Signal that first() has finished.
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() finishes.
        firstDone.await();

        // printSecond.run() outputs "second".
        printSecond.run();

        // Signal that second() has finished.
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() finishes.
        secondDone.await();

        // printThird.run() outputs "third".
        printThird.run();
    }
}
