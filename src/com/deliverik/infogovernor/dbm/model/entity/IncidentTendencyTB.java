/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.dbm.model.entity;

 import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;



/**
 * 
 * @Description:�¼�����ͳ�Ʊ�ʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IncidentTendency")
@IdClass(IncidentTendencyTBPK.class)
public class IncidentTendencyTB extends BaseEntity implements Serializable, Cloneable, IncidentTendency{

	/**ͳ����**/
	@Id
	private String ityear;
	
	/**ͳ����**/
	@Id
	private String itmonth;
	
	/**ͳ����**/
	@Id
	private String itday;

	
	/**�¼�����**/
	private int itamount;
	
	
	/**�¼�ƽ�����ʱ�䣨��������**/
	private int itaveragetime;;
	
	
	/**ʱ���**/
	private String Fingerprint;


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


	public int getItamount() {
		return itamount;
	}

	public void setItamount(int itamount) {
		this.itamount = itamount;
	}

	public int getItaveragetime() {
		return itaveragetime;
	}

	public void setItaveragetime(int itaveragetime) {
		this.itaveragetime = itaveragetime;
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
		return new IncidentTendencyTBPK(ityear, itmonth, itday);
	}
}

