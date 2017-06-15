package com.deliverik.infogovernor.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCondImpl;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;

public class ProcessStatusValueBean {
	
	/** 记录日志 */
	private static Log log = LogFactory.getLog(ProcessStatusValueBean.class);
	
	/** 系统参数信息 */
	private static Map<String, String> prtypeValueMap = new HashMap<String, String>();
	
	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private ProcessStatusValueBean() {

	}

	/**
	 * <p>
	 * Description: 根据流程id查询相关流程状态
	 * </p>
	 * 
	 * @param key
	 * @return String
	 */
	public static String getProcessStatus(String prid) {
		log.debug("根据流程id查询相关流程状态开始");
		
		String status="";
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		IG512SearchCondImpl prrCond = new IG512SearchCondImpl();
		prrCond.setParprid(Integer.valueOf(prid));
		List<IG512Info> processRecordRelationList = workFlowOperationBL.searchProcessRecordRelation(prrCond);//主动
		prrCond.setParprid(null);
		prrCond.setCldprid(Integer.valueOf(prid));
		processRecordRelationList.addAll(workFlowOperationBL.searchProcessRecordRelation(prrCond));//被动
		
		if(processRecordRelationList!=null&&processRecordRelationList.size()>0){
			IG512Info info = processRecordRelationList.get(0);
			IG500Info process=null;
			//取得相关流程
			if(prid.equals(info.getParprid().toString())){
				process = info.getCldProcess();
			}else{
				process = info.getParProcess();
			}
			
			if(process!=null){
				String prpdid = process.getPrpdid();
				String prstatus = process.getPrstatus();
				
				status = getConfigInfo(prpdid,prstatus);
			}
		}
		
		log.debug("根据流程id查询相关流程状态结束");
		
		return status;
	}

	/**
	 * <p>
	 * Description: 获取参数信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 */
	public static String getConfigInfo(String pdid,String psdcode) {
		String key = String.valueOf(pdid)+"_"+psdcode;
		if (prtypeValueMap != null && !prtypeValueMap.isEmpty()) {
			if(prtypeValueMap.get(key)==null || "".equals(prtypeValueMap.get(key))){
				init(pdid,psdcode);
				return (String) prtypeValueMap.get(key);
			}else{
				return (String) prtypeValueMap.get(key);
			}
		}else{
			init(pdid,psdcode);
			return (String) prtypeValueMap.get(key);
		}

	}
	
	/**
	 * <p>
	 * Discription:初始化参数map
	 * </p>
	 * 
	 */
	public static void init(String pdid,String psdcode) {

		log.debug("＝＝＝＝＝＝自定义流程状态名取得开始＝＝＝＝＝＝");
		// 取出单位系统配置参数
		
		IGPRD01BL prdBL = (IGPRD01BL) WebApplicationSupport.getBean("igPRD01BL");
		String type_name = prdBL.getPsNameByPdidAndPsdidAction(pdid,psdcode);
		String key = String.valueOf(pdid)+"_"+psdcode;
		prtypeValueMap.put(key,type_name);

		log.debug("＝＝＝＝＝＝自定义流程状态名取得结束＝＝＝＝＝＝");

	}
}
