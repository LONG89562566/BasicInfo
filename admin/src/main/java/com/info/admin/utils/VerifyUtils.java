package com.info.admin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;

/**
 * 常用验证
 * 
 * @author administrator
 */
public class VerifyUtils {

	/***
	 * 邮箱
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		Assert.hasText(email, "email is null");
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}

	/***
	 * 手机号码
	 * 
	 * @param 手机号码
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		Assert.hasText(mobile, "mobileis null");
		String check = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(mobile);
		return matcher.matches();
	}

	/**
	 * 是否是Number
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNum(String number) {
		Assert.hasText(number, "number is null");
		String check = "^[0-9]{5}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(number);
		return matcher.matches();
	}
}