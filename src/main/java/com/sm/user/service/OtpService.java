package com.sm.user.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@Component
public class OtpService {
	private static final Logger LOG = LoggerFactory.getLogger(OtpService.class);
	private static final Integer EXPIRE_MINS = 1;
	private static final Integer EXPIRE_MINS_FORGOTPASSWORD = 1;
	private LoadingCache<String, Integer> otpCache;
	private LoadingCache<String, Integer> otpCacheForGotPassword;

	public OtpService() {
		super();
		otpCache = CacheBuilder.newBuilder().
				expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
			public Integer load(String key) {
				return 0;
			}
		});
		otpCacheForGotPassword= CacheBuilder.newBuilder().
				expireAfterWrite(EXPIRE_MINS_FORGOTPASSWORD, TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
			public Integer load(String key) {
				return 0;
			}
		});

	}
	//This method is used to push the otp number against Key. Rewrite the OTP if it exists
	//Using user id  as key
	public int generateOTP(String key) {
		LOG.info("Generate OTP in OTP Service Class");
		Integer otp = generateOtp();
		otpCache.put(key, otp);
		return otp;
	}

	public int generateOTPForGetPassWord(String key) {
		LOG.info("Generate OTP in OTP Service Class");
		Integer otp = generateOtp();
		otpCacheForGotPassword.put(key, otp);
		return otp;
	}
	//This method is used to return the OPT number against Key->Key values is username
	public int getOtp(String key) {
		try {
			LOG.debug("Get OTP By Username " + key);

			return otpCache.get(key);
		} catch (Exception e) {
			LOG.error("No Otp Found For The Username = " + key);
			return 0;
		}
	}

	public int getOtpForGetPassWord(String key) {
		try {
			LOG.debug("Get OTP By Username " + key);

			return otpCacheForGotPassword.get(key);
		} catch (Exception e) {
			LOG.error("No Otp Found For The Username = " + key);
			return 0;
		}
	}

	//This method is used to clear the OTP catched already
	public void clearOTP(String key) {
		LOG.debug("Clear OTP For Key " + key);
		otpCache.invalidate(key);

		LOG.info("OTP Clear or invalidated for Key " + key);
	}

	public void clearOTPForGetPassWord(String key) {
		LOG.debug("Clear OTP For Key " + key);
		otpCacheForGotPassword.invalidate(key);

		LOG.info("OTP Clear or invalidated for Key " + key);
	}
private Integer generateOtp(){
	Random random = new Random();
	int otp=random.nextInt(999999);
	while (String.valueOf(otp).length()<6){

		otp=random.nextInt(999999);
	}

	return Integer.valueOf(otp);
}

}
