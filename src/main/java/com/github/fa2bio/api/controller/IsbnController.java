package com.github.fa2bio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fa2bio.api.model.VolumeInfoRepresentationModel;
import com.github.fa2bio.domain.service.IsbnService;

@RestController
@RequestMapping(path = "/isbn")
public class IsbnController {
	
	@Autowired
	private IsbnService isbnService;

	@GetMapping(path = "{isbn}")
	public VolumeInfoRepresentationModel find(@PathVariable String isbn) {
		return isbnService.findIsbnManual(isbn);
	}
}
