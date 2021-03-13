-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Mar 2021 pada 12.21
-- Versi server: 10.4.8-MariaDB
-- Versi PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baihaqi_app_pembayaranspp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `foto_profile`
--

CREATE TABLE `foto_profile` (
  `id_user` int(6) NOT NULL,
  `foto` text DEFAULT 'src\\resources\\image\\user-profile\\default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` char(9) NOT NULL,
  `nama_kelas` varchar(10) NOT NULL,
  `level_kelas` enum('X','XI','XII','XIII') NOT NULL,
  `jurusan` enum('TPM','TITL','TOI','TBG','TBS','RPL') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`, `level_kelas`, `jurusan`) VALUES
('x.rpl1', 'X-RPL-1', 'X', 'RPL'),
('x.rpl2', 'X-RPL-2', 'X', 'RPL'),
('x.tbg1', 'X-TBG-1', 'X', 'TBG'),
('x.tbg2', 'X-TBG-2', 'X', 'TBG'),
('x.tbs1', 'X-TBS-1', 'X', 'TBS'),
('x.tbs2', 'X-TBS-2', 'X', 'TBS'),
('x.titl1', 'X-TITL-1', 'X', 'TITL'),
('x.titl2', 'X-TITL-2', 'X', 'TITL'),
('x.titl3', 'X-TITL-3', 'X', 'TITL'),
('x.toi1', 'X-TOI-1', 'X', 'TOI'),
('x.tpm1', 'X-TPM-1', 'X', 'TPM'),
('x.tpm2', 'X-TPM-2', 'X', 'TPM'),
('x.tpm3', 'X-TPM-3', 'X', 'TPM'),
('xi.rpl1', 'XI-RPL-1', 'XI', 'RPL'),
('xi.rpl2', 'XI-RPL-2', 'XI', 'RPL'),
('xi.tbg1', 'XI-TBG-1', 'XI', 'TBG'),
('xi.tbg2', 'XI-TBG-2', 'XI', 'TBG'),
('xi.tbs1', 'XI-TBS-1', 'XI', 'TBS'),
('xi.tbs2', 'XI-TBS-2', 'XI', 'TBS'),
('xi.titl1', 'XI-TITL-1', 'XI', 'TITL'),
('xi.titl2', 'XI-TITL-2', 'XI', 'TITL'),
('xi.titl3', 'XI-TITL-3', 'XI', 'TITL'),
('xi.toi1', 'XI-TOI-1', 'XI', 'TOI'),
('xi.tpm1', 'XI-TPM-1', 'XI', 'TPM'),
('xi.tpm2', 'XI-TPM-2', 'XI', 'TPM'),
('xi.tpm3', 'XI-TPM-3', 'XI', 'TPM'),
('xii.rpl1', 'XII-RPL-1', 'XII', 'RPL'),
('xii.rpl2', 'XII-RPL-2', 'XII', 'RPL'),
('xii.tbg1', 'XII-TBG-1', 'XII', 'TBG'),
('xii.tbg2', 'XII-TBG-2', 'XII', 'TBG'),
('xii.tbs1', 'XII-TBS-1', 'XII', 'TBS'),
('xii.tbs2', 'XII-TBS-2', 'XII', 'TBS'),
('xii.titl1', 'XII-TITL-1', 'XII', 'TPM'),
('xii.titl2', 'XII-TITL-2', 'XII', 'TITL'),
('xii.titl3', 'XII-TITL-3', 'XII', 'TITL'),
('xii.toi1', 'XII-TOI-1', 'XII', 'TOI'),
('xii.tpm1', 'XII-TPM-1', 'XII', 'TPM'),
('xii.tpm2', 'XII-TPM-2', 'XII', 'TPM'),
('xii.tpm3', 'XII-TPM-3', 'XII', 'TPM'),
('xiii.toi1', 'XIII-TOI-1', 'XIII', 'TOI');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(10) NOT NULL,
  `id_petugas` int(6) NOT NULL,
  `nis` int(6) NOT NULL,
  `bln_bayar` enum('Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember') NOT NULL,
  `thn_bayar` int(4) NOT NULL,
  `jml_bayar` int(11) DEFAULT 0,
  `tgl_bayar` date NOT NULL,
  `id_spp` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_petugas`, `nis`, `bln_bayar`, `thn_bayar`, `jml_bayar`, `tgl_bayar`, `id_spp`) VALUES
('TR000001', 111, 6156, 'Januari', 2021, 135000, '0000-00-00', 12),
('TR000002', 12, 6156, 'Desember', 2020, 135000, '2021-03-13', 12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int(6) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nama_petugas` varchar(50) NOT NULL,
  `gender` enum('L','P') NOT NULL,
  `tempat_lahir` varchar(50) DEFAULT 'Indonesia',
  `tanggal_lahir` date DEFAULT '2000-01-01',
  `alamat` text DEFAULT 'Jawa Timur, Indonesia',
  `no_hp` varchar(15) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(50) NOT NULL,
  `level` enum('admin','petugas') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `username`, `nama_petugas`, `gender`, `tempat_lahir`, `tanggal_lahir`, `alamat`, `no_hp`, `email`, `password`, `level`) VALUES
(111, 'admin', 'Anonim', 'L', 'Indonesia', '2000-01-01', 'Jawa Timur, Indonesia', '085', 'nuub', 'root', 'admin'),
(112, 'admin1', 'Anonim', 'L', 'Indonesia', '2000-01-01', 'Jawa Timur, Indonesia', '0856', 'nuub1', 'root', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` int(6) NOT NULL,
  `nama_siswa` varchar(50) NOT NULL,
  `gender` enum('L','P') NOT NULL,
  `tempat_lhr` varchar(50) DEFAULT 'Indonesia',
  `tanggal_lhr` date DEFAULT '2020-01-01',
  `id_kelas` char(9) NOT NULL,
  `alamat` text DEFAULT 'Jawa Timur, Indonesia',
  `no_hp` varchar(15) NOT NULL,
  `email` varchar(60) NOT NULL,
  `nama_wali` varchar(50) DEFAULT 'Manusia',
  `id_spp` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `spp`
--

CREATE TABLE `spp` (
  `id_spp` int(2) NOT NULL,
  `tahun` int(4) NOT NULL,
  `nominal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `spp`
--

INSERT INTO `spp` (`id_spp`, `tahun`, `nominal`) VALUES
(17, 2017, 120000),
(18, 2018, 140000),
(19, 2019, 160000),
(20, 2020, 180000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `foto_profile`
--
ALTER TABLE `foto_profile`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indeks untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indeks untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`,`username`,`email`,`no_hp`);

--
-- Indeks untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`,`no_hp`,`email`);

--
-- Indeks untuk tabel `spp`
--
ALTER TABLE `spp`
  ADD PRIMARY KEY (`id_spp`,`tahun`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
