/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.kgm.model.Knowledge;
/**
 * ����:֪ʶ����ϸ��ѯVO
 * ����������֪ʶ����ϸ��ѯVO
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM02141VO extends BaseVO implements Serializable{
	
	/**֪ʶ����ϸ��Ϣ*/
	protected Knowledge knowledge;
	
	
	/**
	 * ֪ʶ����ϸ��Ϣȡ��
	 * @return ֪ʶ����ϸ��Ϣ
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * ֪ʶ����ϸ��Ϣ�趨
	 * @param knowledge ֪ʶ����ϸ��Ϣ
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	
}


