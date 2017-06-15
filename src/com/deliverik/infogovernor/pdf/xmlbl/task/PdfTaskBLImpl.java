package com.deliverik.infogovernor.pdf.xmlbl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.bl.task.PdfIg599MapVWBL;
import com.deliverik.infogovernor.pdf.bl.task.PdfIg898MapVWBL;
import com.deliverik.infogovernor.pdf.bl.task.PdfTableNodeBL;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCondImpl;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCondImpl;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCondImpl;
import com.deliverik.infogovernor.pdf.xmlbean.PdfXmlDoc;
import com.deliverik.infogovernor.pdf.xmlbl.IGPDF01BLImpl;

/**
 * 概述: 报表数据获取BL类
 * 功能描述：报表数据数据获取BL类
 * 创建人：deliverik
 * 创建记录：2013-7-26
 * 修改记录：
 */
public class PdfTaskBLImpl extends BaseBLImpl implements PdfTaskBL {

    /** 报表字段与流程公有表单值映射关系视图BL*/ 
    protected PdfIg599MapVWBL ig599MapBL;
    
    /** 报表字段与流程表格式表单值映射关系视图BL*/ 
    protected PdfIg898MapVWBL ig898MapBL;
    
    /** PDF报表与流程表单映射表业务逻辑BL*/ 
    protected PdfTableNodeBL pdfTableNodeBL;
    
    /** 日志信息*/ 
    static Log log = LogFactory.getLog(IGPDF01BLImpl.class);
    
    /**
     * @param 报表字段与流程公有表单值映射关系视图BL the ig599MapBL to set
     */
    public void setIg599MapBL(PdfIg599MapVWBL ig599MapBL) {
        this.ig599MapBL = ig599MapBL;
    }

    /**
     * @param 报表字段与流程表格式表单值映射关系视图BL the ig898MapBL to set
     */
    public void setIg898MapBL(PdfIg898MapVWBL ig898MapBL) {
        this.ig898MapBL = ig898MapBL;
    }
    
    /**
     * @param PDF报表与流程表单映射表业务逻辑BL the pdfTableNodeBL to set
     */
    public void setPdfTableNodeBL(PdfTableNodeBL pdfTableNodeBL) {
        this.pdfTableNodeBL = pdfTableNodeBL;
    }
    
    
    /**
     * 获取填充数据后的XML对象
     * 
     * @param prid 流程ID
     * @param pdid 流程定义ID
     * @param xmlName xml文件名
     * @return Document
     * @throws BLException
     */
    public String getXmlFilledData(Integer prid, String pdid, String xmlName) throws BLException {
        // 取得报表XML可操作对象
        PdfXmlDoc xml = new PdfXmlDoc(xmlName);
        // 查询报表XML中二级节点信息
        PdfTableNodeSearchCondImpl cond = new PdfTableNodeSearchCondImpl();
        cond.setPdid(pdid);
        List<PdfTableNodeInfo> pdfTableNodeInfoList = pdfTableNodeBL.searchPdfTableNode(cond);
        
        // 填充流程常规表单数据
        fillNormalData(prid, xml) ;
        
    	Map<String,String> nodeTypeMap = new HashMap<String, String>();
		for (PdfTableNodeInfo info : pdfTableNodeInfoList) {
			nodeTypeMap.put(info.getDatabinding(), info.getNodetype());
		}
		// 填充流程表格式表单数据
		for (PdfTableNodeInfo nodeInfo : pdfTableNodeInfoList) {
			if (nodeInfo.getNodetype().equals("0")) {
				// 固定节点填充
				fillTableDataOneNode(prid, xml, nodeInfo.getPdatabinding(),nodeInfo.getDatabinding());
			} else {
				// ZYL 第一种情况，可变行里面有可变行：子节点在内部判断
				if (StringUtils.isEmpty((nodeInfo.getPdatabinding()))) {
					fillTableDataMoreNode(prid, xml.getRootElement(),nodeInfo.getPdatabinding(),nodeInfo.getDatabinding());
				}
				// ZYL 第二种情况，固定行里面有可变行
				if (StringUtils.isNotEmpty((nodeInfo.getPdatabinding()))&&"0".equals(nodeTypeMap.get(nodeInfo.getPdatabinding()))) {
					fillTableDataMoreNode(prid, xml.getRootElement().element(nodeInfo.getPdatabinding()),null,nodeInfo.getDatabinding());
				}
			}
		}
        if(pdid.startsWith("21040")){
            fillTableDataOneNodeFor21040(prid, xml);
        }
        log.debug("填充数据后的xml：" + xml.asXml());
        log.info(xml.asXml());
        return xml.asXml();
    }
    
