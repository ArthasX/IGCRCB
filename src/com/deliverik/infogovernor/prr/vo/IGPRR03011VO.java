/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG001Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:OA��ɫ���ó�ʼ����ʾvo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03011VO extends BaseVO{
	
	/** �����˽�ɫ��Ϣ���� */
	protected List<IG001Info> ig001List_A;
	
	/** ֵ���˽�ɫ��Ϣ���� */
	protected List<IG001Info> ig001List_B;
	
	/** ִ���˽�ɫ��Ϣ���� */
	protected List<IG001Info> ig001List_C;

	/**
	 * �����˽�ɫ��Ϣ����ȡ��
	 * @return �����˽�ɫ��Ϣ����
	 */
	public final List<IG001Info> getIg001List_A() {
		return ig001List_A;
	}

	/**
	 * �����˽�ɫ��Ϣ�����趨
	 * @param ig001List_A �����˽�ɫ��Ϣ����
	 */
	public final void setIg001List_A(List<IG001Info> ig001List_A) {
		this.ig001List_A = ig001List_A;
	}

	/**
	 * ֵ���˽�ɫ��Ϣ���ȡ��
	 * @return ֵ���˽�ɫ��Ϣ����
	 */
	public final List<IG001Info> getIg001List_B() {
		return ig001List_B;
	}

	/**
	 * ֵ���˽�ɫ��Ϣ�����趨
	 * @param ig001List_B ֵ���˽�ɫ��Ϣ����
	 */
	public final void setIg001List_B(List<IG001Info> ig001List_B) {
		this.ig001List_B = ig001List_B;
	}

	/**
	 * ִ���˽�ɫ��Ϣ����ȡ��
	 * @return ִ���˽�ɫ��Ϣ����
	 */
	public final List<IG001Info> getIg001List_C() {
		return ig001List_C;
	}

	/**
	 * ִ���˽�ɫ��Ϣ�����趨
	 * @param ig001List_C ִ���˽�ɫ��Ϣ����
	 */
	public final void setIg001List_C(List<IG001Info> ig001List_C) {
		this.ig001List_C = ig001List_C;
	}
	

}
