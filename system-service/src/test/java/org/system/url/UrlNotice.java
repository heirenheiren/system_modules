package org.system.url;

/**
 * 通知
 * @author Administrator
 *
 */
public class UrlNotice {
		/**
		 * 获取用户通知
		 * @param access_token/oauth2_token获取的access_token
		 * @param dataType/返回数据类型['json'|'jsonp'|'xml']	json
		 * @return
		 */
		public String user_notice(String access_token,String dataType){
			return "/action/openapi/user_notice?access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 清除用户通知
		 * @param access_token/oauth2_token获取的access_token
		 * @param type/需清除的通知类型：1-清除 @我的信息(referCount)，2-清除 未读信息(msgCount)，3-清除 评论个数(replyCount)，4-清除 新粉丝个数(fansCount)	0
		 * @param dataType/返回数据类型['json'|'jsonp'|'xml']	json
		 * @return
		 */
		public String clear_notice(String access_token,int type,String dataType){
			return "/action/openapi/clear_notice?access_token="+access_token+"&type="+type+"&dataType="+dataType;
		}
}
