package com.algorithm.g3;
//String s="xyz" 与 String s=new String("xyz") 
//一个是编译是常量池中的 "xyz ",另一个是运行时堆中的 "xyz ".s只是一个引用,不是对象,它指向的是堆中的那个 "xyz ". 
//http://www.javaeye.com/topic/774673
//如果String   str   =   "abc ";     就是在栈内存创建(如果已经存在,就用str引用指尚它) 
//如果String   str   =   new   String( "abc ")     就是在堆栈内存中创建(不管以前是否有该对象都创建),并且用str指尚它 

public class String对象 {
	
	public static void main(String[] args) {
	//String s = "abc" ;//s是存储在栈里。
  //先在栈中创建一个对String类的对象引用变量s，然后查找栈中有没有存放"abc"，如果没有，则将"abc"存放进栈，并令s指向”abc”，如果已经有”abc” 则直接令s指向“abc”。例子如下：
	String s1 = "abc";
	String s2 = "abc";
	System.out.println(s1==s2); //true 
	//说明s1和s2指向同一个对象
	
	
	//String s0 = new String("abc") ;//s是存储在堆里。
	//每调用一次就会创建一个新的对象。 例子如下：
	String s3 =new String ("abc");
	String s4 =new String ("abc");
	System.out.println(s3==s4); // false 
	//说明s1和s2是不指向同一个对象的
	}
}

