package view.admin;
import controller.TransactionController;

import javax.swing.*;

import Node.Admin;
import Node.Transaction;

import java.awt.*;

public class CetakTransaksi extends JFrame {
    Admin atmin;
    JPanel inputPanel;
    TransactionController transactionController;
    public CetakTransaksi(Admin admin){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        setLayout(null);

        this.atmin = admin;
        this.transactionController = new TransactionController();

        setResizable(false);
        component();
    }

    public void component(){
        JButton back = new JButton("Kembali");
        back.setBounds(30, 30, 90, 30);

        JLabel judul = new JLabel("List Transaksi");
        judul.setBounds(165, 90, 100, 20);

        int y=130;
        for (Transaction transaction: transactionController.modelTransaction.transactions){
            JLabel label = new JLabel(transaction.poli.namaPoli+" "+transaction.antrean.kodePasien+" "+transaction.antrean.pasien.namaPasien);
            label.setBounds(165, y, 200, 20);

            JButton print = new JButton("Cetak");
            print.setBounds(365, y, 100, 20);
            print.addActionListener(e -> cetakTransaksi(transaction));
            add(label);
            add(print);
            y+=30;
        }

        back.addActionListener(e -> event());

        add(back);
        add(judul);
    }

    public void event(){
        HomeAdmin homeAdmin = new HomeAdmin(atmin);
        this.dispose();
        homeAdmin.setVisible(true);
    }

    public void cetakTransaksi(Transaction transaction){
        inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout( 10,1));
        inputPanel.add(new JLabel("+<<Puskesmas Abal-Abal>>+"));
        inputPanel.add(new JLabel("  Kode Antrean : "+transaction.antrean.kodePasien));
        inputPanel.add(new JLabel("  Poli : "+transaction.poli.namaPoli));
        inputPanel.add(new JLabel("  Nama Pasien : "+transaction.antrean.pasien.namaPasien));
        inputPanel.add(new JLabel("  NIK : "+transaction.antrean.pasien.NIK));
        inputPanel.add(new JLabel("  BPJS : "+transaction.antrean.pasien.BPJS));
        inputPanel.add(new JLabel("  Tanggal : "+transaction.tanggal));
        inputPanel.add(new JLabel("  Admin : "+atmin.username));

        int result = JOptionPane.showConfirmDialog(this, inputPanel, "Data Transaksi Pasien", JOptionPane.OK_CANCEL_OPTION);

    }
}
