package com.ml.image.brew.imagestore.service

import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class ImageService {
    private val storage: Storage = StorageOptions.getDefaultInstance().service

    /*fun uploadImage(imageData: InputStream, bucketName: String, fileName: String, contentType: String) {
        val blobId = BlobId.of(bucketName, fileName)
        val blobInfo = BlobInfo.newBuilder(blobId).setContentType(contentType).build()
        storage.create(blobInfo, imageData)
    }*/

    fun uploadImage(imageData: ByteArray, bucketName: String, fileName: String) {
        val blobId = BlobId.of(bucketName, fileName)
        val blobInfo = BlobInfo.newBuilder(blobId).build()
        storage.create(blobInfo, imageData)
    }

    /*fun getImage(bucketName: String, fileName: String): InputStream? {
        val blobId = BlobId.of(bucketName, fileName)
        val blob = storage.get(blobId)
        return blob?.getContent()
    }*/
}

/* This version has the new apis, combine
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class com.ml.image.brew.imagestore.service.ImageService {

    @Autowired
    private lateinit var imageMetadataRepository: ImageMetadataRepository

    fun uploadImageToGCS(bucketName: String, filePath: String): String? {
        // Logic for uploading image to GCS goes here
        // Return the GCS image ID if successful, or null if failed
        return null
    }

    fun saveImageMetadata(imageMetadata: ImageMetadata): ImageMetadata? {
        return imageMetadataRepository.save(imageMetadata)
    }

    fun getImageMetadataByUserId(userId: Int): List<ImageMetadata> {
        return imageMetadataRepository.findByUserId(userId)
    }

    fun getAllImageMetadata(): List<ImageMetadata> {
        return imageMetadataRepository.findAll()
    }
}

 */