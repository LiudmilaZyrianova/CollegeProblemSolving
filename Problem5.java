class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // System.out.println(n);
        int[] resO = new int[n];
        int[] resE = new int[n];
        for (int i = 0; i<n-1; i++) {
            resO[i] = 1;
            
            if (s.charAt(i) == s.charAt(i+1)) {
                resE[i] = 2;
            } else {
                resE[i] = 0;
            }
        }
        resO[n-1] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= Math.min(i, n-1-i); j++) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    resO[i] = resO[i] + 2;
                } else {
                    break;
                }
            }
            for (int j = 1; j <= Math.min(i, n-2-i); j++) {
                if (resE[i] >= 2 && i+1+j < n && s.charAt(i-j) == s.charAt(i+1+j)) {
                    resE[i] = resE[i] + 2;
                } else {
                    break;
                }
            }
        }
        int mO = -1;
        int posO = -1;
        int mE = -1;
        int posE = -1;
        for (int i = 0; i<n; i++) {
            if (resO[i] > mO) {
                mO = resO[i]; 
                posO = i;
            }
            if (resE[i] > mE) {
                mE = resE[i]; 
                posE = i;
            }
        }
        if (mO >= mE) {
            return s.substring(posO-(mO/2), posO+(mO/2)+1);
        }
        return s.substring(posE-(mE/2-1), posE+ mE/2 + 1);
        
    }
}

// Better solution
public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}
