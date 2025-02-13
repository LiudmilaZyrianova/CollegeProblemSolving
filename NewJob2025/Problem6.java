// 6. Zigzag Conversion - M
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int row = 0; // startOffset
        int dip = 2*(numRows-1);
        int peak = 0;

        

        while (row < numRows) {
            int i = row;
            boolean goDown = (row != numRows - 1 ) ? true : false;
            while (i < s.length()) {
                res.append(s.charAt(i));
                if (goDown) {
                    i += dip;
                    if (row != 0) goDown = false;
                } else {
                    i += peak;
                    if (row != numRows - 1 ) goDown = true;
                }
            }
            
            dip -= 2;
            peak += 2;

            row++;
        }

        return res.toString();
    }

// Alt sol - store each row separately
        int idx = 0, d = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[idx].add(c);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }
