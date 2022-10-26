create database sinhvien;
use sinhvien;
create table tb_sinhvien(
	MaSv varchar(50),
    TenSv varchar(50),
    Gender varchar(50),
    ClassSv varchar(50),
    Diem varchar(50)
);
INSERT INTO `sinhvien`.`tb_sinhvien`(`MaSv`,`TenSv`,`Gender`,`ClassSv`,`Diem`)VALUES("01","Tuyên","Nam","62TH5","9");
DELETE FROM `sinhvien`.`tb_sinhvien`WHERE MaSv="05";
UPDATE `sinhvien`.`tb_sinhvien`SET`MaSv` = ?,`TenSv` = ?,`Gender` = ?,`ClassSv` = ?,`Diem` = ?WHERE `MaSv` =?;

