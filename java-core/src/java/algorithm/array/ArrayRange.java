package java.algorithm.array;

/**
 * 字符数组组成的所有字符串
 * @author zhaojw_420
 *
 */
public class ArrayRange {

	public static void main(String[] args) {
		char[] cs = {'a','b','c'};    
        int length = cs.length;        
        recursionSwap(cs,0,length);
	}
	
	public static void swap(char[] cs,int index1,int index2){
        char temp = cs[index1];
        cs[index1]=cs[index2];
        cs[index2]=temp;        
    }
    
    public static void recursionSwap(char[] cs,int start,int length){
        if(start>=length-1){
            print(cs);
            return;
        }
        for(int i=start;i<length;i++){
            swap(cs,start,i);
            recursionSwap(cs,start+1,length);//此处经典    
            swap(cs,start,i);//此处经典  
        }
    }
    
    public static void print(char[] cs){
        for(int i=0;i<cs.length;i++){
            System.out.print(cs[i]);
        }
        System.out.println();
    }
}
