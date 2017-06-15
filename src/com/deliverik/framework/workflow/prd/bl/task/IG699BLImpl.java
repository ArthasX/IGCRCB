/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG699DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;

/**
 * <p>概述:流程缺省参与者变量权限业务逻辑实现</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.全部检索处理</p>
 * <p>          4.条件检索处理</p>
 * <p>          5.登录处理</p>
 * <p>          6.删除处理</p>
 * <p>          7.变更处理</p>
 * <p>          8.流程缺省参与者变量权限存在检查</p>
 * 创建记录：</p>
 */
public class IG699BLImpl extends BaseBLImpl implements IG699BL{
	
	/** ParticipantDefaultVariable DAO */
	protected IG699DAO ig699DAO;
	
	/**
	 * 流程缺省参与者变量权限DAO
	 * @param ig699DAO 流程缺省参与者变量权限DAO
	 */
	public void setIg699DAO(
			IG699DAO ig699DAO) {
		this.ig699DAO = ig699DAO;
	}

	/**
	 * 功能：获取流程变量定义实例
	 * @return IG699TB
	 */
	
	public IG699TB getIG699TBInstance(){
		return new IG699TB();
	}

	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG699InfoSearchCount(IG699SearchCond cond){
		
		return ig699DAO.getSearchCount(cond);
	}

	/**
	 * 功能：主键检索处理
	 * @param pdvid 流程缺省参与者变量权限ID
	 * @return 流程缺省参与者变量权限
	 */
	public IG699Info searchIG699InfoByKey(String pdvid) throws BLException{
		
		return checkExistParticipantDefaultVariable(pdvid);
	}
	
	/**
	 * 功能：全部检索处理
	 * @param cond 检索条件
	 * @return 全部流程缺省参与者变量权限信息
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond){
		
		return ig699DAO.findByCond(cond,0,0);
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG699Info> searchIG699Info(IG699SearchCond cond, int start, int count){
		
		return ig699DAO.findByCond(cond,start,count);
	}

	/**
	 * 功能：登录处理
	 * @param ig699Info 登录数据
	 * @return 流程缺省参与者变量权限
	 * @throws BLException
	 */
	public IG699Info registIG699Info(IG699Info ig699Info) throws BLException{
		
		return ig699DAO.save(ig699Info);
	}

	/**
	 * 功能：删除处理
	 * @param pdvid 删除对象流程缺省参与者主键
	 * @throws BLException
	 */
	public void deleteIG699InfoByKey(String pdvid) throws BLException{
		
		IG699Info participantDefaultVariable = checkExistParticipantDefaultVariable(pdvid);
		
		ig699DAO.delete(participantDefaultVariable);
	}

	/**
	 * 功能：删除处理
	 * @param pdvid 删除对象流程缺省参与者主键 
	 * @throws BLException
	 */
	public void deleteIG699Info(IG699Info ig699Info) throws BLException{
		IG699Info pid = checkExistParticipantDefaultVariable(ig699Info.getPdvid());
		
		ig699DAO.delete(pid);
	}
	/**
	 * 功能：变更处理
	 * @param ig699Info 变更数据
	 * @return 流程缺省参与者变量权限
	 * @throws BLException
	 */
	public IG699Info updateIG699Info(IG699Info ig699Info) throws BLException{
		
		checkExistParticipantDefaultVariable(ig699Info.getPdvid());
		return ig699DAO.save(ig699Info);
	}

	/**
	 * 功能：流程缺省参与者变量权限存在检查
	 * @param pdvid 流程缺省参与者变量权限ID
	 * @return 流程缺省参与者变量权限
	 * @throws BLException 
	 */
	protected IG699Info checkExistParticipantDefaultVariable(String pdvid) throws BLException{
		IG699Info info = ig699DAO.findByPK(pdvid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程缺省参与者变量权限基本");
		}
		return info;
	}
	
	/**
	 * 流程缺省变量权限视图查询
	 * 
	 * @param cond 查询条件
	 * @return 流程缺省变量权限
	 * @throws BLException 
	 */
	public List<IG909Info> searchIG909Info(IG909SearchCond cond) {
		return ig699DAO.searchIG909Info(cond);
	}
	
	/**
	 * PDVID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PDVID主键值
	 */
	public String getPdvidSequenceNextValue(String psdid) {
		return ig699DAO.getPdvidSequenceNextValue(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG699SearchCondImpl cond = new IG699SearchCondImpl();
		cond.setPdvid_like(pdid);
		List<IG699Info> lst_IG699Info = this.searchIG699Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG699>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG699Info != null) {
			for(IG699Info info : lst_IG699Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDVID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdvid()) ? "" : IGStringUtils.filterXMLStr(info.getPdvid()));
				sbf_xml.append("</PDVID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PIDACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPidaccess()));
				sbf_xml.append("</PIDACCESS>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PIDREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidrequired()) ? "" : IGStringUtils.filterXMLStr(info.getPidrequired()));
				sbf_xml.append("</PIDREQUIRED>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG699>");
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
		List<IG699Info> lst_IG699 = new ArrayList<IG699Info>();
		IG699TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG699TBInstance();
			entity.setPdvid(e.getChildText("PDVID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPidaccess(e.getChildText("PIDACCESS"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPidrequired(e.getChildText("PIDREQUIRED"));
			lst_IG699.add(entity);
		}
		this.ig699DAO.saveOrUpdateAll(lst_IG699);
	}
	
}
