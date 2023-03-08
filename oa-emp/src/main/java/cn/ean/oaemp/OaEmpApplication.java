package cn.ean.oaemp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class OaEmpApplication {

    /**
     * 1. AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
     * 2. 在`src/main/resources`目录下新建文件`application.yml`,
     *    内容为：`spring.output.ansi.enabled=always`
     * <p>
     * 重要：如果配置第二种方式(SpringApplication.run())，第一种方式就不会起作用
     */
    public static void main(String[] args) {
        /* 启动颜色格式化
           这不是唯一启动颜色格式的方式，有兴趣的可以查看源码 */
        /*
         .main是为了可以加载 Spring 版本
         .bannerMode设置为控制台打印
         */
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
        new SpringApplicationBuilder(OaEmpApplication.class)
                .main(SpringVersion.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);

        // SpringApplication.run(OaEmpApplication.class, args);
    }

}
