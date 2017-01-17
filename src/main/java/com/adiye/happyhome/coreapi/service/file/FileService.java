package com.adiye.happyhome.coreapi.service.file;

import java.io.File;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by nyeluri on 11/15/16.
 */
public interface FileService {

    public void uploadProfilePic(String userId, MultipartFile image);

    public InputStream loadProfilePic(String userId);

    public void deleteProfilePic(String userId);

}
