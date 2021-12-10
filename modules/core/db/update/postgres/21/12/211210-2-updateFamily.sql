alter table KAUST_FAMILY rename column property_prediction_id to property_prediction_id__u29522 ;
alter table KAUST_FAMILY alter column property_prediction_id__u29522 drop not null ;
alter table KAUST_FAMILY drop constraint FK_KAUST_FAMILY_ON_PROPERTY_PREDICTION ;
drop index IDX_KAUST_FAMILY_ON_PROPERTY_PREDICTION ;
