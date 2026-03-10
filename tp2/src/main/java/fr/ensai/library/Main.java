package fr.ensai.library;

public class Main {

    public static void main(String[] args) {
        Library bib= new Library("Bib de Jules");
        
        bib.loadBooksFromCSV("src/main/java/fr/ensai/library/Main.java");
        System.out.println(fellowshipOfTheRing);
    }
}
