package com.ml.image.brew.imagestore.controller

import com.ml.image.brew.imagestore.config.ImageStoreProperties
import com.ml.image.brew.imagestore.service.ImageService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/images")
class ImageStoreController (private val props: ImageStoreProperties,
                            private val imageService: ImageService) {

    //@Autowired
    //private lateinit var userService: UserService

    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun handleFileUpload(
        @RequestPart("files") files: List<MultipartFile>?,
    ): ResponseEntity<String> {
        if (files.isNullOrEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No files found")
        }
        val fileName = files.first().originalFilename
        if(fileName.isNullOrEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file name found")
        }
        val fileSize = files.first().size
        //val fileContent = files.first().bytes.toString(StandardCharsets.UTF_8)
        val fileContent = files.first().bytes
        logger.info("file name: $fileName, size: $fileSize")
        imageService.uploadImage(fileContent, props.bucketName, fileName)


        return ResponseEntity.ok("You sent this file: $fileName")
    }

    /*@PostMapping
    fun uploadImage(@RequestBody imageRequest: ImageRequest): ResponseEntity<String> {
        val user = userService.getUserById(imageRequest.userId)
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found")
        }

        val imageId = imageService.uploadImageToGCS(imageRequest.bucketName, imageRequest.filePath)
        if (imageId == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image")
        }

        val imageMetadata = ImageMetadata(user.id, imageId, LocalDateTime.now())
        val savedMetadata = imageService.saveImageMetadata(imageMetadata)
        if (savedMetadata == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save image metadata")
        }

        return ResponseEntity.ok("Image uploaded successfully")
    }*/



    @GetMapping("/{userId}")
    fun getUserImages(@PathVariable userId: Int): ResponseEntity<List<String>> {
        /*val user = userService.getUserById(userId)
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emptyList())
        }

        val imageMetadataList = imageService.getImageMetadataByUserId(userId)
        val imageResponseList = imageMetadataList.map { SingleImageResponse(it.bucketName, it.filePath) }
        return ResponseEntity.ok(imageResponseList)*/
        return ResponseEntity.ok(emptyList())
    }
    /*
    @GetMapping("/all/{userId}")
    fun getAllUserImages(@PathVariable userId: Int): ResponseEntity<List<SingleImageResponse>> {
        val user = userService.getUserById(userId)
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emptyList())
        }

        val imageMetadataList = imageService.getImageMetadataByUserId(userId)
        val imageResponseList = imageMetadataList.map { SingleImageResponse(it.bucketName, it.filePath) }
        return ResponseEntity.ok(imageResponseList)
    }*/
}
