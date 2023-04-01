-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Nov 2022 pada 13.22
-- Versi server: 10.4.25-MariaDB
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `evakuasi_bencana`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `ttl` varchar(30) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` text NOT NULL,
  `imageLink` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`id`, `username`, `ttl`, `jk`, `telepon`, `jabatan`, `alamat`, `email`, `password`, `imageLink`) VALUES
(1, 'Wahyu', 'Pandajaya, 30-04-1998', 'Laki-laki', '082293546364', 'Admin', 'Perumahan Dosen', 'www', '123', 'https://i.pinimg.com/originals/8b/16/7a/8b167af653c2399dd93b952a48740620.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `posko_pengungsi`
--

CREATE TABLE `posko_pengungsi` (
  `id` int(11) NOT NULL,
  `nama_lokasi` varchar(60) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `kelurahan` varchar(60) DEFAULT NULL,
  `kecamatan` varchar(60) NOT NULL,
  `latitude` varchar(30) DEFAULT NULL,
  `longitude` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `posko_pengungsi`
--

INSERT INTO `posko_pengungsi` (`id`, `nama_lokasi`, `alamat`, `kelurahan`, `kecamatan`, `latitude`, `longitude`) VALUES
(1, 'Posko Tanamodindi 1', 'Jl. Garuda', 'Tanamodindi', 'Mantikulore', '-0.916521', '119.885432'),
(2, 'Posko Tatura Utara 1', 'Gereja Jl. Tanjung Manimbaya Palu\r\n', 'Tatura Utara', 'Palu Selatan', '-0.9083901', '119.8818257'),
(3, 'Posko Nunu 1', 'Jalan Jati Lorong Meranti Nomor 22\r\n', 'Nunu', 'Tatanga', '-0.9126912', '119.8637985'),
(4, 'Posko Birobuli Selatan 1', 'Jl. Banteng, Lorong SMA 3 (Komp. Rumah Helmi Mantik)\r\n', 'Birobuli Selatan', 'Palu Selatan', '-0.9318012', '119.8978194'),
(5, 'Posko Kamonji 1', 'Jl. Lombok Lorong 2\r\n', 'Kamonji', 'Palu Barat', '-0.9137524', '119.883053'),
(6, 'Posko Tatura Utara 2', 'Jalan Anoa 1. Lorong Sintuvuntodea\r\n', 'Tatura Utara', 'Palu Selatan', '-0.9137524', '119.883053'),
(7, 'Posko Tavanjuka 1', 'Jalan Lekatu\r\n', 'Tavanjuka', 'Tatanga', '-0.9184385', '119.8651612'),
(8, 'Posko Birobuli Selatan 2', 'Jalan Banteng\r\n', 'Birobuli Selatan', 'Palu Selatan', '-0.9312282', '119.8898427'),
(9, 'Posko Talise 1', 'Jln. Dayo Dara Paharayung Perum Pesona Citra Indah 1s blok D\r\n', 'Talise', 'Mantikulore', '-0.8852602', '119.8902983'),
(10, 'Posko Birobuli Selatan 3', 'Jl. Banteng No. 29\r\n', 'Birobuli Selatan', 'Palu Selatan', '-0.931208', '119.892436'),
(11, 'Posko Tondo 1', 'Jalan Soekarno Hatta\r\n', 'Tondo', 'Mantikulore', '-0.8521054', '119.8922454'),
(12, 'Posko Nunu 2', 'Jalan Sungai Sausu\r\n', 'Nunu', 'Palu Barat', '-0.9023973', '119.8612621'),
(13, 'Posko Talise 2', 'Jl. Hangtuah lrg. Bukit Marwah (Depan lorang ada alfamidi)\r\n', 'Talise', 'Mantikulore', '-0.8780246', '119.8762428'),
(14, 'Posko Lasoani 1', 'BTN Lasoani Blok E2 No. 2\r\n', 'Lasoani', 'Mantikulore', '-0.9021866', '119.9132728'),
(15, 'Posko Tanamodindi 2', 'Jln. Muh. Yamin Samping Lapangan Gor Siranindi Komplex penjualan durian\r\n', 'Tanamodindi', 'Mantikulore', '-0.9023614', '119.8894566'),
(16, 'Posko Tatura Utara 2', 'Jl. Tanjung Satu Lorong Citra\r\n', 'Tatura Utara', 'Palu Selatan', '-0.9060638', '119.8830271'),
(17, 'Posko Birobuli Utara 1', 'Jl. Garuda II No. 8A\r\n', 'Birobuli Utara', 'Palu Selatan', '-0.9153343', '119.9013514'),
(18, 'Posko Boyaoge 1', 'Jln. Puebongo. Lrg kemiri\r\n', 'Boyaoge', 'Tatanga', '-0.9033643', '119.8561349'),
(19, 'Posko Talise 3', 'Jl. Tombolotutu, Lorong Jabal Rahma\r\n', 'Talise', 'Mantikulore', '-0.8853189', '119.8822714'),
(20, 'Posko Tatura Utara 3', 'Jl. Batu Merah Indah\r\n', 'Tatura Utara', 'Palu Selatan', '-0.9022374', '119.8505773'),
(21, 'Posko Kamonji 4', 'Jl. Palola\r\n', 'Kamonji', 'Palu Barat', '-0.8981657', '119.847522'),
(22, 'Posko Birobuli Utara 9', 'Jl. Banteng Blok E 32\r\n', 'Birobuli Selatan', 'Palu Selatan', '-0.9313508', '119.8914806'),
(23, 'Posko Nunu 3', 'jl. Tanah Rava Indah RT1 RW1 Kelurahan Nunu Kec. Tatanga\r\n', 'Nunu', 'Tatanga', '-0.9125721', '119.8676374'),
(24, 'Posko Panau 1', 'Jl. Labu Lembah Panau kec. Tawaeli\r\n', 'Panau', 'Tawaeli', '-0.7338018', '119.8607104'),
(25, 'Posko Besusu Barat 1', 'Jl. Hayam Wuruk no.18 kec. Palu Timur kel. Besusu Barat (depan Fotocopy wahyu)\r\n', 'Besusu Barat', 'Palu Timur', '-0.889151', '119.86172'),
(26, 'Posko Baiya 2', 'Jl. Andudana Baiya Kec. Tawaeli\r\n', 'Baiya', 'Tawaeli', '-0.727609', '119.86478'),
(27, 'Posko Kamonji 3', '\"Jl. Mangga No 56 (Depan TK Alkhairat)\r\nPalu\"\r\n', 'Kamonji', 'Palu Barat', '-0.901311', '119.857917'),
(28, 'Posko Lasoani 2', 'Jl. Bouraq ', 'Lasoani', 'Palu Timur', '-0.9107778', '119.8994463'),
(29, 'Posko Birobuli Utara 4', 'Jln Elang, Palu	', 'Birobuli Utara', 'Palu Selatan', '-0.9081402', '119.8975453'),
(30, 'Posko Nunu 4', 'Jl sungai balantak (Belakang mesjid) Kelurahan Nunu	', 'Nunu', 'Tatanga', '-0.9046027', '119.8657303'),
(31, 'Posko Tatura Selatan 1', 'Jalan Towua\r\n', 'Tatura Selatan	', 'Palu Selatan', '-0.9230828', '119.879281'),
(32, 'Posko Birobuli Selatan 4', 'Jl Kijang Selatan\r\n', 'Birobuli Selatan', 'Palu Selatan	', '-0.9286059', '119.8936719'),
(33, 'Posko Tanamodindi 3', 'Jl. Sisingamangaraja, Lorong Simaja I No. 15', 'Tanamodindi', 'Mantikulore', '-0.8909152', '119.8880689'),
(34, 'Posko Birobuli Selatan 5', 'Jl. Towua, Lorong Malaya', 'Birobuli Selatan', 'Palu Selatan', '-0.9322603', '119.8823278'),
(35, 'Posko Boyaoge 2', 'Jl. Bambu No.10\r\n', 'Boyaoge', 'Palu Barat', '-0.9073133', '119.8570892'),
(36, 'Posko Baiya 3', 'Jl. Vatamoento, Baiya, Kecamatan Tawaeli\r\n', 'Baiya', 'Tawaeli', '-0.7243304', '119.8613048'),
(37, 'Posko Duyu 2', 'Jl. Gunung gawalise', 'Duyu', 'Palu Barat', '-0.911865', '119.836619'),
(38, 'Posko Siranindi 2', 'jl. Mangga 1 no.10\r\n', 'Siranindi	', 'Palu Barat', '-0.8999769', '119.8525638'),
(39, 'Posko Lolu Selatan 1', 'Jl. Tanjung seng No.5		', 'Lolu Selatan', 'Palu Selatan', '-0.9037827', '119.8777263'),
(40, 'Posko Nunu 5', 'Jalan Jati Kel. Nunu Palu Barat\r\n', 'Nunu', 'Palu Barat', '-0.9107909', '119.866645'),
(41, 'Posko Birobuli Selatan 6', 'Jl. Banteng Blok. I dan Blok. G', 'Birobuli Selatan', 'Palu Selatan', '-0.9318727', '119.889457'),
(42, 'Posko Birobuli Selatan 7', 'Jl. Abd. Rahman Saleh BTN Mutiara	', 'Birobuli Utara', 'Palu Selatan', '-0.9205368', '119.9016322'),
(43, 'Posko Boyaoge 3', 'Jalan bambu no.23b 	\r\n', 'Boyaoge', 'Tatanga', '-0.90794', '119.8589247'),
(44, 'Posko Tanamodindi 4', 'Jln kakatua lrg touna no. 4. 	\r\n', 'Tanamodindi', 'Mantikulore', '-0.9024252', '119.8902196'),
(45, 'Posko Birobuli Utara 5', 'Abd. Rahman Saleh No. 49\r\n', 'Birobuli Utara', 'Palu Selatan', '-0.9193095', '119.896977'),
(46, 'Posko Boyaoge 4', 'Jalan puebongo lorong kayu manis		\r\n', 'Boyaoge', 'Tatanga	 	', '-0.9152352', '119.8563577'),
(47, 'Posko Lere 2', 'Jl. Asam 2\r\n', 'Lere', 'Palu Barat', '-0.8941665', '119.841434'),
(48, 'Posko Besusu Timur 1', 'Jl. Otto Iskandar Dinata No.52', 'Besusu Timur', 'Palu Timur', '-0.8920351', '119.8813016'),
(49, 'Posko Talise 4', 'Jl Hangtuah, Dekat Unishmuh Palu - Lapangan', 'Talise', 'Mantikulore', '-0.871962', '119.8777372'),
(50, 'Posko Tatura Utara 4', 'Jl. Purnawirawan II Lorong 4\r\n', 'Tatura Utara', 'Palu Selatan	', '-0.9172536', '119.880555'),
(51, 'Posku Lolu Selatan 2', 'Jalan tanjung balantak, dusun lolu selatan\r\n', 'Lolu Selatan', 'Palu Selatan', '-0.905568', '119.88279'),
(52, 'Posko Talise 5', 'Jl Dayodara perumahan cipta pesona indah 3 blok B1 	\r\n', 'Talise', 'Mantikulore', '-0.8845814', '119.8905574'),
(53, 'Posko Tondo 2', 'btn bumi roviga blok b7/3 	\r\n', 'Tondo', 'Mantikulore', '-0.844513', '119.904972'),
(54, 'Posko Birobuli Utara 6', 'Jalan Basuki Rahmat Lorong Pahlawan/ Lorong Nusantara No. 22B 	\r\n', 'Birobuli Utara', 'Palu Selatan', '-0.920546', '119.879876'),
(55, 'Posko Kamonji 5', 'Jalan kedondong lorong 3 palu (lapangan)', 'Kamonji', 'Palu Barat', '-0.9033806', '119.82976'),
(56, 'Posko Tatura Utara 5', 'Jalan tanjung satu no. 68b	', 'Tatura Utara ', 'Palu Selatan', '-0.9055053', '119.8874733'),
(57, 'Posko Talise 6', 'Jl. Tombolotutu Tengah, Lorong Melati', 'Talise', 'Mantikulore', '-0.9053418', '119.8450953'),
(58, 'Posko Talise 7', 'Jln bukit jabal rahmah, kelurahan talise, mantikulore', 'Talise', 'Mantikulore', '-0.8836368', '119.8607104'),
(59, 'Posko Birobuli Selatan 8', 'Jalan Banteng Utara 1', 'Birobuli Selatan', 'Palu Selatan', '-0.9299467', '119.8922129'),
(60, 'Posko Birobuli Utara 7', 'Jalan Basuki Rahmat I\r\n', 'Birobuli Utara', 'Palu Selatan', '-0.9169015', '119.8895439'),
(61, 'Posko Tatura Utara 6', 'Jln. Anoa 1 no. 17 Dekat mall ramayana, Kel. Tatura utara', 'Tatura Utara', 'Palu Selatan', '-0.9142449', '119.8892976'),
(62, 'Posko Lere 3', 'jl Asam 2', 'Lere', 'Palu Barat', '-0.8941659', '119.8449999'),
(63, 'Posko Lolu Utara 2', 'Jl. Gunung Loli\r\n', ' Lolu Utara', 'Palu Selatan', '-0.8989202', '119.881869'),
(64, 'Posko Duyu 3', 'Jl. Sungai Manonda, lrg Syukur', 'Duyu	', 'Palu Barat', '-0.9154048', '119.8465109'),
(65, 'Posko Boyaoge 5', 'Jln anggur 3 desa Bayoge Kec.Tataga\r\n', 'Boyaoge	', 'Tatanga', '-0.9127494', '119.8541024'),
(66, 'Posko Siranindi 3', 'Jalan danau lindu no. 8 D\r\n', 'Siranindi', 'Palu Barat', '-0.8987648', '119.8609171'),
(67, 'Posko Layana Indah 1', 'jl. Dupa indah, Sebelum surau bahrul ami\r\n', 'Layana Inda', 'Mantikulore', '-0.8128582', '119.8862779'),
(68, 'Posko Talise 8', 'Jalan lagarutu \r\n', 'Talise', 'Palu Timur', '-0.8900927', '119.8964677'),
(69, 'Posko Birobuli Utara 8', 'Jalan tanggul utara, dekat bandara, Desa Birobuli utara Kec. Palu Selatan', 'Birobuli Utara', 'Palu Selatan', '-0.9097527', '119.8931441'),
(70, 'Posko Duyu 4', 'Puskesmas Sungurara, Kelurahan Duyu Kecamatan Tatanga', 'Duyu', 'Tatanga', '-0.9199363', '119.845792'),
(71, 'Posko Layana Indah 2', 'Jalan Dupa Indah', 'Layana Inda', 'Mantikulore', '-0.8129302', '119.886338'),
(72, 'Posko Besusu Barat 2', 'BTN Griya garuda indah', 'Besusu Barat', 'Palu Timur', '-0.9109318', '119.8988286'),
(73, 'Posko Pengawu 3', 'Jalan padanjaka lorong uwempemata kel pengau kec tatanga - Halaman Rumah', 'Pengawu', 'Tatanga', '-0.9215093', '119.8415494'),
(74, 'Posko Pengawu 4', 'Jalan malontara kecamatan palu barat kelurahan pengau - Halaman Rumah', 'Pengawu', 'Palu Barat', '-0.9273668', '119.8454099'),
(75, 'Posko Tanamodindi 5', 'Jalan Lagarutu Perintis, Tanamodindi Palu - Halaman Rumah	', 'Tanamodindi', 'Palu Selatan', '-0.8877534', '119.9026397'),
(76, 'Posko Lasoani 3', 'Btn lasoani bawah blok d4 no.6 - Halaman Rumah\r\n', 'Lasoani', 'Mantikulore', '-0.9043197', '119.9143825'),
(77, 'Posko Boyaege 5', 'Jl. Pue bongo di lapangan sebelah rusun universitas alkhairat', 'Boyaoge', 'Tatanga', '-0.919862', '119.855932'),
(78, 'Posko Talise 9', 'Jl lagarutu no 22', 'Talise	', 'Palu Timur', '-0.8892446', '119.8887838'),
(79, 'Posko Birobuli Selatan 11', 'Jl. Banteng BTN BUMI ANGGUR ', 'Birobuli Selatan	', 'Palu Selatan', '0° 55\' 53.0954\" S', '119° 53\' 41.73\" E'),
(80, 'Posko Tanamodindi 6', 'Jalan Garuda II (Kompleks Mesjid Al-hijrah) dekat mesjid	', 'Tanamodindi', 'Mantikulore', '-0.915717', '119.9003845'),
(81, 'Posko Tanamodindi 7', 'Jl. Garuda No. 90 Palu - Lapangan	\r\n', 'Tanamodindi', 'Mantikulore', '-0.9089465', '119.8985271'),
(82, 'Posko Birobuli Utara 9', 'Jalan basuki rahmat lorong apotik pelangi	\r\n', 'Birobuli Utara', 'Palu Selatan', '-0.9187089', '119.8859309'),
(83, 'Posko Talise 10', 'Jln. Hangtuah , lrg bukit sofa blok A depan mesjid al-mutahirin\r\n', 'Talise', 'Mantikulore', '-0.8740391', '119.8807264'),
(84, 'Posko Tanamodindi 8', 'Jl. Garuda Lorong Kapurung (Perum. Grahha Garuda Nusantara)\r\n', 'Tanamodindi', 'Mantikulore', '-0.9136843', '119.9009088'),
(85, 'Posko Tatura Utara 7', 'Jalan Anoa I Lorong Pemuda Pancasila (Halaman Rumah)', 'Tatura Utara', 'Palu Selatan', '-0.9122721', '119.8798919'),
(86, 'Posko Birobuli Selatan 9', 'Lapangan futsal banteng jl.banteng', 'Birobuli Selatan	', 'Palu Selatan', '-0.9293658', '119.8923052'),
(87, 'Posko Kayumalue Ngapa 1', 'Jl Ndate Ngisi', 'Kayumalue Ngapa', 'Palu Utara', '-0.7572583', '119.8637708'),
(88, 'Posko Kamonji 2', 'Jalan Palola Desa Kamonji, Kec.Palu Barat', 'Kamonji', 'Palu Barat', '-0.8985404', '119.846717'),
(89, 'Posko Lolu Utara 3', 'Jl. Juanda\r\n', 'Lolu Utara', 'Palu Selatan', '-0.8960019', '119.8806425'),
(90, 'Posko Lolu Utara 4', 'Jl. Professor Moh. Yamin\r\n', 'Lolu Utara', 'Palu Timur', '-0.8986229', '119.8878688'),
(91, 'Posko Birobuli Utara 10', 'Jl. DR. Abdurrahman Saleh\r\n\r\n', 'Birobuli Utara', 'Palu Selatan', '-0.918826', '119.9058937'),
(92, 'Posko Besusu Barat 1', 'DR. Sam Ratulangi, No. 80\r\n', 'Besusu Barat', 'Palu Timur', '-0.8909037', '119.8695114'),
(93, 'Posko Lolu Selatan 2', 'Jl. Patimura No.53\r\n', 'Lolu Selatan', 'Palu Selatan', '-0.9021177', '119.8695607'),
(94, 'Posko Tatura Utara 8', 'Jl. Anoa Lrg Thoy Hally', 'Tatura Utara', 'Palu Selatan', '-0.9130844', '119.8852999'),
(95, 'Posko Balaroa 1', 'jl. Cempedak', 'Balaroa', 'Palu Barat', '-0.90516', '119.8550275'),
(96, 'Posko Duyu 5', 'Lapangan Sepak Bola GALARA', 'Duyu', 'Palu Barat', '-0.9155622', '119.8522289'),
(97, 'Posko Birobuli Selatan 10', 'Jl. Banteng No.29\r\n', 'Birobuli Selatan', 'Palu Selatan', '-0.931208', '119.892436'),
(98, 'Posko Siranindi 1', 'Jalan Sungai Surumana', 'Siranindi	', 'Palu Barat', '-0.9026049', '119.8606588'),
(99, 'Posko Baiya 1', 'Lapangan jl. Vatamoento\r\n', 'Baiya', 'Tawaeli', '-0.7227165', '119.8598738'),
(100, 'Posko Lere 1', 'jl Asam 2\r\n', 'Lere', 'Palu Barat', '-0.8941659', '119.8449999'),
(101, 'Posko Duyu 1', 'Stadion Gawalise', 'Duyu', 'Tatanga', '-0.9232133', '119.839214'),
(102, 'Posko Tatura Selatan 2', 'Jalan Towua 2 lrg 1\r\n', 'Tatura Selatan', 'Palu Selatan', '-0.923954', '119.8809833'),
(103, 'Posko Tatura Utara 9', 'Jln. Anoa 1 lorong Anoaku Palu\r\n', 'Tatura Utara', 'Palu Selatan', '-0.913844', '119.883662'),
(104, 'Posko Tanamodindi 8', 'Jl. soekarno hatta', 'Tanamodindi', 'mantikulore', '-0.8837258254133833', '119.79121153739106');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `posko_pengungsi`
--
ALTER TABLE `posko_pengungsi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `posko_pengungsi`
--
ALTER TABLE `posko_pengungsi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
