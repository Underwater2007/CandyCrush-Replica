
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 309954
 */
public class TitleLabel extends JLabel {

    private String title;

    public TitleLabel(String title) {
        Font font = new Font("Comic Sans MS", Font.BOLD, 32);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
        setText(title);
        setFont(font);
    }
}
