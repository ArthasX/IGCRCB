package com.deliverik.framework.model.condition;

/**
 * <p>
 * 附件信息检索条件
 * </p>
 * <p>
 * （未说明属性为平台保留属性)<br>
 * <table border="1">
 * <tr>
 * <td>attname</td>
 * <td>附件名称</td>
 * </tr>
 * <tr>
 * <td>attkey</td>
 * <td>附件索引</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface AttachmentSearchCond {
	/**
	 * 附件名称取得
	 * @return 附件名称
	 */
	public String getAttname();
	
	/**
	 * 附件索引取得
	 * @return 附件索引
	 */
	public String getAttkey();

}
