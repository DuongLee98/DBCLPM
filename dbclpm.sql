-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 31, 2020 lúc 10:55 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbclpm`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `Id` int(10) NOT NULL,
  `StaffPersonId` int(10) NOT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`Id`, `StaffPersonId`, `Username`, `Password`) VALUES
(1, 5, 'kimxuantien', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `address`
--

CREATE TABLE `address` (
  `Id` int(10) NOT NULL,
  `Number` int(10) NOT NULL,
  `Street` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `address`
--

INSERT INTO `address` (`Id`, `Number`, `Street`) VALUES
(1, 12, 'Ton Duc Thang'),
(2, 12, 'Van Huong'),
(3, 20, 'Trung Ta'),
(4, 21, 'Huy Van'),
(5, 198, 'Van Chuong'),
(6, 24, 'Cho Van Chuong'),
(7, 90, 'Cho Van Chuong');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `Id` int(10) NOT NULL,
  `Mesure` int(11) NOT NULL,
  `Date` varchar(255) DEFAULT NULL,
  `Tax` int(10) NOT NULL,
  `PreIndex` int(10) NOT NULL,
  `CurrentIndex` int(10) NOT NULL,
  `Unit` int(11) NOT NULL,
  `Paymentstatus` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`Id`, `Mesure`, `Date`, `Tax`, `PreIndex`, `CurrentIndex`, `Unit`, `Paymentstatus`) VALUES
(1, 1, '12-10-2019', 1, 50, 100, 1, 1),
(2, 2, '12-11-2019', 3, 50, 250, 8, 1),
(3, 5, '10-11-2019', 3, 100, 500, 8, 0),
(4, 7, '11-11-2019', 3, 70, 300, 8, 0),
(5, 4, '11-11-2019', 3, 50, 400, 8, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `company`
--

CREATE TABLE `company` (
  `Id` int(10) NOT NULL,
  `AddressId` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Phone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `company`
--

INSERT INTO `company` (`Id`, `AddressId`, `Name`, `Phone`) VALUES
(1, 6, 'Cong ty dien luc Ha Noi', 987654);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `Joindate` varchar(255) DEFAULT NULL,
  `PaymentId` int(10) NOT NULL,
  `PersonId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`Joindate`, `PaymentId`, `PersonId`) VALUES
