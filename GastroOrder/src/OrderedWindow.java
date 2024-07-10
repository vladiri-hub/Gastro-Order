import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

public class OrderedWindow extends JFrame implements ActionListener {

    HashMap<String, Integer> orderMap;
    private int width = 800, height = 800;

    private JButton payment;
    private JButton moreOrder;

    private int billNumber;

    public OrderedWindow(HashMap<String, Integer>hm){
        super("ORDER");

        double[] prices = {2.50, 3, 4.20};

        double price = 0;

        double totalPrice = 0;

        orderMap = hm;

        this.setSize(width, height);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - this.width) / 2,
                (screenSize.height - this.height) / 2);

        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();

        //Panel North
        panelNorth.setBackground(Color.BLACK);

        JTextArea rechnung = new JTextArea();
        rechnung.setFont(new Font("Arial", Font.BOLD,20));
        rechnung.setForeground(Color.WHITE);
        rechnung.setBackground(Color.BLACK);
        rechnung.setMargin(new Insets(0,30,40,30));
        rechnung.setText("BESTELLUNG");
        panelNorth.add(rechnung);

        this.add(panelNorth, BorderLayout.NORTH);

        //Panel South
        panelSouth.setBackground(Color.BLACK);

        Random random = new Random();
        int number = random.nextInt(1000000);
        JTextArea billNumber = new JTextArea();
        billNumber.setFont(new Font("Arial", Font.ITALIC,15));
        billNumber.setForeground(Color.WHITE);
        billNumber.setBackground(Color.BLACK);
        billNumber.setText("RECHNUNGSNUMMER: "+ String.valueOf(number));
        billNumber.setBounds(10, 10, 40, 40);
        //String number = String.valueOf(billNumber);
        panelSouth.add(billNumber);

        moreOrder = new JButton();
        moreOrder.setText("WEITERE BESTELLUNGEN");
        panelSouth.add(moreOrder);

        payment = new JButton();
        payment.setText("BEZAHLEN");
        panelSouth.add(payment);

        this.add(panelSouth, BorderLayout.SOUTH);

        panelCenter.setBackground(Color.DARK_GRAY);

        JTextArea bestellung = new JTextArea();
        bestellung.setFont(new Font("Arial", Font.BOLD,20));
        bestellung.setForeground(Color.WHITE);
        bestellung.setBackground(Color.DARK_GRAY);
        bestellung.setMargin(new Insets(0,30,40,30));
        bestellung.setText("ARTIKEL\t\t" + "MENGE\t\t" + "PREIS\n\n");
        for (String i : hm.keySet()) {

            if (i == "Kaffee"){
                price = hm.get(i)*prices[0];
            } else if (i == "Wasser") {
                price = hm.get(i)*prices[1];
            } else if (i == "Kuchen") {
                price = hm.get(i)*prices[2];
            }
            totalPrice += price;
            bestellung.append(String.format("%s\t\t" + "%s\t\t" + String.format("%.2f", price) + " EUR\t\n", i, hm.get(i)));
        }
        bestellung.append("\n\t\t"+ "Gesamtbetrag: \t" + String.format("%.2f", totalPrice) + " EUR");

        panelCenter.add(bestellung);


        this.add(panelCenter, BorderLayout.CENTER);






        setVisible(true);

        moreOrder.addActionListener(this);
        payment.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == moreOrder){
            new NewOrderWindow();
            dispose();
            //TODO
        }
        if (e.getSource() == payment){
            new BillWindow();
            dispose();
        }
    }
}
