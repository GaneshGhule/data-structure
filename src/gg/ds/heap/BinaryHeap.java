package gg.ds.heap;

public abstract class BinaryHeap {

    protected int[] heap;
    protected int size;
    protected int capacity;

    public BinaryHeap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public BinaryHeap() {
        this(20);
    }

    public BinaryHeap(int[] elements) {
        this.heap = elements;
        this.capacity = elements.length;
        this.size = elements.length;

        for (int index = (size / 2) - 1; index >= 0; index--) {
            sink(index);
        }
    }

    protected int getParent(int index) {
        if (index <= 0) {
            return 0;
        }
        return (index - 1) / 2;
    }

    protected int getLeft(int index) {
        return 2 * index + 1;
    }

    protected int getRight(int index) {
        return 2 * index + 2;
    }

    protected void swap(int indexA, int indexB) {
        int temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }


    protected int extract() {
        if (size <= 0) {
            return -1;
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);
        return root;
    }

    protected int getRoot() {
        if (size <= 0) {
            return -1;
        }
        return heap[0];
    }

    protected void print() {
        for (int i = 0; i < (size / 2); i++) {
            int parent = heap[getParent(i)];
            int left = heap[getLeft(i)];
            int right = heap[getRight(i)];

            System.out.println("Element : " + heap[i] + " Parent : " + parent + " Left : " + left + " Right : " + right);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }


    public void add(int element) {
        if (size >= capacity) {
            throw new RuntimeException("Heap size exceeds capacity");
        }
        heap[size] = element;
        size++;
        swim(size - 1);
    }

    protected abstract void sink(int index);

    protected abstract void swim(int index);

}
