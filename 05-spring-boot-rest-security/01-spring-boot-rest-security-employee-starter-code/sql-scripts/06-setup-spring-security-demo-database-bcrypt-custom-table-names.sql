USE `TypeTeam`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(75) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `members`
VALUES
('bluu','{bcrypt}$2a$12$Lz/mcYZHc1D5kl1VaTYJouop8O/.MQvMRp2pexvZuY8v1cm9n55qu', 1),
('test','{bcrypt}$2a$12$HOGVXlx090ksYZx5IjB/XuD752mpjkx2XZf7A0zT.7nkBlZvNtnvC', 1);


CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `roles`
VALUES
('bluu','USER'),
('test','USER')

