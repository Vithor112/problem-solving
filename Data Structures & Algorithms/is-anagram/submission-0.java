class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> frequencies = new HashMap<>();
        for (Character c : s.toCharArray()){
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()){
            frequencies.put(c, frequencies.getOrDefault(c, 0) - 1);
        }
        for (Integer frequency : frequencies.values()){
            if (frequency != 0){
                return false;
            }
        }

        return true; 
        
    }
}
