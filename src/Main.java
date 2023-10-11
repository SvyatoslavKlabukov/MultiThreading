import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("Асинхронный привет!");
                    sleep(5000);
                    System.out.println("Асинхронный пока!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        while (true) {
            try {
                sleep(1000);
                System.out.println("Работает основная программа.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}