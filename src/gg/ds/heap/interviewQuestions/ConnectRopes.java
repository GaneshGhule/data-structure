package gg.ds.heap.interviewQuestions;

import gg.ds.heap.BinaryMinHeap;

//Connect n ropes with minimum cost
public class ConnectRopes {

    /**
     *
     * @param n number of ropes
     * @param lengths rope lengths
     * @return minimum cost to connect all ropes
     */
    public int getMinCost(int n, int lengths[]){

        BinaryMinHeap binaryMinHeap = new BinaryMinHeap(lengths);

        int cost = 0;
        while (binaryMinHeap.getSize() != 1){
            int smallest = binaryMinHeap.extractMin();
            int secondSmallest = binaryMinHeap.extractMin();

            cost += secondSmallest+ smallest;

            binaryMinHeap.add(secondSmallest+ smallest);
        }

        return cost;
    }

    public static void main(String[] args) {
        ConnectRopes connectRopes = new ConnectRopes();
        System.out.println(connectRopes.getMinCost(4, new int[]{4, 3, 2, 6 }));
    }
}
