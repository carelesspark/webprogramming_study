delete from memberJoin;
delete from board;
delete from member;

commit;

insert into member
values('kiae1234', '1234', '박종혁', sysdate);

commit;

select * from member;

insert into board
   values (seq_board_num.nextval, '지금은 봄입니다', '봄의왈츠', 'kiae1234', sysdate, 0);
insert into board
   values (seq_board_num.nextval, '지금은 여름입니다', '여름향기', 'kiae1234', sysdate, 0);
insert into board
   values (seq_board_num.nextval, '지금은 가을입니다', '가을동화', 'kiae1234', sysdate, 0);
insert into board
   values (seq_board_num.nextval, '지금은 겨울입니다', '겨울연가', 'kiae1234', sysdate, 0);   

select * from board;