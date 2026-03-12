package org.example.lab1springboot.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> findByTitle(@Param("title") String title);

    @Modifying
    @Query("UPDATE Book b SET b.title = :newTitle WHERE b.id IN :ids")

    int updateTitles(@Param("ids") List<Long> ids,
                     @Param("newTitle") String newTitle);

    @Modifying
    @Query("UPDATE Book b SET b.title = :newTitle WHERE b.id = :id")
    @Transactional
    int updateTitle(@Param("id") Long id,
                    @Param("newTitle") String newTitle);



}
