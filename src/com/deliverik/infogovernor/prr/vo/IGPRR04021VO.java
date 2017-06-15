/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 一级菜单下的服务目录
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04021VO extends BaseVO {
	
	/** 数据 */
	protected Map<String, List<List<IGPRR04022VO>>> data;
	
	public IGPRR04021VO(Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap,List<IG380Info> processDefList){
		if(serviceCatalogMap != null){
			Map<String , IG380Info> pdMap = new HashMap<String, IG380Info>();
			if(processDefList != null){
				for(IG380Info pd:processDefList){
					pdMap.put(pd.getPdid(), pd);
				}
			}
			data = new LinkedHashMap<String, List<List<IGPRR04022VO>>>();
			Set<Entry<String, List<Map<CodeDetailDef, List<IG380Info>>>>> set = serviceCatalogMap.entrySet();
			for(Iterator<Entry<String, List<Map<CodeDetailDef, List<IG380Info>>>>> iter = set.iterator();iter.hasNext();){
				Entry<String, List<Map<CodeDetailDef, List<IG380Info>>>> next = iter.next();
				List<Map<CodeDetailDef,List<IG380Info>>> list = next.getValue();
				List<List<IGPRR04022VO>> dataList = new ArrayList<List<IGPRR04022VO>>();
				List<IGPRR04022VO> voListBuffer = new ArrayList<IGPRR04022VO>();
				int rcount = 1;
				for(Map<CodeDetailDef,List<IG380Info>> info:list){
					Set<Entry<CodeDetailDef, List<IG380Info>>> set2 = info.entrySet();
					for(Iterator<Entry<CodeDetailDef, List<IG380Info>>> iter2 = set2.iterator();iter2.hasNext();){
						Entry<CodeDetailDef, List<IG380Info>> next2 = iter2.next();
						CodeDetailDef key = next2.getKey();
						List<IG380Info> value = next2.getValue();
						List<IGPRR04022VO> voList = new ArrayList<IGPRR04022VO>();
						IGPRR04022VO vo = new IGPRR04022VO();
						vo.setTitle(key.getCvalue());
						List<IGPRR04023VO> pdList = new ArrayList<IGPRR04023VO>();
						for(int i=0;i<value.size();i++){
							if(i > 0 && i % 6 == 0){
								vo.setContent(pdList);
								voList.add(vo);
								vo = new IGPRR04022VO();
								vo.setIsShowTitle("0");
								pdList = new ArrayList<IGPRR04023VO>();
							}
							IGPRR04023VO pdVo = new IGPRR04023VO();
							pdVo.setPdinfo(value.get(i));
							if(pdMap.get(value.get(i).getPdid()) == null){
								pdVo.setIsapprove("0");
							}else{
								pdVo.setIsapprove("1");
							}
							pdList.add(pdVo);
						}
						vo.setContent(pdList);
						voList.add(vo);
						if(rcount%5 + voList.size() > 5){
							dataList.addAll(packagingVO(voListBuffer));
							voListBuffer = new ArrayList<IGPRR04022VO>();
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
	
	public List<List<IGPRR04022VO>> packagingVO(List<IGPRR04022VO> voList){
		List<List<IGPRR04022VO>> dataList = new ArrayList<List<IGPRR04022VO>>();
		List<IGPRR04022VO> temp = new ArrayList<IGPRR04022VO>();
		for(int i=0;i<voList.size();i++){
			if(i >0 && i%5 == 0){
				dataList.add(temp);
				temp = new ArrayList<IGPRR04022VO>();
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
	public Map<String, List<List<IGPRR04022VO>>> getData() {
		return data;
	}

	/**
	 * 数据设定
	 * @param data 数据
	 */
	public void setData(Map<String, List<List<IGPRR04022VO>>> data) {
		this.data = data;
	}
}
