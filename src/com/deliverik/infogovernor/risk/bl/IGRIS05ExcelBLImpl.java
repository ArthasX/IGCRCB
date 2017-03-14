/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.bl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.risk.dto.IGRIS05ExcelDTO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
 * @Description:
 * @Author zhangqiang
 * @History @2014-7-11新建
 * 
 * @Version V1.0
 */
public class IGRIS05ExcelBLImpl extends ExcelBaseBLImpl implements
		IGRIS05ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGRIS05ExcelBLImpl.class);

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================获取检查问题报表导出开始=================");
		IGRIS05ExcelDTO exceldto = (IGRIS05ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获取导出内容
		Map<String, Map<String, List<CheckWorkConutVWInfo>>> map = exceldto.getMap();
		
		int i = 0;  //列号
		int j = 0;
		int index = 0; //索引
		//迭代map
		for(Iterator<Entry<String, Map<String, List<CheckWorkConutVWInfo>>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, List<CheckWorkConutVWInfo>>> entry = iter.next();
			String key = entry.getKey();
			
			Map<String, List<CheckWorkConutVWInfo>> mapName = entry.getValue();
			int mergeStartClass = j;
			//循环其中
			for(Iterator<Entry<String, List<CheckWorkConutVWInfo>>> iterName = mapName.entrySet().iterator();iterName.hasNext();){
				Entry<String, List<CheckWorkConutVWInfo>> entryName = iterName.next();
				index ++;
				//取得检查问题集合
				List<CheckWorkConutVWInfo> list = entryName.getValue();
				//初始位置
				int mergeStart = i;
				for(CheckWorkConutVWInfo info:list){
					// 填充序号
					addCell(0, i, index);
					String type = "";
					// 填充检查项分类
					Integer temp = Integer.parseInt(key);
					switch(temp){
					case 1:type="机房";break;
					case 2:type="系统";break;
					case 3:type="网络";break;
					case 4:type="桌面安全";break;
					case 5:type="访问控制";break;
					case 6:type="开发";break;
					default: break;
					}
					addCell(1, i, type);
					// 填充检查项名称
					addCell(2, i, info.getRcname());
					// 填充检查项说明
					addCell(3, i, info.getRcdesc());
					// 填充实际检查时间
					/*addCell(4, i, info.getRccreatetime());*/
					// 填充检查频率
					addCell(4, i, info.getRcfrequency());
					// 检查结果
					addCell(5, i, info.getRcrresult());
					// 结果说明
					addCell(6, i, info.getRcrcomment());
					// 附件
					addCell(7, i,StringUtils.isNotEmpty(info.getRcrattch()) ? info.getRcrattch().substring(info.getRcrattch().lastIndexOf("_") + 1) : ""); 
					// 问题名称
					addCell(8, i, info.getPrtitle());
					i++;
					j++;
				}
				//结束位置
				int mergeEnd = i - 1;
				//判断合并
				if(mergeStart != mergeEnd){
					try {
						dto.getWritableSheet().mergeCells(0,dto.getStartRow() + mergeStart,0, dto.getStartRow() + mergeEnd);
						dto.getWritableSheet().mergeCells(2,dto.getStartRow() + mergeStart,2, dto.getStartRow() + mergeEnd);
					} catch (Exception e) {
						log.error("",e);
					} 
				}
			}
			int mergeEndClass = j - 1;
			//判断合并
			if(mergeStartClass != mergeEndClass){
				try {
					dto.getWritableSheet().mergeCells(1,dto.getStartRow() + mergeStartClass,1, dto.getStartRow() + mergeEndClass);
				} catch (Exception e) {
					log.error("",e);
				} 
			}
		}
		log.debug("=================获取检查问题报表导出结束=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}
}
