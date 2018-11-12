/*
 * Copyright (c) 2011-2013 GoPivotal, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.info.admin.utils;
 
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Helper for creating random and Type 1 (time-based) UUIDs.
 *
 * @author Jon Brisbin
 */
public abstract class UUIDUtils {
 
	private static boolean IS_THREADLOCALRANDOM_AVAILABLE = false;
	private static       Random random;
	private static final long   leastSigBits;
	private static final ReentrantLock lock = new ReentrantLock();
	private static long lastTime;
 
	static {
		try {
			IS_THREADLOCALRANDOM_AVAILABLE = null != UUIDUtils.class.getClassLoader().loadClass(
					"java.util.concurrent.ThreadLocalRandom"
			);
		} catch(ClassNotFoundException e) {
		}
 
		byte[] seed = new SecureRandom().generateSeed(8);
		leastSigBits = new BigInteger(seed).longValue();
		if(!IS_THREADLOCALRANDOM_AVAILABLE) {
			random = new Random(leastSigBits);
		}
	}

	public static String[] chars = new String[] { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z"
	};

	/**
	 * 生成10位UUID
	 * @return 10位UUID
	 */
	public static String generateShortUuid() {
		return generateShortUuid(10);
	}

	/**
	 * 生成指定位UUID
	 * @param bit 位数
	 * @return 指定位UUID
	 */
	public static String generateShortUuid(int bit) {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < bit; i++) {
			String str = uuid.substring(i * 3, i * 3 + 3);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 35]);
		}
		return shortBuffer.toString();
	}

	private UUIDUtils() {

	}
 
	/**
	 * Create a new random UUID.
	 *
	 * @return the new UUID
	 */
	public static UUID random() {
		byte[] randomBytes = new byte[16];
		if(IS_THREADLOCALRANDOM_AVAILABLE) {
			java.util.concurrent.ThreadLocalRandom.current().nextBytes(randomBytes);
		} else {
			random.nextBytes(randomBytes);
		}
 
		long mostSigBits = 0;
		for(int i = 0; i < 8; i++) {
			mostSigBits = (mostSigBits << 8) | (randomBytes[i] & 0xff);
		}
		long leastSigBits = 0;
		for(int i = 8; i < 16; i++) {
			leastSigBits = (leastSigBits << 8) | (randomBytes[i] & 0xff);
		}
 
		return new UUID(mostSigBits, leastSigBits);
	}
 
	/**
	 * Create a new time-based UUID.
	 *
	 * @return the new UUID
	 */
	public static UUID create() {
		long timeMillis = (System.currentTimeMillis() * 10000) + 0x01B21DD213814000L;
 
		lock.lock();
		try {
			if(timeMillis > lastTime) {
				lastTime = timeMillis;
			} else {
				timeMillis = ++lastTime;
			}
		} finally {
			lock.unlock();
		}
 
		// time low
		long mostSigBits = timeMillis << 32;
 
		// time mid
		mostSigBits |= (timeMillis & 0xFFFF00000000L) >> 16;
 
		// time hi and version
		mostSigBits |= 0x1000 | ((timeMillis >> 48) & 0x0FFF); // version 1
 
		return new UUID(mostSigBits, leastSigBits);
	}

	public static void main(String[] args) {
		System.out.println("code : "+generateShortUuid());
	}
}
