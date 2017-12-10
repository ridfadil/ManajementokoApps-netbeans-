-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30 Mei 2017 pada 15.28
-- Versi Server: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajementoko`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(10) NOT NULL,
  `jenis_barang` varchar(15) NOT NULL,
  `merk_barang` varchar(15) NOT NULL,
  `quantity_barang` int(11) NOT NULL,
  `harga_barang` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `jenis_barang`, `merk_barang`, `quantity_barang`, `harga_barang`) VALUES
('B2', 'DVD', 'SHARP p20', 10, '255000'),
('B3', 'DVD', 'AKARI 200', 3, '200000'),
('C1', 'TV', 'SONYZ1000', 9, '4500000'),
('C2', 'TV', 'SHARP G100', 12, '2500000'),
('C3', 'TV', 'SAMSUNG LED TV', 10, '3200000'),
('C4', 'TV', 'CHANGHONG R5', 11, '670000'),
('D1', 'PLAYSTASION', 'SONY 3', 12, '1300000'),
('E1', 'KIPAS', 'SEKKAI HFN-1050', 7, '270000'),
('E2', 'KIPAS', 'SINYO', 11, '125000'),
('E3', 'KIPAS', 'MASPION', 4, '123000'),
('f1', 'HP', 'SAMSUNG J1', 2, '1350000'),
('F10', 'HP', 'LENOVO A6000', 4, '1700000'),
('F19', 'HP', 'SAMSUNG J2', 3, '1950000'),
('F2', 'HP', 'SAMSUNG J3', 4, '2000000'),
('F3', 'HP', 'ADVAN Q5', 3, '1500000'),
('F4', 'HP', 'XIAOMI MI4', 2, '1500000'),
('F5', 'HP', 'SAMSUNG A5', 3, '4000000'),
('F7', 'HP', 'SONY Z2', 13, '2600000'),
('F9', 'HP', 'XIAOMI MI 5', 10, '5000000'),
('G1', 'TABLET', 'AXIOO P20', 0, '1300000'),
('G3', 'TABLET', 'LENOVO A1010', 9, '950000'),
('H3', 'HP', 'SAMSUNG ACE 4', 14, '1560000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `NIK` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `alamat` varchar(225) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `jabatan` varchar(15) NOT NULL,
  `gaji` int(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`NIK`, `nama`, `alamat`, `jk`, `jabatan`, `gaji`) VALUES
('113127', 'farhan', 'kuningan', 'laki laki', 'staff', NULL),
('113128', 'fahmi', 'kuningan', 'laki laki', 'sales', NULL),
('113129', 'ramdhan', 'cirebon', 'laki laki', 'kasir', NULL),
('113130', 'nina', 'indramayu', 'perempuan', 'kasir', 3650000),
('113131', 'maya', 'majalengka', 'perempuan', 'staff', NULL),
('113132', 'novia', 'kuningan', 'perempuan', 'sales', NULL),
('113133', 'yuli', 'kuningan', 'perempuan', 'supervisor', NULL),
('113134', 'anggi', 'kuningan', 'perempuan', 'staff', 4590000),
('113135', 'eva', 'kuningan', 'perempuan', 'staff', 4430000),
('113136', 'nadhia', 'kuningan', 'perempuan', 'staff', 4430000),
('113137', 'linda', 'kuningan', 'perempuan', 'sales', NULL),
('113138', 'ricky', 'indramayu', 'laki laki', 'sales', 3650000),
('113139', 'fauzi', 'lembang', 'laki laki', 'sales', 3650000),
('113140', 'adam', 'sukabumi', 'laki laki', 'sales', NULL),
('113171', 'farid padilah', 'kuningan', 'laki laki', 'manager', NULL),
('113177', 'sandi', 'kuningan', 'laki laki', 'direktur', NULL),
('113179', 'luna', 'kuningan', 'laki laki', 'sales', NULL),
('113444', 'adam d', 'indramayu', 'laki laki', 'staff', NULL),
('113456', 'ficky', 'sukabumi', 'laki laki', 'kasir', NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginadmin`
--

CREATE TABLE `loginadmin` (
  `usernameadmin` varchar(20) NOT NULL,
  `passwordadmin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `loginadmin`
--

INSERT INTO `loginadmin` (`usernameadmin`, `passwordadmin`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `loginkasir`
--

CREATE TABLE `loginkasir` (
  `usernamekasir` varchar(20) NOT NULL,
  `passwordkasir` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `loginkasir`
--

INSERT INTO `loginkasir` (`usernamekasir`, `passwordkasir`) VALUES
('kasir', 'kasir');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksikredit`
--

CREATE TABLE `transaksikredit` (
  `nomortransaksi` int(11) NOT NULL,
  `Tanggal` date NOT NULL,
  `namapelanggan` varchar(25) NOT NULL,
  `nomorktp` varchar(20) NOT NULL,
  `kodebarang` varchar(11) NOT NULL,
  `quantity` varchar(5) NOT NULL,
  `cicilan` varchar(15) NOT NULL,
  `uangmuka` varchar(15) NOT NULL,
  `total` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksikredit`
--

INSERT INTO `transaksikredit` (`nomortransaksi`, `Tanggal`, `namapelanggan`, `nomorktp`, `kodebarang`, `quantity`, `cicilan`, `uangmuka`, `total`) VALUES
(1250, '2017-05-03', 'fadil', '346583279724', 'B3', '1', '3 bulan', '30000', '66666'),
(1251, '2017-05-03', 'fadil', '346583279724', 'B3', '1', '3 bulan', '30000', '66666');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksitunai`
--

CREATE TABLE `transaksitunai` (
  `nomor_faktur` int(11) NOT NULL,
  `nama_pembeli` varchar(30) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `Kode_barang` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksitunai`
--

INSERT INTO `transaksitunai` (`nomor_faktur`, `nama_pembeli`, `tanggal_transaksi`, `Kode_barang`, `quantity`, `bayar`, `kembali`) VALUES
(13, 'fadil', '2017-05-10', 'C2', 1, 2500000, 0),
(14, 'fadil', '2017-05-03', 'C1', 1, 4550000, 50000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`NIK`),
  ADD UNIQUE KEY `NIK` (`NIK`);

--
-- Indexes for table `loginadmin`
--
ALTER TABLE `loginadmin`
  ADD PRIMARY KEY (`usernameadmin`);

--
-- Indexes for table `loginkasir`
--
ALTER TABLE `loginkasir`
  ADD PRIMARY KEY (`usernamekasir`);

--
-- Indexes for table `transaksikredit`
--
ALTER TABLE `transaksikredit`
  ADD PRIMARY KEY (`nomortransaksi`);

--
-- Indexes for table `transaksitunai`
--
ALTER TABLE `transaksitunai`
  ADD PRIMARY KEY (`nomor_faktur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaksikredit`
--
ALTER TABLE `transaksikredit`
  MODIFY `nomortransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1252;
--
-- AUTO_INCREMENT for table `transaksitunai`
--
ALTER TABLE `transaksitunai`
  MODIFY `nomor_faktur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
