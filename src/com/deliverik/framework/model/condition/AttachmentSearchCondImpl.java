package com.deliverik.framework.model.condition;

/**
 * ������Ϣ��������ʵ��
 */
public class AttachmentSearchCondImpl implements AttachmentSearchCond {

	/** �������� */
	protected String attname;
	
	/** �������� */
	protected String attkey;

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttname() {
		return attname;
	}

	/**
	 * ���������趨
	  * @param attname ��������
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getAttkey(){
		return attkey;
	}
	
	/**
	 * ���������趨
	  * @param attkey ��������
	 */
	public void setAttkey(String attkey){
		this.attkey = attkey;
	}
}
