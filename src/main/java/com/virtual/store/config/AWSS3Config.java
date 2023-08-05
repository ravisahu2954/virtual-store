package com.virtual.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class AWSS3Config {

	@Value("${amazon.aws.accessKey}")
	private String accessKey;

	@Value("${amazon.aws.secretKey}")
	private String secretKey;

	@Value("${aws.s3.bucket}")
	private String bucketName;

	
	S3Client s3Client;

	AwsCredentialsProvider awsCredentialsProvider;

	@Bean
	public S3Client sc3Client()
	{
		awsCredentialsProvider = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey,secretKey));
		s3Client = S3Client.builder().credentialsProvider(awsCredentialsProvider).region(Region.US_EAST_2).build();
		return s3Client;
		
	}
   


}
