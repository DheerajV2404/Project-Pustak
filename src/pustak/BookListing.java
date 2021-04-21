/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pustak;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author DHEERAJ
 */
public class BookListing extends javax.swing.JFrame {
 String image1=null;
 String image2=null;
 String image3=null;
 String image4=null;
 PustakDB pdb;
    /**
     * Creates new form BookListing
     */
    public BookListing() {
        initComponents();
    }

    BookListing(String mobno) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      initComponents();
      pdb=new PustakDB();
      getInfo(mobno);
    }
    
    BookListing(ResultSet rs)
    {
         initComponents();
         showBookData(rs);
         jButton2.setLabel("CONTACT NOW");
         setVisible(true);
    }

     public void showBookData(ResultSet rs)
     {
         try
         {
             idno.setEditable(false);
         idno.setText(rs.getString("BIDno"));
         bldate.setEditable(false);
          bldate.setText(rs.getString("BDate"));
          bltime.setEditable(false);
          bltime.setText(rs.getString("BTime"));
          blname.setEditable(false);
          blname.setText(rs.getString("BookName"));
          blauthor.setEditable(false);
          blauthor.setText(rs.getString("BAuthor"));
          bldescription.setEditable(false);
          bldescription.setText(rs.getString("BDescription"));
          blold.setEditable(false);
          blold.setText(rs.getString("Byearold"));
          nlacademy.setEditable(false);
          nlacademy.setText(rs.getString("Academy"));
          blacademic.setEditable(false);
          blacademic.setText(rs.getString("Academic"));
          blother.setEditable(false);
          blother.setText(rs.getString("OtherStream"));
          blrealprice.setEditable(false);
          blrealprice.setText(rs.getString("BRealPrice"));
          blprice.setEditable(false);
          blprice.setText(rs.getString("SellerPrice"));
          blsellname.setEditable(false);
          blsellname.setText(rs.getString("SellerName"));
          blmobno.setEditable(false);
          
          blmobno.setText(rs.getString("SellerMobNo"));
          bladdress.setEditable(false);
          bladdress.setText(rs.getString("SellerAddress"));
           try{
           byte[] img2=rs.getBytes("ImageFront");
         ImageIcon ic=new ImageIcon(img2);
         Image im=ic.getImage().getScaledInstance(jLabel16.getWidth(),jLabel16.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon newImage=new ImageIcon(im);
         jLabel16.setEnabled(false);
         jLabel16.setIcon(newImage);
          }catch(Exception e){
              System.out.println(e);
          } 
           try{
           byte[] img2=rs.getBytes("ImageBack");
         ImageIcon ic=new ImageIcon(img2);
         Image im=ic.getImage().getScaledInstance(jLabel17.getWidth(),jLabel17.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon newImage=new ImageIcon(im);
         jLabel17.setEnabled(false);
         jLabel17.setIcon(newImage);
          }catch(Exception e){
              System.out.println(e);
          } 
           try{
           byte[] img2=rs.getBytes("ImagePriceTag");
         ImageIcon ic=new ImageIcon(img2);
         Image im=ic.getImage().getScaledInstance(jLabel18.getWidth(),jLabel18.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon newImage=new ImageIcon(im);
         jLabel18.setEnabled(false);
         jLabel18.setIcon(newImage);
          }catch(Exception e){
              System.out.println(e);
          } 
           try{
           byte[] img2=rs.getBytes("ImageWhole");
         ImageIcon ic=new ImageIcon(img2);
         Image im=ic.getImage().getScaledInstance(jLabel19.getWidth(),jLabel19.getHeight(),Image.SCALE_SMOOTH);
         ImageIcon newImage=new ImageIcon(im);
         jLabel19.setEnabled(false);
         jLabel19.setIcon(newImage);
          }catch(Exception e){
              System.out.println(e);
          } 
         }catch(Exception e)
         {
             JOptionPane.showMessageDialog(null,e+" SHOW BOOK DATA ");
         }
     }
    
    public int maxSNO()
    {
        int t=0;
        PustakDB db=new PustakDB();
        String que ="Select Max(BSNO) as LargestNumber from booklisting";
         System.out.println(que);
        try
       {
        db.rs = db.stm.executeQuery(que);
        db.rs.next();
        t =db.rs.getInt(1);
            t=1; 
        }catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e);
       }
        return t;
    }
    
    public int maxIDno()
    {
        int t=0;
        PustakDB db=new PustakDB();
        String que ="Select Max(BIDno) as LargestNumber from booklisting";
         System.out.println(que);
        try
       {
        db.rs = db.stm.executeQuery(que);
        db.rs.next();
          t =db.rs.getInt(1);
            t=101;
        }catch(Exception e)
       {
        JOptionPane.showMessageDialog(null,e);
       }
        return t;
    }
    
    public void getInfo(String mono)
    {
        String que="select * from signup where MobNo='"+mono+"'";
        try
        {
            pdb.rs=pdb.stm.executeQuery(que);
            pdb.rs.next();
            blsellname.setText(pdb.rs.getString("Name"));
            bladdress.setText(pdb.rs.getString("Address")+" "+pdb.rs.getString("City"));
            blmobno.setText(mono);
            nlacademy.setText(pdb.rs.getString("Academy"));
            blacademic.setText(pdb.rs.getString("Class"));
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+" GET INFO FUNCTION");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Author = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        idno = new javax.swing.JTextField();
        bltime = new javax.swing.JTextField();
        blname = new javax.swing.JTextField();
        blauthor = new javax.swing.JTextField();
        blold = new javax.swing.JTextField();
        nlacademy = new javax.swing.JTextField();
        blacademic = new javax.swing.JTextField();
        blother = new javax.swing.JTextField();
        blrealprice = new javax.swing.JTextField();
        blprice = new javax.swing.JTextField();
        blsellname = new javax.swing.JTextField();
        blmobno = new javax.swing.JTextField();
        bladdress = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bldescription = new javax.swing.JTextArea();
        bldate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("ID no");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Time");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Book Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Description");

        Author.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Author.setText("Author");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Old Years");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Academy");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Academic");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Any other ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Book Real Price");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Your Price");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Seller's Name");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Seller's Mob no");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("Seller's Address");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setText("        +Image Front");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 153)));
        jLabel16.setPreferredSize(new java.awt.Dimension(2, 2));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("         +Image Back");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 102)));
        jLabel17.setPreferredSize(new java.awt.Dimension(2, 2));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("     +Image Price Tag");
        jLabel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        jLabel18.setPreferredSize(new java.awt.Dimension(2, 2));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("       +Normal Image");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jLabel19.setPreferredSize(new java.awt.Dimension(2, 22));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        idno.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        bltime.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blauthor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        blauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blauthorActionPerformed(evt);
            }
        });

        blold.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        nlacademy.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blacademic.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blother.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blrealprice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blprice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blsellname.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        blmobno.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        bladdress.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jButton2.setText("ENTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bldescription.setColumns(20);
        bldescription.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        bldescription.setRows(5);
        jScrollPane1.setViewportView(bldescription);

        bldate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(blprice))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(blrealprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(blother)
                                    .addComponent(blacademic, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nlacademy)
                                    .addComponent(blold)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(Author, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(blname)
                            .addComponent(blauthor)
                            .addComponent(idno)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(bltime)
                            .addComponent(bldate))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(blsellname))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(blmobno))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bladdress, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blsellname, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(blmobno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bldate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bltime, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bladdress))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(blname, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Author)
                            .addComponent(blauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(blold, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nlacademy, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blacademic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blother, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blrealprice, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(blprice, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(57, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void blauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blauthorActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
       
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        image1 = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(new ImageIcon(image1).getImage().getScaledInstance(jLabel16.getWidth(),jLabel16.getHeight(),Image.SCALE_SMOOTH));
       // Image image = icon.getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_SMOOTH);
        jLabel16.setIcon(icon);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
       
          JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        image2 = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(new ImageIcon(image2).getImage().getScaledInstance(jLabel17.getWidth(),jLabel17.getHeight(),Image.SCALE_SMOOTH));
       // Image image = icon.getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_SMOOTH);
        jLabel17.setIcon(icon);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
      
          JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        image3 = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(new ImageIcon(image3).getImage().getScaledInstance(jLabel18.getWidth(),jLabel18.getHeight(),Image.SCALE_SMOOTH));
       // Image image = icon.getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_SMOOTH);
        jLabel18.setIcon(icon);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
   
          JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        image4 = f.getAbsolutePath();
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(new ImageIcon(image4).getImage().getScaledInstance(jLabel19.getWidth(),jLabel19.getHeight(),Image.SCALE_SMOOTH));
       // Image image = icon.getImage().getScaledInstance(img.getWidth(),img.getHeight(),Image.SCALE_SMOOTH);
        jLabel19.setIcon(icon);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BookListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookListing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookListing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Author;
    private javax.swing.JTextField blacademic;
    private javax.swing.JTextField bladdress;
    private javax.swing.JTextField blauthor;
    private javax.swing.JTextField bldate;
    private javax.swing.JTextArea bldescription;
    private javax.swing.JTextField blmobno;
    private javax.swing.JTextField blname;
    private javax.swing.JTextField blold;
    private javax.swing.JTextField blother;
    private javax.swing.JTextField blprice;
    private javax.swing.JTextField blrealprice;
    private javax.swing.JTextField blsellname;
    private javax.swing.JTextField bltime;
    private javax.swing.JTextField idno;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nlacademy;
    // End of variables declaration//GEN-END:variables

public void insert()
{
    String s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;
   int s1=maxSNO();
   int s2=maxIDno();
   
   Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy/MM/dd");
        s3 = ft.format(date); 
         Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
   s4=sdf.format(cal.getTime());
   s5=blname.getText();
   s6=blauthor.getText();
   s7=bldescription.getText();
   s8=blold.getText();
   s9=nlacademy.getText();
   s10=blacademic.getText();
   s11=blother.getText();
   s12=blrealprice.getText();
   s13=blprice.getText();
   s14=blsellname.getText();
   s15=blmobno.getText();
   s16=bladdress.getText();
   s17="0";
   String que="insert into booklisting (BSNO,BIDno,BDate,BTime,BookName,BAuthor,BDescription,Byearold,Academy,Academic,OtherStream,BRealPrice,SellerPrice,ImageFront,ImageBack,ImagePriceTag,ImageWhole,SellerName,SellerMobNo,SellerAddress,Status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   System.out.println(que);
   PustakDB db=new PustakDB();
   try
   {
       PreparedStatement ps=db.con.prepareStatement(que);
       ps.setInt(1,s1);
       ps.setInt(2, s2);
       ps.setString(3,s3);
       ps.setString(4,s4);
       ps.setString(5,s5);
       ps.setString(6,s6);
       ps.setString(7,s7);
       ps.setString(8,s8);
       ps.setString(9,s9);
       ps.setString(10,s10);
       ps.setString(11,s11);
       ps.setString(12,s12);
       ps.setString(13,s13);
       File imageA=new File(image1);
       FileInputStream fis1= new FileInputStream (imageA);
       ps.setBinaryStream(14, fis1,fis1.available());
       File imageB=new File(image2);
      FileInputStream fis2=new FileInputStream(imageB);
       ps.setBinaryStream(15, fis2,fis2.available());
      File  imageC=new File(image3);
      FileInputStream fis3=new FileInputStream(imageC);
       ps.setBinaryStream(16, fis3,fis3.available());
      File imageD=new File(image4);
      FileInputStream fis4=new FileInputStream(imageD);
       ps.setBinaryStream(17, fis4,fis4.available());
       ps.setString(18,s14);
       ps.setString(19,s15);
       ps.setString(20,s16);
       ps.setString(21,s17);
       ps.execute();
       JOptionPane.showMessageDialog(null,"YOUR BOOK LISTED SUCCESSFULLY.....");
   }catch(Exception e)
   {
       JOptionPane.showMessageDialog(null,e+" INSERT FUNCTION ");
   }
   image1=null;
   image2=null;
   image3=null;
   image4=null;
}

}
