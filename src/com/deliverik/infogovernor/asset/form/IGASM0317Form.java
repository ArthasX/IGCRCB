package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.base.BaseForm;

/**
 * �豸�������༭����FORM
 * 
 */
public class IGASM0317Form extends BaseForm implements IG013Info{

	private static final long serialVersionUID = 1L;

	/** �豸ID */
	protected Integer eiid;
	
	/** �豸ID�����֣� */
	protected String eiidStr;

	/** �ʲ�ģ��ID */
	protected Integer eid;
	
	/** �ʲ�ģ��ID�����֣� */
	protected String eidStr;
	
	/** �ʲ�ģ�ͱ��� */
	protected String elabel;

	/** �ʲ�ģ������ */
	protected String ename;

	/** �豸���� */
	protected String einame;
	
	/** �豸���� */
	protected String eilabel;

	/** �豸˵�� */
	protected String eidesc;

	/** �豸״̬ */
	protected String eistatus;

	/** �豸���ʱ�� */
	protected String eiupdtime;
	
	/** �豸�汾�� */
	protected Integer eiversion;

	/** �豸�Ǽ��� */
	protected String eiinsdate;
	
	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";
	
	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������ģ��*/
	protected String esyscoding;
	
	/** �豸�������ģ���豸ID */
	protected String pareiid;
	
	/** �豸��������豸label*/
	protected String[] eilabels;
	
	/** �豸��������豸name */
	protected String[] einames;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** �豸�������ÿ��������������*/
	protected String maxcount;
	
	/** �豸���������������*/
	protected String addcount;
	
	/** �豸�������ÿ����¼��ID*/
	protected String[] ids;
	
	/** �豸��������ύ��ÿ����¼��ID*/
	protected String[] ids_default;
	
	/** �豸��������ύ��ÿ���豸�����к�*/
	protected String[] serials;

	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/**
	 * @return the serials
	 */
	public String[] getSerials() {
		return serials;
	}
	
	/**
	 * @param serials the serials to set
	 */
	public void setSerials(String[] serials) {
		this.serials = serials;
	}

	/**
	 * @return the ids_default
	 */
	public String[] getIds_default() {
		return ids_default;
	}

	/**
	 * @param ids_default the ids_default to set
	 */
	public void setIds_default(String[] ids_default) {
		this.ids_default = ids_default;
	}

	/**
	 * @return the ids
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * @param ids the ids to set
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * @return the maxcount
	 */
	public String getMaxcount() {
		return maxcount;
	}

	/**
	 * @return the addcount
	 */
	public String getAddcount() {
		return addcount;
	}

	/**
	 * @param maxcount the maxcount to set
	 */
	public void setMaxcount(String maxcount) {
		this.maxcount = maxcount;
	}

	/**
	 * @param addcount the addcount to set
	 */
	public void setAddcount(String addcount) {
		this.addcount = addcount;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** �豸��������豸type */
	protected String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getEilabels() {
		return eilabels;
	}

	public void setEilabels(String[] eilabels) {
		this.eilabels = eilabels;
	}

	public String[] getEinames() {
		return einames;
	}

	public void setEinames(String[] einames) {
		this.einames = einames;
	}

	public String getPareiid() {
		return pareiid;
	}

	public void setPareiid(String pareiid) {
		this.pareiid = pareiid;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * �豸IDȡ��
	 * @return �豸ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}

	/**
	 * �豸ID�趨
	 *
	 * @param eiid �豸ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * �豸ID�����֣�ȡ��
	 * @return �豸ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * �豸ID�����֣��趨
	 *
	 * @param eiidStr �豸ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid() {
			return eid;
	}

	/**
	 * �ʲ�ģ��ID�趨
	 *
	 * @param eid �ʲ�ģ��ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�ģ��ID�����֣�ȡ��
	 * @return �ʲ�ģ��ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�ģ��ID�����֣��趨
	 *
	 * @param eidStr �ʲ�ģ��ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
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
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * �ʲ�ģ�������趨
	 *
	 * @param ename �ʲ�ģ������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �豸�����趨
	 *
	 * @param einame �豸����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �豸����ȡ��
	 * @return �豸����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �豸�����趨
	 *
	 * @param eilabel �豸����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �豸˵��ȡ��
	 * @return �豸˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * �豸˵���趨
	 *
	 * @param eidesc �豸˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * �豸����ʱ��ȡ��
	 * @return �豸����ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �豸����ʱ���趨
	 *
	 * @param eiupdtime �豸����ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * �豸״̬ȡ��
	 * @return �豸״̬
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * �豸״̬�趨
	 *
	 * @param eistatus �豸״̬
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * �豸�汾��ȡ��
	 * @return �豸�汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �豸�汾���趨
	 *
	 * @param eiversion �豸�汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �༭ģʽȡ��
	 * @return �༭ģʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �豸�Ǽ���ȡ��
	 * @return �豸�Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �豸�Ǽ����趨
	 *
	 * @param eiinsdate �豸�Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
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
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid() {
		return eiuserid;
	}
	
	/**
	 * �ʲ��������趨
	 *
	 * @param eiuserid �ʲ�������
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername() {
		return eiusername;
	}
	
	/**
	 * �ʲ������������趨
	 *
	 * @param eiusername �ʲ�����������
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	public Integer getEirootmark() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * �ʲ�С�汾�趨
	 *
	 * @param eismallversion �ʲ�С�汾
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}


}
