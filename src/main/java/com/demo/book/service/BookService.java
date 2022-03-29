package com.demo.book.service;

import com.demo.book.model.Book;
import com.demo.book.repository.BookRepository;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository dao;

    public List<Book> findAll(){
        return dao.findAll();
    }

    public Optional<Book> findById(Long id){
        return dao.findById(id);
    }

    public Book addBook(Book book){
        return dao.save(book);
    }

    public Book updateBook(Book book){
        return dao.save(book);
    }

    public void deleteById(Long id){
        dao.deleteById(id);
    }
}
