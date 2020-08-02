package gg.ds.heap.interviewQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySorted {

    public int[] sort(int arr[], int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1);

        //Add k+1 elements in min heap
        int i = 0;
        while (i < k+1){
            queue.add(arr[i]);
            i++;
        }

        //Set element at correct position and add next element in min heap
        int index = 0;
        for (i = k+1; i < arr.length; i++) {
            arr[index] = queue.poll();
            queue.add(arr[i]);
            index++;
        }

        //Set remaining elements
        while (!queue.isEmpty()){
            arr[index++] = queue.poll();
        }

        //print elements
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j]+" ");
        }

        return arr;
    }

    public static void main(String[] args) {
        NearlySorted nearlySorted = new NearlySorted();

        nearlySorted.sort(new int[]{6, 5, 3, 2, 8, 10, 9}, 3);
    }
}
