/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
/**
 * ����:��Ϣ����ģ�廭��VO
 * ������¼�����    2011/10/18
 * ����������SOCԭ��Ϣʱ���趨
 * �޸�ʱ�䣺LuJiayuan 2013/01/29 ����ϲ���ԭIGSYM17011VO����IGSYM19011VO
 */
@SuppressWarnings("serial")
public class IGSYM19011VO extends BaseVO implements Serializable{
	
	/**
	 * ��Ϣ����ģ������
	 */
	protected List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList;

	/**
	 * ��Ϣ����ģ��������ȡ
	 * @return
	 */
	public List<ProcessWorkTimeTemplateInfo> getProcessWorkTimeTemplateInfoList() {
		return processWorkTimeTemplateInfoList;
	}

	/**
	 * ��Ϣ����ģ�������趨
	 * @param processWorkTimeTemplateInfoList
	 */
	public void setProcessWorkTimeTemplateInfoList(
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList) {
		this.processWorkTimeTemplateInfoList = processWorkTimeTemplateInfoList;
	}

}
