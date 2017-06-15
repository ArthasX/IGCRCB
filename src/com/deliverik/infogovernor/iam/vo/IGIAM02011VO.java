/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;

/**
 * @author Administrator
 *
 */
/**
 * ����: 
 * ����������
 * �����ˣ�����
 * ������¼�� 2012-7-26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGIAM02011VO extends BaseVO implements Serializable {

	/**
     * ��������ϸ��Ϣ��ʾbean
     */
	private IGIAM0203Form igiam0203form;

    /**
     * ������������ѯ���list
     */
	protected List<InternalauditJobInfo> internalauditJobList;
	 
	protected List<Attachment> attkeyList;
	
	/**
	 * ��ȡattkeyList
	 * @return fattkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	/**
	 * ����attkeyList
	 * @param attkeyList  attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

	/**
	 * ��ȡigiam0203form
	 * @return figiam0203form igiam0203form
	 */
	public IGIAM0203Form getIgiam0203form() {
		return igiam0203form;
	}

	/**
	 * ����igiam0203form
	 * @param igiam0203form  igiam0203form
	 */
	public void setIgiam0203form(IGIAM0203Form igiam0203form) {
		this.igiam0203form = igiam0203form;
	}

	/**
	 * ��ȡinternalauditJobList
	 * @return finternalauditJobList internalauditJobList
	 */
	public List<InternalauditJobInfo> getInternalauditJobList() {
		return internalauditJobList;
	}

	/**
	 * ����internalauditJobList
	 * @param internalauditJobList  internalauditJobList
	 */
	public void setInternalauditJobList(
			List<InternalauditJobInfo> internalauditJobList) {
		this.internalauditJobList = internalauditJobList;
	}
	
}
