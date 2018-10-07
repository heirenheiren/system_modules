package com.algorithm.card;

import java.util.Random;

/**
 * @Cardcom.card
 * @author 作者: perlin
 * @version 创建时间：2012-2-26 上午02:45:13
 */
// 纸牌的花色，分别是：黑桃，红心，方片，梅花
enum CardSuit
{
	SPADE, HEART, DIAMOND, CLUB
};

// 52张牌，没有大小王
public class Cards
{

	public Cards()
	{
		cards = new Card[52];
		int index = 0;
		for (CardSuit suit : CardSuit.values())
		{
			for (int i = 1; i <= 13; i++)
				cards[index++] = new Card(suit, i);
		}
	}

	public void showCards()
	{
		for (Card c : cards)
		{
			System.out.print(c);
			System.out.print("  ");
		}
		System.out.println();
	}

	// 洗牌
	public void shuffle()
	{
		Card[] target = new Card[52];
		int i = 0, j = 26, index = 0, n;
		Random rand = new Random();
		// 交错式洗牌
		while (index < 52)
		{
			n = rand.nextInt(3) + 1;
			while (n > 0 && i < 26)
			{
				target[index++] = cards[i++];
				n--;
			}
			n = rand.nextInt(3) + 1;
			while (n > 0 && j < 52)
			{
				target[index++] = cards[j++];
				n--;
			}
		}

		// 切牌，把下半部分和上半部分互换位置
		n = rand.nextInt(10) + 20;
		for (i = 0; i < 52; i++)
		{
			cards[i] = target[(n + i) % 52];
		}
	}

	private Card[] cards;
}