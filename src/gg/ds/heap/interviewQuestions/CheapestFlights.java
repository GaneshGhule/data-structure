package gg.ds.heap.interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Cheapest Flights Within K Stops
public class CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer, HashMap<Integer, Integer>> prices = new HashMap<>();

        for (int[] f : flights) {
            prices.putIfAbsent(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((nodeA, nodeB) -> nodeA.price - nodeB.price);

        //Tuple of (Price, city, stops)
        queue.add(new Node(0, src, k+1));

        while (!queue.isEmpty()) {
          Node node = queue.poll();
          if(node.city == dst){
              return node.price;
          }

          if(node.stops > 0){
              Map<Integer, Integer> adj = prices.getOrDefault(node.city, new HashMap<>());
              adj.forEach((city, price) -> {
                  queue.add(new Node(node.price+price, city, node.stops - 1));
              });
          }
        }

        return -1;
    }

    class Node {
        int price;
        int city;
        int stops;


        Node(int price, int city, int stops){
            this.city = city;
            this.price = price;
            this.stops = stops;
        }

        @Override
        public String toString() {
            return "City : "+city+" Price: "+price+" Stops: "+stops;
        }
    }

    public static void main(String[] args) {
        CheapestFlights cheapestFlights = new CheapestFlights();

        System.out.println(cheapestFlights.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0, 2, 1));
    }
}
