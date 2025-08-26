
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*

 */
/**
 *
 * @author 309954
 */
//Rushi Patel
//2025-01-15
//MatchThree
public class MatchThree extends JFrame {

    private ScorePanel scorePanel = new ScorePanel(0, Color.green);
    private BallPanel ballPanel = new BallPanel(this);
    
    private static final long serialVersionUID = 1L;

    private Font font = new Font(Font.DIALOG, Font.BOLD, 36);
    private TimerPanel timerPanel = new TimerPanel(0, font);

    public MatchThree() {

        initGUI();
        setTitle("Match Three");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initGUI() {
        TitleLabel titleLabel = new TitleLabel("Match Three");
        add(titleLabel, BorderLayout.PAGE_START);
        // main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.green);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel, BorderLayout.CENTER);
        //timer panel
        mainPanel.add(timerPanel);
        timerPanel.setBackground(Color.yellow);
        JPanel buttonPanelTimer = new JPanel();
        add(buttonPanelTimer, BorderLayout.PAGE_END);
        buttonPanelTimer.setBackground(Color.red);
        //Hour Button
        JButton hourButton = new JButton();
        hourButton.setText("Hour");
        hourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnHour();
            }
        });
        buttonPanelTimer.add(hourButton);
        //minutes Button
        JButton minButton = new JButton();
        minButton.setText("Min");
        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAMinute();
            }
        });
        buttonPanelTimer.add(minButton);
        //clear Button
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        buttonPanelTimer.add(clearButton);
        //start button
        JButton startButton = new JButton();
        startButton.setText("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerPanel.start();
            }
        });
        buttonPanelTimer.add(startButton);
        //stop button

        JButton stopButton = new JButton();
        stopButton.setText("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerPanel.stop();
            }
        });
        buttonPanelTimer.add(stopButton);
        // score panel
        mainPanel.add(scorePanel);
        // ball panel
        mainPanel.add(ballPanel);
        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.black);
        mainPanel.add(buttonPanel);

        JButton hintButton = new JButton();
        hintButton.setText("Hint");
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHint();
            }
        });
        buttonPanel.add(hintButton);

    }

    private void addAnHour() {
        long time = timerPanel.getTime();
        time += 3600;
        timerPanel.setTime(time);
    }

    private void addAMinute() {
        long time = timerPanel.getTime();
        time += 60;
        timerPanel.setTime(time);
    }

    private void clear() {
        timerPanel.stop();
        timerPanel.setTime(0);
    }

    public void showHint() {
        ballPanel.showHint();
    }

    public static void main(String[] args) {
        MatchThree mt = new MatchThree();
    }

    public void addToScore(int newPoints) {
        scorePanel.addToScore(newPoints);
    }

    public void restart() {
        scorePanel.reset();
        ballPanel.setInitialBalls();
    }

}
