import java.util.ArrayList;
import java.util.List;

class ContainerShip {
    private List<Container> containers;
    private double maxSpeed;
    private static int maxContainerCount;


    static {
        int indexNumber = 24737;

        if (indexNumber % 2 == 0) {
            maxContainerCount = indexNumber / 2;
        } else {
            maxContainerCount = indexNumber / 5;
        }
    }

    public ContainerShip(double maxSpeed) {
        this.containers = new ArrayList<>();
        this.maxSpeed = maxSpeed;
    }

    public List<Container> getContainers() {
        return containers;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxContainerCount() {
        return maxContainerCount;
    }

    public void addContainer(Container container) {
        if (containers.size() >= maxContainerCount) {
            System.out.println("Nie mozna dodac wiecej kontenerow. Osiagnieto maksymalna ilosc kontenerow na statku.");
        } else {
            containers.add(container);
            System.out.println("Dodano kontener o numerze seryjnym: " + container.getSerialNumber());
        }
    }

    public void addContainers(List<Container> newContainers) {
        int availableSpace = maxContainerCount - containers.size();
        int containersToAdd = Math.min(availableSpace, newContainers.size());

        containers.addAll(newContainers.subList(0, containersToAdd));

        if (containersToAdd > 0) {
            System.out.println("Dodano " + containersToAdd + " kontenerow.");
        } else {
            System.out.println("Nie mozna dodac wiecej kontenerow. Osiągnieto maksymalna ilosc kontenerow na statku.");
        }
    }

    public void removeContainer(Container container) {
        if (containers.remove(container)) {
            System.out.println("Usunieto kontener o numerze seryjnym: " + container.getSerialNumber());
        } else {
            System.out.println("Podany kontener nie znajduje sie na statku.");
        }
    }

    public void removeContainers(List<Container> containersToRemove) {
        containers.removeAll(containersToRemove);
        System.out.println("Usunieto " + containersToRemove.size() + " kontenerow.");
    }

    public void replaceContainer(int position, Container newContainer) {
        if (position >= 0 && position < containers.size()) {
            containers.set(position, newContainer);
            System.out.println("Zamieniono kontener na pozycji " + position);
        } else {
            System.out.println("Nieprawidlowa pozycja kontenera.");
        }
    }

    public static void transferContainers(ContainerShip sourceShip, ContainerShip destinationShip, List<Container> containers) {
        if (destinationShip.getContainers().size() + containers.size() > destinationShip.getMaxContainerCount()) {
            System.out.println("Nie mozna przetransferowac kontenerow. Statki kontenerowe docelowy nie maja wystarczającej ilosci miejsca.");
        } else {
            int transferredContainers = containers.size();
            destinationShip.getContainers().addAll(containers);
            sourceShip.getContainers().removeAll(containers);
            System.out.println("Przeniesiono " + transferredContainers + " kontenerow ze statku zrodlowego na statek docelowy.");
        }
    }

    public static ContainerShip createContainerShip(double maxSpeed) {
        ContainerShip containerShip = new ContainerShip(maxSpeed);
        System.out.println("Utworzono nowy statek kontenerowy.");
        return containerShip;
    }
}