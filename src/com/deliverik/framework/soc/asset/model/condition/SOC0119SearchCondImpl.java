package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;

/**
 * �ʲ���ϵ��Ϣ��������ʵ��
 * 
 */
public class SOC0119SearchCondImpl implements SOC0119SearchCond {

	/** �ʲ�ID�����������⣩ */
	protected String eiid;
	
	/** �ʲ���汾�����������⣩ */
	protected String eiversion;
	
	/** �ʲ�С�汾�����������⣩ */
	protected String eismallversion;
	
	/** �ʲ���ϵ�� */
	protected String eirrelationcode;
	
	/** �ʲ�ID������ */
	protected Integer pareiid;
	
	/** �ʲ���汾������ */
	protected Integer parversion;
	
	/** �ʲ�С�汾������ */
	protected Integer parsmallversion;
	
	/** �ʲ�ID������ */
	protected Integer cldeiid;
	
	/** �ʲ���汾������ */
	protected Integer cldversion;
	
	/** �ʲ�С�汾������ */
	protected Integer cldsmallversion;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag;
	
	/** �ʲ���ϵID��ƽ̨������ */
	protected String eirrelation;
	protected String[] eirrelation_in;
	protected String eirrelations;
	
	/** �ʲ���ϵ�Ƿ����ɾ����ʶ��ƽ̨������ */
	protected String eirstatus;
	
	/** �ʲ���ϵ˵����ƽ̨������ */
	protected String eirdesc;
	
	/** ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ��ƽ̨������ */
	protected String eirinfo;
	
	protected String pareiids;
	
	protected String cldeiids;
	
	protected boolean flag;
	
	/** �ʲ�ģ��ID������ */
	protected Integer cldeid;
	
	/** �ʲ�ģ��ID������ */
	protected Integer pareid;
	
	protected List<Integer> cldriid_in;
	
	public List<Integer> getCldriid_in() {
		return cldriid_in;
	}

	public void setCldriid_in(List<Integer> cldriid_in) {
		this.cldriid_in = cldriid_in;
	}

	/**
	 * �ʲ�ID�����������⣩ȡ��
	 * @return �ʲ�ID�����������⣩
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�����������⣩�趨
	 *
	 * @param eiid �ʲ�ID�����������⣩
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * �ʲ�ID�������趨
	 *
	 * @param pareiid �ʲ�ID������
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * �ʲ�ID�������趨
	 *
	 * @param cldeiid �ʲ�ID������
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * �ʲ���ϵIDȡ��
	 * @return �ʲ���ϵID
	 */
	public String getEirrelation() {
		return eirrelation;
	}

	/**
	 * �ʲ���ϵID�趨
	 *
	 * @param eirrelation �ʲ���ϵID
	 */
	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}

	/**
	 * �ʲ���ϵ�Ƿ����ɾ����ʶȡ��
	 * @return �ʲ���ϵ�Ƿ����ɾ����ʶ
	 */
	public String getEirstatus() {
		return eirstatus;
	}

	/**
	 * �ʲ���ϵ�Ƿ����ɾ����ʶ�趨
	 *
	 * @param eirstatus �ʲ���ϵ�Ƿ����ɾ����ʶ
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	/**
	 * �ʲ���ϵ˵��ȡ��
	 * @return �ʲ���ϵ˵��
	 */
	public String getEirdesc() {
		return eirdesc;
	}

	/**
	 * �ʲ���ϵ˵���趨
	 *
	 * @param eirdesc �ʲ���ϵ˵��
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}
	
	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣȡ��
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	public String getEirinfo() {
		return eirinfo;
	}

	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ�趨
	 *
	 * @param eirinfo ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	public void setEirinfo(String eirinfo) {
		this.eirinfo = eirinfo;
	}
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getParversion() {
		return parversion;
	}

	/**
	 * �����ʲ���汾�趨
	 *
	 * @param parversion �����ʲ���汾
	 */
	public void setParversion(Integer parversion) {
		this.parversion = parversion;
	}
	
	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getParsmallversion() {
		return parsmallversion;
	}

	/**
	 * �����ʲ�С�汾�趨
	 *
	 * @param parsmallversion �����ʲ�С�汾
	 */
	public void setParsmallversion(Integer parsmallversion) {
		this.parsmallversion = parsmallversion;
	}
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getCldversion() {
		return cldversion;
	}

	/**
	 * �����ʲ���汾�趨
	 *
	 * @param cldversion �����ʲ���汾
	 */
	public void setCldversion(Integer cldversion) {
		this.cldversion = cldversion;
	}

	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getCldsmallversion() {
		return cldsmallversion;
	}

	/**
	 * �����ʲ�С�汾�趨
	 *
	 * @param cldsmallversion �����ʲ�С�汾
	 */
	public void setCldsmallversion(Integer cldsmallversion) {
		this.cldsmallversion = cldsmallversion;
	}

	/**
	 * �߼�ɾ����ʶȡ��
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * �߼�ɾ����ʶ�������趨
	 *
	 * @param deleteflag �߼�ɾ����ʶ������
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * �ʲ���汾�����������⣩ȡ��
	 * 
	 * @return �ʲ���汾�����������⣩
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ���汾�����������⣩�趨
	 * 
	 * @param eiversion �ʲ���汾�����������⣩
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �ʲ�С�汾�����������⣩
	 * 
	 * @return �ʲ�С�汾�����������⣩
	 */
	public String getEismallversion() {
		return eismallversion;
	}

	/**
	 * �ʲ�С�汾�����������⣩
	 * 
	 * @param eismallversion �ʲ�С�汾�����������⣩
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}

	public String getEirrelationcode() {
		return eirrelationcode;
	}

	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}

	public String getPareiids() {
		return pareiids;
	}

	public void setPareiids(String pareiids) {
		this.pareiids = pareiids;
	}

	public String getCldeiids() {
		return cldeiids;
	}

	public void setCldeiids(String cldeiids) {
		this.cldeiids = cldeiids;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/**
	 * eirrelation_inȡ��
	 *
	 * @return eirrelation_in eirrelation_in
	 */
	public String[] getEirrelation_in() {
		return eirrelation_in;
	}

	/**
	 * eirrelation_in�趨
	 *
	 * @param eirrelation_in eirrelation_in
	 */
	public void setEirrelation_in(String[] eirrelation_in) {
		this.eirrelation_in = eirrelation_in;
	}

	public String getEirrelations() {
		return eirrelations;
	}

	public void setEirrelations(String eirrelations) {
		this.eirrelations = eirrelations;
	}
	
	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public Integer getPareid() {
		return pareid;
	}

	/**
	 * �ʲ�ģ��ID�������趨
	 *
	 * @param pareid �ʲ�ģ��ID������
	 */
	public void setPareid(Integer pareid) {
		this.pareid = pareid;
	}
	
	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public Integer getCldeid() {
		return cldeid;
	}

	/**
	 * �ʲ�ģ��ID�������趨
	 *
	 * @param cldeid �ʲ�ģ��ID������
	 */
	public void setCldeid(Integer cldeid) {
		this.cldeid = cldeid;
	}
}
