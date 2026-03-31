package fr.ensai.mediaplayer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PlaylistTest{
    @Test
    void testaddMedia(){
        Podcast flonflon=new Podcast("Flonflon Music Friday","Flonflon","music",238,25,"Et bienvenue dans mon podcast, c'est Flonflon le GOAT");
        Playlist pl=new Playlist("La playlist du chef");
        pl.addMedia(flonflon);
        assertEquals(pl.get_mediaList().size(), 1);
    }

}