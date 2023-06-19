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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")
@Ignore
public class test {
	@Autowired
	ApplicationContext context;
	
	JdbcTemplate jdbc;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void test0() {
		System.out.println(jdbc.query("select * from test", ((rs,index)->rs.getInt(1)) ) );
		
	}
}
