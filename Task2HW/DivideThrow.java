package Task2HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DivideThrow {
    public static void main(String[] args) {
        Integer[] intArr1 = { 1, 20, 3, 40, 5 };
        Integer[] intArr2 = { 3, 15, 8, 12, 4 };
        ArrayList<Integer> arrL1 = new ArrayList<>(Arrays.asList(intArr1));
        ArrayList<Integer> arrL2 = new ArrayList<>(Arrays.asList(intArr2));

        try {
            List<Double> result = divideOfArrays(arrL1, arrL2);
            System.out.println("Новый массив: ");
            result.stream().forEach(x -> System.out.print(String.format("%.3f", x) + " "));
        } 
        catch (CustomArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }
    }

    private static List<Double> divideOfArrays(ArrayList<Integer> arrL1, ArrayList<Integer> arrL2) {
        if (arrL1.size() != arrL2.size()) {
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.", arrL1.size(), arrL2.size());
        } else {
            return IntStream.range(0, arrL1.size())
                    .mapToDouble(index -> ((float) arrL1.get(index) / (float) arrL2.get(index)))
                    .boxed()
                    .collect(Collectors.toList());
        }
    }
}
