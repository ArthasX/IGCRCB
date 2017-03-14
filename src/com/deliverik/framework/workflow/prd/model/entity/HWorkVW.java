/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prd.model.HWork;

/**
 * @Description: ��ʷ����ͳ��ʵ��
 * @Author  zhaoyunli
 * @History 2010-9-4     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(HWorkVWPK.class)
public class HWorkVW implements Serializable, Cloneable, HWork {
	/**ͳ������*/
	@Id
	protected String prtype ;
	/**ͳ������*/
	@Id
	protected Integer hcount;
	/**ʱ��*/
	@Id
	protected String propentime;
	
	protected String pruserid;
	public String getPrtype() {
		return prtype;
	}
	
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
	

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public Integer getHcount() {
		return hcount;
	}

	public void setHcount(Integer hcount) {
		this.hcount = hcount;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	
}