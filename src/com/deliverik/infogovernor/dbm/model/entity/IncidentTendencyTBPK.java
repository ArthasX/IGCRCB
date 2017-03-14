package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;
import com.deliverik.framework.base.BasePK;

/**
 * <p>
 *�¼�����ͳ�Ʊ�ʵ������
 * </p>
 */
@SuppressWarnings("serial")
public class IncidentTendencyTBPK extends BasePK implements Serializable {

	/**ͳ����**/
	private String ityear;
	
	/**ͳ����**/
	private String itmonth;
	
	/**ͳ����**/
	private String itday;

	public IncidentTendencyTBPK(){}
	
	public IncidentTendencyTBPK(String ityear,String itmonth,String itday){
		this.ityear = ityear;
		this.itmonth = itmonth;
		this.itday = itday;
	}

	public String getItyear() {
		return ityear;
	}
	
	public void setItyear(String ityear) {
		this.ityear = ityear;
	}

	public String getItmonth() {
		return itmonth;
	}

	public void setItmonth(String itmonth) {
		this.itmonth = itmonth;
	}

	public String getItday() {
		return itday;
	}

	public void setItday(String itday) {
		this.itday = itday;
	}
	
}
