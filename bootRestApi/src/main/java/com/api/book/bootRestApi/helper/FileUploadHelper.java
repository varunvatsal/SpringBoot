package com.api.book.bootRestApi.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
//    public final String UPLOAD_DIR = "/Users/varunvatsal/Documents/SpringBoot/bootRestApi/src/main/resources/static/image";

    public final String UPLOAD_DIR = new ClassPathResource("static"+File.separator+"image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean fileUpload(MultipartFile file) {
        boolean result = false;

        try{
            //old way
//            InputStream inputStream = file.getInputStream();
//            byte[] data = new byte[inputStream.available()];
//            inputStream.read(data);
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+"/"+file.getOriginalFilename());
//            fileOutputStream.write(data);
//            fileOutputStream.flush();
//            fileOutputStream.close();
            //new way
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            result = true;

        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
