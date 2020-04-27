package org.simplon.epec.archivageElectronique.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootConfiguration
@ComponentScan(basePackages = { "org.simplon.epec.archivageElectronique" }, lazyInit = true)
@EnableJpaRepositories
class InfrastructureApplicationTests {

    public static void main(final String[] args) {

        SpringApplication.run(InfrastructureApplicationTests.class, args);
    }

}
