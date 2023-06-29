package com.ml.image.brew.imagestore

import com.ml.image.brew.imagestore.config.ImageStoreProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.util.*

@SpringBootApplication
@EnableConfigurationProperties(ImageStoreProperties::class)
class ImageStoreApplication

fun main(args: Array<String>) {
	runApplication<ImageStoreApplication>(*args)
}

@RestController
class MessageController {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String) = "Hello, $name!"
}

/*@RestController
class MessageController {
	@GetMapping("/")
	fun index() = listOf(
			Message("1", "Hello!"),
			Message("2", "Bonjour!"),
			Message("3", "Privet!"),
	)
}*/




//data class Message(@Id var id: String?, val text: String)

