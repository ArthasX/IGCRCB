/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG221Info;

/**
  * ����: �����߰�ť������Ϣ����ͼʵ��
  * ��������: �����߰�ť������Ϣ����ͼʵ��
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG221VW extends BaseEntity implements Serializable,
		Cloneable, IG221Info {

	/** ��ťID */
	@Id
	protected String pbdid;

	/** Ĭ�ϰ�ť���� */
	protected String pbdname;

	/** ��ť�Ƿ��ԾǨ��ʶ��0��ԾǨ��1����ԾǨ�� */
	protected String pbdflag;
	
	//**********************IG132*******************
	/** ���� */
	protected String ppbdid;

	/** �����߶���ID */
	protected String ppdid;

	/** ��ť��ʾ���� */
	protected String ppbdname;

	/** ��ť��ʾ��Ϣ */
	protected String ppbddesc;

	/** �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0 */
	protected String ppbdauth;
	
	//*********************ParticipantDefaultButtonDef*******************
	/** ���� */
	protected String pdbdid;
	
	/** ״̬�ڵ�ID*/
	protected String psdid;
	
	/** ��ť��ʾ���� */
	protected String pdbdname;
	
	/** ��ť��ʾ��Ϣ */
	protected String pdbddesc;

	/** �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0 */
	protected String pdbdauth;
	
	/** �Ƿ�У��������� 0��У�� 1У�� */
	protected String checkrequired;
	
	/** �Ƿ����¼���� */
	protected String checkrecord;
	
	/** ����ҳjs���� */
	protected String acturl;
	
	/**
	 * ��ťIDȡ��
	 *
	 * @return ��ťID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ��ťID�趨
	 *
	 * @param pbdid ��ťID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * Ĭ�ϰ�ť����ȡ��
	 *
	 * @return Ĭ�ϰ�ť����
	 */
	public String getPbdname() {
		return pbdname;
	}

	/**
	 * Ĭ�ϰ�ť�����趨
	 *
	 * @param pbdname Ĭ�ϰ�ť����
	 */
	public void setPbdname(String pbdname) {
		this.pbdname = pbdname;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPpbdid() {
		return ppbdid;
	}

	/**
	 * �����趨
	 *
	 * @param ppbdid ����
	 */
	public void setPpbdid(String ppbdid) {
		this.ppbdid = ppbdid;
	}

	/**
	 * �����߶���IDȡ��
	 *
	 * @return �����߶���ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * �����߶���ID�趨
	 *
	 * @param ppdid �����߶���ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * ��ť��ʾ����ȡ��
	 *
	 * @return ��ť��ʾ����
	 */
	public String getPpbdname() {
		return ppbdname;
	}

	/**
	 * ��ť��ʾ�����趨
	 *
	 * @param ppbdname ��ť��ʾ����
	 */
	public void setPpbdname(String ppbdname) {
		this.ppbdname = ppbdname;
	}

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getPpbddesc() {
		return ppbddesc;
	}

	/**
	 * ��ť��ʾ��Ϣ�趨
	 *
	 * @param ppbddesc ��ť��ʾ��Ϣ
	 */
	public void setPpbddesc(String ppbddesc) {
		this.ppbddesc = ppbddesc;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getPpbdauth() {
		return ppbdauth;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0�趨
	 *
	 * @param ppbdauth �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public void setPpbdauth(String ppbdauth) {
		this.ppbdauth = ppbdauth;
	}

	@Override
	public Serializable getPK() {
		return pbdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPdbdid() {
		return pdbdid;
	}

	public void setPdbdid(String pdbdid) {
		this.pdbdid = pdbdid;
	}

	public String getPdbdname() {
		return pdbdname;
	}

	public void setPdbdname(String pdbdname) {
		this.pdbdname = pdbdname;
	}

	public String getPdbddesc() {
		return pdbddesc;
	}

	public void setPdbddesc(String pdbddesc) {
		this.pdbddesc = pdbddesc;
	}

	public String getPdbdauth() {
		return pdbdauth;
	}

	public void setPdbdauth(String pdbdauth) {
		this.pdbdauth = pdbdauth;
	}

    /**
     * @return the ��ť�Ƿ��ԾǨ��ʶ��0��ԾǨ��1����ԾǨ��
     */
    public String getPbdflag() {
        return pbdflag;
    }

    /**
     * @param ��ť�Ƿ��ԾǨ��ʶ��0��ԾǨ��1����ԾǨ�� the pbdflag to set
     */
    public void setPbdflag(String pbdflag) {
        this.pbdflag = pbdflag;
    }

	/**
	 *�Ƿ�У���������0��У��1У��ȡ��
	 */
	public String getCheckrequired() {
		return checkrequired;
	}

	/**
	 *�Ƿ�У���������0��У��1У���趨
	 */
	public void setCheckrequired(String checkrequired) {
		this.checkrequired = checkrequired;
	}

	/**
	 *�Ƿ����¼����ȡ��
	 */
	public String getCheckrecord() {
		return checkrecord;
	}

	/**
	 *�Ƿ����¼�����趨
	 */
	public void setCheckrecord(String checkrecord) {
		this.checkrecord = checkrecord;
	}

	/**
	 *����ҳjs����ȡ��
	 */
	public String getActurl() {
		return acturl;
	}

	/**
	 *����ҳjs�����趨
	 */
	public void setActurl(String acturl) {
		this.acturl = acturl;
	}
	

}