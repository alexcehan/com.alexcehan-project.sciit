package week3.homeworks;

public class ArtAlbums extends Book{
    static ArtAlbums[] artAlbums = new ArtAlbums[5];
    String paper;

    public ArtAlbums(String name, String author, int pages, String paper) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.paper = paper;
    }

    public ArtAlbums() {

    }

    @Override
    public void sortByName() {
        ArtAlbums[] tempArray = artAlbums;
        ArtAlbums tempArtAlbum = new ArtAlbums();

        for (int i = 0; i < tempArray.length -1; i++) {
            for (int j = i; j < tempArray.length; j++) {
                if(tempArray[i].name.compareTo(tempArray[j].name) > 0) {
                    tempArtAlbum = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = tempArtAlbum;
                }
            }
        }

        artAlbums = tempArray;
    }

    @Override
    public void sortByAuthor() {
        ArtAlbums[] tempArray = artAlbums;
        ArtAlbums tempArtAlbum = new ArtAlbums();

        for (int i = 0; i < tempArray.length -1; i++) {
            for (int j = i; j < tempArray.length; j++) {
                if(tempArray[i].author.compareTo(tempArray[j].author) > 0) {
                    tempArtAlbum = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = tempArtAlbum;
                }
            }
        }

        artAlbums = tempArray;
    }

    @Override
    public void removeBook(String book) {
        boolean bookRemoved = false;
        for (int i = 0; i < artAlbums.length; i++) {
            if(book.equals(artAlbums[i].name)) {
                System.out.println(book + " was removed from library!");
                artAlbums[i] = artAlbums[artAlbums.length-1];
                bookRemoved =true;
            }
        }
        if (!bookRemoved) {
            System.out.println("The book wasn't found in the library!");
        }

        ArtAlbums[] tempArray = new ArtAlbums[artAlbums.length - 1];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = artAlbums[i];
        }
        artAlbums = tempArray;
    }

    @Override
    public void printAllBooks() {
        for (ArtAlbums album : artAlbums) {
            System.out.println(album.toString());
        }

    }

    @Override
    public String toString() {

        String stringFormat = String.format("%-40s"+" %-25s"+" %-6d"+" %-10s",  name, author,pages, paper);
        return  stringFormat;
    }
}
