import java.util.Arrays;

public class sortTemp {
	static int[] temp = new int[6];

	public static void main(String[] args) {
		int[] arr1 = { 6, 5, 4, 3, 1, 2 };
		int[] arr2 = { 6, 5, 4, 3, 1, 2 };
		int[] arr3 = { 6, 5, 4, 3, 1, 2 };
//		int[] arr4 = { 4, 2, 3, 6, 5, 1 };
		int[] arr4 = { 6, 5, 4, 3, 1, 2 };
		int[] arr5 = { 6, 5, 4, 3, 1, 2 };
		int[] arr6 = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
		int[] arr7 = { 1, 4, 3, 2, 6, 123, 11, 32, 4, 6, 34 };
		
		selectedSort(arr1);
		bubbleSort(arr2);
		insertSort(arr3);
		quickSort(arr4);
		mergeSort(arr5);
		heapSort(arr6);
		countingSort(arr7);
	}

	
	private static void countingSort(int[] arr) {
		System.out.println("countingSort");
		int SIZE = Integer.MIN_VALUE;
		for(int v : arr) {
			if(SIZE < v) SIZE = v;
		}
		int[] tempArr = new int[SIZE+1];
		Arrays.fill(tempArr, 0);
		
		for(int v : arr) {
			tempArr[v]++;
		}
		
		int idx = 0;
		for(int i=0; i<tempArr.length; i++) {
			for(int j=0; j<tempArr[i]; j++) {
				arr[idx++] = i;
			}
		}
		printArr(arr);
	}


	private static void heapSort(int[] arr) {
		System.out.println("heapSort");
		System.out.print("Heapify : ");
		int temp;
		for(int i=1; i<arr.length; i++) {
			int node = i;
			do {
				int root = (node - 1) / 2;
				if(arr[root] < arr[node]) {
					temp = arr[root];
					arr[root] = arr[node];
					arr[node] = temp;
				}
				node = root;
			} while(node != 0);
		}
		printArr(arr);
		
		for(int i=arr.length-1; i>0; i--) {
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			int root = 0;
			int node = 1;
			do {
				node = root * 2 + 1;
				if(node < i-1 && arr[node] < arr[node+1]) node++;
				if(node < i && arr[node] > arr[root]) {
					temp = arr[root];
					arr[root] = arr[node];
					arr[node] = temp;
				}
				root = node;
			} while(node < i);
		}
		printArr(arr);
	}


	private static void mergeSort(int[] arr) {
		System.out.println("mergeSort");
		int[] tempArr = new int[arr.length];
		doSplit(arr, 0, arr.length-1, tempArr);
		printArr(arr);
	}


	private static void doSplit(int[] arr, int start, int end, int[] tempArr) {
		if(start >= end) return;
		
		int middle = (start + end) / 2;
		doSplit(arr, start, middle, tempArr);
		doSplit(arr, middle+1, end, tempArr);
		doMerge(arr, start, middle, end, tempArr);
	}


	private static void doMerge(int[] arr, int start, int middle, int end, int[] tempArr) {
		int i = start;
		int j = middle + 1;
		int idx = start;
		
		while(i<=middle && j<=end) {
			tempArr[idx++] = (arr[i] < arr[j]) ? arr[i++] : arr[j++];
		}
		
		if(i<=middle && j>end) {
			while(i<=middle) tempArr[idx++] = arr[i++];
		}
		
		if(i>middle && j<=end) {
			while(j<=end) tempArr[idx++] = arr[j++];
		}
		for(int k=start; k<=end; k++) {
			arr[k] = tempArr[k];
		}
	}


	private static void quickSort(int[] arr) {
		System.out.println("quickSort");
		doQuick(arr, 0, arr.length-1);
		printArr(arr);
	}
	
	private static void doQuick(int[] arr, int start, int end) {
		if(start >= end) return;
		
		int pivot = start;
		int i = start + 1;
		int j = end;
		int temp;
		while(i < j) {
			while(i<=end && arr[i] <= arr[pivot]) i++;
			while(start<j && arr[pivot] <= arr[j]) j--;
			
			if(i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			} else {
				temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;
			}
		}
		
		doQuick(arr, start, j-1);
		doQuick(arr, j+1, end);
	}


	private static void insertSort(int[] arr) {
		System.out.println("insertSort");
		int temp;
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0; j--) {
				if(arr[j-1] <= arr[j]) break;
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
		}
		printArr(arr);
	}


	private static void bubbleSort(int[] arr) {
		System.out.println("bubbleSort");
		int temp;
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		printArr(arr);
	}


	private static void selectedSort(int[] arr) {
		System.out.println("selectedSort");
		int temp;
		for(int i=0; i<arr.length; i++) {
			int minValue = arr[i];
			int minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < minValue) {
					minValue = arr[j];
					minIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		printArr(arr);
	}


	private static void printArr(int[] arr) {
		for (int v : arr)
			System.out.print(v + " ");
		System.out.println();
	}
}
