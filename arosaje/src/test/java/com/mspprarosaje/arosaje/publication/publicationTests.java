package com.mspprarosaje.arosaje.publication;

import com.mspprarosaje.arosaje.api.PublicationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class publicationTests {

	@Autowired
	PublicationController publicationController;

	@Test
	public void testGetPublications() {
		assertTrue(publicationController.getPublications().getBody() != null);
	}

	@Test
	public void testGetPublicationById() {
		assertTrue(publicationController.getPublicationById(52).getBody() != null);
	}

	@Test
	public void testGetPublicationByIdNotFound() {
		assertTrue(publicationController.getPublicationById(0).getBody() == null);
	}

	@Test
	public void testGetPublicationsByUserId() {
		assertTrue(publicationController.getPublicationsByUserId(1).getBody() != null);
	}

}
