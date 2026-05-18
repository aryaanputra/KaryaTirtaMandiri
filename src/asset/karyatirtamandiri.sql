-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2026 at 06:18 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `karyatirtamandiri`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `id_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `kategori` enum('Air Konsumsi','Air Nonkonsumsi') NOT NULL,
  `deskripsi` text NOT NULL,
  `harga_beli` int(10) NOT NULL,
  `harga_jual` int(10) NOT NULL,
  `satuan` varchar(10) NOT NULL,
  `nama_supplier` varchar(50) NOT NULL,
  `alamat_supplier` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`id_barang`, `nama_barang`, `kategori`, `deskripsi`, `harga_beli`, `harga_jual`, `satuan`, `nama_supplier`, `alamat_supplier`) VALUES
('BRG001', 'Air Bersih', 'Air Konsumsi', 'Air bersih layak minum untuk rumah tangga', 50000, 80000, 'liter', 'Tirta Sejahtera', 'Bandung'),
('BRG002', 'Air Bersih', 'Air Nonkonsumsi', 'Air bersih untuk mandi dan cuci', 200000, 300000, 'liter', 'Sumber Air Jaya', 'Bekasi'),
('BRG003', 'Air Bersih', 'Air Konsumsi', 'Air minum isi ulang kualitas depot', 60000, 90000, 'liter', 'Fresh Water Indo', 'Depok'),
('BRG004', 'Air Bersih', 'Air Nonkonsumsi', 'Air sumur untuk kebutuhan umum', 100000, 150000, 'liter', 'Sumur Makmur', 'Bogor'),
('BRG005', 'Air Bersih', 'Air Konsumsi', 'Ini bisa untuk siram tanaman', 7000, 10000, 'Liter', 'Air Bersih Aryaan', 'Jl. Unindra');

-- --------------------------------------------------------

--
-- Table structure for table `tb_karyawan`
--

CREATE TABLE `tb_karyawan` (
  `id_karyawan` varchar(10) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `tempat_lahir` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `alamat` text NOT NULL,
  `nomor_telepon` varchar(15) NOT NULL,
  `status_bekerja` enum('Tetap','Kontrak','Magang') NOT NULL,
  `status` enum('Aktif','Nonaktif') NOT NULL,
  `tanggal_bergabung` date NOT NULL,
  `nomor_rekening` varchar(12) NOT NULL,
  `bank` varchar(20) NOT NULL,
  `nama_kontak_darurat` varchar(50) NOT NULL,
  `nomor_telepon_darurat` varchar(12) NOT NULL,
  `hubungan` enum('Pasangan','Orangtua','Adik','Kakak','Teman') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_karyawan`
--

INSERT INTO `tb_karyawan` (`id_karyawan`, `nama_karyawan`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `alamat`, `nomor_telepon`, `status_bekerja`, `status`, `tanggal_bergabung`, `nomor_rekening`, `bank`, `nama_kontak_darurat`, `nomor_telepon_darurat`, `hubungan`) VALUES
('KRY001', 'Andi Saputra', 'Bandung', '1998-05-12', 'Laki-laki', 'Jl. Soekarno Hatta No.10', '081234567890', 'Tetap', 'Aktif', '2022-01-10', '123456789012', 'BCA', 'Siti Aminah', '081298765432', 'Orangtua'),
('KRY002', 'Rina Wijaya', 'Jakarta', '2000-08-22', 'Perempuan', 'Jl. Melati No.5', '082345678901', 'Kontrak', 'Aktif', '2023-03-15', '234567890123', 'BRI', 'Budi Wijaya', '082198765432', 'Orangtua'),
('KRY003', 'Dedi Kurniawan', 'Bogor', '1995-11-30', 'Laki-laki', 'Jl. Raya Bogor Km.7', '083456789012', 'Magang', 'Nonaktif', '2024-06-01', '345678901234', 'Mandiri', 'Ani Kurnia', '083298765432', 'Pasangan');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pengemudi`
--

CREATE TABLE `tb_pengemudi` (
  `id_pengemudi` varchar(10) NOT NULL,
  `nama_pengemudi` varchar(50) NOT NULL,
  `tempat_lahir` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `alamat_pengemudi` text NOT NULL,
  `nomor_telepon` varchar(15) NOT NULL,
  `nomor_sim` varchar(15) NOT NULL,
  `masa_berlaku` date NOT NULL,
  `status_kerja` enum('Tetap','Kontrak') NOT NULL,
  `tanggal_bergabung` date NOT NULL,
  `status_aktif` enum('Aktif','Nonaktif') NOT NULL,
  `nomor_rekening` varchar(12) NOT NULL,
  `bank` varchar(20) NOT NULL,
  `nama_kontak_darurat` varchar(50) NOT NULL,
  `nomor_kontak_darurat` varchar(12) NOT NULL,
  `hubungan` enum('Istri','Ibu','Adik','Kakak','Teman') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_pengemudi`
