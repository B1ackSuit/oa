package cn.ean.oasecurity.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @FileName CaptchaController
 * @Author ean
 * @Date 2023/3/30 19:28
 **/
@RestController
public class CaptchaController {

    private final DefaultKaptcha defaultKaptcha;

    @Autowired
    public CaptchaController(DefaultKaptcha defaultKaptcha) {
        this.defaultKaptcha = defaultKaptcha;
    }

    /**
     * produces: 设置返回数据类型及编码
     * @param request
     * @param response
     */
    @GetMapping(value = "/captcha", produces = "image/jpeg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        // 定义response输出类型为image/jpeg类型
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");



        //-------------------生成验证码 begin --------------------------
        // 获取验证码文本内容
        String text = defaultKaptcha.createText();
        // 将验证码放入Session中
        request.getSession().setAttribute("captcha", text);

        // ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //
        // String nanoid = NanoIdUtils.randomNanoId();
        // valueOperations.set("captcha_" + nanoid, text);
        //
        // try {
        //     result = KeyEncryptUtils.encryptKey(nanoid);
        // } catch (Exception e) {
        //     throw new RuntimeException(e);
        // }

        //根据文本内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            //输出流输出图片，格式jpg
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //-------------------生成验证码 end ----------------------------
        // return result;
    }

}
