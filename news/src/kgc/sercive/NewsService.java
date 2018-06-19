package kgc.sercive;

import java.util.List;

import kgc.pojo.News;

//对新闻信息进行逻辑操作的接口
public interface NewsService {
	//查询全部新闻
	public List<News> getNewsList();
	
	//增加新闻
	public boolean addNews(News news);
	
	//根据新闻ID查询新闻信息
	public News getNewsById(int id);
	
	//获取新闻总数据
	public int getTotalCount();
		
	//分页获取新闻数据
	public List<News> getPageNewsList(int pageNo,int pageSize);
	
	//删除新闻
	public boolean deleteNews(News news);
}
