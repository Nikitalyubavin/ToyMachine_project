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
        for (Toys toy: toysList){
            sb.append(toy.showInfo());
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
                toysList.remove(lowRate.get(lowWinRate));
                lowRate.remove(lowWinRate);
            } else {
                unluck();
            }
        }
        else if (winRate > 1 && winRate <= 4){
            if (check(mediumRate)) {
                System.out.println(mediumRate.get(mediumWinRate).showToy());
                toysList.remove(mediumRate.get(mediumWinRate));
                mediumRate.remove(mediumWinRate);
            } else {
                unluck();
            }
        }
        else {
            if (check(highRate)) {
                System.out.println(highRate.get(highWinRate).showToy());
                toysList.remove(highRate.get(highWinRate));
                highRate.remove(highWinRate);
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
        for (Toys toy : toysList) {
            sb.append(toy.adminShowInfo());
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
}
