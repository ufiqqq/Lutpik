package controller;

import Node.Poli;
import Node.Queue;
import Node.Transaction;
import model.ModelTransaction;

public class TransactionController {
    public ModelTransaction modelTransaction;

    public TransactionController(){
        this.modelTransaction = new ModelTransaction();
    }
    public void addTransaction(Queue antrean, Poli poli){
        int id = modelTransaction.getLastCode()+1;
        Transaction transaction = new Transaction(id, antrean, poli);
        modelTransaction.modelAddTransaction(transaction);
    }

    public Transaction searchTransaksi(int idT){
        return modelTransaction.searchTransaction(idT);
    }
}
