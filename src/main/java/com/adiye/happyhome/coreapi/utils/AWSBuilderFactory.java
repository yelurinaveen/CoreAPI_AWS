package com.adiye.happyhome.coreapi.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * Created by nyeluri on 11/15/16.
 */
@Service
public class AWSBuilderFactory {

    //To do - Make it a perfect singleton
    private AWSBuilderFactory(){

    }

    @Value("${aws.s3.region}")
    private String s3Region;

    private static AWSBuilderFactory instance = new AWSBuilderFactory();

    /*
    Note : The client builder will use default Credentials chain, which in turn falls on
    1. Dev or Local ENV : Configured AWS profile credentials. A Developer will generally install AWS CLI and configures these credentials
    2. Test/Stage EC2 Instance : IAM Role configured for the instance
     */
    private AmazonS3ClientBuilder amazonS3ClientBuilder = AmazonS3ClientBuilder.standard()
                                                            .withRegion(s3Region);

    public static AWSBuilderFactory getInstance() {
        return instance;
    }

    public AmazonS3ClientBuilder getAmazonS3ClientBuilder() {
        return amazonS3ClientBuilder;
    }
}
