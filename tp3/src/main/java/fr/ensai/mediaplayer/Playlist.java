package fr.ensai.mediaplayer;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Media> mediaList;
    private int totalDuration;
    /**
     * Constructs a new Playlist object.
     *
     * @param name    The title of the media.
     * @param mediaList The duration of the media in seconds.
     * @param totalDuration     The year the media was released.
     */
    public Playlist(String name){
        this.name=name;
        this.mediaList=new ArrayList<>();
        this.totalDuration=0;
    }
    public void addMedia(Media m){
        this.mediaList.add(m);
        this.totalDuration+=m.getDuration();
    }
    public boolean removeMedia(Media m){
        boolean success=this.mediaList.remove(m);
        if (success){
        this.totalDuration+=m.getDuration();
        }
        return success;
    }

    public void removeMedia{int i}{
        this.mediaList.remove(i);
    }

    public void removeMedia{int i}{
        this.mediaList.remove(i);
    }
    public List<Media> getmediaList(){
        return this.mediaList;
    }

}
