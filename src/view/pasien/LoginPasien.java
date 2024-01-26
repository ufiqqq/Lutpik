package view.pasien;

import controller.PasienController;
import model.ModelPasien;
import view.HomePage;

import javax.swing.*;

import Node.Pasien;

import java.awt.*;

public class LoginPasien extends JFrame {
    JTextField uname;
    JButton login;
    JLabel warn;
    PasienController pasienController;
    PilihPoli pilihPoli;
    public LoginPasien(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        pasienController = new PasienController();

        setResizable(false);
        component();
    }

    public void component(){
        JButton back = new JButton("Kembali");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("Ambil Antrian Pasien!");
        judul.setBounds(350, 160, 300, 30);

        JLabel username = new JLabel("Input NIK/BPJS");
        username.setBounds(350, 200, 200, 20);

        uname = new JTextField();
        uname.setBounds(350, 220, 200, 30);

        login = new JButton("Lanjut");
        login.setBounds(350, 260, 200, 30);


        warn = new JLabel();
        warn.setBounds(350, 290, 200, 30);


        back.addActionListener(e -> event());
        login.addActionListener(e -> loginBang());

        add(warn);
        add(back);
        add(judul);
        add(username);
        add(uname);
        add(login);
        gambar();
    }

    public void loginBang() {
        boolean found = false;

        for (Pasien pasien : pasienController.modelPasien.pasiens) {
            if (uname.getText().equals(pasien.NIK) || uname.getText().equals(pasien.BPJS)) {
                found = true;
                pilihPoli = new PilihPoli(pasien.idPasien);
                this.setVisible(false);
                pilihPoli.setVisible(true);
                break;
            }
        }

        if (!found) {
            warn.setText("NIK/BPJS belum terdaftar :)");
            warn.setVisible(true);
        }
    }


    public void event(){
        HomePage homePage = new HomePage();
        this.setVisible(false);
        homePage.setVisible(true);
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
