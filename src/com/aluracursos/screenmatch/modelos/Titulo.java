package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.exception.ErrorEnConversion;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamietno;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamietno) {
        this.nombre = nombre;
        this.fechaDeLanzamietno = fechaDeLanzamietno;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamietno = Integer.valueOf(miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversion("No pude convertir la duración, porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(
                miTituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamietno() {
        return fechaDeLanzamietno;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamietno(int fechaDeLanzamietno) {
        this.fechaDeLanzamietno = fechaDeLanzamietno;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }

    public void muestrafichaTecnica() {
        System.out.println("El nombre de la película es: "+ nombre);
        System.out.println("Su fecha de lanzamietno es: "+ fechaDeLanzamietno);
        System.out.println("Duración en minutos: "+ getDuracionEnMinutos());
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre='" + nombre + '\'' +
                ", fechaDeLanzamietno=" + fechaDeLanzamietno +
                " , duración= "+ duracionEnMinutos + ")";
    }
}
