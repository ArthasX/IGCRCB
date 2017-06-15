package com.deliverik.framework.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.PageContext;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.utility.data.AuthControlDO;
import com.deliverik.framework.utility.data.AuthControlGuiBlockDO;
import com.deliverik.framework.utility.data.AuthControlGuiItemDO;
import com.deliverik.framework.utility.data.AuthControlParamDO;

/**
 * 
 *
 * 平台未使用<br>
 * <br>
 * <br>
 * <br><br>
 * <br>
 * 
 *
 * @author
 *
 */
@SuppressWarnings("unused")
public class AuthControlUtils {

	/**  */
	protected static volatile HashMap<String, AuthControlDO> authListMap = new HashMap<String, AuthControlDO>();
	/**  */
	private final static String JSP_ID = "id";
	/**  */
	private final static String AUTH_TENBAN = "auth_tenban";
	/**  */
	private final static String AUTH_YUKO_HIZUKE_TO = "auth_yuko_hizuke_to";
	/**  */
	private final static String AUTH_KOJYO_CD = "auth_kojyo_cd";
	/**  */
	private final static String AUTH_TENPO_STATUS = "auth_tenpo_status";
	/**  */
	private final static String AUTH_TENPO_TYPE = "auth_tenpo_type";
	/**  */
	private static volatile Digester digester;

	/**  */
	public final static String AUTHPRM_NOT_VIEW = "NV";
	/**  */
	public final static String AUTHPRM_NOT_INPUT = "NI";
	/**  */
	public final static String AUTHPRM_ONLY_VIEW = "OV";
	/**  */
	public final static String AUTHPRM_ONLY_INPUT = "OI";

	/**  */
	static Log log = LogFactory.getLog(AuthControlUtils.class);

	/**
	 *
	 *
	 * @param p  PageContext
	 * @return
	 */
	public static AuthControlDO getAuthControlData(PageContext p){
		String gui_id = (String)p.getAttribute(JSP_ID, PageContext.REQUEST_SCOPE);

		AuthControlDO ret = authListMap.get(gui_id);
		if(ret == null && setXMLData(p)){
			log.debug("getAuthControlData XML" + gui_id);
			ret = authListMap.get(gui_id);
		}
		return ret;
	}

	/**
	 *
	 *
	 * @param p PageContext
	 * @param block_id
	 * @param item_id
	 * @param ctrlType
	 * @return 
	 */

	public static boolean isControl(PageContext p, String block_id, String item_id, String ctrlType){

		if(block_id==null)
			return false;

		AuthControlDO authDO = getAuthControlData(p);

		if(authDO == null)
			return false;

		AuthControlGuiBlockDO blockDO = null;
		for(AuthControlGuiBlockDO bDO : authDO.getGui_blocks())
			if(block_id.equalsIgnoreCase(bDO.getId()))
				blockDO = bDO;

		if(blockDO == null)
			return false;

		if(AUTHPRM_NOT_VIEW.equalsIgnoreCase(ctrlType)){


		}

		return false;
	}

	/**
	 *
	 *
	 * @param kengen
	 * @param blockDO
	 * @param block_id
	 * @param type
	 * @param status
	 * @param ctrlType
	 * @return
	 */
	private static boolean isControlBlock(List<Integer> kengen, AuthControlGuiBlockDO blockDO, String block_id, String type, String status, String ctrlType){

		if(StringUtils.isEmpty(block_id) || blockDO == null)
			return false;

		if(isExist(kengen, blockDO.getRolls(),ctrlType))
			return true;

		if(isExist(type, blockDO.getType(), ctrlType))
			return true;

		if(isExist(status, blockDO.getStatus(), ctrlType))
			return true;

		if(AUTHPRM_NOT_VIEW.equalsIgnoreCase(ctrlType)){

			if(isOnlyCtrl(getOnlyPrm(blockDO.getRolls(), AUTHPRM_ONLY_VIEW), kengen))
				return true;

			if(isOnlyCtrl(getOnlyPrm(blockDO.getType(), AUTHPRM_ONLY_VIEW), type))
				return true;

			if(isOnlyCtrl(getOnlyPrm(blockDO.getStatus(), AUTHPRM_ONLY_VIEW), status))
				return true;

	}else if(AUTHPRM_NOT_INPUT.equalsIgnoreCase(ctrlType)){

			if(isOnlyCtrl(getOnlyPrm(blockDO.getRolls(), AUTHPRM_ONLY_INPUT), kengen))
				return true;

			if(isOnlyCtrl(getOnlyPrm(blockDO.getType(), AUTHPRM_ONLY_INPUT), type))
				return true;

			if(isOnlyCtrl(getOnlyPrm(blockDO.getStatus(), AUTHPRM_ONLY_INPUT), status))
				return true;
		}


		return false;
	}

