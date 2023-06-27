package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyMachine implements Serializable {
    private List<Toys> toysList;
    private List<Toys> lowRate;
    private List<Toys> mediumRate;
    private List<Toys> highRate;

    public ToyMachine() {
        this.lowRate = new ArrayList<>();
        this.mediumRate = new ArrayList<>();
        this.highRate = new ArrayList<>();
        this.toysList = new ArrayList<>();
    }

    public void addToy(Toys toy){
        toysList.add(toy);
        if (toy.getToyRate() <= 1) lowRate.add(toy);
        else if (toy.getToyRate() > 1 && toy.getToyRate() <= 4) mediumRate.add(toy);
        else highRate.add(toy);
    }

    public String showInfo(){
        StringBuilder sb = new StringBuilder();
        if (toysList.size() > 0){
            for (Toys toy: toysList){
                sb.append(toy.showInfo());
            }
        } else {
            sb.append("К сожалению, игрушки ещё не завезли...");
        }
        return sb.toString();
    }

    public void play(){
        Random rnd = new Random();
        int winRate = rnd.nextInt(1, 11);
        int lowWinRate = 0;
        int mediumWinRate = 0;
        int highWinRate = 0;
        if (check(lowRate)){
            lowWinRate = rnd.nextInt(0, lowRate.size());
        }
        if (check(mediumRate)){
            mediumWinRate = rnd.nextInt(0, mediumRate.size());
        }
        if (check(highRate)){
            highWinRate = rnd.nextInt(0, highRate.size());
        }
        if (winRate <= 1){
            if (check(lowRate)){
                System.out.println(lowRate.get(lowWinRate).showToy());
                if (toysList.get(toysList.indexOf(lowRate.get(lowWinRate))).getQuantity() > 1){
                    toysList.get(toysList.indexOf(lowRate.get(lowWinRate))).setQuantity();
                } else {
                    toysList.remove(lowRate.get(lowWinRate));
                    lowRate.remove(lowWinRate);
                    for (int i = lowWinRate; i < toysList.size(); i++){
                        toysList.get(i).setId(i+1);
                    }
                }
            } else {
                unluck();
            }
        }
        else if (winRate > 1 && winRate <= 4){
            if (check(mediumRate)) {
                System.out.println(mediumRate.get(mediumWinRate).showToy());
                if (toysList.get(toysList.indexOf(mediumRate.get(mediumWinRate))).getQuantity() > 1){
                    toysList.get(toysList.indexOf(mediumRate.get(mediumWinRate))).setQuantity();
                } else {
                    toysList.remove(mediumRate.get(mediumWinRate));
                    mediumRate.remove(mediumWinRate);
                    for (int i = mediumWinRate; i < toysList.size(); i++){
                        toysList.get(i).setId(i+1);
                    }
                }
            } else {
                unluck();
            }
        }
        else {
            if (check(highRate)) {
                System.out.println(highRate.get(highWinRate).showToy());
                if (toysList.get(toysList.indexOf(highRate.get(highWinRate))).getQuantity() > 1) {
                    toysList.get(toysList.indexOf(highRate.get(highWinRate))).setQuantity();
                } else {
                    toysList.remove(highRate.get(highWinRate));
                    highRate.remove(highWinRate);
                    for (int i = highWinRate; i < toysList.size(); i++){
                        toysList.get(i).setId(i+1);
                    }
                }
            } else {
                unluck();
            }
        }
    }

    private void unluck() {
        System.out.println("К сожалению, Вы ничего не выиграли... :(\n" +
                "Попробуйте ещё раз!");
    }

    private boolean check(List<Toys> temp){
        return temp.size() > 0;
    }

    public String adminShowInfo() {
        StringBuilder sb = new StringBuilder();
        if (toysList.size()>0){
            for (Toys toy : toysList) {
                sb.append(toy.adminShowInfo());
            }
        } else {
            sb.append("В автомате нет игрушек...");
        }
        return sb.toString();
    }

    public int toyListGetSize(){
        return toysList.size();
    }

    public void changeName(int index, String name) {
        toysList.get(index-1).setToyName(name);
    }

    public void changeDesc(int index, String desc) {
        toysList.get(index-1).setToyDescription(desc);
    }

    public void changeRate(int index, int rate) {
        toysList.get(index-1).setToyRate(rate);
    }

    public List<Toys> getToysList(){
        return toysList;
    }

    public void delete(int ans) {
        if (toysList.get(ans-1).getToyRate() <= 1){
            lowRate.remove(toysList.get(ans-1));
        } else if (toysList.get(ans-1).getToyRate() > 1 && toysList.get(ans-1).getToyRate() <= 4){
            mediumRate.remove(toysList.get(ans-1));
        } else {
            highRate.remove(toysList.get(ans-1));
        }
        toysList.remove(ans-1);
        for (int i = ans-1; i < toysList.size(); i++){
            toysList.get(i).setId(i+1);
        }
        System.out.println("Игрушка успешно удалена из списка!");
    }

    public boolean checkList() {
        return (toysList.size() > 0);
    }

    public void changeQuantity(int index, int quantity) {
        toysList.get(index-1).setToyQuantity(quantity);
    }
}
