
package DataBase;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionDB {
    
    public DriverManagerDataSource connection(){
          DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bd_stock");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin1914");
        return dataSource;
    }  
}
