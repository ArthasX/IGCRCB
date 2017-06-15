package com.deliverik.infogovernor.util;


/**
 * 流程按表单值显示图片常量定义<br>
 *
 *
 *
 * @author
 *
 */
public enum ProcessDefine {

	/**故障申报_Nokia （故障等级）*/
	故障申报_Nokia("故障等级")
	;

	/** */
	protected String pidname;

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