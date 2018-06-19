package kgc.service.impl;

import java.util.List;

import kgc.dao.NewsDao;
import kgc.impl.NewsDaoImpl;
import kgc.pojo.News;
import kgc.sercive.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;
	
	public NewsServiceImpl(){
		newsDao=new NewsDaoImpl();
	}
	
	
	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		return newsDao.getNewsList();
	}
	//增加新闻
	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.addNews(news);
	}
	//根据iD查询特定新闻信息
	public News getNewsById(int id){
		return newsDao.getNewsById(id);
		
	}
	//获取新闻总数据
	public int getTotalCount(){
		return newsDao.getTotalCount();
	}
		
	//分页获取新闻数据
	public List<News> getPageNewsList(int pageNo,int pageSize){
		return newsDao.getPageNewsList(pageNo, pageSize);
	}
	
	//删除新闻
	public boolean deleteNews(News news){
		return newsDao.deleteNews(news);
	}
}
