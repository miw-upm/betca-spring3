package injection.e3;

import java.util.HashMap;
import java.util.Map;

public class MessageService {
    private Map<String, String> messageMap;

    public MessageService() {
        messageMap = new HashMap<>();
    }

    public void add(String key, String message) {
        messageMap.put(key, message);
    }

    public String message(String key) {
        return messageMap.get(key);
    }

    public String key(String message) {
        for (String key : messageMap.keySet()) {
            if (messageMap.get(key).equals(message)) {
                return key;
            }
        }
        return null;
    }
}
