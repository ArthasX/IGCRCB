/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: UserRegion�ӿ�
  * ��������: UserRegion�ӿ�
  * ������¼: 2014/01/10
  * �޸ļ�¼: 
  */
public interface UserRegionInfo extends BaseModel {

	/**
	 * IDȡ��
	 *
	 * @return ID
	 */
	public Integer getID();

	/**
	 * flexIDȡ��
	 *
	 * @return flexID
	 */
	public String getFlexID();

	/**
	 * UserIDȡ��
	 *
	 * @return UserID
	 */
	public String getUserID();

	/**
	 * xȡ��
	 *
	 * @return x
	 */
	public String getX();

	/**
	 * yȡ��
	 *
	 * @return y
	 */
	public String getY();

	/**
	 * widthȡ��
	 *
	 * @return width
	 */
	public String getWidth();

	/**
	 * heightȡ��
	 *
	 * @return height
	 */
	public String getHeight();

	/**
	 * titleȡ��
	 *
	 * @return title
	 */
	public String getTitle();

}