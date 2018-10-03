package org.system.url;

/**
 * 帖子
 * @author Administrator
 *
 */
public class UrlPose {
		/**
		 * 获取讨论区的帖子列表(对应android的 问答 分享 综合 职业 站务)
		 * @param client_id/OAuth2客户ID
		 * @param catalog/类别ID 1-问答 2-分享 3-IT杂烩(综合) 4-站务 100-职业生涯 0-所有     0
		 * @param tag/帖子相关标签
		 * @param page/页数	1
		 * @param pageIndex/页数	1
		 * @param pageSize/每页条数	20
		 * @param dataType/返回数据类型['json'|'jsonp'|'xml']	json
		 * @return
		 */
		public String post_list(String client_id,int catalog,String tag,int page,int pageIndex,int pageSize,String dataType){
			return "/action/openapi/post_list?client_id="+client_id+"&catalog="+catalog+"&tag="+tag+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&dataType="+dataType;
		}
		/**
		 * 发布帖子
		 * @param access_token/oauth2_token获取的access_token
		 * @param isNoticeMe/有回答是否邮件通知 2是邮件通知	0
		 * @param catalog/类别ID 1-问答 2-分享 3-IT杂烩(综合) 4-站务 100-职业生涯	0
		 * @param title/帖子标题
		 * @param content/帖子内容
		 * @param askuser/用户id（向某人提问）
		 * @return
		 */
		public String post_pub(String access_token,int isNoticeMe,int catalog,String title,String content,long askuser){
			return "/action/openapi/post_pub?access_token="+access_token+"&isNoticeMe="+isNoticeMe+"&catalog="+catalog+"&title="+title+"&content="+content+"&askuser="+askuser;
		}
		/**
		 * 获取讨论区的帖子详情
		 * @param id/帖子ID	0
		 * @param access_token/oauth2_token获取的access_token 传则显示是否收藏 用户未登录则不传	
		 * @param dataType/返回数据类型['json'|'jsonp'|'xml']
		 * @return
		 */
		public String post_detail(long id,String access_token,String dataType){
			return "/action/openapi/post_detail?id="+id+"&access_token="+access_token+"&dataType="+dataType;
		}
}