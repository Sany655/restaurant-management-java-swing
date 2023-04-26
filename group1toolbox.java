/**
 * group1toolbox.java Feb/02/2022
 * The main ToolBox class
 *
 * @Author CTS Unique Touch Pro
 * @Version v1.0 05th April 2022
 * @Date April 05, 2022
 *
 * This is the main class that provides access to the Hotel Online Booking
Management System Application.
 */
//--------------------------------------------------------------------------

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
//--------------------------------------------------------------------------

public class group1toolbox extends JFrame {

    group1toolbox() {}
        //------------------------------------------------------------------
        
        public void mainHome() {
            //Setting the Form and Frame properties
            setTitle("Hotel Online Booking Management System: Application");
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setBounds(100, 30, 1200, 650); //size of the frame
            setResizable(false);

            //------------------------------------------------------------------
            
            //Check for an event (keyboard or mouse action)
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent event) {
                    confirmAndExit();
                }
            });
            //------------------------------------------------------------------
            
            Action exitAction = new AbstractAction("Exit") {
                @Override
                public void actionPerformed(ActionEvent event) {
                    confirmAndExit();
                }
            };
            //------------------------------------------------------------------
            
            //Create the MenuBar with menu navigation options
            JMenuBar menuBar = new JMenuBar();
            JMenu menu1 = new JMenu("Application");
            JMenu menu2 = new JMenu("Help");
            menuBar.add(menu1);
            menuBar.add(menu2);
            //------------------------------------------------------------------
            
            //Adding Components to the File navigation option on the Main
            MenuBar
            JMenu menu11 = new JMenu("Login");
            JMenuItem menu111 = new JMenuItem("Login as a Guest");
            menu111.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GuestLogin.userLogin();
                        setVisible(true);
                    }
                });

            JMenuItem menu112 = new JMenuItem("Login as Staff");
            menu112.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        StaffLogin.userStaffLogin();
                        setVisible(true);
                    }
                });

            menu11.add(menu111);
            menu11.add(menu112);

            //------------------------------------------------------------------
            
            JMenuItem menu12 = new JMenuItem("Register");
            menu12.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        RegisterGuest rg = new RegisterGuest();
                        rg.registerGuest();
                        setVisible(true);
                    }
                });

            //------------------------------------------------------------------
            
            JMenuItem menu13 = new JMenuItem("Test Connection");
            menu13.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TestDatabaseConnection tdc = new
                        TestDatabaseConnection();
                        tdc.testMyConnection();
                        tdc.printResult();
                    }
                });
            //------------------------------------------------------------------
            
            menu1.add(menu11);
            menu1.add(new JSeparator());
            menu1.add(menu12);
            menu1.add(new JSeparator());
            menu1.add(menu13);
            menu1.add(new JSeparator());
            menu1.add(exitAction);
            //------------------------------------------------------------------
            
            //Adding Components to the Help option on the Main MenuBar
            JMenuItem menu21 = new JMenuItem("User Guide");
            JMenuItem menu22 = new JMenuItem("Frequently Asked Questions");
            JMenuItem menu23 = new JMenuItem("About Hotel Online Management System");
                    JMenuItem menu24 = new JMenuItem("About Development Team"); JMenuItem menu25 = new JMenuItem("Legal Agreement and Copyright"); JMenuItem menu26 = new JMenuItem("Hotel Brief");

                    menu2.add(menu21); menu2.add(menu22); menu2.add(new JSeparator()); menu2.add(menu23); menu2.add(menu24); menu2.add(new JSeparator()); menu2.add(menu25); menu2.add(menu26);
                    //------------------------------------------------------------------
                    
                    menu21.addActionListener(
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
                    
                    menu22.addActionListener(
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
                    
                    menu23.addActionListener(
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
                    
                    menu24.addActionListener(
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
                    
                    menu25.addActionListener(
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
                    
                    menu26.addActionListener(
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
                    
                    //Main Body Panel: The middle panel
                    JPanel mainBodyPanel = new JPanel(); mainBodyPanel.setSize(1200, 650); mainBodyPanel.setBackground(Color.LIGHT_GRAY);
                    //------------------------------------------------------------------
                    
                    //Main Body Sub Panel 0: The top label on the form
                    JPanel mainBodySubPanel0 = new JPanel(); mainBodySubPanel0.setLayout(null); mainBodySubPanel0.setBackground(Color.MAGENTA); mainBodySubPanel0.setPreferredSize(new Dimension(1200, 40));
                    //------------------------------------------------------------------
                    
                    //The title on the form to be placed in mainBodySubPanel0
                    JLabel title = new JLabel("WELCOME TO THE LUTON HOTEL!!"); title.setHorizontalAlignment(JLabel.CENTER); title.setVerticalAlignment(JLabel.CENTER); title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25)); title.setSize(1200, 35); title.setForeground(Color.GREEN); mainBodySubPanel0.add(title); mainBodyPanel.add(mainBodySubPanel0);
                    //------------------------------------------------------------------
                    
                    //Main Body Sub Panel 1: The Backgroung Image sub panel
                    ImagePanel mainBodySubPanel1 = new ImagePanel(new ImageIcon("img/mainDemo.jpg").getImage()); mainBodySubPanel1.setPreferredSize(new Dimension(1068, 427));

                    mainBodySubPanel1.setBorder(BorderFactory.createLineBorder(Color.green)); mainBodyPanel.add(mainBodySubPanel1);




                    //------------------------------------------------------------------
                    
                    getContentPane().add(BorderLayout.NORTH, menuBar); getContentPane().add(BorderLayout.CENTER, mainBodyPanel);
                }

                //----------------------------------------------------------------------
                

                class ImagePanel extends JPanel {
                    private Image img;
                    public ImagePanel(String img) {
                            this(new ImageIcon(img).getImage());
                        }
                        //------------------------------------------------------------------
                        
                        public ImagePanel(Image img) {
                            this.img = img;
                            Dimension size = new Dimension(img.getWidth(null),
                                img.getHeight(null));
                            //img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);

                            setPreferredSize(size);
                            setMinimumSize(size);
                            setMaximumSize(size);
                            setSize(size);
                            setLayout(null);
                        }
                        //------------------------------------------------------------------
                        
                        public void paintComponent(Graphics g) {
                            g.drawImage(img, 0, 0, null);
                        }
                }
                //----------------------------------------------------------------------
                
                void confirmAndExit() {
                    if (JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to quit?",
                            "Please confirm",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
                //----------------------------------------------------------------------
                //Main application method
                public static void main(String[] args) {
                    group1toolbox gt = new group1toolbox();
                    gt.mainHome();
                    gt.setVisible(true);
                }
        }