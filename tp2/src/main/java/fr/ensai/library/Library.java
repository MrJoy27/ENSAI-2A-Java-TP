package fr.ensai.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Library {
    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------
    private String name;
    private List<Item> items;
     /**
     * Constructs a new ...
     * @param name parameter1_description
     * @param items parameter2_description
     */
    public Library(String name) {
        this.name=name;
        this.items=new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Item> getItems(){
        return items;
    }
    public void addBook(Item item){
        items.add(item);
    }
    public void displayItems(){
        int n=Items.size();
        if (n==0){
            String chaine="There are no books in the library";
            System.out.println(chaine);
        }
        else{
            String chaine="";
            for (int i=0; i<n;i++){
                chaine +=items.get(i).toString();
            }
            System.out.println(chaine);
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        //System.out.println(String.format("Create %s", author));
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addBook(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }


}
