package java.algorithm.array;

/**
 * 子数组最大和
 * @author zhaojw_420
 *
 */
public class ArrayRangeMax {

	public static void main(String[] args) {
		    int[] num = {1,-2,3,10,-4,7,2,-5};
	        System.out.println(maxSum(num));
	}
	
	 public static int maxSum(int[] num){
	        int curSum = 0;
	        int curMaxSum = -99999999;
	        int start = 0;
	        int end = 0;
	        
	        for(int i=0;i<num.length;i++){
	            if(curSum<=0){
	                curSum = num[i]; //负数加上一个负数只会变得更小，所以当curSum<0时，最大和还是等于当前的数
	                start = i;
	            }
	            else{
	                curSum += num[i];
	            }
	            if(curSum>curMaxSum){
	                curMaxSum = curSum;        
	                end = i;
	            }
	        }    
	        for(int i = start;i<=end;i++){
	            System.out.println(num[i]);
	        }
	        return curMaxSum;
	    }
}
