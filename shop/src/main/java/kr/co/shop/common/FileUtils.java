package kr.co.shop.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.shop.shop.dto.ProductPhotoDto;

@Component			// FileUtils Class Bean 등록
public class FileUtils {
	public ProductPhotoDto parsePhotoInfo(String productNo, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		ProductPhotoDto productPhoto = new ProductPhotoDto();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String path = "c:/dev/images/"+current.format(format);
		
		File file = new File(path);
		if (! file.exists()) {
			file.mkdirs();
		}
		
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("photo");
		String fileName, fileExtension, contentType;
		
		if(! multipartFile.isEmpty()) {
			contentType = multipartFile.getContentType();
			if(ObjectUtils.isEmpty(contentType)) {
				return null;
			}else {
				if(contentType.contains("image/jpeg")){
					fileExtension = ".jpg";
				}else if(contentType.contains("image/png")) {
					fileExtension = ".png";
				}else if(contentType.contains("image/gif")) {
					fileExtension = ".gif";
				}else {
					return null;
				}
			}
			// 서버에 저장될 파일 이름 생성 (파일 업로드될 시가을 나노초를 이요하여 새로운 파일 이름으로 지정 -> 파일명 중복 방지)
			fileName = Long.toString(System.nanoTime()) + fileExtension;
			
			// 저장할 파일 정보를 ProductPhotoDto에 저장
			productPhoto.setProductNo(productNo);
			productPhoto.setPhotoName(multipartFile.getOriginalFilename());
			productPhoto.setPhotoPath(path + "/" + fileName);
			
			// 업로드된 파일을 새로운 이름으로 변경하여 지정된 경로에 저장
			file = new File(path + "/" + fileName);
			multipartFile.transferTo(file);
		}
		return productPhoto;
	}
}
