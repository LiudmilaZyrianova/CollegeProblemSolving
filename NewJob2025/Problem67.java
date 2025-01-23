// 67. Add Binary

    public String addBinary(String a, String b) {
        String longer = (a.length() > b.length()) ? a : b;
        String shorter = (a.length() > b.length()) ? b : a;
        int carryOver = 0;
        int tempRes = 0;
        StringBuilder myRes = new StringBuilder(longer);
        for (int i = longer.length() - 1; i >= 0; i--) {
            tempRes = (longer.charAt(i) - '0') + carryOver;
            if (i - (longer.length() - shorter.length()) >= 0 ) {
                tempRes += shorter.charAt(i - (longer.length() - shorter.length())) - '0';
            }
            carryOver = (tempRes > 1) ? 1 : 0; 
            myRes.setCharAt(i, (tempRes % 2 == 0) ? '0' : '1');
        }
        longer = myRes.toString();
        if (carryOver == 1) { longer = "1" + longer; }
        return longer;
    }

// cleaner - to do one by one by appending to a new sb and then reverse and decide length inside loop
  public String addBinary(String a, String b) 
  {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0 || carry == 1) 
    {
      if(i >= 0)
        carry += a.charAt(i--) - '0';
      if(j >= 0)
        carry += b.charAt(j--) - '0';
      sb.append(carry % 2);
      carry /= 2;
    }
    return sb.reverse().toString();
  }
