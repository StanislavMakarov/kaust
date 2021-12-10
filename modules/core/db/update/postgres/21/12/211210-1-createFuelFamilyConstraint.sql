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
);