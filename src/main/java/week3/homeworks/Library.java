package week3.homeworks;

public class Library {




    public static void main(String[] args) throws Exception {
        Novels.novels[0] = new Novels("Anna Karenina", "Leo Tolstoy", "Drama", 435);
        Novels.novels[1] = new Novels("Madame Bovary", "Gustavo Flaubert","Drama", 365);
        Novels.novels[2] = new Novels("War and Peace", "Leo Tolstoy","History", 534);
        Novels.novels[3] = new Novels("The Great Gatsby", "F. Scott Fitzgerald","Tragedy", 429);
        Novels.novels[4] = new Novels("Lolita", "Vladimir Nabokov", "Erotic", 298);
        Novels.novels[5] = new Novels("Middlemarch", "George Eliot", "History", 565);
        Novels.novels[6] = new Novels("The Adventures of Huckleberry Finn", "Mark Twain", "Adventure", 398);
        Novels.novels[7] = new Novels("The Stories of Anton Chekhov", "Anton Chekhov", "Science-Fiction", 453);
        Novels.novels[8] = new Novels("In Search of Lost Time ", "Marcel Proust", "Drama", 523);
        Novels.novels[9] = new Novels("Hamlet", "William Shakespeare", "History", 312);

        ArtAlbums.artAlbums[0] = new ArtAlbums("Best paints!", "John Doe", 37, "Good");
        ArtAlbums.artAlbums[1] = new ArtAlbums("Random Pictures", "Jack London", 78, "Best");
        ArtAlbums.artAlbums[2] = new ArtAlbums("Random Pictures", "Ion Popescu", 95, "Very good");
        ArtAlbums.artAlbums[3] = new ArtAlbums("Amazing Pictures", "Marius Popa", 32, "Worst");
        ArtAlbums.artAlbums[4] = new ArtAlbums("Beautiful Pictures", "John Spark", 154, "Bad");



       Novels novel = new Novels();
       ArtAlbums album = new ArtAlbums();


//       String book = "insertname"; //change the name of the variable book with the book you want to remove
//       novel.removeBook(book);
//       album.removeBook(book);
//
//
//       novel.sortByName();  //novels will be sorted by the name of the book
//       novel.sortByAuthor(); //novels will be sorted by the name of the author
//
//       album.sortByName();   //albums will be sorted by the name of the book
//       album.sortByAuthor();  //albumswill be sorted by the name of the author
//
//        novel.printAllBooks();
//        System.out.println();
//        album.printAllBooks();











    }
}
