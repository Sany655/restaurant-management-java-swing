
/**
 * RegisterGuest.java
 * The RegisterGuest class
 *
 * @Author CTS Unique Touch Pro
 * @Version v1.0 05th April 2022
 * @Date April 05, 2022
 *
 * Class to manage Hotel Guest Registration Information
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;
import java.sql.*;
import java.io.File;

//import java.io.IOException;
public class RegisterGuest extends JFrame implements ActionListener {
    JTextField tguestNo, tname, temail;
    JPasswordField tpassword, tconfirmPassword;
    JComboBox tguestType;
    JFormattedTextField tphone, tcreditCardNo, tcreditCardExpiryDate, tcreditCardCode, tdiscount, tregistrationDate;
    JTextArea taddress, tadditionalGuestDetails, tgeneralNotes;
    JButton submit, clear;
    double lastDouble = 0.0;

    // ----------------------------------------------------------------------
    public RegisterGuest() {
    }

    // Protected Java Database Connection
    DatabaseAccess da = new DatabaseAccess();

    // ----------------------------------------------------------------------
    public void registerGuest() {
            //Setting the Guest Form properties
            setTitle("Hotel Online Booking Management System Application: Register Guest ");
                    setBounds(262, 50, 900, 600); //size of the frame
                    setResizable(false);
                    //------------------------------------------------------------------
                    JMenuBar menuBar = new JMenuBar(); JMenu menu1 = new JMenu("File"); JMenu menu2 = new JMenu("Edit"); JMenu menu3 = new JMenu("Help");

                    menuBar.add(menu1); menuBar.add(menu2); menuBar.add(menu3);

                    //------------------------------------------------------------------
                    //Adding Components to the File option on the Main MenuBar
                    JMenuItem menu11 = new JMenuItem("Close"); menu1.add(menu11); menu11.addActionListener(e - > {
                        this.dispose();
                    });
                    //------------------------------------------------------------------
                    //Add Components to the Edit option on the Main MenuBar
                    JMenuItem menu21 = new JMenuItem("Copy"); JMenuItem menu22 = new JMenuItem("Paste"); JMenuItem menu23 = new JMenuItem("Search"); menu2.add(menu21); menu2.add(menu22); menu2.add(new JSeparator()); menu2.add(menu23);
                    //------------------------------------------------------------------
                    //Adding Components to the Help option on the Main MenuBar
                    JMenuItem menu31 = new JMenuItem("User Guide"); JMenuItem menu32 = new JMenuItem("Frequently Asked Questions"); JMenuItem menu33 = new JMenuItem("About Hotel Online Management System ");
                        JMenuItem menu34 = new JMenuItem("About Development Team"); JMenuItem menu35 = new JMenuItem("Legal Agreement and Copyright"); JMenuItem menu36 = new JMenuItem("Hotel Brief");

                        menu3.add(menu31); menu3.add(menu32); menu3.add(new JSeparator()); menu3.add(menu33); menu3.add(menu34); menu3.add(new JSeparator()); menu3.add(menu35); menu3.add(menu36);
                        //------------------------------------------------------------------
                        menu31.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(ActionEvent arg0) {
                                    try {
                                        File file = new File("docs/userGuide.pdf");
                                        Desktop desktop = Desktop.getDesktop();
                                        if (file.exists()) desktop.open(file);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        //------------------------------------------------------------------
                        menu32.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(ActionEvent arg0) {
                                    try {
                                        File file = new File("docs/faqs.pdf");
                                        Desktop desktop = Desktop.getDesktop();
                                        if (file.exists()) desktop.open(file);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        //------------------------------------------------------------------
                        menu33.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(ActionEvent arg0) {
                                    try {
                                        File file = new File("docs/aboutTheSystem.pdf");
                                        Desktop desktop = Desktop.getDesktop();
                                        if (file.exists()) desktop.open(file);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        //------------------------------------------------------------------
                        menu34.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(ActionEvent arg0) {
                                    try {
                                        File file = new File("docs/developmentTeam.pdf");
                                        Desktop desktop = Desktop.getDesktop();
                                        if (file.exists()) desktop.open(file);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        //------------------------------------------------------------------
                        menu35.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(ActionEvent arg0) {
                                    try {
                                        File file = new File("docs/legalCopyright.pdf");
                                        Desktop desktop = Desktop.getDesktop();
                                        if (file.exists()) desktop.open(file);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        //------------------------------------------------------------------
                        menu36.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(ActionEvent arg0) {
                                    try {
                                        File file = new File("docs/hotelBrief.pdf");
                                        Desktop desktop = Desktop.getDesktop();
                                        if (file.exists()) desktop.open(file);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        //------------------------------------------------------------------
                        //Guest Main Body Panel: The middle component of the JFrame
                        JPanel mainBodyPanel = new JPanel(); mainBodyPanel.setSize(900, 450); mainBodyPanel.setBackground(Color.LIGHT_GRAY);
                        //------------------------------------------------------------------
                        //Guest Sub Panel 1: The top label on the form
                        JPanel mainBodySubPanel1 = new JPanel(); mainBodySubPanel1.setLayout(null); mainBodySubPanel1.setBackground(Color.MAGENTA); mainBodySubPanel1.setPreferredSize(new Dimension(900, 40));
                        //The title on the form to be placed in mainBodySubPanel1
                        JLabel title = new JLabel("GUEST REGISTRATION PORTAL"); title.setHorizontalAlignment(JLabel.CENTER); title.setVerticalAlignment(JLabel.CENTER); title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20)); title.setForeground(Color.GREEN); title.setSize(900, 35); mainBodySubPanel1.add(title);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: Guest Data Sub Panel 2
                        JPanel mainBodySubPanel2 = new JPanel(); mainBodySubPanel2.setLayout(null); mainBodySubPanel2.setPreferredSize(new Dimension(830, 240));
                        //mainBodySubPanel2.setBackground(Color.BLUE);

                        mainBodySubPanel2.setBorder(BorderFactory.createLineBorder(Color.green));

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest ID label on the form
                        JLabel lGuestID = new JLabel("Guest ID"); lGuestID.setFont(new Font("Arial", Font.PLAIN, 14)); lGuestID.setSize(120, 20); lGuestID.setLocation(20, 20); mainBodySubPanel2.add(lGuestID);
                        //Guest Sub Panel 2: The Guest ID textbox on the form
                        JTextField tGuestID = new JTextField(); tGuestID.setFont(new Font("Arial", Font.PLAIN, 9)); tGuestID.setBackground(Color.LIGHT_GRAY); tGuestID.setText("System Assigned"); tGuestID.setForeground(Color.BLUE); tGuestID.setEditable(false); tGuestID.setSize(210, 20); tGuestID.setLocation(150, 20); mainBodySubPanel2.add(tGuestID);
                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Name label on the form
                        JLabel lname = new JLabel("Name*"); lname.setFont(new Font("Arial", Font.PLAIN, 14)); lname.setSize(120, 20); lname.setLocation(20, 50); mainBodySubPanel2.add(lname);

                        //Guest Sub Panel 2: The Guest Name textbox on the form
                        tname = new JTextField(); tname.setFont(new Font("Arial", Font.PLAIN, 15)); tname.setSize(210, 20); tname.setLocation(150, 50); this.addWindowFocusListener(new WindowAdapter() {
                            public void windowGainedFocus(WindowEvent e) {
                                tname.requestFocusInWindow();
                            }
                        }); mainBodySubPanel2.add(tname);
                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Address label on the form
                        JLabel laddress = new JLabel("Address*"); laddress.setFont(new Font("Arial", Font.PLAIN, 14)); laddress.setSize(120, 20); laddress.setLocation(20, 80); mainBodySubPanel2.add(laddress);

                        //Guest Sub Panel 2: The Guest Address textbox on the form
                        //JPanel p = new JPanel();
                        taddress = new JTextArea(); taddress.setFont(new Font("Arial", Font.PLAIN, 15)); taddress.setSize(210, 50); taddress.setLocation(150, 80); taddress.setBackground(Color.WHITE); taddress.setLineWrap(true); taddress.setEditable(true); taddress.addKeyListener(new KeyAdapter() //Prevent Tabbing within the TextArea  
                        {
                                public void keyPressed(KeyEvent e) {
                                    if (e.getKeyCode() == KeyEvent.VK_TAB) {
                                        e.consume();
                                        KeyboardFocusManager.

                                        getCurrentKeyboardFocusManager().focusNextComponent();
                                    }
                                    if (e.getKeyCode() == KeyEvent.VK_TAB &&
                                        e.isShiftDown()) {
                                        e.consume();
                                        KeyboardFocusManager.

                                        getCurrentKeyboardFocusManager().focusPreviousComponent();
                                    }
                                }
                            });

                        JScrollPane taddressScroll = new JScrollPane(taddress); taddressScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); taddressScroll.setSize(210, 50); taddressScroll.setLocation(150, 80); tname.setNextFocusableComponent(taddress); mainBodySubPanel2.add(taddressScroll);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Phone label on the form
                        JLabel lphone = new JLabel("Phone*"); lphone.setFont(new Font("Arial", Font.PLAIN, 14)); lphone.setSize(120, 20); lphone.setLocation(20, 140); mainBodySubPanel2.add(lphone);
                        //Guest Sub Panel 2: The Guest Phone textbox on the form
                        MaskFormatter tphoneMask = null;
                        try {
                            tphoneMask = new MaskFormatter("###-####"); //the # is for numeric values
                            tphoneMask.setPlaceholderCharacter('_');
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        tphone = new JFormattedTextField(tphoneMask); tphone.setFont(new Font("Arial", Font.PLAIN, 15)); tphone.setSize(210, 20); tphone.setLocation(150, 140); taddress.setNextFocusableComponent(tphone); mainBodySubPanel2.add(tphone);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Email label on the form
                        JLabel lemail = new JLabel("Email*"); lemail.setFont(new Font("Arial", Font.PLAIN, 14)); lemail.setSize(120, 20); lemail.setLocation(20, 170); mainBodySubPanel2.add(lemail);

                        //Guest Sub Panel 2: The Guest Email textbox on the form
                        temail = new JTextField(); temail.setFont(new Font("Arial", Font.PLAIN, 15)); temail.setSize(210, 20); temail.setLocation(150, 170); tphone.setNextFocusableComponent(temail); mainBodySubPanel2.add(temail);
                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Type label on the form
                        JLabel lguestType = new JLabel("Guest Type*"); lguestType.setFont(new Font("Arial", Font.PLAIN, 14)); lguestType.setSize(120, 20); lguestType.setLocation(20, 200); mainBodySubPanel2.add(lguestType);

                        //Guest Sub Panel 2: The Guest Type Combobox on the form
                        String guestRoles[] = {
                            "",
                            "Corporate",
                            "Individual"
                        }; tguestType = new JComboBox(guestRoles); tguestType.setSize(210, 20); tguestType.setLocation(150, 200); temail.setNextFocusableComponent(tguestType); mainBodySubPanel2.add(tguestType);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Credit Card Number label on the form
                        JLabel lcreditCardNo = new JLabel("Credit Card No*"); lcreditCardNo.setFont(new Font("Arial", Font.PLAIN, 14)); lcreditCardNo.setSize(120, 20); lcreditCardNo.setLocation(450, 20); mainBodySubPanel2.add(lcreditCardNo);
                        //Guest Sub Panel 2: The Guest Credit Card Number textbox on the form 
                        MaskFormatter creditCardNoMask = null;
                        try {
                            creditCardNoMask = new MaskFormatter("####-####-####-####"); //the # is for numeric values
                            creditCardNoMask.setPlaceholderCharacter('_');
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        tcreditCardNo = new JFormattedTextField(creditCardNoMask); tcreditCardNo.setFont(new Font("Arial", Font.PLAIN, 15)); tcreditCardNo.setSize(210, 20); tcreditCardNo.setLocation(600, 20); tguestType.setNextFocusableComponent(tcreditCardNo); mainBodySubPanel2.add(tcreditCardNo);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Credit Card Expiry Date label on the form 
                        JLabel lcreditCardExpiryDate = new JLabel("CC Expiry Date*"); lcreditCardExpiryDate.setFont(new Font("Arial", Font.PLAIN, 14)); lcreditCardExpiryDate.setSize(120, 20); lcreditCardExpiryDate.setLocation(450, 50); mainBodySubPanel2.add(lcreditCardExpiryDate);
                        //Guest Sub Panel 2: The Guest Credit Card Expiry Date textbox on the form 
                        MaskFormatter creditCardExpiryDateMask = null;
                        try {
                            creditCardExpiryDateMask = new MaskFormatter("####-##-##"); //the # is for numeric values
                            creditCardExpiryDateMask.setPlaceholderCharacter('_');
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        tcreditCardExpiryDate = new JFormattedTextField(creditCardExpiryDateMask); tcreditCardExpiryDate.setFont(new Font("Arial", Font.PLAIN, 15)); tcreditCardExpiryDate.setSize(100, 20); tcreditCardExpiryDate.setLocation(600, 50); tcreditCardNo.setNextFocusableComponent(tcreditCardExpiryDate); mainBodySubPanel2.add(tcreditCardExpiryDate); lcreditCardExpiryDate = new JLabel("(yyyy-mm-dd)"); lcreditCardExpiryDate.setFont(new Font("Arial", Font.PLAIN, 14)); lcreditCardExpiryDate.setSize(120, 20); lcreditCardExpiryDate.setLocation(710, 50); mainBodySubPanel2.add(lcreditCardExpiryDate);
                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Credit Card Code label on the form
                        JLabel lcreditCardCode = new JLabel("CVV Code*"); lcreditCardCode.setFont(new Font("Arial", Font.PLAIN, 14)); lcreditCardCode.setSize(120, 20); lcreditCardCode.setLocation(450, 80); mainBodySubPanel2.add(lcreditCardCode);

                        //Guest Sub Panel 2: The Guest Credit Card Code textbox on the form
                        MaskFormatter creditCardCodeMask = null;
                        try {
                            creditCardCodeMask = new MaskFormatter("###"); //the # is for numeric values
                            creditCardCodeMask.setPlaceholderCharacter('_');
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        tcreditCardCode = new JFormattedTextField(creditCardCodeMask); tcreditCardCode.setFont(new Font("Arial", Font.PLAIN, 15)); tcreditCardCode.setSize(45, 20); tcreditCardCode.setLocation(600, 80); tcreditCardExpiryDate.setNextFocusableComponent(tcreditCardCode); mainBodySubPanel2.add(tcreditCardCode);
                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Discount label on the form
                        JLabel ldiscount = new JLabel("Discount (%)*"); ldiscount.setFont(new Font("Arial", Font.PLAIN, 14)); ldiscount.setSize(120, 20); ldiscount.setLocation(450, 110); mainBodySubPanel2.add(ldiscount);
                        //Guest Sub Panel 2: The Guest Discount textbox on the form
                        tdiscount = new JFormattedTextField(new DecimalFormat("###.##")); tdiscount.setFont(new Font("Arial", Font.PLAIN, 15)); tdiscount.setSize(45, 20); tdiscount.setLocation(600, 110); tdiscount.setText(lastDouble + ""); tdiscount.selectAll(); tcreditCardCode.setNextFocusableComponent(tdiscount); mainBodySubPanel2.add(tdiscount);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Registration Date label on the form
                        JLabel lregistrationDate = new JLabel("Registration Date*"); lregistrationDate.setFont(new Font("Arial", Font.PLAIN, 14)); lregistrationDate.setSize(120, 20); lregistrationDate.setLocation(450, 140); mainBodySubPanel2.add(lregistrationDate);

                        //Guest Sub Panel 2: The Guest Registration Date textbox on the form
                        MaskFormatter registrationDateMask = null;
                        try {
                            registrationDateMask = new MaskFormatter("####-##-##"); //the # is for numeric values
                            registrationDateMask.setPlaceholderCharacter('_');
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        tregistrationDate = new JFormattedTextField(registrationDateMask); tregistrationDate.setFont(new Font("Arial", Font.PLAIN, 15)); tregistrationDate.setSize(100, 20); tregistrationDate.setLocation(600, 140); tdiscount.setNextFocusableComponent(tregistrationDate); mainBodySubPanel2.add(tregistrationDate); lregistrationDate = new JLabel("(yyyy-mm-dd)"); lregistrationDate.setFont(new Font("Arial", Font.PLAIN, 14)); lregistrationDate.setSize(120, 20); lregistrationDate.setLocation(710, 140); mainBodySubPanel2.add(lregistrationDate);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Password label on the form
                        JLabel lpassword = new JLabel("Password*"); lpassword.setFont(new Font("Arial", Font.PLAIN, 14)); lpassword.setSize(120, 20); lpassword.setLocation(450, 170); mainBodySubPanel2.add(lpassword);

                        //Guest Sub Panel 2: The Guest Password textbox on the form
                        tpassword = new JPasswordField(); tpassword.setFont(new Font("Arial", Font.PLAIN, 15)); tpassword.setSize(210, 20); tpassword.setLocation(600, 170); tregistrationDate.setNextFocusableComponent(tpassword); mainBodySubPanel2.add(tpassword);

                        //------------------------------------------------------------------
                        //Guest Sub Panel 2: The Guest Confirm Password label on the form
                        JLabel lconfirmPassword = new JLabel("Confirm Password*"); lconfirmPassword.setFont(new Font("Arial", Font.PLAIN, 14)); lconfirmPassword.setSize(120, 20); lconfirmPassword.setLocation(450, 200); mainBodySubPanel2.add(lconfirmPassword);

                        //Guest Sub Panel 2: The Guest Confirm Password textbox on the form
                        tconfirmPassword = new JPasswordField(); tconfirmPassword.setFont(new Font("Arial", Font.PLAIN, 15)); tconfirmPassword.setSize(210, 20); tconfirmPassword.setLocation(600, 200); tpassword.setNextFocusableComponent(tconfirmPassword); mainBodySubPanel2.add(tconfirmPassword);


                        //------------------------------------------------------------------
                        //Guest Sub Panel 3: Guest Details Sub Panel3: The Tabbed Panel
                        JPanel mainBodySubPanel3 = new JPanel(); mainBodySubPanel3.setLayout(new GridLayout(1, 1)); mainBodySubPanel3.setPreferredSize(new Dimension(850, 210)); mainBodySubPanel3.setBorder(BorderFactory.createTitledBorder("Guest Details "));

                                JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
                                //Guest Sub Panel 3: Additional Guest Details Sub Panel3: Tab 1, Additional Guest Details TextArea 
                                JPanel tadditionalGuestDetailsPanel = new JPanel(); tadditionalGuestDetails = new JTextArea(8, 62); tadditionalGuestDetails.setFont(new Font("Arial", Font.PLAIN, 15)); tadditionalGuestDetails.setSize(105, 245);

                                tadditionalGuestDetails.setBorder(BorderFactory.createLineBorder(Color.green)); tadditionalGuestDetails.setLocation(1, 0); tadditionalGuestDetails.setBackground(Color.WHITE); tadditionalGuestDetails.setLineWrap(true); tadditionalGuestDetails.setEditable(true);

                                JScrollPane additionalGuestDetailsScroll = new JScrollPane(tadditionalGuestDetails); additionalGuestDetailsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); tadditionalGuestDetailsPanel.add(additionalGuestDetailsScroll); 
                                tabbedPane.addTab("Additional Guest Details", tadditionalGuestDetailsPanel);

                                //Guest Sub Panel 3: Guest Details Sub Panel3: The General Notes TextArea 
                                JPanel tgeneralNotesPanel = new JPanel(); tgeneralNotes = new JTextArea(8, 62); tgeneralNotes.setFont(new Font("Arial", Font.PLAIN, 15)); tgeneralNotes.setSize(105, 245); tgeneralNotes.setLocation(1, 0); tgeneralNotes.setBackground(Color.WHITE); tgeneralNotes.setLineWrap(true); tgeneralNotes.setEditable(true);

                                JScrollPane generalNotesScroll = new JScrollPane(tgeneralNotes); generalNotesScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); tgeneralNotesPanel.add(generalNotesScroll); tabbedPane.addTab("General Notes", tgeneralNotesPanel); tconfirmPassword.setNextFocusableComponent(tabbedPane); mainBodySubPanel3.add(tabbedPane);
                                //------------------------------------------------------------------
                                //Guest Sub Panel 4: Button Panel
                                JPanel buttonPanel = new JPanel(); buttonPanel.setBackground(Color.LIGHT_GRAY); submit = new JButton("Save"); submit.addActionListener(this); tabbedPane.setNextFocusableComponent(submit);

                                clear = new JButton("Reset"); clear.addActionListener(this); submit.setNextFocusableComponent(clear); JButton close = new JButton("Close"); close.addActionListener(e -> {
                                    this.dispose();
                                }); clear.setNextFocusableComponent(close); close.setNextFocusableComponent(tname); buttonPanel.add(submit); buttonPanel.add(clear); buttonPanel.add(close); clear.addActionListener(this); mainBodyPanel.add(mainBodySubPanel1); mainBodyPanel.add(mainBodySubPanel2); mainBodyPanel.add(mainBodySubPanel3); getContentPane().add(BorderLayout.NORTH, menuBar); getContentPane().add(BorderLayout.CENTER, mainBodyPanel); getContentPane().add(BorderLayout.SOUTH, buttonPanel); setVisible(true);
                            }

    // ----------------------------------------------------------------------
    public static String formatCard(String cardNumber) {
        if (cardNumber == null)
            return null;
        char delimiter = ' ';
        return cardNumber.replaceAll(".{4}(?!$)", "$0" + delimiter);
    }

    // ----------------------------------------------------------------------
    // Method to action Registration events
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // Get all the information from the input screen and assign them to the
            // respective variables
            String s1 = null;
            String s2 = tname.getText();
            String s3 = taddress.getText();
            String s4 = tphone.getText();
            String s5 = temail.getText();
            String s6 = tpassword.getText();
            String s7 = tcreditCardNo.getText();
            String s8 = tcreditCardExpiryDate.getText();
            String s9 = tcreditCardCode.getText();
            String s10 = tguestType.getSelectedItem().toString();
            String s11 = tdiscount.getText();
            String s12 = tregistrationDate.getText();
            String s13 = tadditionalGuestDetails.getText();
            String s14 = tgeneralNotes.getText();
            String s15 = tconfirmPassword.getText();

            // Check to ensure that data is input in all required fields
            if (!s2.equals("") && !s3.equals("") && !s4.equals("") && !s5.equals("") && !s6.equals("") && !s7.equals("")
                    && !s8.equals("") && !s9.equals("") && !s10.equals("") && !s11.equals("") && !s12.equals("")) {
                /**
                 * Check if the email address is valid and if the password and confirmPassword
                 * match
                 */
                if (isValidEmailAddress(s5) && s6.equals(s15)) {
                    // Try to insert data into the Guest table in the group1toolbox database
                    try {
                        // Create a query with masked (?) input data values
                        String query = "INSERT INTO GUEST VALUES(null, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
                        da.ps = da.con.prepareStatement(query);
                        // No input data is required for the guestID as this field is auto - populated
                        // by the database
                        // da.ps.setString(1, s1); //Guest ID
                        // set that input data for each masked input specified in the query
                        da.ps.setString(1, s2); // Name
                        da.ps.setString(2, s3); // Address
                        da.ps.setString(3, s4); // Phone
                        da.ps.setString(4, s5); // Email
                        da.ps.setString(5, s6); // Password
                        da.ps.setString(6, s7); // Credit Card No
                        da.ps.setString(7, s8); // Credit Card Expiry Date
                        da.ps.setString(8, s9); // Credit Card Code
                        da.ps.setString(9, s10); // Guest Type
                        da.ps.setString(10, s11); // Discount
                        da.ps.setString(11, s12); // Registration Date
                        da.ps.setString(12, s13); // Additional Guest Details
                        da.ps.setString(13, s14); // General Notes

                        // Execute the SQL statement to insert data into the group1toolbox database
                        if (da.ps.executeUpdate() > 0) {
                            JOptionPane.showMessageDialog(null, "Data Saved Successfully ");
                            // Reset all fields in the Guest Registration form tname.setText("");
                            // taddress.setText(""); tphone.setText(""); temail.setText("");
                            // tpassword.setText(""); tconfirmPassword.setText("");
                            // tcreditCardNo.setText(""); tcreditCardExpiryDate.setText("");
                            // tcreditCardCode.setText(""); tguestType.setSelectedIndex(0);
                            // tdiscount.setText(lastDouble + ""); tregistrationDate.setText("");
                            // tadditionalGuestDetails.selectAll();
                            // tadditionalGuestDetails.replaceSelection(""); tgeneralNotes.selectAll();
                            // tgeneralNotes.replaceSelection("");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Error: Data Not Saved\nPlease check data input and try again");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error: Invalid Data\nEither email address is invalid\n Or passwords do not match ");
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Error: Missing data\nPlease ensure all required data fields are populated and try again");
            }
        } else {
            // Reset all fields in the Guest Registration form
            tname.setText("");
            taddress.setText("");
            tphone.setText("");
            temail.setText("");
            tpassword.setText("");
            tconfirmPassword.setText("");
            tcreditCardNo.setText("");
            tcreditCardExpiryDate.setText("");
            tcreditCardCode.setText("");
            tguestType.setSelectedIndex(0);
            tdiscount.setText(lastDouble + "");
            tregistrationDate.setText("");
            tadditionalGuestDetails.selectAll();
            tadditionalGuestDetails.replaceSelection("");
            tgeneralNotes.selectAll();
            tgeneralNotes.replaceSelection("");
        }
    }

    // Method to validate an email address
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9] { 1, 3 }\\.[0 - 9] { 1, 3 }\\.[0 - 9] { 1, 3 }\\.[0 - 9] { 1, 3 }\\]) | (([a - zA - Z\\ - 0 - 9] + \\.) + [azA - Z] { 2, })) $ ";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}