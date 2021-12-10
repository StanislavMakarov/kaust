alter table KAUST_FUEL_FAMILY_CONSTRAINT add constraint FK_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FUEL foreign key (FUEL_ID) references KAUST_FUEL_DESIGN(ID);
alter table KAUST_FUEL_FAMILY_CONSTRAINT add constraint FK_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FAMILY foreign key (FAMILY_ID) references KAUST_FAMILY(ID);
create index IDX_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FUEL on KAUST_FUEL_FAMILY_CONSTRAINT (FUEL_ID);
create index IDX_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FAMILY on KAUST_FUEL_FAMILY_CONSTRAINT (FAMILY_ID);