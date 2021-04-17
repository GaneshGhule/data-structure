package gg.ds.graph.interviewQuestions;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {

        HashSet<Character> charSet = new HashSet<>();

        HashMap<Character, HashSet<Character>> adjList = new HashMap<>();

        HashMap<Character, Integer> inDegree = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            int j = i - 1;

            int k = 0;

            while (k < words[j].length() && k < words[i].length()) {

                Character parent = words[j].charAt(k);

                Character child = words[i].charAt(k);

                charSet.add(parent);

                charSet.add(child);

                inDegree.putIfAbsent(parent, 0);

                inDegree.putIfAbsent(child, 0);

                if (parent != child) {

                    adjList.putIfAbsent(parent, new HashSet<>());

                    adjList.get(parent).add(child);

                    inDegree.putIfAbsent(parent, 0);

                    inDegree.put(child, inDegree.getOrDefault(child, 0)+1);

                    break;
                }
                k++;
            }
        }

        ArrayDeque<Character> queue = new ArrayDeque<>();

        inDegree.forEach((key, value) -> {
            if(value == 0){
                queue.add(key);
            }
        });

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            Character ch = queue.poll();
            sb.append(ch);

            for (Character adjCh : adjList.getOrDefault(ch, new HashSet<>())){
                inDegree.put(adjCh, inDegree.get(adjCh) - 1);
                if(inDegree.get(adjCh) == 0){
                    queue.add(adjCh);
                }
            }
        }


        return  charSet.size() == sb.length() ?  sb.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(alienDictionary.alienOrder(new String[]{"z", "x"}));
        System.out.println(alienDictionary.alienOrder(new String[]{"z", "x", "z"}));
    }
}
