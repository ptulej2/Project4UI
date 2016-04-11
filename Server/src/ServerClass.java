/**
 * This is the Server Chat GUI Window.
 */

import javax.swing.*; //Used for the JFrame
import javax.swing.border.Border;
import java.awt.*;

public class ServerClass extends JFrame {

    public static final String TITLE = "CHAT SERVER"; //Title of server
    private static ServerClass instance;

    private JTextArea console; // Components of JFrame
    private JList listUsers;


    public ServerClass() {
        createView();

        setTitle(TITLE);
        setSize(500,400);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    private void createView(){
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(new BorderLayout());

        console = new JTextArea();
        console.setEditable(false);
        console.setLineWrap(true);
        console.setForeground(Color.BLUE);
        JScrollPane consoleSP = new JScrollPane(console);
        consoleSP.setBorder(BorderFactory.createTitledBorder("Console Output"));
        panel.add(consoleSP, BorderLayout.CENTER);

        listUsers = new JList();
        JScrollPane listUsersSP = new JScrollPane(listUsers);
        listUsersSP.setPreferredSize(new Dimension(200, 0));
        listUsersSP.setBorder(BorderFactory.createTitledBorder("List of clients"));
        panel.add(listUsersSP, BorderLayout.EAST);
    }

    public static ServerClass getInstance() {
        return instance;
    }

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               instance =  new ServerClass();
               instance.setVisible(true);
            }
        });
    }
}
