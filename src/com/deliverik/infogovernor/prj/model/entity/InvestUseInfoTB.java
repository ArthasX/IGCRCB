/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;

/**
 * ����: Ͷ��ʹ���������ʵ��
 * ����������Ͷ��ʹ���������ʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
@Entity
@SuppressWarnings("serial")
public class InvestUseInfoTB implements InvestUseInfoVW,Serializable{
	@Id
	/** ��ĿID */
	private Integer pid;
	/** ��Ŀ���� */
	private String ppquality;
	/** ��Ŀ��� */
	private String ptype;
	/** ��Ŀ���� */
	private String pname;
	/** ��Ŀ��� */
	private String pdesc;
	/** Ԥ����Ŀ��� */
	private String pstorecode;
	/** ��ͬ����ܼ� */
	private Double ltotal;
	/** ��ͬ����ʱ����ܼ� */
	private Double ltotalctsum;
	/** ��ͬ���ɱ����ܼ� */
	private Double ltotalcssum;
	/** ��ͬ����ʱ��𿪷� */
	private Double ltotal1;
	/** ��ͬ����ʱ������ */
	private Double ltotal2;
	/** ��ͬ����ʱ���Ӳ�� */
	private Double ltotal3;
	/** ��ͬ����ʱ��𹤳� */
	private Double ltotal4;
	/** ��ͬ����ʱ������� */
	private Double ltotal5;
	/** ��ͬ���ɱ���ʵʩ */
	private Double ltotal6;
	/** ��ͬ���ɱ������� */
	private Double ltotal7;
	/** �������� */
	private String term;
	/** ���� */
	private Double fktotal;
	/** Ԥ���ܼ� */
	private Double bztotal;
	/** Ԥ���ʱ����ܼ� */
	private Double bztotalctsum;
	/** Ԥ��ɱ����ܼ� */
	private Double bztotalcssum;
	/** Ԥ���ʱ��𿪷� */
	private Double bztotal1;
	/** Ԥ���ʱ������ */
	private Double bztotal2;
	/** Ԥ���ʱ���Ӳ�� */
	private Double bztotal3;
	/** Ԥ���ʱ��𹤳� */
	private Double bztotal4;
	/** Ԥ���ʱ������� */
	private Double bztotal5;
	/** Ԥ��ɱ���ʵʩ */
	private Double bztotal6;
	/** Ԥ��ɱ������� */
	private Double bztotal7;
	/** ��Ŀ�ܼ� */
	private Double ptotal;
	/** ��Ŀ�ʱ����ܼ� */
	private Double ptotalctsum;
	/** ��Ŀ�ɱ����ܼ� */
	private Double ptotalcssum;
	/** ��Ŀ�ʱ��𿪷� */
	private Double ptotal1;
	/** ��Ŀ�ʱ������ */
	private Double ptotal2;
	/** ��Ŀ�ʱ���Ӳ�� */
	private Double ptotal3;
	/** ��Ŀ�ʱ��𹤳� */
	private Double ptotal4;
	/** ��Ŀ�ʱ������� */
	private Double ptotal5;
	/** ��Ŀ�ɱ���ʵʩ */
	private Double ptotal6;
	/** ��Ŀ�ɱ������� */
	private Double ptotal7;
	/** ��Ŀ��; */
	private String ppurpose;
	/**
	 * pidȡ��
	 * @return pid pid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * pid�趨
	 * @param pid pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * ��Ŀ����ȡ��
	 * @return ppquality ��Ŀ����
	 */
	public String getPpquality() {
		return ppquality;
	}
	/**
	 * ��Ŀ�����趨
	 * @param ppquality ��Ŀ����
	 */
	public void setPpquality(String ppquality) {
		this.ppquality = ppquality;
	}
	/**
	 * ��Ŀ���ȡ��
	 * @return ptype ��Ŀ���
	 */
	public String getPtype() {
		return ptype;
	}
	/**
	 * ��Ŀ����趨
	 * @param ptype ��Ŀ���
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
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
	 * @return pdesc ��Ŀ���
	 */
	public String getPdesc() {
		return pdesc;
	}
	/**
	 * ��Ŀ����趨
	 * @param pdesc ��Ŀ���
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	/**
	 * Ԥ����Ŀ���ȡ��
	 * @return pstorecode Ԥ����Ŀ���
	 */
	public String getPstorecode() {
		return pstorecode;
	}
	/**
	 * Ԥ����Ŀ����趨
	 * @param pstorecode Ԥ����Ŀ���
	 */
	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}
	/**
	 * ��ͬ����ܼ�ȡ��
	 * @return ltotal ��ͬ����ܼ�
	 */
	public Double getLtotal() {
		return ltotal;
	}
	/**
	 * ��ͬ����ܼ��趨
	 * @param ltotal ��ͬ����ܼ�
	 */
	public void setLtotal(Double ltotal) {
		this.ltotal = ltotal;
	}
	/**
	 * ��ͬ����ʱ����ܼ�ȡ��
	 * @return ltotalctsum ��ͬ����ʱ����ܼ�
	 */
	public Double getLtotalctsum() {
		return ltotalctsum;
	}
	/**
	 * ��ͬ����ʱ����ܼ��趨
	 * @param ltotalctsum ��ͬ����ʱ����ܼ�
	 */
	public void setLtotalctsum(Double ltotalctsum) {
		this.ltotalctsum = ltotalctsum;
	}
	/**
	 * ��ͬ���ɱ����ܼ�ȡ��
	 * @return ltotalcssum ��ͬ���ɱ����ܼ�
	 */
	public Double getLtotalcssum() {
		return ltotalcssum;
	}
	/**
	 * ��ͬ���ɱ����ܼ��趨
	 * @param ltotalcssum ��ͬ���ɱ����ܼ�
	 */
	public void setLtotalcssum(Double ltotalcssum) {
		this.ltotalcssum = ltotalcssum;
	}
	/**
	 * ��ͬ����ʱ��𿪷�ȡ��
	 * @return ltotal1 ��ͬ����ʱ��𿪷�
	 */
	public Double getLtotal1() {
		return ltotal1;
	}
	/**
	 * ��ͬ����ʱ��𿪷��趨
	 * @param ltotal1 ��ͬ����ʱ��𿪷�
	 */
	public void setLtotal1(Double ltotal1) {
		this.ltotal1 = ltotal1;
	}
	/**
	 * ��ͬ����ʱ������ȡ��
	 * @return ltotal2 ��ͬ����ʱ������
	 */
	public Double getLtotal2() {
		return ltotal2;
	}
	/**
	 * ��ͬ����ʱ�������趨
	 * @param ltotal2 ��ͬ����ʱ������
	 */
	public void setLtotal2(Double ltotal2) {
		this.ltotal2 = ltotal2;
	}
	/**
	 * ��ͬ����ʱ���Ӳ��ȡ��
	 * @return ltotal3 ��ͬ����ʱ���Ӳ��
	 */
	public Double getLtotal3() {
		return ltotal3;
	}
	/**
	 * ��ͬ����ʱ���Ӳ���趨
	 * @param ltotal3 ��ͬ����ʱ���Ӳ��
	 */
	public void setLtotal3(Double ltotal3) {
		this.ltotal3 = ltotal3;
	}
	/**
	 * ��ͬ����ʱ��𹤳�ȡ��
	 * @return ltotal4 ��ͬ����ʱ��𹤳�
	 */
	public Double getLtotal4() {
		return ltotal4;
	}
	/**
	 * ��ͬ����ʱ��𹤳��趨
	 * @param ltotal4 ��ͬ����ʱ��𹤳�
	 */
	public void setLtotal4(Double ltotal4) {
		this.ltotal4 = ltotal4;
	}
	/**
	 * ��ͬ����ʱ�������ȡ��
	 * @return ltotal5 ��ͬ����ʱ�������
	 */
	public Double getLtotal5() {
		return ltotal5;
	}
	/**
	 * ��ͬ����ʱ��������趨
	 * @param ltotal5 ��ͬ����ʱ�������
	 */
	public void setLtotal5(Double ltotal5) {
		this.ltotal5 = ltotal5;
	}
	/**
	 * ��ͬ���ɱ���ʵʩȡ��
	 * @return ltotal6 ��ͬ���ɱ���ʵʩ
	 */
	public Double getLtotal6() {
		return ltotal6;
	}
	/**
	 * ��ͬ���ɱ���ʵʩ�趨
	 * @param ltotal6 ��ͬ���ɱ���ʵʩ
	 */
	public void setLtotal6(Double ltotal6) {
		this.ltotal6 = ltotal6;
	}
	/**
	 * ��ͬ���ɱ�������ȡ��
	 * @return ltotal7 ��ͬ���ɱ�������
	 */
	public Double getLtotal7() {
		return ltotal7;
	}
	/**
	 * ��ͬ���ɱ��������趨
	 * @param ltotal7 ��ͬ���ɱ�������
	 */
	public void setLtotal7(Double ltotal7) {
		this.ltotal7 = ltotal7;
	}
	/**
	 * ��������ȡ��
	 * @return term ��������
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * ���������趨
	 * @param term ��������
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * ����ȡ��
	 * @return fktotal ����
	 */
	public Double getFktotal() {
		return fktotal;
	}
	/**
	 * �����趨
	 * @param fktotal ����
	 */
	public void setFktotal(Double fktotal) {
		this.fktotal = fktotal;
	}
	/**
	 * Ԥ���ܼ�ȡ��
	 * @return bztotal Ԥ���ܼ�
	 */
	public Double getBztotal() {
		return bztotal;
	}
	/**
	 * Ԥ���ܼ��趨
	 * @param bztotal Ԥ���ܼ�
	 */
	public void setBztotal(Double bztotal) {
		this.bztotal = bztotal;
	}
	/**
	 * Ԥ���ʱ����ܼ�ȡ��
	 * @return bztotalctsum Ԥ���ʱ����ܼ�
	 */
	public Double getBztotalctsum() {
		return bztotalctsum;
	}
	/**
	 * Ԥ���ʱ����ܼ��趨
	 * @param bztotalctsum Ԥ���ʱ����ܼ�
	 */
	public void setBztotalctsum(Double bztotalctsum) {
		this.bztotalctsum = bztotalctsum;
	}
	/**
	 * Ԥ��ɱ����ܼ�ȡ��
	 * @return bztotalcssum Ԥ��ɱ����ܼ�
	 */
	public Double getBztotalcssum() {
		return bztotalcssum;
	}
	/**
	 * Ԥ��ɱ����ܼ��趨
	 * @param bztotalcssum Ԥ��ɱ����ܼ�
	 */
	public void setBztotalcssum(Double bztotalcssum) {
		this.bztotalcssum = bztotalcssum;
	}
	/**
	 * Ԥ���ʱ��𿪷�ȡ��
	 * @return bztotal1 Ԥ���ʱ��𿪷�
	 */
	public Double getBztotal1() {
		return bztotal1;
	}
	/**
	 * Ԥ���ʱ��𿪷��趨
	 * @param bztotal1 Ԥ���ʱ��𿪷�
	 */
	public void setBztotal1(Double bztotal1) {
		this.bztotal1 = bztotal1;
	}
	/**
	 * Ԥ���ʱ������ȡ��
	 * @return bztotal2 Ԥ���ʱ������
	 */
	public Double getBztotal2() {
		return bztotal2;
	}
	/**
	 * Ԥ���ʱ�������趨
	 * @param bztotal2 Ԥ���ʱ������
	 */
	public void setBztotal2(Double bztotal2) {
		this.bztotal2 = bztotal2;
	}
	/**
	 * Ԥ���ʱ���Ӳ��ȡ��
	 * @return bztotal3 Ԥ���ʱ���Ӳ��
	 */
	public Double getBztotal3() {
		return bztotal3;
	}
	/**
	 * Ԥ���ʱ���Ӳ���趨
	 * @param bztotal3 Ԥ���ʱ���Ӳ��
	 */
	public void setBztotal3(Double bztotal3) {
		this.bztotal3 = bztotal3;
	}
	/**
	 * Ԥ���ʱ��𹤳�ȡ��
	 * @return bztotal4 Ԥ���ʱ��𹤳�
	 */
	public Double getBztotal4() {
		return bztotal4;
	}
	/**
	 * Ԥ���ʱ��𹤳��趨
	 * @param bztotal4 Ԥ���ʱ��𹤳�
	 */
	public void setBztotal4(Double bztotal4) {
		this.bztotal4 = bztotal4;
	}
	/**
	 * Ԥ���ʱ�������ȡ��
	 * @return bztotal5 Ԥ���ʱ�������
	 */
	public Double getBztotal5() {
		return bztotal5;
	}
	/**
	 * Ԥ���ʱ��������趨
	 * @param bztotal5 Ԥ���ʱ�������
	 */
	public void setBztotal5(Double bztotal5) {
		this.bztotal5 = bztotal5;
	}
	/**
	 * Ԥ��ɱ���ʵʩȡ��
	 * @return bztotal6 Ԥ��ɱ���ʵʩ
	 */
	public Double getBztotal6() {
		return bztotal6;
	}
	/**
	 * Ԥ��ɱ���ʵʩ�趨
	 * @param bztotal6 Ԥ��ɱ���ʵʩ
	 */
	public void setBztotal6(Double bztotal6) {
		this.bztotal6 = bztotal6;
	}
	/**
	 * Ԥ��ɱ�������ȡ��
	 * @return bztotal7 Ԥ��ɱ�������
	 */
	public Double getBztotal7() {
		return bztotal7;
	}
	/**
	 * Ԥ��ɱ��������趨
	 * @param bztotal7 Ԥ��ɱ�������
	 */
	public void setBztotal7(Double bztotal7) {
		this.bztotal7 = bztotal7;
	}
	/**
	 * ��Ŀ�ܼ�ȡ��
	 * @return ptotal ��Ŀ�ܼ�
	 */
	public Double getPtotal() {
		return ptotal;
	}
	/**
	 * ��Ŀ�ܼ��趨
	 * @param ptotal ��Ŀ�ܼ�
	 */
	public void setPtotal(Double ptotal) {
		this.ptotal = ptotal;
	}
	/**
	 * ��Ŀ�ʱ����ܼ�ȡ��
	 * @return ptotalctsum ��Ŀ�ʱ����ܼ�
	 */
	public Double getPtotalctsum() {
		return ptotalctsum;
	}
	/**
	 * ��Ŀ�ʱ����ܼ��趨
	 * @param ptotalctsum ��Ŀ�ʱ����ܼ�
	 */
	public void setPtotalctsum(Double ptotalctsum) {
		this.ptotalctsum = ptotalctsum;
	}
	/**
	 * ��Ŀ�ɱ����ܼ�ȡ��
	 * @return ptotalcssum ��Ŀ�ɱ����ܼ�
	 */
	public Double getPtotalcssum() {
		return ptotalcssum;
	}
	/**
	 * ��Ŀ�ɱ����ܼ��趨
	 * @param ptotalcssum ��Ŀ�ɱ����ܼ�
	 */
	public void setPtotalcssum(Double ptotalcssum) {
		this.ptotalcssum = ptotalcssum;
	}
	/**
	 * ��Ŀ�ʱ��𿪷�ȡ��
	 * @return ptotal1 ��Ŀ�ʱ��𿪷�
	 */
	public Double getPtotal1() {
		return ptotal1;
	}
	/**
	 * ��Ŀ�ʱ��𿪷��趨
	 * @param ptotal1 ��Ŀ�ʱ��𿪷�
	 */
	public void setPtotal1(Double ptotal1) {
		this.ptotal1 = ptotal1;
	}
	/**
	 * ��Ŀ�ʱ������ȡ��
	 * @return ptotal2 ��Ŀ�ʱ������
	 */
	public Double getPtotal2() {
		return ptotal2;
	}
	/**
	 * ��Ŀ�ʱ�������趨
	 * @param ptotal2 ��Ŀ�ʱ������
	 */
	public void setPtotal2(Double ptotal2) {
		this.ptotal2 = ptotal2;
	}
	/**
	 * ��Ŀ�ʱ���Ӳ��ȡ��
	 * @return ptotal3 ��Ŀ�ʱ���Ӳ��
	 */
	public Double getPtotal3() {
		return ptotal3;
	}
	/**
	 * ��Ŀ�ʱ���Ӳ���趨
	 * @param ptotal3 ��Ŀ�ʱ���Ӳ��
	 */
	public void setPtotal3(Double ptotal3) {
		this.ptotal3 = ptotal3;
	}
	/**
	 * ��Ŀ�ʱ��𹤳�ȡ��
	 * @return ptotal4 ��Ŀ�ʱ��𹤳�
	 */
	public Double getPtotal4() {
		return ptotal4;
	}
	/**
	 * ��Ŀ�ʱ��𹤳��趨
	 * @param ptotal4 ��Ŀ�ʱ��𹤳�
	 */
	public void setPtotal4(Double ptotal4) {
		this.ptotal4 = ptotal4;
	}
	/**
	 * ��Ŀ�ʱ�������ȡ��
	 * @return ptotal5 ��Ŀ�ʱ�������
	 */
	public Double getPtotal5() {
		return ptotal5;
	}
	/**
	 * ��Ŀ�ʱ��������趨
	 * @param ptotal5 ��Ŀ�ʱ�������
	 */
	public void setPtotal5(Double ptotal5) {
		this.ptotal5 = ptotal5;
	}
	/**
	 * ��Ŀ�ɱ���ʵʩȡ��
	 * @return ptotal6 ��Ŀ�ɱ���ʵʩ
	 */
	public Double getPtotal6() {
		return ptotal6;
	}
	/**
	 * ��Ŀ�ɱ���ʵʩ�趨
	 * @param ptotal6 ��Ŀ�ɱ���ʵʩ
	 */
	public void setPtotal6(Double ptotal6) {
		this.ptotal6 = ptotal6;
	}
	/**
	 * ��Ŀ�ɱ�������ȡ��
	 * @return ptotal7 ��Ŀ�ɱ�������
	 */
	public Double getPtotal7() {
		return ptotal7;
	}
	/**
	 * ��Ŀ�ɱ��������趨
	 * @param ptotal7 ��Ŀ�ɱ�������
	 */
	public void setPtotal7(Double ptotal7) {
		this.ptotal7 = ptotal7;
	}
	/**
	 * ��Ŀ��;ȡ��
	 * @return ppurpose ��Ŀ��;
	 */
	public String getPpurpose() {
		return ppurpose;
	}
	/**
	 * ��Ŀ��;�趨
	 * @param ppurpose ��Ŀ��;
	 */
	public void setPpurpose(String ppurpose) {
		this.ppurpose = ppurpose;
	}
}
