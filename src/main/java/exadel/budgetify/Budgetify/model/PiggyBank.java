package exadel.budgetify.Budgetify.model;

import jakarta.persistence.*;

@Entity
public class PiggyBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goal;

    private float goalAmount;

    private float savedAmount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public PiggyBank() {
    }

    public PiggyBank(String goal, float goalAmount, float savedAmount, Account account) {
        this.goal = goal;
        this.goalAmount = goalAmount;
        this.savedAmount = savedAmount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public float getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(float goalAmount) {
        this.goalAmount = goalAmount;
    }

    public float getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(float savedAmount) {
        this.savedAmount = savedAmount;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
