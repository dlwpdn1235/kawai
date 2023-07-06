package com.kawai.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public int imginsert(MultipartFile file, HttpServletRequest request , BookImgVO vo) {
		
		String saved="";
		saved = fileUpload(file, request); //파일업로드 처리
		vo.setImg_file_name(saved);
		
		try {
			 // 현재 시간 설정
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = now.format(formatter);
	        vo.setImg_reg_date(formattedDateTime);
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dao.imginsert(vo);
	}

	@Override
	public int imgupdate(BookImgVO vo) {
		return dao.imgupdate(vo);
	}

	@Override
	public int imgdelete(int no) {
		return dao.imgdelete(no);
	}

	@Override
	public BookImgVO imgread(int no) {
		return dao.imgread(no);
	}

	@Override
	public List<BookImgVO> imgreadAll() {
		return dao.imgreadAll();
	}
	
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
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			String attachPath = "resources\\upload";
			String uploadPath = rootPath + attachPath;
			log.info("uploadPath : " + uploadPath);
			
			File target = new File(uploadPath , saved);  //java.io (File)
			try {
				FileCopyUtils.copy(file.getBytes(), target); // 실제파일처리 - 스프링제공.
				log.info("ㅁ2. upload 성공 : " + saved);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return saved;
		}
		
}
