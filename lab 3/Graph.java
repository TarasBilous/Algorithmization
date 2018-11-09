import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertexes = new ArrayList<>();
    private ArrayList<Vertex> used = new ArrayList<>();

    public ArrayList<Vertex> getVertexes() {
        return vertexes;
    }

    public void addPair(Vertex vertex1, Vertex vertex2) {
        for (int i = 0; i < vertexes.size(); i++) {
            if (vertexes.get(i).value == vertex1.value) {
                vertex1 = vertexes.get(i);
                vertexes.remove(i);
                break;
            }
        }
        for (int i = 0; i < vertexes.size(); i++) {
            if (vertexes.get(i).value == vertex2.value) {
                vertex2 = vertexes.get(i);
                vertexes.remove(i);
                break;
            }
        }

        vertex1.neighbours.add(vertex2);
        vertex2.neighbours.add(vertex1);
        vertexes.add(vertex1);
        vertexes.add(vertex2);
    }

    public boolean checkElemBfs(Vertex start, Vertex el) {
        if (start.value == el.value) {
            return true;
        }
        for (Vertex neighbor : start.neighbours) {
            if (neighbor.value == el.value) {
                return true;
            }
        }
        used.add(start);
        for (Vertex neighbor : start.neighbours) {
            if (!used.contains(neighbor)) {
                if (checkElemBfs(neighbor, el))
                    return true;
            }
        }
        return false;
    }

    static class Vertex {
        int value;
        private ArrayList<Vertex> neighbours = new ArrayList<>();

        Vertex(int value) {
            this.value = value;
        }
    }
}
