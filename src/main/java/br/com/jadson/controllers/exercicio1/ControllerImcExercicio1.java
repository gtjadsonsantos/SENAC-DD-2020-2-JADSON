package br.com.jadson.controllers.exercicio1;

import br.com.jadson.models.vo.exercicio1.ImcExercicio1;

public class ControllerImcExercicio1 {
    
    public double calculateImc(ImcExercicio1 imc) {

        double result = imc.getWeight() / (imc.getHeigth() * imc.getHeigth());

        return result;
    }
}