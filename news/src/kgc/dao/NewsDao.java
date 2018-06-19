package kgc.dao;

import java.util.Date;
import java.util.List;

import kgc.pojo.News;
import kgc.pojo.NewsCategory;

public interface NewsDao {
	//连接数据源，进行数据库操作，查询新闻
	public void getNewsListByDS();

	// 增加新闻信息
	public boolean addNews(News news) ;
	// 修改新闻标题
	public void updateNews(News news);
	// 删除新闻信息
	public boolean deleteNews(News news);

	// 查找特定标题的新闻信息
	public void getNewsByTitle(News news);
	//查询全部新闻信息
	public List<News> getNewsList();
	
	//查询某个新闻分类下是否有新闻
	public int getCountByCategory(NewsCategory newsCategory);
	
	//根据iD查询特定 新闻信息
	public News getNewsById(int id);
	
	//获取新闻总数据
	public int getTotalCount();
	
	//分页获取新闻数据
	public List<News> getPageNewsList(int pageNo,int pageSize);
}



















