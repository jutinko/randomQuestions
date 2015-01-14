/**
 * Created by jutinko on 14/01/15.
 * Simplified hashtable from http://www.algolist.net/Data_structures/Hash_table/Simple_example
 */
public class MyHashTable {
    static class MyHashMapEntry {
        int key;
        String value;

        public MyHashMapEntry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    private static final int MAX_SIZE = 128;
    private MyHashMapEntry[] table;
    private int size;

    public MyHashTable() {
        this.table = new MyHashMapEntry[MAX_SIZE];
        for(int i = 0; i < MAX_SIZE; ++i) {
            table[i] = null;
        }
        this.size = 0;
    }

    public String find(int key) {
        int hash = key%MAX_SIZE;

        while(table[hash] != null && table[hash].getKey() != key) {
            hash = (hash+1)%MAX_SIZE;
        }
        if(table[hash] == null) {
            return null;
        } else {
            return table[hash].getValue();
        }
    }

    public void put(int key, String value) {
        if(size >= MAX_SIZE) {
            System.out.println("The map is full, it will now behave weird");
            return;
        }
        int hash = key%MAX_SIZE;
        while(table[hash] != null) {
            hash = (hash+1)%MAX_SIZE;
        }

        table[hash] = new MyHashMapEntry(key, value);
        ++size;
    }

    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        for(int i = 0; i < 100; ++i) {
            table.put(3*i, String.valueOf(90*i));
        }
        System.out.println(table.find(6));
    }
}
