package com.deliverik.infogovernor.soc.cim.form;



import com.deliverik.framework.base.BaseForm;

/**
 * �豸�����ļ���ʷ�汾�Ƚ�FORM
 * 
 */
public class IGCIM0141Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** �ʲ���� */
	protected String eiid;
	
	/** �汾1 */
	protected String pre;
	
	/** �汾2 */
	protected String next;
	
	/** �ڵ� */
	protected String node;
	
	/** �汾1��Ϣ */
	protected String preValue;
	
	/** �汾2��Ϣ */
	protected String nextValue;
	
	protected String filename;
	
	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getPre() {
		return pre;
	}

	public void setPre(String pre) {
		this.pre = pre;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getPreValue() {
		return preValue;
	}

	public void setPreValue(String preValue) {
		this.preValue = preValue;
	}

	public String getNextValue() {
		return nextValue;
	}

	public void setNextValue(String nextValue) {
		this.nextValue = nextValue;
	}
	
	
}
