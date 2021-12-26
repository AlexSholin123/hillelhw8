import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyPhoneBookTest {
    MyPhoneBook myPhoneBook;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        myPhoneBook = new MyPhoneBook();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void sortByPhoneNumber() {
        myPhoneBook.addPhoneNumber("a", "1");
        myPhoneBook.addPhoneNumber("a", "4");
        myPhoneBook.addPhoneNumber("a", "3");
        myPhoneBook.addPhoneNumber("a", "2");

        myPhoneBook.sortByPhoneNumber();
        List<MyPhoneBook.PhoneRecord> phoneRecords = myPhoneBook.getPhoneNumbers();

        assertThat(phoneRecords.get(0).getPhone()).isEqualTo("1");
        assertThat(phoneRecords.get(1).getPhone()).isEqualTo("2");
        assertThat(phoneRecords.get(2).getPhone()).isEqualTo("3");
        assertThat(phoneRecords.get(3).getPhone()).isEqualTo("4");

    }

    @Test
    public void sortByNameTest() {
        myPhoneBook.addPhoneNumber("a", "1");
        myPhoneBook.addPhoneNumber("z", "1");
        myPhoneBook.addPhoneNumber("c", "1");
        myPhoneBook.addPhoneNumber("g", "1");

        myPhoneBook.sortByName();
        List<MyPhoneBook.PhoneRecord> phoneRecords = myPhoneBook.getPhoneNumbers();

        assertThat(phoneRecords.get(0).getName()).isEqualTo("a");
        assertThat(phoneRecords.get(1).getName()).isEqualTo("c");
        assertThat(phoneRecords.get(2).getName()).isEqualTo("g");
        assertThat(phoneRecords.get(3).getName()).isEqualTo("z");
    }

    @Test
    public void printPhoneBookTest() {
        myPhoneBook.addPhoneNumber("test", "111");
        String expectedResult = "[PhoneRecord{name='test', phone='111'}]";


        myPhoneBook.printPhoneBook();

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedResult);
    }

    @Test
    public void addPhoneNumberTest() {
        MyPhoneBook.PhoneRecord phoneRecord = new MyPhoneBook.PhoneRecord("Peter", "063 567 56 76");

        myPhoneBook.addPhoneNumber("Peter", "063 567 56 76");

        List<MyPhoneBook.PhoneRecord> phoneRecords = myPhoneBook.getPhoneNumbers();

        assertThat(phoneRecords).isNotEmpty()
                .hasSize(1)
                .doesNotContainNull()
                .contains(phoneRecord);
    }

    @Test
    public void getPhoneNumbersTest() {
        List<MyPhoneBook.PhoneRecord> expectedRecords = new ArrayList<>();
        expectedRecords.add(new MyPhoneBook.PhoneRecord("test", "number"));
        expectedRecords.add(new MyPhoneBook.PhoneRecord("test2", "number2"));

        myPhoneBook.addPhoneNumber("test", "number");
        myPhoneBook.addPhoneNumber("test2", "number2");
        List<MyPhoneBook.PhoneRecord> resultRecords = myPhoneBook.getPhoneNumbers();

        assertThat(resultRecords).isEqualTo(expectedRecords)
                .doesNotContainNull()
                .hasSize(2)
                .isNotEmpty()
                .containsAll(expectedRecords);
    }

}
