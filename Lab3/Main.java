public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("89163093552", new Contact("Sergey", "sergo.kuznezh61@gmail.com", "test"));
        hashTable.put("89065628834", new Contact("Semyon", "spv145@mail.ru", "bla-bla"));
        hashTable.put("29165593038", new Contact("Yegres", "yggdrass16@ya.ru", "esrever"));
        hashTable.put("89163093552", new Contact("Sergey", "sergo", "test"));
        printFullHashTable(hashTable);
        Contact contact = hashTable.get("89065628834");
        System.out.println(contact.getName() + " " + contact.getEmail());
    }

    public static void printFullHashTable(HashTable htable) {
        for (int i = 0; i < 1000; i++) {
            if (htable.isListExist(i)) {
                System.out.print("Array " + i);
                for (KeyValue<String, Contact> kv : htable.getList(i)) {
                    Contact contact = kv.getValue();
                    System.out.print(" -> (" + kv.getKey() + " | " + contact.getName() + " " 
                                                                    + contact.getEmail() + " " 
                                                                    + contact.getInfo()  + ")");
                }
                System.out.print("\n");
            }
        }
    }
}
