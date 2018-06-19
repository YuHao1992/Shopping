package kgc.service.impl;

import com.sun.xml.internal.bind.v2.model.core.ID;

import kgc.dao.NewsCategoryDao;
import kgc.dao.NewsDao;
import kgc.impl.NewsCategoryDaoImpl;
import kgc.impl.NewsDaoImpl;
import kgc.pojo.NewsCategory;
import kgc.sercive.NewsCategoryService;

public class NewsCateGoryServiceImpl implements NewsCategoryService {
	private NewsDao newsDao;
	private NewsCategoryDao newsCategoryDao;
	public NewsCateGoryServiceImpl(){
		newsDao=new NewsDaoImpl();
		newsCategoryDao=new NewsCategoryDaoImpl();
	}
	
	
	
	//删除新闻分类
	public boolean deleteNewsCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int count=newsDao.getCountByCategory(newsCategory);
		if(count>0){
			System.out.println("无法删除该分类！");
		}else{
			flag=newsCategoryDao.deleteNewsCategory(newsCategory);
		}
		return flag;
	}

}
