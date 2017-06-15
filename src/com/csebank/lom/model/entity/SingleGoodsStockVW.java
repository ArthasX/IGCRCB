/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.SingleGoodsStock;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_��һ��Ʒ���ͳ����Ϣ
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@Table(name = "SingleGoodsStockVW")
@SuppressWarnings("serial")
@Entity
@IdClass(SingleGoodsStockVWPK.class)
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class SingleGoodsStockVW implements Serializable, Cloneable, SingleGoodsStock {

	@Id
	/**���� */
	protected String giodtime;
	@Id
	/**��������� */
	protected String giodtype;
	
	/**������*/
	//protected String orgname;
	
	/**��������*/
	protected Integer giodoutnum;

	/**�������*/
	protected Integer giodinnum;
	
	/**�����*/
	protected Integer giodnum;
	
	/**�Ӵ�ID*/
	protected Integer rid;
	
	/** �Ӵ�����ʵ�� */
	@OneToOne
	@JoinColumn(name="rid", referencedColumnName="rid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RecptionTB recptionTB;
	
	public Serializable getPK() {
		return giodtime;
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getGiodtime() {
		return giodtime;
	}
	
	/**
	 * ����
	 * @param giodininnum ����
	 */
	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}
	
	/**
	 * ���������
	 * @return ���������
	 */
	public String getGiodtype() {
		return giodtype;
	}
	
	/**
	 * ���������
	 * @param giodtype ���������
	 */
	public void setGiodtype(String giodtype) {
		this.giodtype = giodtype;
	}
	
	/**
	 * ������
	 * @return ������

	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * ������
	 * @param orgname ������
	 
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	*/
	/**
	 * ��������
	 * @return ��������
	 */
	public Integer getGiodoutnum() {
		return giodoutnum;
	}
	
	/**
	 * ��������
	 * @param orgname ��������
	 */
	public void setGiodoutnum(Integer giodoutnum) {
		this.giodoutnum = giodoutnum;
	}
	
	/**
	 * �������
	 * @return �������
	 */
	public Integer getGiodinnum() {
		return giodinnum;
	}
	
	/**
	 * �������
	 * @param giodinnum �������
	 */
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}
	
	/**
	 * �����
	 * @return �����
	 */
	public Integer getGiodnum() {
		return giodnum;
	}
	
	/**
	 * �����
	 * @param giodnum �����
	 */
	public void setGiodnum(Integer giodnum) {
		this.giodnum = giodnum;
	}

	public RecptionTB getRecptionTB() {
		return recptionTB;
	}

	public void setRecptionTB(RecptionTB recptionTB) {
		this.recptionTB = recptionTB;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
}