    /**
     * 获取填充数据后的XML对象
     * TQ3专用
     * @param prid 流程ID
     * @param pdid 流程定义ID
     * @param xmlName xml文件名
     * @return Document
     * @throws BLException
     */
    public String getXmlFilledDataForTQ3(Integer prid, String pdid, String xmlName) throws BLException {
    	// 取得报表XML可操作对象
    	PdfXmlDoc rootXml = new PdfXmlDoc(xmlName);
    	// 查询报表XML中二级节点信息
    	PdfTableNodeSearchCondImpl cond = new PdfTableNodeSearchCondImpl();
    	cond.setPdid(pdid);
    	List<PdfTableNodeInfo> pdfTableNodeInfoList = pdfTableNodeBL.searchPdfTableNode(cond);
    	//放六大模块
    	List<PdfTableNodeInfo> nodeInfoListOne = new ArrayList<PdfTableNodeInfo>();
    	List<PdfTableNodeInfo> nodeInfoListTwo = new ArrayList<PdfTableNodeInfo>();
    	List<PdfTableNodeInfo> nodeInfoListThr = new ArrayList<PdfTableNodeInfo>();
    	List<PdfTableNodeInfo> nodeInfoListFou = new ArrayList<PdfTableNodeInfo>();
    	List<PdfTableNodeInfo> nodeInfoListFiv = new ArrayList<PdfTableNodeInfo>();
    	List<PdfTableNodeInfo> nodeInfoListSix = new ArrayList<PdfTableNodeInfo>();
    	for (PdfTableNodeInfo info : pdfTableNodeInfoList) {
			if(info.getDatabinding().startsWith("a"))nodeInfoListOne.add(info);
			if(info.getDatabinding().startsWith("b"))nodeInfoListTwo.add(info);
			if(info.getDatabinding().startsWith("c"))nodeInfoListThr.add(info);
			if(info.getDatabinding().startsWith("d"))nodeInfoListFou.add(info);
			if(info.getDatabinding().startsWith("e"))nodeInfoListFiv.add(info);
			if(info.getDatabinding().startsWith("f"))nodeInfoListSix.add(info);
    	}    		
    	// 填充流程常规表单数据
    	fillNormalData(prid, rootXml) ;
    	
    	Map<String,String> nodeTypeMap = new HashMap<String, String>();
    	for (PdfTableNodeInfo info : pdfTableNodeInfoList) {
    		nodeTypeMap.put(info.getDatabinding(), info.getNodetype());
    	}
    	// 填充流程表格式表单数据
    	fillData(prid,"aTQ3TABLE1", rootXml, nodeInfoListOne, nodeTypeMap);
    	fillData(prid,"bTQ3TABLE1", rootXml, nodeInfoListTwo, nodeTypeMap);
    	fillData(prid,"cTQ3TABLE1", rootXml, nodeInfoListThr, nodeTypeMap);
    	fillData(prid,"dTQ3TABLE1", rootXml, nodeInfoListFou, nodeTypeMap);
    	fillData(prid,"eTQ3TABLE1", rootXml, nodeInfoListFiv, nodeTypeMap);
    	fillData(prid,"fTQ3TABLE1", rootXml, nodeInfoListSix, nodeTypeMap);
    	String asXml = rootXml.asXml();
    	asXml = returnFinalXml(asXml);
    	log.info("填充数据后的xml：" + asXml);
    	return asXml;
    }

