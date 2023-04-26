/**
 * StaffGuestServices.java
 * * @Author CTS Unique Touch Pro
 * @Version v1.0 05th April 2022
 * @Date April 05, 2022
 * Class to manage Guest Services provided by the Receptionist to Hotel
Guests
 */
//--------------------------------------------------------------------------

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.sql.*;
import java.io.File;
import java.io.IOException;
//--------------------------------------------------------------------------

public class StaffGuestServices extends JFrame {
    // ----------------------------------------------------------------------

    // Constructor for objects of class GuestServices
    public StaffGuestServices() {
    }
    // ----------------------------------------------------------------------

    // Protected Java Database Connection
    DatabaseAccess da = new DatabaseAccess();
    // ----------------------------------------------------------------------

 public void staffGuestServices(String user) {
 //Setting the Guest Form properties
 setTitle("Hotel Online Booking Management System: Staff Guest Services");
 setBounds(262, 50, 900, 600); //size of the frame
 setResizable(false);

 //------------------------------------------------------------------

 JMenuBar menuBar = new JMenuBar();
 JMenu menu1 = new JMenu("File");
 JMenu menu2 = new JMenu("Edit");
 JMenu menu3 = new JMenu("Modules");
 JMenu menu4 = new JMenu("Reports");
 JMenu menu5 = new JMenu("Tools");
 JMenu menu6 = new JMenu("Help");

 menuBar.add(menu1);
 menuBar.add(menu2);
 menuBar.add(menu3);
 menuBar.add(menu4);
 menuBar.add(menu5);
 menuBar.add(menu6);

 //------------------------------------------------------------------

 //Adding Components to the File option on the Main MenuBar
 JMenuItem menu11 = new JMenuItem("Close");
 menu1.add(menu11);
 menu11.addActionListener(e -> {
 this.dispose();
 });
 //------------------------------------------------------------------

 //Add Components to the Edit option on the Main MenuBar
 JMenuItem menu21 = new JMenuItem("Copy");
 JMenuItem menu22 = new JMenuItem("Paste");
 JMenuItem menu23 = new JMenuItem("Search");
 menu2.add(menu21);
 menu2.add(menu22);
 menu2.add(new JSeparator());
 menu2.add(menu23);
 //------------------------------------------------------------------

 //Add Components to the Modules option on the Main MenuBar
 JMenu menu31 = new JMenu("Booking");
 JMenuItem menu311 = new JMenuItem("Search for a Booking");
 JMenuItem menu312 = new JMenuItem("Make a Booking");
 JMenuItem menu313 = new JMenuItem("Update a Booking");
 JMenuItem menu314 = new JMenuItem("Delete a Booking");

 menu31.add(menu311);
 menu31.add(menu312);
 menu31.add(menu313);
 menu31.add(menu314);
 menu3.add(menu31);
 JMenu menu32 = new JMenu("Guest Services");
 JMenuItem menu321 = new JMenuItem("Check In Guest");
 JMenuItem menu322 = new JMenuItem("Check Out Guest");
 JMenuItem menu323 = new JMenuItem("Print Guest Bill");
 JMenuItem menu324 = new JMenuItem("Order External Services");

 menu32.add(menu321);
 menu32.add(menu322);
 menu32.add(menu323);
 menu32.add(menu324);
 menu3.add(menu32);
 //------------------------------------------------------------------

 //Main Body Panel: The middle panel
 JPanel mainBodyPanel = new JPanel();
 mainBodyPanel.setSize(900,450);
 //mainBodyPanel.setBackground(Color.GRAY);
 //------------------------------------------------------------------

 //Guest Services Sub Panel 1: The top label on the form
 JPanel mainBodySubPanel1 = new JPanel();
 mainBodySubPanel1.setLayout(null);
 mainBodySubPanel1.setBackground(Color.MAGENTA);
 mainBodySubPanel1.setPreferredSize(new Dimension(900, 40));
 //------------------------------------------------------------------

 //The title on the form to be placed in mainBodySubPanel1
 JLabel title = new JLabel(" Staff Guest Services Dashboard");
 title.setHorizontalAlignment(JLabel.LEFT);
 title.setVerticalAlignment(JLabel.CENTER);
 title.setFont(new Font("Arial", Font.BOLD, 20));
 title.setForeground(Color.green);
 title.setSize(900, 35);
 mainBodySubPanel1.add(title);
 //------------------------------------------------------------------

 JLabel guestNameLabel = new JLabel("User: " + user + " ");
 guestNameLabel.setHorizontalAlignment(JLabel.RIGHT);
 guestNameLabel.setVerticalAlignment(JLabel.CENTER);
 guestNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
 guestNameLabel.setForeground(Color.BLUE);
 guestNameLabel.setSize(900, 35);
 mainBodySubPanel1.add(guestNameLabel);
 mainBodyPanel.add(mainBodySubPanel1);

 //------------------------------------------------------------------

 //Guest Services Sub Panel 1: Form Spacer
 JPanel mainBodySubPanelSpacer = new JPanel();
 mainBodySubPanelSpacer.setLayout(new GridLayout());
 mainBodySubPanelSpacer.setPreferredSize(new Dimension(900, 10));
 //------------------------------------------------------------------

 //Guest Services Sub Panel 2: Create Guest Booking Sub Panel 2
 JPanel mainBodySubPanel2 = new JPanel();
 mainBodySubPanel2.setLayout(new GridLayout(1,0));
 mainBodySubPanel2.setPreferredSize(new Dimension(890, 175));
 mainBodySubPanel2.setBorder(BorderFactory.createTitledBorder(""));
 //------------------------------------------------------------------

 //Guest Services Sub Panel 2: Create Guest Booking Sub Panel 21
 JPanel mainBodySubPanel21 = new JPanel();
 mainBodySubPanel21.setLayout(new GridLayout());
 mainBodySubPanel21.setPreferredSize(new Dimension(40, 40));
 mainBodySubPanel21.setBorder(BorderFactory.createTitledBorder("Make
Booking"));

 //Guest Services Sub Panel 2: Create Guest Booking Image
 JButton createBooking = new JButton(new ImageIcon(((new
ImageIcon("img\\createBooking.png")).getImage()).getScaledInstance(140, 140,
java.awt.Image.SCALE_SMOOTH)));
 createBooking.addActionListener(
 new ActionListener(){
 public void actionPerformed(ActionEvent e) {
 StaffCreateBooking scb = new StaffCreateBooking();
 scb.StaffCreateBooking(user);
 setVisible(true);
 }
});
mainBodySubPanel21.add(createBooking);
mainBodySubPanel2.add(mainBodySubPanel21);
//------------------------------------------------------------------

//Guest Services Sub Panel 2: View Guest Booking Sub Panel 22
JPanel mainBodySubPanel22 = new JPanel();
mainBodySubPanel22.setLayout(new GridLayout());
mainBodySubPanel22.setPreferredSize(new Dimension(40, 40));

mainBodySubPanel22.setBorder(BorderFactory.createTitledBorder("Search-ViewUpdate Booking"));
//Guest Services Sub Panel 2: View Guest Booking Image
JButton searchBooking = new JButton(new ImageIcon(((new
ImageIcon("img\\viewBooking.png")).getImage()).getScaledInstance(140, 140,
java.awt.Image.SCALE_SMOOTH)));
searchBooking.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent e) {
StaffSearchBooking ssb = new StaffSearchBooking();
ssb.staffSearchBooking(user);
setVisible(true);
}
});

mainBodySubPanel22.add(searchBooking);
mainBodySubPanel2.add(mainBodySubPanel22);
//------------------------------------------------------------------

//Guest Services Sub Panel 3: Change Guest Booking Sub Panel 23
JPanel mainBodySubPanel23 = new JPanel();
mainBodySubPanel23.setLayout(new GridLayout());
mainBodySubPanel23.setPreferredSize(new Dimension(40, 40));

mainBodySubPanel23.setBorder(BorderFactory.createTitledBorder("Charges"));
//Guest Services Sub Panel 2: View Guest Booking Image
JButton Charges = new JButton(new ImageIcon(((new ImageIcon("img\\
changeBooking.png")).getImage()).getScaledInstance(140, 140,
java.awt.Image.SCALE_SMOOTH)));
Charges.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent e) {
Charges c = new Charges();
c.Charges(user);
setVisible(true);
}
});
mainBodySubPanel23.add(Charges);
mainBodySubPanel2.add(mainBodySubPanel23);
//------------------------------------------------------------------

