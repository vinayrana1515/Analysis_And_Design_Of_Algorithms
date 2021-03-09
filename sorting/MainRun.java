package sorting;
import java.io.*;
import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainRun {
	
	public int count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            MainRun mr= new MainRun();
 
        	int [] arr1= mr.generate();
        	int n=arr1.length;
        	
        	long start=System.currentTimeMillis();
        	mr.heapsort(arr1);
        	long end =  System.currentTimeMillis();      	
        	mr.display(arr1);
        	int r=mr.count;
        	mr.count=0;
        	
        	long start1=System.currentTimeMillis();
        	mr.heapsort(arr1);
        	long end1 =  System.currentTimeMillis();
        	int as=mr.count;
        	mr.count=0;
        	       	
            int [] arr3=new int[n];
            int j=n-1;
            for(int i =0 ;i<n;i++) {
          	     arr3[j]=arr1[i];
          	     j--;
            }
            long start2=System.currentTimeMillis();
            mr.heapsort(arr3);
            long end2 =  System.currentTimeMillis();
            int desc=mr.count;
            mr.count=0;
            
            int arr4[]=new int[n];
            for(int i =0 ;i<n;i++) {
             	arr4[i]=5;
            }
            
            long start3=System.currentTimeMillis();
            mr.heapsort(arr4);
            long end3 =  System.currentTimeMillis();
            int sam=mr.count;
            
            
            System.out.println("Time random ms"+(end-start));
            System.out.println("Time asec ms"+(end1-start1));
            System.out.println("Time desc ms"+(end2-start2));
            System.out.println("Time same ms"+(end3-start3));
	}
	void heapsort(int arr[])
	      {  
	          int n=arr.length;
	          for(int i=n/2-1;i>=0;i--)
	               heapify(arr, n, i);
	          for (int i=n-1;i>0;i--) {
	               int temp=arr[0];
	               arr[0]=arr[i];
	               arr[i]=temp;
	               heapify(arr,i,0);
	        }
	      }
	   
    void heapify(int arr[],int n,int i)
	       { 
	           int largest=i;
	           int l=2*i+1;
	           int r=2*i+2;
	           if (l<n&&arr[l]>arr[largest])
	               largest=l;
	           if (r<n && arr[r]>arr[largest])
	               largest=r;
	           if (largest!=i) {
	               int swap=arr[i];
	               arr[i]=arr[largest];
	               arr[largest]=swap;
	               heapify(arr,n,largest);
	           }
	       }
	      

	   

	int[] generate() {
		   Random rnd = new Random();
		   int arr[]=new int[1000];
	        for(int i=0;i<1000;i++){
//	            System.out.println(rnd.nextInt(1000));
	            arr[i]=rnd.nextInt(10000);
	        }
	        return arr;
	}
	
	int partition(int arr[], int l, int r) 
    { 
		int pivot = arr[r];  
        int i = (l-1); 
        for (int j=l; j<r; j++) 
        {
            if (arr[j] < pivot) 
            {   i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[r]; 
        arr[r] = temp; 
  
        return i+1; 
    }
	
	void quickSort(int arr[], int l, int r) 
    {
        if (l<r) 
        {            
            int p = partition(arr, l, r); 
            quickSort(arr, l, p-1); 
            quickSort(arr, p+1, r); 
        } 
        count++;
    }
	
	void merge(int arr[], int left, int mid, int right) 
    { 
        int n1 = mid - left + 1; 
        int n2 = right - mid; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        
        for (int i=0; i<n1; ++i) 
            L[i] = arr[left + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[mid + 1+ j]; 
  
         int i = 0, j = 0; 
        
        int k = left; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
       } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
          j++; 
           k++; 
        } 
    }
	
	 void mergeSort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            int m = (l+r)/2; 
	  	           
	            mergeSort(arr, l, m); 
	            mergeSort(arr , m+1, r); 
	  
	            merge(arr, l, m, r); 
	        } 
	    }

	 void selectionSort(int arr[]) 
	    { 
	        int n = arr.length; 
	         for (int i = 0; i < n-1; i++) 
	        { 
	            int min = i; 
	            for (int j = i+1; j < n; j++) 
	            { if (arr[j] < arr[min]) 
	                    min = j; 
	            }
	            
	            int temp = arr[min]; 
	            arr[min] = arr[i]; 
	            arr[i] = temp; 
	        } 
	         
	    } 

	 
void insertionSort(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 1; i < n; ++i) { 
	            int v = arr[i]; 
	            int j = i - 1; 
	  
	            while (j >= 0 && arr[j] > v) { 
	                arr[j + 1] = arr[j]; 
	                j = j - 1; 
	            } 
	            arr[j + 1] = v; 
	        } 
	        
	        
	    } 


void bubbleSort(int arr[]) 
{ 
    int n = arr.length; 
    for (int i = 0; i < n-1; i++) 
    {  for (int j = 0; j < n-i-1; j++) 
            if (arr[j] > arr[j+1]) 
            {              
                int temp = arr[j]; 
                arr[j] = arr[j+1]; 
                arr[j+1] = temp; 
            } 
    }
} 

void display(int arr[]) 
{ 
    int n = arr.length; 
    for (int i=0; i<n; ++i) 
        {System.out.println(arr[i] + " ");} 
   // System.out.println(); 
}
}