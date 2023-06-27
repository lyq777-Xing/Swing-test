/*
 * Created by JFormDesigner on Sun Jun 18 00:08:45 CST 2023
 */

package views;

import dao.StudentsDao336;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 336
 */
public class Add336 extends JFrame {
    public Add336() {
        initComponents();
        ButtonGroup group=new ButtonGroup();//按钮组
        group.add(radioButton1);//把按钮放在按钮组中
        group.add(radioButton2);
    }

//    public static void main(String[] args) {
//        new Add336().setVisible(true);
//    }

    private void close(ActionEvent e) {
        // TODO add your code here
        this.setVisible(false);
    }

    private void Add(ActionEvent e) {
        // TODO add your code here
        String sex = "";
        if(radioButton1.isSelected()){
            sex = "男";
        }
        if(radioButton2.isSelected()){
            sex = "女";
        }
        if(!radioButton1.isSelected() && !radioButton2.isSelected()){
            JOptionPane.showMessageDialog(Add336.this,"请选择性别");
            return;
        }
        if(number.getText()==null || number.getText().equals("") || name.getText()==null || name.getText().equals("")
                || profession.getText()==null || profession.getText().equals("") || grade.getText()==null || grade.getText().equals("")) {
            JOptionPane.showMessageDialog(Add336.this,"请填写完整信息");
            return;
        }
        int add = StudentsDao336.add(number.getText(), name.getText(), sex, profession.getText(), grade.getText());
        if(add == 3){
            JOptionPane.showMessageDialog(Add336.this,"该学号已经存在，请重新输入");
        }else if(add == 1){
            JOptionPane.showMessageDialog(Add336.this,"添加成功！");
            this.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(Add336.this,"添加失败！");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        number = new JTextField();
        label2 = new JLabel();
        name = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        profession = new JTextField();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();
        grade = new JTextField();

        //======== this ========
        setTitle("\u6dfb\u52a0\u5b66\u751f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(25, 5, 50, 40);
        contentPane.add(number);
        number.setBounds(75, 10, 100, number.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(25, 60), label2.getPreferredSize()));
        contentPane.add(name);
        name.setBounds(75, 55, 100, name.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(220, 60), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u4e13\u4e1a\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(25, 110), label4.getPreferredSize()));
        contentPane.add(profession);
        profession.setBounds(75, 105, 100, profession.getPreferredSize().height);

        //---- radioButton1 ----
        radioButton1.setText("\u7537");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(255, 55), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("\u5973");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(300, 55), radioButton2.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> Add(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(90, 185), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addActionListener(e -> close(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(225, 185), button2.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u5e74\u7ea7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(225, 110), label5.getPreferredSize()));
        contentPane.add(grade);
        grade.setBounds(265, 105, 70, grade.getPreferredSize().height);

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
        setSize(465, 355);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField number;
    private JLabel label2;
    private JTextField name;
    private JLabel label3;
    private JLabel label4;
    private JTextField profession;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    private JTextField grade;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
