import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUIFrame extends JFrame {
    JPanel mainPnl;
    JPanel pizzaOrderPnl;  // Top
    JPanel orderDisplayPnl; // Center
    JPanel controlPnl; // Bottom

    JPanel radioButtonsPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;

    JButton createOrderBtn;

    JRadioButton thinCrust;
    JRadioButton regularCrust;
    JRadioButton deepDishCrust;
    ButtonGroup buttonGroup;

    String crustType = "";

    JComboBox pizzaSizeCmbBx;
    String[] pizzaSize = {"Small", "Medium", "Large", "Super"};
    String selectedPizzaSize = "";

    JCheckBox extraCheeseCb;
    boolean extraCheese = false;
    JCheckBox noPepperoniCb;
    boolean noPepperoni = false;
    JCheckBox pineappleChkBx;
    boolean pineapple = false;
    JCheckBox mamasSauceCb;
    boolean mamasSauce = false;
    JCheckBox stuffedCrustCb;
    boolean stuffedCrust = false;
    JCheckBox sausageCb;
    boolean sausage = false;

//dev


    JButton quitBtn;


    public PizzaGUIFrame()
    {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
// center frame in screen


        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createPizzaOrderPanel();
        mainPnl.add(pizzaOrderPnl, BorderLayout.WEST);

        createOrderDisplayPanel();
        mainPnl.add(orderDisplayPnl, BorderLayout.EAST);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize((screenWidth / 4) *3, (screenHeight / 4) *3);
        setLocation(screenWidth / 8, screenHeight / 8);
        //setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createPizzaOrderPanel()
    {

        pizzaOrderPnl = new JPanel();
        pizzaOrderPnl.setLayout(new GridLayout(4, 1));
//        icon = new ImageIcon("src/Wizard.png");
        titleLbl = new JLabel("Order a Pizza", JLabel.CENTER);
        titleLbl.setFont(new Font("Ubuntu", Font.PLAIN, 36));

        radioButtonsPnl = new JPanel();
        radioButtonsPnl.setLayout(new GridLayout(1, 3));
        thinCrust = new JRadioButton("Thin Crust");
        regularCrust = new JRadioButton("Regular Crust");
        deepDishCrust = new JRadioButton("Deep-Dish Crust");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(thinCrust);
        buttonGroup.add(regularCrust);
        buttonGroup.add(deepDishCrust);


        thinCrust.setBounds(50,50,100,30);
        regularCrust.setBounds(50,80,100,30);
        deepDishCrust.setBounds(50,110,100,30);

        thinCrust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                crustType = thinCrust.getText();
                System.out.println(crustType);
            }
        });
        regularCrust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                crustType = regularCrust.getText();
                System.out.println(crustType);
            }
        });
        deepDishCrust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                crustType = deepDishCrust.getText();
                System.out.println(crustType);
            }
        });

        radioButtonsPnl.add(thinCrust);
        radioButtonsPnl.add(regularCrust);
        radioButtonsPnl.add(deepDishCrust);

        pizzaSizeCmbBx = new JComboBox<>(pizzaSize);
        pizzaSizeCmbBx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected item and update the label
                selectedPizzaSize = (String) pizzaSizeCmbBx.getSelectedItem();
                System.out.println(selectedPizzaSize);
            }
        });


        // Obscure code to align the text to the Icon!
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        pizzaOrderPnl.add(titleLbl);
        pizzaOrderPnl.add(radioButtonsPnl);
        pizzaOrderPnl.add(pizzaSizeCmbBx);
    }

    private void createOrderDisplayPanel()
    {
        orderDisplayPnl = new JPanel();
        displayTA = new JTextArea(10, 86);
        displayTA.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));


        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        orderDisplayPnl.add(scroller);
    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        createOrderBtn = new JButton("Read My Fortune!");
        createOrderBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        createOrderBtn.addActionListener((ActionEvent ae) ->
        {
//            currentFortune = rnd.nextInt(fortunes.size());
//            do {
//                currentFortune = rnd.nextInt(fortunes.size());
//            }while (currentFortune == previousFortune);
//
//            displayTA.append(fortunes.get(currentFortune) + "\n");
//            previousFortune = currentFortune;
            displayTA.append("You are reading a message!\n");
        });


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Ubuntu Thin", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(createOrderBtn);
        controlPnl.add(quitBtn);

    }
}
