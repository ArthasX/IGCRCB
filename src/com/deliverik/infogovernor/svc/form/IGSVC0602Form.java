/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
	
	/** �¼�ͳ��ģ��id*/
    protected String ipdid;
    /** ����ͳ��ģ��id*/
    protected String ppdid;
    /** ���ͳ��ģ��id*/
    protected String cpdid;
    /** ��������ͳ��ģ��id*/
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
     * �¼�ͳ��ģ��idȡ��
     *
     * @return ipdid �¼�ͳ��ģ��id
     */
    public String getIpdid() {
        return ipdid;
    }

    /**
     * �¼�ͳ��ģ��id�趨
     *
     * @param ipdid �¼�ͳ��ģ��id
     */
    public void setIpdid(String ipdid) {
        this.ipdid = ipdid;
    }

    /**
     * ����ͳ��ģ��idȡ��
     *
     * @return ppdid ����ͳ��ģ��id
     */
    public String getPpdid() {
        return ppdid;
    }

    /**
     * ����ͳ��ģ��id�趨
     *
     * @param ppdid ����ͳ��ģ��id
     */
    public void setPpdid(String ppdid) {
        this.ppdid = ppdid;
    }

    /**
     * ���ͳ��ģ��idȡ��
     *
     * @return cpdid ���ͳ��ģ��id
     */
    public String getCpdid() {
        return cpdid;
    }

    /**
     * ���ͳ��ģ��id�趨
     *
     * @param cpdid ���ͳ��ģ��id
     */
    public void setCpdid(String cpdid) {
        this.cpdid = cpdid;
    }

    /**
     * ��������ͳ��ģ��idȡ��
     *
     * @return spdid ��������ͳ��ģ��id
     */
    public String getSpdid() {
        return spdid;
    }

    /**
     * ��������ͳ��ģ��id�趨
     *
     * @param spdid ��������ͳ��ģ��id
     */
    public void setSpdid(String spdid) {
        this.spdid = spdid;
    }

}
