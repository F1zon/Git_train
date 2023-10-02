import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    /*
     * Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

        I может быть помещен перед (5) и (10), чтобы сделать 4 и 9. VX
        X может быть помещен перед (50) и (100), чтобы сделать 40 и 90. LC
        C может быть размещен перед (500) и (1000), чтобы сделать 400 и 900.DM

        LVIII -> 58
        MCMXCIV -> 1994
     */
    public static int romanToInt(String s) {
        char[] rimNum = s.toCharArray();
        int sum = 0;
        Map<Character, Integer> nums = new TreeMap<>();
        nums.put('I', 1);
        nums.put('V', 5);
        nums.put('X', 10);
        nums.put('L', 50);
        nums.put('C', 100);
        nums.put('D', 500);
        nums.put('M', 1000);

        for (int i = 0; i < rimNum.length; i++) {
            System.out.println(sum);
            switch (rimNum[i]) {
                case 'I':
                    if (i < rimNum.length - 2 && rimNum[i + 1] == 'V') {sum += 4; i++;}
                    if (i < rimNum.length - 2 && rimNum[i + 1] == 'X') {
                        sum += 9;
                        i++;
                    } else sum += nums.get(rimNum[i]);
                    break;
                case 'X':
                    if (i < rimNum.length - 2 && rimNum[i + 1] == 'L') {sum += 40; i++;}
                    if (i < rimNum.length - 2 && rimNum[i + 1] == 'C') {
                        sum += 90;
                        i++;
                    } else sum += nums.get(rimNum[i]);
                    break;
                case 'C':
                    if (i < rimNum.length - 2 && rimNum[i + 1] == 'D') {sum += 400; i++;}
                    if (i < rimNum.length - 2 && rimNum[i + 1] == 'M') {
                        sum += 900;
                        i++;
                    } else sum += nums.get(rimNum[i]);
                    break;
                default:
                    sum += nums.get(rimNum[i]);
                    break;
            }
            System.out.println(sum);

        }

        return sum;
    }
}