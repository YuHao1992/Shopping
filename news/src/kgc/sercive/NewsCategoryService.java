package kgc.sercive;

import kgc.pojo.NewsCategory;

//对新闻类别进行业务逻辑操作的service
public interface NewsCategoryService {
	//删除新闻分类
	public boolean deleteNewsCategory(NewsCategory newsCaregory);
}
