package com.deliverik.framework.dao.jdbc;

import java.util.*;

@SuppressWarnings("rawtypes")
class IndexedMapImpl extends HashMap implements IndexedMap {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6026766828373059492L;
	private List<Object> values = null;

	public IndexedMapImpl() {
		this(100);
	}

	public IndexedMapImpl(int initialCapacity) {
		super(initialCapacity);
		values = new ArrayList<Object>(initialCapacity);
	}

	@SuppressWarnings("unchecked")
	public Object put(String key, Object value) {
		Object result = null;

		result = super.put(key, value);
		values.add(value);

		return result;
	}

	public Object remove(Object key) {
		Object result = null;

		result = super.remove(key);
		values.remove(key);

		return result;
	}

	public Object get(int i) {
		return values.get(i);
	}

	public Iterator<Object> iterator() {
		return values.iterator();
	}
}
