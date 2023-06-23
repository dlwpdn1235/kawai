package kawai_project;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.MarketProductMapper;
import com.kawai.dto.MarketDto;
import com.kawai.dto.UserDto;
import com.kawai.service.MarketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/*-context.xml")
public class MarketTest {
	@Autowired
	MarketProductMapper dao;
	
	@Autowired
	MarketService service;
	
	@Autowired
	UserDto user;
	
	@Test @Ignore
	public void test0() {
		MarketDto dto = new MarketDto();
		dto.setmTitle("3");
		dto.setmContent("내용");
		dto.setMarket_id(1);
		System.out.println(dao.marketUpdate(dto));
	}
	
	@Test @Ignore
	public void test1() {
	    MarketDto dto = new MarketDto();
	    dto.setMarket_id(1);
	    int result = dao.marketDelete(dto.getMarket_id());
	    System.out.println(result);
	}
	
	@Test
	public void test2() {
	MarketDto dto = new MarketDto();
	dto.setmTitle("제목");
	dto.setmContent("내용");
	dto.setmIp("아피");
	dto.setmPrice(3000);
	dto.setmDate("2023-06-23");
	int result = dao.marketInsert(dto);
	System.out.println(result);
	}
	
	@Test @Ignore
	public void test3() {
	    List<MarketDto> marketList = dao.marketList();
	    for (MarketDto dto : marketList) {
	        System.out.println(dto);
	    }
	}
}
