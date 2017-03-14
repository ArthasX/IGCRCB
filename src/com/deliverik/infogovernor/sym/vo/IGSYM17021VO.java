/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ����: ���̲�����Ϣ�֣�
 * �������������̲�����Ϣ�֣�
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM17021VO extends BaseVO implements Serializable{
	
	/** �����̶ȼ��� */
	protected List<LabelValueBean> prurgencyList;
	
	/** ����״̬���� */
	protected List<IG333Info> processStatusDefList;
	
	/** ����״̬���� */
	protected List<LabelValueBean> prstatusList;
	
	/** ���̶�����Ϣ */
	protected IG380Info processDefinition;
	
	/** ���̲������汾�� */
	protected Integer maxPsdversion;
	
	/**
	 * �����̶ȼ����趨
	 * @param prurgencyList�����̶ȼ���
	 */
	public List<LabelValueBean> getPrurgencyList() {
		return prurgencyList;
	}

	/**
	 * �����̶ȼ���ȡ��
	 * @return �����̶ȼ���
	 */
	public void setPrurgencyList(List<LabelValueBean> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}
	
	/**
	 * ����״̬�����趨
	 * @param processStatusDefList����״̬����
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
	
	/**
	 * ����״̬�����趨
	 * @param prstatusList����״̬����
	 */
	public List<LabelValueBean> getPrstatusList() {
		return prstatusList;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public void setPrstatusList(List<LabelValueBean> prstatusList) {
		this.prstatusList = prstatusList;
	}
	
	/**
	 * ���̶�����Ϣ�趨
	 * @param processDefinition���̶�����Ϣ
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * ���̶�����Ϣȡ��
	 * @return ���̶�����Ϣ
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}
	
	/**
	 * ���̲������汾��ȡ��
	 * @return ���̲������汾��
	 */
	public Integer getMaxPsdversion() {
		if(maxPsdversion != null && maxPsdversion == 0) {
			return null;
		} else {
			return maxPsdversion;
		}
	}

	/**
	 * ���̲������汾���趨
	 * @param maxPsdversion���̲������汾��
	 */
	public void setMaxPsdversion(Integer maxPsdversion) {
		this.maxPsdversion = maxPsdversion;
	}

}


