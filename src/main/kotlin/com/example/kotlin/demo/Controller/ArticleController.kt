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


    //return a mutable list of articles
    /**
     * The @GetMapping("/articles") annotation specifies that this function will handle GET requests with the /articles suffix.
     * The function returns a mutable list of articles by calling
     * the findAll() method on the articleRepository.
     * */
    @GetMapping("/articles")
    fun getArticles(): MutableList<Article> = articleRepository.findAll()


    /**
     * This block of code defines a function called createNewArticle().
     * The @PostMapping("/articles") annotation specifies that this function will handle POST requests with the /articles suffix.
     * The function takes an instance of an article as input and saves it to the database by calling the save() method on the articleRepository.
     * */
    @PostMapping("/articles")
    fun createNewArticle(article: Article) : Article = articleRepository.save(article)


    /**
     * This block of code defines a function called getArticleById().
     * The @GetMapping("/articles/{id}") annotation specifies that this function will handle GET requests with the /articles/{id} suffix.
     * The function takes an ID as input and returns an instance of an article by calling the findById() method on the articleRepository.
     * */
    @GetMapping("/articles/{id}")
    fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map {
          article ->  ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }


    /**
     * This block of code defines a function called updateArticleById().
     * The @PutMapping("/articles/{id}") annotation specifies that this function will handle PUT requests with the /articles/{id} suffix.
     * The function takes an ID and an instance of an article as input and updates it in the database by calling the save() method on the articleRepository.
     * */
    @PutMapping("/articles/{id}")
    fun updateArticleById(@PathVariable(value = "id") articleId: Long, @Valid @RequestBody newArticle: Article) : ResponseEntity<Article>{
        return articleRepository.findById(articleId).map { existingArticle ->
            val updatedArticle: Article = existingArticle
                .copy(title = newArticle.title, content = newArticle.content)
            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }


    /**
     * This block of code defines a function called deleteArticleById().
     * The @DeleteMapping("/articles{id}") annotation specifies that this function will handle DELETE requests with the /articles/{id} suffix.
     * The function takes an ID as input and deletes it from the database by calling the delete() method on the articleRepository.
     * */
    @DeleteMapping("/articles{id}")
    fun deleteArticleById(@PathVariable(value = "id") articleId: Long) : ResponseEntity<Void>{
        return articleRepository.findById(articleId).map { article  ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())


    }







}