public class Main {

    public static void main(String[] args) {

        MyPhoneBook myPhoneBook = new MyPhoneBook();
        myPhoneBook.addPhoneNumber("d","2");
        myPhoneBook.addPhoneNumber("c","1");
        myPhoneBook.addPhoneNumber("b","3");
        myPhoneBook.addPhoneNumber("a","4");
        System.out.println("just phones: ");
        myPhoneBook.printPhoneBook();
        myPhoneBook.sortByName();
        System.out.println("sorted by name: ");
        myPhoneBook.printPhoneBook();
        myPhoneBook.sortByPhoneNumber();
        System.out.println("sorted by phone number: ");
        myPhoneBook.printPhoneBook();
    }

}
