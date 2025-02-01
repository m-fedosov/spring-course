package dev.fedosov.services;

import dev.fedosov.models.Book;
import dev.fedosov.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Book> findByReservedBy(int reservedBy) {
        return booksRepository.findByReservedBy(reservedBy);
    }

    public void save(Book book) {
        booksRepository.save(book);
    }

    public void update(Book book, int id) {
        book.setId(id);
        booksRepository.save(book);
    }

    public void delete(int id) {
        booksRepository.deleteById(id);
    }
}
