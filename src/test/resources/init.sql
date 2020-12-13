CREATE TABLE `t_allocated_bin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bin_id` varchar(15) NOT NULL,
  `pallet_id` varchar(15) NOT NULL,
  `material_id` varchar(15) NOT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_by` varchar(30) DEFAULT NULL,
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `active_status` varchar(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`id`)
)