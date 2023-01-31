import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// Create a Menu class which inherits JFrame and implements ActionListener interface
public class Menu extends JFrame implements ActionListener {

    // Declare buttons
    private final JButton button1;
    private final JButton button2;
    private final JButton button3;


    // Create a constructor
    Menu(){
        // Create and set up the frame

        this.setSize(800, 600); // set the size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // set the program will be closed if the exit is pressed
        this.setResizable(false);   // set the window cannot be resized
        this.setLayout(null);   // do not apply any layouts
        this.setTitle("Quiz");  // set the title of the window
        this.getContentPane().setBackground(new Color(33,40,60));   // set the background colour
        this.setVisible(true);  // make the window visible

        // Create and set up the header

        JLabel header = new JLabel("Educational Quiz"); // create the header title
        header.setFont(new Font("Montserrat", Font.BOLD, 50));  // set the title font
        header.setForeground(new Color(255, 255, 255));  // set the text colour
        header.setBounds(170, 75, 800, 60);  // set the bounds of the label
        header.setVisible(true);
        this.add(header);   // add the component to the frame

        // Create and set up buttons
        // Create border
        Border border1 = BorderFactory.createLineBorder(new Color(165, 246, 156),3);
        Border border2 = BorderFactory.createLineBorder(new Color(255, 150, 142),3);
        Border border3 = BorderFactory.createLineBorder(new Color(142,151, 255),3);

        // Create icons
        ImageIcon commerceIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("commerce.png")));
        ImageIcon englishIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("english.png")));
        ImageIcon physicsIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("physics.png")));

        // Create labels for icons
        JLabel displayArea = new JLabel();
        JLabel displayArea2 = new JLabel();
        JLabel displayArea3 = new JLabel();

        displayArea.setBounds(185,200,72,72);
        displayArea2.setBounds(185,310,72,72);
        displayArea3.setBounds(185,420,72,72);

        displayArea.setVisible(true);
        displayArea2.setVisible(true);
        displayArea3.setVisible(true);

        this.add(displayArea);
        this.add(displayArea2);
        this.add(displayArea3);

        // Set icons to labels
        displayArea.setIcon(commerceIcon);
        displayArea2.setIcon(englishIcon);
        displayArea3.setIcon(physicsIcon);

        // Apply the border
        displayArea.setBorder(border1);
        displayArea2.setBorder(border2);
        displayArea3.setBorder(border3);

        // Create buttons
        button1 = new JButton("Commerce      ");
        button2 = new JButton("English      ");
        button3 = new JButton("Physics      ");

        this.add(button1);
        this.add(button2);
        this.add(button3);

        button1.setBounds(257, 200, 350, 72);
        button2.setBounds(257, 310, 350, 72);
        button3.setBounds(257, 420, 350, 72);

        button1.setFont(new Font("Montserrat", Font.PLAIN, 24));
        button2.setFont(new Font("Montserrat", Font.PLAIN, 24));
        button3.setFont(new Font("Montserrat", Font.PLAIN, 24));

        // Set the colour of the button's text
        button1.setForeground(new Color(33,40,60));
        button2.setForeground(new Color(33,40,60));
        button3.setForeground(new Color(33,40,60));

        // Set the button colour
        button1.setBackground(new Color(165, 246, 156));
        button2.setBackground(new Color(255, 150, 142));
        button3.setBackground(new Color(142,151, 255));

        // Remove the border
        button1.setBorder(BorderFactory.createEmptyBorder()); // set no border to the button
        button2.setBorder(BorderFactory.createEmptyBorder()); // set no border to the button
        button3.setBorder(BorderFactory.createEmptyBorder()); // set no border to the button

        // Make button not highlighted
        button1.setFocusable(false);
        button2.setFocusable(false);
        button3.setFocusable(false);

        // Apply action listener to monitor whether button is pressed or not
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        // Apply the icon for the frame
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon.jpg")));
        this.setIconImage(icon.getImage());

    }


    // React on buttons

    @Override   // overriding
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){ // check whether the source is the button or not
            this.dispose(); // close this window
            new CommerceWindow();    // open new window (CommerceWindow Java class)
        }
        else if(e.getSource()==button2){
            this.dispose();
            new EnglishWindow();    // open new window (EnglishWindow Java class)
        }
        else if(e.getSource()==button3){
            this.dispose();
            new PhysicsWindow();    // open new window (PhysicsWindow Java class)
        }
    }
}
