import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillWindow extends JFrame implements ActionListener {

    private int width = 400;
    private int height = 400;

    private JButton close;

    public BillWindow(){

        super("RECHNUNG");

        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.setLayout(new BorderLayout());
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout());
        panelCenter.setBackground(Color.DARK_GRAY);

        JTextArea endText = new JTextArea();

        endText.setFont(new Font("Arial", Font.BOLD, 20));
        endText.setForeground(Color.WHITE);
        endText.setBackground(Color.DARK_GRAY);
        endText.setMargin(new Insets(30,30,30,30));

        endText.setText("DANKE FÜR IHR BESUCH!\n\nWIR WÜNSCHEN IHNEN\nEINEN SCHÖNEN TAG!");

        JFrame frame = new JFrame();
        Container c = frame.getContentPane();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("smiley2.png"));
        Dimension size = label.getPreferredSize();
        label.setBounds(180, 200, 100,100);
        c.add(label);

        this.add(label, BorderLayout.CENTER);
        this.add(endText, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(Color.BLACK);

        close =  new JButton();
        close.setLayout(new FlowLayout(FlowLayout.LEADING));
        close.setText("<html>SCHLIESSEN</html>");
        panelSouth.add(close);

        this.add(panelSouth, BorderLayout.SOUTH);


        setVisible(true);

        close.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close){
            dispose();
        }
    }
}
