/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.csebank.lom.model.GoodsStock;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_���ͳ����Ϣ
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class GoodsStockVW implements Serializable, Cloneable, GoodsStock {

	@Id
	/**��� */
	protected String gid;
	
	/**��Ʒ��� */
	protected String giodcode;
	
	/**��Ʒ����*/
	protected String giodname;
	
	/**��������*/
	protected Integer giodoutnum;

	/**�������*/
	protected Integer giodinnum;
	
	/**�����*/
	protected Integer giodnum;
	
	/**���������*/
	protected String type;
	
	public Serializable getPK() {
		return gid;
	}
	
	/**
	 * ���
	 * @return ���
	 */
	public String getGid() {
		return gid;
	}
	
	/**
	 * ���
	 * @param gid ���
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	/**
	 * ��Ʒ���
	 * @return ��Ʒ���
	 */
	public String getGiodcode() {
		return giodcode;
	}
	
	/**
	 * ��Ʒ���
	 * @param giodcode ��Ʒ���
	 */
	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}
	
	/**
	 * ��Ʒ����
	 * @return ��Ʒ����
	 */
	public String getGiodname() {
		return giodname;
	}
	
	/**
	 * ��Ʒ����
	 * @param giodname ��Ʒ����
	 */
	public void setGiodname(String giodname) {
		this.giodname = giodname;
	}
	
	/**
	 * ��������
	 * @return ��������
	 */
	public Integer getGiodoutnum() {
		return giodoutnum;
	}
	
	/**
	 * ��������
	 * @param giodinoutnum ��������
	 */
	public void setGiodinoutnum(Integer giodoutnum) {
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
	 * @param giodininnum �������
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
	 * @param giodininnum �����
	 */
	public void setGiodnum(Integer giodnum) {
		this.giodnum = giodnum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
