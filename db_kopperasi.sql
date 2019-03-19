-- Adminer 4.7.1 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `tb_anggota`;
CREATE TABLE `tb_anggota` (
  `id_anggota` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(45) DEFAULT NULL,
  `no_hp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_anggota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tb_anggota` (`id_anggota`, `nama`, `no_hp`) VALUES
(1,	'Ikhsan fauji',	'07646731256'),
(2,	'Khoirul Fajri',	'08646730067'),
(3,	'Enta bayon',	'000');

DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE `tb_barang` (
  `id_barang` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(45) DEFAULT NULL,
  `harga` int(15) DEFAULT NULL,
  PRIMARY KEY (`id_barang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tb_barang` (`id_barang`, `nama_barang`, `harga`) VALUES
(1,	'Buku Tulis',	5000),
(2,	'Pulpen Standard',	2500),
(3,	'Rokok Surya 16',	23000),
(4,	'Permen',	23000);

DROP TABLE IF EXISTS `tb_total_bulanan`;
CREATE TABLE `tb_total_bulanan` (
  `id_bulan` int(11) NOT NULL AUTO_INCREMENT,
  `bulan` varchar(45) DEFAULT NULL,
  `total_transaksi` int(20) DEFAULT 0,
  PRIMARY KEY (`id_bulan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tb_total_bulanan` (`id_bulan`, `bulan`, `total_transaksi`) VALUES
(1,	'Januari',	25000),
(2,	'Februari',	25000),
(3,	'Maret',	92000),
(4,	'April',	0),
(5,	'Mei',	0),
(6,	'Juni',	0),
(7,	'Juli',	0),
(8,	'Agustus',	0),
(9,	'September',	0),
(10,	'Oktober',	0),
(11,	'November',	0),
(12,	'Desember',	0);

DROP TABLE IF EXISTS `tb_transaksi`;
CREATE TABLE `tb_transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_barang` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `total_harga` int(20) DEFAULT NULL,
  `id_bulan` int(11) DEFAULT NULL,
  `id_anggota` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tb_transaksi` (`id_transaksi`, `id_barang`, `jumlah`, `total_harga`, `id_bulan`, `id_anggota`) VALUES
(1,	1,	2,	10000,	1,	NULL),
(2,	2,	2,	5000,	1,	NULL),
(3,	2,	2,	5000,	1,	NULL),
(4,	1,	1,	5000,	1,	NULL),
(5,	3,	3,	69000,	3,	NULL),
(6,	3,	1,	23000,	3,	NULL),
(7,	1,	1,	5000,	2,	3),
(8,	2,	5,	12500,	2,	3),
(9,	1,	1,	5000,	2,	3),
(10,	2,	1,	2500,	2,	3);

-- 2019-03-19 01:18:38