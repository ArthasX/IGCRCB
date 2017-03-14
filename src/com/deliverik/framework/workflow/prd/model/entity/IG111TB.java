/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ��������ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG111")
public class IG111TB extends BaseEntity implements IG111Info{
	
	/** ���� */
	@Id
	protected String qid;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ��ѯ��ʽ */
	protected String qmode;
	
	/** ��ѯ������ʶ */
	protected String qtype;
	
	/** ��ѯ������ʶ */
	protected String qflag;
	
	/** ��ʶ���� */
	protected String qname;
	
	/** ������ʵ�� */
	@Transient
	protected IG007Info pid;
	
	/**
	 * ����ȡ��
	 * @return qid ����
	 */
	public String getQid() {
		return qid;
	}

	/**
	 * �����趨
	 * @param qid ����
	 */
	public void setQid(String qid) {
		this.qid = qid;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ѯ��ʽȡ��
	 * @return qmode ��ѯ��ʽ
	 */
	public String getQmode() {
		return qmode;
	}

	/**
	 * ��ѯ��ʽ�趨
	 * @param qmode ��ѯ��ʽ
	 */
	public void setQmode(String qmode) {
		this.qmode = qmode;
	}

	/**
	 * ��ѯ������ʶȡ��
	 * @return qtype ��ѯ������ʶ
	 */
	public String getQtype() {
		return qtype;
	}

	/**
	 * ��ѯ������ʶ�趨
	 * @param qtype ��ѯ������ʶ
	 */
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	/**
	 * ��ѯ������ʶȡ��
	 * @return qflag ��ѯ������ʶ
	 */
	public String getQflag() {
		return qflag;
	}

	/**
	 * ��ѯ������ʶ�趨
	 * @param qflag ��ѯ������ʶ
	 */
	public void setQflag(String qflag) {
		this.qflag = qflag;
	}

	/**
	 * ��ʶ����ȡ��
	 * @return qname ��ʶ����
	 */
	public String getQname() {
		return qname;
	}

	/**
	 * ��ʶ�����趨
	 * @param qname ��ʶ����
	 */
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	/**
	 * ������ʵ��ȡ��
	 * @return pid ������ʵ��
	 */
	public IG007Info getPid() {
		if(pid == null && "pi".equals(qtype)){
			WorkFlowDefinitionBL bl = (WorkFlowDefinitionBL) WebApplicationSupport.getBean("workFlowDefinitionBL");
			try {
				pid = bl.searchProcessInfoDefByKey(qflag);
			} catch (BLException e) {
			}
		}
		return pid;
	}

	/**
	 * ������ʵ���趨
	 * @param pid ������ʵ��
	 */
	public void setPid(IG007Info pid) {
		this.pid = pid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.qid;
	}

}
