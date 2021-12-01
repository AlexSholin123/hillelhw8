import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемое количество цветов в букете 2,3,4.....");
        int flower = scanner.nextInt();
        bouquetPrice(flower);

    }

    public static void bouquetPrice(int amount) {
        System.out.println("Сформирован букет из " + amount + " цветов");
        int priceBouquet = 0;
        for (int i = 1; i <= amount; i++) {
            Flower flower = getRandomFlower();
            assert flower != null;
            System.out.println("#" + i + " " + flower.getName() + " (" + flower.getCost() + ")");
            priceBouquet += flower.getCost();

        }
        System.out.println("Стоимость букета " + priceBouquet);

    }

    public static Flower getRandomFlower() {
        int random = (int) (Math.random() * 3) + 1;
        switch (random) {
            case 1:
                return new Rose("Роза", 45);
            case 2:
                return new Tulip("Тюльпан", 20);
            case 3:
                return new Chamomile("Ромашка", 15);
            default:
                return null;
        }

    }

}
