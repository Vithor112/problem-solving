class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies using a HashMap.
        // O(N) time, where N is the number of elements in nums.
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Build a min-heap. The heap is ordered by frequency.
        // The lambda (a, b) -> a.getValue() - b.getValue() makes it a min-heap based on frequency.
        // O(U log k) time, where U is the number of unique elements.
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the smallest frequency.
            }
        }

        // Step 3: Extract the results from the heap.
        // O(k log k) time.
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}