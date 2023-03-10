import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Map;

class Edges {
    String start;
    String end;
    String movie;
    public Edges(String s, String e, String m){
        start = s;
        end = e;
        movie = m;
    }
    public String getStart() {
        return start;
    }
    public String getEnd(){
        return end;
    }
    public String getMovie(){
        return movie;
    }
}

class Nodes {
    Nodes prev;
    String name;
    ArrayList<Edges> edge = new ArrayList<Edges>();
    boolean visited = false;
    public Nodes(String n){
        name = n;
    }
    public void addEdge(Edges e){
        edge.add(e);
    }
    public ArrayList<Edges> getEdges(){
        return edge;
    }
    public int edgeNum() {
    	return edge.size();
    }
    public void visit() {
        visited = true;
    }
    public void antiVisit(){
        visited = false;
    }
    public boolean getVisited(){
        return visited;
    }
    public boolean hasPrev(){
        if (prev==null) return false;
        return true;
    }
    public void setPrev(Nodes n) {
        prev = n;
    }
    public Nodes getPrev(){
        return prev;
    }
    public String getName() {
        return name;
    }
}

class Graph {
	public HashMap<String, Nodes> buildGraph() throws IOException {
        BufferedReader actorsList = new BufferedReader(new FileReader("actors.txt"));
        BufferedReader moviesList = new BufferedReader(new FileReader("movies.txt"));
        BufferedReader movie_actors = new BufferedReader(new FileReader("movie-actors.txt"));
        HashMap<String, String> actor = new HashMap<String, String>();
        HashMap<String, String> movie = new HashMap<String, String>();
        HashMap<String, Nodes> code_node = new HashMap<String, Nodes>();
        HashMap<String, Nodes> name_node = new HashMap<String, Nodes>();
        ArrayList<String> movieList = new ArrayList<String>();
        ArrayList<Nodes> actors = new ArrayList<Nodes>();
        for (String line = actorsList.readLine(); line != null; line = actorsList.readLine()){
        	String[] tokens = line.split("~");
        	String code = tokens[0];
	        String name = tokens[1];
	        Nodes n = new Nodes(name);
            actors.add(n);
            actor.put(code, name);
            code_node.put(code, n);
            name_node.put(name, n);
        }

        for (String line = moviesList.readLine(); line != null; line = moviesList.readLine()){
        	String[] tokens = line.split("~");
        	String code = tokens[0];
	        String name = tokens[1];
            movieList.add(name);
            movie.put(code, name);
        }
        
        String currMovie = "";
        ArrayList<Nodes> currActors = new ArrayList<Nodes>();
        ArrayList<Nodes> emp = new ArrayList<Nodes>();
        for (String line = movie_actors.readLine(); line != null; line = movie_actors.readLine()){
        	String[] tokens = line.split("~");
        	String movieCode = tokens[0];
	        String actorCode = tokens[1];
	        if(currMovie.equals("")) currMovie = movieCode;
	        if(movieCode.equals(currMovie)) {
	        	 if(currActors.size()!=0) {
	        		 for (int i = 0; i < currActors.size(); i++) {
		        		 Edges e1 = new Edges(actor.get(actorCode), currActors.get(i).getName(), movie.get(movieCode));
		        		 Edges e2 = new Edges(currActors.get(i).getName(), actor.get(actorCode), movie.get(movieCode));
		        		 code_node.get(actorCode).addEdge(e1);
		        		 currActors.get(i).addEdge(e2);
		        	 }
	        		 currActors.add(code_node.get(actorCode));
	        	 }
	        	 else {
	        		 currActors.add(code_node.get(actorCode));
	        	 }
	        }
	        else {
//	        	System.out.println(currActors.size());
//	        	System.out.println(currMovie);
//	        	System.out.println(movieCode);
	        	
//	        	System.out.println(num);
	        	currActors = emp;
	        	currMovie = movieCode;
	        }
        }
        actorsList.close();
        moviesList.close();
        movie_actors.close();
        return name_node;
    }
}

