package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Mapper 인터페이스를 인식할 수 있도록 설정
@MapperScan(value={"com.example.demo.dao"})
public class InsuranceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceSystemApplication.class, args);
	}
	

	//스프링에 필요한 객체를 생성
	@Bean
	//스프링부트가 실행할 때 DataSoruce객체를 이 메소드에 실행시 주입해서 결과를 만ㄷ늘고, 그 결과를 스프링 내 Bean으로 사용.
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
        
    }
}
