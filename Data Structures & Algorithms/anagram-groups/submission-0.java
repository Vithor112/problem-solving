class Solution {
    private static final char[] LowerCaseAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    HashMap<String, HashMap<Character, Integer>> cacheAnagrams = new HashMap<>(); 

    private HashMap<Character, Integer> calculateCharFrequency(String word){
        if (cacheAnagrams.containsKey(word)){
            return cacheAnagrams.get(word);
        }
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (Character character : word.toCharArray()){
            frequency.put(character, frequency.getOrDefault(character, 0) + 1);
        }
        cacheAnagrams.put(word, frequency);
        return frequency;
    }

    private boolean areAnagrams(String word1, String word2){
        HashMap<Character, Integer> frequency1 = calculateCharFrequency(word1);
        HashMap<Character, Integer> frequency2 = calculateCharFrequency(word2);
        for (char character : LowerCaseAlphabet){
            if (frequency1.getOrDefault(character, 0) != frequency2.getOrDefault(character, 0)){
                return false;
            }
        }
        return true; 
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsGrouped = new ArrayList<>(); 
        for (String word : strs){
            boolean hasFoundGroup = false;
            for (List<String> anagramGroup : anagramsGrouped){
                if (areAnagrams(anagramGroup.get(0), word)){
                    anagramGroup.add(word); 
                    hasFoundGroup = true; 
                }
            }
            if (!hasFoundGroup){
                List<String> anagramGroup = new ArrayList<>(); 
                anagramGroup.add(word);
                anagramsGrouped.add(anagramGroup);
            }
        }
        return anagramsGrouped; 
    }
}
