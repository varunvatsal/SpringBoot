package com.api.book.bootRestApi.controller;


import com.api.book.bootRestApi.helper.FileUploadHelper;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam(required = false, value="image") MultipartFile image) {

//        System.out.println(image.getOriginalFilename());
//        System.out.println(image.getSize());
//        System.out.println(image.getContentType());
//        System.out.println(image.getName());//return the values of key passed in postman

        try {

            if(image==null || image.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("file is empty");
            }
            if(!image.getContentType().equals("image/jpeg")){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("image is not jpeg");
            }
            if (fileUploadHelper.fileUpload(image)) {
            //file upload code...
//                return ResponseEntity.status(HttpStatus.OK).body("file uploaded successfully");
                return ResponseEntity.status(HttpStatus.OK).body(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(image.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

    }
}
