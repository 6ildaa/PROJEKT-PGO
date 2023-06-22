import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RefrigeratedContainer extends Container {
    private double temperature;
    private List<String> products;

    {
        products = new ArrayList<>();
        String[] productList = {"banany", "czekolada", "ryba", "mieso", "lody czekoladowe", "mrozona pizza",
                "ser", "kielbaski", "maslo", "mleko"};

        Random random = new Random();
        int index = random.nextInt(productList.length);
        for (int i = 0; i <= index; i++) {
            products.add(productList[i]);
        }
    }

    public RefrigeratedContainer(double cargoWeight, int height, int length, double maxWeight, double temperature) {
        super(cargoWeight, height, length, maxWeight);
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public List<String> getProducts() {
        return products;
    }
}