	/**
	 *
	 *
	 * @param kengen
	 * @param blockDO
	 * @param item_id
	 * @param type
	 * @param status
	 * @param ctrlType
	 * @return
	 */
	private static boolean isControlItem(List<Integer> kengen, AuthControlGuiBlockDO blockDO, String item_id, String type, String status, String ctrlType){

		if(StringUtils.isEmpty(item_id) || blockDO.getGui_items() == null )
			return false;

		AuthControlGuiItemDO itemDO = null;
		for(AuthControlGuiItemDO iDO : blockDO.getGui_items())
			if(item_id.equalsIgnoreCase(iDO.getId()))
				itemDO = iDO;

		if(itemDO == null)
			return false;

		if(isExist(kengen, itemDO.getRolls(),ctrlType))
			return true;

		if(isExist(type, itemDO.getType(), ctrlType))
			return true;

		if(isExist(status, itemDO.getStatus(), ctrlType))
			return true;

		if(AUTHPRM_NOT_VIEW.equalsIgnoreCase(ctrlType)){

			if(isOnlyCtrl(getOnlyPrm(itemDO.getRolls(), AUTHPRM_ONLY_VIEW), kengen))
				return true;

			if(isOnlyCtrl(getOnlyPrm(itemDO.getType(), AUTHPRM_ONLY_VIEW), type))
				return true;

			if(isOnlyCtrl(getOnlyPrm(itemDO.getStatus(), AUTHPRM_ONLY_VIEW), status))
				return true;


		}else if(AUTHPRM_NOT_INPUT.equalsIgnoreCase(ctrlType)){

			if(isOnlyCtrl(getOnlyPrm(itemDO.getRolls(), AUTHPRM_ONLY_INPUT), kengen))
				return true;

			if(isOnlyCtrl(getOnlyPrm(itemDO.getType(), AUTHPRM_ONLY_INPUT), type))
				return true;

			if(isOnlyCtrl(getOnlyPrm(itemDO.getStatus(), AUTHPRM_ONLY_INPUT), status))
				return true;
		}

		return false;
	}

	private static boolean isExist(List<Integer> list, List<AuthControlParamDO> plist, String prm) {
		if(list == null || plist == null)
			return false;

		for(AuthControlParamDO pdo : plist){
			if(prm.equalsIgnoreCase(pdo.getValue())){
				String buf = "";
				for(Integer s : list){
					if(s!=null)
						buf = s.toString();

					if(buf.equalsIgnoreCase(pdo.getId()))
						return true;
				}
			}
		}
		return false;
	}

	private static boolean isExist(String value, List<AuthControlParamDO> plist, String prm) {
		if(value == null || plist == null)
			return false;

		for(AuthControlParamDO pdo : plist)
			if(prm.equalsIgnoreCase(pdo.getValue()))
				if(value.equalsIgnoreCase(pdo.getId()))
					return true;

		return false;
	}

	private static List<String> getOnlyPrm(List<AuthControlParamDO> plist, String prm) {
		if(plist == null)
			return new ArrayList<String>();

		List<String> ret = new ArrayList<String>();

		for(AuthControlParamDO pdo : plist)
			if(prm.equalsIgnoreCase(pdo.getValue()))
				ret.add(pdo.getId());

		return ret;
	}

	private static boolean isOnlyCtrl(List<String> plist, String value) {

		if(plist == null || value == null || plist.isEmpty())
			return false;

		for(String id : plist)
			if(id.equalsIgnoreCase(value))
				return false;

		return true;
	}

	private static boolean isOnlyCtrl(List<String> plist, List<Integer> value) {

		if(plist == null || value == null || plist.isEmpty())
			return false;

		for(String id : plist)
			for(Integer v : value)
				if(id.equals(Integer.toString(v)))
					return false;

		return true;
	}

	/**
	 * 
	 * <br><br>
	 *
	 * @param p PageContext
	 * @return 
	 * @throws Exception
	 */
	protected static synchronized boolean setXMLData(PageContext p) throws IllegalStateException {
		String guiId = (String)p.getAttribute(JSP_ID, PageContext.REQUEST_SCOPE);

		if(guiId==null)
			throw new IllegalStateException("JSP");


		String dirId = StringUtils.lowerCase(guiId);
		dirId = StringUtils.mid(dirId, 2, 3);

		File f = new File(p.getServletContext().getRealPath("") + "/WEB-INF/auth-xml/" + dirId + "/" + guiId + ".xml");
	    if (!f.exists()){
	    	return false;
	    }

		AuthControlDO map=null;
		if(digester == null)
			setXMLRule();

		try {
			map = (AuthControlDO)digester.parse(f);
			authListMap.put(guiId, map);

		} catch (Exception e) {
			throw new IllegalStateException(e.toString());
		}

		return true;
	}

