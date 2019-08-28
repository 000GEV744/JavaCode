package Java.Array;

public class ArrayDemo {

	 private char arr[];
	 
	 public void getLength(int len) {
		 arr =new char[len];
	 }
	  
	 public char[] getArray() {
		
		 for(int i=0;i<arr.length;i++) {
			 arr[i]=(char)('A'+i);
		 }
		 return arr;
	 }
	 
	 //stack implementation
	 
	 int stackArr[] = new int[10];
	 int first=0, top=0;
	 
	 //pushing the elements 
	 public void push(int a ) {
		 if(top==stackArr.length) {
			 System.out.println("overflow");
		 }
		 else {
		 this.stackArr[top]=a;
		 System.out.println("pushing element "+a+" at index "+ top);
		 top++;
	 }
	 }
	 
	 //popping the element 
	 public void pop() {
		 if(first==top) {
			 System.out.println("underflow");
		 }
		 else {
			 System.out.println("pop: "+stackArr[top-1]);
		 top--;
	 }
	 }
	 
	 //showing my stack array
	 public void showStackArr() {
		 int i=0;
		 if(i==top) {
			 System.out.println("no elements in the Stack");
		 }
		 else {
			 System.out.println("stack contains: ");
		 
		 for(i=0;i<top;i++) {		 
			System.out.print(" "+stackArr[i]);
		 }	}	
	 }
	 
	 //stack implementation ends here!
	 
	
}
