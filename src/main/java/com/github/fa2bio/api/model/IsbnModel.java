package com.github.fa2bio.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsbnModel {
	private List<BookModel> items;
}
