public class Order {
    private final String customer;
    private final String good;
    private final Integer count;

    public Order(String customer,String gud, Integer count){
        this.customer = customer;
        this.good = gud;
        this.count = count;
    }

    public String getCustomer() {
        return customer;
    }

    public String getGood() {
        return good;
    }

    public Integer getCount() {
        return count;
    }
}
