public class Less1 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";

        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        char result = '#';
        boolean test = false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (char i : tArr) {
            for (char j : sArr) if (j == i) test = true;
            if (!test) {
                result = i;
                break;
            }
            test = false;
        }

        if (result == '#') result = tArr[tArr.length - 1];

        return result;
    }
}
