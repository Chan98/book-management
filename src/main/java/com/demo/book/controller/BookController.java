package com.demo.book.controller;

import com.demo.book.model.Book;
import com.demo.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    //도서 전체 조회, 넘어오는 값 없이 위 url 그대로 호출 경우
    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
    //특정 도서 조회, 특정 아이디가 넘어오면 위 url 그대로 경우
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable(value = "id") Long id){
        Optional<Book> book = bookService.findById(id);

        if(!book.isPresent()){
            log.error("Id : " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(book.get());
    }

    //도서 등록
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }

    //도서 수정
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Book book){
        if(!bookService.findById(id).isPresent()){
            log.error("Id : " + id + "  is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    //도서 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        if(!bookService.findById(id).isPresent()){
            log.error("Id : " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
