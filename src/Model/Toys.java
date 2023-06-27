package Model;

import java.io.Serializable;

public class Toys implements Serializable {
    private int id;
    private int toyRate;
    private int quantity;
    private String toyName;
    private String toyDescription;

    public Toys(int id, int toyRate, String toyName, String toyDescription, int quantity) {
        this.id = id;
        this.toyRate = toyRate;
        this.toyName = toyName;
        this.toyDescription = toyDescription;
        this.quantity = quantity;
    }

    public Toys(int id, int toyRate, String toyName, int quantity) {
        this.id = id;
        this.toyRate = toyRate;
        this.quantity = quantity;
        this.toyName = toyName;
    }

    public Toys(int id, int toyRate, String toyName) {
        this.id = id;
        this.toyRate = toyRate;
        this.toyName = toyName;
        this.quantity = 1;
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
        sb.append(id +
                ".\tИгрушка: " + toyName +
                "\n\tОписание: " + getToyDescription() +
                "\n\tКоличество: " + quantity + "\n");
        return sb.toString();
    }

    public String showToy(){
        StringBuilder sb = new StringBuilder();
        sb.append(toyName + ", " + getToyDescription() + "\n");
        return sb.toString();
    }

    public String adminShowInfo() {
        StringBuilder sb = new StringBuilder();
        if (getToyRate()<=1) {
            sb.append(id +
                    ".\tИгрушка: " + toyName +
                    "\n\tОписание: " + getToyDescription() +
                    "\n\tКоличество: " + quantity +
                    "\n\tВероятность выигрыша: низкая\n");
            return sb.toString();
        } else if (getToyRate()>1 && getToyRate()<=4){
            sb.append(id +
                    ".\tИгрушка: " + toyName +
                    "\n\tОписание: " + getToyDescription() +
                    "\n\tКоличество: " + quantity +
                    "\n\tВероятность выигрыша: средняя\n");
            return sb.toString();
        } else {
            sb.append(id +
                    ".\tИгрушка: " + toyName +
                    "\n\tОписание: " + getToyDescription() +
                    "\n\tКоличество: " + quantity +
                    "\n\tВероятность выигрыша: высокая\n");
            return sb.toString();
        }
    }

    public void setToyRate(int toyRate) {
        this.toyRate = toyRate;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public void setToyDescription(String toyDescription) {
        this.toyDescription = toyDescription;
    }
    public void setToyQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setQuantity(){
        this.quantity--;
    }
    public int getQuantity(){
        return quantity;
    }
}
