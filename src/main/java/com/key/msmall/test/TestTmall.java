package com.key.msmall.test;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
public class TestTmall {
  
    public static void main(String args[]){
        //准备分类测试数据：
    	ResultSet resultSet = null;
    	PreparedStatement preparedStatement = null;
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
  
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall?useUnicode=true&characterEncoding=utf8",
                        "root", "950423");
        )
        {
                String sql = "select * from category where id=60";
                preparedStatement = c.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                	System.out.println(resultSet.getString("name"));
                }
           
             
            System.out.println("已经成功创建10条分类测试数据");
  
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	if(resultSet!=null) {
        		try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        	if (preparedStatement != null) {
    			try {
    				preparedStatement.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
 
        }
  
    }
  
}