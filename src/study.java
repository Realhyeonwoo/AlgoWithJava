import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class study {
	public static void main(String[] args) {
		System.out.println("Stack");
		Stack<Integer> stk = new Stack<>();
		
		stk.push(7);
		stk.push(5);
		stk.push(4);
		stk.pop();
		
		System.out.println("TOP : " + stk.peek());
		System.out.println(stk.isEmpty());
		
		stk.push(1);
		System.out.println("5값 위치 : " + stk.search(5));
		System.out.println("값 포함 확인 : " + stk.contains(123));
		
		while(!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
		
		System.out.println();
		
		System.out.println("Queue");
		Queue<Integer> queue = new LinkedList<>();
		queue.add(7);
		queue.add(5);
		queue.add(4);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		queue.add(1);
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		queue.add(1);
		queue.add(2);
		System.out.println(queue);
		System.out.println(queue.remove(1));
		System.out.println(queue);
		queue.clear();
		System.out.println(queue);
	}
}