/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fin.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 * ����: ��Ŀ�Ǽ�Ԥ�㵯��ҳvo
 * ���������� ��Ŀ�Ǽ�Ԥ�㵯��ҳvo
 * �����ˣ���͢־
 * ������¼�� 2012-5-17
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGFIN01013VO extends BaseVO{
	/** Ԥ����ͼ����� */
	private List<Pbsummary> pbsummaryList;

	/**
	 * Ԥ����ͼ�����ȡ��
	 * @return pbsummaryList Ԥ����ͼ�����
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}

	/**
	 * Ԥ����ͼ������趨
	 * @param pbsummaryList Ԥ����ͼ�����
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
}
