package com.deliverik.infogovernor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * map��keyֵ����
 * @updateDateTime 2014/04/23 LuJiayuan
 * (1)ʹ��ͨ�÷��ͼ��ٴ����ظ�
 */
public class MapKeySort<T> {

	/**
	 * �ʲ����԰�ccategory����չʾtabҳ
	 * Ĭ����������
	 * @param map��Ҫ�����Map
	 */
	public Map<String, T> sort(Map<String, T> map) {
		Map<String, T> retMap = new LinkedHashMap<String, T>();
		if(map == null){
			return retMap;
		}
		Set<String> keySet = map.keySet();
		List<String> list = new ArrayList<String>();
		list.addAll(keySet);
		Collections.sort(list);
		for(String key : list){
			retMap.put(key, map.get(key));
		}
//		Iterator<String> iterator = map.keySet().iterator();
//		while(iterator.hasNext()){
//			Collections.reverse(map.get(iterator.next()));
//		}
		
		return retMap;
	}
	
	/**
	 * �ʲ����԰�ccategory����չʾtabҳ
	 * �����ǵ���
	 * @param map��Ҫ�����Map, asc�������л��ǵ�������
	 */
	public Map<String, T> sort(Map<String, T> map, boolean asc) {
		Map<String, T> retMap = new LinkedHashMap<String, T>();
		if(map == null){
			return retMap;
		}
		Set<String> keySet = map.keySet();
		List<String> list = new ArrayList<String>();
		list.addAll(keySet);
		Collections.sort(list);
		if(!asc){
			Collections.reverse(list);
		}
		for(String key : list){
			retMap.put(key, map.get(key));
		}
		return retMap;
	}
}