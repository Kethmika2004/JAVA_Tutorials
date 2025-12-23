public class Library {

    String name;
    int year;
    Book[] books;

    public Library(String name, int year, Book[] books){
        this.name = name;
        this.year = year;
        this.books = books;
    }

    void display_info(){
        System.out.println("Library Name: " + name);
        System.out.println("Established Year: " + year);
        System.out.println("Books in the Library:");
        for(Book book : books){
            System.out.println("- " + book.title + " (" + book.pages + " pages)");
        }
    }
    
}
