/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * ����:������Դͳ����ͼ��������(����Ŀ)
 * ��������:������Դͳ����ͼ��������(����Ŀ) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
public class VIM03CountByProjVWSearchCondImpl implements
		VIM03CountByProjVWSearchCond {

	/**��Ŀ��  */
	protected String pname_like;

	/**
	 * ��Ŀ��ȡ��
	 * @return pname_like ��Ŀ��
	 */
	public String getPname_like() {
		return pname_like;
	}

	/**
	 * ��Ŀ���趨
	 * @param pname_like ��Ŀ��
	 */
	public void setPname_like(String pname_like) {
		this.pname_like = pname_like;
	}
	
}
