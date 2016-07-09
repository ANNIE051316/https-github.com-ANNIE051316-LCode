public class TwoSum {
    List<Integer> nums = new ArrayList<Integer>();
    Set<Integer> sums = new HashSet<Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    for(Integer i : nums) {
	        sums.add(i + number);
	    }
	    
	    nums.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return sums.containsValue(value);
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);