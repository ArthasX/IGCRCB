/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务目录显示vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04011VO extends BaseVO{

	/** 服务目录显示数据 */
	protected Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap;
	
	/** 服务目录一级分类 */
	protected List<CodeDetailDef> serviceCatalogFirstClassify;
	
	/** 数据 */
	protected Map<String, List<List<IGPRR04012VO>>> data;

	/**
	 * 服务目录一级分类取得
	 * @return serviceCatalogFirstClassify 服务目录一级分类
	 */
	public List<CodeDetailDef> getServiceCatalogFirstClassify() {
		return serviceCatalogFirstClassify;
	}

	/**
	 * 服务目录一级分类设定
	 * @param serviceCatalogFirstClassify 服务目录一级分类
	 */
	public void setServiceCatalogFirstClassify(
			List<CodeDetailDef> serviceCatalogFirstClassify) {
		this.serviceCatalogFirstClassify = serviceCatalogFirstClassify;
	}

	/**
	 * 服务目录显示数据取得
	 * @return serviceCatalogMap 服务目录显示数据
	 */
	public Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> getServiceCatalogMap() {
		return serviceCatalogMap;
	}

	/**
	 * 服务目录显示数据设定
	 * @param serviceCatalogMap 服务目录显示数据
	 */
	public void setServiceCatalogMap(Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap) {
		this.serviceCatalogMap = serviceCatalogMap;
		if(serviceCatalogMap != null){
			data = new LinkedHashMap<String, List<List<IGPRR04012VO>>>();
			Set<Entry<String, List<Map<CodeDetailDef, List<IG380Info>>>>> set = serviceCatalogMap.entrySet();
			for(Iterator<Entry<String, List<Map<CodeDetailDef, List<IG380Info>>>>> iter = set.iterator();iter.hasNext();){
				Entry<String, List<Map<CodeDetailDef, List<IG380Info>>>> next = iter.next();
				List<Map<CodeDetailDef,List<IG380Info>>> list = next.getValue();
				List<List<IGPRR04012VO>> dataList = new ArrayList<List<IGPRR04012VO>>();
				List<IGPRR04012VO> voListBuffer = new ArrayList<IGPRR04012VO>();
				int rcount = 1;
				for(Map<CodeDetailDef,List<IG380Info>> info:list){
					Set<Entry<CodeDetailDef, List<IG380Info>>> set2 = info.entrySet();
					for(Iterator<Entry<CodeDetailDef, List<IG380Info>>> iter2 = set2.iterator();iter2.hasNext();){
						Entry<CodeDetailDef, List<IG380Info>> next2 = iter2.next();
						CodeDetailDef key = next2.getKey();
						List<IG380Info> value = next2.getValue();
						List<IGPRR04012VO> voList = new ArrayList<IGPRR04012VO>();
						IGPRR04012VO vo = new IGPRR04012VO();
						vo.setTitle(key.getCvalue());
						List<IG380Info> pdList = new ArrayList<IG380Info>();
						for(int i=0;i<value.size();i++){
							if(i > 0 && i % 6 == 0){
								vo.setContent(pdList);
								voList.add(vo);
								vo = new IGPRR04012VO();
								vo.setIsShowTitle("0");
								pdList = new ArrayList<IG380Info>();
							}
							pdList.add(value.get(i));
						}
						vo.setContent(pdList);
						voList.add(vo);
						if(rcount%5 + voList.size() > 5){
							dataList.addAll(packagingVO(voListBuffer));
							voListBuffer = new ArrayList<IGPRR04012VO>();
						}
						voListBuffer.addAll(voList);
						rcount = voListBuffer.size();
					}
					
				}
				if(voListBuffer.size() > 0){
					dataList.addAll(packagingVO(voListBuffer));
				}
				data.put(next.getKey(), dataList);
			}
			
		}
	}
	
	public List<List<IGPRR04012VO>> packagingVO(List<IGPRR04012VO> voList){
		List<List<IGPRR04012VO>> dataList = new ArrayList<List<IGPRR04012VO>>();
		List<IGPRR04012VO> temp = new ArrayList<IGPRR04012VO>();
		for(int i=0;i<voList.size();i++){
			if(i >0 && i%5 == 0){
				dataList.add(temp);
				temp = new ArrayList<IGPRR04012VO>();
			}
			temp.add(voList.get(i));
		}
		if(temp.size() > 0){
			dataList.add(temp);
		}
		return dataList;
	}

	/**
	 * 数据取得
	 * @return data 数据
	 */
	public Map<String, List<List<IGPRR04012VO>>> getData() {
		return data;
	}

	/**
	 * 数据设定
	 * @param data 数据
	 */
	public void setData(Map<String, List<List<IGPRR04012VO>>> data) {
		this.data = data;
	}
	
}
