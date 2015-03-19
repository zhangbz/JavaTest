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
	//private 完成交换功能的子函数
	private static void swap(int[] source, int x, int y) {
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	//在main中测试
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
		
		selectSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
}