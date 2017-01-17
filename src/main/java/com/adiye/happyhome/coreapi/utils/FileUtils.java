package com.adiye.happyhome.coreapi.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Function;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nyeluri on 11/15/16.
 */
public class FileUtils {

    public static Function<MultipartFile,File> MULTIPART_TO_FILE =
        multipartFile -> {
            File file = new File(multipartFile.getOriginalFilename());
            try{
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(multipartFile.getBytes());
                fos.close();
            }
            catch(IOException e){
                file = null;
            }
            return file;
        };

}
