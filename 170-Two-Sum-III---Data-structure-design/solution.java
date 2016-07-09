public class TwoSum {
    Map<Integer, Integer> map;
    Set<Integer> sums;
    
    TwoSum(){
         map = new HashMap<Integer, Integer>();
         sums = new HashSet<Integer>();
    }

    // Add the number to an internal data structure.
	public void add(int number) {
	    if(!map.containsKey(number)) {
	        map.put(number, 1);
	    }
	    else {
	        map.put(number, map.get(number) + 1);
	        sums.add(2 * number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    if(sums.contains(value)) {
	        return true;
	    }
	    
	    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
	        int key = entry.getKey();
	        int target = value - key;
	        if(target == key) {
	            continue;
	        }
	        else if(map.containsKey(target)){
	            sums.add(value);
	            return true;
	        }
	    }
		return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);