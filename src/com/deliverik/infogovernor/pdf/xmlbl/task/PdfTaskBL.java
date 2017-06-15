package com.deliverik.infogovernor.pdf.xmlbl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 概述: PDF报表TaskBL公共接口
 * 功能描述：PDF报表TaskBL公共接口
 * 创建人：deliverik
 * 创建记录：2013-7-26
 * 修改记录：
 */
public interface PdfTaskBL extends BaseBL{
    
	/**
	 * 获取填充数据后的XML对象
	 * @param prid
	 * @return Document
	 * @throws BLException
	 */
    public String getXmlFilledData(Integer prid, String pdid, String xmlName) throws BLException;
    /**
     * 获取填充数据后的XML对象
     * TQ3专用
     * @param prid 流程ID
     * @param pdid 流程定义ID
     * @param xmlName xml文件名
     * @return Document
     * @throws BLException
     */
    public String getXmlFilledDataForTQ3(Integer prid, String pdid, String xmlName) throws BLException;
}
