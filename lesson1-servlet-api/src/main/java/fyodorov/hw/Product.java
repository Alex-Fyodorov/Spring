package fyodorov.hw;

public class Product {
    private Long id;
    private String tittle;
    private int cost;

    public Product(String tittle, int cost) {
        this.tittle = tittle;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}