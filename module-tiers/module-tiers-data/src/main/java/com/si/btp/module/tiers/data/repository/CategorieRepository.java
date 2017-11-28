package com.si.btp.module.tiers.data.repository;

import com.si.btp.module.tiers.data.domain.tables.pojos.Categorie;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Optional;

import static com.si.btp.module.tiers.data.domain.tables.Categorie.CATEGORIE;

@Repository
public class CategorieRepository {
    @Inject
    private DSLContext dsl;


    public Optional<Categorie> findById(Integer idCategory) {
        return dsl.selectFrom(CATEGORIE)
                .where(CATEGORIE.ID.eq(idCategory))
                .fetchOptionalInto(Categorie.class);
    }
}
