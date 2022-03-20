class Solution {
    public class OurPair {
        Integer val;
        Integer freq;
        OurPair(int val, int freq) {this.val = val; this.freq = freq;}   
    }
    
    public class NameComparator implements Comparator<OurPair> {


    @Override
    public int compare(OurPair p1, OurPair p2) {
        // ascending order (descending order would be: name2.compareTo(name1))
        return p2.freq.compareTo(p1.freq);
    }

}
    
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                int currFreq = freq.get(nums[i]);
                freq.put(nums[i], currFreq + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }
        PriorityQueue<OurPair> q = new PriorityQueue<>(new NameComparator());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            q.add(new OurPair(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        for (int i = 0; i<k; i++) {
            res[i] = q.poll().val;
        }
        return res;
        
    }
}

// But better using bucket sort
public List<Integer> topKFrequent(int[] nums, int k) {

	List<Integer>[] bucket = new List[nums.length + 1];
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}

	for (int key : frequencyMap.keySet()) {
		int frequency = frequencyMap.get(key);
		if (bucket[frequency] == null) {
			bucket[frequency] = new ArrayList<>();
		}
		bucket[frequency].add(key);
	}

	List<Integer> res = new ArrayList<>();

	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
		if (bucket[pos] != null) {
			res.addAll(bucket[pos]);
		}
	}
	return res;
}
