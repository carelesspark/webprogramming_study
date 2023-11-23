create table pagejoin(
    idx number primary key,
    userid varchar2(20) not null,
    username varchar2(20) not null,
    useremail varchar2(39) not null,
    usercomment varchar2(100),
    joindate date default sysdate
);

drop table pagejoin;
drop sequence seq_num_plus;

create sequence seq_num_plus
increment by 1
start with 1
maxvalue 101
minvalue 1
nocycle 
nocache;

select * from pagejoin;

commit;