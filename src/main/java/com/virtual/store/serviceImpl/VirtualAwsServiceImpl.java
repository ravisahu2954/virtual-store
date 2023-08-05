package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualAwsService;
import com.virtual.store.util.APIResponseDTO;
import com.virtual.store.util.AwsData;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

@Service
@RequiredArgsConstructor
public class VirtualAwsServiceImpl implements VirtualAwsService {

	private final S3Client s3Client;

	private final AwsData awsData;

	public APIResponseDTO getProductDetailsFromAwsByProductId(String bucketName, String folderName) {
		String folderPath = "Training" + "/" + folderName;

		ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder().bucket(bucketName)
				.prefix(folderPath + "/") // Specify the folder name as the prefix
				.build();
		ListObjectsV2Response listObjectsResponse = s3Client.listObjectsV2(listObjectsRequest);

		String htmlFilePaths = "";
		List<String> imageUrl = new ArrayList<>();
		List<String> videoUrl = new ArrayList<>();
		String awsUrl = "https://virtual-store-dev1.s3.us-east-2.amazonaws.com/";
		for (S3Object s3Object : listObjectsResponse.contents()) {
			String objectKey = s3Object.key();
			if (objectKey.toLowerCase().endsWith(".html")) {
				htmlFilePaths += awsUrl + objectKey;
			} else if (objectKey.toLowerCase().endsWith(".jpeg")) {
				imageUrl.add(awsUrl + objectKey);
			} else if(objectKey.toLowerCase().endsWith(".mp4"))
				videoUrl.add(awsUrl + objectKey);

		}
		String encodedUrl = Base64.getUrlEncoder().encodeToString(htmlFilePaths.getBytes());
		awsData.setEncodedUrl(encodedUrl);
		awsData.setImageUrl(imageUrl);
		awsData.setVideoUrl(videoUrl);
		return APIResponseDTO.builder().data(awsData).statusCode(HttpStatus.OK.value()).success(true)
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

}
