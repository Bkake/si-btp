package com.si.btp.module.tiers.data.repository;

import com.si.btp.module.tiers.data.configuration.Config;
import com.si.btp.module.tiers.data.domain.tables.pojos.Categorie;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@Transactional("transactionManager")

public class CategorieRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategorieRepositoryTest.class);

    @Inject
    private CategorieRepository categorieRepository;


    @Test
    public void findByIdTest() {
        Optional<Categorie> categorie = categorieRepository.findById(1);

        assertThat(categorie.isPresent()).isTrue();

        LOGGER.info("findByIdTest :" + categorie);
    }
}

