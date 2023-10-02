// Сложность алгоритма О(1)

public class StringNum {
    public static void main(String[] args) {
        String one = "12";
        String two = "47";

        one = replacementMinNum(getMaxNum(two), one);
        System.out.println(one);
    }

    static String replacementMinNum(int num, String one) {
        if (num > getMaxNum(one)) {
            return String.valueOf(String.valueOf(num) + String.valueOf(getMaxNum(one)));
        } else return String.valueOf(String.valueOf(getMaxNum(one)) + String.valueOf(num));
    }

    static int getMaxNum(String num) {
        int temp = Integer.parseInt(num);
        if (temp % 10 > temp / 10) {
            return temp % 10;
        } else return temp / 10;
    }
}
