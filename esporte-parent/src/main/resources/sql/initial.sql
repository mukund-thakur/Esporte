-- Create syntax for TABLE 'address'
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `locality` varchar(45) DEFAULT NULL,
  `sublocality` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `landmark` varchar(45) DEFAULT NULL,
  `coordinates` varchar(200) DEFAULT NULL,
  `address_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'email'
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `provider` varchar(45) DEFAULT NULL,
  `email_type` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'image'
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `image_url` varchar(45) DEFAULT NULL,
  `imaze_size` varchar(45) DEFAULT NULL,
  `image_bytes` blob,
  `image_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'interest'
CREATE TABLE `interest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `score` int(3) DEFAULT NULL,
  `priority` int(2) DEFAULT NULL,
  `interest_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'phone_details'
CREATE TABLE `phone_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imei_code` varchar(100) DEFAULT NULL,
  `gcm_id` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'phone_number'
CREATE TABLE `phone_number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `country_code` varchar(10) DEFAULT NULL,
  `number` varchar(45) NOT NULL,
  `provider` varchar(45) DEFAULT NULL,
  `phone_number_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'player_sports_mapping'
CREATE TABLE `player_sports_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `sports_id` int(11) NOT NULL,
  `has_venue` int(2) NOT NULL,
  `has_kit` int(2) NOT NULL,
  `has_extra_kit` int(2) NOT NULL,
  `start_level` int(2) NOT NULL,
  `current_level` int(2) NOT NULL,
  `ranking` varchar(45) DEFAULT '',
  `total_credit` int(11) DEFAULT NULL,
  `credit_remaining` int(11) DEFAULT NULL,
  `credit_used` int(11) DEFAULT NULL,
  `seeding` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_player_sport` (`user_id`,`sports_id`),
  KEY `id_idx` (`user_id`),
  KEY `id_idx1` (`sports_id`),
  CONSTRAINT `fk_player` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sports` FOREIGN KEY (`sports_id`) REFERENCES `sports` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'sports'
CREATE TABLE `sports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sports_type` varchar(45) NOT NULL DEFAULT '',
  `number_teams` int(2) DEFAULT NULL,
  `num_players` int(2) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user'
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `gender` int(1) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT '',
  `username` varchar(100) DEFAULT '',
  `password` varchar(500) DEFAULT '',
  `user_type` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user_address_mapping'
CREATE TABLE `user_address_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`user_id`),
  KEY `id_idx1` (`address_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_adderes` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user_email_mapping'
CREATE TABLE `user_email_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `email_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`user_id`,`email_id`),
  KEY `fk_user_email` (`email_id`),
  CONSTRAINT `fk_user_email` FOREIGN KEY (`email_id`) REFERENCES `email` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user_image_mapping'
CREATE TABLE `user_image_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`user_id`),
  KEY `id_idx1` (`image_id`),
  CONSTRAINT `fk_image_m` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_m` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user_interest_mapping'
CREATE TABLE `user_interest_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `interest_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`user_id`),
  KEY `id_idx1` (`interest_id`),
  CONSTRAINT `fk_user_in` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_map` FOREIGN KEY (`interest_id`) REFERENCES `interest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user_phone_details_mapping'
CREATE TABLE `user_phone_details_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `phone_details_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_ph` (`user_id`),
  KEY `phone_details_id` (`phone_details_id`),
  CONSTRAINT `fk_user_ph` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_phone_details_mapping_ibfk_1` FOREIGN KEY (`phone_details_id`) REFERENCES `phone_details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Create syntax for TABLE 'user_phone_number_mapping'
CREATE TABLE `user_phone_number_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `phone_number_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`user_id`),
  KEY `id_idx1` (`phone_number_id`),
  CONSTRAINT `fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk1` FOREIGN KEY (`phone_number_id`) REFERENCES `phone_number` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;