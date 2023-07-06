package com.kawai.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dto.CommDtoSearch;
import com.kawai.service.CommService;
import com.kawai.service.CommServiceCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
								 "file:src/main/webapp/WEB-INF/spring/**/servlet-kawai-context.xml"})
public class CommServiceTest {
	@Autowired CommService commservice;
	@Autowired CommServiceCategory category;
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
		System.out.println(commservice.commCommunityAllRead(search));
		System.out.println(category.commCategoryList());
	} 
}
