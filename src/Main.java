interface Explosible {
    void explode();
}

class OverfillException extends Exception {
    public OverfillException(String message) {
        super(message);
    }
}


public class Main {
    public static void main(String[] args) {
        ContainerShip containerShip1 = ContainerShip.createContainerShip(40.0);

        LiquidContainer liquidContainer = new LiquidContainer(500, 10, 10, 700, false);
        GasContainer gasContainer = new GasContainer(1000, 8, 8, 2000, 2.5);
        RefrigeratedContainer refrigeratedContainer = new RefrigeratedContainer(800, 12, 12, 1200, -5);

        containerShip1.addContainer(liquidContainer);
        containerShip1.addContainer(gasContainer);
        containerShip1.addContainer(refrigeratedContainer);


        ContainerShip containerShip2 = ContainerShip.createContainerShip(50.0);

        System.out.println();
        System.out.println("Aktualna ilosc kontenerow na statku 1: " + containerShip1.getContainers().size());
        System.out.println("Aktualna ilosc kontenerow na statku 2: " + containerShip2.getContainers().size());

        System.out.println();
        ContainerShip.transferContainers(containerShip1, containerShip2, containerShip1.getContainers());

        System.out.println();
        System.out.println("Aktualna ilosc kontenerow na statku 1 po transferze: " + containerShip1.getContainers().size());
        System.out.println("Aktualna ilosc kontenerow na statku 2 po transferze: " + containerShip2.getContainers().size());

        containerShip2.getContainers().clear();
        System.out.println();
        System.out.println("Usunieto wszystkie kontenery z drugiego statku.");
    }
}



