package gg.ds.graph.interviewQuestions;

import java.util.*;

//Parallel Courses
public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        int[] indegree = new int[n + 1];

        //create adjList and indegree array
        for (int[] relation : relations) {
            indegree[relation[1]]++;
            adjList.putIfAbsent(relation[0], new ArrayList<>());
            adjList.get(relation[0]).add(relation[1]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //in-degree is 0 means course can start without any pre-requisite
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
            adjList.putIfAbsent(i, new ArrayList<>());
        }

        int semesters = 0;

        int nodeCount = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            nodeCount += size;

            while (size-- > 0) {
                int node = queue.poll();
                for (Integer adjNode : adjList.get(node)) {
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 0) {
                        queue.add(adjNode);
                    }
                }
            }
            semesters++;
        }

        //if node count is not equal node size then there is cycle or course schedule not possible
        return n == nodeCount ? semesters : -1;
    }

    public static void main(String[] args) {
        ParallelCourses parallelCourses = new ParallelCourses();
        System.out.println(parallelCourses.minimumSemesters(3, new int[][]{{1, 3}, {2, 3}, {3, 2}}));
    }
}
