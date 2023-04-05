package cn.ean.oasecurity.util.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @FileName KeyEncryptUtil
 * @Author ean
 * @Date 2023/4/5 16:29
 **/
public class KeyEncryptUtils {

    /**
     * 加密算法和填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/CBC/PKCS5Padding";

    /**
     * AES加密密钥
     */
    private static final String AES_KEY = "0123456789abcdef";

    /**
     *  加密向量
     */
    private static final String AES_IV = "0123456789abcdef";

    /**
     * 加密key
     * @param key 要加密的key
     * @return 加密后的字符串
     * @throws Exception 加密异常
     */
    public static String encryptKey(String key) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(AES_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        IvParameterSpec iv = new IvParameterSpec(AES_IV.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(key.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * 解密key
     * @param encryptedKey 被加密的key
     * @return 解密后的key
     * @throws Exception 解密异常
     */
    public static String decryptKey(String encryptedKey) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(AES_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
        IvParameterSpec iv = new IvParameterSpec(AES_IV.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedKey));
        return new String(original);
    }


}