public class BFS{
	public String findPath(HashMap<String, Nodes> name_node, String start, String end){
        if (name_node.get(start) == null||name_node.get(end) == null){
            return "Who is this character, never heard of them :0";
        }
        String ans = "";
        Nodes s = name_node.get(start);
        Nodes prev = s;
        Queue<Nodes> queue = new LinkedList<Nodes>();
//        queue.add(s);
        boolean yay = false;
//        while(!queue.isEmpty()){
//            Nodes currNode = queue.poll();
//            currNode.visit();
//            prev = currNode;
//            if (currNode.getName().equals(end)){
//                yay = true;
//                break;
//            }
//            for (int i = 0; i < currNode.edgeNum(); i++){
//            	Nodes o = name_node.get(currNode.getEdges().get(i).end);
//                if (!o.getVisited() && !o.hasPrev()){
//                    o.setPrev(prev);
//                    queue.add(o);
//                }
//            }
//        }
        for(int i = 0; i <= name_node.get(start).getEdges().size() - 1; i++){
            queue.add(name_node.get(name_node.get(start).getEdges().get(i).end));
            name_node.get(name_node.get(start).getEdges().get(i).end).setPrev(prev);
            name_node.get(start).visit();
        }

//        boolean found = false;
        System.out.println(name_node.get(start).getEdges().size());

        while(!queue.isEmpty()){
            queue.peek().visit();
            Nodes currVertex = queue.poll();
            prev = currVertex;
            System.out.println(currVertex.name);
            System.out.println(end);
            if (currVertex.name.equals(end)){
                yay = true;
                break;
            }
            for (int i = 0; i <= name_node.get(currVertex.name).getEdges().size() - 1; i++){
                if (!name_node.get(name_node.get(currVertex.name).getEdges().get(i).end).visited && !name_node.get(name_node.get(currVertex.name).getEdges().get(i).end).hasPrev()){
                	name_node.get(name_node.get(currVertex.name).getEdges().get(i).end).setPrev(prev);
                    queue.add(name_node.get(name_node.get(currVertex.name).getEdges().get(i).end));
                }
            }
        }
        if(yay) {
            Stack<Nodes> backtrack = new Stack<Nodes>();
            Queue<String> movies = new LinkedList<String>();
            Nodes target = name_node.get(end);
            backtrack.add(target);
            while (!target.getName().equals(start)) {
                target = target.getPrev();
                backtrack.add(target);
            }
            Stack<Nodes> dup = backtrack;
            Nodes first = s;
            Nodes second = dup.pop();
            while(dup.size() > 0){
                for (int i = 0; i < first.edgeNum(); i++){
                	Edges c = first.getEdges().get(i);
                    if (c.getEnd().equals(second.getName())){
                        movies.add(c.movie);
                        break;
                    }
                }
                first = second;
                second = dup.pop();
            }
            for (int i = 0; i < first.edgeNum(); i++){
            	Edges c = first.getEdges().get(i);
                if (c.getEnd().equals(second.getName())){
                    movies.add(c.movie);
                }
            }
            while (backtrack.size() != 1){
                ans += backtrack.pop() + " -> ";
                ans += "(" + movies.poll() + ") ->";
            }
            ans += end;
            return ans;
        }
        else{
            return "They're unrelated, how sad :(";
        }
    }
//	public String BaconNum(HashMap<String, Nodes> name_node, String end) {
//		if (name_node.get(end) == null){
//            return "Who is this character, never heard of them :0";
//        }
//        String ans = "";
//        Nodes s = name_node.get(start);
//        Nodes prev = s;
//        Queue<Nodes> queue = new LinkedList<Nodes>();
//        queue.add(s);
//        boolean yay = false;
//        while(!queue.isEmpty()){
//            Nodes currNode = queue.poll();
//            currNode.visit();
//            prev = currNode;
//            if (currNode.getName().equals(end)){
//                yay = true;
//                break;
//            }
//            for (int i = 0; i < currNode.edgeNum(); i++){
//            	Nodes o = name_node.get(currNode.getEdges().get(i).end);
//                if (!o.getVisited() && !o.hasPrev()){
//                    o.setPrev(prev);
//                    queue.add(o);
//                }
//            }
//        }
//	}
}