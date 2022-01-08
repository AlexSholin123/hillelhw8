import java.util.Iterator;

public class DataStructure<E> {
    private final E[] arrayOfElements;

    public DataStructure(E[] arrayOfElements) {
        this.arrayOfElements = arrayOfElements;
    }

    public void printEven() {
        EvenIterator evenIterator = new EvenIterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
    }

    private interface ArrayIterator extends Iterator {

    }

    private class EvenIterator implements ArrayIterator {
        int index = 0;

        public EvenIterator() {
        }

        @Override
        public boolean hasNext() {
            return index < arrayOfElements.length;
        }

        @Override
        public E next() {
            E result = arrayOfElements[index];
            index += 2;
            return result;
        }
    }

}