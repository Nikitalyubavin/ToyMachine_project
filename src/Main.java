import Model.Service;
import Model.ToyMachine;
import Model.Toys;
import Presenter.Presenter;
import View.Console;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addToy("Мишка", "Мягкая игрушка", 6);
        service.addToy("Жираф", "Мягкая игрушка", 6);
        service.addToy("Заяц", "Мягкая игрушка", 6);
        service.addToy("Волк", "Мягкая игрушка", 6);
        service.addToy("Лошадь", "Мягкая игрушка", 6);
        service.addToy("Корова", "Мягкая игрушка", 6);
        service.addToy("Фрукты и овощи", "Набор", 3);
        service.addToy("Детская посуда", "Набор", 3);
        service.addToy("Автомат", "Игрушка", 3);
        service.addToy("Лего", "Конструктор", 1);

        Presenter presenter = new Presenter(service);
        Console console = new Console(presenter);
        console.title();
        console.startMenu();
    }
}