package exadel.budgetify.Budgetify.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Obligatory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private float amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false, updatable = false)
    private Date endDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Obligatory() {
    }

    public Obligatory(String title, float amount, Date startDate, Date endDate,
                      String description, Account account) {
        this.title = title;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
