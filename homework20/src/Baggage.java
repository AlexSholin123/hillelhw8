public class Baggage {
    private int amount;
    private int customFee;

    public Baggage(int amount, int customFee) {
        this.amount = amount;
        this.customFee = customFee;
    }

    public int getFee() {
        return customFee * amount;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "amount=" + amount +
                ", customFree=" + customFee +
                '}';
    }
}

