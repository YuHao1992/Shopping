package kgc.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import kgc.dao.BaseDao;
import kgc.dao.NewsDao;
import kgc.pojo.News;
import kgc.pojo.NewsCategory;


//使用JDBC实现课工场新闻数据的增删改查
public class NewsDaoImpl extends BaseDao implements NewsDao {
	//获取新闻总数据
		public int getTotalCount(){
			int total=0;
			String sql="select count(1) from news_detail";
			Object[] params={};
			ResultSet rs=this.executeSQL(sql, params);
			try {
				while(rs.next()){
					total=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return total;
		}
		
		//分页获取新闻数据 pageno是当前页码，pagesize是页面容量
		public List<News> getPageNewsList(int pageNo,int pageSize){
			List<News> list=new ArrayList<News>();
			String sql="select id,title,author,createdate from news_detail where 1=1 ORDER BY CREATEDATE DESC LIMIT ?,?";
			Object[] params={(pageNo-1)*pageSize,pageSize};
			ResultSet rs=this.executeSQL(sql, params); 		
			try {
				while(rs.next()){
					 int id=rs.getInt("id");
					 String title=rs.getString("title");	
					 String author=rs.getString("author");
					 Timestamp createdate=rs.getTimestamp("createdate");
					 
					 News news=new News();
					 news.setId(id);
					 news.setTitle(title);
					 news.setAuthor(author);
					 news.setCreateDate(createdate);
					 
					 list.add(news);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	
    public News getNewsById(int id){
    	News news=new News();
    	String sql="select title,summary,author,content,createdate,picpath from news_detail where id=?";
    	Object[] params={id};
    	ResultSet rs=this.executeSQL(sql, params); 		
		try {
			while(rs.next()){
				 String title=rs.getString("title");	
				 String summary=rs.getString("summary");
				 String author=rs.getString("author");
				 String content=rs.getString("content");
				 Timestamp createdate=rs.getTimestamp("createdate");
				 String picpath=rs.getString("picpath");
				 
				 news.setTitle(title);
				 news.setSummary(summary);
				 news.setAuthor(author);
				 news.setContent(content);
				 news.setCreateDate(createdate);
				 news.setPicPath(picpath);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return news;
    	
    }
    
    
  //查询某个新闻分类下是否有新闻
  	public int getCountByCategory(NewsCategory newsCategory){
  		int count=0;
  		try {
	  		String sql="select count(1) from news_detail where categoryId=?";
	  		Object[] params= {newsCategory.getId()};
	  		ResultSet rs=this.executeSQL(sql, params); 		
			while(rs.next()){
					count=rs.getInt(1);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return count; 			
  	}

    //增加新闻信息
    public boolean addNews(News news) {
    	boolean flag=false;
        try {
            
            //sql命令
            String sql="INSERT INTO news_detail(categoryId,title,summary,content,author,createdate,picpath) VALUES (?,?,?,?,?,?,?)";
            Object[] params={news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),news.getAuthor(),new Timestamp(news.getCreateDate().getTime()),news.getPicPath()};
            int i=this.executeUpdate(sql, params);
            if (i>0) {
                System.out.println("插入新闻成功！");
                flag=true;
            }
        } finally {
           this.closeResource();
        }
        return flag;
        }



    //删除特定新闻
        public boolean deleteNews(News news) {
        	boolean flag=false;
            try {
                String sql="DELETE FROM news_detail WHERE ID=?";
                Object[] params={news.getId()};
                int i=this.executeUpdate(sql, params);
                if (i>0) {
                    System.out.println("删除新闻成功！");
                    flag=true;
                }
            } finally {
                this.closeResource();
            }
            return flag;
        }

    //修改特定新闻标题的方法
    public void updateNews(News news) {
        try {
            String sql="update news_detail set title=? WHERE ID=?";
            Object[] params={news.getTitle(),news.getId()};
            int i=this.executeUpdate(sql, params);
            if (i>0) {
                System.out.println("修改新闻成功！");
            }
        } finally {
           this.closeResource();
        }
    }

    //查询全部新闻信息的方法
    public List<News> getNewsList() {
    	List<News> list=new ArrayList<News>();
        try {
            String sql = "SELECT id,categoryId,title,summary,content,author,createdate FROM news_detail";
            Object[] params={};
            ResultSet rs=this.executeSQL(sql, params);
            while (rs.next()) {
                int id = rs.getInt("id");
                int categoryId=rs.getInt("categoryId");
                String newstitle = rs.getString("title");
                String summary = rs.getString("summary");
                String content = rs.getString("content");
                String author = rs.getString("author");
                Timestamp createdate=rs.getTimestamp("createdate");
                System.out.println(id + "\t" + "categoryId"+ "\t" +newstitle+ "\t" +"summary"+ "\t" +"content"+ "\t" +"author"+ "\t" +createdate);
                News news=new News();
                news.setId(id);
                news.setCategoryId(categoryId);
                news.setTitle(newstitle);
                news.setSummary(summary);
                news.setAuthor(author);
                news.setContent(content);
                news.setCreateDate(createdate);
                
                list.add(news);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return list;
    }


    //查询特定新闻id，标题
    public void getNewsByTitle(News news) {

        try {
            String sql = "SELECT id,title FROM news_detail where title=?";
            Object[] params ={news.getTitle()};
            ResultSet rs=this.executeSQL(sql, params);
            while (rs.next()) {
                int id = rs.getInt("id");
                String newstitle = rs.getString(2);
                System.out.println(id + "\t" + newstitle);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
           this.closeResource();
        }
    }

  //根据数据源获取新闻信息
  	public void getNewsListByDS() {
  		ResultSet rsResultSet = null;
  		try {
  			// 3 获取Statement对象，执行sql语句
  			String sql = "select * from news_detail";
  			Object[] params = {};
  			rsResultSet = this.executeSQL(sql, params);
  			// 4 处理执行结果集ResultSet
  			while (rsResultSet.next()) {
  				int id = rsResultSet.getInt("id");
  				String title = rsResultSet.getString("title");
  				String summary = rsResultSet.getString("summary");
  				String content = rsResultSet.getString("content");
  				String author = rsResultSet.getString("author");
  				Timestamp createDate = rsResultSet.getTimestamp("createDate");
  				System.out.println(id + "\t" + title + "\t" + summary + "\t"
  						+ content + "\t" + author + "\t" + createDate);
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  		} finally {
  			this.closeResource();
  		}
  	}

    public static void main(String[] args) {
    	NewsDao dao=new NewsDaoImpl();
    	News news=new News();
    	news.setId(88);
    	news.setCategoryId(2);
    	news.setTitle("tet");
    	news.setAuthor("ee");
    	news.setContent("ss");
    	news.setCreateDate(new Date());
    	news.setSummary("ds");
    	
    	dao.addNews(news);
    	/*News news=new News();
    	news.setId(88);
    	news.setCategoryId(2);
    	news.setTitle("newtet");
    	dao.addNews(news);*/
//		dao.getNewsByTitle("Java Web开课啦！");
//		dao.addNews(3,1,"test","test","test","chenxuan",new Date());
//		dao.updateNews(3,"newTitle");
		dao.getNewsList();
//		dao.deleteNews(3);

    }





}





















