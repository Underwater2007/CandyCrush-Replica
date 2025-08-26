
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author patel
 */
public class TimerPanel extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private int width = 130;
    private int height = 23;
    private String timeString = "00:00:00";
    private long time = 0;
    private Thread timerThread;
    

    public TimerPanel(long time, Font font) {
        setTime(time);
        setFont(font);
        height = font.getSize();
        FontMetrics fm = getFontMetrics(font);
        width = fm.stringWidth(timeString);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawString(timeString, width, height);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(width, height);
        return size;
    }

    public void setTime(long time) {
        this.time = time;
        long h = time / 3600;
        long m = (time / 60) % 60;
        long s = time % 60;
        timeString = String.format("%02d:%02d:%02d", h, m, s);
        repaint();
    }

    public void start() {
        stop();
        timerThread = new Thread(this);
        timerThread.start();
    }

    public void run() {
        while (time > 0) {
            time--;
            setTime(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
        timesUp();
    }

    public void stop() {
        if (timerThread != null) {
            timerThread.interrupt();
            timerThread = null;
        }
    }

    public long getTime() {
        return this.time;
    }

    protected void timesUp() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src\\alarm1.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            MatchThree game = new MatchThree();

            System.out.println("Playing sound...");
            String message = "Times Up";
            int option = JOptionPane.showConfirmDialog(this, message, "Times Up", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                clip.stop();
                game.restart();
            } else {
                System.exit(0);
            }

        } catch (IOException e) {
            // Handle when the file cannot be opened
            String message = "The alarm file could not be opened.";
            JOptionPane.showMessageDialog(this, message);
        } catch (UnsupportedAudioFileException e) {
            // Handle when the file is not a valid audio file
            String message = "The alarm file is not a valid audio file.";
            JOptionPane.showMessageDialog(this, message);
        } catch (LineUnavailableException e) {
            // Handle when resources are not available to open the file
            String message = "Resources are not available to play the alarm sound.";
            JOptionPane.showMessageDialog(this, message);
        }

    }

}
