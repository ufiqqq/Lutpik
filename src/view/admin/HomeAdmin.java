package view.admin;

import view.HomePage;
import view.RoundButton;

import javax.swing.*;

import Node.Admin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HomeAdmin extends JFrame {

    List<JButton> buttons;
    Admin atmin;
    public HomeAdmin(Admin admin){
        this.buttons = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);
//        add(new JS)
        this.atmin = admin;
        components();
        actionHandler();
        setVisible(true);
    }

    public void components(){
        RoundButton back = new RoundButton("LogOut");
        back.setBounds(30, 30, 90, 30);

        Font font = new Font("HelveticaNeue", Font.ITALIC, 20);

        JLabel label = new JLabel("Menu Admin");
        label.setBounds(165, 120, 200, 20);
        label.setForeground(Color.green);
        label.setFont(font);


        String[] data = {"List Poli", "List Dokter", "Cetak Transaksi"};
        int y = 150;
        for (String txt: data){
            RoundButton button = new RoundButton(txt);
            button.setBounds(165, y, 200, 50);
            button.setForeground(Color.white);
            button.setBackground(Color.gray);
            button.setBorderPainted(false);

            y+=65;
            buttons.add(button);
            add(button);
        }

        back.addActionListener(e -> event());
        add(back);
        add(label);
        gambar();
    }

    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }

    public void actionHandler(){
        buttons.get(0).addActionListener(e ->{
            ListPoli listPoli = new ListPoli(atmin);
            this.setVisible(false);
            listPoli.setVisible(true);
        });

        buttons.get(1).addActionListener(e ->{
            ListDokter listDokter = new ListDokter(atmin);
            this.setVisible(false);
            listDokter.setVisible(true);
        });

        buttons.get(2).addActionListener(e -> {
            CetakTransaksi cetakTransaksi = new CetakTransaksi(atmin);
            this.setVisible(false);
            cetakTransaksi.setVisible(true);
        });
    }

    public void gambar(){
        ImageIcon icon = new ImageIcon("D:/Proyek PBO/Puskesmas-master/src/gambar/Logo.jpg");
        Image gambar = icon.getImage();

        Image resized = gambar.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedd = new ImageIcon(resized);
        JLabel gamba = new JLabel(resizedd);
        gamba.setBounds(0, 0, 900, 600);

        add(gamba);
    }

}
