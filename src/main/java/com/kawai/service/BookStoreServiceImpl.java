package com.kawai.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dao.BookImgDao;
import com.kawai.dao.BookStoreDao;
import com.kawai.dto.BookStoreVO;
import com.kawai.dto.BookTagBoxVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookStoreServiceImpl implements BookStoreService{
	@Autowired BookStoreDao dao;
	@Autowired BookImgDao imgdao;
	@Autowired BookHashTagDao tagdao;
	
	@Override
	public int bookstoreinsert(MultipartFile file, HttpServletRequest request , BookStoreVO vo) { 
		String saved="";
		saved = fileUpload(file, request); //파일업로드 처리
		vo.setBfile(saved);
		
		return dao.bookstoreinsert(vo); // bookstore 테이블에 데이터 삽입
	}
	@Transactional
	@Override
	public BookStoreVO bookstoreread(BookStoreVO vo) { return dao.bookstoreread(vo); }
	@Transactional
	@Override
	public int bookstoreupdate(MultipartFile file, HttpServletRequest request , BookStoreVO vo) { 
		// 이전파일 가져오기
				vo.setBfile(dao.bookstoreread(vo).getBfile());
				//현재파일의 이름이 0이아니라면.
				String saved="";
				if(file.getOriginalFilename().length() !=0 ) {
					saved=fileUpload(file, request);
					vo.setBfile(saved);
				}
				return dao.bookstoreupdate(vo); 
				}
	@Override
	public int bookstoredelete(int no) { return dao.bookstoredelete(no); }
	@Override
	public List<BookStoreVO> bookstorereadAll() { return dao.bookstorereadAll(); }
	@Override
	public Integer findMaxBsNo() {
		Integer maxBsNo = dao.findMaxBsNo();
		return maxBsNo != null ? maxBsNo : 0;
	}
	@Override
	public void addBookTagBox(BookTagBoxVO tagBox) {
		 dao.addBookTagBox(tagBox);
	}
	@Override
	public List<String> getBookStoreTagNames(int no) {
		 return dao.getBookStoreTagNames(no);
	}
	@Override
	public List<BookStoreVO> getBsName(String name) {
		return dao.getBsName(name);
	}
	
	@Override
	public void registerBookStore(BookStoreVO vo) {
		// 최대 bs_no 값을 조회하여 새로운 번호 설정
        int maxBsNo = findMaxBsNo();
        int newBsNo = maxBsNo + 1;
        vo.setBs_no(newBsNo);

        // 서점 등록 메서드 호출
        dao.registerBookStore(vo);
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
//		String uploadPath = "C:\\upload";  
//		String rootPath = "C:\\Users\\djaak\\Documents";
//		String attachPath = "\\upload";
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources\\upload";
		String uploadPath = rootPath + attachPath;
	//	String uploadPath = "C:/Users/djaak/Documents/upload";
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