public enum Drinks {
    YES(0, "спиртное", 12), NO(1, "безалкогольное", 0);
    private int var;
    private String description;
    private int price;

    Drinks(int var, String description, int price) {
        this.var = var;
        this.description = description;
        this.price = price;
    }

    public int getVar() {
        return var;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "var=" + var +
                ", description='" + description + '\'' +
                ", price=" + price + " $ " +
                '}';
    }
}
