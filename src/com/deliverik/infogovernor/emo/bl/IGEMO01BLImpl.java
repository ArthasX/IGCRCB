/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.emo.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.emo.bl.task.EmBL;
import com.deliverik.infogovernor.emo.dto.IGEMO01DTO;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor oracle性能监控
 * </p>
 * <p>
 * Description: oracle性能监控_BL
 * </p>
 * @version 
 */
public class IGEMO01BLImpl extends BaseBLImpl implements IGEMO01BL {
	
	static Log log = LogFactory.getLog(IGEMO01BLImpl.class);

	/** oracle性能监控BL */
	protected EmBL emBL;
	
	/** 配置项信息BL */
	protected SOC0118BL soc0118BL;

	/**
	 * oracle性能监控BL设定
	 * @param emBL oracle性能监控BL
	 */
	public void setEmBL(EmBL emBL) {
		this.emBL = emBL;
	}

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * oracle性能监控处理
	 *
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 */
	public IGEMO01DTO getEmData(IGEMO01DTO dto) throws BLException {
		log.debug("========oracle性能监控处理开始========");
		//查询出资产的Eilabel
		SOC0118Info soc0118info = soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getEiid()));
		
		EmSearchCondImpl cond = new EmSearchCondImpl();
		cond.setEm_type(dto.getEm_type());
		cond.setFingerprint(soc0118info.getEilabel());
		cond.setMax_collecttime("1");
		cond.setOrder_Totail_desc("1");
		List<EmInfo> reslist = emBL.searchEm(cond);
		String sid = "";
		List<String> categories = new ArrayList<String>();
		Map<String, EmInfo> categoriesMap = new LinkedHashMap<String, EmInfo>();
		Map<String, Map<String,Object>> seriesMap = new LinkedHashMap<String, Map<String,Object>>();
		List<Map<String,String>> info = new ArrayList<Map<String,String>>();
		for(EmInfo embean:reslist){
			sid = embean.getFingerPrint();
			Map<String,String> infobean = new HashMap<String, String>();
			infobean.put("td1", embean.getEm_Totail());
			if("1".equals(dto.getEm_type())){
				categories.add(embean.getEm_sqlid());
				categoriesMap.put(embean.getEm_sqlid(), embean);
				infobean.put("td2", embean.getEm_sqltype());
				infobean.put("td3", embean.getEm_sqlcontent());
			}else{
				categories.add(embean.getEm_sessionid());
				categoriesMap.put(embean.getEm_sessionid(), embean);
				infobean.put("td2", embean.getEm_username());
				infobean.put("td3", embean.getEm_program());
			}
			info.add(infobean);
			if(!"0".equals(embean.getEm_other())){
				if(seriesMap.get("other")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "other");
					seriesMap.put("other", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_network())){
				if(seriesMap.get("network")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "network");
					seriesMap.put("network", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_Queueing())){
				if(seriesMap.get("Queueing")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "Queueing");
					seriesMap.put("Queueing", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_Idle())){
				if(seriesMap.get("Idle")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "Idle");
					seriesMap.put("Idle", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_Cluster())){
				if(seriesMap.get("Cluster")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "Cluster");
					seriesMap.put("Cluster", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_administrative())){
				if(seriesMap.get("administrative")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "administrative");
					seriesMap.put("administrative", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_configuraction())){
				if(seriesMap.get("configuraction")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "configuraction");
					seriesMap.put("configuraction", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_commit())){
				if(seriesMap.get("commit")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "commit");
					seriesMap.put("commit", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_application())){
				if(seriesMap.get("application")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "application");
					seriesMap.put("application", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_concurrency())){
				if(seriesMap.get("concurrency")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "concurrency");
					seriesMap.put("concurrency", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_systemIO())){
				if(seriesMap.get("systemIO")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "systemIO");
					seriesMap.put("systemIO", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_userIO())){
				if(seriesMap.get("userIO")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "userIO");
					seriesMap.put("userIO", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_scheduler())){
				if(seriesMap.get("scheduler")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "scheduler");
					seriesMap.put("scheduler", seriesBean);
				}
			}
			if(!"0".equals(embean.getEm_cpu())){
				if(seriesMap.get("cpu")==null){
					Map<String, Object> seriesBean = new HashMap<String, Object>();
					seriesBean.put("name", "cpu");
					seriesMap.put("cpu", seriesBean);
				}
			}
		}
		List<Map<String,Object>> seriesList = new ArrayList<Map<String,Object>>();
		List<String> colors = new ArrayList<String>();
		for(String seriesName:seriesMap.keySet()){
			List<Float> seriesData = new ArrayList<Float>();
			for(String categorie:categories){
				if("other".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_other()));
				}else if("network".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_network()));
				}else if("Queueing".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_Queueing()));
				}else if("Idle".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_Idle()));
				}else if("Cluster".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_Cluster()));
				}else if("administrative".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_administrative()));
				}else if("configuraction".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_configuraction()));
				}else if("commit".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_commit()));
				}else if("application".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_application()));
				}else if("concurrency".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_concurrency()));
				}else if("systemIO".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_systemIO()));
				}else if("userIO".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_userIO()));
				}else if("scheduler".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_scheduler()));
				}else if("cpu".equals(seriesName)){
					seriesData.add(Float.parseFloat(categoriesMap.get(categorie).getEm_cpu()));
				}
			}
			
			if("other".equals(seriesName)){
				colors.add("#FF6699");
			}else if("network".equals(seriesName)){
				colors.add("#9F9371");
			}else if("Queueing".equals(seriesName)){
				colors.add("#C2B79B");//????
			}else if("Idle".equals(seriesName)){
				colors.add("#99FF66");//????
			}else if("Cluster".equals(seriesName)){
				colors.add("#9966FF");//????
			}else if("administrative".equals(seriesName)){
				colors.add("#666666");
			}else if("configuraction".equals(seriesName)){
				colors.add("#663300");
			}else if("commit".equals(seriesName)){
				colors.add("#CC6600");
			}else if("application".equals(seriesName)){
				colors.add("#CC3300");
			}else if("concurrency".equals(seriesName)){
				colors.add("#993300");
			}else if("systemIO".equals(seriesName)){
				colors.add("#0099FF");
			}else if("userIO".equals(seriesName)){
				colors.add("#0033FF");
			}else if("scheduler".equals(seriesName)){
				colors.add("#99FF99");
			}else if("cpu".equals(seriesName)){
				colors.add("#00CC00");
			}
			
			Map<String,Object> seriesBean = seriesMap.get(seriesName);
			seriesBean.put("data", seriesData);
			seriesList.add(seriesBean);
		}
		
		Map<String,Object> emData = new HashMap<String, Object>();
		emData.put("categories", categories);
		emData.put("series", seriesList);
		emData.put("info", info);
		emData.put("colors", colors);
		emData.put("sid", sid);
		dto.setEmData(emData);
		log.debug("========oracle性能监控处理终了========");
		return dto;
	}
}
