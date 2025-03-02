import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

public class PizzaGUIFrame extends JFrame {
    JPanel mainPnl;
    JPanel pizzaOrderPnl;  // Top
    JPanel orderDisplayPnl; // Center
    JPanel controlPnl; // Bottom
    JPanel fixmentPnl;

    JPanel radioButtonsPnl;

    JTextArea displayTA;
    JScrollPane scroller;

//    JLabel titleLbl;

    JButton createOrderBtn;
    JButton clearOrderBtn;

    JRadioButton thinCrust;
    JRadioButton regularCrust;
    JRadioButton deepDishCrust;
    ButtonGroup buttonGroup;

    String crustType = "";

    JComboBox pizzaSizeCmbBx;
    String[] pizzaSize = {"Small", "Medium", "Large", "Super"};
    String selectedPizzaSize = "Small";

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

    JPanel checkBtns;

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
        mainPnl.add(pizzaOrderPnl, BorderLayout.NORTH);

        createOrderDisplayPanel();
        mainPnl.add(orderDisplayPnl, BorderLayout.CENTER);

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
        pizzaOrderPnl.setLayout(new GridLayout(3, 1));


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
//                System.out.println(crustType);
            }
        });
        regularCrust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                crustType = regularCrust.getText();
//                System.out.println(crustType);
            }
        });
        deepDishCrust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                crustType = deepDishCrust.getText();
//                System.out.println(crustType);
            }
        });

        radioButtonsPnl.add(thinCrust);
        radioButtonsPnl.add(regularCrust);
        radioButtonsPnl.add(deepDishCrust);

        pizzaSizeCmbBx = new JComboBox<>(pizzaSize);
        pizzaSizeCmbBx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedPizzaSize = (String) pizzaSizeCmbBx.getSelectedItem();
