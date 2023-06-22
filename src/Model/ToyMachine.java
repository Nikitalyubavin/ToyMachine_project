package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyMachine {
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
        int lowWinRate = rnd.nextInt(0, lowRate.size());
        int mediumWinRate = rnd.nextInt(0, mediumRate.size());
        int highWinRate = rnd.nextInt(0, highRate.size());
        if (winRate <= 1){
            if (lowRate.size() > 0){
                System.out.println(lowRate.get(lowWinRate).showToy());
            } else {
                unluck();
            }
        }
        else if (winRate > 1 && winRate <= 4){
            if (mediumRate.size() > 0) {
                System.out.println(mediumRate.get(mediumWinRate).showToy());
            } else {
                unluck();
            }
        }
        else {
            if (highRate.size() > 0) {
                System.out.println(highRate.get(highWinRate).showToy());
            } else {
                unluck();
            }
        }
    }

    private void unluck() {
        System.out.println("К сожалению, Вы ничего не выиграли... :(\n" +
                "Попробуйте ещё раз!");
    }
}
