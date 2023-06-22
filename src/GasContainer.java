class GasContainer extends Container implements Explosible {
    private double pressureLevel;

    public GasContainer(double cargoWeight, int height, int length, double maxWeight, double pressureLevel) {
        super(cargoWeight, height, length, maxWeight);
        this.pressureLevel = pressureLevel;
    }

    public double getPressureLevel() {
        return pressureLevel;
    }

    @Override
    public void removeCargo() {
        double cargoToKeep = getCargoWeight() * 0.05;
        setCargoWeight(cargoToKeep);
    }

    @Override
    public void loadCargo(double cargoWeight) throws OverfillException {
        if (cargoWeight > getMaxWeight()) {
            explode();
            throw new OverfillException("Przekroczono maksymalna wage kontenera.");
        }

        setCargoWeight(cargoWeight);
    }

    @Override
    public void explode() {
        System.out.println("Gas container with serial number: " + getSerialNumber() + " exploded!");
    }
}