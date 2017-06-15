/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description:�������ͳ�Ʊ�ʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="ChangeTendency")
@IdClass(ChangeTendencyTBPK.class)
public class ChangeTendencyTB extends BaseEntity implements Serializable, Cloneable, ChangeTendency{
	
	/**ͳ����**/
	@Id
	private String ctyear;
	
	/**ͳ����**/
	@Id
	private String ctmonth;
	
	/**ͳ����**/
	@Id
	private String ctday;
	
	/**����������ѹرգ�**/
	private int ctamount;
	
	/**����ɹ���**/
	private Double ctsucRate;
	
	/**ʱ���**/
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
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return new ChangeTendencyTBPK(ctyear, ctmonth, ctday);
	}
}

