package fr.ensai.mediaplayer;

public class Podcast {
    private String host;
    private String title;
    private String topic;
    private int duration;
    private int year;
    private String subtitles;

    public Podcast(String title, String host, int year, int duration, String topic, String subtitles) {
        this.title = title;
        this.host = host;
        this.year = year;
        this.duration = duration;
        this.topic = topic;
        this.subtitles = subtitles;
    }

    public void play() {
        String word="";
        int n=this.subtitles.length();
        for(int i=0; i<n; i++){
            if (this.subtitles.charAt(i)==' ' || this.subtitles.charAt(i)=='\n'){
                System.out.println(word);
                word=" ";
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Thread was interrupted");
                }
            }
            word= word+ this.subtitles.charAt(i);
        }
        System.out.println(word);
        
        
    }


}
