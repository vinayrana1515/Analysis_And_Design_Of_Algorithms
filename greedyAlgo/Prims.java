package greedyAlgo;

public class Prims {
	
private static final int V=5;
	
	int minKey(int key[],Boolean mstSet[])
	{
		int min=Integer.MAX_VALUE, min_index=-1;
		
		for(int v=0;v<V;v++)
		{
			if(mstSet[v]==false && key[v]<min)
			{
				min=key[v];
				min_index=v;
			}
		}
		
		return min_index;
	}

	void print(int parent[],int graph[][])
	{
		int weight=0;
		System.out.println("Edge\t Weight");
		for(int i=1;i<V;i++)
		{
			System.out.println(parent[i]+"-"+i+"\t"+"  "+graph[i][parent[i]]);
			weight+=graph[i][parent[i]];
		}
		System.out.println("Minimum cost: "+weight);
	}
	
	void primMst(int graph[][])
	{
		int parent[]=new int[V];
		int key[]=new int[V];
		Boolean mstSet[]=new Boolean[V];
		
		for(int i=0;i<V;i++)
		{
			key[i]=Integer.MAX_VALUE;
			mstSet[i]=false;
		}
		
		key[0]=0;
		parent[0]=-1;
		
		for(int j=0;j<V-1;j++)
		{
			int u=minKey(key,mstSet);
			mstSet[u]=true;
			
			for(int v=0;v<V;v++)
			{
				if(graph[u][v]!=0 && mstSet[v]==false && graph[u][v]<key[v])
				{
					parent[v]=u;
					key[v]=graph[u][v];
				}
			}
		}
		
		print(parent,graph);
	}
	
	public static void main(String args[])
	{
		Prims pm=new Prims();
		
		int graph[][]=new int[][] { {0,9,3,2,0},
									{9,0,0,6,8},
									{3,0,0,7,5},
									{2,6,7,0,4},
									{0,8,5,4,0}};
									
		pm.primMst(graph);
    } 

}