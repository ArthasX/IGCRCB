/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR06011VO extends BaseVO{

	/** ���̲�ѯ��� */
	protected List<Map<String, Object>> result;

	/**
	 * ���̲�ѯ���ȡ��
	 * @return result ���̲�ѯ���
	 */
	public List<Map<String, Object>> getResult() {
		return result;
	}

	/**
	 * ���̲�ѯ����趨
	 * @param result ���̲�ѯ���
	 */
	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}
}
