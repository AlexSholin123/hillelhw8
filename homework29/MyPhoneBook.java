import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class MyPhoneBook {

    private final ArrayList<PhoneRecord> phoneNumbers;

    public MyPhoneBook() {
        this.phoneNumbers = new ArrayList<>();
    }

    static class PhoneRecord {
        private String name;
        private String phone;

        public PhoneRecord(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return "PhoneRecord{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneRecord that = (PhoneRecord) o;
            return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, phone);
        }
    }

    public void printPhoneBook() {
        System.out.println(phoneNumbers);
    }

    public ArrayList<PhoneRecord> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(String name, String phone) {
        phoneNumbers.add(new PhoneRecord(name, phone));
    }

    public void sortByName() {
        phoneNumbers.sort(new Comparator<>() {
            @Override
            public int compare(PhoneRecord o1, PhoneRecord o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortByPhoneNumber() {
        phoneNumbers.sort((o1, o2) -> o1.getPhone().compareTo(o2.getPhone()));
    }

}
