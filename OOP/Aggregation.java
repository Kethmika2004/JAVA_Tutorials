public class Aggregation {
    public static void main(String[] args){

        //Aggregation =  Represents a "has-a" relationship between objects.
        //               One object contains another object as part of its structure.
        //               but the contained object/s can exist independently.

        Book book1 = new Book("Harry Potter", 500);
        Book book2 = new Book("The Two Towers", 352);
        Book book3 = new Book("The Da Vinci Code", 689);
        Book book4 = new Book("The Alchemist", 197);

        Book[] books = {book1, book2, book3, book4};

        Library library = new Library("City Library", 1985, books);
        library.display_info();
    }
    
}
