import java.util.*;

public class Kruskal {
    int matrix[][];
    int visted[];
    ArrayList<Edge> sortlist = new ArrayList<>();

    public Kruskal(Graph a) {
        matrix = a.getMatrix();
        visted = new int[a.getSize()];
        for (int i = 0; i < a.getSize(); i++) {
            visted[i] = i;
        }
        for (int i = 0; i < a.getSize(); i++) {
            for (int j = 0; j < a.getSize(); j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1000) {
                    sortlist.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        sortlist.sort((o1, o2) -> o1.getValue() - o2.getValue());
    }

    private void union(int i, int j) {
        int start = visted[i];
        int end = visted[j];
        for (int a = 0; a < visted.length; a++) {
            if (visted[a] == end) {
                visted[a] = start;
            }
        }
    }

    public void Kruskals() {
        int chose = 0;
        int current = 0;
        System.out.println("Source\t" + "Destion\t" + "Weight");
        while (chose < matrix[0].length - 1 && current < sortlist.size()) {
            Edge s = sortlist.get(current);
            if (visted[s.getSource()] != visted[s.getDest()]) {
                union(s.getSource(), s.getDest());
                System.out.println(s.getSource() + "\t" + s.getDest() + "\t" + s.getValue());
                chose++;
            }
            current++;
        }
    }
}
public class Main{
    public static void main(String[] args){
        int graph[][] = new int[][]{
                {0, 3, 4, x, x, x},
                {3, 0, x, 4, 2, x},
                {4, x, 0, x, 5, x},
                {x, 4, x, 0, x, 1},
                {x, 2, 5, x, 0, 6},
                {x, x, x, x, x, 0}
        };
        Kruskal sa=new Kruskal(graph);
        sa.Kruskals();
    }
}
