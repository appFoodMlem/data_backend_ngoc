-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2021 at 05:11 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bán hàng`
--

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_hd`
--

CREATE TABLE `chi_tiet_hd` (
  `ma_chitiet_hd` int(11) NOT NULL,
  `ma_hd` int(11) NOT NULL,
  `ma_hang` int(11) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `tong_tien` float(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chi_tiet_hd`
--

INSERT INTO `chi_tiet_hd` (`ma_chitiet_hd`, `ma_hd`, `ma_hang`, `so_luong`, `tong_tien`) VALUES
(1, 1, 2, 1, 3.500),
(2, 1, 1, 1, 12.000),
(3, 2, 2, 2, 7.000);

-- --------------------------------------------------------

--
-- Table structure for table `chi_tiet_nhap`
--

CREATE TABLE `chi_tiet_nhap` (
  `ma_chi_tiet_nhap` int(11) NOT NULL,
  `ma_nhap` int(11) NOT NULL,
  `ma_hang` int(11) NOT NULL,
  `so_luong_nhap` int(11) NOT NULL,
  `tong_tien_nhap` float(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chi_tiet_nhap`
--

INSERT INTO `chi_tiet_nhap` (`ma_chi_tiet_nhap`, `ma_nhap`, `ma_hang`, `so_luong_nhap`, `tong_tien_nhap`) VALUES
(1, 2, 2, 125, 250.000),
(2, 2, 4, 125, 250.000),
(3, 1, 1, 30, 300.000);

-- --------------------------------------------------------

--
-- Table structure for table `hang_hoa`
--

CREATE TABLE `hang_hoa` (
  `ma_hang` int(11) NOT NULL,
  `ten_hang` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `gia_nhap` float(10,3) NOT NULL,
  `gia_ban` float(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hang_hoa`
--

INSERT INTO `hang_hoa` (`ma_hang`, `ten_hang`, `gia_nhap`, `gia_ban`) VALUES
(1, 'sua Milo 100ml', 10.000, 12.000),
(2, 'mi tom Hao Hao chua cay 500g', 2.000, 3.500),
(3, 'sua Milo 50ml', 5.000, 7.000),
(4, 'mi tom Hao Hao k cay 500g', 2.000, 3.500);

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `ma_hd` int(11) NOT NULL,
  `ma_nv` int(11) NOT NULL,
  `ma_khach` int(11) NOT NULL,
  `ngay_tao` datetime NOT NULL,
  `thanh_toan` float(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoa_don`
--

INSERT INTO `hoa_don` (`ma_hd`, `ma_nv`, `ma_khach`, `ngay_tao`, `thanh_toan`) VALUES
(1, 3, 2, '2021-11-19 16:45:53', 15.500),
(2, 2, 1, '2021-11-19 16:45:53', 7.000);

-- --------------------------------------------------------

--
-- Table structure for table `khach_hang`
--

CREATE TABLE `khach_hang` (
  `ma_khach` int(11) NOT NULL,
  `ten_khach` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_khach` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khach_hang`
--

INSERT INTO `khach_hang` (`ma_khach`, `ten_khach`, `sdt_khach`) VALUES
(1, 'anh', '963852741'),
(2, 'Lee Min Ho', '9517534862');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `ma_nv` int(11) NOT NULL,
  `ten_nv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `ngay_sinh` date NOT NULL,
  `gioi_tinh` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_nv` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `phan_quyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`ma_nv`, `ten_nv`, `ngay_sinh`, `gioi_tinh`, `dia_chi`, `sdt_nv`, `username`, `password`, `phan_quyen`) VALUES
(1, 'phượng', '2000-06-10', 'nữ', 'thanh hóa', '0123456789', 'phuong123', 'phuong123', 1),
(2, 'ngọc', '2000-09-10', 'nữ', 'nam dinh', '0378116778', 'ngoc123', 'ngoc123', 0),
(3, 'dung', '2000-01-10', 'nam', 'quang ninh', '7893214560', 'dung123', 'dungdeptrai', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhap_hang`
--

CREATE TABLE `nhap_hang` (
  `ma_nhap` int(11) NOT NULL,
  `ma_ncc` int(11) NOT NULL,
  `ma_nv` int(11) NOT NULL,
  `ngay_nhap` date NOT NULL,
  `thanh_tien` float(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhap_hang`
--

INSERT INTO `nhap_hang` (`ma_nhap`, `ma_ncc`, `ma_nv`, `ngay_nhap`, `thanh_tien`) VALUES
(1, 2, 1, '2021-11-19', 500.000),
(2, 1, 1, '2021-11-19', 300.000);

-- --------------------------------------------------------

--
-- Table structure for table `nha_cc`
--

CREATE TABLE `nha_cc` (
  `ma_ncc` int(11) NOT NULL,
  `ten_ncc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `sdt_ncc` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nha_cc`
--

INSERT INTO `nha_cc` (`ma_ncc`, `ten_ncc`, `sdt_ncc`) VALUES
(1, 'Cong ty sua Milo', '7410852963'),
(2, 'Cong ty my tom Hao Hao', '7894561230');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chi_tiet_hd`
--
ALTER TABLE `chi_tiet_hd`
  ADD PRIMARY KEY (`ma_chitiet_hd`),
  ADD KEY `ma_hd` (`ma_hd`),
  ADD KEY `ma_hang` (`ma_hang`);

--
-- Indexes for table `chi_tiet_nhap`
--
ALTER TABLE `chi_tiet_nhap`
  ADD PRIMARY KEY (`ma_chi_tiet_nhap`),
  ADD KEY `ma_nhap` (`ma_nhap`),
  ADD KEY `ma_hang` (`ma_hang`);

--
-- Indexes for table `hang_hoa`
--
ALTER TABLE `hang_hoa`
  ADD PRIMARY KEY (`ma_hang`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`ma_hd`),
  ADD KEY `ma_nv` (`ma_nv`),
  ADD KEY `ma_khach` (`ma_khach`);

--
-- Indexes for table `khach_hang`
--
ALTER TABLE `khach_hang`
  ADD PRIMARY KEY (`ma_khach`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`ma_nv`);

--
-- Indexes for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  ADD PRIMARY KEY (`ma_nhap`),
  ADD KEY `ma_ncc` (`ma_ncc`),
  ADD KEY `ma_nv` (`ma_nv`);

--
-- Indexes for table `nha_cc`
--
ALTER TABLE `nha_cc`
  ADD PRIMARY KEY (`ma_ncc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chi_tiet_hd`
--
ALTER TABLE `chi_tiet_hd`
  MODIFY `ma_chitiet_hd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `chi_tiet_nhap`
--
ALTER TABLE `chi_tiet_nhap`
  MODIFY `ma_chi_tiet_nhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hang_hoa`
--
ALTER TABLE `hang_hoa`
  MODIFY `ma_hang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `ma_hd` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `khach_hang`
--
ALTER TABLE `khach_hang`
  MODIFY `ma_khach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `ma_nv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  MODIFY `ma_nhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nha_cc`
--
ALTER TABLE `nha_cc`
  MODIFY `ma_ncc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chi_tiet_hd`
--
ALTER TABLE `chi_tiet_hd`
  ADD CONSTRAINT `chi_tiet_hd_ibfk_1` FOREIGN KEY (`ma_hang`) REFERENCES `hang_hoa` (`ma_hang`),
  ADD CONSTRAINT `chi_tiet_hd_ibfk_2` FOREIGN KEY (`ma_hd`) REFERENCES `hoa_don` (`ma_hd`);

--
-- Constraints for table `chi_tiet_nhap`
--
ALTER TABLE `chi_tiet_nhap`
  ADD CONSTRAINT `chi_tiet_nhap_ibfk_1` FOREIGN KEY (`ma_hang`) REFERENCES `hang_hoa` (`ma_hang`),
  ADD CONSTRAINT `chi_tiet_nhap_ibfk_2` FOREIGN KEY (`ma_nhap`) REFERENCES `nhap_hang` (`ma_nhap`);

--
-- Constraints for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `hoa_don_ibfk_1` FOREIGN KEY (`ma_nv`) REFERENCES `nhanvien` (`ma_nv`),
  ADD CONSTRAINT `hoa_don_ibfk_2` FOREIGN KEY (`ma_khach`) REFERENCES `khach_hang` (`ma_khach`);

--
-- Constraints for table `nhap_hang`
--
ALTER TABLE `nhap_hang`
  ADD CONSTRAINT `nhap_hang_ibfk_1` FOREIGN KEY (`ma_ncc`) REFERENCES `nha_cc` (`ma_ncc`),
  ADD CONSTRAINT `nhap_hang_ibfk_2` FOREIGN KEY (`ma_nv`) REFERENCES `nhanvien` (`ma_nv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
