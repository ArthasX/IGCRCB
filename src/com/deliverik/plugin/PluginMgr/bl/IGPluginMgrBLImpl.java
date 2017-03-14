/*
 * 北京递蓝科软件技术有限公司。
 */
package com.deliverik.plugin.PluginMgr.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.plugin.PluginMgr.dto.IGPluginDTO;
import com.deliverik.plugin.PluginMgr.model.IGPlugin;
import com.deliverik.plugin.PluginMgr.model.IGPluginInfo;
import com.deliverik.plugin.PluginMgr.vo.IGPluginMgrVO;
import com.system.plugins.utils.PluginsDataUtils;
import com.system.plugins.utils.SQLBean;
import com.system.plugins.utils.dao.PluginsDataUtilDAO;

/**
 * 概述: 插件接口实现
 * 功能描述: 插件接口实现
 * 创建记录: 2012-11-5
 * 修改记录: 
 */
public class IGPluginMgrBLImpl extends BaseBLImpl implements IGPluginMgrBL{
	static Log log = LogFactory.getLog(IGPluginMgrBLImpl.class);
	FileInputStream in;
	FileOutputStream os;
	File dataFile = null;
	//查询插件列表
	public IGPluginDTO getPluginList(IGPluginDTO dto)throws BLException{
		List<IGPluginInfo> pluginList=new ArrayList<IGPluginInfo>();
		List<String> list_path = getPluginPathList();
		
		for (String pluginPath:list_path) {
			IGPlugin igp=new IGPlugin();
			igp.setPluginPath(pluginPath);
			try {
				in = new FileInputStream(pluginPath+ File.separator +"config/config.properties");
				Properties prop = new Properties();
				prop.load(in);
				igp.setPluginStatus(prop.getProperty("PLUGIN_STATUS"));
				igp.setPluginName(prop.getProperty("PLUGIN_NAME"));
				in.close();
				in = null;
				prop = null;
			}catch(Exception e){
				e.printStackTrace();
			}
			pluginList.add(igp);
		}
		
		dto.setPluginList(pluginList);
		IGPluginMgrVO vo =new IGPluginMgrVO();
		vo.setPluginList(dto.getPluginList());
		return dto;
	}
	//更改插件状态
	public IGPluginDTO modifyPlugin(IGPluginDTO dto)throws BLException{
		String realPath="";
		String path=dto.getPath();
		String status=dto.getStatus();
		if(path!=null){
			path=path.substring(path.indexOf("WEB-INF"));
		}
		List<String> list_path = getPluginPathList();
		for (String list_p : list_path) {
			String cutpath=list_p.substring(list_p.indexOf("WEB-INF")).replace("\\", "");
			if( cutpath.equals(path) ){
				realPath=list_p;
				break;
			}
		}
		if(!"".equals(realPath) && !"".equals(status)){
			try {
				//写config.properties
				in = new FileInputStream(realPath+ File.separator +"config/config.properties");
				Properties prop = new Properties();
				prop.load(in);
				prop.setProperty("PLUGIN_STATUS", status);
				os = new FileOutputStream(realPath+ File.separator +"config/config.properties");
				prop.store(os, "");
				os.flush();
				os.close();
				in.close();
				os = null;
				in = null;
				prop = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.addMessage(new ActionMessage("IGPLUGINMGR.I001"));
		return dto;
	}
	//更新插件DATA.xml
	public IGPluginDTO updatePluginDataXml(IGPluginDTO dto)throws Exception,BLException{
		String realPath="";
		String path=dto.getPath();
		String status=dto.getStatus();
		
		if(path!=null){
			path=path.substring(path.indexOf("WEB-INF"));
		}
		List<String> list_path = getPluginPathList();
		for (String list_p : list_path) {
			String cutpath=list_p.substring(list_p.indexOf("WEB-INF")).replace("\\", "");
			if( cutpath.equals(path) ){
				realPath=list_p;
				break;
			}
		}
		PluginsDataUtils pluginData = new PluginsDataUtils();
		PluginsDataUtilDAO pluginDao = (PluginsDataUtilDAO) WebApplicationSupport.getBean("pluginsDataUtilDAO");
    	if("Y".equals(status) && !"".equals(realPath)){
	    	//删除插件内数据
    		List<SQLBean> delDataList  = pluginData.parseXmlToList_INSERT_OR_UPDATE(realPath+"/config/data.xml");//拼sql
	    	log.debug("=========="+realPath.substring(realPath.indexOf("WEB-INF"))+"启用状态==>插入或更新数据======");
	    	//立即更新data.xml 到  数据库
	    	pluginDao.initConn();
	    	UpdateData(delDataList,pluginDao);
    	}else if("N".equals(status) && !"".equals(realPath)){
    		List<SQLBean> delDataList  = pluginData.parseXmlToList_DELETE_BY_PK(realPath+"/config/data.xml");//pk 删除？
    		log.debug("=========="+realPath.substring(realPath.indexOf("WEB-INF"))+"禁用状态==>删除数据======");
	    	pluginDao.initConn();
	    	DeleteData(delDataList,pluginDao);
    	}
		dto.addMessage(new ActionMessage("IGPLUGINMGR.I002"));
		return dto;
	}
	//获取插件路径列表
	private List<String> getPluginPathList(){
		PluginsDataUtils pluginUtil = new PluginsDataUtils();
		String path = pluginUtil.getAbsolutePathByClass();
		path = path + "WEB-INF" + File.separator + "plugin";
		return pluginUtil.getPluginPath(path);
	}
	/***
	 * 更新数据
	 * @param dataMap
	 * @param pluginDao
	 * @throws Exception
	 */
	private void UpdateData(List<SQLBean> dataList,PluginsDataUtilDAO pluginDao) throws Exception{
		log.debug("==========更新插件数据开始======");
		if(pluginDao==null){
			return;
		}
		//设置非自动提交模式
		pluginDao.setAutCommit(false);
		int temp_int=0;
		for(SQLBean sqlBean:dataList){
			try {
				temp_int=pluginDao.getCountData(sqlBean.getSelectSql(), sqlBean.getPks(),sqlBean.getColumntypes());
				if(temp_int == 1){
					pluginDao.executeSQL(sqlBean.getUpdateSql(), sqlBean.getPkvalues(),sqlBean.getColumntypes());//update
					log.info("====数据存在 更新插件数据"+sqlBean.getUpdateSql()+"==="+sqlBean.getpkvalue()+"\n");
				}else if(temp_int == 0){
					pluginDao.executeSQL(sqlBean.getSql(),sqlBean.getValues(),sqlBean.getColumntypes());//insert
					log.info("====数据不存在 插入插件数据"+sqlBean.getSql()+"==="+sqlBean.getValue()+"\n");
				}else{
					throw new BLException("VALUES IS NULL");
				}
			} catch (SQLException e) {
				pluginDao.rollback();
				log.error("====更新插件数据异常"+sqlBean.getUpdateSql()+"==="+sqlBean.getValue()+"===\n"+e);
			}
		}
		log.debug("==========更新插件数据结束======");
	}
	/***
	 * 删除数据
	 * @param dataMap
	 * @param pluginDao
	 * @throws Exception
	 */
	private void DeleteData(List<SQLBean> dataList,PluginsDataUtilDAO pluginDao) throws Exception{
		log.debug("==========删除插件数据开始======");
		if(pluginDao==null){
			return;
		}
		//设置非自动提交模式
		pluginDao.setAutCommit(false);
		int temp_int=0;
		for(SQLBean sqlBean:dataList){
			try {
				temp_int=pluginDao.getCountData(sqlBean.getSelectSql(), sqlBean.getPks(),sqlBean.getColumntypes());
				if(temp_int==1){
					pluginDao.executeSQL(sqlBean.getSql(), sqlBean.getPks(),sqlBean.getColumntypes());
					log.info("====删除插件数据"+sqlBean.getSql()+"==="+sqlBean.getpk()+"\n");
				}
			} catch (SQLException e) {
				pluginDao.rollback();
				log.error("====删除插件数据异常"+sqlBean.getUpdateSql()+"==="+sqlBean.getpk()+"===\n"+e);
			}
		}
		log.debug("==========删除插件数据结束======");
	}

}
