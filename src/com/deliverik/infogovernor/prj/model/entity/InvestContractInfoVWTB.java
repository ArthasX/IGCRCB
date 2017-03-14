/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;

/**
 * ����: Ͷ�ʺ�ͬ��ϸ��ͼʵ��
 * ����������Ͷ�ʺ�ͬ��ϸ��ͼʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-25
 * �޸ļ�¼��
 */
@Entity
public class InvestContractInfoVWTB implements InvestContractInfoVW{
	@Id
	/** ��ĿID */
	private Integer pid;
	/** ��Ŀ���� */
	private String pname;
	/** ��Ŀ��� */
	private String pcode;
	/** Ԥ���� */
	private String pstorecode;
	/** Ԥ������ */
	private String btitle;
	/** ��Ӳ�� */
	private String pcut;
	/** ��ͬ��� */
	private String plcnumber;
	/** ��ͬ��� */
	private Double plcsum;
	/** �Ѹ��� */
	private Double plbsum;
	/** ��� */
	private Double subnum;
	/** ��ͬ���� */
	private Integer lcount;
	/** �������� */
	private Integer bcount;
	/** ������ */
	private String username;
	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * ��Ŀ����ȡ��
	 * @return pname ��Ŀ����
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * ��Ŀ�����趨
	 * @param pname ��Ŀ����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * ��Ŀ���ȡ��
	 * @return pcode ��Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}
	/**
	 * ��Ŀ����趨
	 * @param pcode ��Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	/**
	 * Ԥ����ȡ��
	 * @return pstorecode Ԥ����
	 */
	public String getPstorecode() {
		return pstorecode;
	}
	/**
	 * Ԥ�����趨
	 * @param pstorecode Ԥ����
	 */
	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}
	/**
	 * Ԥ������ȡ��
	 * @return btitle Ԥ������
	 */
	public String getBtitle() {
		return btitle;
	}
	/**
	 * Ԥ�������趨
	 * @param btitle Ԥ������
	 */
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	/**
	 * ��Ӳ��ȡ��
	 * @return pcut ��Ӳ��
	 */
	public String getPcut() {
		return pcut;
	}
	/**
	 * ��Ӳ���趨
	 * @param pcut ��Ӳ��
	 */
	public void setPcut(String pcut) {
		this.pcut = pcut;
	}
	/**
	 * ��ͬ���ȡ��
	 * @return plcnumber ��ͬ���
	 */
	public String getPlcnumber() {
		return plcnumber;
	}
	/**
	 * ��ͬ����趨
	 * @param plcnumber ��ͬ���
	 */
	public void setPlcnumber(String plcnumber) {
		this.plcnumber = plcnumber;
	}
	/**
	 * ��ͬ���ȡ��
	 * @return plcsum ��ͬ���
	 */
	public Double getPlcsum() {
		return plcsum;
	}
	/**
	 * ��ͬ����趨
	 * @param plcsum ��ͬ���
	 */
	public void setPlcsum(Double plcsum) {
		this.plcsum = plcsum;
	}
	/**
	 * �Ѹ���ȡ��
	 * @return plbplcsum �Ѹ���
	 */
	public Double getPlbsum() {
		return plbsum;
	}
	/**
	 * �Ѹ����趨
	 * @param plbplcsum �Ѹ���
	 */
	public void setPlbsum(Double plbsum) {
		this.plbsum = plbsum;
	}
	/**
	 * ���ȡ��
	 * @return subnum ���
	 */
	public Double getSubnum() {
		return subnum;
	}
	/**
	 * ����趨
	 * @param subnum ���
	 */
	public void setSubnum(Double subnum) {
		this.subnum = subnum;
	}
	/**
	 * ��ͬ����ȡ��
	 * @return lcount ��ͬ����
	 */
	public Integer getLcount() {
		return lcount;
	}
	/**
	 * ��ͬ�����趨
	 * @param lcount ��ͬ����
	 */
	public void setLcount(Integer lcount) {
		this.lcount = lcount;
	}
	/**
	 * ��������ȡ��
	 * @return bcount ��������
	 */
	public Integer getBcount() {
		return bcount;
	}
	/**
	 * ���������趨
	 * @param bcount ��������
	 */
	public void setBcount(Integer bcount) {
		this.bcount = bcount;
	}
	/**
	 * ������ȡ��
	 * @return username ������
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * �������趨
	 * @param username ������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
