/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.framework.workflow.prd.model.condition;

 /**
  * ����:����������ϸ��¼��Condʵ��
  * ����������
  *           
  * ������¼��wangxiaoqiang    2010/11/29
  */
public class IG229SearchCondImpl implements
		IG229SearchCond {
	/**
	 *����ID
	 */
	protected Integer padprid;

	/**
	 *����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPadprid() {
		return padprid;
	}

	/**
	 *����ID�趨
	 * 
	 * @param padprid����ID
	 */
	public void setPadprid(Integer padprid) {
		this.padprid = padprid;
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

