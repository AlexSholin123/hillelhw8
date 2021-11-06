import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.List;

public class JsonParser {
    public List<DayJournal> parser() {
        Gson gson = new Gson();
        String path = "journal_ru.json";
        try {
            return gson.fromJson(new FileReader(path), new TypeToken<List<DayJournal>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}



