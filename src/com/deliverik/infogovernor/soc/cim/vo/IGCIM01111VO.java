/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.asset.vo.IGCIM01112VO;
import com.deliverik.infogovernor.soc.cim.bl.IGRAWCIType;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 配置源数据版本比较vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM01111VO extends BaseVO{

	/** 设备基本信息 */
	protected SOC0118Info entityItem;
	
	/** 标题集合 */
	protected List<String> titleList;
	
	/** 显示数据 */
	protected Map<String, List<IGCIM01112VO>> data;
	
	/** 采集结果分类集合 */
	protected Map<String, List<String>> categorys;
	
	/**采集文件名*/
	protected String host;
	
	
	/**
	 * 构造方法
	 */
	public IGCIM01111VO(){
		
	}
	
	/**
	 * 构造方法
	 */
	public IGCIM01111VO(Map<String, List<CR01VWInfo>> crMap){
		if(crMap!=null){
			if(titleList==null){
				//改变数据结构
				Map<String, Map<String, List<CR01VWInfo>>> dataMap = new LinkedHashMap<String, Map<String,List<CR01VWInfo>>>();
				String[] title = new String[crMap.size()];
				int index = 0;
				for(String key:crMap.keySet()){
					title[index] = key;
					index++;
					for(CR01VWInfo cr01:crMap.get(key)){
						if(dataMap.get(cr01.getCommand())==null){
							List<CR01VWInfo> tempList = new ArrayList<CR01VWInfo>();
							tempList.add(cr01);
							Map<String, List<CR01VWInfo>> tempMap = new HashMap<String, List<CR01VWInfo>>();
							tempMap.put(key, tempList);
							dataMap.put(cr01.getCommand(), tempMap);
						}else{
							if(dataMap.get(cr01.getCommand()).get(key)==null){
								List<CR01VWInfo> tempList = new ArrayList<CR01VWInfo>();
								tempList.add(cr01);
								dataMap.get(cr01.getCommand()).put(key, tempList);
							}else{
								dataMap.get(cr01.getCommand()).get(key).add(cr01);
							}
						}
					}
				}
				Arrays.sort(title);
				//处理标题
				titleList = new ArrayList<String>();
				categorys = new LinkedHashMap<String, List<String>>();
				titleList.add("配置类别");
				titleList.add("关键字");
				titleList.add("采集命令");
				for(String s:title){
					titleList.add(s);
				}
				//处理数据
				data = new LinkedHashMap<String, List<IGCIM01112VO>>();
				for(String key:dataMap.keySet()){
					IGCIM01112VO vo = new IGCIM01112VO();
					vo.setCommand(key);
					//取得被比较数据
					List<CR01VWInfo> list1 = dataMap.get(key).get(title[0]);
					if(list1!=null&&list1.size()>0){
						vo.setCategory(IGRAWCIType.getKeys(list1.get(0).getCategory()));
						vo.setKeys(IGRAWCIType.getKeys(list1.get(0).getKeys()));
					}else{
						vo.setCategory("");
						vo.setKeys("");
					}
					//比较数据取得
					List<CR01VWInfo> list2 = dataMap.get(key).get(title[1]);
					
					//判断内容
					Map<Integer, CR01VWInfo> map1 = new HashMap<Integer, CR01VWInfo>();
					Map<Integer, CR01VWInfo> map2 = new HashMap<Integer, CR01VWInfo>();
					if(list1!=null&&list1.size()>0){
						for(CR01VWInfo cr:list1){
							map1.put(cr.getCdataorder(), cr);
						}
					}
					if(list2!=null&&list2.size()>0){
						for(CR01VWInfo cr:list2){
							map2.put(cr.getCdataorder(), cr);
						}
					}
					
					//设置被比较数据
					if(list1!=null&&list1.size()>0){
						if(list1.size()>1){
							vo.setCompare1(map1.get(list1.get(0).getCdataorder()).getCdata()+"... ...");
						}else{
							if (map1.get(0) != null) {
								vo.setCompare1(map1.get(0).getCdata());
							} else {
								vo.setCompare1(map1.get(1).getCdata());
							}
						}
					}else{
						vo.setCompare1("");
					}
					//设置比较数据
					if(list2!=null&&list2.size()>0){
						if(list2.size()>1){
							vo.setCompare2(map2.get(list2.get(0).getCdataorder()).getCdata()+"... ...");
						}else{
							if (map2.get(0) != null) {
								vo.setCompare2(map2.get(0).getCdata());
							} else {
								vo.setCompare2(map2.get(1).getCdata());
							}
						}
					}else{
						vo.setCompare2("");
					}
					//比较数据结果
					boolean flag = false;
					
					//如果被比较数据和比较数据都为空，则不必再比较
					if((list1==null||list1.isEmpty())&&(list2==null||list2.isEmpty())){
						continue;
					}
					
					//判断被比较数据数量上的差异
					if(((list1==null||list1.isEmpty())!=(list2==null||list2.isEmpty()))||(list1.size()!=list2.size())){
						flag = true;
					}else{
						for(Integer order:map1.keySet()){
							if(map2.get(order)==null){
								flag = true;
								break;
							}else{
								if(!map1.get(order).getCdata().equals(map2.get(order).getCdata())){
									flag = true;
									vo.setCompare1(map1.get(order).getCdata()+(map1.size()>1?"... ...":""));
									vo.setCompare2(map2.get(order).getCdata()+(map2.size()>1?"... ...":""));
									break;
								}
							}
						}
					}
					if (flag) {
						vo.setCompareStyle(" background:#ffff99;");
					}
					String mapKey = vo.getCategory();
					//封装数据
					if(data.get(mapKey)==null){
						List<IGCIM01112VO> datatemplist = new ArrayList<IGCIM01112VO>();
						datatemplist.add(vo);
						data.put(mapKey, datatemplist);
					}else{
						data.get(mapKey).add(vo);
					}
					
					//封装category信息
					String category = vo.getCategory();
					String[] keys = vo.getKeys()==null?null:vo.getKeys().split(",");
					if(categorys.get(category)==null){
						if(keys==null){
							categorys.put(category, new ArrayList<String>());
						}else{
							List<String> keysList = new ArrayList<String>();
							for(String s:keys){
								keysList.add(s);
							}
							categorys.put(category, keysList);
						}
					}else{
						if(keys!=null){
							for(String s:keys){
								if(!categorys.get(category).contains(s)){
									categorys.get(category).add(s);
								}
							}
						}
					}
				}
				
			}
		}
	}

	/**
	 * 设备基本信息取得
	 * @return 设备基本信息
	 */
	public SOC0118Info getEntityItem() {
		return entityItem;
	}

	/**
	 * 设备基本信息设定
	 * @param entityItem 设备基本信息
	 */
	public void setEntityItem(SOC0118Info entityItem) {
		this.entityItem = entityItem;
	}

	/**
	 * 标题集合取得
	 * @return 标题集合
	 */
	public List<String> getTitleList() {
		return titleList;
	}

	/**
	 * 标题集合设定
	 * @param titleList 标题集合
	 */
	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	/**
	 * 显示数据取得
	 * @return 显示数据
	 */
	public Map<String, List<IGCIM01112VO>> getData() {
		return data;
	}

	/**
	 * 显示数据设定
	 * @param data 显示数据
	 */
	public void setData(Map<String, List<IGCIM01112VO>> data) {
		this.data = data;
	}
	
	/**
	 * 采集结果分类集合取得
	 * @return 采集结果分类集合
	 */
	public Map<String, List<String>> getCategorys() {
		return categorys;
	}

	/**
	 * 采集结果分类集合设定
	 * @param categorys 采集结果分类集合
	 */
	public void setCategorys(Map<String, List<String>> categorys) {
		this.categorys = categorys;
	}

	/**
	 * 采集文件名取得
	 *
	 * @return host 采集文件名
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * 采集文件名设定
	 *
	 * @param host 采集文件名
	 */
	
	public void setHost(String host) {
		this.host = host;
	}
	
	
	
}
