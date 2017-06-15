/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * @Description: ���̷���VO
 * @Author
 * @History 2010-9-13 �½�
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01011VO extends BaseVO implements Serializable {

	/** ҳ��ɼ���ť���� */
	protected Map<String,String> actionlist;// ÿ����¼��4λ���ֱ�ʾ��1����ɼ�0�����ɼ���˳��Ϊ��׼--����--�ύ--��ֹ

	/** �������� keyΪ������pidid */
	protected Map<String, IG007Info> processInfoDefmap;

	/** ��ȡֵ��ΧΪ�����б���Ϣ */
	protected Map<String, String[]> optionMap;

	/** ��ɫ�����б��Ƿ���ʾ;0-��ʾ1-����ʾ */
	protected String disp;
	/**�ı���󶨸���*/
	protected Map<String,List<Attachment>> textAreaMap;
	
	protected String pdidOrgid;
	
	protected IG243TB processTitleDefTB;
	
	/** �����߿��Ӱ�ť */
	List<IG309Info> lst_ParticipantVisibleButtonVWInfo;

	private IG500Info process;
	
	/** ״̬������Ϣ */
	protected IG333Info processStatusDef;
	
	public String getPdidOrgid() {
		return pdidOrgid;
	}

	public void setPdidOrgid(String pdidOrgid) {
		this.pdidOrgid = pdidOrgid;
	}
	
	/**
	 * ��ȡֵ��ΧΪ�����б���Ϣȡ��
	 * @return ��ȡֵ��ΧΪ�����б���Ϣ
	 */
	public Map<String, String[]> getOptionMap() {
		return optionMap;
	}

	/**
	 * ��ȡֵ��ΧΪ�����б���Ϣ�趨
	 * @param optionMap ��ȡֵ��ΧΪ�����б���Ϣ
	 */
	public void setOptionMap(Map<String, String[]> optionMap) {
		this.optionMap = optionMap;
	}

	/**
	 * �������ϣ�keyΪ������PIDID��ȡ��
	 * 
	 * @return �������ϣ�keyΪ������PIDID��
	 */
	public Map<String, IG007Info> getProcessInfoDefmap() {
		return processInfoDefmap;
	}

	/**
	 * �������ϣ�keyΪ������PIDID���趨
	 * 
	 * @param processStatusInfoDefmap �������ϣ�keyΪ������PIDID��
	 */
	public void setProcessInfoDefmap(
			Map<String, IG007Info> processInfoDefmap) {
		this.processInfoDefmap = processInfoDefmap;
	}

	/**
	 * ��ɫ�����б��Ƿ���ʾȡ��
	 * @return ��ɫ�����б��Ƿ���ʾ
	 */
	public String getDisp() {
		return disp;
	}

	/**
	 * ��ɫ�����б��Ƿ���ʾ�趨
	 * @param disp ��ɫ�����б��Ƿ���ʾ
	 */
	public void setDisp(String disp) {
		this.disp = disp;
	}
	public Map<String, List<Attachment>> getTextAreaMap() {
		return textAreaMap;
	}

	public void setTextAreaMap(Map<String, List<Attachment>> textAreaMap) {
		this.textAreaMap = textAreaMap;
	}

	public IG243TB getProcessTitleDefTB() {
		return processTitleDefTB;
	}

	public void setProcessTitleDefTB(IG243TB processTitleDefTB) {
		this.processTitleDefTB = processTitleDefTB;
	}
	
	/**
	 * �����߿��Ӱ�ťȡ��
	 * 
	 * @return �����߿��Ӱ�ť
	 */
	public List<IG309Info> getLst_ParticipantVisibleButtonVWInfo() {
		return lst_ParticipantVisibleButtonVWInfo;
	}

	/**
	 * �����߿��Ӱ�ť�趨
	 * 
	 * @param lst_ParticipantVisibleButtonVWInfo �����߿��Ӱ�ť
	 */
	public void setLst_ParticipantVisibleButtonVWInfo(
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo) {
		this.lst_ParticipantVisibleButtonVWInfo = lst_ParticipantVisibleButtonVWInfo;
	}
	
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * process�趨
	 * @param process process
	 */
	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * ״̬������Ϣȡ��
	 * @return ״̬������Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ״̬������Ϣ�趨
	 * @param processStatusDef ״̬������Ϣ
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}
	
}
