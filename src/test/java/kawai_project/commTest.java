package kawai_project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.CommDao;
import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.CommDtoCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/*-context.xml")
public class commTest {
	@Autowired
	CommDao dao;
	@Test
	public void test0() {
		CommDto info = new CommDto();
		info.setCommunity_title("승재형은 왜그럴까?라는 책의 리뷰입니다.");
		info.setCommunity_content("이책은 진짜 승재형이 왜그럴까에대해 잘설명되어있습니다.");
		info.setCommunity_ip("111-222-111");
		info.setUser_id("dlwpdn");
		CommDtoBookinfo info2 = new CommDtoBookinfo();
		info2.setBookinfo_id(1);
		info.setBookinfo(info2);
		CommDtoCategory info3 = new CommDtoCategory();
		info3.setCategory_id(2);
//		info.setBookinfo_id(1);
		
	}
}
