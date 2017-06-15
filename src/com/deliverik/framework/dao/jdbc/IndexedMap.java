package com.deliverik.framework.dao.jdbc;

import java.util.Map;

@SuppressWarnings("rawtypes")
interface IndexedMap extends Map {
	public Object get(int i);
}
