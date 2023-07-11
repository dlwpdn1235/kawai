package com.kawai.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kawai.dao.CommDaoComment;
import com.kawai.dao.CommDaoCommentLike;
import com.kawai.dto.CommDtoComment;
import com.kawai.dto.CommDtoCommentLike;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class CommServiceCommentImpl implements CommServiceComment{

	@Autowired
	CommDaoComment commentdao;
	@Autowired
	CommDaoCommentLike like;
	
	@Transactional
	@Override
	public List<CommDtoComment> commCommentAllRead(int community_id, String user_id) {
		List<CommDtoComment> comments = commentdao.commCommentAllRead(community_id);
		CommDtoCommentLike likedto = new CommDtoCommentLike();
		System.out.println(community_id);
		likedto.setUser_id(user_id);		
		for(CommDtoComment c : comments) {
			likedto.setComment_id(c.getComment_id());
			c.setLike(like.commentIsLike(likedto));
		}
		return comments;
	}

	@Transactional
	@Override
	public int commentInsert(CommDtoComment commDtoComment, HttpServletRequest request) {
		try {  commDtoComment.setComment_ip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		
		int comment_group=-1, comment_step=-1, comment_indent=-1;  
		
		if(request.getServletPath().equals("/community/commentInsert")) { //1000 2000 3000
			log.info("................. /board/insert");
			try{comment_step=commentdao.commSelectMax(commDtoComment.getCommunity_id());   }   // 최대값
			catch(Exception e) { comment_step=0;}
			comment_group = (int) ((Math.ceil(comment_step/(double)1000))+1);
			                           //999/1000 = 0.999  =>1 + 1=> 2 
			//bstep  = bgroup*1000;   //0 -> 1000  / 1000->2000  / 999(원본글삭제시)
			comment_step  = (int) ((Math.ceil(comment_step/(double)1000))*1000 + 1000);
			//           999/1000 = 0.999=1*1000 = 1000+1000
			comment_indent= 0;
			
		}else {
		    ///////// 답변글 bstep=999  (-1)   bindent=1 (+1) [답변글]
			this.commCommentStepUpdate(commDtoComment);  // 이전글들 1개씩 빼기
			comment_group =commDtoComment.getComment_group();
			comment_step  =commDtoComment.getComment_step()-1;
			comment_indent=commDtoComment.getComment_indent()+1;
		}

		commDtoComment.setComment_group(comment_group);
		commDtoComment.setComment_step(comment_step);
		commDtoComment.setComment_indent(comment_indent);
		commDtoComment.setUser_id((String)request.getSession().getAttribute("account"));
		return commentdao.commentInsert(commDtoComment);
	}

	@Override
	public int commentUpdate(CommDtoComment commDtoComment) {
		try {  commDtoComment.setComment_ip(InetAddress.getLocalHost().getHostAddress()); }
		catch (UnknownHostException e) { e.printStackTrace(); }
		return commentdao.commentUpdate(commDtoComment);
	}

	@Override
	public int commentDelete(CommDtoComment commDtoComment) {
		return commentdao.commentDelete(commDtoComment.getComment_id());
	}

	@Override
	public int commCommentStepUpdate(CommDtoComment commDtoComment) {
		Map<String, Integer> para = new HashMap<>();
		para.put("prev", (int)(Math.ceil(commDtoComment.getComment_step()/(float)1000)*1000-1000) );              //0
		para.put("curr", commDtoComment.getComment_step());  //1000 , 999-1000 
		log.info(".....service para" + para);
		return commentdao.commCommentStepUpdate(para);
	}	


}
