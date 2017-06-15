package com.deliverik.infogovernor.validator;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.DateValidator;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.FieldChecks;
import org.apache.struts.validator.Resources;

import com.deliverik.framework.utility.IGStringUtils;

/**
 * 
 *
 * @author
 *
 */
public class IGValidator {

	/**
	 * YYYYMMDD<br>
	 * 99999999 OK
	 */
	public static boolean validateDate(Object bean, ValidatorAction va, Field field,
			ActionMessages errors, Validator validator, HttpServletRequest request) {

		String value = null;

		//
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		if( "99999999".equals(value) ) return true;
		if( StringUtils.isEmpty(value)) return true;

		// ALL0
        boolean allowAll0Flg = BooleanUtils.toBoolean(Resources.getVarValue("allowAll0", field, validator, request, false));

		if( allowAll0Flg && "00000000".equals(value)) return true;

		if ( !DateValidator.getInstance().isValid(value, "yyyyMMdd", true)) {
			errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
			return false;
		}

		if( !Character.isDigit(value.charAt(value.length()-1) )){
			// 
			errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
			return false;
		}

		// 
		int year = Integer.parseInt(value.substring(0, 4));
		if( year < 1900 || year > 2999 ){
			errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
			return false;
		}

		return true;

	}


	/**
	 * <br>
	 * NumberFormat
	 * 
	 */
	public static boolean validateDate2(Object bean, ValidatorAction va, Field field,
			ActionMessages errors, Validator validator, HttpServletRequest request) {

		String value = null;

		//
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		if( StringUtils.isEmpty(value)) return true;

		if( !Character.isDigit(value.charAt(value.length()-1) )){
			//
			errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
			return false;
		}

		Object ret = FieldChecks.validateDate(bean, va, field, errors, validator, request);
		if( ret instanceof Boolean ){
			return ((Boolean)ret).booleanValue();
		} else if( ret instanceof Date ){
			//
			if( ret != null ){
				Calendar c = Calendar.getInstance();
				c.setTime((Date)ret);
				int year = c.get(Calendar.YEAR);
				if( year < 1900 || year > 2999 ){
					errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
					return false;
				}
			}
			return true;
		} else {
			errors.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
			return false;
		}

	}

	/**
	 * 
	 */
	public static boolean validateMaxBytes(Object bean, ValidatorAction va, Field field,
			ActionMessages errors, Validator validator, HttpServletRequest request) {

		String value = null;

		//
		if (isString(bean)) {
			value = (String) bean;
		} else {
			value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		}

		int maxBytes =Integer.valueOf(Resources.getVarValue("maxbytes", field, validator,request, true));

		//
		if (!IGStringUtils.isValidBytes(value,maxBytes)) {
			errors.add(field.getKey(), new ActionMessage(va.getMsg(), field.getArg(0).getKey() , maxBytes/3, maxBytes));
			return false;
		}

		return true;
	}

	protected static boolean isString(Object o) {
		return (o == null) ? true : String.class.isInstance(o);
	}
}
