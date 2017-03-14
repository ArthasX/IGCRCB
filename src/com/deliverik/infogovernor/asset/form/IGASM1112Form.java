/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
 * @Description: ����༭����FORM
 * @Author  
 * @History 2009-8-17     �½�
 * @Version V2.0
 */
public class IGASM1112Form extends BaseForm implements SOC0118Info{

	private static final long serialVersionUID = 1L;
	
	/** �������� */
	protected String eimark;
	/** ����ID */
	protected Integer eiid;
	
	/** ����ID�����֣� */
	protected String eiidStr;

	/** �ʲ�����ID */
	protected String eid;
	
	/** �ʲ�����ID�����֣� */
	protected String eidStr;
	
	/** �������� */
	protected String einame;
	
	/** �������� */
	protected String jiname;
	
	/** ������� */
	protected String eilabel;
	
	/** ���ܱ��� */
	protected String jilabel;
	
	/** ����˵�� */
	protected String eidesc;
	
	/** ����˵�� */
	protected String jidesc;
	/** ����汾�� */
	protected Integer eiversion;
	
	/** �Ƿ������ñ�־λ */
	protected String graphstatus;

	/** ������ʱ�� */
	protected String eiupdtime;
	
	/** ����Ǽ��� */
	protected String eiinsdate;
	
	/** ����λ�ã�X�� */
	protected String x_value;
	
	/** ����λ�ã�Y�� */
	protected String y_value;
	
	/** �����ڻ�����λ�ã�U�� */
	protected String wz_value;
	
	/** ����߶ȣ�U�� */
	protected String u_total;
	
	/** ���ܸ߶ȣ�J�� */
	protected String j_total;
	
	/** ���ܿ�ȣ�W�� */
	protected String w_total;
	
	/** �������� */
	protected String x_width;

	/** ��������� */
	protected String y_width;

	/** �༭ģʽ���Ǽ�/����� */
	protected String mode = "0";

	/** �ʲ�����������*/
	protected String eiorgsyscoding;
	
	/** �ʲ���������������*/
	protected String eiorgname;
	
	/** �ʲ�������*/
	protected String eiuserid;
	
	/** �ʲ�����������*/
	protected String eiusername;
	
	protected String fingerPrint;
	
	/** ������*/
	protected String standard;
	
	/** ��������*/
	protected String weight;
	
	/** ���ѹ*/
	protected String voltage;

	/** �����*/
	protected String maxload;
	
	/** ������*/
	protected String maxpower;
	
	/** �ʲ�С�汾*/
	protected Integer eismallversion;
	
	/** ���ܺ���U�� */
	protected String width;
	
	/** ƽ̨�����ֶ� */
	protected String ptemp;
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
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
	
