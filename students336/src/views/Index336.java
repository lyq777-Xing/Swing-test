/*
 * Created by JFormDesigner on Sat Jun 17 23:02:43 CST 2023
 */

package views;

import dao.StudentsDao336;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 336
 */
public class Index336 extends JFrame {
    private Integer id;
    private int updId;
    public Index336() {
        initComponents();
        findCounts();
        findAll();
        ButtonGroup group=new ButtonGroup();//按钮组
        group.add(radioButton1);//把按钮放在按钮组中
        group.add(radioButton2);
    }

    public static void main(String[] args) {
        new Index336().setVisible(true);
    }

    /**
     * 获取所有数据
     */
    private void findAll(){
        ResultSet date = StudentsDao336.findAll();
        String s = "";
        try {
            while (date.next()){
                s = s + date.getString(1) + "," + date.getString(2) + "," + date.getString(3) + "," + date.getString(4) + "," + date.getString(5) + "\n";
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        all.setText(s);
    }

    /**
     * 获取数据总数
     */
    private void findCounts(){
        ResultSet date = StudentsDao336.findCount();
        try {
            while (date.next()){
                count.setText(String.valueOf(date.getInt(1)));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 查找第一条数据
     * @param e
     */
    private void findFirst(ActionEvent e) {
        // TODO add your code here
        ResultSet first1 = StudentsDao336.findFirst();
        try {
            while (first1.next()){
                number.setText(first1.getString(1));
                name.setText(first1.getString(2));
                sex.setText(first1.getString(3));
                profession.setText(first1.getString(4));
                grade.setText(first1.getString(5));
                id = first1.getInt(6);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }

    /**
     * 查找上一条记录
     * @param e
     */
    private void findlast(ActionEvent e) {
        // TODO add your code here
        ResultSet first1 = StudentsDao336.findLast(id);
        try {
            while (first1.next()){
                number.setText(first1.getString(1));
                name.setText(first1.getString(2));
                sex.setText(first1.getString(3));
                profession.setText(first1.getString(4));
                grade.setText(first1.getString(5));
                id = first1.getInt(6);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 查找下一条记录
     * @param e
     */
    private void findnext(ActionEvent e) {
        // TODO add your code here
        ResultSet first1 = StudentsDao336.findNext(id);
        try {
            while (first1.next()){
                number.setText(first1.getString(1));
                name.setText(first1.getString(2));
                sex.setText(first1.getString(3));
                profession.setText(first1.getString(4));
                grade.setText(first1.getString(5));
                id = first1.getInt(6);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 查找最后一条记录
     * @param e
     */
    private void findatlast(ActionEvent e) {
        // TODO add your code here
        ResultSet first1 = StudentsDao336.findfinal();
        try {
            while (first1.next()){
                number.setText(first1.getString(1));
                name.setText(first1.getString(2));
                sex.setText(first1.getString(3));
                profession.setText(first1.getString(4));
                grade.setText(first1.getString(5));
                id = first1.getInt(6);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void findByNumber(ActionEvent e) {
        // TODO add your code here
        ResultSet date = StudentsDao336.findByNumber(findnunber.getText());
        int idd = 0;
        try {
            while (date.next()){
                number.setText(date.getString(1));
                name.setText(date.getString(2));
                sex.setText(date.getString(3));
                profession.setText(date.getString(4));
                grade.setText(date.getString(5));
                id = date.getInt(6);
                idd = date.getInt(6);

            }
            if(idd == 0){
                JOptionPane.showMessageDialog(Index336.this,"该学号不存在请重新输入");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void del(ActionEvent e) {
        // TODO add your code here
        ResultSet date = StudentsDao336.findByNumber(findnunber.getText());
        int idd = 0;
        try {
            while (date.next()){
                idd = date.getInt(6);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        if(idd == 0){
            JOptionPane.showMessageDialog(Index336.this,"该学号不存在请重新输入");
        }else {
            int del1 = StudentsDao336.del(idd);
            if(del1 == 1){
                JOptionPane.showMessageDialog(Index336.this,"删除成功");
            }else {
                JOptionPane.showMessageDialog(Index336.this,"删除失败");
            }
        }
    }

    private void refesh(ActionEvent e) {
        // TODO add your code here
        findAll();
        findCounts();
    }

    private void look(ActionEvent e) {
        // TODO add your code here
        panel1.setVisible(true);
    }

    private void unlook(ActionEvent e) {
        // TODO add your code here
        panel1.setVisible(false);
    }

    private void add(ActionEvent e) {
        // TODO add your code here
        new Add336().setVisible(true);
    }

    private void upd(ActionEvent e) {
        // TODO add your code here
        ResultSet date = StudentsDao336.findByNumber(findnunber.getText());
        int idd = 0;
        try {
            while (date.next()){
                idd = date.getInt(6);
                number2.setText(date.getString(1));
                name2.setText(date.getString(2));
//                sex.setText(date.getString(3));
                profession2.setText(date.getString(4));
                grade2.setText(date.getString(5));
                updId = date.getInt(6);
                if(date.getString(3).equals("男")){
                    radioButton1.doClick();
                }else {
                    radioButton2.doClick();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        if(idd == 0){
            JOptionPane.showMessageDialog(Index336.this,"该学号不存在请重新输入");
        }else {
            desktopPane1.setVisible(true);
        }
    }

    private void close(ActionEvent e) {
        // TODO add your code here
        desktopPane1.setVisible(false);
    }

    private void doUpd(ActionEvent e) {
        // TODO add your code here
        String sex2 = "";
        if(radioButton1.isSelected()){
            sex2 = "男";
        }
        if(radioButton2.isSelected()){
            sex2 = "女";
        }
        int upd1 = StudentsDao336.upd(number2.getText(), name2.getText(), sex2, profession2.getText(), grade2.getText(), updId);
        if(upd1 == 1){
            JOptionPane.showMessageDialog(Index336.this,"更新成功");
            desktopPane1.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(Index336.this,"更新失败");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        desktopPane1 = new JDesktopPane();
        internalFrame1 = new JInternalFrame();
        label10 = new JLabel();
        number2 = new JTextField();
        label11 = new JLabel();
        name2 = new JTextField();
        label12 = new JLabel();
        label13 = new JLabel();
        profession2 = new JTextField();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        button2 = new JButton();
        label14 = new JLabel();
        grade2 = new JTextField();
        button6 = new JButton();
        label1 = new JLabel();
        number = new JTextField();
        label2 = new JLabel();
        name = new JTextField();
        label3 = new JLabel();
        sex = new JTextField();
        label4 = new JLabel();
        profession = new JTextField();
        label5 = new JLabel();
        grade = new JTextField();
        first = new JButton();
        last = new JButton();
        next = new JButton();
        atlast = new JButton();
        label6 = new JLabel();
        findnunber = new JTextField();
        find = new JButton();
        add = new JButton();
        upd = new JButton();
        del = new JButton();
        label7 = new JLabel();
        count = new JTextField();
        label8 = new JLabel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        all = new JTextArea();
        label9 = new JLabel();
        refesh = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        setTitle("\u4e09\u5c42\u7ed3\u6784\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7a0b\u5e8f");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== desktopPane1 ========
        {
            desktopPane1.setVisible(false);

            //======== internalFrame1 ========
            {
                internalFrame1.setVisible(true);
                Container internalFrame1ContentPane = internalFrame1.getContentPane();
                internalFrame1ContentPane.setLayout(null);

                //---- label10 ----
                label10.setText("\u5b66\u53f7\uff1a");
                internalFrame1ContentPane.add(label10);
                label10.setBounds(75, 30, 50, 40);

                //---- number2 ----
                number2.setEditable(false);
                internalFrame1ContentPane.add(number2);
                number2.setBounds(125, 35, 100, 30);

                //---- label11 ----
                label11.setText("\u59d3\u540d\uff1a");
                internalFrame1ContentPane.add(label11);
                label11.setBounds(75, 85, 36, 17);
                internalFrame1ContentPane.add(name2);
                name2.setBounds(125, 80, 100, 30);

                //---- label12 ----
                label12.setText("\u6027\u522b\uff1a");
                internalFrame1ContentPane.add(label12);
                label12.setBounds(270, 85, 36, 17);

                //---- label13 ----
                label13.setText("\u4e13\u4e1a\uff1a");
                internalFrame1ContentPane.add(label13);
                label13.setBounds(75, 135, 36, 17);
                internalFrame1ContentPane.add(profession2);
                profession2.setBounds(125, 130, 100, 30);

                //---- radioButton1 ----
                radioButton1.setText("\u7537");
                internalFrame1ContentPane.add(radioButton1);
                radioButton1.setBounds(305, 80, 50, 21);

                //---- radioButton2 ----
                radioButton2.setText("\u5973");
                internalFrame1ContentPane.add(radioButton2);
                radioButton2.setBounds(375, 80, 50, 21);

                //---- button2 ----
                button2.setText("\u53d6\u6d88");
                button2.addActionListener(e -> close(e));
                internalFrame1ContentPane.add(button2);
                button2.setBounds(275, 210, 78, 30);

                //---- label14 ----
                label14.setText("\u5e74\u7ea7\uff1a");
                internalFrame1ContentPane.add(label14);
                label14.setBounds(275, 135, 36, 17);
                internalFrame1ContentPane.add(grade2);
                grade2.setBounds(315, 130, 100, 30);

                //---- button6 ----
                button6.setText("\u786e\u5b9a");
                button6.addActionListener(e -> doUpd(e));
                internalFrame1ContentPane.add(button6);
                button6.setBounds(new Rectangle(new Point(145, 210), button6.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < internalFrame1ContentPane.getComponentCount(); i++) {
                        Rectangle bounds = internalFrame1ContentPane.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = internalFrame1ContentPane.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    internalFrame1ContentPane.setMinimumSize(preferredSize);
                    internalFrame1ContentPane.setPreferredSize(preferredSize);
                }
            }
            desktopPane1.add(internalFrame1, JLayeredPane.DEFAULT_LAYER);
            internalFrame1.setBounds(15, 10, 485, 340);
        }
        contentPane.add(desktopPane1);
        desktopPane1.setBounds(35, 55, 510, 355);

        //---- label1 ----
        label1.setText("\u5b66\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(160, 25), label1.getPreferredSize()));

        //---- number ----
        number.setEditable(false);
        contentPane.add(number);
        number.setBounds(200, 20, 120, number.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(125, 70), label2.getPreferredSize()));

        //---- name ----
        name.setEditable(false);
        contentPane.add(name);
        name.setBounds(165, 65, 80, name.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6027\u522b\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(275, 70), label3.getPreferredSize()));

        //---- sex ----
        sex.setEditable(false);
        contentPane.add(sex);
        sex.setBounds(310, 65, 60, sex.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u4e13\u4e1a\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(90, 115), label4.getPreferredSize()));

        //---- profession ----
        profession.setEditable(false);
        contentPane.add(profession);
        profession.setBounds(130, 110, 125, profession.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u5e74\u7ea7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(280, 115), label5.getPreferredSize()));

        //---- grade ----
        grade.setEditable(false);
        contentPane.add(grade);
        grade.setBounds(320, 110, 80, grade.getPreferredSize().height);

        //---- first ----
        first.setText("\u9996\u8bb0\u5f55");
        first.addActionListener(e -> findFirst(e));
        contentPane.add(first);
        first.setBounds(new Rectangle(new Point(45, 160), first.getPreferredSize()));

        //---- last ----
        last.setText("\u4e0a\u8bb0\u5f55");
        last.addActionListener(e -> findlast(e));
        contentPane.add(last);
        last.setBounds(new Rectangle(new Point(150, 160), last.getPreferredSize()));

        //---- next ----
        next.setText("\u4e0b\u8bb0\u5f55");
        next.addActionListener(e -> findnext(e));
        contentPane.add(next);
        next.setBounds(new Rectangle(new Point(255, 160), next.getPreferredSize()));

        //---- atlast ----
        atlast.setText("\u5c3e\u8bb0\u5f55");
        atlast.addActionListener(e -> findatlast(e));
        contentPane.add(atlast);
        atlast.setBounds(new Rectangle(new Point(365, 160), atlast.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u8bf7\u8f93\u5165\u5b66\u53f7\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(15, 210), label6.getPreferredSize()));
        contentPane.add(findnunber);
        findnunber.setBounds(90, 205, 120, findnunber.getPreferredSize().height);

        //---- find ----
        find.setText("\u67e5\u627e");
        find.addActionListener(e -> findByNumber(e));
        contentPane.add(find);
        find.setBounds(new Rectangle(new Point(220, 205), find.getPreferredSize()));

        //---- add ----
        add.setText("\u6dfb\u52a0");
        add.addActionListener(e -> add(e));
        contentPane.add(add);
        add.setBounds(new Rectangle(new Point(300, 205), add.getPreferredSize()));

        //---- upd ----
        upd.setText("\u4fee\u6539");
        upd.addActionListener(e -> upd(e));
        contentPane.add(upd);
        upd.setBounds(new Rectangle(new Point(385, 205), upd.getPreferredSize()));

        //---- del ----
        del.setText("\u5220\u9664");
        del.addActionListener(e -> del(e));
        contentPane.add(del);
        del.setBounds(new Rectangle(new Point(475, 205), del.getPreferredSize()));

        //---- label7 ----
        label7.setText("----------------------\u6d4f\u89c8\u533a-------------------\u603b\u8bb0\u5f55\u6570\uff1a");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(35, 255), label7.getPreferredSize()));

        //---- count ----
        count.setEnabled(false);
        contentPane.add(count);
        count.setBounds(325, 250, 60, count.getPreferredSize().height);

        //---- label8 ----
        label8.setText("---------------------------------");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(385, 255), label8.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //======== scrollPane1 ========
            {
                scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane1.setViewportView(all);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(15, 10, 520, 160);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(20, 315, 545, 175);

        //---- label9 ----
        label9.setText("\u5b66\u53f7-\u59d3\u540d-\u6027\u522b-\u4e13\u4e1a-\u5e74\u7ea7");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(35, 285), label9.getPreferredSize()));

        //---- refesh ----
        refesh.setText("\u5237\u65b0");
        refesh.addActionListener(e -> refesh(e));
        contentPane.add(refesh);
        refesh.setBounds(new Rectangle(new Point(365, 495), refesh.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u6d4f\u89c8");
        button4.addActionListener(e -> look(e));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(270, 495), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("\u53d6\u6d88\u6d4f\u89c8");
        button5.addActionListener(e -> unlook(e));
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(460, 495), button5.getPreferredSize()));

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
        setSize(585, 570);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JDesktopPane desktopPane1;
    private JInternalFrame internalFrame1;
    private JLabel label10;
    private JTextField number2;
    private JLabel label11;
    private JTextField name2;
    private JLabel label12;
    private JLabel label13;
    private JTextField profession2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button2;
    private JLabel label14;
    private JTextField grade2;
    private JButton button6;
    private JLabel label1;
    private JTextField number;
    private JLabel label2;
    private JTextField name;
    private JLabel label3;
    private JTextField sex;
    private JLabel label4;
    private JTextField profession;
    private JLabel label5;
    private JTextField grade;
    private JButton first;
    private JButton last;
    private JButton next;
    private JButton atlast;
    private JLabel label6;
    private JTextField findnunber;
    private JButton find;
    private JButton add;
    private JButton upd;
    private JButton del;
    private JLabel label7;
    private JTextField count;
    private JLabel label8;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea all;
    private JLabel label9;
    private JButton refesh;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
