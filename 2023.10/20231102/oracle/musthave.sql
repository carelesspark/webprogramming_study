create table test(
    id number 
);

create table member(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(30) not null,
    regidate date default sysdate not null,
    primary key(id)
);

create table board (
    num number primary key,
    title varchar2(200) not null,
    content varchar2(2000) not null,
    id varchar2(10) not null,
    postdate date default sysdate not null,
    visitcount number(6)
);

alter table board
add constraint board_id_fk foreign key(id) REFERENCES member(id);

create SEQUENCE seq_board_num
increment by 1
start with 1;

insert into member(id, pass, name)
values ('musthave', '1234', '머스트해브');

insert into board(num, title, content, id, postdate, visitcount)
values (seq_board_num.nextval, '제목1', '내용1', 'musthave', sysdate, 0);

commit;

select * from member;
select * from board;