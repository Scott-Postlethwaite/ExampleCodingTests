import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map.Entry;

class Graph{

    private Set<Node> nodes = new HashSet<>();
    public void addNode(Node node1){
        nodes.add(node1);
        
    }

    public Set<Node> gNodes(){
            return nodes;
        }

        public void sNodes(Set<Node>nodes){
            this.nodes = nodes;
        }

}

class Node{
    private String name;
    private List<Node> path = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> connections = new HashMap<>();
    public void addConnection(Node connection, int diatance){
        connections.put(connection, distance);
    }
    public Node(String name){
        this.name = name;
    }

    public String gName(){
        return name;
        }

    public void sName(String name){
        this.name=name;
    }
    public Map<Node,Integer> gConns(){
        return connections;
    }

    public void sConns(Map<Node,Integer> conns){
        this.connections=conns;
    }

    public int gDistance(){
        return distance;
    }
    public void setDistance(int distance){
        this.distance=distance;
    }

    public List<Node> gPath(){
        return path;
    }

    public void sPath(List<Node> path){
        this.path=path;
    }

}

class dijkstra{

    public static Graph shortestPath(Graph graph, Node root){
        root.setDistance(0);
        Set<Node> expNodes = new HashSet<>();
        Set<Node> freeNodes = new HashSet<>();

        freeNodes.add(root);

        while (freeNodes.size()!=0){
            Node current = getClosestNode(freeNodes);
            freeNodes.remove(current);
            for( Entry<Node,Integer>connPair:current.gConns().entrySet()){
                Node cNode=connPair.getKey();
                Integer edge =  connPair.getValue();

                if(!expNodes.contains(cNode)){
                    minDistance(cNode,edge,current);
                    freeNodes.add(cNode);
                }
            }
            expNodes.add(current);
        }
        
        return graph;
    }

    private static void minDistance(Node eNode, Integer edge, Node root){
        Integer rootDis = root.gDistance();
        if(rootDis+edge < eNode.gDistance()){
            eNode.setDistance(rootDis + edge);
            LinkedList<Node> path = new LinkedList<>(root.gPath());
            path.add(root);
            eNode.sPath(path);
        }
    }

    private static Node getClosestNode(Set<Node>freeNodes){
        Node minDisNode = null;
        int minDis = Integer.MAX_VALUE;
        for(Node node : freeNodes){
            int nDis = node.gDistance();
            if(nDis<minDis){
                minDis=nDis;
                minDisNode=node;
            }
        }
        return minDisNode;
    }


}




public class Solution {
    public static void main(String args[] ) throws Exception {


  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            Node root = new Node("A");
            Node destination = new Node("D");
            List<Node> nodes = new ArrayList<Node>();
            String allNodes = bufferedReader.readLine();
            String ins = bufferedReader.readLine();
            String[] instructions = ins.split("[-+>,]");
            String[] split = allNodes.split("\\s+");
         
         
            for(String node : split){




                node = node.substring(1, node.length()-1);
                String[] values = node.split(",");
                int from=Integer.MAX_VALUE;
                int to =Integer.MAX_VALUE;
                
                for(int i=0;i<nodes.size();i++)
                {
                    if (nodes.get(i).gName() == values[0])
                    {
                        from=i;
                    }else if(nodes.get(i).gName() == values[1])
                    {
                        to=i;
                    }
                }
                if (from!=Integer.MAX_VALUE){
                    if(to!=Integer.MAX_VALUE){
                        nodes.get(from).addConnection(nodes.get(to), Integer.parseInt(values[2]));
                    }else{
                        Node d = new Node(values[1]);
                        nodes.get(from).addConnection(d, Integer.parseInt(values[2]));
                        nodes.add(d);
                         if (values[0]==instructions[0]){
                        root = nodes.get(from);
                         }else if(values[0]==instructions[1]){
                            destination = nodes.get(from);
                         }
                        }
                }else{
                        
                    Node n = new Node(values[0]);
                    Node d = new Node(values[1]);

                    n.addConnection(d, Integer.parseInt(values[2]));

                    nodes.add(n);
                    nodes.add(d);
                    if (values[0]==instructions[0]){
                        root = n;
                    }else if(values[0]==instructions[1]){
                        destination = n;
                    }
                    }

            }



        Graph graph = new Graph();


        for(Node node : nodes){
            graph.addNode(node);
            bufferedWriter.write(node.gConns().toString());
            bufferedWriter.newLine();
        }


bufferedWriter.write("");


        graph = dijkstra.shortestPath(graph,root);

                bufferedWriter.newLine();

        for(Node n : graph.gNodes()){
            if(n.gName()==destination.gName()){
                bufferedWriter.write(n.gName());
            }
        }

       
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}