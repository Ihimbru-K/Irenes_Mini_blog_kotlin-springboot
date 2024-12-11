package com.example.kotlin.demo

import com.example.kotlin.demo.model.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/*This interface inherits all CRUD methods from JpaRepository
*Used to access data from the datasource
 */.....................................................................
@Repository
interface ArticleRepository : JpaRepository<Article, Long>
