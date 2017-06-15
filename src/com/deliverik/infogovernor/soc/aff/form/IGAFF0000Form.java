package com.deliverik.infogovernor.soc.aff.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;

/**
 * 设备影响分析画面FORM
 * 
 */
public class IGAFF0000Form extends BaseForm implements SOC0124SearchCond{

	private static final long serialVersionUID = 1L;
	
	protected String esyscodingbegin;
	protected String esyscoding;
	protected String einame;
	protected String ename;
	protected String paramEsyscoding;
	
	
	
	public String getParamEsyscoding() {
		return paramEsyscoding;
	}
	public void setParamEsyscoding(String paramEsyscoding) {
		this.paramEsyscoding = paramEsyscoding;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	public String getEsyscodingbegin() {
		return esyscodingbegin;
	}
	public void setEsyscodingbegin(String esyscodingbegin) {
		this.esyscodingbegin = esyscodingbegin;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getElabel()
	 */
	public String getElabel() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEilabel()
	 */
	public String getEilabel() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEcategory()
	 */
	public String getEcategory() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEkey1()
	 */
	public String getEkey1() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEkey2()
	 */
	public String getEkey2() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiupdtime_from()
	 */
	public String getEiupdtime_from() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiupdtime_to()
	 */
	public String getEiupdtime_to() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiupdtime_from2()
	 */
	public String getEiupdtime_from2() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiupdtime_to2()
	 */
	public String getEiupdtime_to2() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getCname()
	 */
	public String[] getCname() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getCivalue()
	 */
	public String[] getCivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getCclabel()
	 */
	public String[] getCclabel() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getCcivalue()
	 */
	public String[] getCcivalue() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiorgcode()
	 */
	public String getEiorgcode() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiorgsyscoding()
	 */
	public String getEiorgsyscoding() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiorgsyscoding_q()
	 */
	public String getEiorgsyscoding_q() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEistatus_q()
	 */
	public String getEistatus_q() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEistatus()
	 */
	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEiidList()
	 */
	public List<String> getEiidList() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getUsesyscoding()
	 */
	public String getUsesyscoding() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getWbdate_from()
	 */
	public String getWbdate_from() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getWbdate_to()
	 */
	public String getWbdate_to() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getEirootmark_eq()
	 */
	public Integer getEirootmark_eq() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#isTopCiFlag()
	 */
	public boolean isTopCiFlag() {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond#getIp()
	 */
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAssetNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getIpAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAote() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLifeCycle() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<String> getEiidNotInList() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPayee() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getAmount() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getEiinsdate_gt() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiinsdate_lt() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getEiusername() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
