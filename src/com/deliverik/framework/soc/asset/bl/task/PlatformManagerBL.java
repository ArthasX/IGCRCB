/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;

/**
  * ����:  ҵ��ϵͳ����Աȱʧҵ���߼��ӿ�
  * ��������: ҵ��ϵͳ����Աȱʧҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface PlatformManagerBL extends BaseBL {

	public List<PlatformManagerInfo> findByCond(PlatformManagerVWSearchCond cond,int start,int count)throws BLException;

	public Integer getCount(PlatformManagerVWSearchCond cond)throws BLException;
}