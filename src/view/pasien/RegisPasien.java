package view.pasien;

import controller.PasienController;
import view.HomePage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegisPasien extends JFrame {

    ArrayList<JTextField> txtField;
    PasienController pasienController;
    public RegisPasien(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

        txtField = new ArrayList<>();
        pasienController = new PasienController();

        components();
        setVisible(true);
    }

    public void components(){
        JButton back = new JButton("Kembali");
        back.setBounds(30, 30, 90, 30);

        JButton submit = new JButton("Submit");
        submit.setBounds(160, 450, 90, 30);

        String[] data = {"Nama Pasien", "Alamat", "Gender [L/P]", "Tempat Tanggal Lahir", "NIK", "BPJS"};
        int y = 80;
        for (String val: data){
            JLabel label = new JLabel(val);
            label.setBounds(165, y, 200, 20);

            JTextField txt = new JTextField();
            txt.setBounds(160, y+20, 300, 30);

            txtField.add(txt);
            y+=60;
            add(label);
            add(txt);
            add(submit);
        }

        back.addActionListener(e -> event());
        submit.addActionListener(e -> daftar());
        add(back);
        gambar();

    }

    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
    }

    public void daftar(){
        boolean cek = pasienController.isNIKAda(txtField.get(4).getText(), txtField.get(5).getText());
        if (cek){
            pasienController.addPasien(txtField.get(0).getText(), txtField.get(1).getText(),txtField.get(2).getText(),txtField.get(3).getText(),txtField.get(4).getText(),txtField.get(5).getText());
            JOptionPane.showMessageDialog(this, "Pasien berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            event();
        } else {
            JOptionPane.showMessageDialog(this, "NIK/BPJS sudah terdaftar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

        public void gambar(){
        ImageIcon icon = new ImageIcon("D:/Proyek PBO/Puskesmas-master/src/gambar/asek.jpg");
        Image gambar = icon.getImage();

        Image resized = gambar.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedd = new ImageIcon(resized);
        JLabel gamba = new JLabel(resizedd);
        gamba.setBounds(0, 0, 900, 600);

        add(gamba);
    }


}
