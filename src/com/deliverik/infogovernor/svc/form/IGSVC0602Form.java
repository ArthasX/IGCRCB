/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;


@SuppressWarnings("serial")
public class IGSVC0602Form extends BaseForm implements IG359SearchCond ,IG160SearchCond,IG003SearchCond
{
	protected String prassetcategory;
	
	protected String propentime_from;
	
	protected String propentime_to;
	
	protected String orgName;
	
	protected String orgid;
	
	protected String currentyear;
	
	protected String precedingyear;
	
	/** 事件统计模版id*/
    protected String ipdid;
    /** 问题统计模版id*/
    protected String ppdid;
    /** 变更统计模版id*/
    protected String cpdid;
    /** 服务请求统计模版id*/
    protected String spdid;
	
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	public String getPropentime_from() {
		return propentime_from;
	}

	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	public String getPropentime_to() {
		return propentime_to;
	}

	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

	public String getOrgid() {
		// TODO Auto-generated method stub
		return orgid;
	}

	public String getCurrentyear() {
		return currentyear;
	}

	public String getPrecedingyear() {
		if(this.getCurrentyear() == null){
			return null;
		}
		return (Integer.valueOf(this.getCurrentyear())-1) + "";
	}

    /**
     * 事件统计模版id取得
     *
     * @return ipdid 事件统计模版id
     */
    public String getIpdid() {
        return ipdid;
    }

    /**
     * 事件统计模版id设定
     *
     * @param ipdid 事件统计模版id
     */
    public void setIpdid(String ipdid) {
        this.ipdid = ipdid;
    }

    /**
     * 问题统计模版id取得
     *
     * @return ppdid 问题统计模版id
     */
    public String getPpdid() {
        return ppdid;
    }

    /**
     * 问题统计模版id设定
     *
     * @param ppdid 问题统计模版id
     */
    public void setPpdid(String ppdid) {
        this.ppdid = ppdid;
    }

    /**
     * 变更统计模版id取得
     *
     * @return cpdid 变更统计模版id
     */
    public String getCpdid() {
        return cpdid;
    }

    /**
     * 变更统计模版id设定
     *
     * @param cpdid 变更统计模版id
     */
    public void setCpdid(String cpdid) {
        this.cpdid = cpdid;
    }

    /**
     * 服务请求统计模版id取得
     *
     * @return spdid 服务请求统计模版id
     */
    public String getSpdid() {
        return spdid;
    }

    /**
     * 服务请求统计模版id设定
     *
     * @param spdid 服务请求统计模版id
     */
    public void setSpdid(String spdid) {
        this.spdid = spdid;
    }

}
