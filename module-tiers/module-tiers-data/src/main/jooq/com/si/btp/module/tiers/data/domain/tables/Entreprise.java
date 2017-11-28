/**
 * This class is generated by jOOQ
 */
package com.si.btp.module.tiers.data.domain.tables;


import com.si.btp.module.tiers.data.converter.LocalDateConverter;
import com.si.btp.module.tiers.data.domain.Keys;
import com.si.btp.module.tiers.data.domain.Public;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Entreprise extends TableImpl<Record> {

    private static final long serialVersionUID = -1256166514;

    /**
     * The reference instance of <code>PUBLIC.ENTREPRISE</code>
     */
    public static final Entreprise ENTREPRISE = new Entreprise();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>PUBLIC.ENTREPRISE.ID</code>.
     */
    public final TableField<Record, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.CODE</code>.
     */
    public final TableField<Record, String> CODE = createField("CODE", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.COMMENTAIRE</code>.
     */
    public final TableField<Record, String> COMMENTAIRE = createField("COMMENTAIRE", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.STATUT</code>.
     */
    public final TableField<Record, String> STATUT = createField("STATUT", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.NOM</code>.
     */
    public final TableField<Record, String> NOM = createField("NOM", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.ENSEIGNE</code>.
     */
    public final TableField<Record, String> ENSEIGNE = createField("ENSEIGNE", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.SIREN</code>.
     */
    public final TableField<Record, String> SIREN = createField("SIREN", org.jooq.impl.SQLDataType.VARCHAR.length(11), this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.CATEGORIE_ID</code>.
     */
    public final TableField<Record, Integer> CATEGORIE_ID = createField("CATEGORIE_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.ADRESSE_ID</code>.
     */
    public final TableField<Record, Integer> ADRESSE_ID = createField("ADRESSE_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.CONTACT_ID</code>.
     */
    public final TableField<Record, Integer> CONTACT_ID = createField("CONTACT_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PUBLIC.ENTREPRISE.DATE_OF_CREATE</code>.
     */
    public final TableField<Record, LocalDate> DATE_OF_CREATE = createField("DATE_OF_CREATE", org.jooq.impl.SQLDataType.DATE.defaultValue(org.jooq.impl.DSL.field("CURRENT_DATE()", org.jooq.impl.SQLDataType.DATE)), this, "", new LocalDateConverter());

    /**
     * The column <code>PUBLIC.ENTREPRISE.DATE_OF_UPDATE</code>.
     */
    public final TableField<Record, LocalDate> DATE_OF_UPDATE = createField("DATE_OF_UPDATE", org.jooq.impl.SQLDataType.DATE, this, "", new LocalDateConverter());

    /**
     * Create a <code>PUBLIC.ENTREPRISE</code> table reference
     */
    public Entreprise() {
        this("ENTREPRISE", null);
    }

    /**
     * Create an aliased <code>PUBLIC.ENTREPRISE</code> table reference
     */
    public Entreprise(String alias) {
        this(alias, ENTREPRISE);
    }

    private Entreprise(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Entreprise(String alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.PK_ENTREPRISE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.PK_ENTREPRISE_ID, Keys.UNQ_ENTRPRISE_CODE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK_ENTREPRISE_CATEGORIE, Keys.FK_ENTREPRISE_ADRESSE, Keys.FK_ENTREPRISE_CONTACT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entreprise as(String alias) {
        return new Entreprise(alias, this);
    }

    /**
     * Rename this table
     */
    public Entreprise rename(String name) {
        return new Entreprise(name, null);
    }
}
