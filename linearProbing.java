public class linearProbing {
    int keys[];
    int values[];
    int capacity;

    linearProbing(int capacity) {
        this.capacity = capacity;
        keys = new int[capacity];
        values = new int[capacity];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = -1;
            values[i] = -1;
        }
    }

    void insert(int key, int value) {
        int i = hashFun(key);
        if (keys[i] == -1) {
            keys[i] = key;
            values[i] = value;
        } else { // probing
            int temp = i;
            do {
                i = (i + 1) % capacity;
                if (keys[i] == -1) {
                    keys[i] = key;
                    values[i] = value;
                }
            } while (temp != i);
        }
    }

    int get(int key) {
        int i = hashFun(key);
        if (keys[i] == key) {
            return values[i];
        } else {
            int temp = i;
            do {
                i = (i + 1) % capacity;
                if (keys[i] == key) {
                    return values[i];
                }
            } while (temp != i);
        }
        return -1;
    }

    int hashFun(int key) {
        return key % capacity;
    }
}
