/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: �������ȼ�����Form
 * �����������������ȼ�����Form
 * ������¼���Կ�    2010/12/14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSYM1109Form extends BaseForm {
	
	/**���ȼ�����*/
	private String pprtype;
	
	/**���ȼ�ֵ*/
	private String pvalues[][];
	
	public String getPprtype() {
		
		return pprtype;
	}
	
	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}
	
	public String[][] getPvalues() {
		return pvalues;
	}
	
	public void setPvalues(String[][] pvalues) {
		this.pvalues = pvalues;
	}
	
}
