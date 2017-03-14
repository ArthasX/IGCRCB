/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.dao.SdlInfoTBDAO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�Ǽ���Ϣ�ӿ�ʵ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class SdlInfoBLImpl extends BaseBLImpl implements SdlInfoBL {

	/** SdlInfoTBDAO DAO */
	protected SdlInfoTBDAO sdlInfoTBDAO;

	public void setSdlInfoTBDAO(SdlInfoTBDAO sdlInfoTBDAO) {
		this.sdlInfoTBDAO = sdlInfoTBDAO;
	}

	/**
	 * <p>
	 * Description: ��ѯ��¼����
	 * </p>
	 * 
	 * @param cond ��������
	 * @return int
	 * @author liupeng@deliverik.com
	 */
	public int getSearchCount(SdlInfoSearchCond cond){
		return sdlInfoTBDAO.getSearchCount(cond);
	}

	/**
	 * <p>
	 * Description: �Ǽ���Ϣ�鿴
	 * </p>
	 * 
	 * @param sdiid �Ǽ���ϢID
	 * @return �Ǽ���Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo searchSdlInfoByKey(Integer eid){

		SdlInfo ret = sdlInfoTBDAO.findByPK(eid);
		return ret;
	}

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
	public List<SdlInfo> searchSdlInfo(SdlInfoSearchCond cond, int start, int count){
		List<SdlInfo> ret = sdlInfoTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * <p>
	 * Description: �Ǽ���Ϣ����
	 * </p>
	 * 
	 * @param sdlInfo �Ǽ���Ϣ
	 * @return �Ǽ���Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo registSdlInfo(SdlInfo sdlInfo) throws BLException{
		SdlInfo ret = sdlInfoTBDAO.save(sdlInfo);
		return ret;
	}
	/**
	 * <p>
	 * Description: �Ǽ���Ϣɾ��
	 * </p>
	 * 
	 * @param sdiid �Ǽ���ϢID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlInfo(Integer eid) throws BLException{
		SdlInfo SdlInfo = checkExistSdlInfo(eid);
		sdlInfoTBDAO.delete(SdlInfo);
	}
	/**
	 * <p>
	 * Description: �Ǽ���Ϣ�޸�
	 * </p>
	 * 
	 * @param sdlInfo �Ǽ���Ϣ
	 * @return �Ǽ���Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo updateSdlInfo(SdlInfo sdlInfo) throws BLException{
		SdlInfo ret = sdlInfoTBDAO.save(sdlInfo);
		return ret;
	}
	
	/**
	 * �Ǽ���Ϣ���ڼ��
	 * 
	 * @param sdiid �Ǽ���ϢID
	 * @return �Ǽ���Ϣ
	 * @throws BLException 
	 */
	protected SdlInfo checkExistSdlInfo(Integer sdiid) throws BLException{
		SdlInfo info = sdlInfoTBDAO.findByPK(sdiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�Ǽǻ���");
		}
		return info;
	}

}
