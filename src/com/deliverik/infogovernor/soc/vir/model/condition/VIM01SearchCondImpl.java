/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * ����: vCenter ServiceInstance��������ʵ��
  * ��������: vCenter ServiceInstance��������ʵ��
  * ������¼: 2014/02/12
  * �޸ļ�¼: 
  */
public class VIM01SearchCondImpl implements
		VIM01SearchCond {
	
	/** URL */
	protected String vcurl;

	/**
	 * URLȡ��
	 * @return vcurl URL
	 */
	public String getVcurl() {
		return vcurl;
	}

	/**
	 * URL�趨
	 * @param vcurl URL
	 */
	public void setVcurl(String vcurl) {
		this.vcurl = vcurl;
	}
	
}