	/**
	 * 
	 */
	private static synchronized void setXMLRule() throws IllegalStateException {
		if( digester != null) return;
		digester = new Digester();
		// root
        digester.addObjectCreate("auth_ctrl", AuthControlDO.class);
        digester.addSetProperties("auth_ctrl", "gui_id", "gui_id");
	        digester.addObjectCreate("auth_ctrl/rolls/value", AuthControlParamDO.class);
	        digester.addSetNext("auth_ctrl/rolls/value", "addRoll", AuthControlParamDO.class.getName());
	        digester.addBeanPropertySetter("auth_ctrl/rolls/value", "value" );
	        digester.addSetProperties("auth_ctrl/rolls/value", "id", "id");
	        digester.addSetProperties("auth_ctrl/rolls/value", "other", "other");
	        digester.addObjectCreate("auth_ctrl/status/value", AuthControlParamDO.class);
	        digester.addSetNext("auth_ctrl/status/value", "addStatus", AuthControlParamDO.class.getName());
	        digester.addBeanPropertySetter("auth_ctrl/status/value", "value" );
	        digester.addSetProperties("auth_ctrl/status/value", "id", "id");
	        digester.addSetProperties("auth_ctrl/status/value", "other", "other");
	        digester.addObjectCreate("auth_ctrl/type/value", AuthControlParamDO.class);
	        digester.addSetNext("auth_ctrl/type/value", "addType", AuthControlParamDO.class.getName());
	        digester.addBeanPropertySetter("auth_ctrl/type/value", "value" );
	        digester.addSetProperties("auth_ctrl/type/value", "id", "id");
	        digester.addSetProperties("auth_ctrl/type/value", "other", "other");

	        digester.addObjectCreate("auth_ctrl/gui_block", AuthControlGuiBlockDO.class);
	        digester.addSetNext("auth_ctrl/gui_block", "addGui_block", AuthControlGuiBlockDO.class.getName());
	        digester.addSetProperties("auth_ctrl/gui_block", "id", "id");
		        digester.addObjectCreate("auth_ctrl/gui_block/rolls/value", AuthControlParamDO.class);
		        digester.addSetNext("auth_ctrl/gui_block/rolls/value", "addRoll", AuthControlParamDO.class.getName());
		        digester.addBeanPropertySetter("auth_ctrl/gui_block/rolls/value", "value" );
		        digester.addSetProperties("auth_ctrl/gui_block/rolls/value", "id", "id");
		        digester.addSetProperties("auth_ctrl/gui_block/rolls/value", "other", "other");
		        digester.addObjectCreate("auth_ctrl/gui_block/status/value", AuthControlParamDO.class);
		        digester.addSetNext("auth_ctrl/gui_block/status/value", "addStatus", AuthControlParamDO.class.getName());
		        digester.addBeanPropertySetter("auth_ctrl/gui_block/status/value", "value" );
		        digester.addSetProperties("auth_ctrl/gui_block/status/value", "id", "id");
		        digester.addSetProperties("auth_ctrl/gui_block/status/value", "other", "other");
		        digester.addObjectCreate("auth_ctrl/gui_block/type/value", AuthControlParamDO.class);
		        digester.addSetNext("auth_ctrl/gui_block/type/value", "addType", AuthControlParamDO.class.getName());
		        digester.addBeanPropertySetter("auth_ctrl/gui_block/type/value", "value" );
		        digester.addSetProperties("auth_ctrl/gui_block/type/value", "id", "id");
		        digester.addSetProperties("auth_ctrl/gui_block/type/value", "other", "other");

		        digester.addObjectCreate("auth_ctrl/gui_block/gui_item", AuthControlGuiItemDO.class);
		        digester.addSetNext("auth_ctrl/gui_block/gui_item", "addGui_item", AuthControlGuiItemDO.class.getName());
		        digester.addSetProperties("auth_ctrl/gui_block/gui_item", "id", "id");
			        digester.addObjectCreate("auth_ctrl/gui_block/gui_item/rolls/value", AuthControlParamDO.class);
			        digester.addSetNext("auth_ctrl/gui_block/gui_item/rolls/value", "addRoll", AuthControlParamDO.class.getName());
			        digester.addBeanPropertySetter("auth_ctrl/gui_block/gui_item/rolls/value", "value" );
			        digester.addSetProperties("auth_ctrl/gui_block/gui_item/rolls/value", "id", "id");
			        digester.addSetProperties("auth_ctrl/gui_block/gui_item/rolls/value", "other", "other");
			        digester.addObjectCreate("auth_ctrl/gui_block/gui_item/status/value", AuthControlParamDO.class);
			        digester.addSetNext("auth_ctrl/gui_block/gui_item/status/value", "addStatus", AuthControlParamDO.class.getName());
			        digester.addBeanPropertySetter("auth_ctrl/gui_block/gui_item/status/value", "value" );
			        digester.addSetProperties("auth_ctrl/gui_block/gui_item/status/value", "id", "id");
			        digester.addSetProperties("auth_ctrl/gui_block/gui_item/status/value", "other", "other");
			        digester.addObjectCreate("auth_ctrl/gui_block/gui_item/type/value", AuthControlParamDO.class);
			        digester.addSetNext("auth_ctrl/gui_block/gui_item/type/value", "addType", AuthControlParamDO.class.getName());
			        digester.addBeanPropertySetter("auth_ctrl/gui_block/gui_item/type/value", "value" );
			        digester.addSetProperties("auth_ctrl/gui_block/gui_item/type/value", "id", "id");
			        digester.addSetProperties("auth_ctrl/gui_block/gui_item/type/value", "other", "other");

	}

}
