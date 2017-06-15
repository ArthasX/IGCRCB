package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;
import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * �������ͳ�Ʊ�ʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class ChangeTendencyTBPK extends BasePK implements Serializable {

	/**ͳ����**/
	private String ctyear;
	
	/**ͳ����**/
	private String ctmonth;
	
	/**ͳ����**/
	private String ctday;

	public String getCtyear() {
		return ctyear;
	}

	public ChangeTendencyTBPK(){}
	
	public ChangeTendencyTBPK(String ctyear,String ctmonth,String ctday){
		this.ctyear = ctyear;
		this.ctmonth = ctmonth;
		this.ctday = ctday;
	}
	
	public void setCtyear(String ctyear) {
		this.ctyear = ctyear;
	}

	public String getCtmonth() {
		return ctmonth;
	}

	public void setCtmonth(String ctmonth) {
		this.ctmonth = ctmonth;
	}

	public String getCtday() {
		return ctday;
	}

	public void setCtday(String ctday) {
		this.ctday = ctday;
	}

}
