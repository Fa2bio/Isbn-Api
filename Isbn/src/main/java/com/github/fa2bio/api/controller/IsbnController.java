package com.github.fa2bio.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fa2bio.api.assembler.VolumeInfoAssembler;
import com.github.fa2bio.api.model.VolumeInfoModel;
import com.github.fa2bio.domain.model.VolumeInfo;
import com.github.fa2bio.domain.service.IsbnService;

@RestController
@RequestMapping(path = "/isbn")
public class IsbnController {
	
	@Autowired
	private IsbnService isbnService;
	
	@Autowired
	private VolumeInfoAssembler volumeInfoAssembler;

	@GetMapping(path = "{isbn}")
	public VolumeInfoModel find(@PathVariable String isbn) {
		VolumeInfo volume = isbnService.findIsbnManual(isbn);
		return volumeInfoAssembler.toModel(volume);
	}
}
