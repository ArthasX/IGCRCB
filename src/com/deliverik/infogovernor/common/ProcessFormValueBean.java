package com.deliverik.infogovernor.common;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;

public class ProcessFormValueBean {
	/** ��ȡ��ֵ */
	private static Log log = LogFactory.getLog(ProcessFormValueBean.class);
	
	private static IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");

	/**
	 * ͨ������id�ͱ����ƻ�ȡ��ֵ
	 * 
	 * @param prid ����ID
	 * @return ��ǰ״̬��ʾ����
	 */
	public static String getFormValue(Integer prid,String formValueName) {
		try {
			IG599SearchCondImpl ig599cond = new IG599SearchCondImpl();
			ig599cond.setPrid(prid);
			ig599cond.setPivarname(formValueName);
			List<IG599Info> infoList = ig599BL.searchIG599InfosByCond(ig599cond);
			if(infoList!=null&&infoList.size()>0){
				return infoList.get(0).getPivarvalue() == null ? "" : infoList.get(0).getPivarvalue();
			}
		} catch (Exception e) {
			log.error("��ֵ��ȡ�쳣", e);
			return "";
		}
		return "";
	}

}
