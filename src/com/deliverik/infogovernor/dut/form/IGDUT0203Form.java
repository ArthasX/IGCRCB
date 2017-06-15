/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.model.DutyPlan;

public class IGDUT0203Form extends BaseForm {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �����ID
	 */
	protected Integer dadid;

	/**
	 * ֵ������
	 */
	protected String dadcategory;
	
	/**
	 * ������
	 */
	protected String dadtype;
	
	/**
	 * �������
	 */
	protected String dadname;
	
	/**
	 * �ʱ������
	 */
	protected String dadlimtime;
	
	/**
	 * ���������
	 */
	protected String dadcontent;
	
	/**
	 * ���˵��
	 */
	protected String dadinfo;
	
	/**
	 * ʹ��״̬
	 */
	protected String dadstatus;
	
	/**
	 * ������ID
	 */
	protected String daduserid;
	
	/**
	 * ����������
	 */
	protected String dadusername;
	
	/**
	 * ����ʱ��
	 */
	protected String dadupdtime;


	/**���ʱ��ID */
	protected Integer datid;
	
	
	/**�����ʱ�� */
	protected String dattime;
	
	/**�����ʱ������ */
	protected String[] dattimes;
	
	/**����ʱ�� */
	protected String datlimtime;

	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode = "0";
	
	
	
	/** ֵ��������ID */
	protected Integer drid;

	/** ֵ��ƻ�ID */
	protected Integer dpid;
	
	/** ������� */
	protected String dptime;
	
	/** ������� */
	protected String dptype;
	
	
	/** ����� */
	protected String drcontent;
	
	/** ʵ���ʱ�� */
	protected String drfilltime;
	
	/** ���˵�� */
	protected String drresult;
	
	/** �������д��ID */
	protected String druserid;
	
	/** �������д������ */
	protected String drusername;
	
	/** �������дʱ�� */
	protected String drcretime;
	
	/** ���˵�� */
	protected String[] drresults;
	
	/** ʵ���ʱ�� */
	protected String[] drfilltimes;
	
	/** ������������� */
	protected String[] dadcontenttypes;
	
	/** ������������� */
	protected String[] dadcontenttypes_hides;
	
	/** �����ID���� */
	protected Integer[] dadids;
	
	/** ���������� */
	protected String[] dadtypes;
	
	/** ����������� */
	protected String[] dadnames;
	
	/** �ʱ���������� */
	protected String[] datlimtimes;
	
	/** ��������� */
	protected String[] dadcontents;
	
	/** ֵ��ƻ� */
	protected DutyPlan dutyPlan;
	
	/** ֵ���ձ�ID���� */
	protected List<Integer> dridList;

	/** ��ա�ʱ���� */
	protected String[] drlimdtimes;
	
	
	/** ����ʱ�� */
	protected String[] dadlimtimes;
	
