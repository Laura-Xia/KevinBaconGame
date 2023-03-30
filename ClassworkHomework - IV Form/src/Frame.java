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
    JTextField actor;
    JLabel actorLabel;
    JTextArea output2;
    JLabel outputlabel2;
    JLabel movieLabel;
    JTextField movie;
    JLabel outputlabel;
    JButton button;
    JButton button2;
    String aStart;
    String aEnd;
    String aName;
    static final Graph g = new Graph();

    BFS b = new BFS();

    HashMap<String, Nodes> name_node = g.buildGraph();

    Frame() throws IOException {
        this.setLayout(new FlowLayout());
        this.setTitle("Kevin Bacon Game");
        start = new JTextField();
        start.setPreferredSize(new Dimension(250, 40));
        startLabel = new JLabel("1st Actor:");
        end = new JTextField();
        end.setPreferredSize(new Dimension(250, 40));
        endLabel = new JLabel("2nd Actor:");
        output = new JTextArea();
        output.setPreferredSize(new Dimension(780, 70));
        output.setLineWrap(true);
        outputlabel = new JLabel("Relation:");
        actor = new JTextField();
        actor.setPreferredSize(new Dimension(250, 40));
        actorLabel = new JLabel("Actor name:");
        output2 = new JTextArea();
        output2.setPreferredSize(new Dimension(780, 70));
        output2.setLineWrap(true);
        outputlabel2 = new JLabel("Kevin Bacon Number:");
        movie = new JTextField();
        movie.setPreferredSize(new Dimension(250, 40));
        movieLabel = new JLabel("This Actor was in:");
        button = new JButton("Submit");
        button.addActionListener(this);
         button2 = new JButton("Submit");
         button2.addActionListener(this);
        this.add(startLabel);
        this.add(start);
        this.add(endLabel);
        this.add(end);
        this.add(button);
        this.add(outputlabel);
        this.add(output);
        this.add(actorLabel);
        this.add(actor);
        this.add(button2);
        this.add(outputlabel2);
         this.add(output2);
         this.add(movieLabel);
         this.add(movie);
        this.setSize(800, 500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            for (String i : name_node.keySet()){
            	name_node.get(i).setPrev(null);
            	name_node.get(i).antiVisit();
            }
            aStart = start.getText();
            aEnd = end.getText();
            output.setText(b.findPath(name_node, aStart, aEnd));
        }
         if(e.getSource()==button2){
             for (String i : name_node.keySet()){
             	name_node.get(i).setPrev(null);
             	name_node.get(i).antiVisit();
             }
             aName = actor.getText();
             output2.setText(b.BaconNum(name_node, aName));
             movie.setText(b.Movie(name_node, aName));
         }
    }
}
