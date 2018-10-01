package org.system.keyword;

public class People
{
	int num;

	public People()
	{
	} // 默认的无参构造函数，没有进行初始化

	public People(int num)
	{ // 有参构造函数
		this.num = num;
	}

	public String toString()
	{
		return "num:" + num;
	}
}
