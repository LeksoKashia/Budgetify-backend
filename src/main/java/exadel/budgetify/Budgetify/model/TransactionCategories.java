package exadel.budgetify.Budgetify.model;

import jakarta.persistence.*;

@Entity
public class TransactionCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public TransactionCategories() {
    }

    public TransactionCategories(String name, String type, Transaction transaction) {
        this.name = name;
        this.type = type;
        this.transaction = transaction;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
