CREATE TABLE `transferencia` (
  `id` int NOT NULL,
  `valor` double NOT NULL,
  `dt_transferencia` datetime(6) NOT NULL,
  `titular` varchar(255) DEFAULT NULL,
  `dt_agendamento` datetime(6) DEFAULT NULL,
  `taxa` double DEFAULT NULL,
  `taxa_fixa` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `id_conta_origem` int NOT NULL,
  `id_conta_destino` int NOT NULL,
  `efetuado` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;