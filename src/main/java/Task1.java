import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {

        // 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> list = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1, 1_000_000))
                .limit(1000)
                .toList();

        list.forEach(System.out::println);

        // 1.1 Найти максимальное
        int max = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Максимальное число списка: " + max);

        // 1.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        long sum = list.stream()
                .filter(it -> it > 500_000)
                .mapToLong(it -> it * 5L - 150)
                .reduce(0, Long::sum);
        System.out.println("Искомая сумма: " + sum);

        // 1.3 Найти количество чисел, квадрат которых меньше, чем 100_000
        long count = list.stream()
                .mapToLong(it -> (long) it * it)
                .filter(it -> it < 100_000)
                .count();
        System.out.println("Искомое количество: " + count);
    }

}
