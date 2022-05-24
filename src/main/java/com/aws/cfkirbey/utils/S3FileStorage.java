package com.aws.cfkirbey.utils;

import java.io.IOException;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorage {
    @Value("${aws.accesKeyId}")
    private String accesKeyId;

    @Value("${aws.secretAccessKey}")
    private String secretAccessKey;

    @Value("${aws.sessionToken}")
    private String sessionToken;

    @Value("${aws.bucket}")
    private String bucket;
    
    public FileStorage(){}

    public String uploadFileToBucket(String ruta, MultipartFile archivo)  throws IOException{
        System.out.println(bucket+"::"+accesKeyId+"::"+secretAccessKey+"::"+sessionToken);
        String bucketLink = "https://" +bucket +".s3.amazonaws.com/";
        BasicSessionCredentials credentials = new BasicSessionCredentials(accesKeyId, secretAccessKey, sessionToken);
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        PutObjectRequest request = new PutObjectRequest(bucket, ruta, archivo.getInputStream(), new ObjectMetadata())
                .withCannedAcl(CannedAccessControlList.PublicRead);
        s3.putObject(request);
        
        return bucketLink +ruta;
    }
}
