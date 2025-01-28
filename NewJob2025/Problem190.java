// 190. Reverse Bits - E

    public int reverseBits(int n) {
        int nullifier = 1;
        int res = 0;
        for (int i = 0; i < 31; i++) {
            res  = res | (n & nullifier);
            res = res << 1;
            n = n >> 1;
        }
        res  = res | (n & nullifier);
        return res;
    }
