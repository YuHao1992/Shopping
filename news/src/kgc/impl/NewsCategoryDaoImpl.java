package kgc.impl;

import kgc.dao.BaseDao;
import kgc.dao.NewsCategoryDao;
import kgc.pojo.NewsCategory;

public class NewsCategoryDaoImpl extends BaseDao implements NewsCategoryDao {

	public boolean deleteNewsCategory(NewsCategory newsCategory) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="delete from news_category where id=?";
		Object[] params={newsCategory.getId()};
		int i=this.executeUpdate(sql, params);
		if(i>0){
			System.out.println("删除新闻类别成功！");
			flag=true;
		}
		return flag;
	}

}
