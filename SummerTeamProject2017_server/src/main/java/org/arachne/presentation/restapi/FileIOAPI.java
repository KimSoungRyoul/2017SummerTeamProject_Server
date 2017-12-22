package org.arachne.presentation.restapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.arachne.util.MediaTypeUtils;
import org.arachne.util.MultiPartFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/files")
public class FileIOAPI {

	@Qualifier("profilePhoto")
	private MultiPartFileUtil ppFiltUtil;

	private String defaultFilePath;

	@Autowired
	public FileIOAPI(MultiPartFileUtil ppFiltUtil, String defaultFilePath) {
		super();
		this.ppFiltUtil = ppFiltUtil;
		this.defaultFilePath = defaultFilePath;
	}

	@GetMapping("/profilephoto/{userEmail}")
	public ResponseEntity<byte[]> GETFile(@PathVariable("userEmail") String userEmail) {

		ResponseEntity<byte[]> entity = null;

		userEmail = userEmail.replace('*', '_');

		InputStream in = null;

		StringBuilder fileNameBuilder = new StringBuilder();

		String fileName = fileNameBuilder.append("D:\\personalProject\\SummerTeamProject2017")
				.append(File.separator).append(userEmail)
				.append(File.separator).append("profilePhoto")
				.append(File.separator).append("096b7e99-3d2e-4d9a-90ab-9e69e368f4d6__KimOuBinImage.jpg")
				.toString();
		
		
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaTypeUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(/*uploadPath */ fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""
						+ new String(fileName.getBytes("UTF-8")).replaceAll("\\+", "%20") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return entity;
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> registerMultipartFile() {

		return null;
	}

}
