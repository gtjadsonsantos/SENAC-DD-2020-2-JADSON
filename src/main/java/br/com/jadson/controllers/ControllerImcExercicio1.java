package br.com.jadson.controllers;

import br.com.jadson.models.vo.ImcExercicio1;

public class ControllerImcExercicio1 {
    
    public double calculateImc(ImcExercicio1 imc) {

        double result = imc.getWeight() / (imc.getHeigth() * imc.getHeigth());

        return result;
    }
}