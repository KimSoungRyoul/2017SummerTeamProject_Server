package org.arachne.util;

import org.springframework.web.multipart.MultipartFile;

public interface MultiPartFileUtil {

	String upload(MultipartFile file,String userEmail);
	
	void delete(String fileName);
	
	
	
}
