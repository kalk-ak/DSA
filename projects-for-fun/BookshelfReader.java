import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
public class BookshelfReader {

    public static Bookshelf readBooksFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            throw new FileNotFoundException("File not found");
        }

        Bookshelf newShelf = new Bookshelf();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String line[] = s.split(",");

            Book newBook = new Book(line[0], line[1], Double.parseDouble(line[2]));
            newShelf.add(newBook);
        }
        return newShelf;
    }


    public static void writeShelfToFile(Bookshelf b, String fileName) throws FileNotFoundException {
        PrintWriter p;

        try {
            File f = new File(fileName);
            p = new PrintWriter(f);

            p.println(b);
/*            for (int i = 0; i < b.shelf.length; i++) {
                String s = b.shelf[i].getTitle() + ", ";   // adds title
                s += b.shelf[i].getAuthor() + ", ";  // adds author
                s += b.shelf[i].getRating();        // adds Rating

                p.print(s);
            }
          */  p.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bookshelf bookshelf = readBooksFromFile("bookinput.txt");
        System.out.println(bookshelf);
        bookshelf.sort('r');

        writeShelfToFile(bookshelf, "output.txt");
    }

}


