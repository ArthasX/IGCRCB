package com.deliverik.framework.model.condition;


/**
 * ���ݷ�����Ϣ��ѯ����ʵ��
 * 
 */
public class CodeCategorySearchCondImpl implements CodeCategorySearchCond {

	/** ����CD */
	protected String ccid ;
	
	/** �ϼ�����CD */
	protected String pccid ;
	
	/** ����༭��ʶ */
	protected String cceditable;
	
	/** �Ƿ������� */
	protected boolean tree;
	
	/**
	 * ����CDȡ��
	 * @return ����CD
	 */
	public String getCcid() {
		return ccid;
	}

	/**
	 * ����CD�趨
	 *
	 * @param ccid ����CD
	 */
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}

	/**
	 * ����༭��ʶȡ��
	 * @return ����༭��ʶ
	 */
	public String getCceditable () {
		return cceditable;
	}

	/**
	 * ����༭��ʶ�趨
	 *
	 * @param cceditable ����༭��ʶ
	 */
	public void setCceditable(String cceditable) {
		this.cceditable = cceditable;
	}

	/**
	 * �ϼ�����CDȡ��
	 * @return �ϼ�����CD
	 */
	public String getPccid() {
		return pccid;
	}

	/**
	 * �ϼ�����CD�趨
	 *
	 * @param pccid �ϼ�����CD
	 */
	public void setPccid(String pccid) {
		this.pccid = pccid;
	}

	/**
	 * �Ƿ�������ȡ��
	 * @return �Ƿ�������
	 */
	public boolean isTree() {
		return tree;
	}

	/**
	 * �Ƿ��������趨
	 *
	 * @param tree �Ƿ�������
	 */
	public void setTree(boolean tree) {
		this.tree = tree;
	}

}
