package gg.ds.disjointSet.interviewQuestions;

import gg.ds.disjointSet.DisjointSet;

import java.util.Arrays;

//The Earliest Moment When Everyone Become Friends
public class EarliestMoment {

    public int earliestMoment(int[][] logs, int n) {

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        DisjointSet disjointSet = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            disjointSet.union(logs[i][1], logs[i][2]);
            if (disjointSet.getComponents() == 1) {
                return logs[i][0];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        EarliestMoment earliestMoment = new EarliestMoment();
        int time = earliestMoment.earliestMoment(new int[][]{
                        {20190101, 0, 1},
                        {20190104, 3, 4},
                        {20190107, 2, 3},
                        {20190211, 1, 5},
                        {20190224, 2, 4},
                        {20190301, 0, 3},
                        {20190312, 1, 2},
                        {20190322, 4, 5}},
                6
        );

        System.out.println(time);

        String a = new String("A");
        String b = new String("A");
        System.out.println(a.hashCode()==b.hashCode());
    }
}
