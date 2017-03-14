/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�Ǽ���Ϣʵ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlInfoBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: �Ǽ���Ϣ��ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<SdlInfo>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlInfo> searchSdlInfo(SdlInfoSearchCond cond, int start, int count);
	
	/**
	 * <p>
	 * Description: ��ѯ��¼����
	 * </p>
	 * 
	 * @param cond ��������
	 * @return int
	 * @author liupeng@deliverik.com
	 */
	public int getSearchCount(SdlInfoSearchCond cond);

	/**
	 * <p>
	 * Description: �Ǽ���Ϣ�鿴
	 * </p>
	 * 
	 * @param siid �Ǽ���ϢID
	 * @return �Ǽ���Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo searchSdlInfoByKey(Integer siid);
	
	/**
	 * <p>
	 * Description: �Ǽ���Ϣ����
	 * </p>
	 * 
	 * @param sdlInfo �Ǽ���Ϣ
	 * @return �Ǽ���Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo registSdlInfo(SdlInfo sdlInfo) throws BLException;
	
	/**
	 * <p>
	 * Description: �Ǽ���Ϣɾ��
	 * </p>
	 * 
	 * @param siid �Ǽ���ϢID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlInfo(Integer siid) throws BLException;
	
	/**
	 * <p>
	 * Description: �Ǽ���Ϣ�޸�
	 * </p>
	 * 
	 * @param sdlInfo �Ǽ���Ϣ
	 * @return �Ǽ���Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo updateSdlInfo(SdlInfo SdlInfo) throws BLException;
}
