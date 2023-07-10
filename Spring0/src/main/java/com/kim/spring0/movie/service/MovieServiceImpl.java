package com.kim.spring0.movie.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kim.spring0.exception.NotDeleteException;
import com.kim.spring0.movie.dao.MovieDao;
import com.kim.spring0.movie.dto.MovieDto;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDao dao;
	
	@Override
	public void getList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=4;
		final int PAGE_DISPLAY_COUNT=5;
	      
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
		
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	      
		MovieDto dto = new MovieDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	      
		List<MovieDto> list = dao.getList(dto);

		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	      
		int totalRow = dao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);
	}

	@Override
	public void getDetail(ModelAndView mView, int num) {
		MovieDto dto = dao.getData(num);
		mView.addObject("dto" , dto);
	}

	@Override
	public void saveImage(MovieDto dto, HttpServletRequest request) {
		MultipartFile image = dto.getImage();
		String orgFileName = image.getOriginalFilename();
		long fileSize = image.getSize();
		String realPath = request.getServletContext().getRealPath("/resources/upload");
		String filePath = realPath + File.separator;
		File upload = new File(filePath);
		if(!upload.exists()) {
			upload.mkdir();
		}
		String saveFileName = System.currentTimeMillis() + orgFileName;
	      
		try {
			image.transferTo(new File(filePath + saveFileName));
			System.out.println();   // 임시 출력
		}catch(Exception e) {
			e.printStackTrace();
		}
		String id = (String)request.getSession().getAttribute("id");
		dto.setWriter(id);
		
		dto.setImagePath("/resources/upload/" + saveFileName);
		dao.insert(dto);
	}

	@Override
	public void delete(int num , HttpServletRequest request) {
		String id = request.getParameter("writer");
		MovieDto dto = dao.getData(num);
		if(!id.equals(dto.getWriter())) {
			throw new NotDeleteException("남의 글 지우지 않기!");
		} 
		dao.delete(num);
	}

	@Override
	public void update(MovieDto dto , HttpServletRequest request) {
		String caption = request.getParameter("caption");
		dto.setCaption(caption);
		dao.update(dto);
	}
}