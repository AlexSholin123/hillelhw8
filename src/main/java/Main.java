import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();
        List<DayJournal> dayJournalList = jsonParser.parser();
        System.out.println(dayJournalList);
    }

}
