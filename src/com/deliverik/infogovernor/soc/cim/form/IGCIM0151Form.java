/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �������ˣ�Ӧ����ϸFORM
 * ��������: �������ˣ�Ӧ����ϸFORM
 * ������¼: 2013/10/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM0151Form extends BaseForm {

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
}
