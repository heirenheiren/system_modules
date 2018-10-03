package org.system.url;

/**
 * 留言
 * @author Administrator
 *
 */
public class UrlMessage {
		/**
		 * 获取留言列表
		 * @param page/页数	1
		 * @param pageIndex/页数	1
		 * @param pageSize/每页条数	20
		 * @param access_token/oauth2_token获取的access_token
		 * @param dataType/返回值类型['json'|'jsonp'|'xml']		json
		 * @return
		 */
		public String message_list(int page,int pageIndex,int pageSize,String access_token,String dataType){
			return "/action/openapi/message_list?page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 删除留言
		 * @param access_token/oauth2_token获取的access_token
		 * @param user/发送留言者
		 * @param friend/接受留言者
		 * @param dataType/返回值类型['json'|'jsonp'|'xml']		json
		 * @return
		 */
		public String message_delete(String access_token,long user,long friend,String dataType){
			return "/action/openapi/message_delete?access_token="+access_token+"&user="+user+"&friend="+friend+"&access_token="+access_token+"&dataType="+dataType;
		}
}
