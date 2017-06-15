package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;

/**
 * ����: ��ȹ���ͳ��BL
 * ������¼:  lianghongyang 2014-8-11 10:34:11
 * �޸ļ�¼: 
 */
public interface IGCRC2001BL extends BaseBL{
	/**��ȹ���ͳ��*/
	public List<IGCRC2001VWInfo> list(IGCRC2001Cond cond);
}
