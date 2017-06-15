package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.base.BaseForm;

/**
 * �ʲ����ϵ�༭����FORM
 * IGASM0207Form ActionForm
 * 
 */
public class IGASM0207Form extends BaseForm implements IG313Info{

	private static final long serialVersionUID = 1L;

	/** �ʲ����ϵID */
	protected Integer eirid;
	
	/** �ʲ����ϵID�����֣� */
	protected String eiridStr;

	/** �ʲ���ID������ */
	protected Integer pareiid;
	
	/** �ʲ���label������ */
	protected String pareilabel;

	/** �ʲ�ID������ */
	protected Integer pareid;

	/** �ʲ���ID���ӣ� */
	protected Integer cldeiid;

	/** �ʲ�ID���ӣ� */
	protected Integer cldeid;

	/** �ʲ����ϵ����ʱ�� */
	protected String eirupdtime;
	
	/** �ʲ����ϵ״̬ */
	protected String eirstatus;
	
	/** �ʲ����ϵ˵�� */
	protected String eirdesc;
	
	/** �ʲ����ϵ */
	protected String eirrelation;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";

	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ������ */
	protected String eilabel;

	/** �ʲ������� */
	protected String einame;

	/** �ʲ���(��)���� */
	protected String pareiname;
	
	/** �ʲ����ϵ���� */
	protected String eirrelationcode;
	
	/** �ʲ����ϵ */
	protected String tempeirrelation;
	
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

	public String getPareilabel() {
		return pareilabel;
	}

	public void setPareilabel(String pareilabel) {
		this.pareilabel = pareilabel;
	}

	/**
	 * �ʲ����ϵIDȡ��
	 * @return �ʲ����ϵID
	 */
	public Integer getEirid() {
		if( (this.eiridStr == null) || (this.eiridStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiridStr);
		}
	}

	/**
	 * �ʲ����ϵID�趨
	 *
	 * @param eirid �ʲ����ϵID
	 */
	public void setEirid(Integer eirid) {
		this.eirid = eirid;
	}

	/**
	 * �ʲ����ϵID�����֣�ȡ��
	 * @return �ʲ����ϵID�����֣�
	 */
	public String getEiridStr() {
		return eiridStr;
	}

	/**
	 * �ʲ����ϵID�����֣��趨
	 *
	 * @param eiridStr �ʲ����ϵID�����֣�
	 */
	public void setEiridStr(String eiridStr) {
		this.eiridStr = eiridStr;
	}

	/**
	 * �ʲ���ID������ȡ��
	 * @return �ʲ���ID������
	 */
	public Integer getPareiid() {
		return pareiid;
	}

	/**
	 * �ʲ���ID�������趨
	 *
	 * @param pareiid �ʲ���ID������
	 */
	public void setPareiid(Integer pareiid) {
		this.pareiid = pareiid;
	}

	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getPareid() {
		return pareid;
	}

	/**
	 * �ʲ�ID�������趨
	 *
	 * @param pareid �ʲ�ID������
	 */
	public void setPareid(Integer pareid) {
		this.pareid = pareid;
	}

	/**
	 * �ʲ���ID���ӣ�ȡ��
	 * @return �ʲ���ID���ӣ�
	 */
	public Integer getCldeiid() {
		return cldeiid;
	}

	/**
	 * �ʲ���ID���ӣ��趨
	 *
	 * @param cldeiid �ʲ���ID���ӣ�
	 */
	public void setCldeiid(Integer cldeiid) {
		this.cldeiid = cldeiid;
	}

	/**
	 * �ʲ�ID���ӣ�ȡ��
	 * @return �ʲ�ID���ӣ�
	 */
	public Integer getCldeid() {
		return cldeid;
	}

	/**
	 * �ʲ�ID���ӣ��趨
	 *
	 * @param cldeid �ʲ�ID���ӣ�
	 */
	public void setCldeid(Integer cldeid) {
		this.cldeid = cldeid;
	}

	/**
	 * �ʲ����ϵ����ʱ��ȡ��
	 * @return �ʲ����ϵ����ʱ��
	 */
	public String getEirupdtime() {
		return eirupdtime;
	}

	/**
	 * �ʲ����ϵ����ʱ���趨
	 *
	 * @param eirupdtime �ʲ����ϵ����ʱ��
	 */
	public void setEirupdtime(String eirupdtime) {
		this.eirupdtime = eirupdtime;
	}

	/**
	 * �ʲ����ϵ״̬ȡ��
	 * @return �ʲ����ϵ״̬
	 */
	public String getEirstatus() {
		return eirstatus;
	}

	/**
	 * �ʲ����ϵ�趨
	 *
	 * @param eirstatus �ʲ����ϵ
	 */
	public void setEirstatus(String eirstatus) {
		this.eirstatus = eirstatus;
	}

	/**
	 * �ʲ����ϵ˵��ȡ��
	 * @return �ʲ����ϵ˵��
	 */
	public String getEirdesc() {
		return eirdesc;
	}

	/**
	 * �ʲ����ϵ˵���趨
	 *
	 * @param eirdesc �ʲ����ϵ˵��
	 */
	public void setEirdesc(String eirdesc) {
		this.eirdesc = eirdesc;
	}

	/**
	 * �ʲ����ϵȡ��
	 * @return �ʲ����ϵ
	 */
	public String getEirrelation() {
		return eirrelation;
	}

	/**
	 * �ʲ����ϵ�趨
	 *
	 * @param eirelation �ʲ����ϵ
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
	 * �ʲ�ģ�ͱ���ȡ��
	 * @return �ʲ�ģ�ͱ���
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * �ʲ�ģ�ͱ����趨
	 *
	 * @param elabel �ʲ�ģ�ͱ���
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * �ʲ������ȡ��
	 * @return �ʲ������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �ʲ�������趨
	 *
	 * @param eilabel �ʲ������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ��������趨
	 *
	 * @param einame �ʲ�������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �ʲ�������������ȡ��
	 * @return �ʲ������ƣ�����
	 */
	public String getPareiname() {
		return pareiname;
	}

	/**
	 * �ʲ������������趨
	 *
	 * @param pareiname �ʲ�����������
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
