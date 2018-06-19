package kgc.dao;

import java.sql.*;


//使用PreparedStatement
public class NewsDao2 {
    //查询新闻id，标题
	public void getNewsByTitle(String title) {
        ResultSet rsResultSet=null;
        PreparedStatement pstmt =null;
        Connection connection=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接connection
            String url="jdbc:mysql://localhost:3306/kgcnews";
            connection=DriverManager.getConnection(url, "root", "yu0816hao");
            //sql命令
            String sql="SELECT id,title FROM news_detail where title=?";
            //获得statement
            pstmt =connection.prepareStatement(sql);
            pstmt.setString(1,title);//在SQL语句的第一个问号的位置填充title
            //返回结果集
            rsResultSet= pstmt.executeQuery();
            while (rsResultSet.next()) {
                int id=rsResultSet.getInt(1);
                String newstitle=rsResultSet.getString(2);
                System.out.println(id+"\t"+newstitle);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭
            try {
                rsResultSet.close();
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }








}





















