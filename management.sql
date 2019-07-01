-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2019-07-01 21:03:29
-- 服务器版本： 5.5.57-log
-- PHP Version: 5.4.45

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `management`
--

DELIMITER $$
--
-- 函数
--
CREATE DEFINER=`management`@`%` FUNCTION `doneTime`(userId VARCHAR(16),courseId VARCHAR(8)) RETURNS int(11)
BEGIN
    DECLARE dTime int DEFAULT 0;
    IF 
    (SELECT sum(willtime) FROM schedule
    WHERE 
    schedule.upost=(SELECT upost FROM UserInformation WHERE uid=userId) 
    AND cid=courseId) 
    THEN SET dTime=
    (SELECT sum(willtime) FROM schedule
    WHERE 
    schedule.upost=(SELECT upost FROM UserInformation WHERE uid=userId) 
    AND cid=courseId);
    END IF;

    IF 
    (SELECT sum(remedialtime) FROM remedial 
    WHERE uid=userId AND cid=courseId AND remedialflag=false)
    THEN SET dTime=dTime-(SELECT sum(remedialtime) FROM remedial 
    WHERE uid=userId AND cid=courseId AND remedialflag=false);
    END IF;
    RETURN dTime;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `sum_remedialtime`(`userID` VARCHAR(16), `courseID` VARCHAR(8)) RETURNS int(11)
    NO SQL
BEGIN 
	
    DECLARE sumtime int DEFAULT 0;
    DECLARE defaultvalue int DEFAULT 0;
   	IF (
    	SELECT SUM(remedialtime) FROM remedial WHERE uid=userID AND cid=courseID
    ) IS NOT NULL
    THEN 
 	 SET sumtime=(
    	SELECT SUM(remedialtime) FROM remedial WHERE uid=userID AND cid=courseID
    );
    END IF;
    RETURN sumtime;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `sum_studytime`(`uid` VARCHAR(16), `upost` VARCHAR(8), `cid` VARCHAR(8)) RETURNS int(11)
    NO SQL
BEGIN
	DECLARE sumtime int DEFAULT 0;   
   SELECT sum_willtime(upost,cid)-sum_remedialtime(uid,cid) INTO sumtime;
   RETURN sumtime;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `sum_willtime`(`userPost` VARCHAR(8), `courseID` VARCHAR(8)) RETURNS int(11)
    NO SQL
BEGIN
    DECLARE sumtime int DEFAULT 0;
    IF (
SELECT SUM(willtime) FROM schedule WHERE upost=userPost AND cid=courseID
    ) IS NOT NULL
    THEN SET sumtime=
(SELECT SUM(willtime) FROM schedule WHERE upost=userPost AND cid=courseID);
END IF;
    RETURN sumtime;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `CourseInformation`
--

