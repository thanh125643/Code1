
import java.util.ArrayList;

public class MinimumCut {
    public MinimumCut() {

    }

    // Thuat toan duyet cay theo chieu rong
    public boolean bfs(int graph[][], int s, int t, int previous[]) {
        int vertice = graph.length;
        // Tao mang visit de danh dau cac phan tu da di qua
        boolean visit[] = new boolean[vertice];
        for (int i = 0; i < vertice; i++) {
            visit[i] = false;
        }

        // Tao mot arraylist queue chua dung phan tu da di qua
        ArrayList<Integer> q = new ArrayList<>();

        // Them gia tri s vao mang q
        q.add(s);
        visit[s] = true;
        previous[s] = -1;

        while (q.size() != 0) {
            // Lay phan tu dau tien cua mang gan vao x va xoa no di
            int x = q.get(0);
            q.remove(0);

            // Kiem tra duong di co ton tai tu s toi t hay khong
            for (int y = 0; y < vertice; y++) {
                if (graph[x][y] > 0 && visit[y] == false) {
                    // Neu ton tai duong di tu x den y ta them gia tri y vao mang q (q = {y})
                    q.add(y);
                    visit[y] = true;
                    previous[y] = x;
                }
            }
        }

        if (visit[t] == true)
            return true;
        else
            return false;
    }

    // Thuat toan duyet cay theo chieu sau
    public boolean[] dfs(int[][] graph, int s) {
        int vertice = graph.length;
        boolean visit[] = new boolean[vertice];
        for (int i = 0; i < vertice; i++) {
            visit[i] = false;
        }

        // Tao mot arraylist queue chua dung phan tu da di qua
        ArrayList<Integer> q = new ArrayList<>();

        // Them gia tri s vao mang q
        q.add(s);
        visit[s] = true;

        while (q.size() != 0) {
            // Lay phan tu dau tien cua mang gan vao x va xoa no di
            int x = q.get(0);
            q.remove(0);

            // Kiem tra duong di co ton tai tu s toi t hay khong
            for (int y = 0; y < vertice; y++) {
                if (graph[x][y] > 0 && visit[y] == false) {
                    // Neu ton tai duong di tu x den y ta them gia tri y vao mang q (q = {y})
                    q.add(y);
                    visit[y] = true;
                    break;
                }
            }
        }
        return visit;
    }

    public void display(int[][] graph, boolean[] visited) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && visited[i] == true && visited[j] == false) {
                    System.out.println(i + " -- " + j);
                }
            }
        }
    }

    public void minimum_cut(int graph[][], int s, int t) {
        int vertice = graph.length;
        int x, y;
        int previous[] = new int[vertice]; // Mang parent chua dung cac phan tu truoc do cua phan tu
                                           // dang xet den

        // Mang graph_1[][] se la mang sao chep cua mang graph[][]
        int graph_1[][] = new int[vertice][vertice];
        for (x = 0; x < vertice; x++)
            for (y = 0; y < vertice; y++)
                graph_1[x][y] = graph[x][y];

        // Tinh toan do thi graph_1 bang cach su dung thuat toan bfs
        while (bfs(graph_1, s, t, previous) == true) {
            int speed = 99999999; // Speed se mang gia tri la duong di co toc do ngan nhat

            // Tim kiem quang duong co toc do ngan nhat
            for (y = t; y != s;) {
                x = previous[y];
                if (graph_1[x][y] < speed)
                    speed = graph_1[x][y];
                y = x;
            }

            // Tru toc do cua duong di voi speed da xac dinh o tren
            // Cong toc do cua doung di nguoc lai voi speed
            for (y = t; y != s;) {
                x = previous[y];
                graph_1[x][y] = graph_1[x][y] - speed;
                graph_1[y][x] = graph_1[y][x] + speed;
                y = x;
            }
        }

        // Sau khi da duyet xong ta se su dung graph_1 de xac dinh cac canh co toc do bang 0
        boolean[] visited = dfs(graph_1, s);
        display(graph, visited);
    }

    public static void main(String[] args) {
        MinimumCut a = new MinimumCut();
        int x = 0;
        int graph[][] = new int[][] {{0, 3, 4, x, x, x}, {3, 0, x, 4, 2, x}, {4, x, 0, x, 5, x},
                {x, 4, x, 0, x, 1}, {x, 2, 5, x, 0, 6}, {x, x, x, x, x, 0}};
        a.minimum_cut(graph, 0, 5);

    }

}
