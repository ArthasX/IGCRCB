/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ������Ӧ���Լ�������ʵ��
  * ��������: ������Ӧ���Լ�������ʵ��
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
public class ResponseStrategySearchCondImpl implements
		ResponseStrategySearchCond {

	/**
	 * ����id
	 */
	private Integer senceid;

	private Integer[] senceids;

	public Integer[] getSenceids() {
		return senceids;
	}

	public void setSenceids(Integer[] senceids) {
		this.senceids = senceids;
	}

	/**
	 * �ؼ���ƥ�� in
	 * 
	 * @return
	 */
	private String[] keyword_in;

	public Integer getSenceid() {
		return senceid;
	}

	public void setSenceid(Integer senceid) {
		this.senceid = senceid;
	}

	public String[] getKeyword_in() {
		return keyword_in;
	}

	public void setKeyword_in(String[] keyword_in) {
		this.keyword_in = keyword_in;
	}

}