public class Book {

    String title;
    int pages;

    Book(String title, int pages){
        this.title = title;
        this.pages = pages; 
    }

    String display_info(){
        return this.title + " has " + this.pages + " pages.";
    }
    
}
