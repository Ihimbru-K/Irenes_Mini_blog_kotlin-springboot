package com.example.kotlin.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class Article (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    val title : String = "",

    val content : String = ""
)