import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {

    private static int swapCounter;
    private static int comparatorCounter;

    private static void merge(ArrayList<Laptop> array, Comparator<Laptop> comparator) {
        int n = array.size();

        if (n < 2) {
            return;
        }
        int mid = n / 2;

        ArrayList<Laptop> leftArray = new ArrayList<>(array.subList(0, mid));
        ArrayList<Laptop> rightArray = new ArrayList<>(array.subList(mid, n));

        merge(leftArray, comparator);
        merge(rightArray, comparator);

        merge(leftArray, rightArray, array, comparator);
    }

    private static void merge(ArrayList<Laptop> leftArray, ArrayList<Laptop> rightArray, ArrayList<Laptop> array, Comparator<Laptop> comparator) {

        int i = 0, j = 0;
        while (i + j < array.size()) {
            if (j == rightArray.size() || (i < leftArray.size() && comparator.compare(leftArray.get(i), rightArray.get(j)) < 0)) {
                array.set(i + j, leftArray.get(i));
                i++;
                comparatorCounter++;
                swapCounter++;
            } else {
                array.set(i + j, rightArray.get(j));
                j++;
                comparatorCounter++;
                swapCounter++;
            }
        }
    }

    public static void mergeSort(ArrayList<Laptop> array, Comparator<Laptop> comparator) {

        swapCounter = 0;
        comparatorCounter = 0;

        long startAlgoTime;
        long endAlgoTime;
        long algoTime;
        startAlgoTime = System.nanoTime();

        merge(array, comparator);

        endAlgoTime = System.nanoTime();
        algoTime = endAlgoTime - startAlgoTime;

        System.out.println("\nMerge sort:\nComparator Counter = " + comparatorCounter + "\nSwap Counter = " + swapCounter
                + "\nExecution time = " + algoTime + "ns");
    }
}