import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TASK 1
        String letter = scanner.next();
        smallBig(letter);

        //TASK 2
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arrays(arr)));

        //TASK 3*/
        int[] firstArrSort = {2, 5, 7, 9, 10};
        int[] secondArrSort = {1, 3, 4, 6, 8};
        System.out.println(Arrays.toString(arraysSort(firstArrSort, secondArrSort)));

        //TASK 5
        System.out.println(foundLitter(scanner));

        //TASK 6
        int value = scanner.nextInt();
        int[][] matrix = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        System.out.println(isValueIncludes(matrix, value));
    }

    //TASK 1
    public static void smallBig(String letter) {
        for (char i = 'a'; i <= 'z'; i++) {
            if (Objects.equals(letter, Character.toString(i))) {
                System.out.println("small");
                return;
            }
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            if (Objects.equals(letter, Character.toString(i))) {
                System.out.println("Big");
                return;
            }
        }

    }

    //TASK 2
    public static int[] arrays(int[] arr) {
        int[] arrRes = new int[3];
        int max = 0;
        int min = 0;
        int sum = 0;
        for (int j : arr) {
            sum += j;
            if (min > j) min = j;
            if (max < j) max = j;
        }
        arrRes[0] = min;
        arrRes[1] = max;
        arrRes[2] = sum / arr.length;
        return arrRes;
    }

    //TASK 3
    public static int[] arraysSort(int[] firstArrSort, int[] secondArrSort) {
        int[] res = IntStream.concat(IntStream.of(firstArrSort), IntStream.of(secondArrSort)).toArray();
        return Arrays.stream(res).sorted().toArray();
    }

    //TASK 5
    public static Map foundLitter(Scanner scanner) {
        String input = scanner.nextLine();

        Map<Character, Integer> letters = new HashMap<>();
        for (char i : input.toCharArray()) {
            letters.put(i, letters.getOrDefault(i, 0) + 1);
        }
        return letters;
    }

    // TASK 6
    public static boolean isValueIncludes(int[][] matrix, int value) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (value == matrix[i][j]) return true;
            }
        }
        return false;
    }

    // throw new IllegalArgumentException("this method is not implemented ");
}
