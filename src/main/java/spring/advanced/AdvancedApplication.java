package spring.advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import spring.advanced.config.proxy.V1Config;
import spring.advanced.config.proxy.V2Config;
import spring.advanced.config.v1_proxy.interface_proxy.InterfaceProxyConfig;
import spring.advanced.trace.logtrace.LogTrace;

//@Import({V1Config.class, V2Config.class})
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "spring.advanced.app.proxy")
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}
}
