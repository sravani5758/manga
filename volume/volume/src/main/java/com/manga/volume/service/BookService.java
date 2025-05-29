package com.manga.volume.service;

import com.manga.volume.entity.Book;
import com.manga.volume.entity.Manga;
import com.manga.volume.payload.BookDto;
import com.manga.volume.repo.BookRepo;
import com.manga.volume.repo.MangaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private MangaRepo mangaRepo;

    public BookDto createBook(BookDto book) {
        Manga manga = mangaRepo.findById(book.getMangaId())
                .orElseThrow(() -> new RuntimeException("Manga not found"));
        Book book1 = new Book();
        book1.setTitle(book.getTitle());
        book1.setId(book.getId());
        book1.setDescription(book.getDescription());
        book1.setPrice(book.getPrice());
        book1.setManga(manga);
        Book savedBook = bookRepo.save(book1);

        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public List<Book> deleteBook(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id"));
        bookRepo.delete(book);
        return bookRepo.findAll();
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepo.existsById(id)){
            Book book1 = bookRepo.findById(id).get();
            book1.setTitle(book.getTitle());;
            bookRepo.save(book1);
            return book1;
        }else{
            return book;
        }
    }
}
