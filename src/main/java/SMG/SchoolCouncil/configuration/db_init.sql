-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.15-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for SchoolCouncil
DROP database IF EXISTS `infocourse`;
CREATE DATABASE IF NOT EXISTS `infocourse` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `infocourse`;

-- Dumping structure for table SchoolCouncil.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `username` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `role` text NOT NULL DEFAULT 'Student',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `tracks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `url` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `tracks` (`id`, `name`, `url`) VALUES
(1, 'PHP', ''),
(2, 'Algorithms', ''),
(3, 'C++', 'https://github.com/TechEducationPlusPlus/Resources/tree/master/presentations/C++/README.md'),
(4, 'Python', ''),
(5, 'Java', 'https://github.com/TechEducationPlusPlus/Resources/tree/master/presentations/Java/README.md');

-- Dumping structure for table SchoolCouncil.users
CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `trackId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


INSERT INTO `courses` (`id`, `name`, `trackId`) VALUES
(1, 'PHP Fundamentals', 1),
(2, 'PHP Advanced', 1),
(3, 'C++ Fundamentals', 3),
(4, 'C++ Advanced', 3),
(5, 'Sort&amp;Find', 2),
(6, 'Graphs', 2),
(7, 'Java Fundamentals', 5),
(8, 'C++ Expert', 5);
-- Dumping structure for table SchoolCouncil.users
CREATE TABLE IF NOT EXISTS `videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `url` text NOT NULL,
  `label` text NOT NULL,
  `courseId` int(11) NOT NULL,
  `examLink` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `videos`
--

INSERT INTO `videos` (`name`, `courseId`, `sourceUrl`, `label`, `examLink`) VALUES
('Introduction to C++', '3', 'https://www.youtube.com/embed/Ot3Uxh6bZxU', 'Author: Alex Tsvetanov', '#'),
--('I/O Stream', 'C++1', '/courses/C++/videos/IO%20Stream', 'https://www.youtube.com/embed/phM0lHrmVnE', 'Alex Tsvetanov', '#'),
--('Data Types and Variables', 'C++1', '/courses/C++/videos/DataTypesVariables', 'https://www.youtube.com/embed/QCvTRpruM8E', 'Alex Tsvetanov', '#'),
--('Overflow, underflow and casting', 'C++1', '/courses/C++/videos/OverUnderCast', 'https://www.youtube.com/embed/zWMbeBmz4EU', 'Alex Tsvetanov', '#'),
--('Sort function', 'C++2', '/courses/C++/videos/sort_func', 'https://www.youtube.com/embed/okiF-XsrSWY', 'Marin Shalamanov', '#'),
--('Binary search function', 'C++2', '/courses/C++/videos/binary_search_function', 'https://www.youtube.com/embed/slk-hXnrXF0', 'Marin Shalamanov', '#'),
--('lower/upper bound', 'C++2', '/courses/C++/videos/bound_functions', 'https://www.youtube.com/embed/NJJ3CEKHySU', 'Marin Shalamanov', '#'),
--('Cube root function', 'C++2', '/courses/C++/videos/cube_root', 'https://www.youtube.com/embed/BtjdITzbvmk', 'Marin Shalamanov', '#'),
--('Workshop - sysadmin', 'C++2', '/courses/C++/videos/workshop_sysadmin', 'https://www.youtube.com/embed/vl3cAW2Kq6w', 'Marin Shalamanov', '#'),
--('Counting sort', 'SortFind', '/courses/Algorithms/videos/counting_sort', 'https://www.youtube.com/embed/wAPHExxXDjo', 'Marin Shalamanov', '#'),
--('Binary search', 'SortFind', '/courses/Algorithms/videos/binary_search', 'https://www.youtube.com/embed/cwmdfliNj5E', 'Marin Shalamanov', '#'),
--('Introduction in Graphs', 'Graphs', '/courses/Algorithms/videos/Introduction_to_Graphs', 'https://www.youtube.com/embed/wXv3VEMzEBM', 'Marin Shalamanov', '#'),
--('List of neighbours', 'Graphs', '/courses/Algorithms/videos/List_of_neighbours', 'https://www.youtube.com/embed/xqRLrrxjM-U', 'Marin Shalamanov', '#'),
--('BFS', 'Graphs', '/courses/Algorithms/videos/BFS', 'https://www.youtube.com/embed/qax90KL-lMk', 'Marin Shalamanov', '#'),
--('Min path with BFS', 'Graphs', '/courses/Algorithms/videos/Min_path_in_Graph', 'https://www.youtube.com/embed/igAboBxH4YE', 'Marin Shalamanov', '#'),
--('Welcome to TechEdu++', 'Java1', '/courses/Java1/videos/welcome', 'https://www.youtube.com/embed/M3Mr20rfr64', 'Hristo Todorov', '#'),
--('Introduction to programming', 'Java1', '/courses/Java1/videos/intro', 'https://www.youtube.com/embed/MKk3b49f1w8', 'Hristo Todorov', '#'),
--('DFS', 'Graphs', '/courses/Algorithms/videos/DFS', 'https://www.youtube.com/embed/dSqZZqjoDjA', 'Marin Shalamanov', '#'),
--('Operators and expressions', 'C++1', '/courses/C++1/videos/OperExpr', "https://www.youtube.com/embed/EN-cHRswnr4", 'Alex Tsvetanov', '#'),
--('First steps in C++', 'C++1', '/courses/C++1/videos/FirstSteps', "#", 'Alex Tsvetanov', 'https://judge.techedu.bg/contests/6b72925241b2220253204adfde3556af'),
--('char, Ascii table', 'C++1', '/courses/C++1/videos/chars', "https://www.youtube.com/embed/OHPCq9Mgb0I", 'Alex Tsvetanov', '#'),
--('if-else', 'C++1', '/courses/C++1/videos/if-else', "https://www.youtube.com/embed/rhOW_IkbUY4", 'Alex Tsvetanov', '#'),
--('switch-case', 'C++1', '/courses/C++1/videos/switch-case', 'https://www.youtube.com/embed/LrgWAXps1C0', 'Alex Tsvetanov', '#'),
--('Introduction to loops', 'C++1', '/courses/C++1/videos/LoopsInto', "https://www.youtube.com/embed/_4Zr66NdjKQ", 'Dobrin Bashev', '#'),
--('For, While, Do-while loops', 'C++1', '/courses/C++1/videos/LoopsOperators', "https://www.youtube.com/embed/LZLg2fxbw0s", 'Dobrin Bashev', '#'),
--('Nested loops, break/continue', 'C++1', '/courses/C++1/videos/NestedLoops', "https://www.youtube.com/embed/tLhyoOlhC2E", 'Dobrin Bashev', '#'),
('Loops workshop', '3', 'https://www.youtube.com/embed/WhCTwXYOF3M', 'Author: Dobrin Bashev', 'http://SchoolCouncil.SMG.bg/contests/ProgrammingBasics5') ,
('Loops workshop', '3', '#', 'Author: Dobrin Bashev', 'http://SchoolCouncil.SMG.bg/contests/ProgrammingBasics5') ;--,
--('Arrays', 'C++1', '/courses/C++1/videos/Arrays', "https://www.youtube.com/embed/qXjmAjJraWM", 'Alex Tsvetanov', '#'),
--('Pointers', 'C++2', '/courses/C++/videos/Pointers', 'https://www.youtube.com/embed/M51p8Rs_4ls', 'Alex Tsvetanov', '#')
--;


CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL AUTO_INCREMENT,
  `video` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `time` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
