package org.example.lab1springboot;

import org.example.lab1springboot.book.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService service;
    @Autowired
    private BookService bookService;





    @Test
    void get404WhenBookNotFound() throws Exception {
        when(service.getBookById(999L)).thenThrow(new BookNotFoundException("Not found"));

        mockMvc.perform(get("/books/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void bookShouldReturnListView() throws Exception{

        when(service.getAllBooksPaginated(anyInt(), anyInt(), any())).thenReturn(Page.empty());



        mockMvc.perform(get("/books")
                        .param("page", "0")
                        .param("size", "5")
                        .param("sort", "id"))
                .andExpect(status().isOk())
                .andExpect(view().name("books"))
                .andExpect(model().attributeExists("books"));



    }
    @Test
    void bookShouldReturnUpdateView() throws Exception {

        mockMvc.perform(get("/books/update/1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/books/edit/1"));
    }





}
