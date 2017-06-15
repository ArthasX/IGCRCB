package com.deliverik.infogovernor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * map按key值排序
 * @updateDateTime 2014/04/23 LuJiayuan
 * (1)使用通用范型减少代码重复
 */
public class MapKeySort<T> {

	/**
	 * 资产属性按ccategory排序展示tab页
	 * 默认升序排列
	 * @param map需要排序的Map
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
	 * 资产属性按ccategory排序展示tab页
	 * 升序还是倒序
	 * @param map需要排序的Map, asc升序排列还是倒序排列
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