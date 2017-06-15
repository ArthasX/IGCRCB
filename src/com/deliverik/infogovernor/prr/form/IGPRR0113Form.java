/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ���̴���Form
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0113Form extends BaseForm {

	/** ����ID */
	protected Integer prid;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/**�ڵ�ģʽ*/
	protected String psdmode;
	
	/** ����״̬ID */
	protected String psdid;
	
	/** ������ID����ʽ��roleid_userid��*/
	protected String[] participants;
	
	/** ����״̬ */
	protected String prstatus;
	
	/** ���첿�Ž�ɫID */
	protected Integer ppsuperid;
	
	/** ���첿�Ż����� */
	protected String ppsuperorgid;
	
	/** ���ɲ��������ͣ�0��Ա��1��ɫ �� */
	protected String psdassign;
	
	/** �ڵ����� */
	protected String psdtype;
	
	/** ҳ�����ͣ�0��ɫ��1�û��� */
	protected String flag;
	
	/** ����ҳ���ʼ��ѡ����Ա��ʶ */
	protected String selected_participants;
	
	/**ҳ����ת��ʶ*/
	protected String jump;
	
	/** ��֧״̬��� */
	protected String psdnum;
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * �ڵ�ģʽȡ��
	 * @return �ڵ�ģʽ
	 */
	public String getPsdmode() {
		return psdmode;
	}

	/**
	 * �ڵ�ģʽ�趨
	 * @param psdmode�ڵ�ģʽ
	 */
	public void setPsdmode(String psdmode) {
		this.psdmode = psdmode;
	}

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 * @param roleid��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * ������IDȡ��
	 * 
	 * @return ������ID
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * ������ID�趨
	 * 
	 * @param participants ������ID
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
	
	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}


	/**
	 * ����״̬ID�趨
	 *
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * 
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**
	 * ���첿�Ž�ɫIDȡ��
	 * 
	 * @return ���첿�Ž�ɫID
	 */
	public Integer getPpsuperid() {
		return ppsuperid;
	}

	/**
	 * ���첿�Ž�ɫID�趨
	 * 
	 * @param ppsuperid ���첿�Ž�ɫID
	 */
	public void setPpsuperid(Integer ppsuperid) {
		this.ppsuperid = ppsuperid;
	}
	
	/**
	 * ���ɲ���������ȡ��
	 * 
	 * @return ���ɲ���������
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * ���ɲ����������趨
	 * 
	 * @param psdassign ���ɲ���������
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	
	/**
	 * �ڵ�����ȡ��
	 * 
	 * @return �ڵ�����
	 */
	public String getPsdtype() {
		return psdtype;
	}

	/**
	 * �ڵ������趨
	 * 
	 * @param psdtype �ڵ�����
	 */
	public void setPsdtype(String psdtype) {
		this.psdtype = psdtype;
	}
	
	/**
	 * ҳ������ȡ��
	 * 
	 * @return ҳ������
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * ҳ�������趨
	 * 
	 * @param flag ҳ������
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.participants = null;
	}
	
	/**
	 * ����ҳ���ʼ��ѡ����Ա��ʶȡ��
	 * 
	 * @return ����ҳ���ʼ��ѡ����Ա��ʶ
	 */
	public String getSelected_participants() {
		return selected_participants;
	}

	/**
	 * ����ҳ���ʼ��ѡ����Ա��ʶ�趨
	 * 
	 * @param selected_participants ����ҳ���ʼ��ѡ����Ա��ʶ
	 */
	public void setSelected_participants(String selected_participants) {
		this.selected_participants = selected_participants;
	}

	/**
	 * ���첿�Ż�����ȡ��
	 * @return ���첿�Ż�����
	 */
	public String getPpsuperorgid() {
		return ppsuperorgid;
	}

	/**
	 * ���첿�Ż������趨
	 * @param ppsuperorgid ���첿�Ż�����
	 */
	public void setPpsuperorgid(String ppsuperorgid) {
		this.ppsuperorgid = ppsuperorgid;
	}
	
	/**
	 * ҳ����ת��ʶȡ��
	 * @return ҳ����ת��ʶ
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * ҳ����ת��ʶ�趨
	 * @param jump ҳ����ת��ʶ
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * ��֧״̬���ȡ��
	 * @return ��֧״̬���
	 */
	public String getPsdnum() {
		return psdnum;
	}

	/**
	 * ��֧״̬����趨
	 * @param psdnum ��֧״̬���
	 */
	public void setPsdnum(String psdnum) {
		this.psdnum = psdnum;
	}
	
}
