// 13. Roman to Integer - convert roman to integer

    public int romanToInt(String s) {
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            switch (s.charAt(i)) {
                case 'M':
                    res += 1000;
                    i++;
                    break;
                case 'D':
                    res += 500;
                    i++; 
                    break;
                case 'C':
                    if ((i < s.length() - 1) && (s.charAt(i+1) == 'M')) {
                        res += 900;
                        i = i + 2;
                    } else if ((i < s.length() - 1) && (s.charAt(i+1) == 'D')) {
                        res += 400;
                        i = i + 2; 
                    } else {
                        res += 100;
                        i++; 
                    } 
                    break;
                case 'L':
                    res += 50;
                    i++;
                    break; 
                case 'X':
                    if ((i < s.length() - 1) && (s.charAt(i+1) == 'C')) {
                        res += 90;
                        i = i + 2;
                    } else if ((i < s.length() - 1) && (s.charAt(i+1) == 'L')) {
                        res += 40;
                        i = i + 2; 
                    } else {
                        res += 10;
                        i++; 
                    }  
                    break;
                case 'V':
                    res += 5;
                    i++; 
                    break; 
                case 'I':
                    if ((i < s.length() - 1) && (s.charAt(i+1) == 'X')) {
                        res += 9;
                        i = i + 2;
                    } else if ((i < s.length() - 1) && (s.charAt(i+1) == 'V')) {
                        res += 4;
                        i = i + 2; 
                    } else {
                        res += 1;
                        i++; 
                    } 
                    break;    
            }    
        }

        return res;
    }




// cleaner solution with hash map and subtracting!!
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        return res + roman.get(s.charAt(s.length() - 1));        
    }



