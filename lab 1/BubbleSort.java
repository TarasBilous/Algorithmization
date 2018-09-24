import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort {

    public static void bubbleSort(ArrayList<Laptop> laptops, Comparator<Laptop> comparator) {
        long startAlgoTime;
        long endAlgoTime;
        long algoTime;

        int swapCounter = 0;
        int comparatorCounter = 0;
        startAlgoTime = System.nanoTime();

        for (int i = laptops.size() - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                comparatorCounter++;
                if (comparator.compare(laptops.get(j), laptops.get(j + 1)) < 0) {
                    swap(laptops, j, j + 1);
                    swapCounter++;
                }
            }
        }
        endAlgoTime = System.nanoTime();
        algoTime = endAlgoTime - startAlgoTime;
        System.out.println("\nBubble sort:\nComparator Counter = " + comparatorCounter + "\nSwap Counter = " + swapCounter
                + "\nExecution time = " + algoTime + "ns");
    }

    private static void swap(ArrayList<Laptop> laptops, int leftIndex, int rightIndex) {
        Laptop temp = laptops.get(leftIndex);
        laptops.set(leftIndex, laptops.get(rightIndex));
        laptops.set(rightIndex, temp);
    }

}