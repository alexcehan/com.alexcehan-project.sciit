package week3.homeworks;

public class Novels extends Book{
    static Novels[] novels = new Novels[10];
    String type;

    public Novels (String name, String author, String type, int pages) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.pages = pages;
    }

    public Novels() {

    }

    @Override
    public void sortByName() {
        Novels[] tempArray = novels;
        Novels tempNovel = new Novels();

        for (int i = 0; i < tempArray.length -1; i++) {
            for (int j = i; j < tempArray.length; j++) {
                if(tempArray[i].name.compareTo(tempArray[j].name) > 0) {
                    tempNovel = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = tempNovel;
                }
            }
        }

        novels = tempArray;
    }

    @Override
    public void sortByAuthor() {
        Novels[] tempArray = novels;
        Novels tempNovel = new Novels();

        for (int i = 0; i < tempArray.length -1; i++) {
            for (int j = i; j < tempArray.length; j++) {
                if(tempArray[i].author.compareTo(tempArray[j].author) > 0) {
                    tempNovel = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = tempNovel;
                }
            }
        }

        novels = tempArray;
    }

    @Override
    public void removeBook(String book) {
        boolean bookRemoved = false;
        for (int i = 0; i < novels.length; i++) {
            if(book.equals(novels[i].name)) {
                System.out.println(book + " was removed from library!");
                novels[i] = novels[novels.length-1];
                bookRemoved =true;
            }
        }
        if (!bookRemoved) {
            System.out.println("The book wasn't found in the library!");
        }

        Novels[] tempArray = new Novels[novels.length - 1];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = novels[i];
        }
        novels = tempArray;
    }

    @Override
    public void printAllBooks() {
        for (Novels novel : novels) {
            System.out.println(novel.toString());
        }
    }

    @Override
    public String toString() {

        String stringFormat = String.format("%-40s"+" %-25s"+" %-6d"+" %-10s",  name, author,pages, type);
        return  stringFormat;
    }
}
