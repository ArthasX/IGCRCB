/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

/**
 * ��������ǰ�ڵ���ϢDAO�ӿ�
 * ������������ǰ�ڵ���ϢDAO�ӿ�
 * ������¼��2014/05/19
 */
public interface CurrentNodeDAO{


	public List<Map<String,Object>> searchCurrentNodes(Integer prid); 
	
	/**
	 * ��������id ��ѯ���нڵ���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> searchAllNodes(Integer prid,String psdid);
}