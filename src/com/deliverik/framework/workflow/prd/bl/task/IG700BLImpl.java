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
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG700DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG700TB;
 
/**
  * 概述: 流程查看角色配置表业务逻辑实现
  * 功能描述: 流程查看角色配置表业务逻辑实现
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public class IG700BLImpl extends BaseBLImpl implements
		IG700BL {

	/** 流程查看角色配置表DAO接口 */
	protected IG700DAO ig700DAO;
	
	/**
	 * 流程查看角色配置表DAO接口设定
	 *
	 * @param ig700DAO 流程查看角色配置表DAO接口
	 */
	public void setIg700DAO(IG700DAO ig700DAO) {
		this.ig700DAO = ig700DAO;
	}

	/**
	 * 流程查看角色配置表实例取得
	 *
	 * @return 流程查看角色配置表实例
	 */
	public IG700TB getIg700TBInstance() {
		return new IG700TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG700Info> searchIg700() {
		return ig700DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG700Info searchIg700ByPK(IG700PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG700SearchCond cond) {
		return ig700DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG700Info> searchIg700(
			IG700SearchCond cond) {
		return ig700DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG700Info> searchIg700(
			IG700SearchCond cond, int start,
			int count) {
		return ig700DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG700Info registIg700(IG700Info instance)
		throws BLException {
		return ig700DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG700Info updateIg700(IG700Info instance)
		throws BLException {
		checkExistInstance(new IG700PK(instance.getPdid(), instance.getRoleid()));
		return ig700DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIg700ByPK(IG700PK pk)
		throws BLException {
		ig700DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIg700(IG700Info instance)
		throws BLException {
		ig700DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG700Info checkExistInstance(IG700PK pk)
		throws BLException {
		IG700Info instance = ig700DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
     * XML脚本导出处理
     *
     * @param pdid 流程定义ID
     * @return XML脚本
     */
    public StringBuffer exportXML(String pdid) throws BLException {
    	IG700SearchCondImpl cond = new IG700SearchCondImpl();
        cond.setPdid(pdid);
        List<IG700Info> lst_IG700Info = this.searchIg700(cond);
        StringBuffer sbf_xml = new StringBuffer("");
        sbf_xml.append("<IG700>");
        sbf_xml.append("<DATALIST>");
        if(lst_IG700Info != null) {
            for(IG700Info info : lst_IG700Info) {
                sbf_xml.append("<DATA>");
                sbf_xml.append("<PDID>");
                sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
                sbf_xml.append("</PDID>");
                sbf_xml.append("<ROLEID>");
                sbf_xml.append(StringUtils.isEmpty(info.getRoleid().toString()) ? "" : "&roleid_" + info.getRoleid().toString() + ";");
                sbf_xml.append("</ROLEID>");
                sbf_xml.append("<FINGERPRINT>");
                sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
                sbf_xml.append("</FINGERPRINT>");
                sbf_xml.append("</DATA>");
            }
        }
        sbf_xml.append("</DATALIST>");
        sbf_xml.append("</IG700>");
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
        List<IG700Info> lst_IG700 = new ArrayList<IG700Info>();
        IG700TB entity = null;
        for(Element e : dataList) {
            entity = this.getIg700TBInstance();
            entity.setPdid(e.getChildText("PDID"));
            entity.setRoleid(Integer.parseInt(e.getChildText("ROLEID")));
            entity.setFingerPrint(e.getChildText("FINGERPRINT"));
            lst_IG700.add(entity);
        }
        this.ig700DAO.saveOrUpdateAll(lst_IG700);
    }

}