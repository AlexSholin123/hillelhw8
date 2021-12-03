import java.util.*;

public class DataStructure {
    private final int[] arrayOfInts;

    public DataStructure(int[] arrayOfInts) {
        this.arrayOfInts = arrayOfInts;
    }


    interface ArrayIterator extends Iterator<Integer> {

    }

    private class EvenIterator implements ArrayIterator {

        public EvenIterator() {
        }

        public EvenIterator(int cursor) {
            this.cursor = cursor;
        }

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < arrayOfInts.length;
        }

        @Override
        public Integer next() {
            int res = arrayOfInts[cursor];
            cursor += 2;
            return res;
        }

    }

    public void printEven() {
        EvenIterator evenIterator = this.new EvenIterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
    }

    public Iterator iterator (){
        return this.new EvenIterator();
    }

    public Iterator iterator (int number){
        return this.new EvenIterator();
    }
}