//Guest Services Sub Panel 2: Cancel Guest Booking Sub Panel 24
JPanel mainBodySubPanel24 = new JPanel();
mainBodySubPanel24.setLayout(new GridLayout());
mainBodySubPanel24.setPreferredSize(new Dimension(40, 40));
mainBodySubPanel24.setBorder(BorderFactory.createTitledBorder("Monthly
Bill"));
 //Guest Services Sub Panel 2: Cancel Guest Booking Image
 JButton MonthlyBill = new JButton(new ImageIcon(((new
ImageIcon("C:img\\printMonthlyBill.png")).getImage()).getScaledInstance(140,
140, java.awt.Image.SCALE_SMOOTH)));
 MonthlyBill.addActionListener(
 new ActionListener(){
 public void actionPerformed(ActionEvent e) {
 MonthlyBill mb = new MonthlyBill();
 mb.MonthlyBill(user);
 setVisible(true);
 }
 });
 mainBodySubPanel24.add(MonthlyBill);
 mainBodySubPanel2.add(mainBodySubPanel24);
 mainBodyPanel.add(mainBodySubPanel2);
 mainBodyPanel.add(mainBodySubPanelSpacer);

 //------------------------------------------------------------------

 //Guest Services Sub Panel 3: Tabbed Sub Panel
 JPanel mainBodySubPanel3 = new JPanel();
 mainBodySubPanel3.setLayout(new GridLayout(1,0));
 mainBodySubPanel3.setPreferredSize(new Dimension(890, 260));
 mainBodySubPanel3.setBorder(BorderFactory.createTitledBorder("View
Guest Booking Details"));
 mainBodyPanel.add(mainBodySubPanel3);

 //------------------------------------------------------------------

 //Guest Services Button Panel
 JPanel buttonPanel = new JPanel();
 buttonPanel.setBackground(Color.WHITE);
 JButton submit = new JButton("Save");
 JButton print = new JButton("Print");
 JButton close = new JButton("Close");
 buttonPanel.add(submit);
 buttonPanel.add(print);
 buttonPanel.add(close);
 getContentPane().add(BorderLayout.NORTH, menuBar);
 getContentPane().add(BorderLayout.CENTER, mainBodyPanel);
 getContentPane().add(BorderLayout.SOUTH, buttonPanel);
 setVisible(true);
 }
    // ----------------------------------------------------------------------

}
