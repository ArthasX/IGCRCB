/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model.condition;

/**
  * ����: ��Ŀ��־��ͬ���������ʵ��
  * ��������: ��Ŀ��־��ͬ���������ʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public class ProjectLogContractSearchCondImpl implements
		ProjectLogContractSearchCond {
	
	/** ���� */
	protected Integer plcid;

	/** ��ͬ��� */
	protected Double plcsum;

	/** ��ͬ�������� */
	protected String plcsumterm;

	/** һ�ڸ����� */
	protected Double plcfirst;

	/** һ�ڸ������� */
	protected String plcfirstterm;

	/** ���ڸ����� */
	protected Double plcsecond;

	/** ���ڸ������� */
	protected String plcsecondterm;

	/** ���ڸ����� */
	protected Double plcthird;

	/** ���ڸ������� */
	protected String plcthirdterm;

	/** ���ڸ����� */
	protected Double plcfourth;

	/** ���ڸ������� */
	protected String plcfourthterm;

	/** ���ڸ����� */
	protected Double plcfifth;

	/** ���ڸ������� */
	protected String plcfifthterm;
	
	/** ��Ӧ��Ŀid */
	protected Integer plcpid;

	/** ��Ӧ��Ŀ��־id */
	protected Integer plcplid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPlcid() {
		return plcid;
	}

	/**
	 * �����趨
	 *
	 * @param plcid ����
	 */
	public void setPlcid(Integer plcid) {
		this.plcid = plcid;
	}

	/**
	 * ��ͬ���ȡ��
	 *
	 * @return ��ͬ���
	 */
	public Double getPlcsum() {
		return plcsum;
	}

	/**
	 * ��ͬ����趨
	 *
	 * @param plcsum ��ͬ���
	 */
	public void setPlcsum(Double plcsum) {
		this.plcsum = plcsum;
	}

	/**
	 * ��ͬ��������ȡ��
	 *
	 * @return ��ͬ��������
	 */
	public String getPlcsumterm() {
		return plcsumterm;
	}

	/**
	 * ��ͬ���������趨
	 *
	 * @param plcsumterm ��ͬ��������
	 */
	public void setPlcsumterm(String plcsumterm) {
		this.plcsumterm = plcsumterm;
	}

	/**
	 * һ�ڸ�����ȡ��
	 *
	 * @return һ�ڸ�����
	 */
	public Double getPlcfirst() {
		return plcfirst;
	}

	/**
	 * һ�ڸ������趨
	 *
	 * @param plcfirst һ�ڸ�����
	 */
	public void setPlcfirst(Double plcfirst) {
		this.plcfirst = plcfirst;
	}

	/**
	 * һ�ڸ�������ȡ��
	 *
	 * @return һ�ڸ�������
	 */
	public String getPlcfirstterm() {
		return plcfirstterm;
	}

	/**
	 * һ�ڸ��������趨
	 *
	 * @param plcfirstterm һ�ڸ�������
	 */
	public void setPlcfirstterm(String plcfirstterm) {
		this.plcfirstterm = plcfirstterm;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcsecond() {
		return plcsecond;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plcsecond ���ڸ�����
	 */
	public void setPlcsecond(Double plcsecond) {
		this.plcsecond = plcsecond;
	}

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcsecondterm() {
		return plcsecondterm;
	}

	/**
	 * ���ڸ��������趨
	 *
	 * @param plcsecondterm ���ڸ�������
	 */
	public void setPlcsecondterm(String plcsecondterm) {
		this.plcsecondterm = plcsecondterm;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcthird() {
		return plcthird;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plcthird ���ڸ�����
	 */
	public void setPlcthird(Double plcthird) {
		this.plcthird = plcthird;
	}

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcthirdterm() {
		return plcthirdterm;
	}

	/**
	 * ���ڸ��������趨
	 *
	 * @param plcthirdterm ���ڸ�������
	 */
	public void setPlcthirdterm(String plcthirdterm) {
		this.plcthirdterm = plcthirdterm;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcfourth() {
		return plcfourth;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plcfourth ���ڸ�����
	 */
	public void setPlcfourth(Double plcfourth) {
		this.plcfourth = plcfourth;
	}

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcfourthterm() {
		return plcfourthterm;
	}

	/**
	 * ���ڸ��������趨
	 *
	 * @param plcfourthterm ���ڸ�������
	 */
	public void setPlcfourthterm(String plcfourthterm) {
		this.plcfourthterm = plcfourthterm;
	}

	/**
	 * ���ڸ�����ȡ��
	 *
	 * @return ���ڸ�����
	 */
	public Double getPlcfifth() {
		return plcfifth;
	}

	/**
	 * ���ڸ������趨
	 *
	 * @param plcfifth ���ڸ�����
	 */
	public void setPlcfifth(Double plcfifth) {
		this.plcfifth = plcfifth;
	}

	/**
	 * ���ڸ�������ȡ��
	 *
	 * @return ���ڸ�������
	 */
	public String getPlcfifthterm() {
		return plcfifthterm;
	}

	/**
	 * ���ڸ��������趨
	 *
	 * @param plcfifthterm ���ڸ�������
	 */
	public void setPlcfifthterm(String plcfifthterm) {
		this.plcfifthterm = plcfifthterm;
	}
	
	/**
	 * ��Ӧ��Ŀidȡ��
	 *
	 * @return ��Ӧ��Ŀid
	 */
	public Integer getPlcpid() {
		return plcpid;
	}

	/**
	 * ��Ӧ��Ŀid�趨
	 *
	 * @param plcplid ��Ӧ��Ŀid
	 */
	public void setPlcpid(Integer plcpid) {
		this.plcpid = plcpid;
	}

	/**
	 * ��Ӧ��Ŀ��־idȡ��
	 *
	 * @return ��Ӧ��Ŀ��־id
	 */
	public Integer getPlcplid() {
		return plcplid;
	}

	/**
	 * ��Ӧ��Ŀ��־id�趨
	 *
	 * @param plcplid ��Ӧ��Ŀ��־id
	 */
	public void setPlcplid(Integer plcplid) {
		this.plcplid = plcplid;
	}
}