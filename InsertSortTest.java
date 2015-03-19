public class InsertSortTest{
	public static void InsertSort(int[] source) {
		//Ĭ�ϵ�һ��Ԫ��������
		for (int i = 1; i < source.length; i++) {
			for (int j = i; (j > 0) && (source[j] < source[j - 1]); j--) {
				swap(source, j, j - 1);
			}
		}
	}
	//��ɽ������ܵ��Ӻ��� static 
	private static void swap(int[] source, int x, int y) {
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	//��main�в���
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
		
		InsertSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
	}
}