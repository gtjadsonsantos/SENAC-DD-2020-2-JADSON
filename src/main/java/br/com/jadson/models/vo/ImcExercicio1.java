package br.com.jadson.models.vo;

public class ImcExercicio1 {
    private double weight;
    private double heigth;

    public ImcExercicio1(){}
    
    public ImcExercicio1(double weight, double heigth) {
        this.weight = weight;
        this.heigth = heigth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }
}