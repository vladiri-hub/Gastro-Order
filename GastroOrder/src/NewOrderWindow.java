import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NewOrderWindow extends JFrame implements ActionListener {

    HashMap<String, Integer> orderMap = new HashMap<>();
    private int width = 800, height = 800;

    int caffeeCounter = 0;
    int waterCounter = 0;
    int cakeCounter = 0;

    private JButton caffee;
    private JButton water;
    private JButton cake;
    private JButton minusCaffee;
    private JButton minusWater;
    private JButton minusCake;

    private JButton cancel;
    private JButton order;



    public NewOrderWindow(){
        super("CHOICE");

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





        panelNorth.setBackground(Color.BLACK);
        //this.add(panelNorth, BorderLayout.NORTH);

        JTextArea choiceManuel = new JTextArea();
        choiceManuel.setFont(new Font("Arial", Font.BOLD,20));
        choiceManuel.setForeground(Color.WHITE);
        choiceManuel.setBackground(Color.BLACK);
        choiceManuel.setMargin(new Insets(0,30,40,30));
        choiceManuel.setText("BITTE ARTIKEL AUSWÄHLEN");
        panelNorth.add(choiceManuel);

        this.add(panelNorth, BorderLayout.NORTH);

        //??
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.DARK_GRAY);


        caffee =  new JButton();
        caffee.setText("<html><h1>KAFFEE</h1></html>");

        minusCaffee = new JButton();
        minusCaffee.setText("<html><h1>-</h1></html>");

        water =  new JButton();
        water.setText("<html><h1>WASSER</h1></html>");

        minusWater = new JButton();
        minusWater.setText("<html><h1>-</h1></html>");

        cake =  new JButton();
        cake.setText("<html><h1>KUCHEN</h1></html>");

        minusCake = new JButton();
        minusCake.setText("<html><h1>-</h1></html>");



        Dimension size = caffee.getPreferredSize();
        caffee.setBounds(30, 30, 200, 60);
        size = water.getPreferredSize();
        water.setBounds( 30,100,200, 60);
        size = cake.getPreferredSize();
        cake.setBounds(30, 170, 200, 60);

        size = minusCaffee.getPreferredSize();
        minusCaffee.setBounds(250, 30,60, 60);
        size = minusWater.getPreferredSize();
        minusWater.setBounds(250, 100,60, 60);
        size = minusCake.getPreferredSize();
        minusCake.setBounds(250, 170,60, 60);

        panelCenter.add(caffee);
        panelCenter.add(water);
        panelCenter.add(cake);

        panelCenter.add(minusCaffee);
        panelCenter.add(minusWater);
        panelCenter.add(minusCake);

        ///
        
        this.add(panelCenter, BorderLayout.CENTER);

        panelSouth.setBackground(Color.BLACK);

        cancel =  new JButton();
        //cancel.setLayout(new FlowLayout(FlowLayout.LEADING));
        cancel.setText("<html>ABBRECHEN</html>");
        panelSouth.add(cancel);

        order =  new JButton();
        order.setLayout(new FlowLayout(FlowLayout.TRAILING));
        order.setText("<html>BESTELLEN</html>");
        panelSouth.add(order);

        this.add(panelSouth, BorderLayout.SOUTH);


        setVisible(true);

        cancel.addActionListener(this);
        order.addActionListener(this);
        caffee.addActionListener(this);
        water.addActionListener(this);
        cake.addActionListener(this);
        minusCaffee.addActionListener(this);
        minusWater.addActionListener(this);
        minusCake.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource()== caffee){
            if(orderMap.containsKey("Kaffee")){
                orderMap.put("Kaffee",orderMap.get("Kaffee")+1);
            }else{
                orderMap.put("Kaffee", 1);

            }
            caffeeCounter++;
            caffee.setText("<html><h1>KAFFEE   "+caffeeCounter+"</h1></html>");
            System.out.println(caffeeCounter);
        }
        if (e.getSource() == minusCaffee){
            caffeeCounter--;
            caffee.setText("<html><h1>KAFFEE    "+caffeeCounter+"</h1></html>");
        }

        if (e.getSource()== water){
            if(orderMap.containsKey("Wasser")){
                orderMap.put("Wasser",orderMap.get("Wasser")+1);
            }else{
                orderMap.put("Wasser", 1);
            }
            waterCounter++;
            water.setText("<html><h1>WASSER    "+ waterCounter +"</h1></html>");
        }
        if (e.getSource() == minusWater){
            waterCounter--;
            water.setText("<html><h1>WASSER    "+waterCounter+"</h1></html>");
        }

        if (e.getSource()== cake){
            if(orderMap.containsKey("Kuchen")){
                orderMap.put("Kuchen",orderMap.get("Kuchen")+1);
            }else{
                orderMap.put("Kuchen", 1);
            }
            cakeCounter++;
            cake.setText("<html><h1>KUCHEN "+cakeCounter+"</h1></html>");
        }
        if (e.getSource() == minusCake){
            cakeCounter--;
            cake.setText("<html><h1>KUCHEN   "+cakeCounter+"</h1></html>");
        }

        if(e.getSource() == cancel) {
            orderMap.clear();
            new StartWindow();
            dispose();
        } else if (e.getSource()== order) {

            new OrderedWindow(orderMap);
            dispose();
            System.out.println(orderMap.size());
            System.out.println(orderMap);


        }
    }
}
