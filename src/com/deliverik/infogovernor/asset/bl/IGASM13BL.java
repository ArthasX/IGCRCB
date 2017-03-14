package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM13DTO;


/**
 * �豸����ͳ���߼��ӿ�
 *
 * 
 */
public interface IGASM13BL extends BaseBL {


	/**
	 * �豸����ͳ�ƴ���
	 */
	public IGASM13DTO getEntityCount(IGASM13DTO dto) throws BLException;
	
	/**
	 * ȡ�û��������б�
	 */
	public List<LabelValueBean> getComputerRoomList(IGASM13DTO dto) throws BLException;
	
	/**
	 * ȡ�û�������ͳ�ƵĽ��
	 */
	public IGASM13DTO searchComputerRoomAndContainer(IGASM13DTO dto) throws BLException;
	
	/**
	 * ȡ���豸�����ֲ�ʽͳ�ƵĽ��
	 */
	public IGASM13DTO getEquDistributingCount(IGASM13DTO dto) throws BLException;
	
}
