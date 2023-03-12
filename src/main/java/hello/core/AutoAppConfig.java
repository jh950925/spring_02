package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages =  "hello.core.member" ,
//        basePackageClasses = AutoAppConfig.class ,
        // 위 처럼 경로를 지정하지 않으면 현재 Configuration class 파일이 있는 package hello.core;가 defualt가 되어
        // 하위 패키지 모두가 지정된다.
        //Configuration.class 파일 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