('12-12-2019', 1, 1),
('12-11-2019', 2, 2),
('12-10-2019', 3, 3),
('12-09-2019', 4, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `fullname`
--

CREATE TABLE `fullname` (
  `Id` int(10) NOT NULL,
  `Lastname` varchar(255) DEFAULT NULL,
  `Middlename` varchar(255) DEFAULT NULL,
  `Firstname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `fullname`
--

INSERT INTO `fullname` (`Id`, `Lastname`, `Middlename`, `Firstname`) VALUES
(1, 'Bui', 'Thanh', 'Tung'),
(2, 'Le', 'Duy', 'Hung Khanh'),
(3, 'Le', 'Binh', 'Duong'),
(4, 'Vuong', 'Vu', 'Bac Son'),
(5, 'Kim', 'Xuan', 'Tien');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mesure`
--

CREATE TABLE `mesure` (
  `Id` int(10) NOT NULL,
  `StationId` int(10) NOT NULL,
  `Date` varchar(255) DEFAULT NULL,
  `PreIndex` int(10) NOT NULL,
  `CurrentIndex` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `mesure`
--

INSERT INTO `mesure` (`Id`, `StationId`, `Date`, `PreIndex`, `CurrentIndex`) VALUES
(1, 1, '12-10-2019', 50, 150),
(2, 1, '12-11-2019', 50, 250),
(3, 1, '12-08-2019', 100, 300),
(4, 1, '11-11-2019', 50, 400),
(5, 1, '10-11-2019', 100, 500),
(6, 1, '12-01-2019', 150, 500),
(7, 1, '11-11-2019', 70, 300);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `person`
--

CREATE TABLE `person` (
  `Id` int(10) NOT NULL,
  `FullnameId` int(10) NOT NULL,
  `AddressId` int(10) NOT NULL,
  `Phone` int(10) NOT NULL,
  `Dob` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `person`
--

INSERT INTO `person` (`Id`, `FullnameId`, `AddressId`, `Phone`, `Dob`) VALUES
(1, 1, 1, 123456, '12-12-1990'),
(2, 2, 2, 123556, '10-12-1991'),
(3, 3, 3, 122356, '11-09-1989'),
(4, 4, 4, 123566, '10-12-1995'),
(5, 5, 5, 199999, '09-09-1998');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `regist`
--

CREATE TABLE `regist` (
  `Id` int(10) NOT NULL,
  `MesureId` int(10) NOT NULL,
  `CustomerPersonId` int(10) NOT NULL,
  `Time` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `regist`
--

INSERT INTO `regist` (`Id`, `MesureId`, `CustomerPersonId`, `Time`) VALUES
(1, 1, 1, '12-12-2019'),
(2, 2, 2, '12-11-2019'),
(3, 3, 3, '12-10-2019'),
(4, 4, 4, '12-09-2019');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `Position` varchar(255) DEFAULT NULL,
  `Salary` int(10) NOT NULL,
  `PersonId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `staff`
--

INSERT INTO `staff` (`Position`, `Salary`, `PersonId`) VALUES
('Nhan vien', 9000000, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `station`
--

CREATE TABLE `station` (
  `Id` int(10) NOT NULL,
  `CompanyId` int(10) NOT NULL,
  `AddressId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `station`
--

INSERT INTO `station` (`Id`, `CompanyId`, `AddressId`) VALUES
(1, 1, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tax`
--

CREATE TABLE `tax` (
  `id` int(11) NOT NULL,
  `value` float NOT NULL,
  `des` text NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `tax`
--

INSERT INTO `tax` (`id`, `value`, `des`, `status`) VALUES
(1, 10, 'VAT 31/05/20', 0),
(2, 15, 'VAT 31/05/20', 0),
(3, 14, 'VAT 31/05/20', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `unit`
--

CREATE TABLE `unit` (
  `id` int(11) NOT NULL,
  `level` text NOT NULL,
  `price` text NOT NULL,
  `des` text NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `unit`
--

INSERT INTO `unit` (`id`, `level`, `price`, `des`, `status`) VALUES
(1, '50|50|100|100|100|-', '1678|1734|2014|2536|2834|2927', 'Bang gia dien up 31/05/20', 0),
(8, '50|50|100|100|105|-', '1678|1734|2014|2536|2834|2927', 'Bang gia dien up 31/05/20', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKAccount342039` (`StaffPersonId`);

--
-- Chỉ mục cho bảng `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKBill237931` (`Mesure`),
  ADD KEY `Tax` (`Tax`),
  ADD KEY `Unit` (`Unit`);

--
-- Chỉ mục cho bảng `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKCompany646510` (`AddressId`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`PersonId`);

--
-- Chỉ mục cho bảng `fullname`
--
ALTER TABLE `fullname`
  ADD PRIMARY KEY (`Id`);

--
-- Chỉ mục cho bảng `mesure`
--
ALTER TABLE `mesure`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKMesure364914` (`StationId`);

--
-- Chỉ mục cho bảng `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKPerson626850` (`AddressId`),
  ADD KEY `FKPerson993029` (`FullnameId`);

--
-- Chỉ mục cho bảng `regist`
--
ALTER TABLE `regist`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKRegist617257` (`CustomerPersonId`),
  ADD KEY `FKRegist237277` (`MesureId`);

--
-- Chỉ mục cho bảng `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`PersonId`);

--
-- Chỉ mục cho bảng `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKStation976249` (`AddressId`),
  ADD KEY `FKStation161765` (`CompanyId`);

--
-- Chỉ mục cho bảng `tax`
--
ALTER TABLE `tax`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `unit`
--
ALTER TABLE `unit`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `address`
--
ALTER TABLE `address`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `company`
--
ALTER TABLE `company`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `fullname`
--
ALTER TABLE `fullname`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `mesure`
--
ALTER TABLE `mesure`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `person`
--
ALTER TABLE `person`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `regist`
--
ALTER TABLE `regist`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `station`
--
ALTER TABLE `station`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tax`
--
ALTER TABLE `tax`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `unit`
--
ALTER TABLE `unit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FKAccount342039` FOREIGN KEY (`StaffPersonId`) REFERENCES `staff` (`PersonId`);

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FKBill237931` FOREIGN KEY (`Mesure`) REFERENCES `mesure` (`Id`),
  ADD CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`Tax`) REFERENCES `tax` (`id`),
  ADD CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`Unit`) REFERENCES `unit` (`id`);

--
-- Các ràng buộc cho bảng `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FKCompany646510` FOREIGN KEY (`AddressId`) REFERENCES `address` (`Id`);

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKCustomer220795` FOREIGN KEY (`PersonId`) REFERENCES `person` (`Id`);

--
-- Các ràng buộc cho bảng `mesure`
--
ALTER TABLE `mesure`
  ADD CONSTRAINT `FKMesure364914` FOREIGN KEY (`StationId`) REFERENCES `station` (`Id`);

--
-- Các ràng buộc cho bảng `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FKPerson626850` FOREIGN KEY (`AddressId`) REFERENCES `address` (`Id`),
  ADD CONSTRAINT `FKPerson993029` FOREIGN KEY (`FullnameId`) REFERENCES `fullname` (`Id`);

--
-- Các ràng buộc cho bảng `regist`
--
ALTER TABLE `regist`
  ADD CONSTRAINT `FKRegist237277` FOREIGN KEY (`MesureId`) REFERENCES `mesure` (`Id`),
  ADD CONSTRAINT `FKRegist617257` FOREIGN KEY (`CustomerPersonId`) REFERENCES `customer` (`PersonId`);

--
-- Các ràng buộc cho bảng `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FKStaff836231` FOREIGN KEY (`PersonId`) REFERENCES `person` (`Id`);

--
-- Các ràng buộc cho bảng `station`
--
ALTER TABLE `station`
  ADD CONSTRAINT `FKStation161765` FOREIGN KEY (`CompanyId`) REFERENCES `company` (`Id`),
  ADD CONSTRAINT `FKStation976249` FOREIGN KEY (`AddressId`) REFERENCES `address` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
