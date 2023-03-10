
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class Frame extends JFrame implements ActionListener {

    JTextField start;
    JLabel startLabel;
    JTextField end;
    JLabel endLabel;
    JTextArea output;
    JLabel recommendedMovieLabel;
    JTextField recommendedMovie;
    JLabel outputlabel;
    JButton button;

    String actorStart;

    String actorEnd;

    static final Graph graph = new Graph();

    BFS bfs = new BFS();

    HashMap<String, Nodes> nameToActor = graph.buildGraph();

    Frame() throws IOException {
        this.setLayout(new FlowLayout());
        this.setTitle("Kevin Bacon Game");
        start = new JTextField();
        start.setPreferredSize(new Dimension(250, 40));
        startLabel = new JLabel("Input Start Actor:");
        end = new JTextField();
        end.setPreferredSize(new Dimension(250, 40));
        endLabel = new JLabel("Input End Actor:");
        output = new JTextArea();
        output.setPreferredSize(new Dimension(780, 200));
        output.setLineWrap(true);
        outputlabel = new JLabel("Connection:");
        recommendedMovie = new JTextField();
        recommendedMovie.setPreferredSize(new Dimension(250, 40));
        recommendedMovieLabel = new JLabel("Recommended Movie By This Actor:");
        button = new JButton("Submit");
        button.addActionListener(this);
        this.add(startLabel);
        this.add(start);
        this.add(endLabel);
        this.add(end);
        this.add(button);
        this.add(outputlabel);
        this.add(output);
        this.add(recommendedMovieLabel);
        this.add(recommendedMovie);
        this.setSize(800, 500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            for (String i : nameToActor.keySet()){
                nameToActor.get(i).setPrev(null);
                nameToActor.get(i).antiVisit();
            }
            actorStart = start.getText();
            actorEnd = end.getText();
            output.setText(bfs.findPath(nameToActor, actorStart, actorEnd));
//            recommendedMovie.setText(bfs.getMovie(nameToActor, actorStart, actorEnd));
        }
    }
}