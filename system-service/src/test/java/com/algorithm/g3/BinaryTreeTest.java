package com.algorithm.g3;

//在JAVA中实现二叉树，程序如下（转载）

//******************************************************************** 
//filename: BinaryTreeTest.java 
//purpose: test a binarytree with java 
//date: 2002/12/18 
//author: flyfan 
//ver: 0.1 
//******************************************************************** 

public class BinaryTreeTest
{
	public static void main(String args[])
	{
		BinaryTreeTest b = new BinaryTreeTest();
		int data[] = { 12, 11, 34, 45, 67, 89, 56, 43, 22, 98 };
		BinaryTree root = new BinaryTree(data[0]);

		System.out.print("二叉树的中的数据：　　");
		for (int i = 1; i < data.length; i++)
		{
			root.insertTree(root, data[i]);
			System.out.print(data[i - 1] + ";");
		}

		System.out.println(data[data.length - 1]);

		int key = Integer.parseInt(args[0].toString());

		if (b.searchkey(root, key))
		{
			System.out.println("找到了:" + key);
		}
		else
		{
			System.out.println("没有找到：" + key);
		}
	}

	public boolean searchkey(BinaryTree root, int key)
	{
		boolean bl = false;
		if (root == null)
		{
			bl = false;
			return bl;
		}
		else if (root.data == key)
		{
			bl = true;
			return bl;
		}
		else if (key >= root.data)
		{
			return searchkey(root.rightpoiter, key);
		}
		return searchkey(root.leftpoiter, key);
	}
}

class BinaryTree
{
	int data;
	BinaryTree leftpoiter;
	BinaryTree rightpoiter;

	BinaryTree(int data)
	{
		this.data = data;
		leftpoiter = null;
		rightpoiter = null;
	}

	public void insertTree(BinaryTree root, int data)
	{
		if (data >= root.data)
		{
			if (root.rightpoiter == null)
			{
				root.rightpoiter = new BinaryTree(data);
			}
			else
			{
				insertTree(root.rightpoiter, data);
			}
		}
		else
		{
			if (root.leftpoiter == null)
			{
				root.leftpoiter = new BinaryTree(data);
			}
			else
			{
				insertTree(root.leftpoiter, data);
			}
		}
	}
}
//end

//讲解：上述各序小，但层次分明，结构严谨，如果有数据库结构知识与C语文能力的JAVA初学者
//
//一看就明白，二个方法如同C语文中的函数，一个寻找关键字－－searchkey 另一个是插入一个
//
//结点：insertTree 而class BinaryTree 如同一个C语言中的共同体.
//
//
//另外这是一个完全的先序遍历二叉树的语法。先根结点，再左结点，如无再右结点，如些加归至
//
//搜索完毕。
//
//运行命令行：java BinaryTreeTest intNumber(一个整数）
//
//
//
//本文来自CSDN博客，转载请标明出处：http://blog.csdn.net/dayang_32/archive/2006/09/16/1228720.aspx
