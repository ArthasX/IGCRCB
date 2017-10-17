package com.dev.hac.bl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.dev.hac.dto.IGHAC01DTO;
import com.dev.hac.form.IGHAC0101Form;
import com.dev.hac.model.entity.HacTB;
import com.dev.hac.util.CodeDefineHac;
import com.dev.hac.util.ComUtil;

public class IGHAC01BLImpl extends BaseBLImpl implements IGHAC01BL {

	static Log log = LogFactory.getLog(IGHAC01BLImpl.class);
	/**
	 * <p>
	 * 查询数据信息树
	 * </p>
	 * @throws BLException
	 * @author lvxin@deliverik.com
	 */
	
	@SuppressWarnings("unchecked")
	public IGHAC01DTO searchCodeTreeAction(IGHAC01DTO dto) throws BLException{
		log.debug("========查询CODE_TREE开始========");
		List<HacTB> hacList = new ArrayList<HacTB>();
		
		
		IGHAC0101Form form = dto.getIghac0101form();
		String platname;
		try {
			platname = URLDecoder.decode(form.getPlatname(),"utf-8");
		
			String url = ResourceUtility.getString("GROUP_URL");
            String endurl= url+URLEncoder.encode(platname,"UTF-8");
            log.info("========查询HAC权限树地址========"+endurl);
            String json = "{'success':true,'errorCode':0,'data':[{'deviceName':'核心账务系统-武汉验证','deviceId':'7825','accountId':[{'deviceId':'7825','accountType':'2','accountId':'15338','name':'db2irun','id':584637304941838342},{'deviceId':'7825','accountType':'2','accountId':'15339','name':'root','id':584637304941838341},{'deviceId':'7825','accountType':'2','accountId':'15340','name':'sudoroot','id':584637304941838340},{'deviceId':'7825','accountType':'2','accountId':'15341','name':'view','id':584637304941838339}],'groupId':'1','id':583470814163107840,'portId':[{'deviceId':'7825','protocol':'SSH','name':'22','id':584637304941838338,'portId':'7826'},{'deviceId':'7825','protocol':'SFTP','name':'22','id':584637304941838337,'portId':'7827'}],'ipAddress':'190.100.100.110'},{'deviceName':'核心账务系统-武汉容灾','deviceId':'7829','accountId':[{'deviceId':'7829','accountType':'2','accountId':'14413','name':'db2irun','id':584637304887312390},{'deviceId':'7829','accountType':'2','accountId':'14415','name':'root','id':584637304887312389},{'deviceId':'7829','accountType':'2','accountId':'14416','name':'sudoroot','id':584637304887312388},{'deviceId':'7829','accountType':'2','accountId':'14417','name':'view','id':584637304887312387}],'groupId':'1','id':583470814129553408,'portId':[{'deviceId':'7829','protocol':'SSH','name':'22','id':584637304887312386,'portId':'7830'},{'deviceId':'7829','protocol':'SFTP','name':'22','id':584637304887312385,'portId':'7831'}],'ipAddress':'10.200.1.1'},{'deviceName':'核心账务系统-导数','deviceId':'7833','accountId':[{'deviceId':'7833','accountType':'2','accountId':'12943','name':'csrcb','id':584637304862146567},{'deviceId':'7833','accountType':'2','accountId':'12944','name':'db2iread','id':584637304862146566},{'deviceId':'7833','accountType':'2','accountId':'12945','name':'root','id':584637304862146565},{'deviceId':'7833','accountType':'2','accountId':'12946','name':'sudoroot','id':584637304862146564},{'deviceId':'7833','accountType':'2','accountId':'12947','name':'view','id':584637304862146563}],'groupId':'1','id':583470814091804672,'portId':[{'deviceId':'7833','protocol':'SSH','name':'22','id':584637304862146562,'portId':'7834'},{'deviceId':'7833','protocol':'SFTP','name':'22','id':584637304862146561,'portId':'7835'}],'ipAddress':'10.11.1.27'},{'deviceName':'核心账务系统-DB-主','deviceId':'7837','accountId':[{'deviceId':'7837','accountType':'2','accountId':'12930','name':'csrcb','id':584637304845369350},{'deviceId':'7837','accountType':'2','accountId':'12931','name':'root','id':584637304845369349},{'deviceId':'7837','accountType':'2','accountId':'12932','name':'sudoroot','id':584637304845369348},{'deviceId':'7837','accountType':'2','accountId':'12933','name':'view','id':584637304845369347}],'groupId':'1','id':583470814054055936,'portId':[{'deviceId':'7837','protocol':'SSH','name':'22','id':584637304845369346,'portId':'7838'},{'deviceId':'7837','protocol':'SFTP','name':'22','id':584637304845369345,'portId':'7839'}],'ipAddress':'10.11.1.23'},{'deviceName':'核心账务系统-DB-容灾','deviceId':'7841','accountId':[{'deviceId':'7841','accountType':'2','accountId':'12912','name':'root','id':584637304828592133},{'deviceId':'7841','accountType':'2','accountId':'12913','name':'sudoroot','id':584637304828592132},{'deviceId':'7841','accountType':'2','accountId':'12914','name':'view','id':584637304828592131}],'groupId':'1','id':583470814020501504,'portId':[{'deviceId':'7841','protocol':'SSH','name':'22','id':584637304828592130,'portId':'7842'},{'deviceId':'7841','protocol':'SFTP','name':'22','id':584637304828592129,'portId':'7843'}],'ipAddress':'10.11.1.123'},{'deviceName':'核心账务系统-DB-备','deviceId':'7845','accountId':[{'deviceId':'7845','accountType':'2','accountId':'12934','name':'csrcb','id':584637304807620614},{'deviceId':'7845','accountType':'2','accountId':'12935','name':'root','id':584637304807620613},{'deviceId':'7845','accountType':'2','accountId':'12936','name':'sudoroot','id':584637304807620612},{'deviceId':'7845','accountType':'2','accountId':'12937','name':'view','id':584637304807620611}],'groupId':'1','id':583470813982752768,'portId':[{'deviceId':'7845','protocol':'SSH','name':'22','id':584637304807620610,'portId':'7846'},{'deviceId':'7845','protocol':'SFTP','name':'22','id':584637304807620609,'portId':'7847'}],'ipAddress':'10.11.1.24'},{'deviceName':'核心账务系统-APP-主','deviceId':'7849','accountId':[{'deviceId':'7849','accountType':'2','accountId':'12915','name':'csrcb','id':584637304790843401},{'deviceId':'7849','accountType':'2','accountId':'12916','name':'cyccall','id':584637304790843400},{'deviceId':'7849','accountType':'2','accountId':'12917','name':'db2iread','id':584637304790843399},{'deviceId':'7849','accountType':'2','accountId':'12919','name':'root','id':584637304790843398},{'deviceId':'7849','accountType':'2','accountId':'12920','name':'sudoroot','id':584637304790843397},{'deviceId':'7849','accountType':'2','accountId':'12921','name':'view','id':584637304790843396},{'deviceId':'7849','accountType':'2','accountId':'12922','name':'watch','id':584637304790843395}],'groupId':'1','id':583470813949198336,'portId':[{'deviceId':'7849','protocol':'SSH','name':'22','id':584637304790843394,'portId':'7850'},{'deviceId':'7849','protocol':'SFTP','name':'22','id':584637304790843393,'portId':'7851'}],'ipAddress':'10.11.1.21'},{'deviceName':'核心账务系统-APP-备','deviceId':'7853','accountId':[{'deviceId':'7853','accountType':'2','accountId':'12923','name':'csrcb','id':584637304761483273},{'deviceId':'7853','accountType':'2','accountId':'12924','name':'cyccall','id':584637304761483272},{'deviceId':'7853','accountType':'2','accountId':'12925','name':'db2iread','id':584637304761483271},{'deviceId':'7853','accountType':'2','accountId':'12926','name':'root','id':584637304761483270},{'deviceId':'7853','accountType':'2','accountId':'12927','name':'sudoroot','id':584637304761483269},{'deviceId':'7853','accountType':'2','accountId':'12928','name':'view','id':584637304761483268},{'deviceId':'7853','accountType':'2','accountId':'12929','name':'watch','id':584637304761483267}],'groupId':'1','id':583470813919838208,'portId':[{'deviceId':'7853','protocol':'SSH','name':'22','id':584637304761483266,'portId':'7854'},{'deviceId':'7853','protocol':'SFTP','name':'22','id':584637304761483265,'portId':'7855'}],'ipAddress':'10.11.1.22'},{'deviceName':'核心账务系统-历史DB','deviceId':'7857','accountId':[{'deviceId':'7857','accountType':'2','accountId':'12938','name':'csrcb','id':584637304748900359},{'deviceId':'7857','accountType':'2','accountId':'12939','name':'db2iread','id':584637304748900358},{'deviceId':'7857','accountType':'2','accountId':'12940','name':'root','id':584637304748900357},{'deviceId':'7857','accountType':'2','accountId':'12941','name':'sudoroot','id':584637304748900356},{'deviceId':'7857','accountType':'2','accountId':'12942','name':'view','id':584637304748900355}],'groupId':'1','id':583470813890478080,'portId':[{'deviceId':'7857','protocol':'SSH','name':'22','id':584637304748900354,'portId':'7858'},{'deviceId':'7857','protocol':'SFTP','name':'22','id':584637304748900353,'portId':'7859'}],'ipAddress':'10.11.1.26'},{'deviceName':'核心账务系统-APP-容灾','deviceId':'7861','accountId':[{'deviceId':'7861','accountType':'2','accountId':'12905','name':'csrcb','id':584637304736317445},{'deviceId':'7861','accountType':'2','accountId':'12907','name':'root','id':584637304736317444},{'deviceId':'7861','accountType':'2','accountId':'12908','name':'sudoroot','id':584637304736317443},{'deviceId':'7861','accountType':'2','accountId':'12910','name':'view','id':584637304736317442}],'groupId':'1','id':583470813856923648,'portId':[{'deviceId':'7861','protocol':'SSH','name':'22','id':584637304736317441,'portId':'7862'},{'deviceId':'7861','protocol':'SFTP','name':'22','id':584637304736317440,'portId':'7863'}],'ipAddress':'10.11.1.121'},{'deviceName':'核心历史系统（临时）','deviceId':'8212','accountId':[{'deviceId':'8212','accountType':'2','accountId':'15295','name':'csrcb','id':584637304702763014},{'deviceId':'8212','accountType':'2','accountId':'15296','name':'root','id':584637304702763013},{'deviceId':'8212','accountType':'2','accountId':'15297','name':'sudoroot','id':584637304702763012},{'deviceId':'8212','accountType':'2','accountId':'15298','name':'view','id':584637304702763011}],'groupId':'1','id':583470813798203392,'portId':[{'deviceId':'8212','protocol':'SSH','name':'22','id':584637304702763010,'portId':'8213'},{'deviceId':'8212','protocol':'SFTP','name':'22','id':584637304702763009,'portId':'8214'}],'ipAddress':'160.100.212.65'},{'deviceName':'核心账务DB本地HADR','deviceId':'8228','accountId':[{'deviceId':'8228','accountType':'2','accountId':'15241','name':'root','id':584637304690180099},{'deviceId':'8228','accountType':'2','accountId':'15242','name':'sudoroot','id':584637304690180098}],'groupId':'1','id':583470813768843264,'portId':[{'deviceId':'8228','protocol':'SSH','name':'22','id':584637304690180097,'portId':'8229'},{'deviceId':'8228','protocol':'SFTP','name':'22','id':584637304690180096,'portId':'8230'}],'ipAddress':'160.100.211.227'}]}";
            JSONObject obj=JSON.parseObject(json);
            //获取到返回的数据
            Map<String,Object> data_jsonmap =  ComUtil.httpRequest(endurl, "GET", null);
           
            log.info("========查询HAC权限树返回数据========"+JSON.toJSONString(data_jsonmap));
            if(data_jsonmap!=null){
            	CodeDefineHac.HAC_MAP= data_jsonmap;
            }else{
            	log.error("变更流程调用获取平台权限树节点未连通");
            	CodeDefineHac.HAC_MAP= obj;
            }
            if(CodeDefineHac.HAC_MAP!=null){
            	
            	Map<String,Object> start_jsonmap =  CodeDefineHac.HAC_MAP;
            	List<Map<String,Object>> new_jsonmap = (List<Map<String, Object>>) start_jsonmap.get("data");
            	if(new_jsonmap!=null){
            		for(int h=0;h<new_jsonmap.size();h++){
            			Map<String,Object>jsonmap = new_jsonmap.get(h);
            			//获取port数据
                        List<Map<String,String>>portMap = (List<Map<String, String>>) jsonmap.get("portId");
                        //获取accounts数据
                        List<Map<String,String>>accMap = (List<Map<String, String>>) jsonmap.get("accountId");
                        //一级树
                        HacTB hactb = new HacTB();
                        hactb.setId(jsonmap.get("deviceId").toString());
                        hactb.setName(jsonmap.get("deviceName")+"("+jsonmap.get("ipAddress")+")");
                        hactb.setPid("0");
                        hacList.add(hactb);
                		//二级树
                		if(portMap.size()>0){
                			for(int i=0;i<portMap.size();i++){
                				HacTB hactbtwo = new HacTB();
                				 
                				hactbtwo.setId(portMap.get(i).get("portId"));
                				hactbtwo.setName(portMap.get(i).get("protocol"));
                				hactbtwo.setPid(jsonmap.get("deviceId").toString());
                				hacList.add(hactbtwo);
                				//添加三级树
                				if(accMap.size()>0){
                					for(int j=0;j<accMap.size();j++){
                						HacTB hactbth = new HacTB();
                						hactbth.setId(accMap.get(j).get("accountId"));
                						hactbth.setName(accMap.get(j).get("name"));
                						hactbth.setPid(portMap.get(i).get("portId"));
                						hacList.add(hactbth);
                					}
                				}
                			}
                		}
            		}
            	}   
            }
            
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		dto.setHacList(hacList);
		log.debug("========查询CODE_TREE结束========");
		return dto;
	}
	
}