CREATE TABLE IF NOT EXISTS `CourseInformation` (
  `cid` varchar(8) NOT NULL,
  `cname` varchar(16) NOT NULL,
  `ctime` int(11) NOT NULL DEFAULT '0',
  `sid` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 触发器 `CourseInformation`
--
DELIMITER $$
CREATE TRIGGER `tri_delete_course` AFTER DELETE ON `CourseInformation`
 FOR EACH ROW BEGIN
UPDATE SubjectInformation
SET stime=(SELECT sum(ctime) FROM CourseInformation WHERE sid=old.sid)
WHERE sid=old.sid;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tri_insert_course` AFTER INSERT ON `CourseInformation`
 FOR EACH ROW UPDATE SubjectInformation
SET stime=(SELECT sum(ctime) FROM CourseInformation WHERE sid=new.sid)
WHERE sid=new.sid
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `tri_update_course` AFTER UPDATE ON `CourseInformation`
 FOR EACH ROW UPDATE SubjectInformation
SET stime=(SELECT sum(ctime) FROM CourseInformation WHERE sid=old.sid)
WHERE sid=old.sid
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- 表的结构 `DatabaseInformation`
--

CREATE TABLE IF NOT EXISTS `DatabaseInformation` (
  `dno` int(11) NOT NULL,
  `user` varchar(64) NOT NULL,
  `url` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `remedial`
--

CREATE TABLE IF NOT EXISTS `remedial` (
  `uid` varchar(16) NOT NULL,
  `cid` varchar(8) NOT NULL,
  `remedialsc_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `remedialtime` int(11) NOT NULL,
  `remedialflag` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `schedule`
--

CREATE TABLE IF NOT EXISTS `schedule` (
  `upost` varchar(11) NOT NULL,
  `cid` varchar(8) NOT NULL,
  `sc_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `willtime` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 替换视图以便查看 `study`
--
CREATE TABLE IF NOT EXISTS `study` (
`uname` varchar(16)
,`cname` varchar(16)
,`studytime` int(11)
);

-- --------------------------------------------------------

--
-- 表的结构 `SubjectInformation`
--

CREATE TABLE IF NOT EXISTS `SubjectInformation` (
  `sid` varchar(8) NOT NULL,
  `sname` varchar(16) NOT NULL,
  `stime` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `UserInformation`
--

CREATE TABLE IF NOT EXISTS `UserInformation` (
  `uid` varchar(16) NOT NULL,
  `upassword` varchar(16) NOT NULL,
  `uname` varchar(16) NOT NULL DEFAULT 'none',
  `utoken` varchar(32) NOT NULL DEFAULT 'none',
  `umodel` varchar(16) NOT NULL DEFAULT '学员',
  `uphone` varchar(11) DEFAULT 'none',
  `upost` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `UserInformation`
--

INSERT INTO `UserInformation` (`uid`, `upassword`, `uname`, `utoken`, `umodel`, `uphone`, `upost`) VALUES
('1120259135', '123', '测试员', 'r7w61ek9SVhgBZcNNBXb3cAD4Dck65BY', '学员', '176', '岗前'),
('3084233184', '123', '测试员2', 'RQtU8MAUV9kX7V0dLpLH9INWfrw82069', '学员', '176', '初级'),
('admin', 'tjzhiclasting', '管理员', 'tjzhc_lasting_copyright', '管理员', '管理员', '管理员');

-- --------------------------------------------------------

--
-- 视图结构 `study`
--
DROP TABLE IF EXISTS `study`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `study` AS select distinct `UserInformation`.`uname` AS `uname`,`CourseInformation`.`cname` AS `cname`,`sum_studytime`(`UserInformation`.`uid`,`UserInformation`.`upost`,`schedule`.`cid`) AS `studytime` from ((`UserInformation` join `CourseInformation`) join `schedule`) where ((`CourseInformation`.`cid` = `schedule`.`cid`) and (`UserInformation`.`uid` <> 'admin'));

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CourseInformation`
--
ALTER TABLE `CourseInformation`
  ADD PRIMARY KEY (`cid`),
  ADD UNIQUE KEY `cname` (`cname`),
  ADD UNIQUE KEY `cid` (`cid`),
  ADD KEY `course_sid` (`sid`);

--
-- Indexes for table `DatabaseInformation`
--
ALTER TABLE `DatabaseInformation`
  ADD PRIMARY KEY (`dno`);

--
-- Indexes for table `remedial`
--
ALTER TABLE `remedial`
  ADD PRIMARY KEY (`uid`,`cid`,`remedialsc_date`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`upost`,`cid`,`sc_date`),
  ADD KEY `cid` (`cid`);

--
-- Indexes for table `SubjectInformation`
--
ALTER TABLE `SubjectInformation`
  ADD PRIMARY KEY (`sid`),
  ADD UNIQUE KEY `sname` (`sname`);

--
-- Indexes for table `UserInformation`
--
ALTER TABLE `UserInformation`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `uname` (`uname`);

--
-- 限制导出的表
--

--
-- 限制表 `CourseInformation`
--
ALTER TABLE `CourseInformation`
  ADD CONSTRAINT `course_sid` FOREIGN KEY (`sid`) REFERENCES `SubjectInformation` (`sid`);

--
-- 限制表 `remedial`
--
ALTER TABLE `remedial`
  ADD CONSTRAINT `remedial_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `schedule` (`cid`),
  ADD CONSTRAINT `remedial_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `UserInformation` (`uid`);

--
-- 限制表 `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `CourseInformation` (`cid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
