package view.admin;

import view.HomePage;

import javax.swing.*;

import Node.Admin;

import java.awt.*;

public class LoginAdmin extends JFrame {
    JTextField uname;
    JLabel label;

    JPasswordField pass;


    public LoginAdmin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        component();
    }

    public void component(){
        JButton back = new JButton("Back");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("Ini Perintah Admin");
        judul.setBounds(350, 160, 300, 30);

        JLabel username = new JLabel("Input Username");
        username.setBounds(350, 200, 200, 20);

        uname = new JTextField();
        uname.setBounds(350, 220, 200, 30);

        JLabel pw = new JLabel("Input Password");
        pw.setBounds(350, 250, 200, 20);

        pass = new JPasswordField();
        pass.setBounds(350, 270, 200, 30);

        JButton login = new JButton("Login");
        login.setBounds(350, 340, 200, 30);

        label = new JLabel();
        label.setBounds(350, 380, 200, 30);
        add(label);


        back.addActionListener(e -> event());
        login.addActionListener(e -> lojinBang());

        add(back);
        add(judul);
        add(username);
        add(uname);
        add(pw);
        add(pass);
        add(login);

        gambar();
    }

    public void lojinBang(){
        char[] paswod = pass.getPassword();
        String passwordReal = String.valueOf(paswod);

        if (uname.getText().equals("ayo")&&passwordReal.equals("123")){
            Admin atmin = new Admin(uname.getText(),passwordReal);
            HomeAdmin homeAdmin = new HomeAdmin(atmin);
            this.setVisible(false);
            homeAdmin.setVisible(true);
        } else {
            label.setText("ID PW sala ea");
            label.setVisible(true);
        }
    }



    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }

        public void gambar(){
        ImageIcon icon = new ImageIcon("src/gambar/dokter.jpg");
        Image gambar = icon.getImage();

        Image resized = gambar.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedd = new ImageIcon(resized);
        JLabel gamba = new JLabel(resizedd);
        gamba.setBounds(0, 0, 900, 600);

        add(gamba);
    }
}
