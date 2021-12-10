-- begin KAUST_COMPOSITION_ELEMENT
alter table KAUST_COMPOSITION_ELEMENT add constraint FK_KAUST_COMPOSITION_ELEMENT_ON_PROPERTY_PREDICTION foreign key (PROPERTY_PREDICTION_ID) references KAUST_PROPERTY_PREDICTION(ID)^
alter table KAUST_COMPOSITION_ELEMENT add constraint FK_KAUST_COMPOSITION_ELEMENT_ON_FUEL_DESIGN foreign key (FUEL_DESIGN_ID) references KAUST_FUEL_DESIGN(ID)^
create index IDX_KAUST_COMPOSITION_ELEMENT_ON_PROPERTY_PREDICTION on KAUST_COMPOSITION_ELEMENT (PROPERTY_PREDICTION_ID)^
create index IDX_KAUST_COMPOSITION_ELEMENT_ON_FUEL_DESIGN on KAUST_COMPOSITION_ELEMENT (FUEL_DESIGN_ID)^
-- end KAUST_COMPOSITION_ELEMENT

-- begin KAUST_PROPERTY_PREDICTION
alter table KAUST_PROPERTY_PREDICTION add constraint FK_KAUST_PROPERTY_PREDICTION_ON_YSI_SCALE foreign key (YSI_SCALE_ID) references KAUST_YSI_SCALES(ID)^
create index IDX_KAUST_PROPERTY_PREDICTION_ON_YSI_SCALE on KAUST_PROPERTY_PREDICTION (YSI_SCALE_ID)^
-- end KAUST_PROPERTY_PREDICTION
-- begin KAUST_COMPONENT
create unique index IDX_KAUST_COMPONENT_UK_SMILES on KAUST_COMPONENT (SMILES) where DELETE_TS is null ^
create unique index IDX_KAUST_COMPONENT_UK_NAME on KAUST_COMPONENT (NAME) where DELETE_TS is null ^
create unique index IDX_KAUST_COMPONENT_UK_INCHI on KAUST_COMPONENT (INCHI) where DELETE_TS is null ^
-- end KAUST_COMPONENT

-- begin KAUST_FUEL_FAMILY_CONSTRAINT
alter table KAUST_FUEL_FAMILY_CONSTRAINT add constraint FK_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FUEL foreign key (FUEL_ID) references KAUST_FUEL_DESIGN(ID)^
alter table KAUST_FUEL_FAMILY_CONSTRAINT add constraint FK_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FAMILY foreign key (FAMILY_ID) references KAUST_FAMILY(ID)^
create index IDX_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FUEL on KAUST_FUEL_FAMILY_CONSTRAINT (FUEL_ID)^
create index IDX_KAUST_FUEL_FAMILY_CONSTRAINT_ON_FAMILY on KAUST_FUEL_FAMILY_CONSTRAINT (FAMILY_ID)^
-- end KAUST_FUEL_FAMILY_CONSTRAINT
