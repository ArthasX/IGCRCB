/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM0901ExcelDTO;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
/**
 * 
 * 概述: 服务商信息导出逻辑实现
 * 功能描述: 服务商信息导出逻辑实现
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录:
 */
public class IGASM0901ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM0901ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		IGASM0901ExcelDTO exceldto = (IGASM0901ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);

		// 报表数据内容取得
		List<EntityItemFacilitatorVWInfo> list = exceldto.getEntityItemFacilitatorList();
		// 写入各个单元格
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				//服务商信息对象取得
				EntityItemFacilitatorVWInfo info=list.get(i);
				
				//公司名称
				addCell(0, i, info.getEiname());
				//地址
				addCell(1, i, info.getAddress());
				//联系人
				addCell(2, i, info.getLinkman());
				//电话
				addCell(3, i, info.getTel());
				//开户行
				addCell(4, i, info.getAccountbk());
				//开户帐号
				addCell(5, i, info.getAccountno());
				//开户名称
				addCell(6, i, info.getAccountname());
			}
		}
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return dto;
	}

}
