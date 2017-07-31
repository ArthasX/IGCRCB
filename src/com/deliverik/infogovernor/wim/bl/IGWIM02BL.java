/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.dto.IGWIM02DTO;

/**
 * @Description ��������BL�ӿ�
 * 
 * @date 2017��6��14��13:51:16
 * 
 * @author zyl
 *
 */
public interface IGWIM02BL extends BaseBL{

	/**
	 * @Description ������ѯ��ͨ������ʱ�䣬�Ӷ���ȡ���ڵ��ܣ�չʾһ�ܵĹ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 */
	public IGWIM02DTO getCurrentWorkByDateAction(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description ��ȡ���Ĳ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgAction(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description ��ȡ���Ĳ����µ���
	 * ��ʽ��List<Map<orgid,orgid>,Map<orgname,orgname>,Map<username,username>,Map<userid,userid>>
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgUserAction(IGWIM02DTO dto) throws BLException;
	/**
	 * @Description ���ڹ���ȷ�ϴ����ʼ��
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmCycleWorkInit(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description ���ڹ���ȷ�ϴ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmCycleWork(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description ���칤��ȷ�ϴ����ʼ��
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 * @modifier WangLiang
	 * @modifyContent ������������˳�ʱֹͣ����ʱ�䣨�죩��ȷ�ϳ�ʼ��ʱ��Ҫ��ϵͳ���ںͳ�ʱֹͣ����ʱ�����Ƚϣ����ѳ�ʱ������ִ����ȷ��/���湤��
	 */
	public IGWIM02DTO confirmTodayWorkInit(IGWIM02DTO dto) throws BLException ;
	/**
	 * @Description ���칤��ȷ�ϴ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmTodayWork(IGWIM02DTO dto) throws BLException;
	
	/**
	 * @Description ������Ϣͳ�Ʋ�ѯ
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO countSearch(IGWIM02DTO dto) throws BLException;
	
	/**
	 * @Description ������Ϣͳ�Ʋ�ѯ����
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO searchExport(IGWIM02DTO dto) throws BLException;
	
	/**
	 * @Description ��ҳ�����鿴
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO findTodayWorkByCondForFirstPage(IGWIM02DTO dto) throws BLException;
	/**
	 * ��ѯ��ǰ�����Ѿ���ʱ����ˣ�������־����Ĵ���ʱ��֮��
	 * @param cond ֻ�õ���ʵ��id-wiid
	 * @return
	 */
	public IGWIM02DTO getTotalExcuteTime(IGWIM02DTO dto);
	/**
	 * ��ѯ��ǰ��¼�û�Ȩ�ޣ�1���Ƽ����쵼���ܾ�����2�����ĸ����ˣ�3����ͨ�û���
	 * @param cond ֻ�õ���ʵ��id-wiid
	 * @return
	 */
	public IGWIM02DTO getPermissionByUser(IGWIM02DTO dto);
	
}
