package com.deliverik.infogovernor.fin.model;

import com.deliverik.framework.base.BaseModel;

public interface Budget  extends BaseModel {

	/** ��ȡ����ID*/
	public abstract Integer getBid();

	/** ��ȡԤ������*/
	public abstract String getBtype();

	public abstract String getBinittime();

	/** ��ȡ��ʼʱ��*/
	public abstract String getBopentime();

	/** ��ȡ״̬*/
	public abstract String getBstatus();

	public abstract String getBreqid();

	public abstract String getBapvid();

	/** ��ȡԤ������*/
	public abstract String getBtitle();

	/** ��ȡ�ر�ʱ��*/
	public abstract String getBclosetime();

	/** ��ȡԤ����*/
	public abstract String getBdesc();

	public abstract String getBinfo();

	/** ��ȡԤ�����*/
	public abstract String getByear();

	/** ��ȡ����ID*/
	public abstract String getBorgid();

	/** ��ȡ��������*/
	public abstract String getBorgname();

	public abstract String getBreqname();

	public abstract String getBapvname();

	/** ��ȡԤ���ܶ�*/
	public abstract Double getBamount();

	public abstract String getBattkey();
	
	public abstract Integer getPid();
	
	public abstract String getPcode();
	
	public abstract String getPname();
	
	/** ��ȡԤ������*/
	public abstract String getPquality();
	
	/** ��ȡ������Ŀ���*/
	public abstract String getPstorecode();
	
	/** ��ȡ������*/
	public abstract String getPneeddispart();
	
	/** ��ȡԤ�����*/
	public abstract String getPbuggetform();
	
	/** ��ȡԤ����;*/
	public abstract String getPuse();
	
	/** ��ȡ��ע*/
	public abstract String getRemark();

	/** ��ȡԤ���ʱ��𿪷�*/
	public abstract Double getBzdevelop();
	
	/** ��ȡԤ���ʱ���Ӳ��*/
	public abstract Double getBzhardware();
	
	/** ��ȡԤ���ʱ������*/
	public abstract Double getBzsoftware();
	
	/** ��ȡԤ���ʱ��𹤳�*/
	public abstract Double getBzproject();
	
	/** ��ȡԤ���ʱ�������*/
	public abstract Double getBzelse();
	
	/** ��ȡԤ��ɱ���ʵʩ*/
	public abstract Double getBcimplement();
	
	/** ��ȡԤ��ɱ�������*/
	public abstract Double getBcelse();
}