	private void fillData(Integer prid,String type ,PdfXmlDoc rootXml,List<PdfTableNodeInfo> nodeInfoList,Map<String, String> nodeTypeMap) throws BLException {
		for (PdfTableNodeInfo nodeInfo : nodeInfoList) {
    		if (nodeInfo.getNodetype().equals("0")) {
    			// 固定节点填充
    			fillTableDataForTQ3(prid, rootXml.getElement(type), nodeInfo.getPdatabinding(),nodeInfo.getDatabinding());
    		} else {
    			// ZYL 第一种情况，可变行里面有可变行：子节点在内部判断
    			if (StringUtils.isEmpty((nodeInfo.getPdatabinding()))) {
    				fillTableDataMoreNode(prid, rootXml.getElement(type),nodeInfo.getPdatabinding(),nodeInfo.getDatabinding());
    			}
    			// ZYL 第二种情况，固定行里面有可变行
    			if (StringUtils.isNotEmpty((nodeInfo.getPdatabinding()))&&"0".equals(nodeTypeMap.get(nodeInfo.getPdatabinding()))) {
    				fillTableDataMoreNode(prid, rootXml.getElement(nodeInfo.getPdatabinding()),null,nodeInfo.getDatabinding());
    			}
    		}
    	}
	}

	private String returnFinalXml(String asXml) {
		//组织数据
    	asXml = asXml.replaceAll("aTQ3TABLE1", "TQ3TABLE1");
    	asXml = asXml.replaceAll("aDSSTRCV", "DSSTRCV");
    	asXml = asXml.replaceAll("aUNPRDCT", "UNPRDCT");
    	asXml = asXml.replaceAll("aPRDCT", "PRDCT");
    	asXml = asXml.replaceAll("bTQ3TABLE1", "TQ3TABLE1");
    	asXml = asXml.replaceAll("bDSSTRCV", "DSSTRCV");
    	asXml = asXml.replaceAll("bUNPRDCT", "UNPRDCT");
    	asXml = asXml.replaceAll("bPRDCT", "PRDCT");
    	
    	asXml = asXml.replaceAll("cTQ3TABLE1", "TQ3TABLE1");
    	asXml = asXml.replaceAll("cDSSTRCV", "DSSTRCV");
    	asXml = asXml.replaceAll("cUNPRDCT", "UNPRDCT");
    	asXml = asXml.replaceAll("cPRDCT", "PRDCT");
    	
    	asXml = asXml.replaceAll("dTQ3TABLE1", "TQ3TABLE1");
    	asXml = asXml.replaceAll("dDSSTRCV", "DSSTRCV");
    	asXml = asXml.replaceAll("dUNPRDCT", "UNPRDCT");
    	asXml = asXml.replaceAll("dPRDCT", "PRDCT");
    	
    	asXml = asXml.replaceAll("eTQ3TABLE1", "TQ3TABLE1");
    	asXml = asXml.replaceAll("eDSSTRCV", "DSSTRCV");
    	asXml = asXml.replaceAll("eUNPRDCT", "UNPRDCT");
    	asXml = asXml.replaceAll("ePRDCT", "PRDCT");
    	
    	asXml = asXml.replaceAll("fTQ3TABLE1", "TQ3TABLE1");
    	asXml = asXml.replaceAll("fDSSTRCV", "DSSTRCV");
    	asXml = asXml.replaceAll("fUNPRDCT", "UNPRDCT");
    	asXml = asXml.replaceAll("fPRDCT", "PRDCT");
		return asXml;
	}

	
    
