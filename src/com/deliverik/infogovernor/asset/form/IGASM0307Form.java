package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;

/**
 * �豸��ϵ�༭����FORM
 * 
 */
public class IGASM0307Form extends BaseForm implements SOC0119Info{

	private static final long serialVersionUID = 1L;

	/** ��ϵID */
	protected Integer eirid;
	
	/** ��ϵID�����֣� */
	protected String eiridStr;

	/** �豸ID������ */
	protected Integer pareiid;
	
	/** �豸label������ */
	protected String pareilabel;

	/** �豸�ʲ�ID������ */
	protected String pareid;

	/** �ʲ���ID���ӣ� */
	protected Integer cldeiid;

	/** �ʲ�ID���ӣ� */
	protected String cldeid;

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

	/** �豸����(��) */
	protected String pareiname;
	
	/** �ʲ����ϵ���� */
	protected String eirrelationcode;
	
	/** �ʲ����ϵ */
	protected String tempeirrelation;
	
	protected String fingerPrint;
	
	/** �ʲ����������ڵ�ʵ���ʶ */
	protected Integer eirootmark;

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
	
	/** ��ϵ����(��ͨ��ϵ��������ϵ) */
	protected String relationType;
	
	/** ��������(�����߼�) */
	protected String belongType;
	/**
	 * ��������(�����߼�) ȡ��
	 * @return ��������(�����߼�) 
	 */
	public String getBelongType() {
		return belongType;
	}
	/**
	 * ��������(�����߼�) �趨
	 *
	 * @param belongType ��������(�����߼�) 
	 */
	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}
	/**
	 * ��ϵ����ȡ��
	 * @return ��ϵ����
	 */
	public String getRelationType() {
		return relationType;
	}
	/**
	 * ��ϵ�����趨
	 *
	 * @param relationType ��ϵ����
	 */
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
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

	public String getPareilabel() {
		return pareilabel;
	}

	public void setPareilabel(String pareilabel) {
		this.pareilabel = pareilabel;
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
	 * �豸ID������ȡ��
	 * @return �豸ID������
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * �豸ID�������趨
	 *
	 * @param pareiid �豸ID������
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * �豸�ʲ�ID������ȡ��
	 * @return �豸�ʲ�ID������
	 */
	public String getPareid() {
		return pareid;
	}

	/**
	 * �豸�ʲ�ID�������趨
	 *
	 * @param pareid �豸�ʲ�ID������
	 */
	public void setPareid(String pareid) {
		this.pareid = pareid;
	}

	/**
	 * �ʲ���ID���ӣ�ȡ��
	 * @return �豸ID���ӣ�
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * �ʲ���ID���ӣ��趨
	 *
	 * @param cldeiid �豸ID���ӣ�
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * �ʲ����ʲ�ID���ӣ�ȡ��
	 * @return �ʲ����ʲ�ID���ӣ�
	 */
	public String getCldeid() {
		return cldeid;
	}

	/**
	 * �ʲ����ʲ�ID���ӣ��趨
	 *
	 * @param cldeid �ʲ����ʲ�ID���ӣ�
	 */
	public void setCldeid(String cldeid) {
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
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getPareiname() {
		return pareiname;
	}

	/**
	 * �豸�����趨
	 *
	 * @param pareiname �豸����
	 */
	public void setPareiname(String pareiname) {
		this.pareiname = pareiname;
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

	/**
	 * �ʲ����ϵȡ��
	 * @return �ʲ����ϵ
	 */
	public String getTempeirrelation() {
		return tempeirrelation;
	}

	/**
	 * �ʲ����ϵ�趨
	 *
	 * @param tempeirrelation �ʲ����ϵ
	 */
	public void setTempeirrelation(String tempeirrelation) {
		this.tempeirrelation = tempeirrelation;
	}

	public String getParflag() {
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
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark() {
		return eirootmark;
	}
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶ�趨
	 *
	 * @param eirootmark �ʲ����������ڵ�ʵ���ʶ
	 */
	public void setEirootmark(Integer eirootmark) {
		this.eirootmark = eirootmark;
	}
	public SOC0123Info getCldEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}
	public SOC0123Info getParEntityItemVW() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
