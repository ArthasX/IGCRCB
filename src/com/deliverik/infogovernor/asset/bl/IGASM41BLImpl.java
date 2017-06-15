/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.bl.task.CheckVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM41DTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckVWCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCondImpl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计业务逻辑实现
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGASM41BLImpl extends BaseBLImpl implements IGASM41BL {
	
	static Log log = LogFactory.getLog(IGASM41BLImpl.class);
	
	/** 风险检查统计(风险)BL */
	protected CheckVWBL checkVWBL;
	
	/** 风险检查统计(检查)BL */
	protected RiskVWBL riskVWBL;

	/**
	 * 风险检查统计(风险)BL设定
	 * @param checkVWBL 风险检查统计(风险)BL
	 */
	public void setCheckVWBL(CheckVWBL checkVWBL) {
		this.checkVWBL = checkVWBL;
	}

	/**
	 * 风险检查统计(检查)BL设定
	 * @param riskVWBL 风险检查统计(检查)BL
	 */
	public void setRiskVWBL(RiskVWBL riskVWBL) {
		this.riskVWBL = riskVWBL;
	}

	public IGASM41DTO searchEntityItemAction(IGASM41DTO dto) throws BLException {
		log.debug("========风险检查统计查询处理开始========");
		//风险查询条件
		RiskVWCondImpl riskCond = new RiskVWCondImpl();
		//查询风险信息列表
		List<RiskVWInfo> riskList = riskVWBL.findByCond(riskCond);
		if(!riskList.isEmpty()){
			//将riskList装进Map
			TreeMap<String,List<RiskVWInfo>> riskMap = new TreeMap<String,List<RiskVWInfo>>();
			for(RiskVWInfo risk:riskList ){
				if(riskMap.containsKey(risk.getSyscoding())){
					List<RiskVWInfo> list = riskMap.get(risk.getSyscoding());
					list.add(risk);
					riskMap.put(risk.getSyscoding(), list);
				}else{
					List<RiskVWInfo> list = new ArrayList<RiskVWInfo>();
					list.add(risk);
					riskMap.put(risk.getSyscoding(), list);
				}
			}
			//拼接多个syscoding
			StringBuffer sb = new StringBuffer();
			for(String key:riskMap.keySet()){
				sb.append(key).append(",");
			}
			//将checkList装进Map
			TreeMap<String,List<CheckVWInfo>> checkMap = new TreeMap<String,List<CheckVWInfo>>();
			if(StringUtils.isNotEmpty(sb.toString())){
				//检查查询条件
				CheckVWCondImpl checkCond = new CheckVWCondImpl();
				checkCond.setSyscoding(sb.toString().substring(0, sb.length()-1));
				//查询检查信息列表
				List<CheckVWInfo> checkList = checkVWBL.findByCond(checkCond);
				for(CheckVWInfo check:checkList ){
					if(checkMap.containsKey(check.getSyscoding())){
						List<CheckVWInfo> list = checkMap.get(check.getSyscoding());
						list.add(check);
						checkMap.put(check.getSyscoding(), list);
					}else{
						List<CheckVWInfo> list = new ArrayList<CheckVWInfo>();
						list.add(check);
						checkMap.put(check.getSyscoding(), list);
					}
				}
			}
			//将riskMap和checkMap对应装进riskCheckMap
			LinkedHashMap<List<RiskVWInfo>,List<CheckVWInfo>> riskCheckMap = new LinkedHashMap<List<RiskVWInfo>,List<CheckVWInfo>>();
			for(String key:riskMap.keySet()){
				if(checkMap.containsKey(key)){
					riskCheckMap.put(riskMap.get(key), checkMap.get(key));
				}else{
					riskCheckMap.put(riskMap.get(key), null);
				}
			}
			dto.setRiskCheckMap(riskCheckMap);
		}
		log.debug("========风险检查统计查询处理终了========");
		return dto;
	}

}
