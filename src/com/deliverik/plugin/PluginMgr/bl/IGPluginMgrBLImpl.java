/*
 * ��������������������޹�˾��
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
 * ����: ����ӿ�ʵ��
 * ��������: ����ӿ�ʵ��
 * ������¼: 2012-11-5
 * �޸ļ�¼: 
 */
public class IGPluginMgrBLImpl extends BaseBLImpl implements IGPluginMgrBL{
	static Log log = LogFactory.getLog(IGPluginMgrBLImpl.class);
	FileInputStream in;
	FileOutputStream os;
	File dataFile = null;
	//��ѯ����б�
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
	//���Ĳ��״̬
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
				//дconfig.properties
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
	//���²��DATA.xml
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
	    	//ɾ�����������
    		List<SQLBean> delDataList  = pluginData.parseXmlToList_INSERT_OR_UPDATE(realPath+"/config/data.xml");//ƴsql
	    	log.debug("=========="+realPath.substring(realPath.indexOf("WEB-INF"))+"����״̬==>������������======");
	    	//��������data.xml ��  ���ݿ�
	    	pluginDao.initConn();
	    	UpdateData(delDataList,pluginDao);
    	}else if("N".equals(status) && !"".equals(realPath)){
    		List<SQLBean> delDataList  = pluginData.parseXmlToList_DELETE_BY_PK(realPath+"/config/data.xml");//pk ɾ����
    		log.debug("=========="+realPath.substring(realPath.indexOf("WEB-INF"))+"����״̬==>ɾ������======");
	    	pluginDao.initConn();
	    	DeleteData(delDataList,pluginDao);
    	}
		dto.addMessage(new ActionMessage("IGPLUGINMGR.I002"));
		return dto;
	}
	//��ȡ���·���б�
	private List<String> getPluginPathList(){
		PluginsDataUtils pluginUtil = new PluginsDataUtils();
		String path = pluginUtil.getAbsolutePathByClass();
		path = path + "WEB-INF" + File.separator + "plugin";
		return pluginUtil.getPluginPath(path);
	}
	/***
	 * ��������
	 * @param dataMap
	 * @param pluginDao
	 * @throws Exception
	 */
	private void UpdateData(List<SQLBean> dataList,PluginsDataUtilDAO pluginDao) throws Exception{
		log.debug("==========���²�����ݿ�ʼ======");
		if(pluginDao==null){
			return;
		}
		//���÷��Զ��ύģʽ
		pluginDao.setAutCommit(false);
		int temp_int=0;
		for(SQLBean sqlBean:dataList){
			try {
				temp_int=pluginDao.getCountData(sqlBean.getSelectSql(), sqlBean.getPks(),sqlBean.getColumntypes());
				if(temp_int == 1){
					pluginDao.executeSQL(sqlBean.getUpdateSql(), sqlBean.getPkvalues(),sqlBean.getColumntypes());//update
					log.info("====���ݴ��� ���²������"+sqlBean.getUpdateSql()+"==="+sqlBean.getpkvalue()+"\n");
				}else if(temp_int == 0){
					pluginDao.executeSQL(sqlBean.getSql(),sqlBean.getValues(),sqlBean.getColumntypes());//insert
					log.info("====���ݲ����� ����������"+sqlBean.getSql()+"==="+sqlBean.getValue()+"\n");
				}else{
					throw new BLException("VALUES IS NULL");
				}
			} catch (SQLException e) {
				pluginDao.rollback();
				log.error("====���²�������쳣"+sqlBean.getUpdateSql()+"==="+sqlBean.getValue()+"===\n"+e);
			}
		}
		log.debug("==========���²�����ݽ���======");
	}
	/***
	 * ɾ������
	 * @param dataMap
	 * @param pluginDao
	 * @throws Exception
	 */
	private void DeleteData(List<SQLBean> dataList,PluginsDataUtilDAO pluginDao) throws Exception{
		log.debug("==========ɾ��������ݿ�ʼ======");
		if(pluginDao==null){
			return;
		}
		//���÷��Զ��ύģʽ
		pluginDao.setAutCommit(false);
		int temp_int=0;
		for(SQLBean sqlBean:dataList){
			try {
				temp_int=pluginDao.getCountData(sqlBean.getSelectSql(), sqlBean.getPks(),sqlBean.getColumntypes());
				if(temp_int==1){
					pluginDao.executeSQL(sqlBean.getSql(), sqlBean.getPks(),sqlBean.getColumntypes());
					log.info("====ɾ���������"+sqlBean.getSql()+"==="+sqlBean.getpk()+"\n");
				}
			} catch (SQLException e) {
				pluginDao.rollback();
				log.error("====ɾ����������쳣"+sqlBean.getUpdateSql()+"==="+sqlBean.getpk()+"===\n"+e);
			}
		}
		log.debug("==========ɾ��������ݽ���======");
	}

}
