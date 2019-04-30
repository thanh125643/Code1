import java.util.ArrayList;

public class MaximumCut {
    public MaximumCut() {

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
            q.remove(0); // q = {}

            // Kiem tra duong di co ton tai tu s toi t hay khong
            for (int y = 0; y < vertice; y++) {
                if (graph[x][y] > 0 && visit[y] == false) {
                    // Neu co ton tai duong di tu x den y ta them gia tri y vao mang q (q = {y})
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

    public int maximum_cut(int graph[][], int s, int t) {
        int vertice = graph.length;
        int x, y;
        int maxcut_speed = 0;
        int previous[] = new int[vertice]; // Mang parent chua dung cac phan tu truoc do cua phan tu
                                           // dang xet den

        // Mang graph_1[][] se la mang sao chep cua mang graph[][]
        int graph_1[][] = new int[vertice][vertice];
        for (x = 0; x < vertice; x++)
            for (y = 0; y < vertice; y++)
                graph_1[x][y] = graph[x][y];

        // Bat dau tinh toan gia tri maxcut_speed khi duong di tu s den t co ton tai
        while (bfs(graph_1, s, t, previous) == true) {
            int speed = 99999999; // Speed se mang gia tri la duong di co toc do ngan nhat

            // Tim kiem quang duong co toc do ngan nhat
            for (y = t; y != s;) {
                x = previous[y];
                if (graph_1[x][y] < speed)
                    speed = graph_1[x][y];
                y = x;
            }

            // Them dan gia tri cua bien speed vao bien maxcut_speed
            maxcut_speed = maxcut_speed + speed;

            // Tru toc do cua duong di voi speed da xac dinh o tren
            // Cong toc do cua doung di nguoc lai voi speed
            for (y = t; y != s;) {
                x = previous[y];
                graph_1[x][y] = graph_1[x][y] - speed;
                graph_1[y][x] = graph_1[y][x] + speed;
                y = x;
            }
        }
        return maxcut_speed;
    }

    public static void main(String[] args) {
        MaximumCut a = new MaximumCut();
        int x = 0;
        int graph[][] = new int[][] {{0, 3, 4, x, x, x}, {3, 0, x, 4, 2, x}, {4, x, 0, x, 5, x},
                {x, 4, x, 0, x, 1}, {x, 2, 5, x, 0, 6}, {x, x, x, x, x, 0}};
        System.out.print("Maximun flow in network: " + a.maximum_cut(graph, 0, 5));
    }

}
