package Model;

public class Toys {
    private int id;
    private int toyRate;
    private String toyName;
    private String toyDescription;

    public Toys(int id, int toyRate, String toyName, String toyDescription) {
        this.id = id;
        this.toyRate = toyRate;
        this.toyName = toyName;
        this.toyDescription = toyDescription;
    }

    public Toys(int id, int toyRate, String toyName) {
        this.id = id;
        this.toyRate = toyRate;
        this.toyName = toyName;
    }

    public int getId() {
        return id;
    }

    public String getToyName() {
        return toyName;
    }

    public String getToyDescription() {
        if (toyDescription == null) return "Описание отсутствует.";
        else return toyDescription;
    }

    public int getToyRate() {
        return toyRate;
    }

    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(id + ".\tИгрушка: " + toyName + "\n\tОписание: " + getToyDescription() + "\n");
        return sb.toString();
    }

    public String showToy(){
        StringBuilder sb = new StringBuilder();
        sb.append(toyName + ", " + getToyDescription() + "\n");
        return sb.toString();
    }
}
