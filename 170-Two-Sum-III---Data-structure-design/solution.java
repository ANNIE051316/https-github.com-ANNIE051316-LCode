public class TwoSum {
    Map<Integer, Integer> map;
    
    TwoSum(){
         map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
	public void add(int number) {
	    if(!map.containsKey(number)) {
	        map.put(number, 1);
	    }
	    else {
	        map.put(number, map.get(number) + 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	 for (Integer i : elements.keySet()) {
			int target = value - i;
			if (map.containsKey(target)) {
				if (i == target && map.get(target) < 2) {
					continue;
				}
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