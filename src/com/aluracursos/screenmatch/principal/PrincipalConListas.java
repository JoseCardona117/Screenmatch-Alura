package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Matrix", 1988);
        otraPelicula.evalua(10);
        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.evalua(10);
        Serie lost = new Serie("Lost", 2000);
        Pelicula otra = new Pelicula("John Wick", 2014);
        otra.evalua(9);
        Serie serie = new Serie("La Casa de Papel", 2017);

        List<Titulo> lista = new ArrayList<>();
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);
        lista.add(otra);
        lista.add(serie);

        for (Titulo item: lista){
            System.out.println("Nombre: "+ item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeartistas = new ArrayList<>();
        listaDeartistas.add("Penelope Cruz");
        listaDeartistas.add("Antonio Banderas");
        listaDeartistas.add("Ricardo Darin");
        System.out.println(listaDeartistas);

        Collections.sort(listaDeartistas);
        System.out.println("Lista de artistas ordenada: "+ listaDeartistas);

        Collections.sort(lista);
        System.out.println("Lista de títulos ordenados: "+lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamietno));
        System.out.println("Lista ordenada por fecha: "+ lista);
    }
}
