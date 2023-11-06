create table memberJoin(
    join_mno number(4) constraint memjoin_no_pk primary key,
    join_id VARCHAR2(20),
    join_pw VARCHAR2(20),
    join_adr1 VARCHAR2(50),
    join_adr2 VARCHAR2(50),
    join_gender VARCHAR2(2),
    join_hobby VARCHAR2(30),
    join_phon1 VARCHAR2(5),
    join_phon2 VARCHAR2(5),
    join_phon3 VARCHAR2(5),
    join_job VARCHAR2(10),
    join_introduce VARCHAR2(50),
    join_regdate date default sysdate
);

create SEQUENCE mem_no_seq
start with 1
INCREMENT by 1;

insert into memberJoin
values(mem_no_seq.nextval, 'test1', '1111', '����', '���� �ް����͵�', 'm', '�, ����', '010', '1111', '2222', '�л�', '�ڱ�Ұ� �ȳ��ϼ���', '2023/11/06');

select * from memberJoin;
delete from memberJoin where join_phon1 = '010';
