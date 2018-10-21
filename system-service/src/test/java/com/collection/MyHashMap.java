package com.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V>, Cloneable, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6857192270735746930L;

	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	static final int MAXIMUM_CAPACITY = 1 << 30;

	transient MyNode<K, V>[] table;
	transient int size;
	final float loadFactor;
	int threshold;
	transient int modCount;

	public MyHashMap()
	{
		this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
	}

	public MyHashMap(int initialCapacity)
	{
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int initialCapacity, float loadFactor)
	{
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		if (loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
		this.loadFactor = loadFactor;
		this.threshold = tableSizeFor(initialCapacity);
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public void clear()
	{
		MyNode<K, V>[] tab;
		modCount++;
		if ((tab = table) != null && size > 0)
		{
			size = 0;
			for (int i = 0; i < tab.length; ++i)
				tab[i] = null;
		}
	}
	
	@Override
	public boolean containsKey(Object key)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value)
	{
		MyNode<K, V>[] tab;
		V v;
		if ((tab = table) != null && size > 0)
		{
			for (int i = 0; i < tab.length; ++i)
			{
				for (MyNode<K, V> e = tab[i]; e != null; e = e.next)
				{
					if ((v = e.value) == value || (value != null && value.equals(v)))
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Set<K> keySet()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet()
	{
		// TODO Auto-generated method stub
		return null;
	}

	static final int tableSizeFor(int cap)
	{
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	public static void main(String[] args)
	{
		System.out.println(tableSizeFor(8));
	}
}
