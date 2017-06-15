package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;
import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * 变更趋势统计表实体主键
 * </p>
 */
@SuppressWarnings("serial")
public class ChangeTendencyTBPK extends BasePK implements Serializable {

	/**统计年**/
	private String ctyear;
	
	/**统计月**/
	private String ctmonth;
	
	/**统计日**/
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
