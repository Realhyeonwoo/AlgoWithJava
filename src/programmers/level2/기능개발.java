package programmers.level2;

import java.util.ArrayList;

public class 기능개발 {
	public static void main(String[] args) {
		
	}
	
    public int[] solution(int[] progresses, int[] speeds) {
        //�궓�� �씪�닔 援ы븯湲�
        int[] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
            for(int d=1; d<100; d++) {
                if((100 - progresses[i]) <= speeds[i] * d) {
                    days[i] = d;
                    break;
                }
            }
        }
        //�궓�� �씪�닔 理쒕뙎媛믪씠 諛붾�붾븣源뚯� 紐⑥븘�꽌 諛고룷
        ArrayList<Integer> outputList = new ArrayList<>();
        int idx = 0;
        while(idx < days.length) {
            int maxDay = days[idx];
            int cnt = 1;
            if(idx + 1 == days.length) {
                outputList.add(1);
                break;
            }
            for(int j=idx+1; j<days.length; j++) {
                if(maxDay < days[j]) {
                    outputList.add(cnt);
                    maxDay = days[j];
                    idx = j;
                    break;
                } else if(j == days.length-1) {
                    outputList.add(cnt+1);
                    idx = days.length;
                } else {        
                    cnt++;
                }
            }
        }
        // 寃곌낵 由ы꽩 
        int[] answer = new int[outputList.size()];
        for(int i=0; i<answer.length; i++) 
            answer[i] = outputList.get(i);
        return answer;
    }
}
