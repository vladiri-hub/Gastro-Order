import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartWindow extends JFrame implements ActionListener {

    private int width = 400;
    private int height = 400;

    private JButton newOrder;

    public  StartWindow() {

        super("WELCOME");

        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width-this.width)/2,
                (screenSize.height-this.height)/2 );


        this.setLayout(new BorderLayout());
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout());

        panelCenter.setBackground(Color.DARK_GRAY);
        this.add(panelCenter, BorderLayout.CENTER);

        newOrder =  new JButton();
        newOrder.setText("<html><h2>NEUE BESTELLUNG</h2></html>");

        panelCenter.add(newOrder);


        JTextArea orderManuel = new JTextArea();

        orderManuel.setFont(new Font("Arial", Font.ITALIC, 20));
        orderManuel.setForeground(Color.WHITE);
        orderManuel.setBackground(Color.DARK_GRAY);
        orderManuel.setMargin(new Insets(30,30,30,30));

        orderManuel.setText("DAS IST EINE DEMO-SOFTWARE \nZUR SELBSBESTELLUNG...");

        this.add(orderManuel, BorderLayout.NORTH);

        setVisible(true);

        newOrder.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource() == newOrder) {

          new NewOrderWindow();
          dispose();
      }

    }
}


