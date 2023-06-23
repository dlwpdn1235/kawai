package kawai_project;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dto.BookHashTagVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")

public class booktest {
	@Autowired ApplicationContext context;
	@Autowired BookHashTagDao dao;
	
	JdbcTemplate jdbc;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	@Test @Ignore
	public void test0() {
		System.out.println(jdbc.query("select * from test", ((rs,index)->rs.getInt(1)) ) );
		
	}
	@Test //@Ignore
	public void test1() {
		BookHashTagVO vo = new BookHashTagVO(); 
		vo.setTag_name("#sally");
		System.out.println( dao.bookinsert(vo) );
		//(1)  readAll
		//for( BookHashTagVO u  : dao.readAll()) { System.out.println(u); }
	}
}
