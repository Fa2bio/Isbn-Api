package com.github.fa2bio.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.fa2bio.api.model.BookModel;
import com.github.fa2bio.api.model.IsbnModel;
import com.github.fa2bio.api.model.VolumeInfoRepresentationModel;
import com.github.fa2bio.domain.exception.IsbnNotFoundException;
import com.github.fa2bio.domain.exception.MalformedIsbnException;
import com.google.gson.Gson;

@Service
public class IsbnService {
		
	public VolumeInfoRepresentationModel findIsbnManual(String isbn) {
		try {				
				URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn);
				URLConnection connection = url.openConnection();
				InputStream stream = connection.getInputStream();
				BufferedReader buffer = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
				StringBuilder jsonIsbn = new StringBuilder();
				
				while((isbn = buffer.readLine())!=null) {
					jsonIsbn.append(isbn);
				}
				
				Gson gson = new Gson();
				IsbnModel isbnFromJson = gson.fromJson(jsonIsbn.toString(), IsbnModel.class);
				
				if(isbnFromJson.getItems()==null) {
					throw new IsbnNotFoundException(String.format("There is no code ISBN book %s", isbn));
				}
									
				return VolumeInfoAssembler(isbnFromJson.getItems());			
			
		} catch (MalformedURLException e ) {			
			throw new MalformedIsbnException("Unable to generate login URL, please check it and try again");
		} catch(IOException e) {
			throw new MalformedIsbnException("Unable to generate login URL, please check it and try again");
		}
	}
	
	private VolumeInfoRepresentationModel VolumeInfoAssembler(List<BookModel> items) {
		VolumeInfoRepresentationModel volume = new VolumeInfoRepresentationModel();
		items.forEach(e ->{
			volume.setTitle(e.getVolumeInfo().getTitle());
			volume.setPageCount(e.getVolumeInfo().getPageCount());
			volume.setLanguage(e.getVolumeInfo().getLanguage());
			volume.setAuthors(e.getVolumeInfo().getAuthors());
			volume.setPublishedDate(e.getVolumeInfo().getPublishedDate());
			volume.setDescription(e.getVolumeInfo().getDescription());
			e.getVolumeInfo().getIndustryIdentifiers().forEach(f->{
				if(f.getType().equalsIgnoreCase("ISBN_10")) {
					volume.setIsbn_10(f.getIdentifier());
				}else {
					volume.setIsbn_13(f.getIdentifier());
				}
			});
		});
		return volume;
	}
}
