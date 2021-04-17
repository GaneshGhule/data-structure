package gg.ds.priorityQueue;

import java.util.NoSuchElementException;

public class IndexPriorityQueue<T extends Comparable> {

    //position map,    key -> position
    private int[] pm;

    //invert position map,  position -> key
    private int[] im;

    // values associated with keys,  key -> value
    private Object[] values;

    //heap size
    private int size;

    //heap capacity
    private int capacity;

    public IndexPriorityQueue(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.values = new Object[capacity];
        this.im = new int[capacity];
        this.pm = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            im[i] = pm[i] = -1;
        }
    }


    /**
     * Add value in heap
     * @param key
     * @param value
     */
    public void add(int key, T value) {

        if (value == null)
            throw new IllegalArgumentException("value cannot be null");

        pm[key] = size;
        im[size] = key;
        values[key] = value;

        swim(size++);
    }

    /**
     * Check key exists in heap
     * @param key
     * @return
     */
    public boolean contains(int key) {
        if (key < 0 || key >= capacity)
            throw new IllegalArgumentException("Key index out of bounds; Key: " + key);
        return pm[key] != -1;
    }

    /**
     * Update value of given key
     * @param key
     * @param value
     */
    public void update(int key, Object value) {
        if (!contains(key))
            throw new NoSuchElementException("Index does not exist; Key: " + key);

        if (value == null)
            throw new IllegalArgumentException("value cannot be null");

        int index = pm[key];
        values[key] = value;
        swim(index);
        sink(index);
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void swim(int index) {
        int parent = getParent(index);

        while (index != 0 && lessThan(index, parent)) {
            swap(index, parent);
            index = parent;
            parent = getParent(index);
        }
    }

    private void sink(int index){
        int smallest = index;
        int left = getLeft(index);
        int right = getRight(index);
        if(left < capacity && im[left] != -1 && lessThan(left, smallest)){
            smallest = left;
        }
        if(right < capacity && im[right] != -1 && lessThan(right, smallest)){
            smallest = right;
        }

        if(smallest != index){
            swap(smallest, index);
            sink(smallest);
        }
    }

    private void swap(int i, int j) {
        pm[im[j]] = i;
        pm[im[i]] = j;

        int temp = im[i];
        im[i] = im[j];
        im[j] = temp;
    }

    @SuppressWarnings("unchecked")
    private boolean lessThan(int i, int j) {
        return ((T) values[im[i]]).compareTo((T) values[im[j]]) < 0;
    }

    public void print() {

        System.out.println();
        System.out.println("Index");


        for (int i = 0; i < capacity; i++) {
            System.out.print(i + "   ");
        }

        System.out.println();
        System.out.println("Position Map");


        for (int i = 0; i < capacity; i++) {
            System.out.print(pm[i] + "   ");
        }

        System.out.println();
        System.out.println("Inverse Position Map");

        for (int i = 0; i < capacity; i++) {
            System.out.print(im[i] + "   ");
        }

        System.out.println();
        System.out.println("Values");

        for (int i = 0; i < capacity; i++) {
            System.out.print(values[i] + "   ");
        }

    }

    public static void main(String[] args) {
        IndexPriorityQueue<Integer> priorityQueue = new IndexPriorityQueue<>(5);

        priorityQueue.add(1, 34);
        priorityQueue.add(4, 20);
        priorityQueue.add(2, 45);
        priorityQueue.add(3, 60);
        priorityQueue.add(0, 67);

        priorityQueue.print();

        priorityQueue.update(1, 78);

        priorityQueue.print();
    }
}
