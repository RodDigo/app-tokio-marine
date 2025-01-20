-- estudo_db.conta definition

CREATE TABLE `conta` (
  `id` int NOT NULL,
  `titular` varchar(255) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;