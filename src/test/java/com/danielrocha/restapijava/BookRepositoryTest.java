package com.danielrocha.restapijava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.danielrocha.restapijava.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void deve_encontrar_cinco_livros() {
		
		int qtd_livros = bookRepository.findAll().size();
		assertEquals(5, qtd_livros);
		
	}

}
