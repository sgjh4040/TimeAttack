insert into member( address1 ,  address2, del_yn, member_birth, member_email, member_nickname, member_password, member_ph, member_reg_date, sns_yn, zip_code  ) values ('부산', '해운대', 'N','19880729','sgjh4040@naver.com','사공닉네임', '1111','01055045331','20191020','Y','612022');
set @last_insert_id = (select last_insert_id());
insert into role(member_id, name) values (@last_insert_id, 'ADMIN');

insert into member( address1 ,  address2, del_yn, member_birth, member_email, member_nickname, member_password, member_ph, member_reg_date, sns_yn, zip_code  ) values ('부산', '해운대', 'N','19880729','sgjh1@naver.com','사공닉네임', '1111','01055045331','20191020','Y','612022');
set @last_insert_id = (select last_insert_id());
insert into role(member_id, name) values (@last_insert_id, 'USER');
insert into member( address1 ,  address2, del_yn, member_birth, member_email, member_nickname, member_password, member_ph, member_reg_date, sns_yn, zip_code  ) values ('부산', '해운대', 'N','19880729','sgjh2@naver.com','사공닉네임', '1111','01055045331','20191020','Y','612022');
set @last_insert_id = (select last_insert_id());
insert into role(member_id, name) values (@last_insert_id, 'USER');
insert into member( address1 ,  address2, del_yn, member_birth, member_email, member_nickname, member_password, member_ph, member_reg_date, sns_yn, zip_code  ) values ('부산', '해운대', 'N','19880729','sgjh3@naver.com','사공닉네임', '1111','01055045331','20191020','Y','612022');
set @last_insert_id = (select last_insert_id());
insert into role(member_id, name) values (@last_insert_id, 'USER');

insert into goods ( goods_contents_order , goods_credate , goods_delivery_date , goods_delivery_price , goods_filename , goods_intro , goods_isbn , goods_point , goods_price , goods_published_date , goods_publisher , goods_sales_price , goods_sort , goods_status , goods_title , goods_total_page , goods_writer ) values ('목차','20191010','20191212','1000','file','책 소개','asd1111','10','5000','20160302','출판사','4000','소설','bestseller','나는 누구인가1','400','사공정훈');
insert into goods ( goods_contents_order , goods_credate , goods_delivery_date , goods_delivery_price , goods_filename , goods_intro , goods_isbn , goods_point , goods_price , goods_published_date , goods_publisher , goods_sales_price , goods_sort , goods_status , goods_title , goods_total_page , goods_writer ) values ('목차','20191010','20191212','1000','file','책 소개','asd1111','10','5000','20160302','출판사','4000','소설','bestseller','나는 누구인가','400','사공정훈');
insert into goods ( goods_contents_order , goods_credate , goods_delivery_date , goods_delivery_price , goods_filename , goods_intro , goods_isbn , goods_point , goods_price , goods_published_date , goods_publisher , goods_sales_price , goods_sort , goods_status , goods_title , goods_total_page , goods_writer ) values ('목차','20191010','20191212','1000','file','책 소개','asd1111','10','5000','20160302','출판사','4000','소설','bestseller','나는 누구인가3','400','사공정훈');
