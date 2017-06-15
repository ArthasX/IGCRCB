package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM0420ExcelDTO;

public class IGASM0420ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM0420ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {

		IGASM0420ExcelDTO exceldto = (IGASM0420ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);

		// 报表数据内容取得
		List<IG499Info> reportDataList = exceldto.getReportDataList();
		// 写入各个单元格
		if (reportDataList != null && reportDataList.size() > 0) {
			for (int i = 0; i < reportDataList.size(); i++) {
				//当前合同应付款对象取得
				IG499Info info=reportDataList.get(i);
				
				//合同编号
				addCell(0, i, info.getEilabel());
				//合同名称
				addCell(1, i, info.getEiname());
				//合同类型
				addCell(2, i, info.getCompacttype());
				//服务商名称(自动截取)
				if(StringUtils.isNotEmpty(info.getFacilitator())){
					int temp = info.getFacilitator().indexOf("(");
					if(temp<0){
						temp = info.getFacilitator().length();
					}
					addCell(3, i, info.getFacilitator().substring(0, temp));
				}else{
					addCell(3, i,"");
				}
				//合同款
				addCell(4, i, info.getContractpayment()==null?"0":info.getContractpayment());
				//已付款
				addCell(5, i, info.getCountmoney()==null?"0":info.getCountmoney());
			}
		}
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return dto;
	}

}