	/** ֵ�౸ע */
	protected String dpremarks;

	

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String[] getDadcontenttypes_hides() {
		return dadcontenttypes_hides;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param dadcontenttypes_hides ����ʱ��
	 */
	public void setDadcontenttypes_hides(String[] dadcontenttypes_hides) {
		this.dadcontenttypes_hides = dadcontenttypes_hides;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String[] getDadlimtimes() {
		return dadlimtimes;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param dadlimtimes ����ʱ��
	 */
	public void setDadlimtimes(String[] dadlimtimes) {
		this.dadlimtimes = dadlimtimes;
	}

	/**
	 * ��ա�ʱ����ȡ��
	 * @return ��ա�ʱ����
	 */
	public String[] getDrlimdtimes() {
		return drlimdtimes;
	}

	/**
	 * ��ա�ʱ�����趨
	 *
	 * @param drlimdtime ��ա�ʱ����
	 */
	public void setDrlimdtimes(String[] drlimdtimes) {
		this.drlimdtimes = drlimdtimes;
	}

	/**
	 * ֵ���ձ�ID����ȡ��
	 * @return the dridList
	 */
	public List<Integer> getDridList() {
		return dridList;
	}

	/**
	 *  ֵ���ձ�ID�����趨
	 */
	public void setDridList(List<Integer> dridList) {
		this.dridList = dridList;
	}
	
	
	/**
	 * ֵ��ƻ�ȡ��
	 * @return ֵ��ƻ�
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}


	/**
	 * ֵ��ƻ��趨
	 *
	 * @param dutyPlan ֵ��ƻ�
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}


	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String[] getDadcontenttypes() {
		return dadcontenttypes;
	}


	/**
	 * ��������������趨
	 *
	 * @param dadcontenttypes �������������
	 */
	public void setDadcontenttypes(String[] dadcontenttypes) {
		this.dadcontenttypes = dadcontenttypes;
	}


	/**
	 * �����ID����ȡ��
	 * @return �����ID����
	 */
	public Integer[] getDadids() {
		return dadids;
	}


	/**
	 * �����ID�����趨
	 *
	 * @param dadids �����ID����
	 */
	public void setDadids(Integer[] dadids) {
		this.dadids = dadids;
	}


	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String[] getDadtypes() {
		return dadtypes;
	}


	/**
	 * �����������趨
	 *
	 * @param dadtypes ����������
	 */
	public void setDadtypes(String[] dadtypes) {
		this.dadtypes = dadtypes;
	}


	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public String[] getDadnames() {
		return dadnames;
	}


	/**
	 * ������������趨
	 *
	 * @param dadnames �����������
	 */
	public void setDadnames(String[] dadnames) {
		this.dadnames = dadnames;
	}


	/**
	 * �ʱ����������ȡ��
	 * @return �ʱ����������
	 */
	public String[] getDatlimtimes() {
		return datlimtimes;
	}


	/**
	 * �ʱ�����������趨
	 *
	 * @param datlimtimes �ʱ����������
	 */
	public void setDatlimtimes(String[] datlimtimes) {
		this.datlimtimes = datlimtimes;
	}


	/**
	 * ���������ȡ��
	 * @return ���������
	 */
	public String[] getDadcontents() {
		return dadcontents;
	}


	/**
	 * ����������趨
	 *
	 * @param dadcontents ���������
	 */
	public void setDadcontents(String[] dadcontents) {
		this.dadcontents = dadcontents;
	}

	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String[] getDrresults() {
		return drresults;
	}

	/**
	 * ���˵���趨
	 *
	 * @param drresults ���˵��
	 */
	public void setDrresults(String[] drresults) {
		this.drresults = drresults;
	}

	/**
	 * ʵ���ʱ��ȡ��
	 * @return ʵ���ʱ��
	 */
	public String[] getDrfilltimes() {
		return drfilltimes;
	}

	/**
	 * ʵ���ʱ���趨
	 *
	 * @param drfilltimes ʵ���ʱ��
	 */
	public void setDrfilltimes(String[] drfilltimes) {
		this.drfilltimes = drfilltimes;
	}

	/**
	 * ֵ��������IDȡ��
	 * @return ֵ��������ID
	 */
	public Integer getDrid() {
		return drid;
	}
	
	/**
	 * ֵ��������ID�趨
	 *
	 * @param drid ֵ��������ID
	 */
	public void setDrid(Integer drid) {
		this.drid = drid;
	}

	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * ֵ��ƻ�ID�趨
	 *
	 * @param dpid ֵ��ƻ�ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}
	
	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDptime() {
		return dptime;
	}
	
	/**
	 * ֵ�������趨
	 *
	 * @param dptime ֵ������
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}
	
	/**
	 * �װ�/ҹ��ȡ��
	 * @return �װ�/ҹ��
	 */
	public String getDptype() {
		return dptype;
	}
	
	/**
	 * �װ�/ҹ���趨
	 *
	 * @param dptype �װ�/ҹ��
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}


	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getDrcontent() {
		return drcontent;
	}
	
	/**
	 * ������趨
	 *
	 * @param drcontent �����
	 */
	public void setDrcontent(String drcontent) {
		this.drcontent = drcontent;
	}

	/**
	 * ʵ���ʱ��ȡ��
	 * @return ʵ���ʱ��
	 */
	public String getDrfilltime() {
		return drfilltime;
	}
	
	/**
	 * ʵ���ʱ���趨
	 *
	 * @param drfilltime ʵ���ʱ��
	 */
	public void setDrfilltime(String drfilltime) {
		this.drfilltime = drfilltime;
	}

	/**
	 * ���˵��ȡ��
	 * @return ���˵��
	 */
	public String getDrresult() {
		return drresult;
	}
	
	/**
	 * ���˵���趨
	 *
	 * @param drresult ���˵��
	 */
	public void setDrresult(String drresult) {
		this.drresult = drresult;
	}

	/**
	 * �������д��IDȡ��
	 * @return �������д��ID
	 */
	public String getDruserid() {
		return druserid;
	}
	
	/**
	 * �������д��ID�趨
	 *
	 * @param druserid �������д��ID
	 */
	public void setDruserid(String druserid) {
		this.druserid = druserid;
	}

	/**
	 * �������д������ȡ��
	 * @return �������д������
	 */
	public String getDrusername() {
		return drusername;
	}
	
	/**
	 * �������д�������趨
	 *
	 * @param drusername �������д������
	 */
	public void setDrusername(String drusername) {
		this.drusername = drusername;
	}

	/**
	 * �������дʱ��ȡ��
	 * @return �������дʱ��
	 */
	public String getDrcretime() {
		return drcretime;
	}
	
	/**
	 * �������дʱ���趨
	 *
	 * @param drcretime �������дʱ��
	 */
	public void setDrcretime(String drcretime) {
		this.drcretime = drcretime;
	}
	
	
	
	/**
	 * ����ʱ��ȡ��
	 * @return datlimtime
	 */
	public String getDatlimtime() {
		return datlimtime;
	}

	/**
	 * ����ʱ���趨
	 */
	public void setDatlimtime(String datlimtime) {
		this.datlimtime = datlimtime;
	}

	
	/**
	 * �����ʱ������ȡ��
	 * @return dattimes
	 */
	public String[] getDattimes() {
		return dattimes;
	}

	/**
	 * �����ʱ�������趨
	 */
	public void setDattimes(String[] dattimes) {
		this.dattimes = dattimes;
	}

	/**
	 * �����������ʶȡ��
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * �����������ʶ�趨
	 * @return mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * �����ID
	 * @return �����ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * ֵ������
	 * @param dadid ֵ������
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}

	/**
	 * ֵ������
	 * @return ֵ������
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * ֵ������
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * ������
	 * @return ������
	 */
	public String getDadtype() {
		return dadtype;
	}

	/**
	 * ������
	 * @param dadtype ������
	 */
	public void setDadtype(String dadtype) {
		this.dadtype = dadtype;
	}

	/**
	 * �������
	 * @return �������
	 */
	public String getDadname() {
		return dadname;
	}

	/**
	 * �������
	 * @param dadname �������
	 */
	public void setDadname(String dadname) {
		this.dadname = dadname;
	}

	/**
	 * �ʱ������
	 * @return �ʱ������
	 */
	public String getDadlimtime() {
		return dadlimtime;
	}

	/**
	 * �ʱ������
	 * @param dadlimtime �ʱ������
	 */
	public void setDadlimtime(String dadlimtime) {
		this.dadlimtime = dadlimtime;
	}

	/**
	 * ���������
	 * @return ���������
	 */
	public String getDadcontent() {
		return dadcontent;
	}

	/**
	 * ���������
	 * @param dadcontent ���������
	 */
	public void setDadcontent(String dadcontent) {
		this.dadcontent = dadcontent;
	}

	/**
	 * ���˵��
	 * @return ���˵��
	 */
	public String getDadinfo() {
		return dadinfo;
	}

	/**
	 * ���˵��
	 * @param dadinfo ���˵��
	 */
	public void setDadinfo(String dadinfo) {
		this.dadinfo = dadinfo;
	}

	/**
	 * ʹ��״̬
	 * @return ʹ��״̬
	 */
	public String getDadstatus() {
		return dadstatus;
	}

	/**
	 * ʹ��״̬
	 * @param dadstatus ʹ��״̬
	 */
	public void setDadstatus(String dadstatus) {
		this.dadstatus = dadstatus;
	}

	/**
	 * ������ID
	 * @return ������ID
	 */
	public String getDaduserid() {
		return daduserid;
	}

	/**
	 * ������ID
	 * @param daduserid ������ID
	 */
	public void setDaduserid(String daduserid) {
		this.daduserid = daduserid;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getDadusername() {
		return dadusername;
	}

	/**
	 * ����������
	 * @param dadusername ����������
	 */
	public void setDadusername(String dadusername) {
		this.dadusername = dadusername;
	}

	/**
	 * ����ʱ��
	 * @return ����ʱ��
	 */
	public String getDadupdtime() {
		return dadupdtime;
	}

	/**
	 * ����ʱ��
	 * @param dadupdtime ����ʱ��
	 */
	public void setDadupdtime(String dadupdtime) {
		this.dadupdtime = dadupdtime;
	}



	 /**
     * 
	 *���ʱ��IDȡ��
	 * @return ���ʱ��ID
	 */
	public Integer getDatid() {
		return datid;
	}
    
	/**
	 * 
	 * ���ʱ��ID�趨
	 * @param datid ���ʱ��ID
	 */
	public void setDatid(Integer datid) {
		this.datid = datid;
	}
    
    
	/**
	 * ���ʱ��ȡ��
	 * @return ���ʱ��
	 */
	public String getDattime() {
		return dattime;
	}
	
    /**
	 * ֵ�౸עȡ��
	 *
	 * @return dpremarks ֵ�౸ע
	 */
	public String getDpremarks() {
		return dpremarks;
	}

	/**
	 * ֵ�౸ע�趨
	 *
	 * @param dpremarks ֵ�౸ע
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}

	/**
     * ���ʱ������
     * @param dattime ���ʱ��
     */
	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	



}
