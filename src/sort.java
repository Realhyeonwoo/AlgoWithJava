import java.util.Arrays;

public class sort {
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
		System.out.println("계수 정렬");
		int MAX = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (MAX < arr[i])
				MAX = arr[i];
		}
		int[] tempArr = new int[MAX + 1];
		Arrays.fill(tempArr, 0);

		for (int i = 0; i < arr.length; i++) {
			tempArr[arr[i]]++;
		}

		int j = 0;
		for (int i = 0; i < tempArr.length; i++) {
			while (tempArr[i] > 0) {
				arr[j++] = i;
				tempArr[i]--;
			}
		}
		for (int v : arr)
			System.out.print(v + " ");
	}

	private static void heapSort(int[] arr) {
		System.out.println("힙정렬");
		for (int v : arr)
			System.out.print(v + " ");
		System.out.println();

		int temp;
		for (int i = 1; i < arr.length; i++) {
			int node = i;
			do {
				int root = (node - 1) / 2;

				if (arr[root] < arr[node]) {
					temp = arr[root];
					arr[root] = arr[node];
					arr[node] = temp;
				}

				node = root;
			} while (node != 0);
		}

		System.out.println("힙트리 만들기");
		for (int v : arr)
			System.out.print(v + " ");
		System.out.println();

		for (int i = arr.length - 1; i >= 0; i--) {
			temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			int root = 0;
			int node;
			do {
				node = 2 * root + 1;

				if (node < i - 1 && arr[node] < arr[node + 1])
					node++;

				if (node < i && arr[root] < arr[node]) {
					temp = arr[root];
					arr[root] = arr[node];
					arr[node] = temp;
				}

				root = node;
			} while (node < i);
		}
		System.out.println("정렬");
		for (int v : arr)
			System.out.print(v + " ");
		System.out.println();
	}

	private static void mergeSort(int[] arr) {
		System.out.println("병합정렬");

		doSplit(arr, 0, arr.length - 1);
		for (int v : arr)
			System.out.print(v + " ");
		System.out.println();
	}

	private static void doSplit(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int middle = (start + end) / 2;

		doSplit(arr, start, middle);
		doSplit(arr, middle + 1, end);
		doMerge(arr, start, middle, end);
	}

	private static void doMerge(int[] arr, int i, int middle, int j) {
		int idx1 = i;
		int idx2 = middle + 1;
		int idx = i;

		while (idx1 <= middle && idx2 <= j) {
			temp[idx++] = (arr[idx1] <= arr[idx2]) ? arr[idx1++] : arr[idx2++];
		}

		if (idx1 > middle) {
			for (int t = idx2; t <= j; t++) {
				temp[idx++] = arr[t];
			}
		} else {
			for (int t = idx1; t <= middle; t++)
				temp[idx++] = arr[t];
		}

		for (int t = i; t <= j; t++)
			arr[t] = temp[t];
	}

	private static void quickSort(int[] arr) {
		System.out.println("퀵정렬");

		doQuick(arr, 0, arr.length - 1);

		printArr(arr);
	}

	private static void doQuick(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int pivot = start;
		int i = start + 1;
		int j = end;
		int temp;

		while (i <= j) {
			while (i <= end && arr[i] <= arr[pivot])
				i++;
			while (start < j && arr[pivot] <= arr[j])
				j--;

			swap(arr, (i <= j) ? i : pivot, j);
		}

		doQuick(arr, start, j - 1);
		doQuick(arr, j + 1, end);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void insertSort(int[] arr) {
		System.out.println("삽입정렬");

		for (int i = 0; i < arr.length; i++) {
			int idx = i;
			while ((idx > 0) && (arr[idx - 1] > arr[idx])) {
				int temp = arr[idx - 1];
				arr[idx - 1] = arr[idx];
				arr[idx] = temp;
				idx--;
			}
		}

		printArr(arr);
	}

	private static void bubbleSort(int[] arr) {
		System.out.println("버블정렬");

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		printArr(arr);
	}

	private static void selectedSort(int[] arr) {
		System.out.println("선택정렬");

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			int minValue = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (minValue > arr[j]) {
					minIndex = j;
					minValue = arr[j];
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		printArr(arr);
	}

	private static void printArr(int[] arr) {
		for (int v : arr)
			System.out.print(v + " ");
		System.out.println();
	}
}
