import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();

        MyTranslator myTranslator = new MyTranslator(hashMap);

        myTranslator.addWords("Dog", "Собака");
        myTranslator.addWords("Cat", "Кот");
        myTranslator.addWords("Monkey", "Обезьяна");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the words: ");
        String s = scanner.nextLine();

            if (hashMap.containsKey(s)) {
                myTranslator.translate(s);
            } else {
                System.out.println("Sorry. There is no such word in the dictionary. Choose from Dog, Cat or Monkey.");
        }
    }

}

