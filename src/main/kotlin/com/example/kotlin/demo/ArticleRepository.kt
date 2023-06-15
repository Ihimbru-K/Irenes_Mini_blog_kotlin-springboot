package com.example.kotlin.demo

import com.example.kotlin.demo.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*
This block of code defines an interface called ArticleRepository.
The @Repository annotation indicates that this interface is a repository that can be used to access data from the datasource.
The JpaRepository<Article, Long> specifies that this repository is a JPA repository for
the Article entity and its primary key is of type Long.
This interface inherits all CRUD methods from JpaRepository
*Used to access data from the datasource
 */
@Repository
interface ArticleRepository : JpaRepository<Article, Long>