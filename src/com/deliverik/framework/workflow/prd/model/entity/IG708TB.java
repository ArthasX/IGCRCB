/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.framework.workflow.prd.model.entity;


import com.deliverik.framework.workflow.prd.model.IG708Info;


 /**
  * ����:����������ϸ��¼��TB��
  *  ��������������������ϸ��¼��TB��
  * 
  * ������¼��wangxiaoqiang 2010/11/29
  */

public class IG708TB implements IG708Info {
	
	/**
	 * checkbox��ʶ
	 */
	protected String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ����
	 */
	protected Integer padid;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getPadid() {
		return padid;
	}

	/**
	 *�����趨
	 * 
	 * @param padid����
	 */
	public void setPadid(Integer padid) {
		this.padid = padid;
	}

	/**
	 *Ӱ��ϵͳ
	 */
	protected String padaffectsystem;

	/**
	 *Ӱ��ϵͳȡ��
	 * 
	 * @return Ӱ��ϵͳ
	 */
	public String getPadaffectsystem() {
		return padaffectsystem;
	}

	/**
	 *Ӱ��ϵͳ�趨
	 * 
	 * @param padaffectsystemӰ��ϵͳ
	 */
	public void setPadaffectsystem(String padaffectsystem) {
		this.padaffectsystem = padaffectsystem;
	}

	protected String padaffectsystemname;
	
	
	public String getPadaffectsystemname() {
		return padaffectsystemname;
	}

	public void setPadaffectsystemname(String padaffectsystemname) {
		this.padaffectsystemname = padaffectsystemname;
	}

	/**
	 *Ӱ�쿪ʼʱ��
	 */
	protected String padstart;

	/**
	 *Ӱ�쿪ʼʱ��ȡ��
	 * 
	 * @return Ӱ�쿪ʼʱ��
	 */
	public String getPadstart() {
		return padstart;
	}

	/**
	 *Ӱ�쿪ʼʱ���趨
	 * 
	 * @param padstartӰ�쿪ʼʱ��
	 */
	public void setPadstart(String padstart) {
		this.padstart = padstart;
	}

	/**
	 *Ӱ�����ʱ��
	 */
	protected String padend;

	/**
	 *Ӱ�����ʱ��ȡ��
	 * 
	 * @return Ӱ�����ʱ��
	 */
	public String getPadend() {
		return padend;
	}

	/**
	 *Ӱ�����ʱ���趨
	 * 
	 * @param padendӰ�����ʱ��
	 */
	public void setPadend(String padend) {
		this.padend = padend;
	}

}

