package br.com.jadson.migrations.exercicio2;

import java.util.ArrayList;

public class RunMiragrations {

    private ArrayList<Migration> migrations;

    public void start() {
        for (int i = 0; i < migrations.size(); i++) {
            migrations.get(i).run();
        }
    }

    public ArrayList<Migration> getMigrations() {
        return migrations;
    }

    public void setMigrations(ArrayList<Migration> migrations) {
        this.migrations = migrations;
    }

    public RunMiragrations() {
    }

    public static void main(String[] args) {
        RunMiragrations miragrations = new RunMiragrations();
        ArrayList<Migration> listMigrations = new ArrayList<Migration>();

        listMigrations.add(new Vacina());
        listMigrations.add(new Pessoa());
        listMigrations.add(new Notas());

        miragrations.setMigrations(listMigrations);
        miragrations.start();

    }

}