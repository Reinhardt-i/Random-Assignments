import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class QuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private JButton submitButton;
    private int currentQuestionIndex;
    private int score;

    private String[] questions = {
            "Question 1: What is the capital of France?",
            "Question 2: What is the largest planet in our solar system?",
            "Question 3: Who painted the Mona Lisa?"
    };

    private String[][] options = {
            {"London", "Paris", "Berlin", "Rome"},
            {"Mars", "Venus", "Saturn", "Jupiter"},
            {"Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh", "Michelangelo"}
    };

    private int[] answers = {1, 3, 1}; // Index of the correct answer for each question

    public QuizApp() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(20, 20, 360, 30);
        add(questionLabel);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBounds(20, 60, 360, 150);
        optionsPanel.setLayout(null);
        add(optionsPanel);

        optionButtons = new JRadioButton[4];
        ButtonGroup optionGroup = new ButtonGroup();

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setBounds(10, 10 + i * 30, 340, 25);
            optionsPanel.add(optionButtons[i]);
            optionGroup.add(optionButtons[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 220, 100, 30);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        startQuiz();
    }

    private void startQuiz() {
        currentQuestionIndex = 0;
        score = 0;
        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(options[currentQuestionIndex][i]);
                optionButtons[i].setSelected(false);
            }
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected() && i == answers[currentQuestionIndex]) {
                score++;
                break;
            }
        }
        currentQuestionIndex++;
        displayQuestion();
    }

    private void finishQuiz() {
        JOptionPane.showMessageDialog(this, "Quiz Finished! Your score is: " + score);
        System.exit(0);
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.setVisible(true);
    }
}
