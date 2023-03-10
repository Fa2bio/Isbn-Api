package com.github.fa2bio.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolumeInfoModel {
	private String title;
	private String publishedDate;
	private String description;
	private String language;
	private int pageCount;
	private String isbn_10;
	private String isbn_13;
	private List<String> authors;
}
