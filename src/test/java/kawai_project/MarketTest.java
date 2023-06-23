package kawai_project;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.MarketDao;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketDto;
import com.kawai.service.MarketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/*-context.xml")
public class MarketTest {
	@Autowired
	MarketDao dao;
	
	@Autowired
	MarketService service;
	


	
	// Update
	@Test @Ignore
	public void test0() {
		MarketDto dto = new MarketDto();
		dto.setmTitle("3");
		dto.setmContent("내용");
		dto.setMarket_id(1);
		System.out.println(dao.marketUpdate(dto));
	}
	// Delete
	@Test @Ignore
	public void test1() {
	    MarketDto dto = new MarketDto();
	    dto.setMarket_id(1);
	    int result = dao.marketDelete(dto.getMarket_id());
	    System.out.println(result);
	}

	// Insert
	@Test //@Ignore
	public void test2() {
	MarketDto dto = new MarketDto();
	dto.setMarket_id(2);
	dto.setmTitle("제목");
	dto.setmContent("내용");
	dto.setmIp("111,111,111"); 
	dto.setmPrice(3000);
	CommDtoBookinfo info = new CommDtoBookinfo();
	info.setBookinfo_id(1);
	dto.setBookInfo(info);
	dto.setUser_id("admin");
	System.out.println(dao.marketInsert(dto));
	}

	// List
	@Test @Ignore
	public void test3() {
	    List<MarketDto> marketList = dao.marketList();
	    for (MarketDto dto : marketList) {
	        System.out.println(dto);
	    }
	}
}
