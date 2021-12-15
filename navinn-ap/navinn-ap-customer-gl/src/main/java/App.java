import controller.A01Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration  // 開啟SpringBoot自動化配置的引入
@ImportResource("classpath:/app-context/app-context.xml")
@ComponentScan(basePackages={"controller","service","persistent"})
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);  // 啟動SpringBoot的選項，並將自身的類別App.class注入，args表可加入啟動多個參數
    }
}
