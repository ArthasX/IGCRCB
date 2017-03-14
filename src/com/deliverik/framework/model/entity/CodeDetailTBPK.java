package com.deliverik.framework.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * ������Ϣ��������
 *
 * @author 
 */
@SuppressWarnings("serial")
public class CodeDetailTBPK extends BasePK implements Serializable{

	/** ���ݷ���CD */
	protected String ccid ;
	
	/** ����CD */
	protected String cid;

	/**
	 * 
	 */
	public CodeDetailTBPK(){}
	
	/**
	 * ������Ϣ�������幹�캯��
	 */
	public CodeDetailTBPK(String ccid, String cid) {
		super();
		this.ccid = ccid;
		this.cid = cid;
	}

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * ����CD�趨
	 *
	 * @param cid ����CD
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

}
