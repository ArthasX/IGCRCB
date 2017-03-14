package com.deliverik.infogovernor.common;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;

public class ProcessUrgencyValueBean {
	
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(ProcessUrgencyValueBean.class);
	
	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private ProcessUrgencyValueBean() {

	}

	/**
	 * <p>
	 * Description: ��������id��ѯ�������״̬
	 * </p>
	 * 
	 * @param key
	 * @return String
	 */
	public static String getProcessUrgencyImg(String prid,String pdid) {
		log.debug("��������id��ѯ���̽����ȿ�ʼ");
		
		String img="";
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		if(pdid.equals("0100301")){
			img="<img src='images/emergency.gif'>";
		}else if(pdid.equals("0100101")){
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(Integer.valueOf(prid));
			List<IG599Info> processInfoList = workFlowOperationBL.searchProcessInfoByCond(cond);
			for (IG599Info info : processInfoList) {
				if(info.getPivarname().equals("���ϵȼ�")){
					String pivarvalue = info.getPivarvalue();
					if("Blocking".equals(pivarvalue)){
						img="<img src='images/emergency.gif'>";
					}
				}
			}
		}
		log.debug("��������id��ѯ���̽����Ƚ���");
		
		return img;
	}
}
