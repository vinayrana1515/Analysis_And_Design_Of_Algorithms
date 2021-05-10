
public class Run {
     static	  int one=0;
     static	  int two=0;
     static	  int three=0;
     static	  int four=0;
     static	  int five=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int arr[]={45, 76, 187, 231, 512,76, 187, 231,45, 187, 231, 512,76, 187, 231,45,45, 76, 187, 231, 512,76, 231,45, 187, 231, 512,76, 187,76, 187, 231, 512,76, 187, 231,45, 187, 231, 512,76, 187, 231,45,45, 76, 187, 231, 512,76, 231,45};
         Run obj=new Run();
         obj.display(arr);
         obj.sort(arr);
         System.out.println("Sorted Array : ");
         obj.print(arr,one,two,three,four,five);
         				
	}

	
	
	
	void sort(int arr[]) 
	{ 
	    int n = arr.length; 
	   
	    for (int i = 0; i < n; i++) 
	    {  if (arr[i]==45) 
	    	  one++;
	       if (arr[i]==76) 
	    	  two++;
	        if (arr[i]==187) 
	    	  three++;
	        if (arr[i]==231) 
	    	  four++;
	        if (arr[i]==512) 
	    	  five++;
	    
	    }
	   
	} 
    void print(int arr[],int a, int b, int c ,int d , int e)
    { int n = arr.length; 
      for (int i=0; i<a; ++i) {
    	  arr[i]=45;
    	     System.out.print(arr[i]+ " ");}
      for (int i=0; i<b; ++i) {
    	  arr[a+i]=76;
 	      System.out.print(arr[a+i]+ " ");
      }
    	  
      for (int i=0; i<c; ++i) {
    	  arr[a+b+i]=187;
 	      System.out.print(arr[a+b+i]+ " ");
      }
    		  
      for (int i=0; i<d; ++i) {
    	  arr[a+b+c+i]=231;
 	      System.out.print(arr[a+b+c+i]+ " ");
      }
    
      for (int i=0; i<e; ++i) {
    	  arr[a+b+c+d+i]=512;
 	      System.out.print(arr[a+b+c+d+i]+ " ");
      }
    							  
    
    	 
      }
    	
    
	void display(int arr[]) 
	{ 
	    int n = arr.length; 
	    for (int i=0; i<n; ++i) 
	        {System.out.println(arr[i] + " ");} 
	   
	}
}
