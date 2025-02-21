package dev.fedosov.springcourse.Project2Boot.services;

import dev.fedosov.springcourse.Project2Boot.models.Book;
import dev.fedosov.springcourse.Project2Boot.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
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
    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear)
            return booksRepository.findAll(Sort.by("year"));
        return booksRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Book> findAll(int page, int itemsPerPage, boolean sortByYear) {
        if (sortByYear)
            return booksRepository.findAll(PageRequest.of(page, itemsPerPage, Sort.by("year"))).getContent();
        return booksRepository.findAll(PageRequest.of(page, itemsPerPage)).getContent();
    }

    @Transactional(readOnly = true)
    public Book findById(int id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Book> findByReservedBy(int reservedBy) {
        return booksRepository.findByReservedBy(reservedBy);
    }

    @Transactional(readOnly = true)
    public Book findByTitle(String title) {
        return booksRepository.findByTitleLike(title + "%");
    }

    @PreAuthorize("hasAuthority('write')")
    public void save(Book book) {
        booksRepository.save(book);
    }

    @PreAuthorize("hasAuthority('write')")
    public void update(Book book, int id) {
        Book bookToUpdate = booksRepository.findById(id).orElse(book);
        if ((bookToUpdate.getReservedBy() == null && book.getReservedBy() != null)
            || (bookToUpdate.getReservedBy() != null && book.getReservedBy() != null && bookToUpdate.getReservedBy() != book.getReservedBy())
        ) {
            book.setReservedTime(new Timestamp(System.currentTimeMillis()));
        }
        book.setId(id);
        booksRepository.save(book);
    }

    @PreAuthorize("hasAuthority('write')")
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public boolean isOverdue(Book book) {
        return book.getReservedTime().toLocalDateTime().isBefore(LocalDate.now().minusDays(10).atStartOfDay());
    }
}
