CREATE TABLE `club` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `description` varchar(500) DEFAULT NULL,
  `address_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `club_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `coach_availability` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `start_hour` int(11) NOT NULL,
  `end_hour` int(11) NOT NULL,
  `coach_sports_mapping_id` int(11) NOT NULL,
  `initial_availability` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `current_availability` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `coach_sports_mapping_id` (`coach_sports_mapping_id`),
  CONSTRAINT `coach_availability_ibfk_1` FOREIGN KEY (`coach_sports_mapping_id`) REFERENCES `coach_sports_mapping` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


-- Create syntax for TABLE 'coach_booking'
CREATE TABLE `coach_booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `player_id` int(11) NOT NULL,
  `coach_availability_id` int(11) NOT NULL,
  `is_coach_visiting` tinyint(1) NOT NULL,
  `address` varchar(45) NOT NULL DEFAULT '',
  `group_booking` tinyint(1) NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT '',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `player_id` (`player_id`),
  KEY `coach_availability_id` (`coach_availability_id`),
  CONSTRAINT `coach_booking_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `user` (`id`),
  CONSTRAINT `coach_booking_ibfk_2` FOREIGN KEY (`coach_availability_id`) REFERENCES `coach_availability` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- Create syntax for TABLE 'coach_interest_mapping'
CREATE TABLE `coach_interest_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` int(45) NOT NULL,
  `interest_id` int(45) NOT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `experience` varchar(45) DEFAULT NULL,
  `group_fee` varchar(45) DEFAULT NULL,
  `fee` varchar(45) DEFAULT NULL,
  `max_player_per_group` int(11) DEFAULT NULL,
  `coach_can_visit` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `interest_id` (`interest_id`),
  CONSTRAINT `coach_interest_mapping_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `coach_interest_mapping_ibfk_2` FOREIGN KEY (`interest_id`) REFERENCES `interest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- Create syntax for TABLE 'coach_interest_club_mapping'
CREATE TABLE `coach_interest_club_mapping` (
  `coach_interest_mapping_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  KEY `club_id` (`club_id`),
  KEY `coach_interest_mapping_id` (`coach_interest_mapping_id`),
  CONSTRAINT `coach_interest_club_mapping_ibfk_2` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `coach_interest_club_mapping_ibfk_3` FOREIGN KEY (`coach_interest_mapping_id`) REFERENCES `coach_interest_mapping` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Create syntax for TABLE 'coach_review_rating'
CREATE TABLE `coach_review_rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coach_sports_mapping_id` int(11) NOT NULL,
  `review` varchar(500) NOT NULL DEFAULT '',
  `rating` double NOT NULL,
  `player_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `coach_sports_mapping_id` (`coach_sports_mapping_id`),
  KEY `player_id` (`player_id`),
  CONSTRAINT `coach_review_rating_ibfk_1` FOREIGN KEY (`coach_sports_mapping_id`) REFERENCES `coach_sports_mapping` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `coach_review_rating_ibfk_2` FOREIGN KEY (`player_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- Create syntax for TABLE 'coach_sports_club_mapping'
CREATE TABLE `coach_sports_club_mapping` (
  `coach_sports_mapping_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  KEY `coach_sports_mapping_id` (`coach_sports_mapping_id`),
  KEY `club_id` (`club_id`),
  CONSTRAINT `coach_sports_club_mapping_ibfk_1` FOREIGN KEY (`coach_sports_mapping_id`) REFERENCES `coach_sports_mapping` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `coach_sports_club_mapping_ibfk_2` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Create syntax for TABLE 'coach_sports_mapping'
CREATE TABLE `coach_sports_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `sports_id` int(11) NOT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `experience` varchar(45) DEFAULT NULL,
  `fee` varchar(45) DEFAULT NULL,
  `group_fee` varchar(45) DEFAULT NULL,
  `max_player_per_group` int(11) DEFAULT NULL,
  `coach_can_visit` tinyint(11) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `sports_id` (`sports_id`),
  CONSTRAINT `coach_sports_mapping_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `coach_sports_mapping_ibfk_2` FOREIGN KEY (`sports_id`) REFERENCES `sports` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

