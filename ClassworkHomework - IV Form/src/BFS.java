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
	ArrayList<Edges> edges = new ArrayList<Edges>();
        ArrayList<String> m_a = new ArrayList<String>();
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
//        
        for (String line = movie_actors.readLine(); line != null; line = movie_actors.readLine()){
        	m_a.add(line);
        }
        
        String currMovie = movie.get(m_a.get(0).split("~")[0]);
        int index = 0;

        
        for (int i = 0; i < m_a.size(); i++){
        	String curr = movie.get(m_a.get(i).split("~")[0]);
            if (!currMovie.equals(curr)){
                for (int j = index; j < i; j++){
                    for (int k = j + 1; k < i; k++){
			String actor1_n = actor.get(m_a.get(j).split("~")[1]);
			String actor2_n = actor.get(m_a.get(j).split("~")[1]);
                        Edges e1 = new Edges(actor1_n, actor2_n, currMovie);
                        Edges e2 = new Edges(actor2_n, actor1_n, currMovie);
                        Nodes actor1 = name_node.get(actor1_n);
                    	Nodes actor2 = name_node.get(actor2_n);
                        actor1.addEdge(e1);
                        actor2.addEdge(e2);
			edges.add(e1);
                    }
                }
                index = i;
                currMovie = curr;
            }
            else if (i == m_a.size() - 1){
                for (int j = index; j <= i; j++){
                    for (int k = j + 1; k <= i; k++){
                        String actor1_n = actor.get(m_a.get(j).split("~")[1]);
			String actor2_n = actor.get(m_a.get(j).split("~")[1]);
                        Edges e1 = new Edges(actor1_n, actor2_n, currMovie);
                        Edges e2 = new Edges(actor2_n, actor1_n, currMovie);
                        Nodes actor1 = name_node.get(actor1_n);
                    	Nodes actor2 = name_node.get(actor2_n);
                        actor1.addEdge(e1);
                        actor2.addEdge(e2);
			edges.add(e1);
                    }
                }
            }
        }
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
        queue.add(s);
        boolean yay = false;
        while(!queue.isEmpty()){
            Nodes currNode = queue.poll();
            currNode.visit();
            prev = currNode;
            if (currNode.getName().equals(end)){
                yay = true;
                break;
            }
            for (int i = 0; i < currNode.edgeNum(); i++){
            	Nodes o = name_node.get(currNode.getEdges().get(i).end);
                if (!o.getVisited() && !o.hasPrev()){
                    o.setPrev(prev);
                    queue.add(o);
                }
            }
        }
        if(yay) {
            Stack<Nodes> backtrack = new Stack<Nodes>();
	    Stack<Nodes> dup = new Stack<Nodes>();
            Queue<String> movies = new LinkedList<String>();
            Nodes target = name_node.get(end);
            backtrack.add(target);
	    dup.add(target);
            while (!target.getName().equals(start)) {
                target = target.getPrev();
                backtrack.add(target);
		dup.add(target);
            }
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
            return "They're unrelated, how sad :((";
        }
    }
	public String Movie(HashMap<String, Nodes> name_node, String end) {
		Edges m = name_node.get(end).getEdges().get(0);
		return m.getMovie();
	}
	public String BaconNum(HashMap<String, Nodes> name_node, String end) {
		if (name_node.get(end) == null){
            return "Who is this character, never heard of them :0";
        }
        String ans = "";
        String k  = "Kevin Bacon";
        Nodes s = name_node.get(k);
        Nodes prev = s;
        Queue<Nodes> queue = new LinkedList<Nodes>();
        queue.add(s);
        boolean yay = false;
        while(!queue.isEmpty()){
            Nodes currNode = queue.poll();
            currNode.visit();
            prev = currNode;
            if (currNode.getName().equals(end)){
                yay = true;
                break;
            }
            for (int i = 0; i < currNode.edgeNum(); i++){
            	Nodes o = name_node.get(currNode.getEdges().get(i).end);
                if (!o.getVisited() && !o.hasPrev()){
                    o.setPrev(prev);
                    queue.add(o);
                }
            }
        }
        if(yay) {
            int num = 0;
            Stack<Nodes> backtrack = new Stack<Nodes>();
	    Stack<Nodes> dup = new Stack<Nodes>();
            Queue<String> movies = new LinkedList<String>();
            Nodes target = name_node.get(end);
            backtrack.add(target);
	    dup.add(target);
            while (!target.getName().equals(k)) {
                target = target.getPrev();
                backtrack.add(target);
		dup.add(target);
            }
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
                num++;
            }
            return Integer.toString(num);
        }
        else{
            return "Your actor is not cool enough to have a bacon number, sorryy";
        }
	}
}
