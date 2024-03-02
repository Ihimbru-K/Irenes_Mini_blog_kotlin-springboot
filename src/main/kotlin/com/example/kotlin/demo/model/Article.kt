

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank


@Entity
data class Article (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0,

    @get : NotBlank
    val title : String = "",

    @get: NotBlank
    val content : String = ""
)

/**
 * This block of code defines a data class called Article.
 * The @Entity annotation indicates that this class is an entity that can be persisted to a database.
 * The @Id annotation specifies that the id property is the primary key for this entity.
 * The @GeneratedValue annotation specifies that the value for the id property will be generated automatically.
 * The @NotBlank annotation specifies that the title and content properties cannot be blank.
 * */
