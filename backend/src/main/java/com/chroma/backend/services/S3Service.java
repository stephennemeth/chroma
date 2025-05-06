package com.chroma.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.AmazonS3;

@Service("s3Service")
public class S3Service {

    @Autowired
    @Qualifier("awsS3Client")
    private AmazonS3 amazonS3;

    @Value("${aws.bucketName}")
    private String bucketName;

    public void uploadFile(String key, String filePath) {
        amazonS3.putObject(bucketName, key, filePath);
    }

    public String getFileUrl(String key) {
        return amazonS3.getUrl(bucketName, key).toString();
    }

    public boolean fileExists(String key) {
        return amazonS3.doesObjectExist(bucketName, key);
    }

    public void deleteFile(String key) {
        amazonS3.deleteObject(bucketName, key);
    }

}
