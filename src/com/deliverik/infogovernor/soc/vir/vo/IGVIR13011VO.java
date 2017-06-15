/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR13011VO extends BaseVO{

	/** �����Ϣ���� */
	protected List<VIM03Info> vim03List;

	/**
	 * �����Ϣ����ȡ��
	 * @return vim03List �����Ϣ����
	 */
	public List<VIM03Info> getVim03List() {
		return vim03List;
	}

	/**
	 * �����Ϣ�����趨
	 * @param vim03List �����Ϣ����
	 */
	public void setVim03List(List<VIM03Info> vim03List) {
		this.vim03List = vim03List;
	}
}
