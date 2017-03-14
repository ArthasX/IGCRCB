package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.CodeCategoryDefInfo;

/**
 * ���ݷ�����Ϣ�༭����FORM
 * 
 */
@SuppressWarnings("serial")
public class IGSYM1507Form extends BaseForm implements CodeCategoryDefInfo{

	/** ���ݷ���CD */
	protected String ccid ;
	
	/** ���ݷ����� */
	protected String ccname;

	/** ���ݷ���˵�� */
	protected String ccinfo;

	/** ���ݷ���༭��ʶ */
	protected String cceditable;

	/** ���ݷ�����(��) */
	protected String pccid;

	/** ���ݷ�������(��) */
	protected String pccname;

	/** �����������ݷ����ʶ */
	protected String pcflag;

	/** �༭ģʽ���Ǽ�/��� */
	protected String mode = "0";
	
	/** ���� */
	public String clevel;

	/**
	 * ���ݷ���CDȡ��
	 * @return ���ݷ���CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ���ݷ���CD�趨
	 *
	 * @param ccid ���ݷ���CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * ���ݷ�����ȡ��
	 * @return ���ݷ�����
	 */
	public String getCcname() {
		return ccname;
	}


	/**
	 * ���ݷ������趨
	 *
	 * @param ccname ���ݷ�����
	 */
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}


	/**
	 * ���ݷ���˵��ȡ��
	 * @return ���ݷ���˵��
	 */
	public String getCcinfo() {
		return ccinfo;
	}


	/**
	 * ���ݷ���˵���趨
	 *
	 * @param ccinfo ���ݷ���˵��
	 */
	public void setCcinfo(String ccinfo) {
		this.ccinfo = ccinfo;
	}


	/**
	 * ���ݷ���༭��ʶȡ��
	 * @return ���ݷ���༭��ʶ
	 */
	public String getCceditable () {
		return cceditable;
	}

	/**
	 * ���ݷ���༭��ʶ�趨
	 *
	 * @param cceditable ���ݷ���༭��ʶ
	 */
	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
	}

	/**
	 * ���ݷ�����(��)ȡ��
	 * @return ���ݷ�����(��)
	 */
	public String getPccid() {
		return pccid;
	}


	/**
	 * ���ݷ�����(��)�趨
	 *
	 * @param pccid ���ݷ�����(��)
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	/**
	 * ���ݷ�������(��)ȡ��
	 * @return ���ݷ�������(��)
	 */
	public String getPccname() {
		return pccname;
	}

	/**
	 * ���ݷ�������(��)�趨
	 *
	 * @param pccname ���ݷ�������(��)
	 */
	public void setPccname(String pccname) {
		this.pccname = pccname;
	}

	/**
	 * �����������ݷ����ʶȡ��
	 * @return �����������ݷ����ʶ
	 */
	public String getPcflag() {
		return pcflag;
	}


	/**
	 * �����������ݷ����ʶ�趨
	 *
	 * @param pcflag �����������ݷ����ʶ
	 */
	public void setPcflag(String pcflag) {
		this.pcflag = pcflag;
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
	 * ��ʼ������
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
	}
	
	/**
	 * ����
	 * @return ����
	 */
	public String getClevel() {
		return clevel;
	}

	/**
	 * ����
	 *
	 * @param clevel ����
	 */
	public void setCcevel(String clevel) {
		this.clevel = clevel;
	}
}
