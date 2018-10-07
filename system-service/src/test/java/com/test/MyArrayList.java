package com.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

public class MyArrayList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	protected transient int modCount = 0;
	transient Object[] elementData;
	private int size;

	public MyArrayList()
	{
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
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
	public boolean contains(Object o)
	{
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray()
	{
		return Arrays.copyOf(elementData, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a)
	{
		if (a.length < size)
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			for (int i = size; i < a.length; i++)
				a[i] = null;
		return a;
	}

	@Override
	public boolean add(E e)
	{
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
		return true;
	}

	private void ensureCapacityInternal(int minCapacity)
	{
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
		{
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity)
	{
		modCount++;
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity)
	{
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		if (newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private static int hugeCapacity(int minCapacity)
	{
		if (minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index)
	{
		rangeCheck(index);

		modCount++;
		E oldValue = (E) elementData[index];

		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		elementData[--size] = null; // clear to let GC do its work

		return oldValue;
	}

	@Override
	public boolean remove(Object o)
	{
		if (o == null)
		{
			for (int index = 0; index < size; index++)
				if (elementData[index] == null)
				{
					fastRemove(index);
					return true;
				}
		}
		else
		{
			for (int index = 0; index < size; index++)
				if (o.equals(elementData[index]))
				{
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	private void fastRemove(int index)
	{
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		elementData[--size] = null;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		for (Object o : c)
			remove(o);
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		for (Object e : c)
			if (!contains(e))
				return false;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityInternal(size + numNew); // Increments modCount
		System.arraycopy(a, 0, elementData, size, numNew);
		size += numNew;
		return numNew != 0;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c)
	{
		rangeCheckForAdd(index);

		Object[] a = c.toArray();
		int numNew = a.length;
		ensureCapacityInternal(size + numNew); // Increments modCount

		int numMoved = size - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew, numMoved);

		System.arraycopy(a, 0, elementData, index, numNew);
		size += numNew;
		return numNew != 0;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		Objects.requireNonNull(c);
		return batchRemove(c, true);
	}

	// 集合A比较与集合B的交集
	private boolean batchRemove(Collection<?> c, boolean complement)
	{
		// 获得当前对象的所有元素
		final Object[] elementData = this.elementData;
		// w：标记两个集合公共元素的个数
		int r = 0, w = 0;
		// 设置标志位
		boolean modified = false;
		try
		{
			// 遍历集合A
			for (; r < size; r++)
				// 判断集合B中是否包含集合A中的当前元素
				if (c.contains(elementData[r]) == complement)
					// 如果包含则直接保存。
					elementData[w++] = elementData[r];
		}
		finally
		{
			// 如果 c.contains() 抛出异常
			if (r != size)
			{
				// 复制剩余的元素
				System.arraycopy(elementData, r, elementData, w, size - r);
				// w为当前集合A的length
				w += size - r;
			}
			// 如果集合A的大小放生改变
			if (w != size)
			{
				// 清除工作
				for (int i = w; i < size; i++)
					elementData[i] = null;
				// 记录集合中元素的改变(add/remove)
				modCount += size - w;
				// 设置当前数组的大小
				size = w;
				// 返回为true
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear()
	{
		for (int i = 0; i < size; i++)
			elementData[i] = null;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index)
	{
		return (E) elementData[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element)
	{
		rangeCheck(index);
		E oldValue = (E) elementData[index];
		elementData[index] = element;
		return oldValue;
	}

	@Override
	public void add(int index, E element)
	{
		rangeCheckForAdd(index);
		ensureCapacityInternal(size + 1); // Increments modCount!!
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = element;
		size++;
	}

	@Override
	public int indexOf(Object o)
	{
		if (o == null)
		{
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		}
		else
		{
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o)
	{
		if (o == null)
		{
			for (int i = size - 1; i >= 0; i--)
				if (elementData[i] == null)
					return i;
		}
		else
		{
			for (int i = size - 1; i >= 0; i--)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex)
	{
		if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                                               ") > toIndex(" + toIndex + ")");
        
        List<E> le = this;
        final Object[] eData = this.elementData;
        elementData=DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        size = toIndex - fromIndex + 1;
        ensureCapacityInternal(size);
        System.arraycopy(eData, fromIndex, elementData, 0, size);
        
		return le;
	}

	private void rangeCheck(int index)
	{
		if (index >= size)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private void rangeCheckForAdd(int index)
	{
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index)
	{
		return "Index: " + index + ", Size: " + size;
	}
}
