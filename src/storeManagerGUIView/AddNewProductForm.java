package storeManagerGUIView;

import controller.Backend_DAO_List;
import jdk.jfr.Description;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddNewProductForm extends JFrame {

    private JComboBox<Itemtype> comboBoxProduct;
    private JButton BTNAddProduct;
    private JTextField NameProdTXT;
    private JTextField DescriptionProdTXT;
    private JTextField PriceProdTXT;
    private JTextField ProdTypeTXT;
    private JLabel JNameProduct;
    private JLabel JDescriptionProduct;
    private JLabel JPriceToUnit;
    private JLabel JType;
    public JPanel panel;

    Backend_DAO_List bdl = Backend_DAO_List.get();

    public AddNewProductForm(ManageCatalogForm m){
        DefaultComboBoxModel<Itemtype> model = new DefaultComboBoxModel(Itemtype.values());
        comboBoxProduct.setModel(model);

        ProdTypeTXT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (!Character.isDigit(e.getKeyChar()) || ProdTypeTXT.getText().length()>=5)
                    e.consume();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        PriceProdTXT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (!Character.isDigit(e.getKeyChar()) )
                    e.consume();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        comboBoxProduct.setSelectedIndex(0);
        comboBoxProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JType.setText(isInHardwareMode()?"תקופת אחריות":"מספר משתמשים");
            }
        });
        BTNAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Product product=null;
                    if (NameProdTXT.getText().isBlank())
                        throw new Exception("חובה להכניס שם מוצר");

                    if(isInHardwareMode()){
                        product= new HardwareProduct(NameProdTXT.getText(), DescriptionProdTXT.getText(),Float.parseFloat(PriceProdTXT.getText()),Integer.parseInt(ProdTypeTXT.getText()));
                    }
                    else {
                        product= new SoftwareProduct( NameProdTXT.getText(), DescriptionProdTXT.getText(),Float.parseFloat(PriceProdTXT.getText()),Integer.parseInt(ProdTypeTXT.getText()));
                    }
                    bdl.AddProduct(product);
                    m.RefreshProductList();

                    JOptionPane.showMessageDialog(AddNewProductForm.this,"הלקוח התווסף בהצלחה");
                    System.out.println(bdl.getAllProducts());
                    System.out.println(product);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddNewProductForm.this,ex.getMessage());
                }
            }
        });
    }

    private boolean isInHardwareMode()
    {
        return comboBoxProduct.getSelectedItem().equals(Itemtype.HARDWARE);
    }

}
