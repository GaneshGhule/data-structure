package gg.ds.heap;

public class HeapSort {


    private int getLeft(int index){
        return 2*index+1;
    }

    private int getRight(int index){
        return 2*index+2;
    }

    private void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapify(int[] arr, int start, int end) {

        int largest = start;
        int left = getLeft(start);
        int right = getRight(start);

        if(left < end && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < end && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != start){
            swap(arr, start, largest);
            heapify(arr, largest, end);
        }
    }

    private void replaceRoot(int arr[], int end){
        if(end <= 0){
            return;
        }
        int temp = arr[0];
        arr[0] = arr[end];
        arr[end] = temp;
    }

    public int[] sort(int[] arr) {

        // Create heap
        int mid = arr.length/2;
        while (mid >= 0){
            heapify(arr, mid, arr.length );
            mid--;
        }

        //replace heap root and heapify array elements
        int end = arr.length - 1;
        for (int i = 0; i < arr.length ; i++) {
            replaceRoot(arr, end);
            heapify(arr, 0, --end);
        }

        //print array
        for (int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(new int[]{5, 10, 12, 13, 3, 4, 7, 8, 20, 6});
    }
}
