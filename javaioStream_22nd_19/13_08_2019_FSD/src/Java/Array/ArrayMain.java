package Java.Array;


public class ArrayMain {

	public static void main(String args[]) {
//			int arr[]= {100,1,-20,30,0};
//			Arrays.sort(arr);
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(arr[i]+" ");
//			}
//			
//			
//			
//			
//	    //searching for an element 
//		int key=-9;
//		int flag=0;
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]==key) {
//			System.out.println("\n"+"got the"+" key:"+key+ " at location "+ (i+1));
//			flag=1;
//			}
//		}
//		if(flag==0) {
//			System.out.println("\n element not found");
//		}
//		
		ArrayDemo stkArr= new ArrayDemo();
		stkArr.push(22);
		stkArr.push(31);
		stkArr.push(4);
		stkArr.push(6);
		stkArr.push(44);
		stkArr.push(76);
		stkArr.push(46);
		stkArr.push(56);
		stkArr.push(36);
		stkArr.push(6);
		stkArr.push(6);
		
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		stkArr.pop();
		
		stkArr.push(56);
		stkArr.push(36);
		stkArr.push(22);
		stkArr.push(31);
		stkArr.push(4);
		stkArr.push(6);
		stkArr.push(44);
		
		stkArr.showStackArr();
	}
}
