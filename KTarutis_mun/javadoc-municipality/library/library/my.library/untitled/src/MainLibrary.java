import com.eisgroup.javaexam.library.Book;
import com.eisgroup.javaexam.library.Library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainLibrary implements Library {

    private List<Book> bookOfLibrary;

    // Constructor initializing the 'owned' list
    public MainLibrary() {
        bookOfLibrary = new ArrayList<>();
    }

    @Override
    public void takeABook(Book book) {
        if (!bookOfLibrary.contains(book)) {
            bookOfLibrary.add(book);
        }
    }

    @Override
    public int getNumberOfBooks() {
        return bookOfLibrary.size();
    }

    @Override
    public Book findByTitle(String title) {
        for (Book bookByTitle: bookOfLibrary) {
            if(bookByTitle.getTitle().equals(title)) {
                return bookByTitle;
            }
        }
        return null;
    }

    @Override
    public Collection<Book> findByAuthor(String author) {
        return bookOfLibrary.stream().filter(b -> b.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public Collection<Book> getBooksSortedByPageCount() {
        return bookOfLibrary.stream().sorted(Comparator.comparing(Book::getPageCount)).collect(Collectors.toList());
    }
}
