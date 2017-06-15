package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM13DTO;


/**
 * 设备存量统计逻辑接口
 *
 * 
 */
public interface IGASM13BL extends BaseBL {


	/**
	 * 设备存量统计处理
	 */
	public IGASM13DTO getEntityCount(IGASM13DTO dto) throws BLException;
	
	/**
	 * 取得机房下拉列表
	 */
	public List<LabelValueBean> getComputerRoomList(IGASM13DTO dto) throws BLException;
	
	/**
	 * 取得机房机柜统计的结果
	 */
	public IGASM13DTO searchComputerRoomAndContainer(IGASM13DTO dto) throws BLException;
	
	/**
	 * 取得设备存量分布式统计的结果
	 */
	public IGASM13DTO getEquDistributingCount(IGASM13DTO dto) throws BLException;
	
}
