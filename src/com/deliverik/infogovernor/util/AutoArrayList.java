package com.deliverik.infogovernor.util;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class AutoArrayList<T> extends ArrayList<T> {

	private Class<T> itemClass;

	public AutoArrayList(Class<T> itemClass) {
		this.itemClass = itemClass;
	}

	public T get(int index) {
		try {
			while (index >= size()) {
				add(itemClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.get(index);
	}
}