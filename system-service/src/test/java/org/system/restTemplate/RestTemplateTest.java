package org.system.restTemplate;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest
{
	@Autowired
	RestTemplate restTemplate;

	// 无参数的 getForEntity 方法
	@RequestMapping("getForEntity")
	public List<UserEntity> getAll2()
	{
		ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://localhost/getAll", List.class);
		HttpHeaders headers = responseEntity.getHeaders();
		HttpStatus statusCode = responseEntity.getStatusCode();
		int code = statusCode.value();

		List<UserEntity> list = responseEntity.getBody();

		System.out.println(list.toString());
		System.out.println(headers);
		System.out.println(code);
		return list;
	}

	// 有参数的 getForEntity 请求,参数列表,可以使用 {} 进行url路径占位符
	@RequestMapping("getForEntity/{id}")
	public UserEntity getById2(@PathVariable(value = "id") String id)
	{
		ResponseEntity<UserEntity> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}",
				UserEntity.class, id);
		UserEntity userEntity = responseEntity.getBody();
		return userEntity;
	}

	// 有参数的 get 请求,使用map封装参数
	@RequestMapping("getForEntity/{id}")
	public UserEntity getById4(@PathVariable(value = "id") String id)
	{
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);

		ResponseEntity<UserEntity> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}",
				UserEntity.class, map);
		UserEntity userEntity = responseEntity.getBody();

		return userEntity;
	}

	// 无参数的 getForObject 请求
	@RequestMapping("getAll2")
	public List<UserEntity> getAll()
	{
		List<UserEntity> list = restTemplate.getForObject("http://localhost/getAll", List.class);

		System.out.println(list.toString());
		return list;

	}

	// 有参数的 getForObject 请求
	@RequestMapping("get2/{id}")
	public UserEntity getById(@PathVariable(value = "id") String id)
	{

		UserEntity userEntity = restTemplate.getForObject("http://localhost/get/{id}", UserEntity.class, id);

		return userEntity;
	}

	// 有参数的 get 请求,使用map封装请求参数
	@RequestMapping("get3/{id}")
	public UserEntity getById3(@PathVariable(value = "id") String id)
	{
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);

		UserEntity userEntity = restTemplate.getForObject("http://localhost/get/{id}", UserEntity.class, map);

		return userEntity;
	}

	// post 请求,提交 UserEntity 对像
	@RequestMapping("saveUser")
	public String save(UserEntity userEntity)
	{

		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/save", userEntity,
				String.class);
		String body = responseEntity.getBody();
		return body;
	}

	// 有参数的 postForEntity 请求,使用map封装
	@RequestMapping("saveUserByType2/{type}")
	public String save3(UserEntity userEntity, @PathVariable("type") String type)
	{
		HashMap<String, String> map = new HashMap<>();
		map.put("type", type);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}",
				userEntity, String.class, map);
		String body = responseEntity.getBody();
		return body;
	}

}
