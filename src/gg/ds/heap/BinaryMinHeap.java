package gg.ds.heap;


public class BinaryMinHeap extends BinaryHeap{


    public BinaryMinHeap(int capacity) {
        super(capacity);
    }

    public BinaryMinHeap() {
        this(20);
    }

    public BinaryMinHeap(int []elements) {
        super(elements);
    }

    @Override
    protected void swim(int index) {
        while (index != 0 && this.heap[index] < heap[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    @Override
    protected void sink(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            sink(smallest);
        }
    }


    public int extractMin() {
        return extract();
    }

    public int getMin() {
        return getRoot();
    }

    public static void main(String[] args) {
        BinaryMinHeap binaryMinHeap = new BinaryMinHeap();
        binaryMinHeap.add(10);
        binaryMinHeap.add(11);
        binaryMinHeap.add(12);
        binaryMinHeap.add(9);

        System.out.println("Min element :"+binaryMinHeap.getMin());

        binaryMinHeap.add(5);

        System.out.println("Min element :"+binaryMinHeap.getMin());

        System.out.println("Size of heap "+binaryMinHeap.getSize());

        System.out.println("Extract Min element :"+binaryMinHeap.extractMin());

        System.out.println("Size of heap "+binaryMinHeap.getSize()+" Min element: "+binaryMinHeap.getMin());


        System.out.println("------------------Initialize heap with array-------------------------------");

        binaryMinHeap = new BinaryMinHeap(new int[]{10, 12, 5, 3, 2, 13, 14});

        System.out.println("Size of heap :"+binaryMinHeap.getSize()+" Min element :"+binaryMinHeap.getMin());

        binaryMinHeap.print();
    }
}