package org.system.url;

/**
 * 博客
 * @author Administrator
 *
 */
public class UrlBlog {
		/**
		 * 发布博客
		 * @param access_token
		 * @param title
		 * @param content
		 * @param save_as_draft
		 * @param catalog
		 * @param abstracts
		 * @param tags
		 * @param classification
		 * @param type
		 * @param origin_url
		 * @param privacy
		 * @param deny_comment
		 * @param auto_content
		 * @param as_top
		 * @return
		 */
		public String blog_pub(String access_token,String title,String content,int save_as_draft,String catalog,
				String abstracts,String tags,int classification,int type,String origin_url,String privacy,
				String deny_comment,String auto_content,String as_top){
			return "/action/openapi/blog_pub?access_token="+access_token+"&title="+title+"&content="+content+"&save_as_draft="+save_as_draft+"&catalog="+catalog
			+"&abstracts="+abstracts+"&tags="+tags+"&classification="+classification+"&type="+type+"&origin_url="+origin_url+"&privacy="+privacy
			+"&deny_comment="+deny_comment+"&auto_content="+auto_content+"&auto_content="+auto_content;
		}
		/**
		 * 获取博客列表
		 * @param client_id
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param dataType
		 * @return
		 */
		public String blog_list(String client_id,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/blog_list?client_id="+client_id+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
		/**
		 * 获取博客推荐列表
		 * @param client_id
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param dataType
		 * @return
		 */
		public String blog_recommend_list(String client_id,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/blog_recommend_list?client_id="+client_id+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
		/**
		 * 获取博客详情
		 * @param id
		 * @param access_token
		 * @param dataType
		 * @return
		 */
		public String blog_detail(long id,String access_token,String dataType){
			return "/action/openapi/blog_detail?id="+id+"&access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 获取用户博客列表
		 * @param access_token
		 * @param authoruid
		 * @param authorname
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param dataType
		 * @return
		 */
		public String user_blog_list(String access_token,int authoruid,String authorname,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/user_blog_list?access_token="+access_token+"&authoruid="+authoruid+"&authorname="+authorname+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
}