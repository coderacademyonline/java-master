package java.algorithm.string;

/**
 * 顺时针打印一个矩阵
 * @author zhaojw_420
 *
 */
public class ClockwiseOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] num = new int[100][100];
	        int n = 5;
	        int count =1;
	        
	        for(int i=0;i<n;i++){
	            for(int j =0;j<n;j++){
	                num[i][j]=count++;
	            }
	        }
	        AntiClockwise(num,0,n-1);
	}

	/**
	 * 顺时针
	 * @param num
	 * @param start
	 * @param end
	 */
	public static void output(int[][] num,int start,int end){
        if(start>end || end<=0)return;
        for(int i=start;i<=end;i++){
            System.out.println(num[start][i]);
        }
        for(int i=start+1;i<=end;i++){
            System.out.println(num[i][end]);
        }
        
        for(int i=end-1;i>=start;i--){
            System.out.println(num[end][i]);
        }
        for(int i=end-1;i>start;i--){
            System.out.println(num[i][start]);
        }
        
        output(num,start+1,end-1);
    }
	
	/**
	 * 逆时针
	 * @param num
	 * @param start
	 * @param end
	 */
	public static void AntiClockwise(int[][] num,int start,int end){
		if(start>end||end<0)return;
		for(int i=start;i<=end;i++){
			System.out.println(num[i][start]);
		}
		
		for(int i=start+1;i<=end;i++){
			System.out.println(num[end][i]);
		}
		
		for (int i = end-1; i >=start; i--) {
			System.out.println(num[i][end]);
		}
		
		for(int i=end-1;i>=start+1;i--){
			System.out.println(num[start][i]);
		}
		
		AntiClockwise(num, start+1, end-1);
	}
	
}
