import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Laptop> laptops = readFile("D:\\algo.txt");

        System.out.println("Current array:");
        printList(laptops);

        BubbleSorter.bubbleSort(laptops, new VolumeRamComparator());
        System.out.println("\nDescending by the RAM volume(bubble sort):");
        printList(laptops);

        MergeSorter.mergeSort(laptops, new SpeedCpuComparator());
        System.out.println("\nSorted by the CPU speed(merge sort):");
        printList(laptops);
    }

    private static void printList(List<Laptop> list) {
        for (Laptop el : list) {
            System.out.println(el);
        }
    }

    private static class SpeedCpuComparator implements Comparator<Laptop> {
        public int compare(Laptop a, Laptop b) {
            Integer speed1 = a.getSpeedCpu();
            Integer speed2 = b.getSpeedCpu();
            return speed1.compareTo(speed2);
        }
    }

    private static class VolumeRamComparator implements Comparator<Laptop> {
        public int compare(Laptop a, Laptop b) {
            Integer volume1 = a.getVolumeRam();
            Integer volume2 = b.getVolumeRam();
            return volume1.compareTo(volume2);
        }
    }

    private static List<Laptop> readFile(String path) {
        List<Laptop> laptops = new ArrayList<>();
        Scanner scanner;

        try {
            String filePath = path;
            scanner = new Scanner(new FileReader(filePath));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                laptops.add(new Laptop(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return laptops;
    }
}