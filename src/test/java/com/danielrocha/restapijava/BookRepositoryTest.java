package com.danielrocha.restapijava;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.danielrocha.restapijava.domain.Book;
import com.danielrocha.restapijava.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void deve_consultar_livros_com_sucesso() {
		int qtd_livros = bookRepository.findAll().size();
		assertEquals(5, qtd_livros);
	}
	
	@Test
	public void deve_consultar_livro_especifico_com_sucesso() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date publishedOn = sdf.parse("2018-01-01 12:10:00");
		Optional<Book> book = bookRepository.findById(1l);
		assertEquals("Dom Casmurro",      book.get().getName());
		assertEquals("Machado de Assis",  book.get().getAuthors());
		assertEquals("ARF247",            book.get().getCode());
		assertEquals("9788533302273",     book.get().getIsbn());
		assertEquals("Objetivo",          book.get().getPublisher());
		assertEquals("30.00",             book.get().getPrice());
		assertEquals(publishedOn,         book.get().getPublishedOn());
	}
	
	@Test
	public void deve_apagar_livro_com_sucesso() {
		Book book = Book.builder().id(2l).build();
		bookRepository.delete(book);
		int qtd_livros = bookRepository.findAll().size();
		assertEquals(4, qtd_livros);
	}
	
	@Test
	public void deve_atualizar_livro_com_sucesso() {
		String name = "TESTEa";
		Book book = Book.builder().id(3l).name(name).build();
		bookRepository.save(book);
		Optional<Book> bookNovo = bookRepository.findById(3l);
		assertEquals(name, bookNovo.get().getName());
	}
	
}
