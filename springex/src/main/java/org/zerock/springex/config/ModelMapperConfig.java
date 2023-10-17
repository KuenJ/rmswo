package org.zerock.springex.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean

    public ModelMapper getMapper(){
        ModelMapper modelMapper =new ModelMapper();
            modelMapper.getConfiguration()
                    .setFieldMatchingEnabled(true)
                    .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                    .setMatchingStrategy(MatchingStrategies.STRICT);

            return modelMapper;
    }
}
/**
 * @Configuration 어노테이션: 이 클래스는 Spring 구성 클래스임을 나타냅니다. Spring 컨테이너가 이 클래스를 로드하여 Bean을 정의하고 구성합니다.
 *
 * @Bean 어노테이션: 이 어노테이션이 메서드에 사용되었으므로 해당 메서드는 Spring 컨테이너에 Bean을 정의하고 반환합니다.
 *
 * public ModelMapper getMapper(): 이 메서드는 ModelMapper Bean을 생성하고 구성합니다. 이 메서드는 getMapper() 메서드의 이름으로 Bean의 이름이 정의됩니다.
 *
 * ModelMapper 객체 생성: ModelMapper modelMapper = new ModelMapper();를 사용하여 ModelMapper 객체를 생성합니다.
 *
 * ModelMapper 구성: 다음 설정을 ModelMapper에 적용합니다.
 *
 * setFieldMatchingEnabled(true): 이 설정은 필드 이름과 일치하는 경우 자동으로 매핑을 수행하도록 활성화합니다.
 * setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE): 이 설정은 ModelMapper가 객체의 private 필드에 액세스할 수 있도록 설정합니다.
 * setMatchingStrategy(MatchingStrategies.STRICT): 매핑 전략을 엄격한(strict) 모드로 설정합니다.
 * 구성이 적용된 ModelMapper 객체를 반환합니다.*/