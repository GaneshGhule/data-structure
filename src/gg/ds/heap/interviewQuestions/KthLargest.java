package gg.ds.heap.interviewQuestions;

import gg.ds.heap.BinaryMinHeap;

import java.util.Scanner;

//  K’th largest element in a stream
class KthLargest {

    private int k;
    private BinaryMinHeap minHeap;

    public KthLargest(int k){
        this.k = k;
        minHeap = new BinaryMinHeap(k);
    }

    protected int add(int val) {
        if(minHeap.getSize() < k){
            minHeap.add(val);
        }else if(val > minHeap.getMin()){
            minHeap.extractMin();
            minHeap.add(val);
        }
        return minHeap.getMin();
    }

    public int getKthLargest(){
        if(minHeap.getSize() < k){
            return -1;
        }
        return minHeap.getMin();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        KthLargest kthLargest = new KthLargest(3);

        while (true){
            System.out.println("Enter next number ");
            int number = scanner.nextInt();
            kthLargest.add(number);
            System.out.println(" KthLargest :"+kthLargest.getKthLargest());
        }
    }
}

