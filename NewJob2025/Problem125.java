//125. Valid Palindrome

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }




    //Optimized solution:
//    public boolean isPalindrome(String s) {
//        if (s.isEmpty()) {
//            return true;
//        }
//        int head = 0, tail = s.length() - 1;
//        char cHead, cTail;
//        while(head <= tail) {
//            cHead = s.charAt(head);
//            cTail = s.charAt(tail);
//            if (!Character.isLetterOrDigit(cHead)) {
//                head++;
//            } else if(!Character.isLetterOrDigit(cTail)) {
//                tail--;
//            } else {
//                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
//                    return false;
//                }
//                head++;
//                tail--;
//            }
//        }
//
//        return true;
//    }
