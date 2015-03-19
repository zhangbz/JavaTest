public class BubbleSortTest {
	//ð������
	public static void bubbleSort(int[] source) {
		//���ѭ�����ƿ��Ʊ���������n�������򣬱���n - 1��
		for (int i = source.length - 1; i > 0; i--) {
			//ÿ���һ�˱������±�Ϊi��λ�õ�Ԫ�ر�ȷ������һ�������ٲ���Ƚ�
			for (int j = 0; j < i; j++) {
				if (source[j] > source[j + 1]) {
					swap(source, j, j + 1);
				}
			}
		}
	}
	//private ��ɽ������ܵ��Ӻ���
	private static  void swap(int[] source, int x, int y) {
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	//��main�в���
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
		
		bubbleSort(a);
		//�ֲ�����Ҫ��ʼ��
		for (int i = 0; i < a.length; i++) {
			//����printf���и�ʽ�����
			System.out.printf("%d ",a[i]);
		}
	}
}