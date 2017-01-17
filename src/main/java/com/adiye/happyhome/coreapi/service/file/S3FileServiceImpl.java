package com.adiye.happyhome.coreapi.service.file;

import java.io.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiye.happyhome.coreapi.exception.EntityNotFoundException;
import com.adiye.happyhome.coreapi.utils.AWSBuilderFactory;
import com.adiye.happyhome.coreapi.utils.FileUtils;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

/**
 * Created by nyeluri on 11/15/16.
 */
@Service("S3FileService")
public class S3FileServiceImpl implements FileService {

    @Value("${aws.s3.bucket.profilepic}")
    private String profilePicBucket;

    private AmazonS3 amazonS3 = AWSBuilderFactory.getInstance().getAmazonS3ClientBuilder().build();

    @Override
    public void uploadProfilePic(String userId, MultipartFile multipartFile){
        amazonS3.putObject(profilePicBucket,userId, FileUtils.MULTIPART_TO_FILE.apply(multipartFile));
    }

    @Override
    public InputStream loadProfilePic(String userId){
        InputStream picStream;
        try {

            S3Object o = amazonS3.getObject(profilePicBucket, userId);
            S3ObjectInputStream s3is = o.getObjectContent();
            picStream = o.getObjectContent();
        }
        catch (AmazonServiceException e) {
            throw new EntityNotFoundException(e.getMessage(),System.currentTimeMillis());
        }
        return picStream;
    }

    @Override
    public void deleteProfilePic(String userId){
        amazonS3.deleteObject(profilePicBucket,userId);
    }

}
