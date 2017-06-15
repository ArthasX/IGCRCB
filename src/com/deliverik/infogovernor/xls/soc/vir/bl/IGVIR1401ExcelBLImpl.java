/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.soc.vir.bl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.xls.soc.vir.dto.IGVIR1401ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源申请统计导出BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1401ExcelBLImpl extends ExcelBaseBLImpl implements IGVIR1401ExcelBL{

	public ExcelDTO initHeader(ExcelDTO excelDTO) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO excelDTO) throws BLException {
		IGVIR1401ExcelDTO dto = (IGVIR1401ExcelDTO) excelDTO;
		dto.setStartRow(2);
		Map<String, Integer[]> map = dto.getVmApplyStatisticsDataMap();
		int index = 0;
		for(Iterator<Entry<String, Integer[]>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Integer[]> next = iter.next();
			String orgname = next.getKey();
			Integer[] counts = next.getValue();
			addCell(0, index,orgname);
			for(int i=0;i<counts.length;i++){
				addCell(i+1,index,counts[i]);
			}
			index ++;
		}
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO excelDTO) throws BLException {
		return null;
	}

}
