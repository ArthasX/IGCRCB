/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.infogovernor.sym.form.IGSYM1901Form;
import com.deliverik.infogovernor.sym.form.IGSYM1902Form;
import com.deliverik.infogovernor.sym.form.IGSYM1903Form;
import com.deliverik.infogovernor.sym.vo.IGSYM19012VO;
/**
 * ����:����������Чʱ�����DTO
 * ������¼�����    2011/10/18
 */

@SuppressWarnings("serial")
public class IGSYM19DTO extends BaseDTO implements Serializable {

	/**
	 * igsym1901Form
	 */
	protected IGSYM1901Form igsym1901Form;
	
	/**
	 * igsym1902Form
	 */
	protected IGSYM1902Form igsym1902Form;
	
	/**
	 * igsym1903Form
	 */
	protected IGSYM1903Form igsym1903Form;
	
	/**
	 * ��Ϣ����ģ������
	 */
	protected List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList;
	
	/**
	 * vo����
	 */
	protected Map<String, IGSYM19012VO> voMap;
	
	/**
	 * �û��趨�������ڼ�������
	 */
	protected Integer processWorkTimeCount;
	
	/**
	 * �û�ID
	 */
	protected String userId;
	/**
	 * igsym1901Form��ȡ
	 * @return
	 */
	public IGSYM1901Form getIgsym1901Form() {
		return igsym1901Form;
	}

	/**
	 * igsym1901Form�趨
	 * @param igsym1901Form
	 */
	public void setIgsym1901Form(IGSYM1901Form igsym1901Form) {
		this.igsym1901Form = igsym1901Form;
	}

	/**
	 * igsym1902Form��ȡ
	 * @return
	 */
	public IGSYM1902Form getIgsym1902Form() {
		return igsym1902Form;
	}

	/**
	 * igsym1902Form�趨
	 * @param igsym1902Form
	 */
	public void setIgsym1902Form(IGSYM1902Form igsym1902Form) {
		this.igsym1902Form = igsym1902Form;
	}

	/**
	 * igsym1903Form��ȡ
	 * @return
	 */
	public IGSYM1903Form getIgsym1903Form() {
		return igsym1903Form;
	}

	/**
	 * igsym1903Form�趨
	 * @param igsym1903Form
	 */
	public void setIgsym1903Form(IGSYM1903Form igsym1903Form) {
		this.igsym1903Form = igsym1903Form;
	}

	/**
	 * ��Ϣģ��������ȡ
	 * @return
	 */
	public List<ProcessWorkTimeTemplateInfo> getProcessWorkTimeTemplateInfoList() {
		return processWorkTimeTemplateInfoList;
	}

	/**
	 * ��Ϣģ�������趨
	 * @param processWorkTimeTemplateInfoList
	 */
	public void setProcessWorkTimeTemplateInfoList(
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList) {
		this.processWorkTimeTemplateInfoList = processWorkTimeTemplateInfoList;
	}

	/**
	 * voMap��ȡ
	 * @return
	 */
	public Map<String, IGSYM19012VO> getVoMap() {
		return voMap;
	}

	/**
	 * voMap�趨
	 * @param voMap
	 */
	public void setVoMap(Map<String, IGSYM19012VO> voMap) {
		this.voMap = voMap;
	}

	/**
	 * �û��趨�������ڼ���������ȡ
	 * @return
	 */
	public Integer getProcessWorkTimeCount() {
		return processWorkTimeCount;
	}

	/**
	 * �û��趨�������ڼ��������趨
	 * @param processWorkTimeCount
	 */
	public void setProcessWorkTimeCount(Integer processWorkTimeCount) {
		this.processWorkTimeCount = processWorkTimeCount;
	}

	/**
	 * �û�ID��ȡ
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * �û�ID�趨
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
