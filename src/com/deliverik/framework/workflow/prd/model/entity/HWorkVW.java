/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prd.model.HWork;

/**
 * @Description: 历史工作统计实体
 * @Author  zhaoyunli
 * @History 2010-9-4     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(HWorkVWPK.class)
public class HWorkVW implements Serializable, Cloneable, HWork {
	/**统计类型*/
	@Id
	protected String prtype ;
	/**统计数量*/
	@Id
	protected Integer hcount;
	/**时间*/
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