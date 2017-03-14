package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCondImpl;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCondImpl;
import com.deliverik.infogovernor.sdl.model.dao.SdlDefineInfoTBDAO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼�ӿ�ʵ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlDefineInfoBLImpl extends BaseBLImpl implements SdlDefineInfoBL {

	/** SdlDefineInfoTBDAO DAO */
	protected SdlDefineInfoTBDAO sdlDefineInfoTBDAO;
	
	protected SdlInfoBL sdlInfoBL;

	public void setSdlDefineInfoTBDAO(SdlDefineInfoTBDAO sdlDefineInfoTBDAO) {
		this.sdlDefineInfoTBDAO = sdlDefineInfoTBDAO;
	}

	public void setSdlInfoBL(SdlInfoBL sdlInfoBL) {
		this.sdlInfoBL = sdlInfoBL;
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
	public int getSearchCount(SdlDefineInfoSearchCond cond){
		return sdlDefineInfoTBDAO.getSearchCount(cond);
	}

	/**
	 * <p>
	 * Description: ��׼�鿴
	 * </p>
	 * 
	 * @param sdiid ��׼ID
	 * @return ��׼��Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo searchSdlDefineInfoByKey(Integer eid){

		SdlDefineInfo ret = sdlDefineInfoTBDAO.findByPK(eid);
		return ret;
	}

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
	public List<SdlDefineInfo> searchSdlDefineInfo(SdlDefineInfoSearchCond cond, int start, int count){
		List<SdlDefineInfo> ret = sdlDefineInfoTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * <p>
	 * Description: ��׼����
	 * </p>
	 * 
	 * @param sdlDefineInfo ��׼��Ϣ
	 * @return ��׼��Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo registSdlDefineInfo(SdlDefineInfo sdlDefineInfo) throws BLException{
		checkNotExistSdlDefineInfo(sdlDefineInfo.getSdieiid(),sdlDefineInfo.getSdiyear(),sdlDefineInfo.getSdieiname());
		SdlDefineInfo ret = sdlDefineInfoTBDAO.save(sdlDefineInfo);
		return ret;
	}
	/**
	 * <p>
	 * Description: ��׼ɾ��
	 * </p>
	 * 
	 * @param sdiid ��׼ID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlDefineInfo(Integer eid) throws BLException{
		SdlDefineInfo SdlDefineInfo = checkExistSdlDefineInfo(eid);
		sdlDefineInfoTBDAO.delete(SdlDefineInfo);
	}
	/**
	 * <p>
	 * Description: ��׼�޸�
	 * </p>
	 * 
	 * @param sdlDefineInfo ��׼��Ϣ
	 * @return ��׼��Ϣ
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo updateSdlDefineInfo(SdlDefineInfo sdlDefineInfo) throws BLException{
		SdlDefineInfo ret = sdlDefineInfoTBDAO.save(sdlDefineInfo);
		return ret;
	}

	/**
	 * ��׼��Ϣ�����ڼ��
	 * 
	 * @param sdieiid ����ʲ�ID
	 * @param disyear ���
	 * @param sdieiname ��׼�ʲ�����
	 * @throws BLException 
	 */
	protected void checkNotExistSdlDefineInfo(Integer sdieiid, String disyear, String sdieiname) throws BLException{
		SdlDefineInfoSearchCondImpl cond = new SdlDefineInfoSearchCondImpl();
		cond.setSdieiid(sdieiid);
		cond.setSdiyear(disyear);
		List<SdlDefineInfo> infoList = sdlDefineInfoTBDAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSDL0301.E001",disyear,sdieiname);
		}
	}
	
	/**
	 * ��׼��Ϣ���ڼ��
	 * 
	 * @param sdiid ��׼ID
	 * @return ��׼��Ϣ
	 * @throws BLException 
	 */
	protected SdlDefineInfo checkExistSdlDefineInfo(Integer sdiid) throws BLException{
		SdlDefineInfo info = sdlDefineInfoTBDAO.findByPK(sdiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","��׼����");
		}
		SdlInfoSearchCondImpl cond = new SdlInfoSearchCondImpl();
		cond.setSieiid(info.getSdieiid());
		List<SdlInfo> list = sdlInfoBL.searchSdlInfo(cond, 0, 0);
		if(list.size()>0){
			throw new BLException("IGSDL0301.E002",info.getSdieiname());
		}
		return info;
	}

}
