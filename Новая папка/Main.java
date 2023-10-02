import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    /*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- int n = Integer.parseInt(reader.readLine());
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
        nums[i] = Integer.parseInt(reader.readLine());
    }
	* последовательность слов в строке --
	String[] parts = reader.readLine().split(" ");

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	int sum = 0;
    String[] parts = reader.readLine().split(" ");
    for (int i = 0; i < parts.length; i++) {
        int num = Integer.parseInt(parts[i]);
        sum += num;
    }
    writer.write(String.valueOf(sum));
	*/
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        if (n < 2) System.exit(1);
        String parts = String.valueOf(reader.readLine());
        String[] temp = parts.split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(nums);
        writer.write(String.valueOf(getSum(nums)));

        reader.close();
        writer.close();
    }

    static String getSum(int[] nums) {
        if (nums.length == 2) {
            return String.valueOf(Math.abs(nums[0] - nums[1]));
        }

        int[] connections = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) 
            connections[i - 1] = nums[i] - nums[i - 1];
        
        int max = connections[1];
        for (int i = 2; i < connections.length - 1; i ++) 
            if (max < connections[i]) max = connections[i];
        
        int sum = 0;
        sum += connections[0] + connections[connections.length - 1];
        for (int i = 1;i < connections.length - 1; i++) 
            if (connections[i] != max) sum += connections[i];
        
        return String.valueOf(sum);
    }

}
