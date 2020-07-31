package gg.ds.heap;

public class BinaryMaxHeap extends BinaryHeap {

    public BinaryMaxHeap(int capacity) {
      super(capacity);
    }

    public BinaryMaxHeap() {
        this(20);
    }

    public BinaryMaxHeap(int []elements) {
        super(elements);
    }


    public int getMax() {
       return getRoot();
    }

    public int extractMax() {
       return extract();
    }

    @Override
    protected void sink(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest = index;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            sink(largest);
        }
    }

    @Override
    protected void swim(int index) {
        while (index != 0 && this.heap[index] > heap[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public static void main(String[] args) {

        BinaryMaxHeap binaryMaxHeap = new BinaryMaxHeap();
        binaryMaxHeap.add(10);
        binaryMaxHeap.add(11);
        binaryMaxHeap.add(12);
        binaryMaxHeap.add(9);

        System.out.println("Max element :"+binaryMaxHeap.getMax());

        binaryMaxHeap.add(15);

        System.out.println("Max element :"+binaryMaxHeap.getMax());

        System.out.println("Size of heap "+binaryMaxHeap.getSize());

        System.out.println("Extract Max element :"+binaryMaxHeap.extractMax());

        System.out.println("Size of heap "+binaryMaxHeap.getSize()+" Max element: "+binaryMaxHeap.getMax());


        System.out.println("------------------Initialize heap with array-------------------------------");

        binaryMaxHeap = new BinaryMaxHeap(new int[]{10, 12, 5, 3, 2, 13, 14});

        System.out.println("Size of heap :"+binaryMaxHeap.getSize()+" Max element :"+binaryMaxHeap.getMax());

        binaryMaxHeap.print();
    }
}
