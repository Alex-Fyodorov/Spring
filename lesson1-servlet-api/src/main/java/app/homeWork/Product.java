package app.homeWork;

public class Product {
    private int id;
    private String tittle;
    private int cost;

    public Product(int id, String tittle, int cost) {
        this.id = id;
        this.tittle = tittle;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "" + tittle + ", id = " + id + ", cost = $" + cost;
    }
}
