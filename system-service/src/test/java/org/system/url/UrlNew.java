package org.system.url;

/**
 * 新闻
 * @author Administrator
 *
 */
public class UrlNew {
	/**
	 * 获取新闻列表
	 * @param client_id
	 * @param catalog
	 * @param page
	 * @param pageIndex
	 * @param pageSize
	 * @param dataType
	 * @return
	 */
	public String news_list(String client_id,int catalog,int page,int pageIndex,int pageSize,String dataType){
		return "/action/openapi/news_list?client_id="+client_id+"&catalog="+catalog+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
	}
	/**
	 * 获取新闻详情
	 * @param id
	 * @param access_token
	 * @param dataType
	 * @return
	 */
	public String news_detail(long id,String access_token,String dataType){
		return "/action/openapi/news_detail?id="+id+"&access_token="+access_token+"&dataType="+dataType;
	}
}