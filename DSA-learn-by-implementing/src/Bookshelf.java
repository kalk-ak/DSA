public class Bookshelf {
    public Book shelf[];
    private int nextEmpty = 0;

    public Bookshelf() {
        shelf = new Book[20];
    }

    public Bookshelf(int size) {
        shelf = new Book[size];
    }

    public boolean add(Book newBook) {
        if (nextEmpty > (shelf.length - 1)) return false;
        shelf[nextEmpty] = newBook;
        nextEmpty++;
        return true;

        /*for (int i = 0; i < shelf.length; i++) {
            if (shelf[i] == null) {
                shelf[i] = newBook;
               return true;
            }
        }
        return false;
    }*/   // this is an O(n) algorithm
    }

    public Bookshelf getBooksByAuthor(String author) {
        Bookshelf newShelf = new Bookshelf(shelf.length);
        for (int i = 0; i < nextEmpty; i++) {
            if (shelf[i].getAuthor().equals(author)) {
                newShelf.add(shelf[i]);
            }
        }
        return newShelf;
    }

    public String toString() {
        String myString = "";
        for (int i = 0; i < nextEmpty; i++) {
            myString += shelf[i] + "\n";
        }
        return myString;
    }
    public void sort(char sortBy) {
        Book temp;
        for (int j = 0; j < nextEmpty; j++) {
            for (int i = 1; i < nextEmpty - j; i++) {
                if (shelf[i].compareTo(shelf[i - 1], sortBy) < 0) {
                    temp = shelf[i];
                    shelf[i] = shelf[i - 1];
                    shelf[i - 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
      /*  Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
        System.out.println(goodbooks);
        bs.sort('a');
        System.out.println(bs);*/

        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        System.out.println(bs);
        bs.sort('a');
        System.out.println(bs);
        }






}
