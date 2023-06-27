package com.kawai.kawai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.CommDao;
import com.kawai.dao.CommDaoAnswer;
import com.kawai.dao.CommDaoBookinfo;
import com.kawai.dao.CommDaoComment;
import com.kawai.dao.CommDaoCommentLike;
import com.kawai.dao.CommDaoInquiry;
import com.kawai.dao.CommDaoLike;
import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoAnswer;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.CommDtoCategory;
import com.kawai.dto.CommDtoComment;
import com.kawai.dto.CommDtoCommentLike;
import com.kawai.dto.CommDtoCommunityLike;
import com.kawai.dto.CommDtoInquiry;
import com.kawai.dto.CommDtoSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/**/servlet-kawai-context.xml"})
public class commTest {
	@Autowired
	CommDao dao; 
	@Autowired
	CommDaoBookinfo dao2;
	@Autowired
	CommDaoLike like;
	@Autowired
	CommDaoInquiry inquiry;
	@Autowired
	CommDaoAnswer answerdao;
	@Autowired
	CommDaoComment commentdao;
	@Autowired
	CommDaoCommentLike commentlike;
	
	@Test @Ignore
	public void bookinfoInsert() {
		CommDtoBookinfo info = new CommDtoBookinfo();
		info.setBook_title("승재형은 왜그럴까?");
		info.setBook_description("일부로 그러는걸까?");
		info.setBook_author("제우리");
		info.setBook_publisher("그린아카데미");
		info.setBook_image("no.jpg");
		info.setBook_pubdate("2023-01-20");
		System.out.println(dao2.commBookinfoInsert(info));
	}
	
	@Test @Ignore
	public void communityInsert() {
		CommDto info = new CommDto();
		info.setCommunity_title("승재형은 왜그럴까?라는 책의 리뷰입니다.");
		info.setCommunity_content("이책은 진짜 승재형이 왜그럴까에대해 잘설명되어있습니다.");
		info.setCommunity_ip("111-222-111");
		info.setUser_id("user001");
//		info.setCommunity_id(2);
		CommDtoBookinfo info2 = new CommDtoBookinfo();
		info2.setBookinfo_id(1);
		info.setBookinfo(info2);
		CommDtoCategory info3 = new CommDtoCategory();
		info3.setCategory_id(2);
		info.setCommcategory(info3);
		info.setCommunity_hide(1);
		dao.commCommunityInsert(info);
//		dao.commCommunityUpdate(info);
	}
	@Test @Ignore
	public void communityHit() {
		System.out.println(dao.commCommunityHit(2));
	}
	@Test @Ignore
	public void communityRead() {
		System.out.println(dao.commCommunityRead(3));
	}
	@Test //@Ignore
	public void communityAllRead() {
		CommDtoSearch search = new CommDtoSearch();
		search.setCategory_id(0);
		search.setCondition(0);
		search.setDay(0);
		search.setSearchKeyword("");
		search.setSearchType(1);
		search.setCount(0);
		search.setCommunity_hide(1);
		System.out.println(dao.commCommunityAllRead(search));
	}
	@Test @Ignore
	public void communityDelete() {
		System.out.println(dao.commCommunityDelete(2));
	}
	@Test @Ignore
	public void insertlike() {
		CommDtoCommunityLike communityLike = new CommDtoCommunityLike();
		communityLike.setCommunity_id(3);
		communityLike.setUser_id("user001");
		like.communityLikeInsert(communityLike);
	}
	@Test @Ignore
	public void deletelike() {
		CommDtoCommunityLike communityLike = new CommDtoCommunityLike();
		communityLike.setCommunity_id(3);
		communityLike.setUser_id("user001");
		like.communityLikeDelete(communityLike);
	}
	@Test @Ignore
	public void commlikeAllRead() {
		like.communityLikeAllRead("user001");
	}
	@Test @Ignore
	public void commInquiryInsert() {
		CommDtoInquiry dto = new CommDtoInquiry();
		dto.setInquiry_category_id(1);
		dto.setInquiry_title("승재형이 왜그럴까? 라는 책이 이상합니다.");
		dto.setInquiry_content("진짜 왜그럴까요");
		dto.setInquiry_ip("111-111-111");
		dto.setMarket_id(1);
		dto.setUser_id("user001");
//		dto.setInquiry_id(1);
		System.out.println(inquiry.commInquiryInsert(dto));
//		System.out.println(inquiry.commInquiryUpdate(dto));
	}
	@Test @Ignore
	public void commInquiryRead() {
		System.out.println(inquiry.commInquiryRead(1));
	}
	@Test @Ignore
	public void commInquiryAllRead() {
		Map<String,String> inquiry_map = new HashMap<>();
		inquiry_map.put("user_id", "user001");
		inquiry_map.put("inquiry_condition", "1");
		System.out.println(inquiry.commInquiryAllRead(inquiry_map));
	}
	@Test @Ignore
	public void commInquiryDelete() {
		System.out.println(inquiry.commInquiryDelete(1));
	}
	@Test @Ignore
	public void commAnswerInsert() {
		CommDtoAnswer answer = new CommDtoAnswer();
		answer.setAnswer("진짜 이상하지 말입니다??");
		answer.setInquiry_id(2);
		answer.setAnswer_ip("111-111-111");
//		answer.setUser_id("admin");
//		System.out.println(answerdao.commAnswerInsert(answer));
		System.out.println(answerdao.commAnswerUpdate(answer));
	}
	@Test @Ignore
	public void commAnswerRead() {
		System.out.println(answerdao.commAnswerRead(2));
	}
	@Test @Ignore
	public void commAnswerIs() {
		System.out.println(answerdao.commAnswerIs(1));
	}
	@Test @Ignore
	public void commAnswerDelete() {
		System.out.println(answerdao.commAnswerDelete(1));
	}
	@Test @Ignore
	public void commCommentInsert() {
		CommDtoComment comment = new CommDtoComment();
		comment.setComment("추천요1");
		comment.setComment_ip("111-111-111");
		comment.setCommunity_id(3);
		comment.setComment_id(6);
		comment.setUser_id("user001");
//		System.out.println(commentdao.commentInsert(comment));
		System.out.println(commentdao.commCommentInsert(comment));
//		System.out.println(commentdao.commentUpdate(comment));
	}
	@Test @Ignore
	public void commCommentDelete() {
		System.out.println(commentdao.commentDelete(5));
	}
	@Test @Ignore
	public void commCommentAllRead() {
		System.out.println(commentdao.commCommentAllRead(3));
	}
	@Test @Ignore
	public void commCommentLikeInsert() {
		CommDtoCommentLike comment = new CommDtoCommentLike();
		comment.setComment_id(8);
		comment.setUser_id("user001");
		System.out.println(commentlike.commentLikeInsert(comment));
	}
	@Test @Ignore
	public void commCommentLikeDelete() {
		CommDtoCommentLike comment = new CommDtoCommentLike();
		comment.setComment_id(8);
		comment.setUser_id("user001");
		System.out.println(commentlike.commentLikeDelete(comment));

	}
	@Test @Ignore
	public void commCategoryUpdate() {
		List<Integer> community_id = new ArrayList<>();
		community_id.add(4);
		Map<String, Object> map = new HashMap<>();
		map.put("community_id_list", community_id);
		map.put("community_hide", 0);
		System.out.println(dao.commCategoryUpdate(map));
		
	}
	
}
