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
import com.deliverik.framework.workflow.prd.model.IG725Info;

/**
  * ����: ȱʡ�����߰�ť�����ʵ��
  * ��������: ȱʡ�����߰�ť�����ʵ��
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG725")
public class IG725TB extends BaseEntity implements Serializable,
		Cloneable, IG725Info {

	/** ���� */
	@Id
	protected String pdbdid;

	/** ���״̬ID */
	protected String psdid;

	/** ��ť����ID */
	protected String pbdid;

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
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPdbdid() {
		return pdbdid;
	}

	/**
	 * �����趨
	 *
	 * @param pdbdid ����
	 */
	public void setPdbdid(String pdbdid) {
		this.pdbdid = pdbdid;
	}

	/**
	 * ���״̬IDȡ��
	 *
	 * @return ���״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ���״̬ID�趨
	 *
	 * @param psdid ���״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
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
	public String getPdbdname() {
		return pdbdname;
	}

	/**
	 * ��ť��ʾ�����趨
	 *
	 * @param pdbdname ��ť��ʾ����
	 */
	public void setPdbdname(String pdbdname) {
		this.pdbdname = pdbdname;
	}

	/**
	 * ��ť��ʾ��Ϣȡ��
	 *
	 * @return ��ť��ʾ��Ϣ
	 */
	public String getPdbddesc() {
		return pdbddesc;
	}

	/**
	 * ��ť��ʾ��Ϣ�趨
	 *
	 * @param pdbddesc ��ť��ʾ��Ϣ
	 */
	public void setPdbddesc(String pdbddesc) {
		this.pdbddesc = pdbddesc;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0ȡ��
	 *
	 * @return �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public String getPdbdauth() {
		return pdbdauth;
	}

	/**
	 * �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0�趨
	 *
	 * @param pdbdauth �ύȨ�ޣ�0ͬ��ɫ�������ύԾǨ��1ͬ��ɫ��һ���ύԾǨ��Ĭ��0
	 */
	public void setPdbdauth(String pdbdauth) {
		this.pdbdauth = pdbdauth;
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
		return pdbdid;
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