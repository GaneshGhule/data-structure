package gg.ds.disjointSet.interviewQuestions;

import gg.ds.disjointSet.DisjointSet;

//Regions Cut By Slashes
public class RegionsCutBySlashes {

    private int length;

    public int regionsBySlashes(String[] grid) {
        length = grid.length;

        DisjointSet disjointSet = new DisjointSet(4 * length * length);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char c = grid[i].charAt(j);

                //connect top cell
                if (i > 0) {
                    disjointSet.union(getIndex(i - 1, j, 2), getIndex(i, j, 0));
                }

                //connect left cell
                if (j > 0) {
                    disjointSet.union(getIndex(i, j - 1, 1), getIndex(i, j, 3));
                }

                //for ' ' it will connect all four nodes
                //for '/' it will connect 0 & 3 , 1 & 2
                //for '\\' it will connect 0 & 1 , 2 & 3

                if (c != '/') {
                    disjointSet.union(getIndex(i, j, 0), getIndex(i, j, 1));
                    disjointSet.union(getIndex(i, j, 2), getIndex(i, j, 3));
                }

                if (c != '\\') {
                    disjointSet.union(getIndex(i, j, 0), getIndex(i, j, 3));
                    disjointSet.union(getIndex(i, j, 1), getIndex(i, j, 2));
                }
            }
        }

        //return connected components size
        return disjointSet.getComponents();
    }

    // index in 1-D  array
    private int getIndex(int i, int j, int k) {
        return (i * length + j) * 4 + k;
    }

    public static void main(String[] args) {
        RegionsCutBySlashes regionsCutBySlashes = new RegionsCutBySlashes();
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{" /", "  "}));
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{"\\/", "/\\"}));
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{"/\\", "\\/"}));
        System.out.println(regionsCutBySlashes.regionsBySlashes(new String[]{"//", "/ "}));
    }
}
