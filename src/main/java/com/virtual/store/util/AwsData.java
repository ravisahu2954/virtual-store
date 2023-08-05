package com.virtual.store.util;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AwsData {

	String encodedUrl;
	List<String> imageUrl;
	List<String> videoUrl;
	
}
