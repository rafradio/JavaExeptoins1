import java.util.Arrays;
import java.util.stream.IntStream;

public class SumThrowHW {
    public static void main(String[] args) {
        int[] intArr1 = { 1, 20, 3, 40, 5 };
        int[] intArr2 = { 3, 15, 8, 12, 4 };
        int[] result = sumOfArrays(intArr1, intArr2);

        if (result != null) {
            System.out.println("Новый массив: ");
            Arrays.stream(result).forEach(x -> System.out.print(x + " "));
        } else {
            System.out.println("У массивов разная длина");
        }
    }

    private static int[] sumOfArrays(int[] arrL1, int[] arrL2) {
        if (arrL1.length != arrL2.length) return null;
        else return IntStream.range(0, arrL1.length)
                .map(index -> (arrL1[index] - arrL2[index]))
                .toArray();
    }
}
