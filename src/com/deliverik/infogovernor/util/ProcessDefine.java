package com.deliverik.infogovernor.util;


/**
 * ���̰���ֵ��ʾͼƬ��������<br>
 *
 * 
 *
 * @author 
 *
 */
public enum ProcessDefine {
	
	/**�����걨_Nokia �����ϵȼ���*/
	�����걨_Nokia("���ϵȼ�")
	;
	
	/** */
	protected String pidname;

	/**
	 * 
	 *
	 * @param ccid
	 */
	private ProcessDefine(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 
	 *
	 * @param id
	 */
	public static ProcessDefine getProcessDefine(String id) {
		for (ProcessDefine c : ProcessDefine.values()) {
			if (c.name().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}

	public String getPidname() {
		return pidname;
	}
}