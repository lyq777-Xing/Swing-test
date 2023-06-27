import java.awt.*;
import javax.swing.*;
///*
// * Created by JFormDesigner on Sun Jun 18 00:34:56 CST 2023
// */
//
//package views;
//
//import dao.StudentsDao336;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
///**
// * @author 336
// */
//public class upd336 extends JFrame {
//    public upd336() {
//        initComponents();
//    }
//
//
//
//    private void close(ActionEvent e) {
//        // TODO add your code here
//        this.setVisible(false);
//    }
//
//    private void upd(ActionEvent e) {
////        StudentsDao336.upd(number.getText(),name.getText(),,profession.getText(),grade.getText(),)
//    }
//
//    private void initComponents() {
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
//
//        //======== this ========
//        setTitle("\u4fee\u6539\u5b66\u751f\u4fe1\u606f");
//        Container contentPane = getContentPane();
//        contentPane.setLayout(null);
//
//        {
//            // compute preferred size
//            Dimension preferredSize = new Dimension();
//            for(int i = 0; i < contentPane.getComponentCount(); i++) {
//                Rectangle bounds = contentPane.getComponent(i).getBounds();
//                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
//                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
//            }
//            Insets insets = contentPane.getInsets();
//            preferredSize.width += insets.right;
//            preferredSize.height += insets.bottom;
//            contentPane.setMinimumSize(preferredSize);
//            contentPane.setPreferredSize(preferredSize);
//        }
//        setSize(515, 370);
//        setLocationRelativeTo(null);
//        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
//    }
//
//    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
//    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
//}

public class upd336 extends JFrame {
    public upd336() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off

        //======== this ========
        setTitle("\u4fee\u6539\u5b66\u751f\u4fe1\u606f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(515, 370);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
