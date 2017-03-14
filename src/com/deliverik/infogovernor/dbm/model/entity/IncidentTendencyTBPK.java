package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;
import com.deliverik.framework.base.BasePK;

/**
 * <p>
 *事件趋势统计表实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class IncidentTendencyTBPK extends BasePK implements Serializable {

	/**统计年**/
	private String ityear;
	
	/**统计月**/
	private String itmonth;
	
	/**统计日**/
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
