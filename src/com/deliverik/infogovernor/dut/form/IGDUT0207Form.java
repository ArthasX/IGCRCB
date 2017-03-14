/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.bl.IGDUTCONSTANTS;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;

/**
 * ֵ����ֹ��ѯForm
 *
 */
public class IGDUT0207Form extends BaseForm implements DutyPlanSearchCond{

	private static final long serialVersionUID = 1L;
	
	/** ֵ��ƻ�״̬ ִ����*/
	protected String dpstatus = IGDUTCONSTANTS.PLAN_STATUS_EXECUTING;
	
	/** ֵ������ */
	protected String dadcategory;
	
	/** ֵ������ ��ǰ����*/
	protected String dptime;
	
	/** �������� */
	protected String dpquestion;
	
	/** �ܽ� */
	protected String dpinfo;
	
	/** ֵ�����ڣ����ڵ���ƥ�䣩 */
	protected String dptime_ge;
	
	/** ����ƻ�ID */
	protected Integer dpid_executing;
	
	/**
	 * ֵ��ƻ�״̬ȡ��
	 * @return ֵ��ƻ�״̬
	 */
	public String getDpstatus() {
		return dpstatus;
	}

	/**
	 * ֵ��ƻ�״̬�趨
	 *
	 * @param dpstatus ֵ��ƻ�״̬
	 */
	public void setDpstatus(String dpstatus) {
		this.dpstatus = dpstatus;
	}

	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * ֵ�������趨
	 *
	 * @param dadcategory ֵ������
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
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
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getDpquestion() {
		return dpquestion;
	}

	/**
	 * ���������趨
	 *
	 * @param dpquestion ��������
	 */
	public void setDpquestion(String dpquestion) {
		this.dpquestion = dpquestion;
	}

	/**
	 * �ܽ�ȡ��
	 * @return �ܽ�
	 */
	public String getDpinfo() {
		return dpinfo;
	}

	/**
	 * �ܽ��趨
	 *
	 * @param dpinfo �ܽ�
	 */
	public void setDpinfo(String dpinfo) {
		this.dpinfo = dpinfo;
	}
	
	/**
	 * ֵ�����ڣ����ڵ���ƥ�䣩ȡ��
	 * @return ֵ�����ڣ����ڵ���ƥ�䣩
	 */
	public String getDptime_ge() {
		return dptime_ge;
	}

	/**
	 * ֵ�����ڣ����ڵ���ƥ�䣩�趨
	 *
	 * @param dptime_ge ֵ�����ڣ����ڵ���ƥ�䣩
	 */
	public void setDptime_ge(String dptime_ge) {
		this.dptime_ge = dptime_ge;
	}
	
	/**
	 * ����ƻ�IDȡ��
	 * @return ����ƻ�ID
	 */
	public Integer getDpid_executing() {
		return dpid_executing;
	}

	/**
	 * ����ƻ�ID�趨
	 *
	 * @param dpid_unexecute ����ƻ�ID
	 */
	public void setDpid_executing(Integer dpid_executing) {
		this.dpid_executing = dpid_executing;
	}

	/**
	 * ��ʼ������
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.dptime = null;
		this.dptime_ge = null;
	}

	public String getDptype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDptime_le() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getDpid() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
