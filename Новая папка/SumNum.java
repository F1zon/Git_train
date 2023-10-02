public class SumNum {
    public static void main(String[] args) {
        int[] arr = {12, 105, 10, 26, 354, 11, 55, 235};
        int temp = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (getSum(arr[i - 1]) > getSum(arr[i])) {
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i = 0;
            }
        }

        for (int i : arr) System.out.println(i + " ");
    }

    static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = Math.floorDiv(num, 10);
        }

        return sum;
    }
}
