/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.soc.cim.bl.IGRAWCIType;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.entity.CR01VW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:配置原数据显示vo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM01101VO extends BaseVO{

	/** 设备被基本信息 */
	protected SOC0118Info entityItem;
	
	/** 原数据索引集合 */
	protected List<CR03Info> cr03List;
	
	/** 采集记录版本信息 */
	protected CR03Info cr03;
	
	/** 采集记录版本信息(新) */
	protected CR03VWInfo cr03VW;
	
	/** 采集结果集合 */
	protected List<CR01VWInfo> cr01List;
	
	/** 显示标识 */
	protected String showFlag;
	
	/** 其他页面跳转返回 */
	protected String otherFlag;

	/** 数据展现map */
	protected Map<String, Map<String, CR01VWInfo>> dataMap =new LinkedHashMap<String, Map<String,CR01VWInfo>>();
	
	/** 采集结果分类集合 */
	protected Map<String, List<String>> categorys;
	
	/**采集文件名字*/
	protected String host;
	
	/** 采集版本列表 */
	protected List<CR03VWInfo> cr03VWList;	
	
	
	
	public List<CR03VWInfo> getCr03VWList() {
		return cr03VWList;
	}

	public void setCr03VWList(List<CR03VWInfo> cr03VWList) {
		this.cr03VWList = cr03VWList;
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
	 *  原数据索引集合取得
	 * @return  原数据索引集合
	 */
	public List<CR03Info> getCr03List() {
		return cr03List;
	}

	/**
	 *  原数据索引集合设定
	 * @param cr03List  原数据索引集合
	 */
	public void setCr03List(List<CR03Info> cr03List) {
		this.cr03List = cr03List;
	}
	
	/**
	 * 采集记录版本信息取得
	 * @return 采集记录版本信息
	 */
	public CR03Info getCr03() {
		return cr03;
	}

	/**
	 * 采集记录版本信息设定
	 * @param cr03 采集记录版本信息
	 */
	public void setCr03(CR03Info cr03) {
		this.cr03 = cr03;
	}

	/**
	 * 采集结果集合取得
	 * @return 采集结果集合
	 */
	public List<CR01VWInfo> getCr01List() {
		return cr01List;
	}

	/**
	 * 采集结果集合取得设定
	 * @param cr01List 采集结果集合取得
	 */
	public void setCr01List(List<CR01VWInfo> cr01List) {
		this.cr01List = cr01List;
		if(cr01List!=null){
			if(this.dataMap == null||this.dataMap.size()==0){
				dataMap = new LinkedHashMap<String, Map<String, CR01VWInfo>>();
				categorys = new LinkedHashMap<String, List<String>>();
				for(CR01VWInfo cr01Info:cr01List){
					/*--------封装显示数据信息-------*/
					String key = IGRAWCIType.getCategory(cr01Info.getCategory());
					CR01VW cr01 = (CR01VW) SerializationUtils.clone(cr01Info);
					cr01.setKeys(IGRAWCIType.getKeys(cr01Info.getKeys()));
					if(dataMap.get(key)==null){
						Map<String, CR01VWInfo> tempmap = new LinkedHashMap<String, CR01VWInfo>();
						tempmap.put(cr01.getCommand(), cr01);
						dataMap.put(key, tempmap);
					}else{
						if(dataMap.get(key).get(cr01.getCommand())==null){
							dataMap.get(key).put(cr01.getCommand(), cr01);
						}else{
							String data = dataMap.get(key).get(cr01.getCommand()).getCdata();
							if(StringUtils.isNotEmpty(data)&&!"null".equals(data)&&(data.length()<8||!"... ...".equals(data.substring(data.length()-7)))){
								CR01VW cr = (CR01VW) SerializationUtils.clone(dataMap.get(key).get(cr01.getCommand()));
								cr.setCdata(data+"... ...");
								dataMap.get(key).put(cr01.getCommand(), cr);
							}
						}
					}
					/*--------封装分类信息-------*/
					String[] keys = StringUtils.isNotEmpty(cr01.getKeys())? cr01.getKeys().split(","):null;
					if(categorys.get(key)==null){
						if(keys!=null){
							List<String> keyList = new ArrayList<String>();
							for(String s:keys){
								keyList.add(s);
								categorys.put(key, keyList);
							}
						}else{
							categorys.put(key, null);
						}
					}else{
						List<String> list = categorys.get(key);
						if(keys!=null){
							for(String s:keys){
								if(!list.contains(s)){
									list.add(s);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 显示标识取得
	 * @return 显示标识
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * 显示标识设定
	 * @param showFlag 显示标识
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	
	/**
	 * 数据展现map取得
	 * @return 数据展现map
	 */
	public Map<String,Map<String, CR01VWInfo>> getDataMap() {
		return dataMap;
	}

	/**
	 * 设定
	 * @param dataMap 数据展现map
	 */
	public void setDataMap(Map<String, Map<String, CR01VWInfo>> dataMap) {
		this.dataMap = dataMap;
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
	 * 采集结果查询页面跳转返回取得
	 * @return 采集结果查询页面跳转返回
	 */
	public String getOtherFlag() {
		return otherFlag;
	}
	/**
	 * 采集结果查询页面跳转返回设定
	 * @return 采集结果查询页面跳转返回
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * 采集文件名字取得
	 *
	 * @return host 采集文件名字
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * 采集文件名字设定
	 *
	 * @param host 采集文件名字
	 */
	
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * 采集记录版本信息取得
	 * @return
	 */
	public CR03VWInfo getCr03VW() {
		return cr03VW;
	}
	
	/**
	 * 采集记录版本信息设定
	 * @param cr03VW
	 */
	public void setCr03VW(CR03VWInfo cr03VW) {
		this.cr03VW = cr03VW;
	}
	
}
