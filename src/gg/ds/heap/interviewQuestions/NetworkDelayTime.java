package gg.ds.heap.interviewQuestions;

import java.util.HashMap;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {

        //Build graph using adj list
        HashMap<Integer, HashMap<Integer, Integer>> adjNodes = new HashMap<>();
        for (int []t : times){
            adjNodes.putIfAbsent(t[0], new HashMap<>());
            adjNodes.get(t[0]).put(t[1], t[2]);
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //pair of distance, node
        queue.add(new Integer[]{0, k});

        boolean []visited = new boolean[n+1];
        int result = 0;

        while (!queue.isEmpty()){
            Integer[] node = queue.poll();

            if(visited[node[1]]){
                continue;
            }

            visited[node[1]] = true;

            result = node[0];

            if(!adjNodes.containsKey(node[1])){
                continue;
            }

            // Add adj nodes in queue with distance
            adjNodes.get(node[1]).forEach((adjNode, time) -> {
                queue.add(new Integer[]{node[0]+time, adjNode});
            });
        }
        return result;
    }

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();

        System.out.println(networkDelayTime.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4, 2));
    }
}
