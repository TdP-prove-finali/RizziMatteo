-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.4.12-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database festivaldimusica
CREATE DATABASE IF NOT EXISTS `festivaldimusica` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_nopad_ci */;
USE `festivaldimusica`;

-- Dump della struttura di tabella festivaldimusica.artisti
CREATE TABLE IF NOT EXISTS `artisti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `genere` varchar(50) NOT NULL,
  `biglietti_venduti` int(10) unsigned NOT NULL DEFAULT 0,
  `numero_di_show` int(10) unsigned NOT NULL DEFAULT 0,
  `numero_medio_biglietti_venduti` double(22,0) unsigned NOT NULL DEFAULT 0,
  `ascolti_Spotify_ultimo_mese` int(10) unsigned NOT NULL DEFAULT 0,
  `cachet_medio` int(10) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella festivaldimusica.artisti: ~0 rows (circa)
/*!40000 ALTER TABLE `artisti` DISABLE KEYS */;
INSERT INTO `artisti` (`id`, `nome`, `genere`, `biglietti_venduti`, `numero_di_show`, `numero_medio_biglietti_venduti`, `ascolti_Spotify_ultimo_mese`, `cachet_medio`) VALUES
	(1, '5 Seconds of Summer', 'pop', 743906, 83, 8963, 21174639, 750000),
	(2, 'Adam Lambert', 'pop', 372462, 25, 14898, 2622358, 200000),
	(3, 'Adele', 'pop', 2475773, 120, 20631, 22354286, 875000),
	(4, 'Aerosmith', 'rock', 208142, 43, 4841, 14879222, 1250000),
	(5, 'Alanis Morisette', 'rock', 121018, 40, 3025, 6012194, 300000),
	(6, 'Alicia Keys', 'pop', 202226, 23, 8792, 19547076, 550000),
	(7, 'All Time Low', 'punk', 53980, 5, 10796, 4583842, 112500),
	(8, 'André Rieu', 'classical', 640923, 68, 9425, 891203, 200000),
	(9, 'Andrea Bocelli', 'classical', 478854, 45, 10641, 3904720, 1250000),
	(10, 'Arctic Monkeys', 'alternative', 278533, 18, 15474, 13588128, 475000),
	(11, 'Ariana Grande', 'pop', 1329061, 97, 13702, 55806678, 750000),
	(12, 'Avril Lavigne', 'pop', 35621, 7, 5089, 11949202, 300000),
	(13, 'Babymetal', 'j-pop/k-pop', 16575, 3, 5525, 611367, 225000),
	(14, 'Backstreet Boys', 'pop', 1066873, 99, 10776, 13776739, 875000),
	(15, 'Bad Bunny', 'latin', 664747, 53, 12542, 42751672, 500000),
	(16, 'Barbra Streisand', 'pop', 203423, 16, 12714, 3870930, 750000),
	(17, 'Bebe Rexha', 'pop', 7108, 9, 790, 25787286, 300000),
	(18, 'Beyoncé', 'R&B', 2242099, 49, 45757, 38931924, 1250000),
	(19, 'Big Bang', 'j-pop/k-pop', 766000, 16, 47875, 2217019, 750000),
	(20, 'Billy Joel', 'rock', 565585, 21, 26933, 14629862, 1250000),
	(21, 'Blake Shelton', 'country', 474448, 26, 18248, 7928605, 750000),
	(22, 'Blink-182', 'punk', 196349, 14, 14025, 11401423, 875000),
	(23, 'Blondie', 'rock', 1993, 2, 996, 6664061, 125000),
	(24, 'Bob Dylan', 'rock', 33998, 11, 3091, 9836368, 300000),
	(25, 'Bob Seger', 'rock', 737376, 62, 11893, 5222778, 625000),
	(26, 'Bon Iver', 'folk', 20259, 2, 10129, 6525949, 375000),
	(27, 'Bon Jovi', 'rock', 1027284, 24, 42803, 17227228, 875000),
	(28, 'Brad Paisley', 'country', 313707, 21, 14938, 4377028, 450000),
	(29, 'Brandon Flowers', 'alternative', 6921, 6, 1153, 565514, 150000),
	(30, 'Bruce Springsteen', 'rock', 2486058, 86, 28908, 12407204, 750000),
	(31, 'Bruno Mars', 'pop', 3633804, 218, 16669, 33262334, 1250000),
	(32, 'BTS', 'j-pop/k-pop', 1336545, 31, 43114, 14375521, 750000),
	(33, 'Carly Rae Jepsen', 'pop', 16325, 6, 2721, 10447302, 87500),
	(34, 'Carrie Underwood', 'country', 671965, 62, 10838, 6220101, 875000),
	(35, 'Cher', 'pop', 933526, 82, 11384, 7247506, 750000),
	(36, 'Cher Lloyd', 'pop', 5691, 4, 1423, 2890902, 22500),
	(37, 'Chris Brown', 'rap/trap', 355101, 37, 9597, 33101171, 250000),
	(38, 'Christina Aguilera', 'pop', 68711, 10, 6871, 15624375, 875000),
	(39, 'Coldplay', 'alternative', 5389586, 115, 46866, 34146450, 625000),
	(40, 'Cyndi Lauper', 'pop', 20280, 9, 2253, 9407056, 87500),
	(41, 'Daddy Yankee', 'latin', 52549, 3, 17516, 40515547, 750000),
	(42, 'Daniel Caesar', 'R&B', 3844, 4, 961, 8235306, 100000),
	(43, 'Darius Rucker', 'country', 354776, 33, 10751, 4592108, 300000),
	(44, 'Daughtry', 'alternative', 4503, 3, 1501, 2630609, 87500),
	(45, 'Dave Matthews Band', 'alternative', 727967, 66, 11030, 2879544, 875000),
	(46, 'Deep Purple', 'rock', 136596, 22, 6209, 6599553, 125000),
	(47, 'Demi Lovato', 'pop', 370853, 40, 9271, 26265262, 437500),
	(48, 'Depeche Mode', 'rock', 2470918, 112, 22062, 7817009, 750000),
	(49, 'Diana Ross', 'pop', 102178, 38, 2689, 6858058, 200000),
	(50, 'Dierks Bentley', 'country', 25633, 4, 6408, 4560514, 750000),
	(51, 'Dixie Chicks', 'country', 788574, 59, 13366, 4929307, 750000),
	(52, 'Dolly Parton', 'country', 141984, 20, 7099, 11497069, 500000),
	(53, 'Drake', 'rap/trap', 285778, 23, 12425, 59930717, 400000),
	(54, 'Eagles', 'rock', 381385, 28, 13621, 14495795, 875000),
	(55, 'Ed Sheeran', 'pop', 2446065, 51, 47962, 53358684, 1000000),
	(56, 'Elton John', 'pop', 1545660, 110, 14051, 25431507, 1250000),
	(57, 'Eminem', 'rap/trap', 366766, 7, 52395, 38964523, 875000),
	(58, 'Enrique Iglesias', 'latin', 217061, 12, 18088, 18175291, 875000),
	(59, 'Eric Church', 'country', 776887, 54, 14387, 5367938, 625000),
	(60, 'EXO', 'j-pop/k-pop', 349110, 31, 11262, 3251041, 750000),
	(61, 'Faith No More', 'alternative', 9152, 2, 4576, 2992116, 500000),
	(62, 'Fall Out Boy', 'rock', 56766, 6, 9461, 19134794, 625000),
	(63, 'Fifth Harmony', 'pop', 56354, 11, 5123, 9206645, 225000),
	(64, 'Fleetwood Mac', 'rock', 858578, 55, 15611, 18076492, 625000),
	(65, 'Florence', 'alternative', 483613, 45, 10747, 9354857, 875000),
	(66, 'Florida Georgia Line', 'country', 744967, 45, 16555, 12150607, 625000),
	(67, 'Foo Fighters', 'alternative', 174930, 17, 10290, 11561857, 300000),
	(68, 'Garbage', 'alternative', 16153, 9, 1795, 1688249, 55000),
	(69, 'Garth Brooks', 'country', 921040, 13, 70849, 625206, 750000),
	(70, 'G-Dragon', 'j-pop/k-pop', 654000, 25, 26160, 1019605, 750000),
	(71, 'Goo Goo Dolls', 'alternative', 17082, 3, 5694, 7518103, 150000),
	(72, 'Green Day', 'punk', 803936, 61, 13179, 16945973, 875000),
	(73, 'Gwen Stefany', 'pop', 136294, 40, 3407, 7785141, 750000),
	(74, 'Haim', 'pop', 35156, 7, 5022, 4475059, 150000),
	(75, 'Halsey', 'pop', 89015, 16, 5563, 49834927, 400000),
	(76, 'Hanson', 'pop', 16552, 6, 2759, 2413122, 57500),
	(77, 'Hootie & the Blowfish', 'rock', 703748, 56, 12567, 2309628, 437500),
	(78, 'Hugh Jackman', 'musical', 1011213, 90, 11236, 4251259, 300000),
	(79, 'Hunter Hayes', 'country', 19532, 6, 3255, 3073712, 45000),
	(80, 'Idina Menzel', 'pop', 20052, 4, 5013, 7189220, 225000),
	(81, 'Imagine Dragons', 'alternative', 76832, 7, 10976, 34081715, 625000),
	(82, 'Iron Maiden', 'rock', 711464, 43, 16546, 5767148, 750000),
	(83, 'J Balvin', 'latin', 26614, 4, 6653, 55812985, 500000),
	(84, 'J. Cole', 'rap/trap', 547931, 35, 15655, 23014732, 125000),
	(85, 'Jack Johnson', 'folk', 332390, 35, 9497, 9885547, 425000),
	(86, 'Jake Owen', 'country', 15375, 3, 5125, 4678208, 175000),
	(87, 'James Blunt', 'alternative', 102740, 18, 5708, 9330297, 300000),
	(88, 'Janet Jackson', 'rock', 550478, 72, 7646, 4974164, 625000),
	(89, 'Jason Aldean', 'country', 457783, 38, 12047, 7170421, 750000),
	(90, 'Jay-Z', 'rap/trap', 426441, 17, 25085, 18113490, 1250000),
	(91, 'Jennifer Lopez', 'pop', 382844, 29, 13202, 15909865, 750000),
	(92, 'Jill Scott', 'pop', 81247, 15, 5416, 1155056, 300000),
	(93, 'John Mayer', 'rock', 627672, 51, 12307, 14722388, 625000),
	(94, 'JoJo', 'pop', 4917, 6, 819, 3985772, 57500),
	(95, 'JoJo Siwa', 'dance', 563441, 89, 6331, 427452, 250000),
	(96, 'Jonas Brothers', 'pop', 1035344, 74, 13991, 22798380, 750000),
	(97, 'Josh Groban', 'pop', 36496, 10, 3650, 1507015, 750000),
	(98, 'Journey', 'rock', 371481, 37, 10040, 12449450, 500000),
	(99, 'Judas Priest', 'rock', 56071, 12, 4673, 3210677, 225000),
	(100, 'Justin Timberlake', 'pop', 567049, 38, 14922, 22419577, 750000),
	(101, 'Kacey Musgraves', 'country', 10437, 8, 1305, 6276393, 400000),
	(102, 'Kanye West', 'rap/trap', 352769, 20, 17638, 34508382, 750000),
	(103, 'Katy Perry', 'pop', 1273559, 113, 11270, 36331563, 875000),
	(104, 'Keane', 'alternative', 65889, 17, 3876, 6316969, 50000),
	(105, 'Kehlani', 'R&B', 70361, 40, 1759, 14497309, 112500),
	(106, 'Keith Urban', 'country', 53754, 15, 3584, 7029770, 500000),
	(107, 'Kelly Clarkson', 'pop', 276639, 28, 9880, 14288242, 300000),
	(108, 'Kendrick Lamar', 'rap/trap', 816228, 61, 13381, 24345227, 475000),
	(109, 'Kenny Chesney', 'country', 1280183, 39, 32825, 6827865, 875000),
	(110, 'Kesha', 'pop', 15775, 7, 2254, 14592942, 200000),
	(111, 'Khalid', 'R&B', 685794, 62, 11061, 50300761, 750000),
	(112, 'KISS', 'rock', 1102981, 91, 12121, 8485745, 425000),
	(113, 'Lady Antebellum', 'country', 147818, 13, 11371, 6901707, 500000),
	(114, 'Lady Gaga', 'pop', 168958, 31, 5450, 49971769, 750000),
	(115, 'Lana Del Rey', 'alternative', 36096, 7, 5157, 16869926, 300000),
	(116, 'Laura Pausini', 'pop', 52513, 7, 7502, 5180404, 400000),
	(117, 'Lea Michele', 'pop', 9227, 5, 1845, 961349, 250000),
	(118, 'Linkin Park', 'alternative', 125460, 6, 20910, 19031253, 625000),
	(119, 'Lionel Richie', 'pop', 218044, 21, 10383, 8613955, 750000),
	(120, 'Little Big Town', 'country', 16880, 3, 5627, 3882465, 325000),
	(121, 'Little Mix', 'R&B', 412178, 40, 10304, 18132254, 225000),
	(122, 'Lorde', 'pop', 106260, 15, 7084, 12466809, 400000),
	(123, 'Luis Miguel', 'latin', 775776, 74, 10483, 8059852, 750000),
	(124, 'Luke Bryan', 'country', 642284, 38, 16902, 8325116, 875000),
	(125, 'Luke Combs', 'country', 746483, 73, 10226, 9358907, 400000),
	(126, 'Madonna', 'pop', 116875, 49, 2385, 13786027, 1000000),
	(127, 'Maluma', 'latin', 343538, 50, 6871, 27400134, 750000),
	(128, 'Marc Anthony', 'pop', 317244, 29, 10939, 7417139, 625000),
	(129, 'Mariah Carey', 'pop', 113422, 31, 3659, 12914638, 875000),
	(130, 'Marilyn Manson', 'rock', 35077, 10, 3508, 5113247, 400000),
	(131, 'Marina Diamandis', 'pop', 15791, 7, 2256, 5375633, 75000),
	(132, 'Mark Knopfler', 'rock', 612348, 82, 7468, 1614681, 400000),
	(133, 'Maroon 5', 'alternative', 397928, 21, 18949, 46415740, 425000),
	(134, 'Martina McBride', 'country', 9340, 7, 1334, 1856520, 150000),
	(135, 'Mary J. Blige', 'R&B', 10119, 3, 3373, 6780081, 625000),
	(136, 'Matchbox Twenty', 'alternative', 60855, 12, 5071, 4261221, 500000),
	(137, 'Maxwell', 'R&B', 33482, 3, 11161, 1955552, 225000),
	(138, 'Meghan Trainor', 'R&B', 41494, 8, 5187, 15585726, 400000),
	(139, 'Michael Bublé', 'pop', 1108305, 101, 10973, 8029952, 875000),
	(140, 'Miley Cyrus', 'pop', 389437, 28, 13908, 25158914, 1250000),
	(141, 'Miranda Lambert', 'country', 26949, 5, 5390, 5279098, 425000),
	(142, 'Mumford & Sons', 'folk', 919488, 72, 12771, 8148375, 300000),
	(143, 'Muse', 'alternative', 1308531, 55, 23791, 8784114, 875000),
	(144, 'My Chemical Romance', 'punk', 44749, 4, 11187, 7881945, 200000),
	(145, 'Neil Diamond', 'rock', 306055, 52, 5886, 6008896, 625000),
	(146, 'New Kids on the Block', 'pop', 653875, 55, 11889, 1494913, 625000),
	(147, 'Nick Jonas', 'pop', 190864, 16, 11929, 7052301, 400000),
	(148, 'Nickelback', 'alternative', 72279, 14, 5163, 9546549, 1000000),
	(149, 'Nicki Minaj', 'rap/trap', 393800, 31, 12703, 46800488, 400000),
	(150, 'No Doubt', 'alternative', 215362, 13, 16566, 5758149, 500000),
	(151, 'Noel Gallagher\'s High Flying Birds', 'rock', 64355, 13, 4950, 1198751, 300000),
	(152, 'Norah Jones', 'pop', 73215, 24, 3051, 5179426, 500000),
	(153, 'Olivia Newton-John', 'pop', 68597, 175, 392, 5223652, 200000),
	(154, 'Olly Murs', 'pop', 237583, 13, 18276, 5262937, 750000),
	(155, 'OneRepublic', 'alternative', 155279, 24, 6470, 32149816, 300000),
	(156, 'Panic! at the Disco', 'alternative', 379177, 27, 14044, 22068510, 500000),
	(157, 'Paramore', 'punk', 292875, 27, 10847, 9136586, 300000),
	(158, 'Pearl Jam', 'alternative', 345572, 10, 34557, 10160517, 625000),
	(159, 'Pentatonix', 'pop', 116068, 14, 8291, 3194793, 450000),
	(160, 'Pet Shop Boys', 'pop', 76587, 24, 3191, 4807761, 400000),
	(161, 'Peter Gabriel', 'rock', 429670, 43, 9992, 4000327, 750000),
	(162, 'Phil Collins', 'pop', 943113, 44, 21434, 14135565, 750000),
	(163, 'Pink', 'pop', 1816263, 68, 26710, 20856197, 1250000),
	(164, 'Pitbull', 'rap/trap', 54921, 6, 9153, 23313610, 500000),
	(165, 'Post Malone', 'rap/trap', 895671, 66, 13571, 46061688, 400000),
	(166, 'Queens of the Stone Age', 'alternative', 318175, 55, 5785, 4981888, 300000),
	(167, 'R. Kelly', 'R&B', 31925, 6, 5321, 5158815, 625000),
	(168, 'Rammstein', 'rock', 1293176, 31, 41715, 6035571, 750000),
	(169, 'Rascal Flatts', 'country', 385658, 25, 15426, 7351069, 375000),
	(170, 'Reba McEntire', 'country', 12039, 3, 4013, 1846378, 500000),
	(171, 'Red Hot Chilli Peppers', 'alternative', 800480, 58, 13801, 20129013, 875000),
	(172, 'Red Velvet', 'j-pop/k-pop', 87828, 19, 4623, 4332431, 112500),
	(173, 'Ricky Martin', 'pop', 67313, 5, 13463, 12216100, 1250000),
	(174, 'Rihanna', 'R&B', 269282, 23, 11708, 39342833, 750000),
	(175, 'Rob Thomas', 'pop', 26939, 10, 2694, 1489203, 225000),
	(176, 'Robbie Williams', 'rock', 344287, 11, 31299, 8531668, 875000),
	(177, 'Robin Thicke', 'pop', 10056, 3, 3352, 4359690, 112500),
	(178, 'Rod Stewart', 'rock', 578968, 52, 11134, 8711801, 1250000),
	(179, 'Rufus Wainwright', 'alternative', 16102, 14, 1150, 1343787, 75000),
	(180, 'Sade', 'pop', 588833, 53, 11110, 3848118, 625000),
	(181, 'Sam Smith', 'R&B', 549037, 34, 16148, 36042261, 625000),
	(182, 'Sarah Brightman', 'pop', 97002, 36, 2694, 1303669, 225000),
	(183, 'Selena Gomez & The Scene', 'pop', 121027, 15, 8068, 5525308, 625000),
	(184, 'Shakira', 'pop', 909288, 52, 17486, 28890991, 1250000),
	(185, 'Shawn Mendes', 'pop', 1315569, 105, 12529, 37095054, 375000),
	(186, 'Snow Patrol', 'rock', 164592, 11, 14963, 7546208, 750000),
	(187, 'Spice Girls', 'pop', 697357, 13, 53643, 7594689, 625000),
	(188, 'Stevie Nicks', 'rock', 441174, 48, 9191, 3602659, 500000),
	(189, 'Sting', 'rock', 339977, 19, 17894, 6943547, 750000),
	(190, 'Swedish House Mafia', 'dance', 180012, 7, 25716, 6275415, 750000),
	(191, 'Take That', 'pop', 656223, 52, 12620, 3861428, 750000),
	(192, 'Tamar Braxton', 'R&B', 4168, 3, 1389, 499016, 67500),
	(193, 'Taylor Swift', 'country', 2888916, 53, 54508, 47159635, 750000),
	(194, 'The 1975', 'rock', 44310, 2, 22155, 10738776, 500000),
	(195, 'The Band Perry', 'country', 99624, 25, 3985, 2139934, 52500),
	(196, 'The Chainsmokers', 'dance', 74433, 8, 9304, 33405865, 750000),
	(197, 'The Killers', 'rock', 400246, 31, 12911, 15072927, 750000),
	(198, 'The Lumineers', 'folk', 195258, 15, 13017, 10316716, 300000),
	(199, 'The Pretty Reckless', 'rock', 3310, 8, 414, 1542923, 45000),
	(200, 'The Rolling Stones', 'rock', 784452, 16, 49028, 20254717, 1250000),
	(201, 'The Script', 'pop', 32373, 5, 6475, 13172711, 400000),
	(202, 'The Weeknd', 'R&B', 742843, 56, 13265, 59724155, 475000),
	(203, 'Tim McGraw', 'country', 1207593, 107, 11286, 7136340, 625000),
	(204, 'Tony Bennett', 'jazz', 52237, 4, 13059, 2206649, 750000),
	(205, 'Tool', 'alternative', 520210, 39, 13339, 2584896, 300000),
	(206, 'Tori Kelly', 'pop', 17805, 8, 2226, 5149270, 225000),
	(207, 'Tove Lo', 'pop', 7851, 5, 1570, 11177918, 75000),
	(208, 'Train', 'rock', 246396, 29, 8496, 13753609, 400000),
	(209, 'Trans-Siberian Orchestra', 'rock', 1016353, 109, 9324, 91187, 750000),
	(210, 'Travis Scott', 'rap/trap', 406218, 29, 14008, 48166726, 750000),
	(211, 'Troye Sivan', 'pop', 30829, 3, 10276, 17873310, 150000),
	(212, 'Twenty One Pilots', 'alternative', 977415, 83, 11776, 17994008, 300000),
	(213, 'Usher', 'R&B', 109438, 12, 9120, 20035915, 750000),
	(214, 'Weird Al Yankovic', 'comedy music', 15033, 9, 1670, 803515, 45000),
	(215, 'Zac Brown Band', 'country', 725691, 49, 14810, 7827331, 625000),
	(216, 'Zara Larsson', 'pop', 9078, 4, 2269, 20179283, 87500),
	(217, 'Zedd', 'dance', 102349, 22, 4652, 20811551, 400000),
	(218, 'Zendaya', 'R&B', 7766, 3, 2589, 7903736, 52500),
	(219, 'ZZ Top', 'rock', 64801, 21, 3086, 6100347, 400000);
/*!40000 ALTER TABLE `artisti` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
