package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Æ©ÇÃ {
	
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{20,111},{111}}";
//		String s = "{{123}}";
		
		int[] answer = solution(s);
		for(int i : answer)
			System.out.print(i + " ");
	}

	private static int[] solution(String s) {
		s = s.substring(1, s.length()-1);
        s = s.substring(1, s.length()-1);
        s = s.replace("},{", "/");
        String[] arr = s.split("/");
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        // Arrays.sort(arr, Comparator.comparing(String::length));

        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        ArrayList<String> ansList = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            String[] temp = list.get(i).split(",");
            for(String c : temp) {
                if(!ansList.contains(c)) ansList.add(c);
            }
            
        }
        
        int index = 0;
        int[] answer = new int[ansList.size()];
        for(String k : ansList)
            answer[index++] = Integer.parseInt(k);
        
        return answer;
	}
	
	
}