    /**
	 * 填充流程的正常表单数据
	 * 
	 * @param prid
	 *            流程id
	 * @param xmlDocument
	 *            报表XML
	 * @return void
	 * @throws BLException
	 */
	private void fillNormalData(Integer prid, PdfXmlDoc xml) throws BLException {
		Element element;
		// 填充非表格式表单的值。
		PdfIg599MapVWSearchCondImpl cond = new PdfIg599MapVWSearchCondImpl();
		cond.setPrid(prid);
		List<PdfIg599MapVWInfo> ig599MapInfoList = ig599MapBL
				.searchPdfIg599MapVW(cond);
		for (PdfIg599MapVWInfo info : ig599MapInfoList) {
			element = xml.getElement(info.getPdatabinding());
			PdfXmlDoc.setPvalueIntoXml(element, info.getDatabinding(),
					info.getPivarvalue(), info.getFormtype());
		}

		// 映射表中的父绑定字段为空，但也定义成了表格式类型的表单，也属于常规表单需在这里填充。
		// 该段程序为了应对调整后的填报基本信息字段（原来是常规表单，后为了美观调整为了表格式表单）
		PdfIg898MapVWSearchCondImpl cond898 = new PdfIg898MapVWSearchCondImpl();
		cond898.setPrid(prid);
		cond898.setPdatabinding("null");
		List<PdfIg898MapVWInfo> ig898MapInfoList = ig898MapBL
				.searchPdfIg898MapVW(cond898);
		for (PdfIg898MapVWInfo info : ig898MapInfoList) {
			element = xml.getElement(info.getPdatabinding());
			PdfXmlDoc.setPvalueIntoXml(element, info.getDatabinding(),
					info.getPvalue(), info.getFormtype());
		}
	}

	/**
	 * 填充可变节点的表格式表单数据
	 * 
	 * @param prid
	 *            流程id
	 * @param xmlDocument
	 *            报表XML操作对象
	 * @param databinding
	 *            报表XML中的一个子节点名称
	 * @return void
	 * @throws BLException
	 */
	private void fillTableDataMoreNode(Integer prid, Element root,
			String nodePdatabinding, String nodeDatabinding) throws BLException {

		// 取得表格类型表单的行数
		PdfIg898MapVWSearchCondImpl cond = new PdfIg898MapVWSearchCondImpl();
		cond.setPrid(prid);
		cond.setPdatabinding(nodeDatabinding);
		String maxRownumber = ig898MapBL.getMaxRowNumber(cond);
		int rowCount = 0;
		int rowNumberIndex = 0;
		if (StringUtils.isNotEmpty(maxRownumber)) {
			String[] rowNumbers = maxRownumber.split("_");
			rowNumberIndex = rowNumbers.length - 1;
			// 取分隔后的最后一位为最大行数
			rowCount = Integer.parseInt(rowNumbers[rowNumberIndex]);
		}
		if("TQ2001".equals(nodeDatabinding)||"TM1001".equals(nodeDatabinding)||"TB13001".equals(nodeDatabinding)||"TQ3TABLE1".equals(nodeDatabinding))
			rowCount = Integer.parseInt(maxRownumber.split("_")[0]);
		if (rowCount > 0) {
			// 取得迭代添加的节点对象
			String pdatabinding;
//			if (StringUtils.isNotEmpty(nodePdatabinding)) {
//				pdatabinding = nodePdatabinding + "#" + nodeDatabinding;
//			} else {
				pdatabinding = nodeDatabinding;
//			}
			Element element = root.element(pdatabinding);

			// 取得表格类型表单值信息
			cond.setOrderby("1");
			List<PdfIg898MapVWInfo> ig898MapInfoList = ig898MapBL.searchPdfIg898MapVW(cond);

			// 填充表格类型表单的每行数据
			ArrayList<PdfIg898MapVWInfo> oneFormValueList = new ArrayList<PdfIg898MapVWInfo>();
			ArrayList<PdfIg898MapVWInfo> oneRowValueList = new ArrayList<PdfIg898MapVWInfo>();
			String rowNumber = "";
			// 遍历每一行
			for (int i = 1; i <= rowCount; i++) {
				// 取得表格式表单可变行一行的填充数据
				oneRowValueList.removeAll(oneRowValueList);
				for (PdfIg898MapVWInfo info : ig898MapInfoList) {
					if("TQ2001".equals(nodeDatabinding)||"TM1001".equals(nodeDatabinding)||"TB13001".equals(nodeDatabinding)||"TQ3TABLE1".equals(nodeDatabinding)){
						if(Integer.parseInt(info.getPvrownumber().split("_")[0])<10){
							if(info.getPvrownumber().startsWith(String.valueOf(i))){
								oneRowValueList.add(info);
							}
						}else{
							if(Integer.parseInt(info.getPvrownumber().split("_")[0])==i){
								oneRowValueList.add(info);
							}
						}
					}else{
						String[] rownumbers = info.getPvrownumber().split("_");
						if (rownumbers[rowNumberIndex].equals(String.valueOf(i))) {
							oneRowValueList.add(info);
						}
					}
				}

				// 为可变行表单填充每一行数据
				Element newElement = element.createCopy();
				for (PdfIg898MapVWInfo info1 : oneRowValueList) {
					for (PdfIg898MapVWInfo info2 : oneRowValueList) {
						if (info1.getPvcolpidid().equals(info2.getPvcolpidid())) {
							// 把一行中的相同表单值收集到一起进行数据填充。
							oneFormValueList.add(info2);
						}
					}
					PdfXmlDoc.setPvalueListIntoXml(newElement, oneFormValueList);
					if(oneRowValueList!=null&&oneRowValueList.size()>0){
						rowNumber = oneRowValueList.get(0).getPvrownumber().substring(0, (maxRownumber.split("_").length)*2-1);
					}
					oneFormValueList.removeAll(oneFormValueList);
				}
				// 遍历每一行中的
				//查询可变子结点
				PdfTableNodeSearchCondImpl ptnCond = new PdfTableNodeSearchCondImpl();
				ptnCond.setPdatabinding(pdatabinding);
				ptnCond.setNodetype("1");
				List<PdfTableNodeInfo> pdfTableNodeList = pdfTableNodeBL.searchPdfTableNode(ptnCond);
				// 是否有可变子节点
				if (pdfTableNodeList != null && pdfTableNodeList.size() > 0) {
					for (PdfTableNodeInfo info : pdfTableNodeList) {
						
							fillTableDataMoreNodeForSon(prid, newElement, rowNumber, info.getDatabinding());
					}
				}			
				root.add(newElement);
				ig898MapInfoList.removeAll(oneRowValueList);
			}
			root.remove(element);
		}
	}

