package com.ml.image.brew.imagestore.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding


@ConfigurationProperties(prefix = "imagestore")
data class ImageStoreProperties(
    val bucketName: String
)
