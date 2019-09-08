//223. Rectangle Area - M.
//Find the total area covered by two rectilinear rectangles in a 2D plane.

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Main {

    public static  int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long a1 = (C - A) * (D - B);
        long a2 = (G - E) * (H - F);
        if (A == C || B == D) return (int)a2;
        if (E == G || F == H) return (int)a1;
        long c = (min(C,G) - max(A,E)) * (min(H, D) - max(F, B));
        if (G <= A || E >= C || F >= D || H <= B) c = 0;
        if ( c < 0) c = 0;
        return (int) (a1 + a2 - c);

    }

    public static void main(String[] args) {
        System.out.println(computeArea(0,0,0,0,-1,-1, 1,1));
        System.out.println(computeArea(-2,-2, 2, 2,-4,3,-3,4));
        System.out.println(computeArea(-2,-2, 2, 2,-1,-1,1,1));
    }
}
