alter table KAUST_COMPOSITION_ELEMENT add column FUEL_DESIGN_ID uuid ;
alter table KAUST_COMPOSITION_ELEMENT alter column PROPERTY_PREDICTION_ID drop not null ;
