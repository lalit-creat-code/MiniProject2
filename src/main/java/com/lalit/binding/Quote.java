package com.lalit.binding;

import org.springframework.stereotype.Component;

@Component
public class Quote {
	String text;
	String author;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
