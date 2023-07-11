package com.kawai.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kawai.dao.BookImgDao;
import com.kawai.dto.BookImgVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookImgServiceImpl implements BookImgService{
	@Autowired BookImgDao dao;
	
	@Override
	public List<BookImgVO> imglist() {
		return dao.imglist();
	}

	@Override
	public String imginsert(MultipartFile file, HttpServletRequest request , BookImgVO vo) {
		
		String saved="";
		saved = fileUpload(file, request); //파일업로드 처리
		vo.setImg_file_name(saved);
		
		try {
			 // 현재 시간 설정
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = now.format(formatter);
	        vo.setImg_reg_date(formattedDateTime);
		
		}catch(Exception e) { e.printStackTrace(); }
		
		if (dao.imginsert(vo) > 0) {
			return saved;
		}
		return "no.jpg";
	}
	
	@Transactional
	@Override
	public int imgupdate(MultipartFile file, HttpServletRequest request, BookImgVO vo) {
		// 이전파일 가져오기
		vo.setImg_file_name(dao.imgread(vo).getImg_file_name());
		
		//현재파일의 이름이 0이아니라면.
		String saved="";
		if(file.getOriginalFilename().length() !=0 ) {
			saved=fileUpload(file, request);
			vo.setImg_file_name(saved);
		}
		return dao.imgupdate(vo);
	}

	@Override public int imgdelete(int no) { return dao.imgdelete(no); }
	@Override public BookImgVO imgread(BookImgVO vo) { return dao.imgread(vo); }

	@Override public List<BookImgVO> imgreadAll() { return dao.imgreadAll(); }
	
	//파일 업로드처리
		private String fileUpload(MultipartFile file ,HttpServletRequest request) {
			
			log.info("ㅁname : " + file.getOriginalFilename());
			log.info("ㅁsize : " + file.getSize());
			log.info("ㅁContentType : " + file.getContentType());
			
			//#1. 파일 이름 중복안되게 고유값 설정
			UUID uid = UUID.randomUUID();
			String saved = uid.toString() + "_" + file.getOriginalFilename();
			
			//#2. 파일 업로드
//			String uploadPath = "C:\\upload";  
			String rootPath = "C:\\Users\\djaak\\Documents";
			String attachPath = "\\upload";
		//	String uploadPath = rootPath + attachPath;
			String uploadPath = "C:/Users/djaak/Documents/upload";
			log.info("uploadPath : " + uploadPath);	
			
			File target = new File(uploadPath , saved);  //java.io (File)
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제파일처리 - 스프링제공.
				log.info("ㅁ2. upload 성공 : " + saved);
			}catch(Exception e) {
				e.printStackTrace();
				log.info("업로드 실패");
			}
			return saved;
		}
//	@Override
//	public List<BookImgVO> getImgsByBsNo(int bsNo) {
//		return dao.getImgsByBsNo(bsNo);
//	}
//
//	@Override
//	public String getImgFileNameByBsNo(int bsNo) {
//		return dao.getImgFileNameByBsNo(bsNo);
//	}
//
//	@Override
//	public String getImgFileNameByBsNoAndImgNo(int bsNo, int imgNo) {
//		 	Map<String, Integer> params = new HashMap<>();
//	        params.put("bsNo", bsNo);
//	        params.put("imgNo", imgNo);
//		return dao.getImgFileNameByBsNoAndImgNo(bsNo, imgNo);
//	}



	


		
}
