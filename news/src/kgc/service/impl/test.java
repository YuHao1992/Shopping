package kgc.service.impl;

import java.util.List;

import kgc.pojo.News;
import kgc.pojo.NewsCategory;
import kgc.sercive.NewsCategoryService;
import kgc.sercive.NewsService;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	// TODO Auto-generated method stub
		NewsCategory newsCaregory=new NewsCategory();
		newsCaregory.setId(6);
		NewsCategoryService newsCategoryService=new NewsCateGoryServiceImpl();
		newsCategoryService.deleteNewsCategory(newsCaregory);*/
		
		
//		NewsService newsService=new NewsServiceImpl();
//		List<News> list=newsService.getNewsList();
//	   for(News news:list){
//		   System.out.println(news.getAuthor());
//	   		}
		//測試分頁
		NewsService service=new NewsServiceImpl();
		System.out.println(service .getTotalCount());
		
		List<News> list=service.getPageNewsList(1, 3);
		for(News news:list){
			System.out.println(news.getId()+"-"+news.getTitle());
		}
	}

}

















