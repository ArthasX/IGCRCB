/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ������Ӧ����Ա��λ��ҵ���߼��ӿ�
 * ����������Ӧ����Ա��λ��ҵ���߼��ӿ�
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
public interface CurrentNodeBL extends BaseBL {
	public List<Map<String,Object>> getCurrentNodes(Integer prid) throws BLException;
	/**
	 * ��������id ��ѯ���нڵ���Ϣ
	 */
	public List<Map<String,Object>> searchAllNodes(Integer prid,String psdid) throws BLException;
}