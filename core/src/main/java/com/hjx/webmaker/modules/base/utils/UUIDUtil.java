package com.hjx.webmaker.modules.base.utils;

import java.util.UUID;

/**
 * 唯一ID生成器。
 *
 * @author HuangJixin
 */
public class UUIDUtil {
    /**
     * 静态生成唯一ID的方法。
     *
     * @return
     */
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