--

INSERT INTO `tb_pengemudi` (`id_pengemudi`, `nama_pengemudi`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, `alamat_pengemudi`, `nomor_telepon`, `nomor_sim`, `masa_berlaku`, `status_kerja`, `tanggal_bergabung`, `status_aktif`, `nomor_rekening`, `bank`, `nama_kontak_darurat`, `nomor_kontak_darurat`, `hubungan`) VALUES
('DRI01', 'Andi Saputra', 'Bandung', '1995-03-12', 'Laki-laki', 'Jl. Melati No.1', '081234567801', 'SIM001', '2027-03-12', 'Tetap', '2023-01-10', 'Aktif', '123456789012', 'BCA', 'Siti', '081298765401', 'Istri'),
('DRI02', 'Budi Santoso', 'Jakarta', '1990-07-21', 'Laki-laki', 'Jl. Mawar No.2', '081234567802', 'SIM002', '2026-07-21', 'Kontrak', '2022-05-15', 'Aktif', '123456789013', 'BRI', 'Ani', '081298765402', 'Ibu'),
('DRI03', 'Cahyo Nugroho', 'Semarang', '1998-11-05', 'Laki-laki', 'Jl. Kenanga No.3', '081234567803', 'SIM003', '2028-11-05', 'Tetap', '2024-02-01', 'Aktif', '123456789014', 'Mandiri', 'Rina', '081298765403', 'Adik'),
('DRI04', 'Dedi Kurniawan', 'Surabaya', '1992-09-14', 'Laki-laki', 'Jl. Anggrek No.4', '081234567804', 'SIM004', '2025-09-14', 'Kontrak', '2021-08-20', 'Nonaktif', '123456789015', 'BNI', 'Lina', '081298765404', 'Istri'),
('DRI05', 'Eko Prasetyo', 'Yogyakarta', '1996-01-30', 'Laki-laki', 'Jl. Dahlia No.5', '081234567805', 'SIM005', '2027-01-30', 'Tetap', '2023-06-12', 'Aktif', '123456789016', 'BCA', 'Sari', '081298765405', 'Ibu'),
('DRI06', 'Fajar Hidayat', 'Malang', '1994-04-18', 'Laki-laki', 'Jl. Flamboyan No.6', '081234567806', 'SIM006', '2026-04-18', 'Kontrak', '2022-11-03', 'Aktif', '123456789017', 'BRI', 'Dewi', '081298765406', 'Kakak'),
('DRI07', 'Gilang Ramadhan', 'Depok', '1999-12-25', 'Laki-laki', 'Jl. Teratai No.7', '081234567807', 'SIM007', '2028-12-25', 'Tetap', '2024-03-22', 'Aktif', '123456789018', 'Mandiri', 'Nina', '081298765407', 'Teman'),
('DRI08', 'Hendra Wijaya', 'Bogor', '1991-06-09', 'Laki-laki', 'Jl. Sakura No.8', '081234567808', 'SIM008', '2025-06-09', 'Kontrak', '2020-09-10', 'Nonaktif', '123456789019', 'BNI', 'Maya', '081298765408', 'Istri'),
('DRI09', 'Irwan Setiawan', 'Bekasi', '1993-08-17', 'Laki-laki', 'Jl. Cemara No.9', '081234567809', 'SIM009', '2027-08-17', 'Tetap', '2023-04-05', 'Aktif', '123456789020', 'BCA', 'Tina', '081298765409', 'Adik'),
('DRI10', 'Joko Susilo', 'Tangerang', '1989-02-11', 'Laki-laki', 'Jl. Pinus No.10', '081234567810', 'SIM010', '2026-02-11', 'Kontrak', '2021-12-01', 'Aktif', '123456789021', 'BRI', 'Rudi', '081298765410', 'Teman');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` varchar(10) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` enum('owner','admin','kasir') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `nama_user`, `username`, `password`, `role`) VALUES
('USN001', 'Aryaan Putra Risqi', 'owner', 'owner', 'owner'),
('USN002', 'Aryaan Putra Risqi', 'admin', 'admin', 'admin'),
(' ', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `tb_karyawan`
--
ALTER TABLE `tb_karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `tb_pengemudi`
--
ALTER TABLE `tb_pengemudi`
  ADD PRIMARY KEY (`id_pengemudi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
