package org.system.url;

/**
 * 评论
 * @author Administrator
 *
 */
public class UrlComment {
		/**
		 * 获取博客评论列表
		 * @param client_id
		 * @param id
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param dataType
		 * @return
		 */
		public String blog_comment_list(String client_id,int id,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/blog_comment_list?client_id="+client_id+"&id="+id+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
		/**
		 * 发表博客评论
		 * @param access_token
		 * @param blog
		 * @param content
		 * @param dataType
		 * @return
		 */
		public String blog_comment_pub(String access_token,long blog,String content,String dataType){
			return "/action/openapi/blog_comment_pub?access_token="+access_token+"&blog="+blog+"&content="+content+"&dataType="+dataType;
		}
		/**
		 * 回复博客评论
		 * @param access_token
		 * @param blog
		 * @param content
		 * @param reply_id
		 * @param reply_user
		 * @param dataType
		 * @return
		 */
		public String blog_comment_reply(String access_token,long blog,String content,long reply_id,long reply_user,String dataType){
			return "/action/openapi/blog_comment_reply?access_token="+access_token+"&blog="+blog+"&content="+content+"&reply_id="+reply_id+"&reply_user="+reply_user+"&dataType="+dataType;
		}
		/**
		 * 删除用户博客
		 * @param access_token
		 * @param id
		 * @param dataType
		 * @return
		 */
		public String user_blog_delete(String access_token,long id,String dataType){
			return "/action/openapi/user_blog_delete?access_token="+access_token+"&id="+id+"&dataType="+dataType;
		}
		/**
		 * 获取评论列表
		 * @param id
		 * @param catalog
		 * @param access_token
		 * @param user
		 * @param pageSize
		 * @param page
		 * @param pageIndex
		 * @param dataType
		 * @return
		 */
		public String comment_list(int id,int catalog,String access_token,int user,int pageSize,int page,int pageIndex,String dataType){
			return "/action/openapi/comment_list?id="+id+"&catalog="+catalog+"&access_token="+access_token+"&user="+user+"&pageSize="+pageSize+"&page="+page+"&pageIndex="+pageIndex+"&dataType="+dataType;
		}
		/**
		 * 发表评论
		 * @param access_token
		 * @param blog
		 * @param content
		 * @param dataType
		 * @return
		 */
		public String comment_pub(String access_token,long blog,String content,String dataType){
			return "/action/openapi/blog_comment_pub?access_token="+access_token+"&blog="+blog+"&content="+content+"&dataType="+dataType;
		}
		/**
		 * 回复评论
		 * @param access_token
		 * @param id
		 * @param catalog
		 * @param content
		 * @param receiver
		 * @param authorid
		 * @param replyid
		 * @param isPostToMyZone
		 * @param dataType
		 * @return
		 */
		public String comment_reply(String access_token,long id,long catalog,String content,long receiver,long authorid,long replyid,int isPostToMyZone,String dataType){
			return "/action/openapi/comment_reply?access_token="+access_token+"&id="+id+"&catalog="+catalog+"&content="+content+"&receiver="+receiver+"&authorid="+authorid+"&replyid="+replyid+"&isPostToMyZone="+isPostToMyZone+"&dataType="+dataType;
		}
		/**
		 * 删除评论
		 * @param access_token
		 * @param catalog
		 * @param id
		 * @param replyid
		 * @param authorid
		 * @param dataType
		 * @return
		 */
		public String comment_delete(String access_token,long catalog,long id,long replyid,long authorid,String dataType){
			return "/action/openapi/comment_delete?access_token="+access_token+"&catalog="+catalog+"&id="+id+"&replyid="+replyid+"&authorid="+authorid+"&dataType="+dataType;
		}
}
