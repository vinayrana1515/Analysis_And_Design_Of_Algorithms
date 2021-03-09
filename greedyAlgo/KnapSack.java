package greedyAlgo;



public class KnapSack{
	public static void main(String[] args) {
		
		int item[] = new int[]{1,2,3,4,5};
		int weight[] = new int[]{5,10,15,22,25};
		int value[] = new int[]{30,40,45,77,90};

		float ratio[] = new float[5];
		float count[] = new float[5];
		
		int m=60;
		int n=5;

		for (int k=0;k<5;k++ ) {
			count[k]=0;
		}

		for(int i=0;i<5;i++) 
		{
			ratio[i]=(float)value[i]/(float)weight[i];
		}

		for(int i=0;i<n;i++)
		{  
			for(int j=1;j<(n-i);j++)
			{  
				if(ratio[j-1]>ratio[j])
				{  
					float temp;

					temp=ratio[j-1];  
					ratio[j-1]=ratio[j];  
					ratio[j]=temp; 

					int temp1;

					temp1=weight[j-1];  
					weight[j-1]=weight[j];  
					weight[j]=temp1; 

					temp1=value[j-1];  
					value[j-1]=value[j];  
					value[j]=temp1; 

				}  

			}  
		}

//		System.out.println();
		
		for(float r:ratio) 
		{
			System.out.print(r+" ");
		}
		System.out.println();


		for(float w:weight) 
		{
			System.out.print(w+" ");
		}
		System.out.println();



		for   (int i=n-1;i>=0;i--) 
		{
		  	if ((m-(int)weight[i])>=0) 
		  	{
		  		count[i]=1;
		  		m=m-weight[i];
		  	}
		  	else if ((m-(int)weight[i])<0)
		  	{
		  		float x=(float)m/(float)weight[i];
		  		if (x>0 && x<1) 
		  		{
		  			count[i]=x;
		  			m=m-weight[i];
		  		}
		  		else
		  		{
		  			count[i]=0;
		  		}
		  	}
		}  

		float profit=0;
		for (int k=0;k<5;k++ ) {
			profit=profit+count[k]*value[k];
		}
		System.out.println("\nRatio vector");

		for(float y:ratio) 
		{
			System.out.print(y+" ");
		}
		System.out.println("\nCount vector");

		for (float z:count) {
			System.out.print(z+" ");
		}
		System.out.println("\nProfit:");

		System.out.println(profit);

	}
}