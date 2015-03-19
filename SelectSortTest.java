public class SelectSortTest {
	public static void selectSort(int[] source) {
		for (int i = 0; i < source.length; i++) {
			for (int j = i + 1; j < source.length; j++) {
				if (source[i] > source[j]) {
					swap(source, i, j);
				}
			}
		}
	}
	//private ��ɽ������ܵ��Ӻ���
	private static void swap(int[] source, int x, int y) {
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	//��main�в���
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
		
		selectSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
}