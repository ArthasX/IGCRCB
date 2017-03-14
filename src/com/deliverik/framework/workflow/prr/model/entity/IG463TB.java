/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG463Info;

/**
 * <p>����:���̴��칤����Ϣʵ��</p>
 * <p>����������1.���̳�ʼ��</p>
 * <p>          2.���̲�ѯ</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG463")
public class IG463TB extends BaseEntity implements Serializable, Cloneable, IG463Info {
	/** ���̴��칤����ϢID */
	@Id
	@TableGenerator(
		    name="IG463_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG463_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG463_TABLE_GENERATOR")
	
	/** ��Ȩ����ID*/
	protected Integer ppwid;
	
	/** ����ID*/
	protected Integer ppwprid;
	
	/** ��������*/
	protected String ppwprtype;
	
	/** ���̱��*/
	protected String ppwprserialnum;
	
	/** ���̱���*/
	protected String ppwprtitle;
	
	/** ��Ȩ��ID*/
	protected String ppwauthorizeuserid;
	
	/** ������ID*/
	protected String ppwproxyuserid;
	
	/** ����������*/
	protected String ppwproxyusername ;
	
	/** �����˴���ʱ��*/
	protected String ppwoptiontime;
	
	/** �رձ�ʶ*/
	protected String ppwcloseflag;
	
	@OneToOne
	@JoinColumn(name="ppwauthorizeuserid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	/** ��Ȩ��TB*/
	protected UserTB userTB;
	/**
	 * ���ܣ���Ȩ����IDȡ��
	 * 
	 * @return ��Ȩ����ID
	 */
	public Integer getPpwid() {
		return ppwid;
	}
	
	/**
	 * ���ܣ���Ȩ����ID�趨
	 *
	 * @param ppwid ��Ȩ����ID
	 */
	public void setPpwid(Integer ppwid) {
		this.ppwid = ppwid;
	}
	
	/**
	 * ���ܣ�����idȡ��
	 * 
	 * @return ����id
	 */
	public Integer getPpwprid() {
		return ppwprid;
	}
	
	/**
	 * ���ܣ�����id�趨
	 *
	 * @param ppwprid ����id
	 */
	public void setPpwprid(Integer ppwprid) {
		this.ppwprid = ppwprid;
	}
	
	/**
	 * ���ܣ���������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPpwprtype() {
		return ppwprtype;
	}
	
	/**
	 * ���ܣ����������趨
	 *
	 * @param ppwprtype ��������
	 */
	public void setPpwprtype(String ppwprtype) {
		this.ppwprtype = ppwprtype;
	}
	
	/**
	 * ���ܣ����̱��ȡ��
	 * 
	 * @return ���̱��
	 */
	public String getPpwprserialnum() {
		return ppwprserialnum;
	}
	
	/**
	 * ���ܣ����̱���趨
	 *
	 * @param ppwprserialnum ���̱��
	 */
	public void setPpwprserialnum(String ppwprserialnum) {
		this.ppwprserialnum = ppwprserialnum;
	}
	
	/**
	 * ���ܣ����̱���ȡ��
	 * 
	 * @return ���̱���
	 */
	public String getPpwprtitle() {
		return ppwprtitle;
	}
	
	/**
	 * ���ܣ����̱����趨
	 *
	 * @param ppwprtitle ���̱���
	 */
	public void setPpwprtitle(String ppwprtitle) {
		this.ppwprtitle = ppwprtitle;
	}
	
	/**
	 * ���ܣ���Ȩ��idȡ��
	 * 
	 * @return ��Ȩ��id
	 */
	public String getPpwauthorizeuserid() {
		return ppwauthorizeuserid;
	}
	
	/**
	 * ���ܣ���Ȩ��id�趨
	 *
	 * @param ppwauthorizeuserid ��Ȩ��id
	 */
	public void setPpwauthorizeuserid(String ppwauthorizeuserid) {
		this.ppwauthorizeuserid = ppwauthorizeuserid;
	}
	
	/**
	 * ���ܣ�������idȡ��
	 * 
	 * @return ������id
	 */
	public String getPpwproxyuserid() {
		return ppwproxyuserid;
	}
	
	/**
	 * ���ܣ�������id�趨
	 *
	 * @param ppwproxyuserid ������id
	 */
	public void setPpwproxyuserid(String ppwproxyuserid) {
		this.ppwproxyuserid = ppwproxyuserid;
	}
	
	/**
	 * ���ܣ�����������ȡ��
	 * 
	 * @return ����������
	 */
	public String getPpwproxyusername() {
		return ppwproxyusername;
	}
	
	/**
	 * ���ܣ������������趨
	 *
	 * @param ppwproxyusername ����������
	 */
	public void setPpwproxyusername(String ppwproxyusername) {
		this.ppwproxyusername = ppwproxyusername;
	}
	
	/**
	 * ���ܣ������˴���ʱ��ȡ��
	 * 
	 * @return �����˴���ʱ��
	 */
	public String getPpwoptiontime() {
		return ppwoptiontime;
	}
	
	/**
	 * ���ܣ������˴���ʱ���趨
	 *
	 * @param ppwoptiontime �����˴���ʱ��
	 */
	public void setPpwoptiontime(String ppwoptiontime) {
		this.ppwoptiontime = ppwoptiontime;
	}
	
	/**
	 * ���ܣ��رձ�־ȡ��
	 * 
	 * @return �رձ�־
	 */
	public String getPpwcloseflag() {
		return ppwcloseflag;
	}
	
	/**
	 * ���ܣ��رձ�־�趨
	 *
	 * @param ppwcloseflag �رձ�־
	 */
	public void setPpwcloseflag(String ppwcloseflag) {
		this.ppwcloseflag = ppwcloseflag;
	}

	@Override
	public Serializable getPK() {
		
		return null;
	}

	/**
	 * ���ܣ���Ȩ��TBȡ��
	 * @return userTB
	 */
	public UserTB getUserTB() {
		return userTB;
	}

	/**
	 * ���ܣ���Ȩ��TB����
	 * @param userTB
	 */
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}
	
	

	
}
