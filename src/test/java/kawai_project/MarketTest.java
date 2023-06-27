package kawai_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.MarketCartDao;
import com.kawai.dao.MarketDao;
import com.kawai.dao.MarketOrderDao;
import com.kawai.dao.MarketPayDao;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.MarketCart;
import com.kawai.dto.MarketDto;
import com.kawai.dto.MarketOrderDto;
import com.kawai.dto.MarketPageDto;
import com.kawai.dto.MarketPayDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MarketTest {
	@Autowired
	MarketDao dao;
	
	@Autowired
	MarketOrderDao mOrderDao;
	

	@Autowired
	MarketPayDao mPayDao;
	
	@Autowired
	MarketCartDao mCartDao;
	
	// Update
	@Test @Ignore
	public void marketUpdate() {
		MarketDto dto = new MarketDto();
		dto.setMTitle("3");
		dto.setMContent("내용");
		dto.setMarket_id(1);
		System.out.println(dao.marketUpdate(dto));
	}
	// Delete
	@Test @Ignore
	public void marketDelete() {
	    MarketDto dto = new MarketDto();
	    dto.setMarket_id(1);
	    int result = dao.marketDelete(dto.getMarket_id());
	    System.out.println(result);
	}

	// Insert
	@Test @Ignore
	public void marketInsert() {
	MarketDto dto = new MarketDto();
	dto.setMarket_id(2);
	dto.setMTitle("제목");
	dto.setMContent("내용");
	dto.setMIp("111,111,111"); 
	dto.setMPrice(3000);
	CommDtoBookinfo info = new CommDtoBookinfo();
	info.setBookinfo_id(1);
	dto.setBookInfo(info);
	dto.setUser_id("admin");
	System.out.println(dao.marketInsert(dto));
	}

	// List
	@Test @Ignore
	public void marketList() {
		MarketPageDto dto = new MarketPageDto();
		dto.setMarketListCount(0);
		dto.setMarketOption(1);
		dto.setMarketPageCount(0);
		dto.setMarketSearch(0);
		dto.setMarketSerchKeyWord("");
	    List<MarketDto> marketList = dao.marketList(dto);
	    System.out.println(marketList);
	}
	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   market   market   market   market   market   market   market   market   market   market   market   market   //  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	// Insert
	@Test @Ignore
	public void marketOrderInsert() {
		MarketOrderDto dto = new MarketOrderDto();
		dto.setMRecAddress("주소값");
		dto.setMRecContent("내용");
		dto.setMRecDate("날짜");
		dto.setMRecIp("아이피");
		dto.setMRecPrice(2000);
		dto.setUser_id("admin");
		dto.setMarket_id(1);
		System.out.println(mOrderDao.marketOrderInsert(dto));
	}
	// List All
	@Test @Ignore
	public void marketOrderList() {
		System.out.println(mOrderDao.mOrderReadAll());
	}
	
	
	
	
	// Delete
	@Test @Ignore
	public void marketOrderDelete() {
		
		int result = mOrderDao.marketOrderDelete(3);
		System.out.println(result);
	}

	//Update
	@Test @Ignore
	public void marketOrderUpdate() {
		MarketOrderDto dto = new MarketOrderDto();
		dto.setMOrder_id(4);
		dto.setMRecContent("또바뀐거임");
		int result = mOrderDao.marketOrderUpdate(dto);
		System.out.println(result);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//marketOrder   marketOrder   marketOrder   marketOrder   marketOrder   marketOrder   marketOrder   marketOrder  //  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test @Ignore
	public void marketPayInsert() {
		MarketPayDto dto = new MarketPayDto();
		dto.setMPay_id(1);
		List<MarketDto> mdto = new ArrayList<>();
		List<MarketOrderDto> morderdto = new ArrayList<>();
		dto.setMarket_id(1);
		dto.setMPay_id(1);
		dto.setMPayCount(2);
		dto.setMPayDate("2023-06-27");
		dto.setMarket(mdto);
		dto.setMOrder(morderdto);
		dto.setMOrder_id(4);
		dto.setUser_id("admin");
		/*
		 * dto.setMOrder(morderdto); dto.setUser_id("admin");
		 */
		System.out.println(mPayDao.marketPayInsert(dto));
	}
	
	@Test @Ignore
	public void marketPayUpdate() {
		MarketPayDto dto = new MarketPayDto();
		dto.setMPay_id(1);
		dto.setMOrder_id(1);
		dto.setMPayDate("2023-06-27");
		dto.setMPayCount(3);
		System.out.println(mPayDao.marketPayUpdate(dto));
	}
	
	@Test @Ignore
	public void marketPayDelete() {
		MarketPayDto dto = new MarketPayDto();
		int result = mPayDao.marketPayDelete(1);
		System.out.println(result);
	}
	
	
	@Test @Ignore
	public void marketPayList() {
		System.out.println(mPayDao.marketPayList());
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//marketCart   marketCart   marketCart   marketCart   marketCart   marketCart   marketCart   marketCart          //  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void marketCartInsert() {
		MarketCart dto = new MarketCart();
		dto.setMarket_id(1);
		dto.setMCount(3);
		dto.setUser_id("admin");
		System.out.println(mCartDao.marketCartInsert(dto));
	}
	
	@Test @Ignore
	public void marketCartList() {
		
	}
}
