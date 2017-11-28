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
public class Adresse extends TableImpl<Record> {

    private static final long serialVersionUID = 2130410460;

    /**
     * The reference instance of <code>PUBLIC.ADRESSE</code>
     */
    public static final Adresse ADRESSE = new Adresse();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>PUBLIC.ADRESSE.ID</code>.
     */
    public final TableField<Record, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.CODE_ADRESSE</code>.
     */
    public final TableField<Record, String> CODE_ADRESSE = createField("CODE_ADRESSE", org.jooq.impl.SQLDataType.VARCHAR.length(30).defaultValue(org.jooq.impl.DSL.field("'Adresse principal'", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.ADRESSE</code>.
     */
    public final TableField<Record, String> ADRESSE_ = createField("ADRESSE", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.CP</code>.
     */
    public final TableField<Record, String> CP = createField("CP", org.jooq.impl.SQLDataType.CHAR.length(5), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.VILLE</code>.
     */
    public final TableField<Record, String> VILLE = createField("VILLE", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.TELEPHONE</code>.
     */
    public final TableField<Record, String> TELEPHONE = createField("TELEPHONE", org.jooq.impl.SQLDataType.VARCHAR.length(15), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.MOBILE</code>.
     */
    public final TableField<Record, String> MOBILE = createField("MOBILE", org.jooq.impl.SQLDataType.VARCHAR.length(15), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.FAX</code>.
     */
    public final TableField<Record, String> FAX = createField("FAX", org.jooq.impl.SQLDataType.VARCHAR.length(15), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.EMAIL</code>.
     */
    public final TableField<Record, String> EMAIL = createField("EMAIL", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>PUBLIC.ADRESSE.DATE_OF_CREATE</code>.
     */
    public final TableField<Record, LocalDate> DATE_OF_CREATE = createField("DATE_OF_CREATE", org.jooq.impl.SQLDataType.DATE.defaultValue(org.jooq.impl.DSL.field("CURRENT_DATE()", org.jooq.impl.SQLDataType.DATE)), this, "", new LocalDateConverter());

    /**
     * The column <code>PUBLIC.ADRESSE.DATE_OF_UPDATE</code>.
     */
    public final TableField<Record, LocalDate> DATE_OF_UPDATE = createField("DATE_OF_UPDATE", org.jooq.impl.SQLDataType.DATE, this, "", new LocalDateConverter());

    /**
     * Create a <code>PUBLIC.ADRESSE</code> table reference
     */
    public Adresse() {
        this("ADRESSE", null);
    }

    /**
     * Create an aliased <code>PUBLIC.ADRESSE</code> table reference
     */
    public Adresse(String alias) {
        this(alias, ADRESSE);
    }

    private Adresse(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Adresse(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.PK_ADRESSE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.PK_ADRESSE_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Adresse as(String alias) {
        return new Adresse(alias, this);
    }

    /**
     * Rename this table
     */
    public Adresse rename(String name) {
        return new Adresse(name, null);
    }
}