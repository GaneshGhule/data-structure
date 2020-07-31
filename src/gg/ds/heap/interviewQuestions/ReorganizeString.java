package gg.ds.heap.interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String str) {
        HashMap<Character, Integer>  freqMap = new HashMap<>();
        for(Character c : str.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        Map.Entry<Character, Integer> max = null;

        for (Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
            if(max == null){
                max = entry;
            }else if(max.getValue() < entry.getValue()){
                max = entry;
            }
        }
        if(max.getValue() > (str.length()+1)/2){
            return "";
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((entryA, entryB) -> entryB.getValue() - entryA.getValue());
        queue.addAll(freqMap.entrySet());

        char []result = new char[str.length()];
        int index = 0;

        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> entry = queue.poll();
            int count = entry.getValue();
            while (count-- > 0){
                result[index] = entry.getKey();
                index += 2;
                if(index >= str.length()){
                    index = 1;
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();

        System.out.println(reorganizeString.reorganizeString("AAABBCC"));

        System.out.println("Empty: "+reorganizeString.reorganizeString("AAAB").isEmpty());
    }
}
