package org.system.url;

/**
 * 个人信息
 * @author Administrator
 *
 */
public class UrlUser {
		/**
		 * 获取当前登录用户的账户信息
		 * @param access_token
		 * @param dataType
		 * @return
		 */
		public String openapi_user(String access_token,String dataType){
			return "/action/openapi/openapi_user?access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 用户详情
		 * @param client_id
		 * @param user
		 * @param friend
		 * @param friend_name
		 * @param dataType
		 * @return
		 */
		public String user_information(String client_id,long user,long friend,String friend_name,String dataType){
			return "/action/openapi/user_information?client_id="+client_id+"&user="+user+"&friend="+friend+"&friend_name="+friend_name+"&dataType="+dataType;
		}
		/**
		 * 个人主页详情
		 * @param access_token
		 * @param dataType
		 * @return
		 */
		public String my_information(String access_token,String dataType){
			return "/action/openapi/my_information?access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 头像更新
		 * @param access_token
		 * @param portrait
		 * @return
		 */
		public String portrait_update(String access_token,String portrait){
			return "/action/openapi/portrait_update?access_token="+access_token+"&portrait="+portrait;
		}
		/**
		 * 获取好友列表
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param relation
		 * @param access_token
		 * @param dataType
		 * @return
		 */
		public String friends_list(int page,int pageIndex,int pageSize,int relation,String access_token,String dataType){
			return "/action/openapi/friends_list?page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&relation="+relation+"&access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 获取动态列表
		 * @param access_token
		 * @param catalog
		 * @param user
		 * @param pageSize
		 * @param page
		 * @param pageIndex
		 * @param dataType
		 * @return
		 */
		public String active_list(String access_token,int catalog,int user,int pageSize,int page,int pageIndex,String dataType){
			return "/action/openapi/active_list?access_token="+access_token+"&catalog="+catalog+"&user="+user+"&pageSize="+pageSize+"&page="+page+"&pageIndex="+pageIndex+"&dataType="+dataType;
		}
		/**
		 * 更新好友关系（加关注、取消关注）
		 * @param access_token
		 * @param friend
		 * @param relation
		 * @param dataType
		 * @return
		 */
		public String update_user_relation(String access_token,long friend,int relation,String dataType){
			return "/action/openapi/update_user_relation?access_token="+access_token+"&friend="+friend+"&relation="+relation+"&dataType="+dataType;
		}
}