package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.base.BaseForm;

/**
 * �����ϵ�༭����FORM
 * 
 */
public class IGASM1207Form extends BaseForm implements IG313Info{

	private static final long serialVersionUID = 1L;

	/** ��ϵID */
	protected Integer eirid;
	
	/** ��ϵID�����֣� */
	protected String eiridStr;

	/** ����ID������ */
	protected Integer pareiid;

	/** �����ʲ�ID������ */
	protected Integer pareid;

	/** �ʲ���ID���ӣ� */
	protected Integer cldeiid;

	/** �ʲ�ID���ӣ� */
	protected Integer cldeid;

	/** ��ϵ����ʱ�� */
	protected String eirupdtime;
	
	/** ��ϵ״̬ */
	protected String eirstatus;
	
	/** ��ϵ˵�� */
	protected String eirdesc;
	
	/** ��ϵ */
	protected String eirrelation;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";

	/** �ʲ���ģ�ͱ��루�ӣ� */
	protected String elabel;

	/** �ʲ�����루�ӣ� */
	protected String eilabel;

	/** �ʲ������ƣ��ӣ� */
	protected String einame;

	/** ��������(��) */
	protected String pareiname;
	
	/** �ʲ����ϵ���� */
	protected String eirrelationcode;
	
	protected String fingerPrint;
	
	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	protected String eirinfo;
	
	/** �ʲ���ϵ���루ƽ̨������ */
	protected String eirsyscodeing;
	
	/** �����ʲ���汾 */
	protected Integer parversion;

	/** �����ʲ�С�汾 */
	protected Integer parsmallversion;

	/** �����ʲ���汾 */
	protected Integer cldversion;

	/** �����ʲ�С�汾 */
	protected Integer cldsmallversion;

	/** �߼�ɾ����ʶ */
	protected String deleteflag;

	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getParversion() {
		return parversion;
	}

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

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * �ʲ���ϵ����ȡ��
	 * @return �ʲ���ϵ����
	 */
	public String getEirsyscodeing() {
		return eirsyscodeing;
	}

	/**
	 * �ʲ���ϵ�����趨
	 *
	 * @param eirsyscodeing �ʲ���ϵ����
	 */
	public void setEirsyscodeing(String eirsyscodeing) {
		this.eirsyscodeing = eirsyscodeing;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * ��ϵIDȡ��
	 * @return ��ϵID
	 */
	public Integer getEirid() {
		if( (this.eiridStr == null) || (this.eiridStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiridStr);
		}
	}

	/**
	 * ��ϵID�趨
	 *
	 * @param eirid ��ϵID
	 */
	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}

	/**
	 * ��ϵID�����֣�ȡ��
	 * @return ��ϵID�����֣�
	 */
	public String getEiridStr() {
		return eiridStr;
	}

	/**
	 * ��ϵID�����֣��趨
	 *
	 * @param eiridStr ��ϵID�����֣�
	 */
	public void setEiridStr(String eiridStr) {
		this.eiridStr = eiridStr;
	}

	/**
	 * ����ID������ȡ��
	 * @return ����ID������
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * ����ID�������趨
	 *
	 * @param pareiid ����ID������
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * �����ʲ�ID������ȡ��
	 * @return �����ʲ�ID������
	 */
	public Integer getPareid() {
		return pareid;
	}

	/**
	 * �����ʲ�ID�������趨
	 *
	 * @param pareid �����ʲ�ID������
	 */
	public void setPareid(Integer pareid) {
		this.pareid = pareid;
	}

	/**
	 * �ʲ���ID���ӣ�ȡ��
	 * @return ����ID���ӣ�
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * �ʲ���ID���ӣ��趨
	 *
	 * @param cldeiid ����ID���ӣ�
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * �ʲ����ʲ�ID���ӣ�ȡ��
	 * @return �ʲ����ʲ�ID���ӣ�
	 */
	public Integer getCldeid() {
		return cldeid;
	}

	/**
	 * �ʲ����ʲ�ID���ӣ��趨
	 *
	 * @param cldeid �ʲ����ʲ�ID���ӣ�
	 */
	public void setCldeid(Integer cldeid) {
		this.cldeid = cldeid;
	}

	/**
	 * ��ϵ����ʱ��ȡ��
	 * @return ��ϵ����ʱ��
	 */
	public String getEirupdtime() {
		return eirupdtime;
	}

	/**
	 * ��ϵ����ʱ���趨
	 *
	 * @param eirupdtime ��ϵ����ʱ��
	 */
	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}

	/**
	 * ��ϵ״̬ȡ��
	 * @return ��ϵ״̬
	 */
	public String getEirstatus() {
		return eirstatus;
	}

	/**
	 * ��ϵ�趨
	 *
	 * @param eirstatus ��ϵ
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	/**
	 * ��ϵ˵��ȡ��
	 * @return ��ϵ˵��
	 */
	public String getEirdesc() {
		return eirdesc;
	}

	/**
	 * ��ϵ˵���趨
	 *
	 * @param eirdesc ��ϵ˵��
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	/**
	 * ��ϵȡ��
	 * @return ��ϵ
	 */
	public String getEirrelation() {
		return eirrelation;
	}

	/**
	 * ��ϵ�趨
	 *
	 * @param eirelation ��ϵ
	 */
	public void setEirrelation(String eirrelation) {
		this.eirrelation = eirrelation;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}


	/**
	 * �༭ģʽ�趨
	 *
	 * @param mode �༭ģʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * �ʲ���ģ�ͱ��루�ӣ�ȡ��
	 * @return �ʲ���ģ�ͱ��루�ӣ�
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ���ģ�ͱ��루�ӣ��趨
	 *
	 * @param elabel �ʲ���ģ�ͱ��루�ӣ�
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ�����루�ӣ�ȡ��
	 * @return �Ų�����루�ӣ�
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�����루�ӣ��趨
	 *
	 * @param eilabel �ʲ�����루�ӣ�
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ������ƣ��ӣ�ȡ��
	 * @return �ʲ������ƣ��ӣ�
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������ƣ��ӣ��趨
	 *
	 * @param einame �ʲ������ƣ��ӣ�
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPareiname() {
		return pareiname;
	}

	/**
	 * ���������趨
	 *
	 * @param pareiname ��������
	 */
	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
	}

	public IG749Info getCldEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}

	public IG749Info getParEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ʲ����ϵ����ȡ��
	 * @return �ʲ����ϵ����
	 */
	public String getEirrelationcode() {
		return eirrelationcode;
	}

	/**
	 * �ʲ����ϵ�����趨
	 *
	 * @param eirrelationcode �ʲ����ϵ����
	 */
	public void setEirrelationcode(String eirrelationcode) {
		this.eirrelationcode = eirrelationcode;
	}

	public String getParflag() {
		// TODO Auto-generated method stub
		return null;
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
}
