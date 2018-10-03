package org.system.url;

/**
 * 软件
 * @author Administrator
 *
 */
public class UrlProject {
		/**
		 * 获取软件详情
		 * @param ident/软件Ident	null
		 * @param access_token/oauth2_token获取的access_token 传则显示是否收藏 用户未登录则不传
		 * @param dataType/返回数据类型 ['json'|'jsonp'|'xml']
		 * @return
		 */
		public String update_user_relation(long ident,String access_token,String dataType){
			return "/action/openapi/update_user_relation?ident="+ident+"&access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 获取软件分类列表(只有2级)
		 * @param client_id/OAuth2客户ID
		 * @param tag/第一级:tag传0,第二级:传递第一级返回的对应tag	0
		 * @param dataType/返回数据类型['json'|'jsonp'|'xml']	json
		 * @return
		 */
		public String project_catalog_list(String client_id,int tag,String dataType){
			return "/action/openapi/project_catalog_list?client_id="+client_id+"&tag="+tag+"&dataType="+dataType;
		}
}
