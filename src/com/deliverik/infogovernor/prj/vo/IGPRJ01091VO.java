/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 * ����:��Ŀ�޸�ҳvo 
 * ������������Ŀ�޸�ҳvo
 * �����ˣ���͢־
 * ������¼�� 2012-5-21
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGPRJ01091VO extends BaseVO{
	/** ��ĿԤ���ϵ��ͼ���� */
	private List<Pbsummary> pbsummaryList;

	/**
	 * ��ĿԤ���ϵ��ͼ����ȡ��
	 * @return pbsummaryList ��ĿԤ���ϵ��ͼ����
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * ��ĿԤ���ϵ��ͼ�����趨
	 * @param pbsummaryList ��ĿԤ���ϵ��ͼ����
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
}
