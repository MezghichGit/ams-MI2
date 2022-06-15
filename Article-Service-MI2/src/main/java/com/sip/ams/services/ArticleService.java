package com.sip.ams.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sip.ams.entities.Article;
import com.sip.ams.models.ArticleProvider;
import com.sip.ams.models.Provider;
import com.sip.ams.repositories.ArticleRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	RestTemplate restTemplate;

	
	public Article saveArticle(Article article)
	{
		return articleRepository.save(article);
	}
	
	public Article findArticleByName(String name)
	{
		return articleRepository.findArticleByName(name);
	}
	
	public ArticleProvider getArticleWithProvider(Long articleId) {
		ArticleProvider article_provider = new ArticleProvider();
		log.info("Get article avec son provider succès depuis Article Service");
		Article article = articleRepository.findArticleById(articleId);
		Provider provider = restTemplate.getForObject("http://PROVIDER-SERVICE/providers/"+article.getProviderId(), Provider.class);
		article_provider.setArticle(article);
		article_provider.setProvider(provider);
		return article_provider;
	}
	
	public List<ArticleProvider> getAllArticlesWithProviders()
	{
		List<ArticleProvider> articlesWithProviders = new ArrayList<>();
		List<Article> articles = articleRepository.findAll();
		articles.forEach(
				
				(Article article)->{
					Provider provider = restTemplate.getForObject("http://PROVIDER-SERVICE/providers/"+article.getProviderId(), Provider.class);
					ArticleProvider article_provider = new ArticleProvider();
					article_provider.setArticle(article);
					article_provider.setProvider(provider);
					articlesWithProviders.add(article_provider);
				}
		);
		
		return articlesWithProviders;
		
	}


}
