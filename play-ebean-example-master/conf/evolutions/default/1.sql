# --- First database schema

# --- !Ups

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;


create table computer (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,

  
  constraint pk_computer primary key (id))
;
create table disk (
  id                        bigint not null,
  name						varchar(255),
  capacidad               integer,
  nucleos             integer,
  computer_id                bigint,
  constraint pk_disk primary key (id))
;
create sequence company_seq start with 1000;
create sequence disk_seq start with 1000;

create sequence computer_seq start with 1000;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);

alter table disk add constraint fk_disk_computer_1 foreign key (computer_id) references computer (id) on delete restrict on update restrict;
create index ix_disk_computer_1 on disk (computer_id);

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;


drop table if exists disk;
drop table if exists computer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;

