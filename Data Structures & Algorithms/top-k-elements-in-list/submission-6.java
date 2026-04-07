class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums){
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> num : frequencies.entrySet()){
            queue.offer(num);
            if (queue.size() > k){
                queue.poll();
            }
        }
        int[] ks = new int[k];
        for (int i = 0; i < k; i++){
            ks[i] = queue.poll().getKey();
        }
        return ks;
    }
}