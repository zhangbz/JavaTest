public class BubbleSortTest {
	//冒泡排序
	public static void bubbleSort(int[] source) {
		//外层循环控制控制遍历次数，n个数排序，遍历n - 1次
		for (int i = source.length - 1; i > 0; i--) {
			//每完成一趟遍历，下标为i的位置的元素被确定，下一遍历不再参与比较
			for (int j = 0; j < i; j++) {
				if (source[j] > source[j + 1]) {
					swap(source, j, j + 1);
				}
			}
		}
	}
	//private 完成交换功能的子函数
	private static  void swap(int[] source, int x, int y) {
		int temp = source[x];
		source[x] = source[y];
		source[y] = temp;
	}
	//在main中测试
	public static void main(String[] args) {
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
		
		bubbleSort(a);
		//局部变量要初始化
		for (int i = 0; i < a.length; i++) {
			//利用printf进行格式化输出
			System.out.printf("%d ",a[i]);
		}
	}
}