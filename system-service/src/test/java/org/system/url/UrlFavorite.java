package org.system.url;

/**
 * 收藏
 * @author Administrator
 *
 */
public class UrlFavorite {
		/**
		 * 获取收藏列表
		 * @param type
		 * @param page
		 * @param pageIndex
		 * @param pageSize
		 * @param access_token
		 * @param dataType
		 * @return
		 */
		public String friends_list(int type,int page,int pageIndex,int pageSize,String access_token,String dataType){
			return "/action/openapi/friends_list?type="+type+"&page="+page+"&pageIndex="+pageIndex+"&pageSize="+pageSize+"&access_token="+access_token+"&dataType="+dataType;
		}
		/**
		 * 添加收藏
		 * @param access_token
		 * @param id
		 * @param type
		 * @param dataType
		 * @return
		 */
		public String favorite_add(String access_token,int id,String type,String dataType){
			return "/action/openapi/favorite_add?access_token="+access_token+"&id="+id+"&type="+type+"&dataType="+dataType;
		}
		/**
		 * 取消收藏
		 * @param access_token
		 * @param id
		 * @param type
		 * @param dataType
		 * @return
		 */
		public String favorite_remove(String access_token,int id,String type,String dataType){
			return "/action/openapi/favorite_remove?access_token="+access_token+"&id="+id+"&type="+type+"&dataType="+dataType;
		}
}
