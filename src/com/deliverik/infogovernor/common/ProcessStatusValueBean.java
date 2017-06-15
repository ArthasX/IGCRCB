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
	
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(ProcessStatusValueBean.class);
	
	/** ϵͳ������Ϣ */
	private static Map<String, String> prtypeValueMap = new HashMap<String, String>();
	
	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private ProcessStatusValueBean() {

	}

	/**
	 * <p>
	 * Description: ��������id��ѯ�������״̬
	 * </p>
	 * 
	 * @param key
	 * @return String
	 */
	public static String getProcessStatus(String prid) {
		log.debug("��������id��ѯ�������״̬��ʼ");
		
		String status="";
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		IG512SearchCondImpl prrCond = new IG512SearchCondImpl();
		prrCond.setParprid(Integer.valueOf(prid));
		List<IG512Info> processRecordRelationList = workFlowOperationBL.searchProcessRecordRelation(prrCond);//����
		prrCond.setParprid(null);
		prrCond.setCldprid(Integer.valueOf(prid));
		processRecordRelationList.addAll(workFlowOperationBL.searchProcessRecordRelation(prrCond));//����
		
		if(processRecordRelationList!=null&&processRecordRelationList.size()>0){
			IG512Info info = processRecordRelationList.get(0);
			IG500Info process=null;
			//ȡ���������
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
		
		log.debug("��������id��ѯ�������״̬����");
		
		return status;
	}

	/**
	 * <p>
	 * Description: ��ȡ������Ϣ
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
	 * Discription:��ʼ������map
	 * </p>
	 * 
	 */
	public static void init(String pdid,String psdcode) {

		log.debug("�������������Զ�������״̬��ȡ�ÿ�ʼ������������");
		// ȡ����λϵͳ���ò���
		
		IGPRD01BL prdBL = (IGPRD01BL) WebApplicationSupport.getBean("igPRD01BL");
		String type_name = prdBL.getPsNameByPdidAndPsdidAction(pdid,psdcode);
		String key = String.valueOf(pdid)+"_"+psdcode;
		prtypeValueMap.put(key,type_name);

		log.debug("�������������Զ�������״̬��ȡ�ý���������������");

	}
}
