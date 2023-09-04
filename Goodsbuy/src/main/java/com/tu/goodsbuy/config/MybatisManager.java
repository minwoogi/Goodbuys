package com.tu.goodsbuy.config;


import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MybatisManager {

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/goodsbuy?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "1234";
    private static final SqlSessionFactory sqlSessionFactory;

    static {
        Configuration configuration = new Configuration();

        configuration.setCacheEnabled(false);
        configuration.setUseGeneratedKeys(true);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);

        // environment 등록
        Environment env = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                // 데이터 소스 생성
                new PooledDataSource(driverName, url, username, password)
        );
        configuration.setEnvironment(env);

        // 매퍼 인터페이스 등록
        configuration.addMappers("com.tu.goodsbuy.repo");

        // sql-session-factory 생성
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public static <T> T getMapper(Class<T> clazz) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession.getMapper(clazz);
    }
}
