package gg.ds.heap.interviewQuestions;

//Minimum Number of Refueling Stops

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumRefuelingStops {


    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        //No need to stop as initial fuel is sufficient
        if(startFuel >= target){
            return 0;
        }

        int distance = startFuel;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int station = 0;

        int stops = 0;

        while (distance < target){

            //find next gas station which have max fuel
            while (station < stations.length && stations[station][0] <= distance){
                queue.add(stations[station][1]);
                station++;
            }

            // no gas station found
            if(queue.isEmpty()){
                return -1;
            }

            //Update distance and stops
            distance += queue.poll();

            stops++;
        }

        return stops;
    }

    public static void main(String[] args) {
        MinimumRefuelingStops minimumRefuelingStops = new MinimumRefuelingStops();

        System.out.println(minimumRefuelingStops.minRefuelStops(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}));
    }
}
