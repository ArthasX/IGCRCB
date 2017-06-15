package com.system.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.system.plugins.utils.PluginsDataUtils;
import com.system.plugins.utils.SQLBean;
import com.system.plugins.utils.dao.PluginsDataUtilDAO;

public class PluginInit implements PlugIn{
	static Log log = LogFactory.getLog(PluginInit.class);
	
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		PluginsDataUtils pluginUtil = new PluginsDataUtils();
		String path = pluginUtil.getAbsolutePathByClass();
		path = path + "WEB-INF" + File.separator + "plugin";
		List<String> pluginList = pluginUtil.getPluginPath(path);
		PluginsDataUtils pluginData = new PluginsDataUtils();
		PluginsDataUtilDAO pluginDao = (PluginsDataUtilDAO) WebApplicationSupport.getBean("pluginsDataUtilDAO");;
		try {
			pluginDao.initConn();
		} catch (SQLException e1) {
			throw new ServletException(e1);
		}

		FileInputStream in;
		File dataFile = null;
		
		String pluginName = "";   //初始化插件名称
		String pluginStatus = "N";  //初始化插件状态
		
		for(String pluginPath:pluginList){
			try {
				in = new FileInputStream(pluginPath+ File.separator +"config/config.properties");
				Properties prop = new Properties();
				prop.load(in);
		    	pluginStatus = prop.getProperty("PLUGIN_STATUS");
		    	pluginName = prop.getProperty("PLUGIN_NAME");
				in.close();
				in = null;
				prop = null;
				log.debug("=====处理====="+pluginName+"插件数据开始======");
				
		    	dataFile = new File(pluginPath+ File.separator +"/config/data.xml");
		    	if(!dataFile.exists()){
		    		log.debug("=========="+pluginName+"数据文件不存在======");
		    		continue;
		    	}
		    	//如果插件不为启动状态
		    	if(!"Y".equals(pluginStatus)){
			    	//删除插件内数据
		    		List<SQLBean> delDataList  = pluginData.parseXmlToList_DELETE_BY_PK(pluginPath+"/config/data.xml");
			    	log.debug("=========="+pluginName+"未启用======");
			    	deleteDate(delDataList,pluginDao,pluginName);
		    	}else{
			    	List<SQLBean> insDataList  = pluginData.parseXmlToList_INSERT_OR_UPDATE(pluginPath+"/config/data.xml");
			    	insertDate(insDataList,pluginDao,pluginName);
		    	}
			} catch (Exception e) {
				log.error("=====插件加载失败====="+e.getMessage()+"======"+pluginName+"\n"+e,e);
			}
			log.debug("=====处理====="+pluginName+"插件数据完成======");
		}
		try {
			pluginDao.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
	
	/***
	 * 删除数据
	 * @param dataMap
	 * @param pluginDao
	 * @throws Exception
	 */
	private void deleteDate(List<SQLBean> dataList,PluginsDataUtilDAO pluginDao,String pluginName) throws Exception{
		log.debug("==========删除"+pluginName+"插件数据开始======");
		if(pluginDao==null){
			return;
		}
		//设置非自动提交模式
		pluginDao.setAutCommit(false);
		for(SQLBean sqlBean:dataList){
			try {
				if(pluginDao.getCountData(sqlBean.getSelectSql(), sqlBean.getPks(),sqlBean.getColumntypes())==1){
					pluginDao.executeSQL(sqlBean.getSql(),sqlBean.getPks(),sqlBean.getColumntypes());
					log.info("====删除插件数据"+sqlBean.getSql()+"==="+sqlBean.getpk()+"===="+pluginName+"===\n");
				}
			} catch (SQLException e) {
				pluginDao.rollback();
				log.error("====插件数据删除失败"+sqlBean.getSql()+"==="+sqlBean.getpk()+"===="+pluginName+"===\n"+e);
			}
		}
		log.debug("==========删除"+pluginName+"插件数据结束======");
	}
	
	/***
	 * 插入数据
	 * @param dataMap
	 * @param pluginDao
	 * @throws Exception
	 */
	private void insertDate(List<SQLBean> dataList,PluginsDataUtilDAO pluginDao,String pluginName) throws Exception{
		if(pluginDao==null){
			return;
		}
		log.debug("==========更新"+pluginName+"插件数据开始======");
		pluginDao.setAutCommit(false);
		for(SQLBean sqlBean:dataList){
			try {
				if(pluginDao.getCountData(sqlBean.getSelectSql(), sqlBean.getPks(),sqlBean.getColumntypes()) == 0){
					pluginDao.executeSQL(sqlBean.getSql(),sqlBean.getValues(),sqlBean.getColumntypes());
					log.info("====数据不存在 插入插件数据"+sqlBean.getSql()+"==="+sqlBean.getValue()+"===="+pluginName+"===\n");
				}
			} catch (SQLException e) {
				pluginDao.rollback();
				log.error("====插件数据更新失败"+sqlBean.getSql()+"==="+sqlBean.getValue()+"===="+pluginName+"===\n"+e,e);
			}
		}
		log.debug("==========更新"+pluginName+"插件数据结束======");
	}
	

	public void destroy() {
	}
}
