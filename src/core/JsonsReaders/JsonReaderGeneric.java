package core.JsonsReaders;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;

public class JsonReaderGeneric {
    public static JSONArray load(String path) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return new JSONArray(content);
    }
}

