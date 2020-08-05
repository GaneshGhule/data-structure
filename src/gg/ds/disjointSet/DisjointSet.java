package gg.ds.disjointSet;

public class DisjointSet {

    private int [] parent;
    private int [] rank;
    private int components;


    public DisjointSet(int size){
        this.components = size;
        this.parent = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size ; i++) {
            this.parent[i] = i;
        }
    }

    public int find(int index){
        while (index != parent[index]){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }

        return parent[index];
    }

    public boolean union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot){
            return false;
        }

        if(rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot;
        }else if(rank[yRoot] > rank[xRoot]){
            parent[xRoot] = yRoot;
        }else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }

        components--;

        return true;
    }

    public int getComponents(){
        return components;
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(5);
        disjointSet.union(0, 1);
        disjointSet.union(2, 3);
        disjointSet.union(1, 4);


        System.out.println(disjointSet.getComponents());
    }
}
