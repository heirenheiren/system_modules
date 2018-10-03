package org.system.url;

/**
 * 搜索
 * @author Administrator
 *
 */
public class UrlSearch {
		/**
		 * 获取搜索列表
		 * @param client_id/OAuth2客户ID
		 * @param catalog/news-新闻，blog-博客，project-开源软件，post-帖子、问答	0
		 * @param q/搜索关键字	0
		 * @param page/页数	1
		 * @param pageIndex/页数	1
		 * @param pageSize/每页条数	20
		 * @param dataType/返回数据类型['json'|'jsonp'|'xml']	json
		 * @return
		 */
		public String tweet_list(String client_id,int catalog,String q,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/tweet_list?client_id="+client_id+"&catalog="+catalog+"&q="+q+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
}