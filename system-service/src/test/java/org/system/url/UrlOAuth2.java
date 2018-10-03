package org.system.url;

/**
 * 认证接口
 * @author Administrator
 *
 */
public class UrlOAuth2 {
		/**
		 * OpenAPI 授权登录页面
		 * @param client_id
		 * @param response_type
		 * @param redirect_uri
		 * @param state
		 * @return
		 */
		public String authorize(String client_id,String response_type,String redirect_uri,String state){
			return "/action/oauth2/authorize?client_id="+client_id+"&response_type="+response_type+"&redirect_uri="+redirect_uri+"&state="+state;
		}
		/**
		 * authorization_code 方式获取 AccessToken
		 * @param client_id
		 * @param client_secret
		 * @param grant_type
		 * @param redirect_uri
		 * @param code
		 * @param dataType
		 * @param callback
		 * @return
		 */
		public String token(String client_id,String client_secret,String grant_type,String redirect_uri,String code,String dataType,String callback){
			return "/action/oauth2/token?client_id="+client_id+"&client_secret="+client_secret+"&grant_type="+grant_type+"&redirect_uri="+redirect_uri+"&code="+code+"&dataType="+dataType+"&callback="+callback;
		}
}