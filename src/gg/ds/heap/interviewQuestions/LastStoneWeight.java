package gg.ds.heap.interviewQuestions;

import gg.ds.heap.BinaryMaxHeap;

//Last Stone Weight
public class LastStoneWeight {

    public int getLastStoneWeight(int[] stones) {
        BinaryMaxHeap maxHeap = new BinaryMaxHeap(stones);
        while(maxHeap.getSize() > 1){
            int y = maxHeap.extractMax();
            int x = maxHeap.extractMax();
            if(x != y){
                maxHeap.add(y-x);
            }
        }
        return maxHeap.getSize() == 1 ? maxHeap.getMax() : 0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.getLastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
