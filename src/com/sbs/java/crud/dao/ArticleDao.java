package com.sbs.java.crud.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.java.crud.dto.Article;

public class ArticleDao {
	public List<Article> articles;
	
	public ArticleDao() {
		articles = new ArrayList<>();
	}
}
