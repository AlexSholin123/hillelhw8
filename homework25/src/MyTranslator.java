import java.util.HashMap;

public class MyTranslator {

    private final HashMap<String, String> dictionary;

    public MyTranslator(HashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void addWords(String eng, String rus) {
        dictionary.put(eng, rus);
    }

    public void translate(String eng) {
        String[] substring = eng.split("\u0020");

        System.out.print("English: ");
        for (String s : substring) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.print("Russian: ");
        for (String s : substring) {
            System.out.print(dictionary.get(s) + " ");
        }
        System.out.println();
    }

}
