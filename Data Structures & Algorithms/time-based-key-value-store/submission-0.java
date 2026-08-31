class TimeMap {

    Map<String, TreeMap<Integer,String>> keyToVaueMap;


    public TimeMap() {
        this.keyToVaueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyToVaueMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp , value);
    }
    
    public String get(String key, int timestamp) {
        if (!keyToVaueMap.containsKey(key))
            return "";
        Map.Entry<Integer,String> entry =keyToVaueMap.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
