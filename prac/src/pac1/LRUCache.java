package pac1;

import java.util.*;

public class LRUCache {
//    private List<Node> cache = new ArrayList<>();
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        int res = -1;
//        if (cache != null) {
//            for (Node node : cache) {
//                if (key == node.getKey()) {
//                    return node.getValue();
//                }
//            }
//        }
//        return res;
//    }
//
//    public void put(int key, int value) {
//
//        if (cache.size()>=capacity) {
//            return;
//        }
//    }
//
//    class Node {
//
//        private int key;
//        private int value;
//
//        public Node(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public int getKey() {
//            return key;
//        }
//
//        public void setKey(int key) {
//            this.key = key;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }

    private int cap;
    float loadFactor = 0.75f;
    private LinkedHashMap<Integer, Integer> map = null;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, loadFactor, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        map.put(key, value);

    }


}