//                System.out.println(selectedPizzaSize);
            }
        });



        checkBtns = new JPanel();
        checkBtns.setLayout(new GridLayout(2, 3));
        extraCheeseCb = new JCheckBox("Extra Cheese");
        extraCheeseCb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                extraCheese = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        noPepperoniCb = new JCheckBox("No Pepperoni");
        noPepperoniCb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                noPepperoni = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        pineappleChkBx = new JCheckBox("Pineapple");
        pineappleChkBx.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                pineapple = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        mamasSauceCb = new JCheckBox("Mamas Sauce");
        mamasSauceCb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                mamasSauce = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        stuffedCrustCb = new JCheckBox("Stuffed Crust");
        stuffedCrustCb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                stuffedCrust = e.getStateChange() == ItemEvent.SELECTED;
            }
        });
        sausageCb = new JCheckBox("Sausage");
        sausageCb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                sausage = e.getStateChange() == ItemEvent.SELECTED;
            }
        });



        checkBtns.add(extraCheeseCb);
        checkBtns.add(noPepperoniCb);
        checkBtns.add(pineappleChkBx);
        checkBtns.add(mamasSauceCb);
        checkBtns.add(stuffedCrustCb);
        checkBtns.add(sausageCb);



        pizzaOrderPnl.add(radioButtonsPnl);
        pizzaOrderPnl.add(pizzaSizeCmbBx);
        pizzaOrderPnl.add(checkBtns);

        int boarderPadding = 10;
        EmptyBorder paddingBorder = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        LineBorder lineBorder = new LineBorder(Color.BLACK);
        CompoundBorder compoundBorder = new CompoundBorder(lineBorder, paddingBorder);
        EmptyBorder outerPadding = new EmptyBorder(boarderPadding, boarderPadding, boarderPadding, boarderPadding);
        CompoundBorder compoundBorder2 = new CompoundBorder(outerPadding, compoundBorder);

        TitledBorder titledBorder = new TitledBorder(compoundBorder2, "Order a Pizza", TitledBorder.CENTER, TitledBorder.TOP);
        titledBorder.setTitleFont(new Font("Ubuntu", Font.BOLD, 20));  // Optional: Set title font style

        pizzaOrderPnl.setBorder(titledBorder);
    }

    private void createOrderDisplayPanel()
    {
        orderDisplayPnl = new JPanel();
        fixmentPnl = new JPanel();
        displayTA = new JTextArea(20, 42);
        displayTA.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));


        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);

        fixmentPnl.add(scroller);
        orderDisplayPnl.add(fixmentPnl);

    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        createOrderBtn = new JButton("Order!");
        createOrderBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        createOrderBtn.addActionListener((ActionEvent ae) ->
        {
            String output = CreateOrder(crustType, selectedPizzaSize, extraCheese, noPepperoni, pineapple, mamasSauce, stuffedCrust, sausage);
            displayTA.setText(output);
            System.out.println(output);
        });

        clearOrderBtn = new JButton("Clear Order");
        clearOrderBtn.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        clearOrderBtn.addActionListener((ActionEvent ae) -> {
            displayTA.setText(""); // Clear text area
            buttonGroup.clearSelection(); // Deselect radio buttons
            pizzaSizeCmbBx.setSelectedIndex(0); // Reset combo box
            extraCheeseCb.setSelected(false);
            noPepperoniCb.setSelected(false);
            pineappleChkBx.setSelected(false);
            mamasSauceCb.setSelected(false);
            stuffedCrustCb.setSelected(false);
            sausageCb.setSelected(false);

            // Reset values
            crustType = "";
            selectedPizzaSize = "Small";
            extraCheese = false;
            noPepperoni = false;
            pineapple = false;
            mamasSauce = false;
            stuffedCrust = false;
            sausage = false;
        });


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Ubuntu Thin", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to quit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });




        controlPnl.add(createOrderBtn);
        controlPnl.add(clearOrderBtn);
        controlPnl.add(quitBtn);

    }


    private String CreateOrder(String crustTypeIn, String selectedPizzaSizeIn, boolean extraCheeseIn, boolean noPepperoniIn, boolean pineappleIn, boolean mamasSauceIn, boolean stuffedCrustIn, boolean sausageIn){
        double pizzaSizeCost;
        double total;
        double tax;
        double taxRate = 0.07;
        if(selectedPizzaSizeIn.equals("Small")){
            pizzaSizeCost = 8.00;
        } else if(selectedPizzaSizeIn.equals("Medium")){
            pizzaSizeCost = 12.00;
        } else if(selectedPizzaSizeIn.equals("Large")){
            pizzaSizeCost = 16.00;
        } else if(selectedPizzaSizeIn.equals("Super")){
            pizzaSizeCost = 20.00;
        } else {
            pizzaSizeCost = 0.00;
            System.out.println(selectedPizzaSizeIn + " is not a valid pizza size");
        }

        String crustTypeOut ="";
        if (crustTypeIn.equals("Thin Crust")){
            crustTypeOut = "Thin Crust     ";
        } else if(crustTypeIn.equals("Regular Crust")){
            crustTypeOut = "Regular Crust  ";
        } else if(crustTypeIn.equals("Deep-Dish Crust")){
            crustTypeOut = "Deep Dish Crust";
        } else {
            crustTypeOut = "";
            System.out.println(crustTypeIn + "is not a valid crust type");
        }


        String ingredientsOut = "";
        double ingredientsCost = 0.00;
        if (extraCheeseIn){
            ingredientsOut += "Extra Cheese                 Price: $1.00\n";
            ingredientsCost = ingredientsCost + 1.00;
        }
        if (noPepperoniIn){
            ingredientsOut += "No Pepperoni                 Price: $1.00\n";
            ingredientsCost = ingredientsCost + 1.00;
        }
        if (pineappleIn){
            ingredientsOut += "Pineapple                    Price: $1.00\n";
            ingredientsCost = ingredientsCost + 1.00;

        }
        if (mamasSauceIn){
            ingredientsOut += "Mamas Sauce                  Price: $1.00\n";
            ingredientsCost = ingredientsCost + 1.00;
        }
        if (stuffedCrustIn){
            ingredientsOut += "Stuffed Crust                Price: $1.00\n";
            ingredientsCost = ingredientsCost + 1.00;
        }
        if (sausageIn){
            ingredientsOut += "Sausage                      Price: $1.00\n";
            ingredientsCost = ingredientsCost + 1.00;
        }




        String returnString = "";
        String spaces = "";
        if (selectedPizzaSizeIn.equals("Small")){
            spaces += "  ";
        } else if (!selectedPizzaSizeIn.equals("Medium")){
            spaces = " ";
        }
        String crustType = selectedPizzaSizeIn + " " + crustTypeOut + spaces + "      Price: $" + pizzaSizeCost + "0";

        spaces = "";
        if (selectedPizzaSizeIn.equals("Small") && ingredientsCost == 0){
            spaces += " ";
        }
        total = pizzaSizeCost + ingredientsCost;
        tax = total * taxRate;
        DecimalFormat df = new DecimalFormat("#.##");
        double taxFixed  = Double.parseDouble(df.format(tax));
        double superTotal = total + taxFixed;
        returnString += "=========================================\n";
        returnString += crustType + "\n";
        returnString += ingredientsOut + "\n";
        returnString += "Sub-Total                          $" + spaces+ total + "0\n";
        returnString += "Tax                                 $" + taxFixed + "\n";
        returnString += "-----------------------------------------\n";
        returnString += "Total                              $" + spaces + superTotal + "\n";
        returnString += "=========================================\n";




        return returnString;
    };

}
