package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame implements ActionListener{
    public JLabel aliveLabel = new JLabel();
    public JLabel generationLabel = new JLabel();
    public JToggleButton playToggleButton = new JToggleButton("Pause");
    private Universe universe;
    private int N; //universe size;

    public GameOfLife() {
        super("Game Of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(501, 561);

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        dataPanel.setBounds(0,0,200,40);
        dataPanel.setBackground(Color.YELLOW);
        add(dataPanel);
        generationLabel.setName("GenerationLabel");
        generationLabel.setText("Generation #0");
        dataPanel.add(generationLabel);
        aliveLabel.setName("AliveLabel");
        aliveLabel.setText("Alive: 0");
        dataPanel.add(aliveLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.setBounds(200,0,301,40);
        buttonPanel.setBackground(Color.ORANGE);
        add(buttonPanel);
        playToggleButton.setName("PlayToggleButton");
        playToggleButton.addActionListener(this);
        buttonPanel.add(playToggleButton);
        JButton resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener(new ResetListener());
        buttonPanel.add(resetButton);

        JPanel gamePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                int i = 0, j = 0;
                Graphics2D g2 = (Graphics2D) g;
                for (int x = 0; i < N; x = x + (500 / N)) {
                    for (int y = 0; j < N; y = y + (500 / N)) {
                        if (universe.getMap()[i][j].equals("O"))
                            g2.fillRect(x,y,500 / N,500 / N);
                        else
                            g2.drawRect(x,y,500 / N,500 / N);
                        j++;
                    }
                    i++;
                    j = 0;
                }
            }
        };
        gamePanel.setBounds(0,40,501,501);
        add(gamePanel);

        setVisible(true);
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
        N = universe.getMap().length;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (playToggleButton.getText().equals("Pause")) {
            playToggleButton.setText("Play");
            Main.setPause(true);
        }
        else {
            playToggleButton.setText("Pause");
            Main.setPause(false);
            try {

                Main.play();
            } catch (InterruptedException ex) {
                System.out.println("ERROR");
            }
        }
    }


    public class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.reset();
        }
    }

}
