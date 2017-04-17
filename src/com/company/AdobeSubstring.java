package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created by pratap on 11/16/16.
 */
public class AdobeSubstring {

    public static void main(String[] args){
        AdobeSubstring a = new AdobeSubstring();
        a.findSubstring("aeioujasdjsahdjashdjashdjahsdjkasdkaksdhasdhkasdbcdeauwerygewryewrewruhdfgfgdgfhgsdfgwiweriwerouopioipoklmslmkdfjhfurfbnvuerhfbuenv");
    }
    public void findSubstring(String s) {
        List<Character> vowels = "aeiou".chars().mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        List<Character> consonants = "bcdfghjklmnpqrstvwxyz".chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());

        PriorityQueue<String> minHeap = new PriorityQueue<>();
        PriorityQueue<String> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int length = s.length();

        for (int pass = 0; pass < length; pass++) {
            if (!vowels.contains(s.charAt(pass))) {
                continue;
            }
            for (int el = pass + 1; el < length; el++) {
                char current = s.charAt(el);
                if (!consonants.contains(current)) {
                    continue;
                }
                String str = s.substring(pass, el + 1);
                minHeap.add(str);
                maxHeap.add(str);
            }
        }
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());
    }
}
