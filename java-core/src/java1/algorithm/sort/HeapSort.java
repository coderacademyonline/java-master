package java1.algorithm.sort;

/**
 * 堆排序
 * @author zhaojw
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long[] nums=new long[10];
		for (int i = 0; i < 10; i++) {
			nums[i]=(long) (Math.random()*(100+1)+100);
		}
		System.out.print("排序前的数组为：");
		for(int k=0;k<10;k++){
			System.out.print(" "+nums[k]);
		}
		System.out.print("\n");
		
		heapSort(nums, nums.length);
	}
	
	/**
	 * 
	 * @param nums 需要排序的数组
	 * @param n    数组的长度
	 */
	public static void heapSort(long[] nums,int n){
		//将nums建成最大根堆
		for(int i=n/2-1;i>=0;i--){
			while(2*i+1<n){   //若存在左子树，则左子树的节点编号为2*i+1，若存在右子树，则柚子树的编号为2*i+2
				int j=2*i+1;
				if ((j+1)<n) {   //若成立在有则第i个结点存在右子树，否则没有右子树
					if (nums[j]<nums[j+1]) {  //若左子树小于右子树，则需要比较右子树
						j++;    //序号加1，比较右子树
					}
				}
				if (nums[i]<nums[j]) {  //比较i与j的为序号的数据
					long temp=nums[i];  //交换数据
					nums[i]=nums[j];
					nums[j]=temp;
					i=j;   //堆被破坏，重新调整
				}else {
					break; //根节点的值比右子树大，所以不需要调整
				}
			}
		}
		
		System.out.print("原数据构成的堆：");
		for(int k=0;k<n;k++){
			System.out.print(" "+nums[k]);
		}
		System.out.print("\n");
		
		for (int i = n-1;i>0;i--) {
			long temp=nums[0];
			nums[0]=nums[i];
			nums[i]=temp;
			int k=0;
			while(2*k+1<i){
				int j=2*k+1;
				if ((j+1)<i) {
					if (nums[j]<nums[j+1]) {
						j++;
					}
				}
				if (nums[k]<nums[j]) {
					temp=nums[k];
					nums[k]=nums[j];
					nums[j]=temp;
					k=j;
				}else {
					break;
				}
			}
			System.out.print("第"+(n-i)+"步排序结果：");
			for (int h = 0; h < n; h++) {
				System.out.print(" "+nums[h]);
			}
			System.out.print("\n");
		}
		System.out.print("排序后结果：");
		for (int h = 0; h < n; h++) {
			System.out.print(" "+nums[h]);
		}
		System.out.print("\n");
	}

}
