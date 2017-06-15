/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.task.MSGFILTERBL;
import com.deliverik.infogovernor.sym.dto.IGSYM20DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1803Form;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
 * 概述: 首页管理逻辑实现 功能描述：首页管理逻辑实现 创建记录：崔学志 2012/11/14 修改记录：
 */
@SuppressWarnings("deprecation")
public class IGSYM20BLImpl extends BaseBLImpl implements IGSYM20BL {

	static Log log = LogFactory.getLog(IGSYM19BLImpl.class);
	private MSGFILTERBL msgfilterbl;

	public void setMsgfilterbl(MSGFILTERBL msgfilterbl) {
		this.msgfilterbl = msgfilterbl;
	}

	// 根据条件查询
	public IGSYM20DTO searchIPInfoAction(IGSYM20DTO dto) throws BLException {
		List<MSGFILTERInfo> ipInfoList = new ArrayList<MSGFILTERInfo>();
		IGSYM1803Form igsym1803form = dto.getIgsym1803form();
		int totalCount = 0;
		totalCount = msgfilterbl.getSearchCount(igsym1803form);
		if (totalCount == 0) {
			log.debug("========信息查询数据不存在========");
			// 资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========信息查询数据件数过多========");
			// 资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		ipInfoList = msgfilterbl.searchMSGFILTER(igsym1803form,
				pDto.getFromCount(), pDto.getPageDispCount());
		dto.setIpInfoList(ipInfoList);
		return dto;
	}

	// 检查表里是否为空
	public boolean checkSearchCount(IGSYM20DTO dto) {
		boolean flag = true;
		IGSYM1803Form igsym1803form = dto.getIgsym1803form();
		if (msgfilterbl.getSearchCount(igsym1803form) != 0) {
			return flag;
		} else {
			return false;
		}

	}

	// 根据实体类删除
	public void deleteTB(MSGFILTERInfo msgfilterinfo) throws BLException {

		msgfilterbl.deleteMSGFILTER(msgfilterinfo);

	}

	// 根据主键删除
	public void deleteByPK(IGSYM20DTO dto) throws BLException {
		IGSYM1803Form form = dto.getIgsym1803form();
		for (Integer ruletempid : form.getIds()) {
			msgfilterbl.deleteMSGFILTERByPK(ruletempid);
		}
	}

	// 登记
	public IGSYM20DTO insertInfo(IGSYM20DTO dto) throws BLException {

		msgfilterbl.registMSGFILTER(dto.getIgsym1803form());

		return dto;

	}

	// 修改
	public IGSYM20DTO updateInfo(IGSYM20DTO dto) throws BLException {

		msgfilterbl.updateMSGFILTER(dto.getMsgfilterinfo());

		return dto;
	}

	// 状态位
	public IGSYM20DTO changeTempstate(IGSYM20DTO dto) throws BLException {
		log.debug("========更改规则状态处理开始========");

		// 取得form
		IGSYM1803Form form = dto.getIgsym1803form();
		// 根据主键获得模板实
		MSGFILTERInfo info = msgfilterbl.searchMSGFILTERByPK(form.getId());
		MSGFILTERTB msgfilterTB = (MSGFILTERTB) SerializationUtils.clone(info);

		// 判断模板之前的状态
		if ("0".equals(form.getState())) {
			msgfilterTB.setState("1");
		} else if ("1".equals(form.getState())) {
			msgfilterTB.setState("0");

			// 修改模板状态
		}
		msgfilterbl.updateMSGFILTER(msgfilterTB);

		return dto;
	}

}
