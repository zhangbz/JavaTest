public class QuickSortTest{
	private static int partition(int[] source, int low, int hight) {
		int key = source[low];
		while (low < hight) {
			while (low < hight && source[hight] >= key) {
				hight --;
			}
			source[low] = source[hight];
			while (low < hight && source[low] <= key) {
				low ++;
			}
			source[hight] = source[low];
		}
		source[low] = key;
		return low;
	}
	public static void quickSort(int[] source, int low, int hight) {
		if (low < hight) {
			int result = partition(source, low, hight);
			quickSort(source, 0, result - 1);
			quickSort(source, result + 1, hight);
		}
	}
	public static void main(String[] args) {
		int[] a = {44,22,2,32,54,22,88,77,99,11};
		
		quickSort(a, 0, a.length - 1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
}