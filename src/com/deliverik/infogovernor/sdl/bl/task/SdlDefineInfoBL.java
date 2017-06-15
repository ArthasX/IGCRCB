/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼�ӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlDefineInfoBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: ��׼��ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<SdlDefineInfo>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlDefineInfo> searchSdlDefineInfo(SdlDefineInfoSearchCond cond, int start, int count);
	
	/**
	 * <p>
	 * Description: ��ѯ��¼����
	 * </p>
	 * 
	 * @param cond ��������
	 * @return int
	 * @author liupeng@deliverik.com
	 */
	public int getSearchCount(SdlDefineInfoSearchCond cond);

	/**
	 * <p>
	 * Description: ��׼�鿴
	 * </p>
	 * 
	 * @param sdiid ��׼ID
	 * @return ��׼��Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo searchSdlDefineInfoByKey(Integer sdiid);
	
	/**
	 * <p>
	 * Description: ��׼����
	 * </p>
	 * 
	 * @param sdlDefineInfo ��׼��Ϣ
	 * @return ��׼��Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo registSdlDefineInfo(SdlDefineInfo sdlDefineInfo) throws BLException;
	
	/**
	 * <p>
	 * Description: ��׼ɾ��
	 * </p>
	 * 
	 * @param sdiid ��׼ID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlDefineInfo(Integer sdiid) throws BLException;
	
	/**
	 * <p>
	 * Description: ��׼�޸�
	 * </p>
	 * 
	 * @param sdlDefineInfo ��׼��Ϣ
	 * @return ��׼��Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo updateSdlDefineInfo(SdlDefineInfo SdlDefineInfo) throws BLException;
}
