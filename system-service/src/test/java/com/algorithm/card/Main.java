package com.algorithm.card;
/** 
* @Cardcom.card
* @author 作者: perlin
* @version 创建时间：2012-2-26 上午02:46:28
*/ 
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cards cards = new Cards();
		cards.showCards();
		cards.shuffle();
		cards.shuffle();
		cards.shuffle();
		cards.shuffle();
		cards.shuffle();
		cards.showCards();
	}
}
