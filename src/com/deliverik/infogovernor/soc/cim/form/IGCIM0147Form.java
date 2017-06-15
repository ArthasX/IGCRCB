package com.deliverik.infogovernor.soc.cim.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

@SuppressWarnings("serial")
public class IGCIM0147Form extends BaseForm implements SOC0107SearchCond,SOC0129SearchCond{
	
	/** �ʲ�ID */
	protected String eiid;

	/** �ʲ�ģ��ID */
	protected String eid;
	
	/** �ʲ����԰汾�� */
	protected String civersion;
	
	/** �ʲ�ģ������ID */
	protected String cid;
	
	/** �ʲ�ģ������ֵ */
	protected String civalue;

	/** �ʲ�����С�汾��*/
	protected String cismallversion;
	
	/** ģ�Ͳ���� */
	protected String esyscoding_q;
	
	/** �Ƿ�ɼ̳б�ʶ��ʹ��entity����Ԥ���ֶ�EKEY2, 0����̳У�1�����̳�*/
	protected String ekey2;
	
	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getCiversion() {
		return civersion;
	}

	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	public String getCismallversion() {
		return cismallversion;
	}

	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}

	public String getClabel_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCname() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getEiid_list() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSreilabel_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSrname_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	public String[] getCids() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEiversion() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond#getCheckersion()
	 */
	public int getCheckersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
