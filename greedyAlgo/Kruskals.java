package greedyAlgo;

import java.util.*;

public class Kruskals {
	
	class Edge implements Comparable<Edge> 
    {
        int src,dest,weight;
        public int compareTo(Edge e)
        {
            return this.weight-e.weight;
        }
    };
   
    class subset 
    {
        int parent, rank;
    };
 
    int V, E;
    Edge edge[];
 
    Kruskals(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0;i<e;++i)
            edge[i]=new Edge();
    }

    int find(subset subsets[], int i)
    {
        if (subsets[i].parent!=i)
            subsets[i].parent= find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    void Union(subset subsets[],int x,int y)
    {
        int xroot=find(subsets,x);
        int yroot=find(subsets,y);
 
        if (subsets[xroot].rank<subsets[yroot].rank)
            subsets[xroot].parent=yroot;
        else if (subsets[xroot].rank>subsets[yroot].rank)
            subsets[yroot].parent=xroot;
 
        else 
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
 
    void KruskalMST()
    {
        Edge result[] = new Edge[V]; 
        int e=0; 
        int i=0; 
        for (i=0;i<V;++i)
            result[i]=new Edge();
        
        Arrays.sort(edge);
 
        subset subsets[]=new subset[V];
        for (i=0;i<V;++i)
            subsets[i] = new subset();

        for (int v=0;v<V;++v) 
        {
            subsets[v].parent=v;
            subsets[v].rank=0;
        }
 
        i=0; 

        while(e<V-1) 
        {
            Edge next_edge=new Edge();
            next_edge=edge[i++];
 
            int x=find(subsets,next_edge.src);
            int y=find(subsets,next_edge.dest);

            if(x!=y) 
            {
                result[e++]=next_edge;
                Union(subsets,x,y);
            }
        }
 
        System.out.println("Edges \tweight");
        int min_cost=0;
        for(i=0;i<e;++i)
        {
            System.out.println(result[i].src+"-"+ result[i].dest+"\t  "+result[i].weight);
            min_cost+=result[i].weight;
        }
        System.out.println("Minimum Cost: "+min_cost);
    }
   
    public static void main(String[] args)
    {
        int V=6; 
        int E=8; 
        Kruskals kg = new Kruskals(V, E);
 
        kg.edge[0].src=0;
        kg.edge[0].dest=1;
        kg.edge[0].weight=4;
 
        kg.edge[1].src=0;
        kg.edge[1].dest=2;
        kg.edge[1].weight=2;
 
        kg.edge[2].src=1;
        kg.edge[2].dest=3;
        kg.edge[2].weight=6;
 
        kg.edge[3].src=1;
        kg.edge[3].dest=2;
        kg.edge[3].weight=5;
 
        kg.edge[4].src=2;
        kg.edge[4].dest=3;
        kg.edge[4].weight=1;
        
        kg.edge[5].src=2;
        kg.edge[5].dest=5;
        kg.edge[5].weight=4;
        
        kg.edge[6].src=3;
        kg.edge[6].dest=4;
        kg.edge[6].weight=3;
        
        kg.edge[7].src=4;
        kg.edge[7].dest=5;
        kg.edge[7].weight=2;
   
        kg.KruskalMST();
    }
}