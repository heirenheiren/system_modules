package com.algorithm.g3;
//http://www.99inf.net/SoftwareDev/Java/53925.htm  纠正下面的
public class HashMap和Hashtable {
//一错误解析	
//HashTable的应用非常广泛，HashMap是新框架中用来代替HashTable的类，也就是说建议使用HashMap，不要使用HashTable。可能你觉得HashTable很好用，为什么不用呢？这里简单分析他们的区别。  
//
//	1.HashTable的方法是同步的，HashMap未经同步，所以在多线程场合要手动同步HashMap这个区别就像Vector和ArrayList一样。 
//
//	2.HashTable不允许null值(key和value都不可以),HashMap允许null值(key和value都可以)。 
//
//	3.HashTable有一个contains(Object value)，功能和containsValue(Object value)功能一样。 
//
//	4.HashTable使用Enumeration，HashMap使用Iterator。 以上只是表面的不同，它们的实现也有很大的不同。 
//
//	5.HashTable中hash数组默认大小是11，增加的方式是 old*2+1。HashMap中hash数组的默认大小是16，而且一定是2的指数。 
//
//	6.哈希值的使用不同，HashTable直接使用对象的hashCode，代码是这样的： 
//
//	int hash = key.hashCode(); 
//
//	int index = (hash & 0x7FFFFFFF) % tab.length; 
//
//	而HashMap重新计算hash值，而且用与代替求模： 
//
//	int hash = hash(k); 
//	int i = indexFor(hash, table.length); 
//
//	static int hash(Object x) { 
//	　　 int h = x.hashCode(); 
//	　　 h += ~(h << 9); 
//	　　 h ^= (h >>> 14); 
//	　　 h += (h << 4); 
//	　　 h ^= (h >>> 10); 
//	　　 return h; 
//	}
//	 
//	static int indexFor(int h, int length) { 
//	　　 return h & (length-1); 
//	} 
//	以上只是一些比较突出的区别，当然他们的实现上还是有很多不同的，比如HashMap对null的操作。 
//	Hashtable和HashMap的区别： 
//	1.Hashtable是Dictionary的子类，HashMap是Map接口的一个实现类； 
//	2.Hashtable中的方法是同步的，而HashMap中的方法在缺省情况下是非同步的。即是说，在多线程应用程序中，不用专门的操作就安全地可以使用Hashtable了；而对于HashMap，则需要额外的同步机制。但HashMap的同步问题可通过Collections的一个静态方法得到解决： 
//	Map Collections.synchronizedMap(Map m) 
//	这个方法返回一个同步的Map，这个Map封装了底层的HashMap的所有方法，使得底层的HashMap即使是在多线程的环境中也是安全的。 
//	3.在HashMap中，null可以作为键，这样的键只有一个；可以有一个或多个键所对应的值为null。当get()方法返回null值时，即可以表示HashMap中没有该键，也可以表示该键所对应的值为null。因此，在HashMap中不能由get()方法来判断HashMap中是否存在某个键，而应该用containsKey()方法来判断。 
//
//	Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现 
//	  
//	HashMap允许将null作为一个entry的key或者value，而Hashtable不允许 
//	  
//	还有就是，HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。 
//
//	最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在 
//	多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 
//	就必须为之提供外同步。 
//	  
//	Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。

//二。正确解析
//	Hashtable和HashMap的区别：
//	1.Hashtable是Dictionary的子类，HashMap是Map接口的一个实现类；
//	2.Hashtable中的方法是同步的，而HashMap中的方法在缺省情况下是非同步的。即是说，在多线程应用程序中，不用专门的操作就安全地可以使用Hashtable了；而对于HashMap，则需要额外的同步机制。但HashMap的同步问题可通过Collections的一个静态方法得到解决：
//	Map Collections.synchronizedMap(Map m)
//	这个方法返回一个同步的Map，这个Map封装了底层的HashMap的所有方法，使得底层的HashMap即使是在多线程的环境中也是安全的。
//	3.在HashMap中，null可以作为键，这样的键只有一个；可以有一个或多个键所对应的值为null。当get()方法返回null值时，即可以表示HashMap中没有该键，也可以表示该键所对应的值为null。因此，在HashMap中不能由get()方法来判断HashMap中是否存在某个键，而应该用containsKey()方法来判断。 



}
