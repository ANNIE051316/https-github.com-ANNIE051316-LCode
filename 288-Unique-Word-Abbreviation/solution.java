public class ValidWordAbbr {
    Set<String> abbr;

    public ValidWordAbbr(String[] dictionary) {
        abbr = new HashSet<String>();
        for(String s : dictionary) {
            abbr.add(getAbbr(s));
        }
    }
    
    private String getAbbr(String s) {
        int len = s.length();
        if(len <= 2) {
            return s;
        }
        else {
            return s.charAt(0) + (len - 2) + s.charAt(len - 1);
        }
    }

    public boolean isUnique(String word) {
        return !abbr.contains(getAbbr(word));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");