	/**
	 * �ʲ�ɾ�����
	 */
	protected String deleteflag;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/** �ʲ����������Ͳ����*/
	public String esyscoding;
	
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
	 * �������ͱ�ʶȡ��
	 * @return �������ͱ�ʶȡ��
	 */
	public String getEimark() {
		return eimark;
	}
	/**
	 * �������ͱ�ʶ�趨
	 * @return �������ͱ�ʶ�趨
	 */
	public void setEimark(String eimark) {
		this.eimark = eimark;
	}
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		if( (this.eiidStr == null) || (this.eiidStr.equals(""))){
			return null;
		} else {
			return Integer.valueOf(this.eiidStr);
		}
	}
	
	/**
	 * �Ƿ����ϼܱ�־λȡ��
	 * @return �Ƿ����ϼܱ�־λ
	 */
	public String getGraphstatus() {
		return graphstatus;
	}
	
	/**
	 * �Ƿ����ϼܱ�־λ�趨
	 *
	 * @param eismallversion �Ƿ����ϼܱ�־λ
	 */
	public void setGraphstatus(String graphstatus) {
		this.graphstatus = graphstatus;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}


	/**
	 * ����ID�����֣�ȡ��
	 * @return ����ID�����֣�
	 */
	public String getEiidStr() {
		return eiidStr;
	}

	/**
	 * ����ID�����֣��趨
	 *
	 * @param eiidStr ����ID�����֣�
	 */
	public void setEiidStr(String eiidStr) {
		this.eiidStr = eiidStr;
	}

	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String getEid() {
		if( (this.eidStr == null) || (this.eidStr.equals(""))){
			return null;
		} else {
			return this.eidStr;
		}
	}

	/**
	 * �ʲ�����ID�趨
	 *
	 * @param eid �ʲ�����ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * �ʲ�����ID�����֣�ȡ��
	 * @return �ʲ�����ID�����֣�
	 */
	public String getEidStr() {
		return eidStr;
	}

	/**
	 * �ʲ�����ID�����֣��趨
	 *
	 * @param eidStr �ʲ�����ID�����֣�
	 */
	public void setEidStr(String eidStr) {
		this.eidStr = eidStr;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ��������趨
	 *
	 * @param eilabel �������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * ����˵���趨
	 *
	 * @param eidesc ����˵��
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * ����汾��ȡ��
	 * @return ����汾��
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * ����汾���趨
	 *
	 * @param eiversion ����汾��
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �������ʱ��ȡ��
	 * @return �������ʱ��
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * �������ʱ���趨
	 *
	 * @param eiupdtime �������ʱ��
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}

	/**
	 * ����Ǽ���ȡ��
	 * @return ����Ǽ���
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * ����Ǽ����趨
	 *
	 * @param eiinsdate ����Ǽ���
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ����λ�ã�X��ȡ��
	 * @return ����λ�ã�X��
	 */
	public String getX_value() {
		return x_value;
	}

	/**
	 * ����λ�ã�X���趨
	 *
	 * @param x_value ����λ�ã�X��
	 */
	public void setX_value(String x_value) {
		this.x_value = x_value;
	}

	/**
	 * ����λ�ã�Y��ȡ��
	 * @return ����λ�ã�Y��
	 */
	public String getY_value() {
		return y_value;
	}

	/**
	 * ����λ�ã�Y���趨
	 *
	 * @param y_value ����λ�ã�Y��
	 */
	public void setY_value(String y_value) {
		this.y_value = y_value;
	}

	/**
	 * ����߶ȣ�U��ȡ��
	 * @return ����߶ȣ�U��
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * ����߶ȣ�U���趨
	 *
	 * @param u_total ����߶ȣ�U��
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}


	/**
	 * ���ܿ�ȣ�W��ȡ��
	 * @return ����߶ȣ�W��
	 */
	public String getW_total() {
		return w_total;
	}

	/**
	 * ���ܿ�ȣ�W���趨
	 * @return ���ܸ߶ȣ�W��
	 */
	public void setW_total(String w_total) {
		this.w_total = w_total;
	}
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getX_width() {
		return x_width;
	}

	/**
	 * ���������趨
	 *
	 * @param x_width ��������
	 */
	public void setX_width(String x_width) {
		this.x_width = x_width;
	}

	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String getY_width() {
		return y_width;
	}

	/**
	 * ����������趨
	 *
	 * @param y_width ���������
	 */
	public void setY_width(String y_width) {
		this.y_width = y_width;
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
	 * �ʲ����������Ͳ����ȡ��
	 * @return �ʲ����������Ͳ����
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �ʲ����������Ͳ�����趨
	 *
	 * @param mode �ʲ����������Ͳ����
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEistatus() {
		// TODO Auto-generated method stub
		return null;
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

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getJiname() {
		return jiname;
	}
	public void setJiname(String jiname) {
		this.jiname = jiname;
	}
	public String getJilabel() {
		return jilabel;
	}
	public void setJilabel(String jilabel) {
		this.jilabel = jilabel;
	}
	public String getJidesc() {
		return jidesc;
	}
	public void setJidesc(String jidesc) {
		this.jidesc = jidesc;
	}
	public String getJ_total() {
		return j_total;
	}
	public void setJ_total(String j_total) {
		this.j_total = j_total;
	}

	public String getWz_value() {
		return wz_value;
	}

	public void setWz_value(String wz_value) {
		this.wz_value = wz_value;
	}

	public String getPtemp() {
		return ptemp;
	}

	public void setPtemp(String ptemp) {
		this.ptemp = ptemp;
	}

	public Integer getEirootmark() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * �����ȡ��
     *
     * @return maxload �����
     */
    public String getMaxload() {
        return maxload;
    }

    /**
     * ������ȡ��
     *
     * @return maxpower ������
     */
    public String getMaxpower() {
        return maxpower;
    }

    /**
     * ������趨
     *
     * @param maxload �����
     */
    public void setMaxload(String maxload) {
        this.maxload = maxload;
    }

    /**
     * �������趨
     *
     * @param maxpower ������
     */
    public void setMaxpower(String maxpower) {
        this.maxpower = maxpower;
    }

	public SOC0117TB getSoc0117TB() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
