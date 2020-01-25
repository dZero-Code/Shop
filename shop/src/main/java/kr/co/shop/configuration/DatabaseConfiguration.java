package kr.co.shop.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")	// application.properties를 사용
@EnableTransactionManagement							// 트랜잭션을 활성화
public class DatabaseConfiguration {
	
	/* MyBatis 설정 */
	@Autowired
	private ApplicationContext applicationContext;
	
	/*
		@ConfigurationProperties(prefix = "spring.datasource.hikari")
		- prefix가 spring.datasource.hikari로 설정하여 spring.datasource.hikari로 
		시작하는 설정을 이용해 히카리CP의 설정파일을 생성
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{
		// 히카리 CP의 설정파일을 사용해 DB와 연결하는 DataSource 생성
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	
	/* MyBatis의 mapUnderscoreToCamelCase 설정값을 적용 */
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		return new org.apache.ibatis.session.Configuration();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		// SqlSessionFactory를 생성하기 위해 SqlSessionFactoryBean을 사용
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); 
		sqlSessionFactoryBean.setDataSource(dataSource);		// DataSource 설정
		
		/*
			Mabatis의 Mapper 파일의 위치를 설정
			- classpath : resources 파일을 의미
			- /mapper/별별/ : mapper 폴더 밑의 모든 폴더를 의미
			- /*-sql.xml : sql로 끝나는 xml가 확장자인 모든 파일 
		 */
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*-sql.xml"));
		sqlSessionFactoryBean.setConfiguration(mybatisConfig());
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception{
		return new DataSourceTransactionManager(dataSource());
	}
}