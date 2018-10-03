package org.system.url;

/**
 * 动弹
 * @author Administrator
 * @param <image>
 *
 */
public class UrlTweet<image> {
		/**
		 * 获取动弹列表 （最新动弹列表 我的动弹）
		 * @param client_id
		 * @param user
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param dataType
		 * @return
		 */
		public String tweet_list(String client_id,int user,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/tweet_list?client_id="+client_id+"&user="+user+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
		/**
		 * 获取动弹列表
		 * @param client_id
		 * @param id
		 * @param dataType
		 * @return
		 */
		public String tweet_detail(String client_id,long id,String dataType){
			return "/action/openapi/tweet_detail?client_id="+client_id+"&id="+id+"&dataType="+dataType;
		}
		/**
		 * 发布动弹
		 * @param access_token
		 * @param msg
		 * @param img
		 * @return
		 */
		public String tweet_pub(String access_token,int msg,image img){
			return "/action/openapi/tweet_pub?access_token="+access_token+"&msg="+msg+"&img="+img;
		}
		/**
		 * 删除动弹
		 * @param access_token
		 * @param tweetid
		 * @param dataType
		 * @return
		 */
		public String tweet_pub(String access_token,long tweetid,String dataType){
			return "/action/openapi/tweet_pub?access_token="+access_token+"&tweetid="+tweetid+"&dataType="+dataType;
		}
}
