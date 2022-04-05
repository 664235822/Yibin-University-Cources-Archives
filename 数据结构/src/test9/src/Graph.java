import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    ArrayList vertexList;
    int[][] edges;
    int numOfEdges;
    boolean[] isVisited;
    int n;

    public Graph(int n) {
        this.n=n;
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
        isVisited=new boolean[5];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getFirstNeighbor(int index){
        for(int j=0;j<vertexList.size();j++){
            if(edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<vertexList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    private void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;

        int w=getFirstNeighbor(i);
        while(w!=-1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w=getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        isVisited=new boolean[5];
        for(int i=0;i<getNumOfVertex();i++){
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }

        System.out.println();
    }

    private void bfs(boolean[] isVisited,int i){
        int u;
        int w;
        LinkedList queue=new LinkedList();
        System.out.print(getValueByIndex(i)+"=>");
        isVisited[i]=true;
        queue.addLast(i);

        while(!queue.isEmpty()){
            u=(Integer)queue.removeFirst();
            w=getFirstNeighbor(u);
            while(w!=-1){
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    isVisited[w]=true;
                    queue.addLast(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }

    public int getFrom(int v1,int v2){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=edges[v1][i];
        }
        return sum;
    }

    public int getTo(int v1,int v2){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=edges[i][v2];
        }
        return sum;
    }

    public int getDegree(int v1,int v2){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=edges[v1][i];
        }

        for(int i=0;i<n;i++){
            sum+=edges[i][v2];
        }

        sum-=edges[v1][v2];

        return sum;
    }

    public void bfs(){
        isVisited=new boolean[5];
        for(int i=0;i<getNumOfVertex();i++){
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }

        System.out.println();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i).toString();
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}
