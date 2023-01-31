import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PhysicsWindow extends JFrame implements ActionListener {

    private final JRadioButton option1;
    private final JRadioButton option2;
    private final JRadioButton option3;
    private final JRadioButton option4;
    private final JButton button;
    private final JButton exitButton;
    private final JLabel label;
    private final JProgressBar bar;
    private final JLabel pointsCounter;
    private final Map<Integer, String[]> questions;
    private final String[] answersArray;
    private String[] question;
    private int index;
    private int points;
    private final int totalQuestions;
    private int barCounter;
    private int cnt = 0;

    PhysicsWindow() {
        this.setTitle("Physics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(new Color(142,151, 255));
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);

        // Create a progress bar

        bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(0, 0, 800, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("Montserrat", Font.BOLD, 25));
        bar.setForeground(new Color(0, 166, 87));
        bar.setBackground(Color.white);
        this.add(bar);

        // Create a label for questions

        label = new JLabel();
        label.setBounds(50, 40, 700, 150);
        label.setFont(new Font("Montserrat", Font.BOLD, 28));
        label.setForeground(new Color(33,40,60));
        this.add(label);

        // Create points counter

        points = 0;
        pointsCounter = new JLabel(String.valueOf(points));
        pointsCounter.setBounds(600, 180, 200, 300);
        pointsCounter.setFont(new Font("Montserrat", Font.BOLD, 125));
        pointsCounter.setForeground(new Color(0, 166, 87));
        this.add(pointsCounter);

        // Create a submit button

        button = new JButton();
        button.setBounds(50, 460, 200, 60);
        button.setFont(new Font("Montserrat", Font.BOLD, 25));
        button.setForeground(new Color(33,40,60));
        button.setBackground(new Color(0, 166, 87));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addActionListener(this);
        button.setFocusable(false);
        button.setText("submit");
        this.add(button);

        // Create an exit button

        exitButton = new JButton("Back");
        exitButton.setBounds(530, 460, 200, 60);
        exitButton.setFont(new Font("Montserrat", Font.BOLD, 25));
        exitButton.setForeground(new Color(33,40,60));
        exitButton.setBackground(new Color(0, 166, 87));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setVisible(false);
        this.add(exitButton);

        // Create the first radio button
        option1 = new JRadioButton();   // set up radio buttons
        option1.setBounds(50, 200, 500, 25);
        option1.setFont(new Font("Montserrat", Font.BOLD, 20));
        option1.setBackground(new Color(142,151, 255));
        option1.setForeground(new Color(33,40,60));
        option1.setFocusable(false);
        option1.addActionListener(this);
        this.add(option1);

        // Create the second radio button

        option2 = new JRadioButton();
        option2.setBounds(50, 260, 500, 25);
        option2.setFont(new Font("Montserrat", Font.BOLD, 20));
        option2.setBackground(new Color(142,151, 255));
        option2.setForeground(new Color(33,40,60));
        option2.setFocusable(false);
        option2.addActionListener(this);
        this.add(option2);

        // Create the third radio button

        option3 = new JRadioButton();
        option3.setBounds(50, 320, 500, 25);
        option3.setFont(new Font("Montserrat", Font.BOLD, 20));
        option3.setBackground(new Color(142,151, 255));
        option3.setForeground(new Color(33,40,60));
        option3.setFocusable(false);
        option3.addActionListener(this);
        this.add(option3);

        // Create the fourth radio button

        option4 = new JRadioButton();
        option4.setBounds(50, 380, 500, 25);
        option4.setFont(new Font("Montserrat", Font.BOLD, 20));
        option4.setBackground(new Color(142,151, 255));
        option4.setForeground(new Color(33,40,60));
        option4.setFocusable(false);
        option4.addActionListener(this);
        this.add(option4);

        // Group buttons (to disable the option to choose a few radio buttons simultaneously)
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        // Algorithm creating a question

        // Algorithm creating a question

        String[] questionsArray = {

                "Identify as scalar or vector: the mass of an object, the number of leaves on a tree, wind velocity.",
                "Which of the following is a physical quantity that has a magnitude but no direction?",
                "Which of the following is an example of a vector quantity?",
                "What type of lens is a Magnifying Glass?",
                "What is the bending of light rays due to a change in speed as the rays pass through a substance, called?",
                "Which type of mirror makes objects appear smaller, but the area of view larger?",
                "A convex lens will make an image appear ______ if the object is placed between the focal point and the lens.",
                "Another name for a pivot is a",
                "For a see-saw to balance, the anti-clockwise  moment must equal the ________________",
                "Moment is the:"

        };


        answersArray = new String[]{

                "scalar, scalar, vector",
                "scalar",
                "velocity",
                "convex",
                "refraction",
                "convex",
                "larger and right side up",
                "fulcrum",
                "clockwise moment",
                "turning effect of a force"

        };

        String[] optionsArray = {

                answersArray[0], "vector, scalar, scalar", "vector, scalar, vector", "scalar, vector, vector",
                answersArray[1], "frame of reference", "resultant", "vector",
                "volume", "mass", "temperature", answersArray[2],
                answersArray[3], "concave", "parabolic", "plane",
                "reflection", answersArray[4], "diffraction", "diffusion",
                answersArray[5], "plane", "parabolic", "concave",
                "smaller and right side up", "larger and upside down", "smaller and upside down", answersArray[6],
                answersArray[7], "tool", "falcon", "none of these",
                "weight", "mass", answersArray[8], "none",
                answersArray[9], "airflow", "mass", "weight"

        };

        questions = new HashMap<>();

        String[] container = new String[5];
        int i = 1;
        int key = 0;
        for (String o : optionsArray) {
            container[i] = o;
            i += 1;
            if (i == 5) {
                questions.put(key, Arrays.copyOf(container, container.length));
                key += 1;
                i = 1;
                container = new String[5];
            }
        }
        key = 0;

        for (String q : questionsArray) {
            questions.get(key)[0] = q;
            key += 1;
        }

        totalQuestions = questions.size();  // count the number of questions
        barCounter = 0; // set the bar initial state

        // Set the first page
        index = 0;  // set the question index
        question = questions.get(index);    // get the first question
        label.setText("<HTML>"+ question[0] + "</HTML>"); // HTML tags for text wrapping
        option1.setText(question[1]);   // set options
        option2.setText(question[2]);
        option3.setText(question[3]);
        option4.setText(question[4]);

        // Apply the icon for the frame
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon.jpg")));
        this.setIconImage(icon.getImage());

    }

    // Set a next question function
    void setQuestion() {
        if (index != totalQuestions - 1) {
            index += 1; // next question
            question = questions.get(index); // get the question
            label.setText("<HTML>"+ question[0] + "</HTML>");
            option1.setText(question[1]);
            option1.setForeground(new Color(33,40,60)); // restore text colour
            option2.setText(question[2]);
            option2.setForeground(new Color(33,40,60));
            option3.setText(question[3]);
            option3.setForeground(new Color(33,40,60));
            option4.setText(question[4]);
            option4.setForeground(new Color(33,40,60));
        }
        else {  // if the last question is completed
            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);
            button.setEnabled(false);
            exitButton.setVisible(true);
        }
    }

    // React on answers
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (option1.isSelected() | option2.isSelected() | option3.isSelected() | option4.isSelected()) {    // condition that is checking whether at least one button pressed or not
                if (option1.isSelected() & Objects.equals(answersArray[index], option1.getText()) |
                        option2.isSelected() & Objects.equals(answersArray[index], option2.getText()) |
                        option3.isSelected() & Objects.equals(answersArray[index], option3.getText()) |
                        option4.isSelected() & Objects.equals(answersArray[index], option4.getText())) { // condition that is checking whether the selected answer is correct
                    if(cnt == 0){   // condition that is checking whether the user answered the question on the first try
                        points += 1;    // add one point if the user answered the question on the first try
                    }
                    if(cnt != 0){ // reset the attempts to zero
                        cnt = 0;
                    }
                    pointsCounter.setText(String.valueOf(points)); // change the points counter
                    barCounter += (100 / totalQuestions);   // change the state of the progress bar
                    bar.setValue(barCounter);   // change the state of the progress bar
                    setQuestion();  // next question function
                } else {    // condition that works if the user made a mistake
                    cnt += 1;   // attempts
                    if (Objects.equals(option1.getText(), answersArray[index])) {    // shows the correct answer
                        option1.setForeground(new Color(0, 166, 87));
                    } else if (Objects.equals(option2.getText(), answersArray[index])) {
                        option2.setForeground(new Color(0, 166, 87));
                    } else if (Objects.equals(option3.getText(), answersArray[index])) {
                        option3.setForeground(new Color(0, 166, 87));
                    } else if (Objects.equals(option4.getText(), answersArray[index])) {
                        option4.setForeground(new Color(0, 166, 87));
                    }
                }
            }
        }   else if(e.getSource() == exitButton) {  // if the source is the exit button, then open the menu window and close the current one
            new Menu();
            this.dispose();
        }
    }
}

