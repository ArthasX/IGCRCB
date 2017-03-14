/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;


/**
 * ��������Form
 *
 */
@SuppressWarnings("serial")
public class IGSYM1402Form extends BaseForm implements ReportFileDefinition {
	
	/** ���� */
	protected Integer rfdid;

	/** ������ʾ���� */
	protected String rfdtitle;
	
	/** ������� */
	protected String rfdtype;

	/** ����˵�� */
	protected String rfddesc;

	/** �����ļ���  */
	protected String rfdfilename;

	/** ����Ǽ���ID */
	protected String rfduserid;

	/** ����Ǽ������� */
	protected String rfdusername;

	/** ����Ǽ�ʱ�� */
	protected String rfdinstime;
	
	/** ��¼ʱ��� */
	protected String fingerPrint;
	
	/** ���������ʾ���� */
	protected String rfdtypename;
	
	/** ����汾�� */
	protected Integer rfdversion;
	
	/** �������°汾�� */
	protected Integer rfdnewversion;
	
	/** �������� */
	protected String rfdpictype;
	
	/** ������� */
	protected String rfdparameters;
	
	/** �Ƿ��� */
	protected String isFlag;
	
	/** �������� */
	protected String prtype;
	/** �������͸�ѡ */
	protected String[] prtypes;
	
	/** ����״̬ */
	protected String[] prstatus;
	
	/** ��ID */
	protected String pidid;
	/** ��ID ��ѡ*/
	protected String[] pidids;
	
	/** ��ֵ */
	protected String pidvalue;
	
	/** ���μ��� */
	protected String rank;
	
	/** ����ģ�� */
	protected String rfdfilemodel;
	
	protected CodeDetailTB codeDetailTB;
	
	protected String prstatuss;
	
	public String getPrstatuss() {
		return prstatuss;
	}

	public void setPrstatuss(String prstatuss) {
		this.prstatuss = prstatuss;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * �����趨
	 * @param rfdid ����
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * ���������趨
	 * @param rfdtitle ��������
	 */
	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getRfdtype() {
		return rfdtype;
	}

	/**
	 * ��������趨
	 * @param rfdtype �������
	 */
	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getRfddesc() {
		return rfddesc;
	}

	/**
	 * ����˵���趨
	 * @param rfddesc ����˵��
	 */
	public void setRfddesc(String rfddesc) {
		this.rfddesc = rfddesc;
	}

	/**
	 * �����ļ���ȡ��
	 * @return �����ļ���
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * �����ļ����趨
	 * @param rfdfilename �����ļ���
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}

	/**
	 * ����Ǽ���IDȡ��
	 * @return ����Ǽ���ID
	 */
	public String getRfduserid() {
		return rfduserid;
	}

	/**
	 * ����Ǽ���ID�趨
	 * @param rfduserid ����Ǽ���ID
	 */
	public void setRfduserid(String rfduserid) {
		this.rfduserid = rfduserid;
	}

	/**
	 * ����Ǽ�������ȡ��
	 * @return ����Ǽ�������
	 */
	public String getRfdusername() {
		return rfdusername;
	}

	/**
	 * ����Ǽ��������趨
	 * @param rfdusername ����Ǽ�������
	 */
	public void setRfdusername(String rfdusername) {
		this.rfdusername = rfdusername;
	}

	/**
	 * ����Ǽ�ʱ��ȡ��
	 * @return ����Ǽ�ʱ��
	 */
	public String getRfdinstime() {
		return rfdinstime;
	}

	/**
	 * ����Ǽ�ʱ���趨
	 * @param rfdinstime ����Ǽ�ʱ��
	 */
	public void setRfdinstime(String rfdinstime) {
		this.rfdinstime = rfdinstime;
	}

	/**
	 * ��¼ʱ���ȡ��
	 * 
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ��¼ʱ����趨
	 *
	 * @param fingerPrint ��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}

	/**
	 * ���������ʾ����ȡ��
	 * 
	 * @return ���������ʾ����
	 */
	public String getRfdtypename() {
		return rfdtypename;
	}

	/**
	 * ���������ʾ�����趨
	 *
	 * @param rfdtypename ���������ʾ����
	 */
	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}
	
	/**
	 * ����Ǽ�ʱ��ȡ��
	 * @return ����Ǽ�ʱ��
	 */
	public Integer getRfdversion() {
		return rfdversion;
	}

	/**
	 * ����Ǽ�ʱ���趨
	 * @param rfdversion ����Ǽ�ʱ��
	 */
	public void setRfdversion(Integer rfdversion) {
		this.rfdversion = rfdversion;
	}
	
	/**
	 * �������°汾��ȡ��
	 * @return �������°汾��
	 */
	public Integer getRfdnewversion() {
		return rfdnewversion;
	}

	/**
	 * �������°汾���趨
	 * @param rfdnewversion �������°汾��
	 */
	public void setRfdnewversion(Integer rfdnewversion) {
		this.rfdnewversion = rfdnewversion;
	}
	
	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}
	
	public String getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}

	public String getRfdparameters() {
		return rfdparameters;
	}

	public void setRfdparameters(String rfdparameters) {
		this.rfdparameters = rfdparameters;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String[] getPrstatus() {
		return prstatus;
	}

	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}

	public void setPrstatus(String[] prstatus) {
		this.prstatus = prstatus;
	}

	public String getPidid() {
		return pidid;
	}

	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPidvalue() {
		return pidvalue;
	}

	public void setPidvalue(String pidvalue) {
		this.pidvalue = pidvalue;
	}

	public String getRfdfilemodel() {
		return rfdfilemodel;
	}

	public void setRfdfilemodel(String rfdfilemodel) {
		this.rfdfilemodel = rfdfilemodel;
	}

	/**
	 * ����ѡ ��ȡ
	 * @return the pidids
	 */
	public String[] getPidids() {
		return pidids;
	}

	/**
	 *
	 *	 ����ѡ����
	 * @param pidids the pidids to set
	 */
	public void setPidids(String[] pidids) {
		this.pidids = pidids;
	}

	/**
	 * ���̸�ѡȡ��
	 * @return the prtypes
	 */
	public String[] getPrtypes() {
		return prtypes;
	}

	/**
	 *
	 *	���̸�ѡ����
	 * @param prtypes the prtypes to set
	 */
	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}

	
}
