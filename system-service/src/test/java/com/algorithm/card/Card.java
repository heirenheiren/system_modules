package com.algorithm.card;

/**
 * @Cardcom.card
 * @author 作者: perlin
 * @version 创建时间：2012-2-26 上午02:43:59
 */
public class Card
{

	public CardSuit suit; // 花色
	public int value; // 点数，1代表A，11代表J

	public Card(CardSuit suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		switch (suit)
		{
		case SPADE:
			sb.append("黑桃");
			break;
		case HEART:
			sb.append("红桃");
			break;
		case DIAMOND:
			sb.append("方片");
			break;
		case CLUB:
			sb.append("梅花");
			break;
		}

		switch (value)
		{
		case 1:
			sb.append('A');
			break;
		case 11:
			sb.append('J');
			break;
		case 12:
			sb.append('Q');
			break;
		case 13:
			sb.append('K');
			break;
		default:
			sb.append(value);
		}
		return sb.toString();
	}
}
