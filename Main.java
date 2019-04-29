public class Main {

    public static void main(String[] args) {
        int graph[][] = new int[][] {{0, 3, 4, 0, 0, 0}, {3, 0, 0, 4, 2, 0}, {4, 0, 0, 0, 5, 0},
                {0, 4, 0, 0, 0, 1}, {0, 2, 5, 0, 0, 6}, {0, 0, 0, 0, 0, 0}};
        Kruskal sa = new Kruskal(graph);
        sa.Kruskals();
    }
}
