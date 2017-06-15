/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG413Info;

/**
 * ����Ϣ��ѯ����Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0126Form extends BaseForm implements IG413Info{
	
	/** ǰ�������ֵ����ֽ��� */
	protected static final int MAX_BYTE = 64;
	
	protected String mode = "0";

	protected String pedid;

	/** ���̶���ID */
	protected String pdid;

	/** ״̬ID */
	protected String psdid;

	/** ����ID */
	protected String pedactionid;

	/** �¼����� */
	protected String pedtype;

	/** �Զ���BL���� */
	protected String pedblid;

	/** �¼�ִ��˳�� */
	protected Integer pedorder;
	
	/** �������� */
	protected String pedec;

	/** �ϼ�״̬ID */
	protected String ppsdid;

	public String getPedec() {
		return pedec;
	}

	public void setPedec(String pedec) {
		this.pedec = pedec;
	}

	public String getPedid() {
		return pedid;
	}

	public void setPedid(String pedid) {
		this.pedid = pedid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPedactionid() {
		return pedactionid;
	}

	public void setPedactionid(String pedactionid) {
		this.pedactionid = pedactionid;
	}

	public String getPedtype() {
		return pedtype;
	}

	public void setPedtype(String pedtype) {
		this.pedtype = pedtype;
	}

	public String getPedblid() {
		return pedblid;
	}

	public void setPedblid(String pedblid) {
		this.pedblid = pedblid;
	}

	public Integer getPedorder() {
		return pedorder;
	}

	public void setPedorder(Integer pedorder) {
		this.pedorder = pedorder;
	}

	public String getFingerPrint() {
		
		return null;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	/** �鿴ģʽ 0���£��ɱ༭��1����ʷ��ֻ�鿴 */
	protected String viewhistory;

	/**
	 * �鿴ģʽ
	 *
	 * @return �鿴ģʽ
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * �鿴ģʽ
	 *
	 * @param viewHistory  0�����£�1��ʷ
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * �ϼ�״̬ID�趨
	 * @param ppsdid �ϼ�״̬ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
}
