import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 309954
 */
public class ScorePanel extends JPanel{
      private static final Font SMALL_FONT = new Font(Font.DIALOG,Font.PLAIN,12);
    private static final Font BIG_FONT=new Font(Font.DIALOG,Font.BOLD,36);
    
    private JLabel scoreLabel = new JLabel("0");
    
    private int initialScore =0;
    private int score =0;
    
    
    public ScorePanel(int initialScore, Color color) {
        this.initialScore=initialScore;
        this.score=initialScore;
        setBackground(color);
        
        JLabel scoreTitleLabel = new JLabel("Score: ");
        scoreTitleLabel.setFont(SMALL_FONT);
        add(scoreTitleLabel);
        
        scoreLabel.setFont(BIG_FONT);
        add(scoreLabel);
        
    }
    
    public void addToScore(int points){
        score +=points;
        scoreLabel.setText(score+"");
    }
    
    public void reset(){
        score=initialScore;
        scoreLabel.setText(score+"");
    }
    
    
}
