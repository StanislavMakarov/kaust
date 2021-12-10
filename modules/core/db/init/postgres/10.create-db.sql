-- begin KAUST_COMPOSITION_ELEMENT
create table KAUST_COMPOSITION_ELEMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SMILES varchar(255) not null,
    VALUE_ decimal(19, 2),
    PROPERTY_PREDICTION_ID uuid,
    FUEL_DESIGN_ID uuid,
    --
    primary key (ID)
)^
-- end KAUST_COMPOSITION_ELEMENT
-- begin KAUST_FAMILY
create table KAUST_FAMILY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    MEMBERS text,
    --
    primary key (ID)
)^
-- end KAUST_FAMILY
-- begin KAUST_PROPERTY_PREDICTION
create table KAUST_PROPERTY_PREDICTION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    YSI_SCALE_ID uuid,
    RON decimal(19, 2),
    MON decimal(19, 2),
    YSI decimal(19, 2),
    --
    primary key (ID)
)^
-- end KAUST_PROPERTY_PREDICTION
-- begin KAUST_FUEL_DESIGN
create table KAUST_FUEL_DESIGN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TARGET_RON decimal(19, 2),
    TARGET_MON decimal(19, 2),
    TARGET_YSI decimal(19, 2),
    NUMBER_OF_COMPONENTS integer,
    --
    primary key (ID)
)^
-- end KAUST_FUEL_DESIGN
-- begin KAUST_COMPONENT
create table KAUST_COMPONENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    SMILES varchar(255) not null,
    INCHI varchar(255) not null,
    FORMULA varchar(255),
    CBS_VALUE double precision,
    G3_VALUE double precision,
    G4_VALUE double precision,
    G4X_VALUE double precision,
    DESCRIPTORS text,
    --
    primary key (ID)
)^
-- end KAUST_COMPONENT
-- begin KAUST_YSI_SCALES
create table KAUST_YSI_SCALES (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    SMILES_A varchar(255),
    YSI_A decimal(19, 2),
    SMILES_B varchar(255),
    YSI_B decimal(19, 2),
    --
    primary key (ID)
)^
-- end KAUST_YSI_SCALES

-- begin KAUST_FUEL_FAMILY_CONSTRAINT
create table KAUST_FUEL_FAMILY_CONSTRAINT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FUEL_ID uuid,
    FAMILY_ID uuid,
    VALUE_ double precision,
    --
    primary key (ID)
)^
-- end KAUST_FUEL_FAMILY_CONSTRAINT