	/**
	 * 填充可变节点的表格式表单数据(子节点)
	 * 
	 * @param prid 流程id
	 * @param xmlDocument 报表XML操作对象
	 * @param databinding 报表XML中的一个子节点名称
	 * @return void
	 * @throws BLException
	 */
	private void fillTableDataMoreNodeForSon(Integer prid, Element root,
			String parentRownumber, String nodeDatabinding) throws BLException {

		// 取得表格类型表单的行数
		PdfIg898MapVWSearchCondImpl cond = new PdfIg898MapVWSearchCondImpl();
		cond.setPrid(prid);
		cond.setPdatabinding(nodeDatabinding);
		if("DSSTRCV".equals(nodeDatabinding)||"UNPRDCT".equals(nodeDatabinding)||"PRDCT".equals(nodeDatabinding))
			parentRownumber = parentRownumber.substring(0, parentRownumber.length()-1);
		cond.setPvrownumber(parentRownumber);
		String maxRownumber = ig898MapBL.getMaxRowNumber(cond);
		int rowCount = 0;
		int rowNumberIndex = 0;
		if (StringUtils.isNotEmpty(maxRownumber)) {
			String[] rowNumbers = maxRownumber.split("_");
			rowNumberIndex = rowNumbers.length - 1;
			// 取分隔后的最后一位为最大行数
			rowCount = Integer.parseInt(rowNumbers[rowNumberIndex]);
		}

		if (rowCount > 0) {
			// 取得迭代添加的节点对象
			String pdatabinding;
			pdatabinding = nodeDatabinding;
			Element element = root.element(pdatabinding);

			// 取得表格类型表单值信息
			cond.setOrderby("1");
			List<PdfIg898MapVWInfo> ig898MapInfoList = ig898MapBL.searchPdfIg898MapVW(cond);

			// 填充表格类型表单的每行数据
			ArrayList<PdfIg898MapVWInfo> oneFormValueList = new ArrayList<PdfIg898MapVWInfo>();
			ArrayList<PdfIg898MapVWInfo> oneRowValueList = new ArrayList<PdfIg898MapVWInfo>();
			// 遍历每一行
			for (int i = 1; i <= rowCount; i++) {
				// 取得表格式表单可变行一行的填充数据
				oneRowValueList.removeAll(oneRowValueList);
				for (PdfIg898MapVWInfo info : ig898MapInfoList) {
					String[] rownumbers = info.getPvrownumber().split("_");
					if (rownumbers[rowNumberIndex].equals(String.valueOf(i))) {
						oneRowValueList.add(info);
					}
				}
				// 为可变行表单填充每一行数据
				Element newElement = element.createCopy();
				for (PdfIg898MapVWInfo info1 : oneRowValueList) {
					for (PdfIg898MapVWInfo info2 : oneRowValueList) {
						if (info1.getPvcolpidid().equals(info2.getPvcolpidid())) {
							// 把一行中的相同表单值收集到一起进行数据填充。
							oneFormValueList.add(info2);
						}
					}
					PdfXmlDoc.setPvalueListIntoXml(newElement, oneFormValueList);
					oneFormValueList.removeAll(oneFormValueList);
				}
				root.add(newElement);
				ig898MapInfoList.removeAll(oneRowValueList);
			}
			root.remove(element);
		}
	}
    /** 
     * 
     * 
     * @param 21040流程 专用
     * @param xmlDocument 报表XML操作对象
     * @param databinding 报表XML中的一个子节点名称
     * @return void
     * @throws BLException
     */
    private void fillTableDataOneNodeFor21040(Integer prid, PdfXmlDoc xml) throws BLException{
    	
    	// 取得表格类型表单的行数
		PdfIg898MapVWSearchCondImpl cond = new PdfIg898MapVWSearchCondImpl();
		cond.setPrid(prid);
		Element pElement = xml.getElement(null);
		// 取得表格类型表单值信息
		cond.setOrderby("1");
		ArrayList<PdfIg898MapVWInfo> oneRowValueList = new ArrayList<PdfIg898MapVWInfo>();
		List<PdfIg898MapVWInfo> ig898MapInfoList = ig898MapBL.searchPdfIg898MapVW(cond);
		for (PdfIg898MapVWInfo info : ig898MapInfoList) {
			if ("1".equals(info.getPvrownumber())) {
				oneRowValueList.add(info);
			}
		}
		String pvalue, formtype, databinding ;
		   for (int i = 0; i < oneRowValueList.size(); i++) {
	             PdfIg898MapVWInfo info = oneRowValueList.get(i);
	             pvalue = info.getPvalue();
	             formtype = info.getFormtype();
	             databinding = info.getDatabinding();
	             if (StringUtils.isNotEmpty(pvalue)) {
	            	 if("3".equals(formtype)&&pvalue!=null){
	            		 setPvalueIntoXml(pElement, databinding, pvalue.replaceAll("/", "-"), formtype);
	            	 }else{
	            		 setPvalueIntoXml(pElement, databinding, pvalue, formtype);
	            	 }
	             }
	         }
    }
    /** 
     * 流程表单数据填充xml
     * @param pdatabinding xml父节点名
     * @param databinding xml节点名
     * @param pvalue 待填充的数据
     * @param formtype 表单值类型
     * @return void
     * @throws 
     */
    public void setPvalueIntoXml(Element element, String databinding, String pvalue, String formtype) {
        if (StringUtils.isNotEmpty(pvalue)) {
                 element.element(databinding).setText(pvalue);
        }
     }
    /** 
     * 填充固定节点的表格式表单数据
     * 
     * @param prid 流程id
     * @param xmlDocument 报表XML操作对象
     * @param databinding 报表XML中的一个子节点名称
     * @return void
     * @throws BLException
     */
    private void fillTableDataOneNode(Integer prid, PdfXmlDoc xml, 
            String nodePdatabinding, String nodeDatabinding) throws BLException{
        // 取得迭代添加的节点对象
        String pdatabinding;
        if (StringUtils.isNotEmpty(nodePdatabinding)) {
            pdatabinding = nodePdatabinding + "#" +nodeDatabinding;
        } else {
            pdatabinding = nodeDatabinding;
        }
        Element element = xml.getElement(pdatabinding);
        
        // 取得表格类型表单值信息
        PdfIg898MapVWSearchCondImpl cond = new PdfIg898MapVWSearchCondImpl();
        cond.setPrid(prid);
        cond.setPdatabinding(nodeDatabinding);
        cond.setOrderby("0");
        List<PdfIg898MapVWInfo> ig898MapInfoList = ig898MapBL.searchPdfIg898MapVW(cond);
        
        // 填充表格类型表单的数据
        ArrayList<PdfIg898MapVWInfo> oneFormValueList = new ArrayList<PdfIg898MapVWInfo>();
        String theLastPvcolpidid = "";
        for (PdfIg898MapVWInfo info : ig898MapInfoList) {
            if (theLastPvcolpidid.equals(info.getPvcolpidid())) {
                oneFormValueList.add(info);
            } else {
                PdfXmlDoc.setPvalueListIntoXml(element, oneFormValueList);
                oneFormValueList.removeAll(oneFormValueList);
                oneFormValueList.add(info);
            }
            theLastPvcolpidid = info.getPvcolpidid();
        }
        if(oneFormValueList.size()>0){
        	PdfXmlDoc.setPvalueListIntoXml(element, oneFormValueList);
        }
    }
    /** 
     * 填充固定节点的表格式表单数据
     * 
     * @param prid 流程id
     * @param xmlDocument 报表XML操作对象
     * @param databinding 报表XML中的一个子节点名称
     * @return void
     * @throws BLException
     */
    private void fillTableDataForTQ3(Integer prid, Element element, 
    		String nodePdatabinding, String nodeDatabinding) throws BLException{
    	// 取得迭代添加的节点对象
//    	String pdatabinding;
//    	if (StringUtils.isNotEmpty(nodePdatabinding)) {
//    		pdatabinding = nodePdatabinding + "#" +nodeDatabinding;
//    	} else {
//    		pdatabinding = nodeDatabinding;
//    	}
//        Element element = xml.getElement(pdatabinding);
    	
    	// 取得表格类型表单值信息
    	PdfIg898MapVWSearchCondImpl cond = new PdfIg898MapVWSearchCondImpl();
    	cond.setPrid(prid);
    	cond.setPdatabinding(nodeDatabinding);
    	cond.setOrderby("0");
    	List<PdfIg898MapVWInfo> ig898MapInfoList = ig898MapBL.searchPdfIg898MapVW(cond);
    	
    	// 填充表格类型表单的数据
    	ArrayList<PdfIg898MapVWInfo> oneFormValueList = new ArrayList<PdfIg898MapVWInfo>();
    	String theLastPvcolpidid = "";
    	for (PdfIg898MapVWInfo info : ig898MapInfoList) {
    		if (theLastPvcolpidid.equals(info.getPvcolpidid())) {
    			oneFormValueList.add(info);
    		} else {
    			PdfXmlDoc.setPvalueListIntoXml(element, oneFormValueList);
    			oneFormValueList.removeAll(oneFormValueList);
    			oneFormValueList.add(info);
    		}
    		theLastPvcolpidid = info.getPvcolpidid();
    	}
    	if(oneFormValueList.size()>0){
    		PdfXmlDoc.setPvalueListIntoXml(element, oneFormValueList);
    	}
    }
    
}
