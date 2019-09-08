//168. Excel Sheet Column Title - E.
//Given a positive integer, return its corresponding column title as appear in an Excel sheet.
public class Main {

//One Line:
//return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));

    public static String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        int a = 'A';
        while (n > 0) {
            n = n-1;
            s.append(Character.toChars(n%26 + a));
            n = n/26;
        }
        s.reverse();
        return s.toString();

    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));

    }
}
