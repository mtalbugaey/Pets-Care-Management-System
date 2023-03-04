/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petscare;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static petscare.Cart.currentCustID;
import static petscare.Cart.totalAmount;
import static petscare.Cart.orderInfo;

/**
 *
 * @author Maryam Tariq
 */
public class OrderInformation extends javax.swing.JFrame {
    
    Connection con;
    Statement st;
    ResultSet rs;
    String orderid;
    String currentCustName;

    /**
     * Creates new form OrderInformation
     */
    public OrderInformation() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosed(WindowEvent event)
                {
                    closeDB();
                    System.exit(0);
                }
            }
        );
        
        try
        {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/PetsCare","root","root");
            st=con.createStatement();
            rs=st.executeQuery("SELECT OrderID FROM Orders WHERE CustomerID = " + currentCustID + " AND TotalAmount = " + totalAmount );
            
            rs.next();
            orderid = String.valueOf(rs.getInt("OrderID"));
            orderIDLabel.setText(orderid);
            priceLabel.setText(String.valueOf(totalAmount) + " SAR");
            
            rs=st.executeQuery("SELECT FirstName, LastName FROM Customer WHERE CustomerID = " + currentCustID );
            rs.next();
            currentCustName = rs.getString("FirstName").concat(" ").concat(rs.getString("LastName"));

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }
    
    public void closeDB()
    {
        try
        {
            rs.close();
            st.close();
            con.close();
        }
        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(this, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        orderIDLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        rateButton = new javax.swing.JButton();
        pdfButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order Information");
        setMaximumSize(new java.awt.Dimension(480, 580));
        setMinimumSize(new java.awt.Dimension(480, 580));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petscare/Icon/PetsCare.png"))); // NOI18N
        jLabel1.setText("PetsCare");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setText("- Order ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("- Total Amount :");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petscare/Icon/Barcode.jpg"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        orderIDLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        orderIDLabel.setText("?");

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        priceLabel.setText("?");

        rateButton.setBackground(new java.awt.Color(78, 95, 200));
        rateButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        rateButton.setForeground(new java.awt.Color(255, 255, 255));
        rateButton.setText("Rate Your Experience !");
        rateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateButtonActionPerformed(evt);
            }
        });

        pdfButton.setBackground(new java.awt.Color(78, 95, 200));
        pdfButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        pdfButton.setForeground(new java.awt.Color(255, 255, 255));
        pdfButton.setText("Print PDF");
        pdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(rateButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceLabel)
                            .addComponent(orderIDLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(pdfButton))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(orderIDLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addGap(27, 27, 27)
                .addComponent(pdfButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rateButton)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(494, 617));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Rate rate = new Rate();
        rate.setVisible(true);
    }//GEN-LAST:event_rateButtonActionPerformed

    private void pdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfButtonActionPerformed
        // TODO add your handling code here:
        
        Document pdfDoc = new Document();
        try
        {
          PdfWriter.getInstance(pdfDoc, new FileOutputStream("bill.pdf"));
          pdfDoc.open();
          
          pdfDoc.add(Image.getInstance("D:\\Maryam\\PetsCare\\src\\petscare\\Icon\\bill1.png"));
          pdfDoc.add(new Paragraph("Customer ID: " + currentCustID));
          pdfDoc.add(new Paragraph("Customer Name: " + currentCustName));
          pdfDoc.add(new Paragraph("Order ID: " + orderid));
          pdfDoc.add(new Paragraph(" "));
          
          PdfPTable table = new PdfPTable(3);
          table.addCell("Name");
          table.addCell("Price");
          table.addCell("Quantity");
          
          for(int i = 0; i< orderInfo.length; i++)
          {
            String recored = orderInfo[i];
            
            String exteactNum = recored.replaceAll("[^0-9].[^0-9]", "");
            exteactNum = exteactNum.trim();
            String[] numList = exteactNum.split("  ");
            
            double priceValue = Double.parseDouble(numList[0]);
            int quantityValue = Integer.parseInt(numList[1]);


            String exteactName = recored.replaceAll("[0-9]", "").replaceAll("SAR", "").replace(".", "").replaceAll("                           ", "");
            table.addCell(exteactName);
            table.addCell(String.valueOf(priceValue));
            table.addCell(String.valueOf(quantityValue));
          }
          pdfDoc.add(table);
          
          Paragraph p = new Paragraph("Total Amount: " + totalAmount + " SAR");
          p.setAlignment(Element.ALIGN_CENTER);
          pdfDoc.add(p);
          
          pdfDoc.add(new Paragraph(" "));
          pdfDoc.add(Image.getInstance("D:\\Maryam\\PetsCare\\src\\petscare\\Icon\\bill2.png"));
          pdfDoc.add(Image.getInstance("D:\\Maryam\\PetsCare\\src\\petscare\\Icon\\bill3.png"));

          pdfDoc.close();
          Desktop desk = Desktop.getDesktop();
          try
          {
              desk.open(new File("bill.pdf"));
          }
          
          catch(IOException ex)
          {
              JOptionPane.showMessageDialog(this, ex.getMessage());
          }
          
        } 
        
        catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } 
        catch (BadElementException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        catch (DocumentException ex) 
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
         
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_pdfButtonActionPerformed

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
            java.util.logging.Logger.getLogger(OrderInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel orderIDLabel;
    private javax.swing.JButton pdfButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton rateButton;
    // End of variables declaration//GEN-END:variables
}