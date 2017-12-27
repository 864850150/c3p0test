package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils { 
    
    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");
    //从连接池中取用一个连接
    public static Connection getConnection() throws Exception{
        try {
            return dataSource.getConnection(); 
        } catch (Exception e) {
        	e.printStackTrace();
            /*logger.error("Exception in C3p0Utils!", e); */ 
           throw new Exception("数据库连接出错!", e);          
        }
    }    
    //释放连接回连接池
     public static void close(Connection conn,PreparedStatement pst,ResultSet rs) throws Exception{  
            if(rs!=null){  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    //logger.error("Exception in C3p0Utils!", e);
                    throw new Exception("数据库连接关闭出错!", e);            
                }  
            }  
            if(pst!=null){  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    //logger.error("Exception in C3p0Utils!", e);
                    throw new Exception("数据库连接关闭出错!", e);    
                }  
            }  
      
            if(conn!=null){  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    //logger.error("Exception in C3p0Utils!", e);
                    throw new Exception("数据库连接关闭出错!", e);    
                }  
            }  
        }  
}