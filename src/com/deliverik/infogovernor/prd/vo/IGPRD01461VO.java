/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG110Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���̲�ѯ��ʾ�п�ȶ���VO 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01461VO extends BaseVO{

	/** ���趨���̲�ѯ��ʾ�м��� */
    protected List<IG110Info> queryShowColumnList;

	/**
	 * ���趨���̲�ѯ��ʾ�м���ȡ��
	 * @return queryShowColumnList ���趨���̲�ѯ��ʾ�м���
	 */
	public List<IG110Info> getQueryShowColumnList() {
		return queryShowColumnList;
	}

	/**
	 * ���趨���̲�ѯ��ʾ�м����趨
	 * @param queryShowColumnList ���趨���̲�ѯ��ʾ�м���
	 */
	public void setQueryShowColumnList(List<IG110Info> queryShowColumnList) {
		this.queryShowColumnList = queryShowColumnList;
	}
}
