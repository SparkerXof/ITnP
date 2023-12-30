import java.util.LinkedList;

public class HashTable {
    private LinkedList<KeyValue<String, Contact>>[] table = new LinkedList[1000];

    public void put(String key, Contact value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<KeyValue<String, Contact>>();
        }
        for (KeyValue<String, Contact> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new KeyValue<String, Contact>(key, value));
    }

    public boolean isListExist(int index) {
        return (table[index] == null ? false : true);
    }

    public LinkedList<KeyValue<String, Contact>> getList(int index) {
        return table[index];
    }

    public Contact get(String key) {
        int index = hash(key);
        for (KeyValue<String, Contact> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return new Contact("No name", "No email", "No info");
    }

    private int hash(String key) {
        int keyHash = 0;
        for (Character symbol : key.toCharArray()) {
            keyHash += Integer.valueOf(symbol);
        }
        return keyHash % 1000;
    }
}