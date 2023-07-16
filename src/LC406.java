import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC406 {
    public static void main(String[] args) {
        LC406 lc406 = new LC406();
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        for (int i = 0; i < people.length; i++) {

            System.out.println(people[i][0]+ "," + people[i][1]);
        }
        System.out.println("============");
        int[][] res = lc406.reconstructQueue(people);
        for (int i = 0; i < res.length; i++) {

            System.out.println(res[i][0]+ "," + res[i][1]);
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i][0]+ "," +people[i][1]);
        }
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);

        }
        for (int i = 0; i < que.size(); i++) {

            System.out.println(que.get(i));
            System.out.println("============");
        }
        return que.toArray(new int[people.length][]);
    }
    public int[][] reconstructQueue11(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }
}
