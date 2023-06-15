package com.example.kotlin.demo.Controller

import com.example.kotlin.demo.ArticleRepository
import com.example.kotlin.demo.model.Article
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api")
class ArticleController(private val articleRepository: ArticleRepository) {


    //return a list of articles
    @GetMapping("/articles")
    fun getArticles(): MutableList<Article> = articleRepository.findAll()

    @PostMapping("/articles")
    fun createNewArticle(article: Article) : Article = articleRepository.save(article)

    @GetMapping("/articles/{id}")
    fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map {
          article ->  ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/articles/{id}")
    fun updateArticleById(@PathVariable(value = "id") articleId: Long, @Valid @RequestBody newArticle: Article) : ResponseEntity<Article>{
        return articleRepository.findById(articleId).map { existingArticle ->
            val updatedArticle: Article = existingArticle
                .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/articles{id}")
    fun deleteArticleById(@PathVariable(value = "id") articleId: Long) : ResponseEntity<Void>{
        return articleRepository.findById(articleId).map { article  ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())


    }




    if (Serial.available()) {
        char incomingData = Serial.read();
        if (incomingData == '0' ) {
            angle = 360;
        } else {
            angle = '1';
        }
        myservo.write(angle);
    }




}