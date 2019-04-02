

CREATE TABLE `md_city` (
  `id` bigint(21) unsigned NOT NULL COMMENT '城市id',
  `province_id` bigint(21) DEFAULT NULL COMMENT '省id',
  `city_cname` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '城市名称',
  `short_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '城市简称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `lng` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `lat` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除：0有效；1删除',
  `creater_id` bigint(21) DEFAULT NULL COMMENT '创建者Id',
  `creater_name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者',
  `updater_id` bigint(21) DEFAULT '0' COMMENT '更新者Id',
  `updater_name` varchar(32) COLLATE utf8mb4_bin DEFAULT '' COMMENT '更新者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_province_id` (`province_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin