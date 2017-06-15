/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG132Info;

/**
  * ����: �����߰�ť������Ϣ��ʵ��
  * ��������: �����߰�ť������Ϣ��ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG132")
public class IG132TB extends BaseEntity implements Serializable,
		Cloneable, IG132Info {

	/** ���� */
	@Id
	protected String ppbdid;

	/** �����߶���ID */
	protected String ppdid;

	/** ��ť����ID */
	protected String pbdid;

	/** ��ť��ʾ���� */
	protected String ppbdname;

	/** ��ť��ʾ��Ϣ */
	protected String ppbddesc;

	/** �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0 */
	protected String ppbdauth;
	
	/** �Ƿ�У��������� 0��У�� 1У�� */
	protected String checkrequired;
	
	/** �Ƿ����¼���� */
	protected String checkrecord;
	
	/** ����ҳjs���� */
	protected String acturl;

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
	 * ��ť����IDȡ��
	 *
	 * @return ��ť����ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ��ť����ID�趨
	 *
	 * @param pbdid ��ť����ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return ppbdid;
	}

	/** ��ť���� */
	@OneToOne
	@JoinColumn(name="pbdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG900TB processButtonDefTB;

	public IG900TB getProcessButtonDefTB() {
		return processButtonDefTB;
	}

	public void setProcessButtonDefTB(IG900TB processButtonDefTB) {
		this.processButtonDefTB = processButtonDefTB;
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