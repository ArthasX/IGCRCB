/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
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
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * ������Ϣʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name="ReportFileDefinition")
public class ReportFileDefinitionTB extends BaseEntity implements Serializable, Cloneable, ReportFileDefinition {

	/** ���� */
	@Id
	@TableGenerator(
		    name="REPORTFILEDEFINITION_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="REPORTFILEDEFINITION_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REPORTFILEDEFINITION_TABLE_GENERATOR")
	protected Integer rfdid;

	/** ������ʾ���� */
	protected String rfdtitle;
	
	/** ������� */
	protected String rfdtype;

	/** ����˵�� */
	protected String rfddesc;

	/** �����ļ��� */
	protected String rfdfilename;

	/** ����Ǽ���ID */
	protected String rfduserid;

	/** ����Ǽ������� */
	protected String rfdusername;

	/** ����Ǽ�ʱ�� */
	protected String rfdinstime;
	
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
	
	/** ��������ʵ�� */
	@OneToOne
	@JoinColumn(name="rfdtype", referencedColumnName="syscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected CodeDetailTB codeDetailTB;

	/**
	 * ��ȡ����
	 * @return 
	 */
	public Serializable getPK() {
		return rfdid;
	}

	/**
	 * �Ƚ�
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ReportFileDefinitionTB))
			return false;
		ReportFileDefinition target = (ReportFileDefinition) obj;
		if (!(getRfdid()==target.getRfdid()))
			return false;

		return true;
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
	 * ������ʾ����ȡ��
	 * @return ������ʾ����
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * ������ʾ�����趨
	 * @param rfdtitle ������ʾ����
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
	 * ����汾��ȡ��
	 * @return ����汾��
	 */
	public Integer getRfdversion() {
		return rfdversion;
	}

	/**
	 * ����汾���趨
	 * @param rfdversion ����汾��
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

	/**
	 * ��������ʵ��ȡ��
	 * @return ��������ʵ��
	 */
	public CodeDetailTB getCodeDetailTB() {
		return codeDetailTB;
	}
	
	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}

	public String getRfdparameters() {
		return rfdparameters;
	}

	public void setRfdparameters(String rfdparameters) {
		this.rfdparameters = rfdparameters;
	}

	public String getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}

	public void setCodeDetailTB(CodeDetailTB codeDetailTB) {
		this.codeDetailTB = codeDetailTB;
	}
	
	
}
