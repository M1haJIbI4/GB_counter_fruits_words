import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] fruits = {"яблоко", "груша", "банан", "апельсин", "киви", "огурцы", "помидоры", "редис"};
        Random random = new Random();

        try (FileWriter writer = new FileWriter("input.txt")) {
            for (int i = 0; i < 100; i++) {
                String randomFruit = fruits[random.nextInt(fruits.length)];
                writer.write(randomFruit + "\n");
            }
            System.out.println("Файл успешно заполнен 100 фруктами и овощами.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}