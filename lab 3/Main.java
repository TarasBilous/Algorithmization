import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph weddGraph = new Graph();
        readFile(weddGraph, "D:\\in.txt");
        int weddCount = 0;
        for (int i = 0; i < weddGraph.getVertexes().size(); i++) {
            for (int j = i + 1; j < weddGraph.getVertexes().size(); j++) {
                if (isNotTheSameTribe(weddGraph, i, j)) {
                    if (isBoyAndGirlPair(weddGraph, i, j)) {
                        weddCount += 1;
                        System.out.println(weddGraph.getVertexes().get(i).value + " - " + weddGraph.getVertexes().get(j).value);
                    }
                }
            }
        }

        System.out.println("Total: " + weddCount);
    }

    private static boolean isNotTheSameTribe(Graph weddGraph, int i, int j) {
        return !weddGraph.checkElemBfs(weddGraph.getVertexes().get(i), weddGraph.getVertexes().get(j));
    }

    private static boolean isBoyAndGirlPair(Graph weddGraph, int i, int j) {
        return (weddGraph.getVertexes().get(i).value + weddGraph.getVertexes().get(j).value) % 2 != 0;
    }

    private static void readFile(Graph graph, String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] pair = line.split(" ");
                graph.addPair(new Graph.Vertex(Integer.parseInt(pair[0])), new Graph.Vertex(Integer.parseInt(pair[1])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
