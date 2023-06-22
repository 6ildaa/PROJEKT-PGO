import java.util.Random;

public class Container {
    private static final int INDEX_NUMBER = 24737;
    private double cargoWeight;
    private int height;
    private int length;
    private int serialNumber;
    private double maxWeight;


    {
        Random random = new Random();
        serialNumber = random.nextInt(INDEX_NUMBER);
    }

    public Container(double cargoWeight, int height, int length, double maxWeight) {
        this.cargoWeight = cargoWeight;
        this.height = height;
        this.length = length;
        this.maxWeight = maxWeight;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void removeCargo() {
        cargoWeight = 0;
    }

    public void loadCargo(double cargoWeight) throws OverfillException {
        if (cargoWeight > maxWeight) {
            throw new OverfillException("Przekroczono maksymalna wage kontenera.");
        }

        this.cargoWeight = cargoWeight;
    }

    public int getIndexNumber() {
        return INDEX_NUMBER;
    }

}