//关于 String a=new String(“abc”); 究竟产生几个String对象实例问题的讨论？ 
//首先说明： 
//问此题的人，其实是草包一个，是半瓶水而已，就像问中国究竟有多少人一样？中国究竟有多少人呢？这问题本身就有问题，你是说中国现在有多少人，还是新中国成立的时候有多少人？还是全球有多少中国人? 
//问问题之前先要明白环境是什么？上下文是什么？那么java 也一样，你不了解java语言本身，或者jvm 本质很难回答看似简单，其实并非简单的问题。往往简单的问题，比较难回答，为什么呢？因为简单的问题没有环境约束，它没有限制出环境。任何东西脱离了周围环境，就没有它存在的价值，就好比 1+1 等于2 如何证明它一样。怎么证明呢？这个问题，你首先考虑的并不是证明不证明的问题。我们要考虑它是怎么来的？这个还真难考虑。不过怎么去证明它，首先你要知道，1+1 是否是规定就等于2，如果规定的东西，不要证明，我规定了1+1 等于二 那么证明它就显得很苍白，原因很简单规定必证明的优先权高，没有方法啊，你总不能越过规定吧，这是自然规律。首先你要这自然规律的约束下发展其自己，就像你活着地球上一样，你要看清地球本身，你光这地球上是不行的。 
//好废话少说，开始我们的讨论： 
//我定义了两个类 
//类一：StringDemo1 
//public class StringDemo1 { 
//public static void main(String[] args) { 
//String a=new String("abc"); 
//} 
//} 
//类二：StringDemo2 
//public class StringDemo2 { 
//public static void main(String[] args) { 
//String b="abc"; 
//String a=new String("abc"); 
//} 
//} 
//这是很简单的两个类，没有什么可解释的，唯一不同是StringDemo2 比StringDemo1多加了一行代码 String b="abc"; 换句话说是加了一个上文的环境。 
//有人就会问我这有什么关系呢？那么请看我下面的分析，很简单，我不会像论坛上的一些人一样，故意那么研究得深刻，把一些不明白的人往火坑里推，显得自己很高深似的。 
//开始动手： 
//步骤一： 
//Javac 编译两个类(各位自己这命令行编译，这里就不列出了了) 
//步骤二： 
//javap -c  使用此命令，这个命令可能一般人就没有使用过，自己上网查查，都是jdk命令;此命令使用的例子：javap -c StringDemo1  javap -c StringDemo2  分别这命令行敲上面的两条命令 
//好，下面的是我cmd 命令行的输出(你自己的输出应该也差不多) 
//注：我用红色的字体来注释行： 
//
//D:\String>javac StringDemo1.java 
//
//D:\String>javac StringDemo2.java 
//
//D:\String>javap -c StringDemo1 
//Compiled from "StringDemo1.java" 
//public class StringDemo1 extends java.lang.Object{ 
//public StringDemo1(); 
//Code: 
// 0:   aload_0 
// 1:   invokespecial   #1; //Method java/lang/Object."<init>":()V 
// 4:   return 
//
//public static void main(java.lang.String[]); 
//Code: 
// 0:   new     #2; //class java/lang/String 此句new 了一个对象，产生了一个对象，毫无疑问 
// 3:   dup   
// 4:   ldc     #3; //String abc  此句将String abc常量值从常量池中推送至栈顶 ，那这算不算对象，当然算了，只不过时创建时间可能不是现在哦 “#” 后面的为索引地址，我们可以从索引地址可以看到，这里有#2,#3,那么String a=new String("abc"); 
//这是一句代码哦，可以看出此题目中这此句产生了两个String 对象。 
// 6:   invokespecial   #4; //Method java/lang/String."<init>":(Ljava/lang/Strin 
//g;)V 
// 9:   astore_1 
// 10:  return 
//} 
//
//D:\String>javap -c StringDemo2 
//Compiled from "StringDemo2.java" 
//public class StringDemo2 extends java.lang.Object{ 
//public StringDemo2(); 
//Code: 
// 0:   aload_0 
// 1:   invokespecial   #1; //Method java/lang/Object."<init>":()V 
// 4:   return 
//
//public static void main(java.lang.String[]); 
//Code: 
// 0:   ldc     #2; //String abc  此句将String abc常量值从常量池中推送至栈顶 
// 2:   astore_1 //存储变量，也就是赋值操作 
// 3:   new     #3; //class java/lang/String  此句产生一个对像 
// 6:   dup 
// 7:   ldc     #2; //String abc   这里很有意思哦，我们看到 #2 索引地址已经出现过来，对了，上面 code 0： 就出现过了 他只不过是把地址，引用要过来了，并没有产生String对象，也就是从Stirng常量池里面要了个地址，自己知道地址就知道他的家了哦， 
//那么这里就有一个问题呀？什么问题？那这样的话，多个Sting变量有可能引用一个Strng实例，那么会产生String共享不安全的问题，多线程的情况下。这个不要担心了，String是线程安全的，因为它是final 类型的，没有办法改变！哦，恍然大悟！原来这样，怪不得sun这样做，有利于减少内存浪费啊（此问题其实还会产生String碎片，那就扯远了和StringBuffere有关系了，暂不讨论）。那么这么说来String a=new String("abc"); 此句产生了一个String对象。 
// 9:   invokespecial   #4; //Method java/lang/String."<init>":(Ljava/lang/Strin 
//g;)V 
// 12:  astore_2 
// 13:  return 
//} 
//
//
//总结一下吧： 
//String a=new String("abc");这样的问题没有什么意义，脱离上下文的环境本身就没有意思了。从上面的分析，我们得出两个结论，第一个结论，也就是StringDemo1 中的请求，此句产生两个对象，其中一个特殊的String对象在String常量池里，另外一个就是对象堆中的(这个普通的Java类一样) 
//第二个结论，也就是StringDemo2， 那一句只产生了一个对象，只有堆中的一个对象，因为上网已经产生了一个String常量对象，后面就不产生了，直接使用地址索引了。 
//String 是一个特殊的数据类型，说白了它是从简单到对象类型过渡的一种类型；它既有简单类型那样的快速又有对象类型的特性。对应String的不足，那么String家族里面已经有了补充的类，完善的类，StringBuffere 各位不用担心，StringBuffere完全面向对象了，怎么证明呢？很简单 
//String a=“abc”； 这样可以直接复制常量值个String类型的。就好像简单类型的可以使用字面量来直接初始化 一样。例如 int a=123; 
//StringBuffere a=“abc”； 这样就不行啦 
//
//最后的结论，1个或者2个 
//补充下：jvm 指令 可以参考 http://samwong.javaeye.com/blog/710737


