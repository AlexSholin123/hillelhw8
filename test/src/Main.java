import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

	int[] ints = {1,2,3,4,5,6,7};
    DataStructure dataStructure = new DataStructure(ints);
    Iterator iterator = dataStructure.iterator();
    while(iterator.hasNext()) {
        System.out.println(iterator.next());
    }


   // dataStructure.printEven();

    }
}
