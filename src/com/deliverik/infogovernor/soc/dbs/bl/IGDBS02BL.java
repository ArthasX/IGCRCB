/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_DaVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_FibreVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_RfbVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;

/**
 * @����SOC EMC��ά�洢����ƽ̨��ҳBL
 * @��������
 * @������¼��
 * @version 1.0
 */

public interface IGDBS02BL extends BaseBL {

	public List<Collect_Dir_FibreVWInfo> findFrontCPUBusy(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public List<Collect_Dir_DaVWInfo> findBehindCPUBusy(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public List<Collect_DisksVWInfo> findDisksBusy(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public List<Collect_Dir_RfbVWInfo> findFrontCPUBusy2(
			final Collect_BusySearchCond cond, final int start, final int count) throws BLException;

	public String createXml(Collect_BusySearchCond cond) throws BLException;

	/**
	 * ��һ�ν��벻��ѯ���ݿ�
	 * 
	 * @return
	 */
	public String initXml(Collect_BusySearchCond cond) throws BLException;

	public String initCXXml(Collect_BusySearchCond cond) throws BLException;

	public String createXml_cx(Collect_BusySearchCond cond) throws BLException;
	
	public String getSymm_version(String symm_id) throws BLException;
	
	public String getSymm_model(String symm_id) throws BLException;
	

}
