/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.entity.HWorkVW;

/**
 * ��ʷ����ͳ��ҵ���߼��ӿ�
 */
public interface HWorkBL extends BaseBL {
	
	
	public List<HWorkVW> searchHistoryCount(String dto,String pruserid);
	
}
