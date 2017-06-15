package com.deliverik.infogovernor.asset.form;



import com.deliverik.framework.base.BaseForm;

/**
 * 设备配置文件历史版本比较FORM
 * 
 */
public class IGASM0341Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/** 资产编号 */
	protected String eiid;
	
	/** 版本1 */
	protected String pre;
	
	/** 版本2 */
	protected String next;
	
	/** 节点 */
	protected String node;
	
	/** 版本1信息 */
	protected String preValue;
	
	/** 版本2信息 */
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
