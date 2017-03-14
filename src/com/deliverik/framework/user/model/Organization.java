package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 机构信息
 * </p>
 */
public interface Organization  extends BaseModel {

	/**
	 * 机构ID取得
	 * @return 机构ID
	 */
	public Integer getOrgid();

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname();

	/**
	 * 机构说明取得
	 * @return 机构说明
	 */
	public String getOrgdesc();

	/**
	 * 机构信息取得
	 * @return 机构信息
	 */
	public String getOrginfo();

	/**
	 * 机构类型取得
	 * @return 机构类型
	 */
	public String getOrgtype();

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgpar();

	/**
	 * 上级机构名称取得
	 * @return 上级机构名称
	 */
	public String getOrgparname();

	/**
	 * 机构地址取得
	 * @return 机构地址
	 */
	public String getOrgaddr();

	/**
	 * 机构电话取得
	 * @return 机构电话
	 */
	public String getOrgphone();

	/**
	 * 机构传真取得
	 * @return 机构传真
	 */
	public String getOrgfax();

	/**
	 * 机构联系人取得
	 * @return 机构联系人
	 */
	public String getOrgcontact();

	/**
	 * 机构状态取得
	 * @return 机构状态
	 */
	public String getOrgstatus();

	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding();

	/**
	 * 机构编码取得
	 * @return 机构编码
	 */
	public String getOrgusercoding();

}