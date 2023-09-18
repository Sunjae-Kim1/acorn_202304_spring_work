package com.example.boot08.gallery;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryRepository repo;
	
	//파일 저장경로
	@Value("${file.location}")
	private String fileLocation;
	
	@Override
	public void saveGallery(Gallery gallery) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값을 얻어오기
		MultipartFile image = gallery.getImage();
		//원본 파일명 -> 저장할 파일 이름 만들기위해서 사용됨
		String orgFileName = image.getOriginalFilename();
		//파일 크기 -> 다운로드가 없으므로, 여기서는 필요 없다.
		long fileSize = image.getSize();
		
		//저장할 파일명  uuid 문자열 + 원본 파일명 
		String saveFileName=UUID.randomUUID().toString()+orgFileName;
		
		//db 에 저장할 저장할 파일의 상세 경로
		String filePath = fileLocation + File.separator + saveFileName;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(fileLocation);
		if(!upload.exists()) {
			//만약 디렉토리가 존재하지X
			upload.mkdir();//폴더 생성
		}
		
		try {
			//upload 폴더에 파일을 저장한다.
			image.transferTo(new File(filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//DB 에는 saveFileName 만 저장하고 출력할때 자세한 경로를 출력해 준다. 
		gallery.setImagePath(saveFileName);
		
		//GalleryRepository 를 이용해서 DB 에 저장하기
		repo.save(gallery);	
	}

	@Override
	public List<Gallery> getList() {
		// TODO Auto-generated method stub
		return repo.findAllByOrderByNumDesc();
	}

	@Override
	public Page<Gallery> getList(int page) {
		//한페이지에 몇개씩 표시할것인지
		int pageRowCount=8;
		//정렬은 어떻게 할것인지 ( num 이라는 칼럼에 대해서 내림차순 정렬하는 Sort 객체)
		Sort sort=Sort.by(Sort.Direction.DESC, "num");
		/*
		 *  .of(페이지 인덱스, pageRowCount, 정렬객체 )
		 *  
		 *  PageRequest 객체가 리턴되는데 PageRequest 는 Pageable 인터페이스를 구현한 객체 이다.
		 */
		Pageable pageable=PageRequest.of(page-1, pageRowCount, sort);
		
		return repo.findAll(pageable);
	}

}