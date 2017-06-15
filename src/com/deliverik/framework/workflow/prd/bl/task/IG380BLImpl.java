/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Attribute;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG380DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * <p>
 * 流程定义业务逻辑实现
 * </p>
 */

public class IG380BLImpl extends BaseBLImpl implements IG380BL {
	
	/**流程定义操作*/
	protected IG380DAO ig380DAO;
	
	/**
	 * 设置流程定义操作
	 * @param ig380DAO ig380DAO
	 */
	public void setIg380DAO(IG380DAO ig380DAO) {
		this.ig380DAO = ig380DAO;
	}

	/**
	 * 获取流程定义实例
	 * 
	 * @return ProcessDefinitionTB
	 * @throws BLException
	 */
	
	public IG380TB getIG380TBInstance(){
		return new IG380TB();
	}
	
	
	/**
	 * 根据流程模版ID获取流程定义集合
	 * @param processTemplateId 流程模版ID
	 * @return  List<ProcessDefinition>
	 */
	
	public List<IG380Info> searchIG380InfoByPtid(Integer processTemplateId){
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPtid(processTemplateId);
		cond.setPdstatus("a");
		return ig380DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 根据流程定义ID获取流程定义
	 * @param pdid 流程定义ID
	 * @return ProcessTemplate
	 * @throws BLException
	 */
	public IG380Info searchIG380InfoByKey(String pdid) throws BLException {
		checkExistIG380Info(pdid);
		return ig380DAO.findByPK(pdid);
	}
	
	/**
	 * 根据检索条件取得流程定义信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getIG380InfoSearchCount(IG380SearchCond cond){
		
		return ig380DAO.getSearchCount(cond);
	}
	
	/**
	 * 根据检索条件取得流程定义最新信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getIG380InfoSearchLastCount(IG380SearchCond cond){
		
		return ig380DAO.getSearchLastCount(cond);
	}
	
	/**
	 * 根据检索条件取得流程定义历史信息结果条数
	 * 
	 * @param cond 流程定义信息检索条件
	 * @return 流程定义信息结果条数
	 */
	public int getIG380InfoSearchHistoryCount(IG380SearchCond cond){
		
		return ig380DAO.getSearchHistoryCount(cond);
	}
	/**
	 * 根据检索条件取得流程定义信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond){
		
		return ig380DAO.findByCond(cond,0,0);
	}
	
	/**
	 * 根据检索条件取得流程定义最新信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchLastIG380Info(IG380SearchCond cond, int start, int count){
		
		return ig380DAO.findLastByCond(cond,start,count);
	}
	
	/**
	 * 根据检索条件取得相关发起的自定义流程类型的信息
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond) {
	    
	    return ig380DAO.relevantProcessfindByCond(cond);
	}
	
	/**
     * 根据检索条件取得缺省权限的相关发起的自定义流程类型的信息
     * 
     * @param cond 流程定义检索条件
     * @return 流程定义信息列表
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond) {
        
        return ig380DAO.relevantProcessfindByCondDefault(cond);
    }
	
	/**
	 * 根据检索条件取得流程定义历史信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchHistoryIG380Info(IG380SearchCond cond, int start, int count){
		
		return ig380DAO.findHistoryByCond(cond,start,count);
	}
	/**
	 * 根据检索条件取得流程定义信息列表
	 * 
	 * @param cond 流程定义检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程定义信息列表
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond, int start, int count){
		
		return ig380DAO.findByCond(cond,start,count);
	}
	
	/**
	 * 流程定义信息
	 * 
	 * @param ig380Info 流程定义信息
	 * @return 流程定义
	 */
	public IG380Info registIG380Info(IG380Info ig380Info) throws BLException{
		if(ig380Info == null) {
			throw new BLException("IGCO10000.E004","流程定义基本");
		}
		checkNotExistIG380Info(ig380Info.getPtid(), ig380Info.getPdname());
		return ig380DAO.save(ig380Info);
	}

	/**
	 * 删除流程定义信息
	 * 
	 * @param ig380Info 流程定义信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380Info(IG380Info ig380Info) throws BLException{
		IG380Info pd = checkExistIG380Info(ig380Info.getPdid());
		ig380DAO.delete(pd);
	}
	
	/**
	 * 删除流程定义信息
	 * 
	 * @param pdid 流程定义主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380InfoByKey(String pdid) throws BLException{
		IG380Info processDefinition = checkExistIG380Info(pdid);
		ig380DAO.delete(processDefinition);
	}

	/**
	 * 更新流程定义信息
	 * 
	 * @param ig380Info 流程定义信息
	 * @return 流程定义
	 * @throws BLException
	 */
	public IG380Info updateIG380Info(IG380Info ig380Info) throws BLException{
		
		checkExistIG380Info(ig380Info.getPdid());
		return ig380DAO.save(ig380Info);
	}

	/**
	 * 流程定义存在检查
	 * 
	 * @param pdid 流程定义ID
	 * @return 流程定义
	 * @throws BLException 
	 */
	protected IG380Info checkExistIG380Info(String pdid) throws BLException{
		IG380Info info = ig380DAO.findByPK(pdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程基本");
		}
		return info;
	}
	
	
	/**
	 * 流程定义不存在检查
	 * 
	 * @param ptid 流程模板ID
	 * @param pdname 流程定义名称
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG380Info(Integer ptid, String pdname) throws BLException{
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdname(pdname);
		cond.setPtid(ptid);
		List<IG380Info> infoList = ig380DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGCO10000.E021","流程基本");
		}
	}
	
	/**
	 * 根据用户ID获取该用户定义的流程定义信息结果列表
	 * @param userid 用户ID
	 * @param pdstatus 自定义流程状态
	 * @return 流程定义信息结果列表
	 */
	public List<IG380Info> findSelfDefinitionByUserId(String userid, String pdstatus){
		return ig380DAO.findSelfDefinitionByUserId(userid, pdstatus);
	}
	
	/**
	 * 根据用户ID获取该用户定义的流程定义信息结果列表(运维计划用)
	 * @return 流程定义信息结果列表
	 */
	public List<IG380Info> findSelfDefinitionAll(){
		return ig380DAO.findSelfDefinitionAll();
	}
	
	/**
	 * 根据用户ID获取该用户流程定义信息结果列表
	 * @param userid 用户ID
	 * @return 流程信息结果列表
	 */
	public List<IG380Info> findSelfDefinitionByUserIdCom(String userid, Integer ptid
			, String pdstatus){
		UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
		cond.setUserid(userid);
		return ig380DAO.findSelfDefinitionByUserIdCom(cond, ptid, pdstatus);
	}
	
	/**
	 * 流程定义主键值取得
	 * @param firstsite 主键首位标识
	 * @param pdsequence 序列名称
	 * @return PDID主键值
	 */
	public String getPdidNextValue(String firstsite,String pdsequence) {
		return ig380DAO.getPdidSequenceNextValue(firstsite,pdsequence);
	}
	
	/**
	 * 流程定义升版处理
	 * 
	 * @param pdid 流程定义ID
	 */
	public String upgradeProcessDefVersion(String pdid) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","流程定义基本");
		}
		return ig380DAO.upgradeProcessDefVersion(pdid);
	}
	
	/**
	 * 流程定义复制处理
	 * 
	 * @param pdid 流程定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyProcessDefVersion(String pdid,String pdsequence) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","流程定义基本");
		}
		return ig380DAO.copyProcessDefVersion(pdid,pdsequence);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG380Info ig380 = this.searchIG380InfoByKey(pdid);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG380>");
		sbf_xml.append("<DATALIST>");
		sbf_xml.append("<DATA>");
		if(ig380 != null) {
			sbf_xml.append("<PDID>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdid()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdid()));
			sbf_xml.append("</PDID>");
			sbf_xml.append("<PTID>");
			sbf_xml.append(ig380.getPtid() == null ? "" : ig380.getPtid());
			sbf_xml.append("</PTID>");
			sbf_xml.append("<PDNAME>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdname()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdname()));
			sbf_xml.append("</PDNAME>");
			sbf_xml.append("<PDDESC>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPddesc()) ? "" : IGStringUtils.filterXMLStr(ig380.getPddesc()));
			sbf_xml.append("</PDDESC>");
			sbf_xml.append("<PDCRTDATE>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdcrtdate()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdcrtdate()));
			sbf_xml.append("</PDCRTDATE>");
			//默认停用状态
			sbf_xml.append("<PDSTATUS>");
			sbf_xml.append(IGPRDCONSTANTS.PD_STATUS_DISABLE);
			sbf_xml.append("</PDSTATUS>");
			sbf_xml.append("<PDXML>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPdxml()) ? "" : ig380.getPdxml());
			sbf_xml.append("</PDXML>");
			sbf_xml.append("<PERMISSION>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getPermission()) ? "" : IGStringUtils.filterXMLStr(ig380.getPermission()));
			sbf_xml.append("</PERMISSION>");
			sbf_xml.append("<FINGERPRINT>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(ig380.getFingerPrint()));
			sbf_xml.append("</FINGERPRINT>");
			sbf_xml.append("<SERIALGENERATOR>");
			sbf_xml.append(StringUtils.isEmpty(ig380.getSerialgenerator()) ? "" : IGStringUtils.filterXMLStr(ig380.getSerialgenerator()));
			sbf_xml.append("</SERIALGENERATOR>");
			sbf_xml.append("<PDACTNAME>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdactname()) ? "" : IGStringUtils.filterXMLStr(ig380.getPdactname()));
            sbf_xml.append("</PDACTNAME>");
            sbf_xml.append("<REPORTDESC>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getReportdesc()) ? "" : IGStringUtils.filterXMLStr(ig380.getReportdesc()));
            sbf_xml.append("</REPORTDESC>");
            sbf_xml.append("<MESSAGEGENERATOR>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getMessagegenerator()) ? "" : IGStringUtils.filterXMLStr(ig380.getMessagegenerator()));
            sbf_xml.append("</MESSAGEGENERATOR>");
            sbf_xml.append("<PDSERIALNUMBER>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdserialnumber()) ? "" : ig380.getPdserialnumber());
            sbf_xml.append("</PDSERIALNUMBER>");
            sbf_xml.append("<PDSERVICECATALOG>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdservicecatalog()) ? "" : ig380.getPdservicecatalog());
            sbf_xml.append("</PDSERVICECATALOG>");
            sbf_xml.append("<PDSERVICECATALOGNAME>");
            sbf_xml.append(StringUtils.isEmpty(ig380.getPdservicecatalogname()) ? "" : ig380.getPdservicecatalogname());
            sbf_xml.append("</PDSERVICECATALOGNAME>");
		}
		sbf_xml.append("</DATA>");
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG380>");
		return sbf_xml;
	}
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG380Info> lst_IG380 = new ArrayList<IG380Info>();
		IG380TB entity = null;
		for(Element e : dataList) {
			StringBuffer pdxml = new StringBuffer();
			entity = this.getIG380TBInstance();
			display(e.getChild("PDXML").getChild("WebFlow"), pdxml);
			entity.setPdid(e.getChildText("PDID"));
			entity.setPtid(new Integer(e.getChildText("PTID")));
			entity.setPdname(e.getChildText("PDNAME"));
			entity.setPddesc(e.getChildText("PDDESC"));
			entity.setPdcrtdate(e.getChildText("PDCRTDATE"));
			entity.setPdstatus(e.getChildText("PDSTATUS"));
			if(pdxml.length() > 1) {
				entity.setPdxml(pdxml.toString());
			}
			entity.setPermission(e.getChildText("PERMISSION"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setSerialgenerator(e.getChildText("SERIALGENERATOR"));
			entity.setPdactname(e.getChildText("PDACTNAME"));
			entity.setReportdesc(e.getChildText("REPORTDESC").replaceAll("&lt;", "<").replaceAll("&gt;", ">"));
			entity.setMessagegenerator(e.getChildText("MESSAGEGENERATOR"));
			entity.setPdserialnumber(e.getChildText("PDSERIALNUMBER"));
			entity.setPdservicecatalog(e.getChildText("PDSERVICECATALOG"));
			entity.setPdservicecatalogname(e.getChildText("PDSERVICECATALOGNAME"));
			lst_IG380.add(entity);
		}
		this.ig380DAO.saveOrUpdateAll(lst_IG380);
	}
	
	/*********** 遍历形式显示各个结点 ************/
	@SuppressWarnings("rawtypes")
	public void display(Element e, StringBuffer sbf) {
		if(e != null) {
			sbf.append("<").append(e.getName());
			List content = e.getContent();// 获得所有子结点于列表中
			Iterator childIterator = content.iterator();// 生成迭代列表
			// 处理元素属性
			List attributes = e.getAttributes();// 属性列表
			if (!attributes.isEmpty()) {// 如果有属性，处理如下
				Iterator attributeIterator = attributes.iterator(); // 生成属性的迭代列表
				while (attributeIterator.hasNext()) { // 迭代遍历各个属性
					Attribute attribute = (Attribute) attributeIterator.next(); // 取第一个（下一个）属性
					sbf.append(" ").append(attribute.getName()).append("=").append("'").append(attribute.getValue()).append("'");
				}
			}
			sbf.append(">");
			// 处理内容文本
			String text = e.getTextNormalize();
			if (StringUtils.isNotEmpty(text)) {
				sbf.append(text);
			}
			// 处理各个子结点（子树）
			Object child = null;
			while (childIterator.hasNext()) {
				child = childIterator.next();
				if (child instanceof Element) { // 如果得到的next是Element类型的
					display((Element)child, sbf);
				}
			}
			sbf.append("</").append(e.getName()).append(">");
		}
	}
}
