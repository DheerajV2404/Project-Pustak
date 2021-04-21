/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pustak;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author DHEERAJ
 */
public class SignUP extends javax.swing.JDialog {
PustakDB pdb;
 String image1=null;
 String mono;
    /**
     * Creates new form SignUP
     */
    public SignUP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pdb=new PustakDB();
        mobnovalid.setVisible(false);
        p_scname.setEditable(false);
        p_class.setEditable(false);
        p_clname.setEditable(false);
        p_sem.setEditable(false);
        states();
        
    }

    SignUP(String mobno) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   initComponents();
   mobnovalid.setVisible(false);
        pdb=new PustakDB();
        getData(mobno);
        mono=mobno;
        states();
    }
    
    public void getData(String no)
    {
        String que="select * from signup where MobNo='"+no+"'";
        try
        {
            pdb.rs=pdb.stm.executeQuery(que);
            pdb.rs.next();
            String a=pdb.rs.getString("Name");
            String [] ns=a.split(" ");
            p_fname.setText(ns[0]);
            p_sname.setText(ns[1]);
            Date date=new Date(pdb.rs.getString("DOB"));
            p_dob.setDate(date);
            p_gender.setSelectedItem(pdb.rs.getString("Gender"));
            p_mobno.setText(no);
            p_email.setText(pdb.rs.getString("EmailID"));
            p_wno.setText(pdb.rs.getString("WhastappNo"));
            p_address.setText(pdb.rs.getString("Address"));
            p_pincode.setText(pdb.rs.getString("Pincode"));
            p_state.setSelectedItem(pdb.rs.getString("State"));
            p_district.setSelectedItem(pdb.rs.getString("Image"));
              byte[] img2=pdb.rs.getBytes("Image");
         ImageIcon ic=new ImageIcon(img2);
         Image im=ic.getImage().getScaledInstance(p_image.getWidth(),p_image.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon newImage=new ImageIcon(im);
         p_image.setIcon(newImage);
         if(pdb.rs.getString("SC/CLG").equals(p_sc.getText()))
         {
             p_sc.setSelected(true);
              p_clname.setEditable(false);
            p_sem.setEditable(false);
             p_scname.setText(pdb.rs.getString("Academy"));
             p_class.setText(pdb.rs.getString("Class"));
         }else
         {
             p_cl.setSelected(true);
             p_scname.setEditable(false);
            p_class.setEditable(false);
             p_clname.setText(pdb.rs.getString("Academy"));
             p_sem.setText(pdb.rs.getString("Class"));
         }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e+" GET DATA FUCNTION");
        }
    }
    
     public int maxSNO()
      {
           int t =0;
          String s="select MAX(SNO) from signup";
          try
          {
              pdb.rs=pdb.stm.executeQuery(s);
              pdb.rs.next();
            t =pdb.rs.getInt(1);
             t=t+1;
       
             
          }catch(Exception e)
          {
              JOptionPane.showMessageDialog(null, e+" MAX VSNO VALUE ");
          }
          return t;
      }
    
    
    public void states()
    {
        String s="select DISTINCT(State) from states ";
        try
        {
            pdb.rs=pdb.stm.executeQuery(s);
            while(pdb.rs.next())
            {
                p_state.addItem(pdb.rs.getString("State"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e+" STATES ADD");
        }
    }
     public void district()
    {
       String a =(String) p_state.getSelectedItem();
       String s="select * from states where State='"+a+"'";
       try
        {
            PustakDB db=new PustakDB();
            db.rs=db.stm.executeQuery(s);
            while(db.rs.next())
            {
                p_district.addItem(db.rs.getString("District"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e+" DISTRICT ADD");
        }
    }    
    
     public void emailConfirm()
      {
         
         
         String id=p_email.getText();
         String name=p_fname.getText();
        
        try
        {
          String recipient = p_email.getText();
           String sender = "dv61155@gmail.com"; 
           Properties properties = new Properties();
           properties.put("mail.smtp.auth","true");
      properties.put("mail.smtp.starttls.enable","true");
      properties.put("mail.smtp.host","smtp.gmail.com");
      properties.put("mail.smtp.port","587");
      String myemail="dv61155@gmail.com";
      String pass="Dheeraj@MS07";
     
          Session session=Session.getDefaultInstance(properties,new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(myemail,pass); //To change body of generated methods, choose Tools | Templates.
          }
    });
           MimeMessage message = new MimeMessage(session);
          message.setFrom(new InternetAddress(sender));
          message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
          message.setSubject("PHASAL DATVA SOFTWARE TEAM");
          message.setText("Hi '"+name+"'","\n Thank you for registering in Pustak .\n Have a great journey on PUSTAK .");
          Transport.send(message);
           System.out.println(message);
          
        }catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e+" EMail wale me error");
        }
        System.out.println("YAHA PE EMAIL SENT HO GYA ");
      
    
      }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p_fname = new javax.swing.JTextField();
        p_sname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p_dob = new com.toedter.calendar.JDateChooser();
        p_gender = new javax.swing.JComboBox<>();
        p_image = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        p_mobno = new javax.swing.JTextField();
        p_wno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        p_state = new javax.swing.JComboBox<>();
        p_district = new javax.swing.JComboBox<>();
        p_pincode = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        p_scname = new javax.swing.JTextField();
        p_class = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        p_clname = new javax.swing.JTextField();
        p_sem = new javax.swing.JTextField();
        p_sc = new javax.swing.JRadioButton();
        p_cl = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        p_address = new java.awt.TextArea();
        jLabel5 = new javax.swing.JLabel();
        p_email = new javax.swing.JTextField();
        mobnovalid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("FIIRST NAME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("SURNAME");

        p_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_fnameActionPerformed(evt);
            }
        });

        p_sname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DOB");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("GENDER");

        p_dob.setFocusable(false);
        p_dob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        p_gender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHER" }));

        p_image.setForeground(new java.awt.Color(153, 153, 153));
        p_image.setText("jLabel5");
        p_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jButton1.setText("ADD IMAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("MOBILE NO");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("WHATSAPP NO");

        jLabel8.setText("FULL ADDRESS");

        p_mobno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p_mobno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_mobnoActionPerformed(evt);
            }
        });
        p_mobno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_mobnoKeyReleased(evt);
            }
        });

        p_wno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("DISTRICT");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("STATE");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("PINCODE");

        p_state.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p_state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_stateActionPerformed(evt);
            }
        });

        p_district.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p_district.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_districtActionPerformed(evt);
            }
        });

        p_pincode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "ACADEMIC ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("SCHOOL NAME");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("CLASS");

        p_scname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        p_class.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p_class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_classActionPerformed(evt);
            }
        });

        jLabel15.setText("CLG NAME");

        jLabel16.setText("YEAR / SEM");

        buttonGroup1.add(p_sc);
        p_sc.setText("SCHOOL");
        p_sc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_scActionPerformed(evt);
            }
        });

        buttonGroup1.add(p_cl);
        p_cl.setText("COLLEGE");
        p_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_clActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p_scname, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(p_clname)
                            .addComponent(p_sem, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_class, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(p_sc)
                        .addGap(86, 86, 86)
                        .addComponent(p_cl)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p_sc)
                    .addComponent(p_cl))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_scname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_class, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(p_clname, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_sem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("EMAIL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p_district, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p_wno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p_mobno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p_fname)
                            .addComponent(p_dob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p_gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p_pincode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p_state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p_address, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobnovalid, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(p_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(p_email, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79)))
                                .addComponent(p_image, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_mobno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_email, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mobnovalid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p_image, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p_wno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_address, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p_pincode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_state, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p_district, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_fnameActionPerformed

    private void p_districtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_districtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_districtActionPerformed

    private void p_stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_stateActionPerformed
        // TODO add your handling code here:
        p_district.removeAllItems();
        district();
    }//GEN-LAST:event_p_stateActionPerformed

    private void p_classActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_classActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_classActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        image1 = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(new ImageIcon(image1).getImage().getScaledInstance(p_image.getWidth(),p_image.getHeight(),Image.SCALE_SMOOTH));
       // Image image = icon.getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_SMOOTH);
        p_image.setIcon(icon);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void p_scActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_scActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()==p_sc)
        {
            p_scname.setEditable(true);
            p_class.setEditable(true);
            p_clname.setEditable(false);
            p_sem.setEditable(false);
        }
    }//GEN-LAST:event_p_scActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String que="select * from signup where MobNo='"+mono+"'";
      
         try
       {
           pdb.rs= pdb.stm.executeQuery(que);
            if(pdb.rs.next()==false)
            {
                if(mobnovalid.isVisible()==true)
                {
                    JOptionPane.showMessageDialog(null, "Please check the mobile no. !",
               "?", JOptionPane.ERROR_MESSAGE);
                }else
                {
                insert();
                }
            }
            else
            {        
               
            }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void p_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_clActionPerformed
        // TODO add your handling code here:
          if(evt.getSource()==p_cl)
        {
             p_clname.setEditable(true);
            p_sem.setEditable(true);
            p_scname.setEditable(false);
            p_class.setEditable(false);
           
        }
    }//GEN-LAST:event_p_clActionPerformed

    private void p_mobnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_mobnoKeyReleased
        // TODO add your handling code here:
       String a= p_mobno.getText();
       String que="select * from signup where MobNo='"+a+"'";
        try
       {
           pdb.rs= pdb.stm.executeQuery(que);
            if(pdb.rs.next()==true)
            {
                mobnovalid.setVisible(true);
                mobnovalid.setText("MOBILE NO. ALREADY REGISTERED !!!!");
                
               
            }
            
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_p_mobnoKeyReleased

    private void p_mobnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_mobnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_mobnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SignUP dialog = new SignUP(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mobnovalid;
    private java.awt.TextArea p_address;
    private javax.swing.JRadioButton p_cl;
    private javax.swing.JTextField p_class;
    private javax.swing.JTextField p_clname;
    private javax.swing.JComboBox<String> p_district;
    private com.toedter.calendar.JDateChooser p_dob;
    private javax.swing.JTextField p_email;
    private javax.swing.JTextField p_fname;
    private javax.swing.JComboBox<String> p_gender;
    private javax.swing.JLabel p_image;
    private javax.swing.JTextField p_mobno;
    private javax.swing.JTextField p_pincode;
    private javax.swing.JRadioButton p_sc;
    private javax.swing.JTextField p_scname;
    private javax.swing.JTextField p_sem;
    private javax.swing.JTextField p_sname;
    private javax.swing.JComboBox<String> p_state;
    private javax.swing.JTextField p_wno;
    // End of variables declaration//GEN-END:variables

    public void insert()
    {
        String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14;
        int t=maxSNO();
        s1=p_fname.getText()+" "+p_sname.getText();
       Date date =p_dob.getDate();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
       s2= sf.format(date);
        
        System.out.println(s2);
        s3=(String) p_gender.getSelectedItem();
        s4=p_mobno.getText();
        s5=p_email.getText();
        s6=p_wno.getText();
        s7=p_address.getText();
        s8=p_pincode.getText();
        s9=(String) p_district.getSelectedItem();
        s10=(String) p_state.getSelectedItem();
        if(p_sc.isSelected())
        {
            s12="SCHOOL";
        }else
        {
            s12="COLLEGE";
        }
        
        s13=p_scname.getText()+""+p_clname.getText();
        s14=p_class.getText()+""+p_sem.getText();
        String que="insert into signup (SNO,Name,DOB,Gender,MobNo,EmailID,WhastappNo,Address,Pincode,City,State,Image,SC/CLG,Academy,Class) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          try
    {
        PreparedStatement ps=pdb.con.prepareStatement(que);
        ps.setInt(1,t);
        ps.setString(2,s1);
        ps.setString(3,s2);
        ps.setString(4,s3);
        ps.setString(5,s4);
        ps.setString(6,s5);
        ps.setString(7,s6);
        ps.setString(8,s7);
        ps.setString(9,s8);
        ps.setString(10,s9);
        ps.setString(11,s10);
        File image=new File(image1);
        FileInputStream fis= new FileInputStream (image);
        ps.setBinaryStream(12, fis,fis.available());
        ps.setString(12,s12);
        ps.setString(14,s13);
        ps.setString(15, s14);
        
        ps.execute();
        JOptionPane.showMessageDialog(null,"SIGNUP SUCCESSFULLY.....");
        emailConfirm();
        HomePage hp=new HomePage(p_mobno.getText());
        hp.setVisible(true);
        
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,e+" INSERT FUNCTION INSPECTION");
    }
    }
    
}
