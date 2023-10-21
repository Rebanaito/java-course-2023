package edu.hw3;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ReverseIterator<T> implements Iterator<T> {
	public ReverseIterator(List<T> list) {
		this.internalIterator = list.listIterator(list.size());
	}

	private final ListIterator<T> internalIterator;

	@Override
	public boolean hasNext() {
		return internalIterator.hasPrevious();
	}

	@Override
	public T next() {
		return internalIterator.previous();
	}
}