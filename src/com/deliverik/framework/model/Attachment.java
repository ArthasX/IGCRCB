package com.deliverik.framework.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 附件信息
 * </p>
 */

public interface Attachment  extends BaseModel {

	/**
	 * 附件ID取得
	 * @return 附件ID
	 */
	public Integer getAttid();

	/**
	 * 附件索引取得
	 * @return 附件索引
	 */
	public String getAttkey();

	/**
	 * 附件名称取得
	 * @return 附件名称
	 */
	public String getAttname();

	/**
	 * 附件描述取得
	 * @return 附件描述
	 */
	public String getAttdesc();

	/**
	 * 附件存放位置取得
	 * @return 附件存放位置
	 */
	public String getAtturl();

}