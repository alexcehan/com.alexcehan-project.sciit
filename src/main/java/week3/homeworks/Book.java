package week3.homeworks;
/*
clasele Novels si ArtAlbums extind clasa Book
Clasa ArtAlbums a fost tratata ceva mai superficial, iar obiectele create acolo reprezinta mai degraba o serie de cuvinte
random.

Metoda main() se afla in clasa Library si acolo am creat si obiectele.

Am lasat toate metodele create pregatite si in main (dar comentate) pentru a iti fi mai usor sa le rulezi la testare.
*/

public abstract class Book {
    String name;
    String author;
    int pages;



    public abstract void sortByName();

    public abstract void sortByAuthor();


    public abstract void removeBook(String book);

    public abstract void printAllBooks();


}
