package java1.algorithm.array;

/**
 * 扑克中任意抽取5张，判断是不是连续的。A代表1，J代表11，Q代表12，K代表13，大小王代表任意的数
 * @author zhaojw_420
 *
 */
public class ArrayContinuity {

	public static void main(String[] args) {
		int[] num = {0,1,0,3,2};
		ArrayContinuity ac=new ArrayContinuity();
        System.out.println(ac.check(num));
	}
	
	 public boolean check(int[] num){
	        //0-13
	        int[] pai = new int[14];
	        for(int n : num){
	            pai[n]=1;
	        }
	        qsort(num,0,num.length-1);
	        int count = pai[0];
	        int start = 0;
	        //改进，若拿的大小王
	        if (num[0]==00&&num[1]==0) {
	        	 start=num[2];
			}else if(num[0]==0&&num[1]!=0){
	            start=num[1];
	        }else{
	            start=num[0];
	        }
	        for(int i = start;i<=start+5;i++){
	            if(pai[i]>1)return false; //出现了两次或者以上的牌。那么就会大于1，不需要再继续判断下去
	            count += pai[i];//若连续，则连续的五个下标的pai数组的和加起来肯定是等于5的。若不连续，则小于5
	        }
	        if(count == 5)return true;
	        else return false;
	        
	    }
	    
	    public void qsort(int[] num,int left,int right){
	        if(left<right){
	            int partition = partition(num,left,right);
	            qsort(num,left,partition-1);
	            qsort(num,partition+1,right);
	        }
	    }
	    
	    public int partition(int[] num,int left,int right){
	        int partition = num[left];
	        while(left<right){
	        	//从左往右找小于partition的数来填num[left]
	            while(left<right && num[right]>=partition){
	                right--;
	            }
	            swap(num,left,right);
	            while(left<right && num[left]<=partition){
	                left++;
	            }
	            swap(num,left,right);
	        }
	        
	        return left;        
	    }
	    
	    public void swap(int[] num,int m,int n){
	        int temp = num[m];
	        num[m]=num[n];
	        num[n]=temp;
	    }
}
