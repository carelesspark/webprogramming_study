delete from memberJoin;
delete from board;
delete from member;

commit;

insert into member
values('kiae1234', '1234', '������', sysdate);

commit;

select * from member;

insert into board
   values (seq_board_num.nextval, '������ ���Դϴ�', '���ǿ���', 'kiae1234', sysdate, 0);
insert into board
   values (seq_board_num.nextval, '������ �����Դϴ�', '�������', 'kiae1234', sysdate, 0);
insert into board
   values (seq_board_num.nextval, '������ �����Դϴ�', '������ȭ', 'kiae1234', sysdate, 0);
insert into board
   values (seq_board_num.nextval, '������ �ܿ��Դϴ�', '�ܿ￬��', 'kiae1234', sysdate, 0);   

select * from board;