class PrefixTree {

    private Trie root;

    public PrefixTree() {
         this.root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;    
        for(Character ch : word.toCharArray()) {
            if(curr.isPresent(ch)) {
                curr= curr.get(ch);
            } else {
               curr = curr.getAndCreate(ch);
            }
        }
        curr.setWordEnd();
    }

    public boolean search(String word) {
        Trie curr = root;    
        for(char ch :word.toCharArray()) {
            if(curr.isPresent(ch)) {
                curr= curr.get(ch);
            } else {
                return false;
            } 
        }
        return curr.isWordEnd();
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;    
        for(char ch :prefix.toCharArray()) {
            if(curr.isPresent(ch)) {
                curr= curr.get(ch);
            } else {
                return false;
            } 
        }
        return curr!=null;
    }

    class Trie {
        private Map<Character,Trie> mapOfCharacter = new HashMap();
        private boolean isWord= false;

        public void setWordEnd(){
            this.isWord = true;
        }

        public boolean isPresent(char ch) {
            return mapOfCharacter.containsKey(ch);
        }

        public Trie get(char ch) {
            return mapOfCharacter.get(ch);
        }

        public Trie getAndCreate(char ch) {
            if (!isPresent(ch)) {
                mapOfCharacter.put(ch, mapOfCharacter.getOrDefault(ch, new Trie()));
            }
            return get(ch);
        }

        public boolean isWordEnd() {
            return isWord;
        }

    }
}
