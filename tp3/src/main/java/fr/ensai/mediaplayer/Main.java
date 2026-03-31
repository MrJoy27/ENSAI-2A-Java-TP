package fr.ensai.mediaplayer;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args){
        Podcast flonflon=new Podcast("Flonflon Music Friday","Flonflon","music",238,25,"Et bienvenue dans mon podcast, c'est Flonflon le GOAT");
        flonflon.play();
        Artist jobim=new Artist("Tom", "Jobim", "Brazil");
        Song aguas=new Song("Aguas de Março", jobim, 1972, 3, "É pau, é pedra, é o fim do caminho E um resto de toco, é um pouco sozinho", jobim, jobim, List.of(Genre.BOSSA_NOVA, Genre.JAZZ));
        aguas.play();
    }
}
