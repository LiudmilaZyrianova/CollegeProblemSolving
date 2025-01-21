//58. Length of Last Word

    public int lengthOfLastWord(String s) {
        int res = 0;
        int pos = s.length()-1;
        // remove last spaces
        while ((pos >= 0) && (s.charAt(pos) == ' ')) {
            pos--;
        }
        // move until the first space
        while ((pos >= 0) && (s.charAt(pos) != ' ')) {
            res++;
            pos--;
        }
        return res;
    }

// alternative -  spit the strign and take last 
public int lengthOfLastWord(String s) {
String []arr=s.split(" "); // might have to do s.trim() because it leaves leading empty string if input starts with white spaces
return arr[arr.length-1].length();
}
