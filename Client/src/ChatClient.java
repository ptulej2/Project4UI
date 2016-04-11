/**
 * This is the client chat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient extends JFrame {
    public static final String TITLE = "Chat Client";
    private static ChatClient instance;

    private JList listUsers; //List of user connected
    private JTextArea textChat; //Chat Text
    private JTextField fieldInput; //User input
    private JButton buttonSend; //Send the message

    public ChatClient(){
        createView();

        setTitle(TITLE); //Create the window
        setSize(600, 500);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    private void createView(){
        JPanel panel = new JPanel(); // JPanel is a General Container
        getContentPane().add(panel);
        panel.setLayout(new BorderLayout());

        listUsers = new JList();
        JScrollPane listUsersSP = new JScrollPane(listUsers);
        listUsersSP.setPreferredSize(new Dimension(200, 0));
        listUsersSP.setBorder(BorderFactory.createTitledBorder("people online")); /* show the people that are online */
        panel.add(listUsersSP, BorderLayout.EAST);

        JPanel panelChat = new JPanel(new BorderLayout());
        panel.add(panelChat, BorderLayout.CENTER);

        textChat = new JTextArea();
        textChat.setEditable(false);
        JScrollPane textChatSp = new JScrollPane(textChat);
        panelChat.add(textChatSp, BorderLayout.CENTER);

        JPanel panelInput = new JPanel(new BorderLayout());
        panel.add(panelInput, BorderLayout.SOUTH);
        fieldInput = new JTextField();
        panelInput.add(fieldInput, BorderLayout.CENTER);
        buttonSend = new JButton("Send");
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panelInput.add(buttonSend, BorderLayout.EAST);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                instance =  new ChatClient();
                instance.setVisible(true);
            }
        });
    }
}
