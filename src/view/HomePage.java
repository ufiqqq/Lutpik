package view;

import controller.DokterController;
import controller.PoliController;
import view.admin.LoginAdmin;
import view.pasien.LoginPasien;
import view.pasien.RegisPasien;

import javax.swing.*;

import Node.Dokter;
import Node.Poli;
import Node.Schedule;

import java.awt.*;
import java.util.ArrayList;

public class HomePage extends JFrame {
    LoginPasien loginPasien;
    RegisPasien regisPasien;
    JPanel inputPanel;
    DokterController dokterController;
    PoliController poliController;
    ArrayList<JButton> buttons;


    public HomePage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        setResizable(false);

        buttons = new ArrayList<>();
        dokterController = new DokterController();
        poliController=new PoliController();
        components();
        actionHandler();
        setVisible(true);
    }

    public void components(){

        JLabel judul = new JLabel("Pendaftaran Puskesmas Online");
        Font font = new Font("HelveticaNeue", Font.ITALIC, 20);
        judul.setForeground(Color.green);
        judul.setFont(font);
        judul.setBounds(310, 180, 300, 40);

        String[] data = {"registrasi pasien", "ambil antrean", "jadwal praktek dokter"};
        int y = 230;
        for (String txt: data){
            RoundButton button = new RoundButton(txt);
            button.setBounds(350, y, 200, 30);
            button.setForeground(Color.white);
            button.setBackground(Color.black);
            button.setFocusPainted(false);
            button.setBorderPainted(false);

            y+=40;
            buttons.add(button);
            add(button);
        }

        RoundButton loginAdmin = new RoundButton("Login admin");
        loginAdmin.setBounds(700, 500, 150, 30);
        loginAdmin.setForeground(Color.yellow);
        loginAdmin.setBackground(Color.blue);
        loginAdmin.setBorderPainted(false);

        loginAdmin.addActionListener(e -> loginAdminView());

        add(judul);

        add(loginAdmin);
        gambar();
    }

    public void gambar(){
        ImageIcon icon = new ImageIcon("src/gambar/Logo.jpg");
        Image gambar = icon.getImage();

        Image resized = gambar.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon resizedd = new ImageIcon(resized);
        JLabel gamba = new JLabel(resizedd);
        gamba.setBounds(0, 0, 900, 600);

        add(gamba);
    }

    public void loginAdminView(){
        LoginAdmin loginView = new LoginAdmin();
        this.setVisible(false);
        loginView.setVisible(true);
    }
    public void jadwalPraktek() {
        inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(0, 1));
        for (Dokter dokter : dokterController.modelDokter.dokters) {
            inputPanel.add(new JLabel("Dokter : " + dokter.namaDokter));
            inputPanel.add(new JLabel("Poli   : " + dokter.poli.namaPoli));
            for (Schedule schedule : dokter.schedules) {
                inputPanel.add(new JLabel(schedule.hari + " " + schedule.jam));
            }
            inputPanel.add(new JLabel("\n"));
        }

        JScrollPane scrollPane = new JScrollPane(inputPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        int result = JOptionPane.showConfirmDialog(this, scrollPane, "Jadwal Praktek dokter", JOptionPane.OK_CANCEL_OPTION);
    }

    public void actionHandler(){
        buttons.get(0).addActionListener(e ->{
            regisPasien = new RegisPasien();
            this.setVisible(false);
            regisPasien.setVisible(true);
        });

        buttons.get(1).addActionListener(e ->{
            loginPasien = new LoginPasien();
            this.setVisible(false);
            loginPasien.setVisible(true);
        });

        buttons.get(2).addActionListener(e -> jadwalPraktek());
    }


}
