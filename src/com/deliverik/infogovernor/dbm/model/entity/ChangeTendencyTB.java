/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.dbm.model.entity;

 import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;



/**
 * 
 * @Description:变更趋势统计表实体TB类
 * @Author
 * @History
 * @Version V1.0
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="ChangeTendency")
@IdClass(ChangeTendencyTBPK.class)
public class ChangeTendencyTB extends BaseEntity implements Serializable, Cloneable, ChangeTendency{
	
	/**统计年**/
	@Id
	private String ctyear;
	
	/**统计月**/
	@Id
	private String ctmonth;
	
	/**统计日**/
	@Id
	private String ctday;
	
	/**变更数量（已关闭）**/
	private int ctamount;
	
	/**变更成功率**/
	private Double ctsucRate;
	
	/**时间戳**/
	private String Fingerprint;

	public String getCtyear() {
		return ctyear;
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

	public int getCtamount() {
		return ctamount;
	}

	public void setCtamount(int ctamount) {
		this.ctamount = ctamount;
	}

	public double getCtsucRate() {
		return ctsucRate;
	}

	public void setCtsucRate(Double ctsucRate) {
		this.ctsucRate = ctsucRate;
	}

	public String getFingerprint() {
		return Fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		Fingerprint = fingerprint;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return new ChangeTendencyTBPK(ctyear, ctmonth, ctday);
	}
}

