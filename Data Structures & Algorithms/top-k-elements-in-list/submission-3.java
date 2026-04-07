        class Solution {
            public int[] topKFrequent(int[] nums, int k) {
                int[] frequencies = new int[2001];
                for (int i : nums){
                    frequencies[i+1000]++;
                }
                List<Integer> kFrequencies = new ArrayList<>();
                List<Integer> kIndexes = new ArrayList<>();
                for (int i = 0; i < frequencies.length; i++){
                    if (kFrequencies.isEmpty()){
                        kFrequencies.add(frequencies[i]);
                        kIndexes.add(i-1000);
                    } else if (kFrequencies.size() < k || kFrequencies.get(0) < frequencies[i]){
                        boolean wasAdded = false;
                        for (int j = 0; j < kFrequencies.size(); j++){
                            if (kFrequencies.get(j) >= frequencies[i]){
                                kFrequencies.add(j, frequencies[i]);
                                kIndexes.add(j, i-1000);
                                wasAdded = true;
                                break;
                            }
                        }
                        if (!wasAdded){
                            kFrequencies.add(kFrequencies.size(), frequencies[i]);
                            kIndexes.add(kIndexes.size(), i-1000);
                        }
                    }

                    if (kFrequencies.size() > k){
                        kFrequencies.remove(0);
                        kIndexes.remove(0);
                    }

                }
                int[] ks = new int[k];
                for (int i = 0; i < k; i++){
                    ks[i] = kIndexes.get(i);
                }

                return ks;
            }
        }