import java.util.*;

public class Kruskal {
    int matrix[][];
    int visted[];
    ArrayList<Edge> sortlist = new ArrayList<>();

    public Kruskal(int[][] a) {
        matrix = a;
        visted = new int[a[0].length];
        for (int i = 0; i < a[0].length; i++) {
            visted[i] = i;
        }
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a[0].length; j++) {
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
