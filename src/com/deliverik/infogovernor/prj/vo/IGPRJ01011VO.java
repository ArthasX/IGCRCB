/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 * ����:��Ŀ��ѯvo 
 * ������������Ŀ��ѯvo
 * �����ˣ���͢־
 * ������¼�� 2012-5-21
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRJ01011VO extends BaseVO{
	/** ��Ŀid */
	private Integer pid;
	/** ��Ŀ���� */
	private String pname;
	/** ��Ŀ��� */
	private Double plimit;
	/** ��Ŀ��� */
	private String pcode;
	/** �Ƿ�ʹ��Ԥ�� */
	private String isUseBudget;
	/** ��Ŀ��ʼʱ�� */
	private String popentime;
	/** ��Ŀ����ʱ�� */
	private String pclosetime;
	/** ��Ŀ״̬ */
	private String pstatus;
	/** ��ĿԤ���ϵ��ͼ���� */
	private List<Pbsummary> pbsummaryList;
	/**
	 * ��Ŀidȡ��
	 * @return pid ��Ŀid
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * ��Ŀid�趨
	 * @param pid ��Ŀid
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
	 * @return plimit ��Ŀ���
	 */
	public Double getPlimit() {
		return plimit;
	}
	/**
	 * ��Ŀ����趨
	 * @param plimit ��Ŀ���
	 */
	public void setPlimit(Double plimit) {
		this.plimit = plimit;
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
	 * �Ƿ�ʹ��Ԥ��ȡ��
	 * @return isUseBudget �Ƿ�ʹ��Ԥ��
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}
	/**
	 * �Ƿ�ʹ��Ԥ���趨
	 * @param isUseBudget �Ƿ�ʹ��Ԥ��
	 */
	public void setIsUseBudget(String isUseBudget) {
		this.isUseBudget = isUseBudget;
	}
	/**
	 * ��Ŀ��ʼʱ��ȡ��
	 * @return popentime ��Ŀ��ʼʱ��
	 */
	public String getPopentime() {
		return popentime;
	}
	/**
	 * ��Ŀ��ʼʱ���趨
	 * @param popentime ��Ŀ��ʼʱ��
	 */
	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}
	/**
	 * ��Ŀ����ʱ��ȡ��
	 * @return pclosetime ��Ŀ����ʱ��
	 */
	public String getPclosetime() {
		return pclosetime;
	}
	/**
	 * ��Ŀ����ʱ���趨
	 * @param pclosetime ��Ŀ����ʱ��
	 */
	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}
	/**
	 * ��Ŀ״̬ȡ��
	 * @return pstatus ��Ŀ״̬
	 */
	public String getPstatus() {
		return pstatus;
	}
	/**
	 * ��Ŀ״̬�趨
	 * @param pstatus ��Ŀ״̬
	 */
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	/**
	 * ��ĿԤ���ϵ��ͼ����ȡ��
	 * @return pbsummaryList ��ĿԤ���ϵ��ͼ����
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}
	/**
	 * ��ĿԤ���ϵ��ͼ�����趨
	 * @param pbsummaryList ��ĿԤ���ϵ��ͼ����
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
}
