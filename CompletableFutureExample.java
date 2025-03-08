import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        int list[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        CompletableFuture<Integer> sum = CompletableFuture.supplyAsync(() -> calculateSum(list));
        CompletableFuture<Integer> square = sum.thenApplyAsync(result -> result * result);
        CompletableFuture<Void> print = square.thenAcceptAsync(result -> System.out.println(result));

        System.out.println("ttttttttttttt");
        print.join();
    }

    public static int calculateSum(int list[]) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum = sum + list[i];
        }
        try {
            Thread.sleep(9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
}
