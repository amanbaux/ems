package in.ems.utils;

public class SQLUtils {

    // Tables
    private static String materialTable = "t_alloc_material";

    private static String materialMasterTable = "material_master";
    private static String archiveMaterialTable = "arc_material";
    private static String allocatedBinTable = "t_allocated_bin";
    private static String subBinTable = "m_sub_bin";
    private static String aisleTable = "m_aisle";
    private static String txnTable = "txn_log";

    public static String INSERT_MATERIAL = "INSERT INTO " + materialTable
            + " (material_id, box_id, prod_date, mat_weight,  mat_status, created_by, created_date, updated_by, updated_date, active_status,bin_id,pallet_id,notes , packing_type,carton_type,glaze,plant_code,reason) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?)";

    public static String PALLET_VERIFICATION = "SELECT COUNT(*) FROM t_alloc_material WHERE pallet_id = ?";

    public static String CHECK_EMPTY_AISLE = "SELECT count(*) from " + aisleTable + " where last_bin < :maxLastBin";

    public static String CHECK_ALL_EMPTY_BINS = "select count(*) from " + allocatedBinTable;

    public static String FETCH_FIRST_BIN_ID = "select bin_id from " + subBinTable + " where is_empty = 'Y' and active_status = 'Y' and is_locked='N' order by bin_id limit 1";

    public static String FETCH_BIN_FOR_MATCHING_MATERIAL = "select\r\n"
            + "	distinct m_bin.bin_id\r\n"
            + "from\r\n"
            + "	" + allocatedBinTable + " as t_alloc\r\n"
            + "	right join\r\n"
            + "	" + subBinTable + " as m_bin\r\n"
            + "	on\r\n"
            + "	substring(m_bin.bin_id, 1, 5) = substring(t_alloc.bin_id, 1, 5)\r\n"
            + "where\r\n"
            + "	t_alloc.material_id = :allocatedMaterialId\r\n"
            + "	and m_bin.is_empty = 'Y'\r\n"
            + "	and m_bin.is_locked = 'N'\r\n"
            + "	and m_bin.curr_bin_capacity + :newMaterialWeight <= :maxBinCapacity\r\n"
            + "	and (select count(distinct material_id) from " + allocatedBinTable + " as alloc where alloc.bin_id = m_bin.bin_id) < :maxBinUniqueAllowedCount\r\n"
            + "	limit 1;";

    public static String FETCH_EMPTY_AISLE_ID = "select"
            + " m_bin.bin_id as bin_id "
            + "from "
            + aisleTable + " as aisle, " + subBinTable
            + " as m_bin where 										\n"
            + "	aisle.last_bin = 0									\n"
            + "	and aisle.aisle_id = substring(m_bin.bin_id, 1, 5)	\n"
            + " and m_bin.is_locked = 'N'							\n"
            + "order by bin_id limit 1";

    public static String FETCH_BIN_ID_WITH_UNIQUE_MATERIAL_COUNT = "select\r\n"
            + "	distinct m_bin.bin_id\r\n"
            + "from\r\n"
            + "	" + allocatedBinTable + " as t_alloc\r\n"
            + "	right join\r\n"
            + "	" + subBinTable + " as m_bin\r\n"
            + "	on\r\n"
            + "	substring(m_bin.bin_id, 1, 5) = substring(t_alloc.bin_id, 1, 5)\r\n"
            + "where\r\n"
            + "	m_bin.is_empty = 'Y'\r\n"
            + "	and m_bin.is_locked = 'N'\r\n"
            + "	and m_bin.curr_bin_capacity + :newMaterialWeight <= :maxBinCapacity\r\n"
            + "	and (select count(distinct material_id) from " + allocatedBinTable + " as alloc where alloc.bin_id = m_bin.bin_id) < :maxBinUniqueAllowedCount\r\n"
            + "	limit 1;";

    public static String LOCK_UNLOCK_BIN = "update " + subBinTable + " set is_locked=:lockedStatus, updated_date=now(), updated_by=:updatedBy where bin_id=:bin_id";

    public static String INSERT_ALLOCATION_BIN = "insert into " + allocatedBinTable + " (id, bin_id, pallet_id, material_id, created_by, created_date, updated_by, updated_date, active_status)\r\n"
            + "values (?, ?, ?, ?, ?, now(), ?, now(), 'Y')";

    public static String SELECT_LAST_BIN = "select last_bin from " + aisleTable + " where aisle_id=?";

    public static String UPDATE_AISLE_STATUS = "update " + aisleTable + " set is_empty=:isEmpty, last_bin=:lastBin, updated_by=:updatedBy, updated_date=now() where aisle_id=:aisleId";

    public static String UPDATE_MASTER_BIN = "update \n"
            + "	m_sub_bin \n"
            + "set \n"
            + "	is_empty= :isEmpty, \n"
            + "    curr_bin_capacity=:newMaterialWeight,\n"
            + "    updated_date = now(),\n"
            + "    updated_by = :updatedBy,\n"
            + "    is_locked = 'N' where \n"
            + "    bin_id = :bin_id;";

    public static String SELECT_ALL_MATERIALS = "select material.material_id, material.mat_name, material.mat_desc, material.mat_grade, material.mat_weight, material.mat_uom, material.mat_height, material.mat_diameter, allocated_bin.bin_id, allocated_bin.pallet_id, substring(allocated_bin.bin_id, 1, 5) as aisle_id\r\n"
            + "from\r\n"
            + "	" + materialTable + " as material,\r\n"
            + "	" + allocatedBinTable + " as allocated_bin\r\n"
            + "where\r\n"
            + "	allocated_bin.material_id = material.material_id and allocated_bin.id = material.id;";

    public static String SAVE_TXN = "INSERT INTO " + txnTable
            + " (userid,txn_type,incomming_request,response,created_by,created_date) VALUES (?, ?, ?, ?, ?, now())";

    public static String FETCH_ALLOCATED_MATERIALS_FROM_BIN = "select "
            + "t_alloc.material_id, material.mat_name, material.mat_grade\r\n"
            + "from\r\n"
            + "	" + allocatedBinTable + " as t_alloc,\r\n"
            + "	" + materialTable + " as material\r\n"
            + "where\r\n"
            + "	t_alloc.material_id = material.material_id and t_alloc.mat_grade = material.mat_grade and t_alloc.id = material.id";

    public static String FETCH_REQUESTED_MATERIAL_BIN_DETAILS = "select\n"
            + "	alocMat.id as allocationId,\n"
            + "	alocMat.mat_weight as mat_weight,\n"
            + "       alocMat.bin_id as bin_id,\n"
            + "       alocMat.box_id box_id,\n"
            + "       alocMat.pallet_id as pallet_id\n"
            + "from\n"
            + "	t_alloc_material as alocMat\n"
            + "where \n"
            + "alocMat.material_id =:" + CommonConstants.MATERIAL_ID_PARAM + "\n"
            + "having (\n"
            + "	select sum(mat_weight) from t_alloc_material where material_id=:" + CommonConstants.MATERIAL_ID_PARAM + " group by  \n"
            + "			material_id\n"
            + ") >= :" + CommonConstants.REQUESTED_MATERIAL_WEIGHT_PARAM + " order by updated_date asc;";

    public static String DELETE_ALLOCATED_MATERIAL = "delete from " + allocatedBinTable + " where id = :id";

    public static String SET_ALLOCATED_BIN_EMPTY = "update " + subBinTable + " set is_empty='Y' where bin_id = :binId ";

    public static String UPDATE_AISLE_INVENTORY_STATE = "update " + aisleTable + "\r\n"
            + "set\r\n"
            + "	last_bin=last_bin-1, is_empty='Y'\r\n"
            + "where\r\n"
            + "	aisle_id = :aisleId\r\n"
            + "	and last_bin >= 1";

    public static String ARCHIVE_PICKED_MATERIAL = "insert into \n"
            + "	arc_material(id,bin_id,material_id,box_id,pallet_id,prod_date,mat_height,mat_weight,mat_diameter,mat_status,created_by,created_date,updated_by,updated_date,active_status,packing_type,carton_type,glaze,inb_reason) \n"
            + "(  \n"
            + "	select  \n"
            + "		id,bin_id,material_id,box_id,pallet_id,prod_date,mat_height,mat_weight,mat_diameter,mat_status,created_by,created_date,updated_by,updated_date,active_status,packing_type,carton_type,glaze,reason  \n"
            + "	from  \n"
            + "		t_alloc_material  \n"
            + "	where id =:id);";

    public static String DELETE_PICKED_MATERIAL = "delete from " + materialTable + "\r\n"
            + "where id =:id ";

    public static String FETCH_LOCKED_BINS_EXCEEDING_MAX_LOCKED_TIME = "select bin_id from " + subBinTable + " where timestampdiff(minute, updated_date, now()) >= :maxLockedTime and is_locked='Y' and active_status='Y' ";

    public static String BATCH_UNLOCKED_BINS = "update " + subBinTable + " set is_locked='N', updated_date=now(), updated_by=:updatedBy where bin_id in (:binIds)";

    public static String SAVE_MATERIAL_MASTER = "INSERT INTO material_master (material_id,mat_name,sub_mat_name,packing_type,grade,created_by,updated_by,uom,glaze, mat_mov_type, carton_type) VALUES (?, ?, ?, ?, ?, ? ,? ,?, ?, ?,?)";

    public static String FETCH_MATERIAL_MASTER = "select \n"
            + "	mm.material_id,\n"
            + "    mm.mat_name,\n"
            + "    mm.sub_mat_name,\n"
            + "    mm.packing_type,\n"
            + "    mm.grade\n"
            + "from \n"
            + "material_master as mm\n"
            + "where\n"
            + "active_status='Y';";

    public static String SELECT_MATERIALS_MASTER_NAME = "select \n"
            + "	distinct mat_name\n"
            + "from\n"
            + "	material_master\n"
            + "where\n"
            + "active_status='Y';";

    public static String SELECT_MATERIALS_MASTER_SUB_NAME = "select \n"
            + "	distinct sub_mat_name \n"
            + "from\n"
            + "	material_master\n"
            + "where\n"
            + "active_status='Y'\n"
            + "and mat_name=:matName ;";

    public static String SELECT_MATERIALS_MASTER_DETAILS = "select \n"
            + "	distinct grade \n"
            + "from\n"
            + "	material_master\n"
            + "where\n"
            + "active_status='Y'\n"
            + "and mat_name=:matName \n"
            + "and sub_mat_name=:subName ;";
    
    public static String SELECT_MATERIALS_MASTER_DETAILS_WITH_GRADE = "select \n"
            + " distinct packing_type \n"
            + "from\n"
            + "	material_master\n"
            + "where\n"
            + "active_status='Y'\n"
            + "and mat_name=:matName \n"
            + "and grade=:matGrade \n"
            + "and sub_mat_name=:subName ;";

    public static String SELECT_CURRENT_WEIGHT_OF_BIN = "select curr_bin_capacity from m_sub_bin where bin_id=?";

    public static String MAT_WEIGHT_FROM_MAT_ID = "select mat_weight from t_material where id =:id;";

    public static String MAT_COUNT_IN_BIN = "select \n"
            + "	count(*) from " + allocatedBinTable + " \n"
            + "where\n"
            + "bin_id = :bin_id ;";

    public static String UPDATE_AISLE_INVENTORY_ONLY_EMPTY = "update " + aisleTable + "\r\n"
            + "set\r\n"
            + "	is_empty='Y'\r\n"
            + "where\r\n"
            + "	aisle_id = :aisleId\r\n"
            + "	and last_bin >= 1";
    public static String UPDATE_CURR_WEIGHT_BIN = "update m_sub_bin set is_empty='Y',curr_bin_capacity=(\n"
            + "select \n"
            + "	coalesce(SUM(mat.mat_weight),0) \n"
            + "from \n"
            + "	t_allocated_bin as alloc,\n"
            + "    t_material as mat\n"
            + "where \n"
            + "	alloc.id=mat.id\n"
            + "    and alloc.bin_id =:binId\n"
            + ") where bin_id = :binId ";

    public static String GET_NEXT_AISLE_NO = "select aisle_id from m_aisle where block=? order by aisle_id desc limit 1;";

    public static String SAVE_AISLE_MASTER = "insert into m_aisle(aisle_id,is_empty,unique_sku_count,last_bin,created_by,updated_by,active_status,block, mat_mov_type) \n"
            + "                                           value(?,?,?,?,?,?,?,?,?);";

    public static String SAVE_BIN_MASTER = "insert into m_sub_bin(bin_id,is_empty,pos_x,pos_y,pos_z,is_locked,curr_bin_capacity,created_by,updated_by,active_status,bin_capacity)\n"
            + "                               values(?,?,?,?,?,?,?,?,?,?,?)";

    public static String FETCH_ALL_AISLE = "select aisle_id,is_empty,unique_sku_count,last_bin,block,active_status, mat_mov_type from " + aisleTable;

    public static String FETCH_ALL_MATERIALMASTER = "select * from " + materialMasterTable + " ORDER BY id DESC LIMIT :offset,:limit";

    public static String FETCH_ALL_ALLOCEDMATERIAL = "SELECT\n"
            + "	material_master.*,SUM(mat_weight) as total_weight\n"
            + "FROM\n"
            + "	material_master INNER JOIN t_alloc_material\n"
            + "ON\n"
            + "	t_alloc_material.material_id = material_master.material_id "
            + " where t_alloc_material.active_status = 'Y' \n"
            + "GROUP BY\n"
            + "	material_id\n"
            + "ORDER BY\n"
            + "	id DESC\n"
            + "LIMIT :offset,:limit";

    public static String FETCH_CURRENT_ALLOC = "select \n"
            + "	id,bin_id,material_id,box_id,pallet_id,prod_date,mat_height,mat_weight,mat_diameter,mat_status,notes,packing_type,glaze,carton_type\n"
            + "from \n"
            + "	t_alloc_material \n"
            + "where \n"
            + "	material_id=:materialId "
            + " and active_status='Y';";

    public static String FETCH_ALL_BIN_FROM_AISLE = "select bin_id,is_empty,pos_x,pos_y,pos_z,is_locked,curr_bin_capacity,active_status,bin_capacity from m_sub_bin  where substr(bin_id,1,5)= :aisleId;";

    public static String UPDATE_AISLE = "update m_aisle set unique_sku_count=:uniqieSKUCount, active_status=:isActive, is_empty=:isEmpty,mat_mov_type=:matMovType where aisle_id=:aisleId;";

    public static String GET_MAT_COUNT_IN_BIN = "select count(*) from t_allocated_bin where substring(bin_id, 1, 5)=?;";

    public static String UPDATE_BIN = "update m_sub_bin set bin_capacity=:binCapacity, active_status=:isActive, is_locked=:lockedStatus,is_empty=:isEmpty where bin_id=:bin_id;";

    public static String UPDATE_LOCK_SUBSEQUENT_BIN = "update m_sub_bin set  is_locked=:lockedStatus where bin_id like  :aisleId  and bin_id > :bin_id";

    public static String GET_MAT_IN_BIN = "select count(*) from t_allocated_bin where bin_id=?";

//    public static String GET_BIN_ID_FROM_EQUAL_UNIQUE_MAT_COUNT = "select\n"
//            + "    bin.bin_id\n"
//            + "from\n"
//            + "	m_aisle as aisle,\n"
//            + "    m_sub_bin as bin\n"
//            + "where\n"
//            + "	aisle.aisle_id= substring(bin.bin_id, 1, 5)\n"
//            + "    and aisle.unique_sku_count = :uniqueMatCount\n"
//            + "    and aisle.is_empty='Y'\n"
//            + "    and aisle.active_status='Y'\n"
//            + "    and bin.is_empty='Y'\n"
//            + "    and bin.active_status='Y' \n"
//            + "order by aisle_id limit 1;";
    
     public static String GET_BIN_ID_FROM_EQUAL_UNIQUE_MAT_COUNT = "select\n"
            + "    bin.bin_id\n"
            + "from\n"
            + "	m_aisle as aisle,\n"
            + "    m_sub_bin as bin\n"
            + "where\n"
            + "	aisle.aisle_id= substring(bin.bin_id, 1, 5)\n"
            + "    and aisle.mat_mov_type = :matMovType\n"
            + "    and aisle.is_empty='Y'\n"
            + "    and aisle.active_status='Y'\n"
            + "    and bin.is_empty='Y'\n"
            + "    and bin.active_status='Y' \n"
            + "order by aisle_id limit 1;";

    public static String GET_BIN_ID_FROM_LESS_UNIQUE_MAT_COUNT = "select\n"
            + "    bin.bin_id\n"
            + "from\n"
            + "	m_aisle as aisle,\n"
            + "    m_sub_bin as bin\n"
            + "where\n"
            + "	aisle.aisle_id= substring(bin.bin_id, 1, 5)\n"
            + "    and aisle.unique_sku_count < :uniqueMatCount\n"
            + "    and aisle.is_empty='Y'\n"
            + "    and aisle.active_status='Y'\n"
            + "    and bin.is_empty='Y'\n"
            + "    and bin.active_status='Y' \n"
            + "order by aisle_id limit 1;";

    public static String GET_BIN_ID_FROM_GREATER_UNIQUE_MAT_COUNT = "select\n"
            + "    bin.bin_id\n"
            + "from\n"
            + "	m_aisle as aisle,\n"
            + "    m_sub_bin as bin\n"
            + "where\n"
            + "	aisle.aisle_id= substring(bin.bin_id, 1, 5)\n"
            + "    and aisle.unique_sku_count > :uniqueMatCount\n"
            + "    and aisle.is_empty='Y'\n"
            + "    and aisle.active_status='Y'\n"
            + "    and bin.is_empty='Y'\n"
            + "    and bin.active_status='Y' \n"
            + "order by aisle_id limit 1;";

    public static String CHECK_FOR_EMPTY_ALLOCATION = "select count(*) from " + allocatedBinTable + " where bin_id=?";

    public static String GET_MAT_COUNT_IN_MATERIAL = "select count(*) from material_master where material_id=?";

    public static String UPDATE_MATERIAL_MASTER = "update\n"
            + "	material_master\n"
            + "set\n"
            + "	mat_name=:matName,sub_mat_name=:subName,packing_type=:packingType,grade=:matGrade,uom=:uom,glaze=:glaze, carton_type=:cartonType, mat_mov_type=:matMovType \n"
            + "where\n"
            + "	material_id=:materialId;";
    
    public static String GET_NEXT_RACK="select substr(aisle_id,2,2) from m_aisle where block=? order by aisle_id desc limit 1;";
    
    public static String GET_BIN_ID_PARTIALLY_FILLED_AISLE = "select\n"
            + "    bin.bin_id\n"
            + "from\n"
            + "	m_aisle as aisle,\n"
            + "    m_sub_bin as bin\n"
            + "where\n"
            + "	aisle.aisle_id= substring(bin.bin_id, 1, 5)\n"
            + "    and aisle.is_empty='Y'\n"
            + "    and aisle.active_status='P'\n"
            + "    and bin.is_empty='Y'\n"
            + "    and bin.active_status='P' \n"
            + "order by bin.bin_id limit 1;";
    
    public static String FETCH_ALL_PARTIAL_ALLOCEDMATERIAL = "SELECT\n"
            + "	material_master.*,SUM(mat_weight) as total_weight\n"
            + "FROM\n"
            + "	material_master INNER JOIN t_alloc_material\n"
            + "ON\n"
            + "	t_alloc_material.material_id = material_master.material_id\n"
            + " where t_alloc_material.active_status='P' "
            + "GROUP BY\n"
            + "	material_id\n"
            + "ORDER BY\n"
            + "	id DESC\n"
            + "LIMIT :offset,:limit";

    public static String FETCH_PARTIAL_CURRENT_ALLOC = "select \n"
            + "	id,bin_id,material_id,box_id,pallet_id,prod_date,mat_height,mat_weight,mat_diameter,mat_status,notes,packing_type,glaze,carton_type\n"
            + "from \n"
            + "	t_alloc_material \n"
            + "where \n"
            + "	material_id=:materialId \n"
            + "and active_status='P';";
    
    public static String FETCH_ALL_ALLOCEDMATERIAL_SORT_BY_MATNAME = "SELECT\n"
            + "	material_master.*,SUM(mat_weight) as total_weight\n"
            + "FROM\n"
            + "	material_master INNER JOIN t_alloc_material\n"
            + "ON\n"
            + "	t_alloc_material.material_id = material_master.material_id "
            + " where t_alloc_material.active_status = :activeStatus \n"
            + "GROUP BY\n"
            + "	material_id\n"
            + "ORDER BY\n"
            + "	material_master.mat_name desc \n"
            + "LIMIT :offset,:limit";
    
    
    public static String FETCH_ALL_ALLOCEDMATERIAL_SORT_BY_PROD_DATE = "SELECT\n"
            + "	material_master.*,SUM(mat_weight) as total_weight\n"
            + "FROM\n"
            + "	material_master INNER JOIN t_alloc_material\n"
            + "ON\n"
            + "	t_alloc_material.material_id = material_master.material_id "
            + " where t_alloc_material.active_status = :activeStatus \n"
            + "GROUP BY\n"
            + "	material_id\n"
            + "ORDER BY\n"
            + "	t_alloc_material.prod_date \n desc \n"
            + "LIMIT :offset,:limit";
    
    public static String FETCH_ALL_ALLOCEDMATERIAL_SORT_BY_MATNAME_ASC = "SELECT\n"
            + "	material_master.*,SUM(mat_weight) as total_weight\n"
            + "FROM\n"
            + "	material_master INNER JOIN t_alloc_material\n"
            + "ON\n"
            + "	t_alloc_material.material_id = material_master.material_id "
            + " where t_alloc_material.active_status = :activeStatus \n"
            + "GROUP BY\n"
            + "	material_id\n"
            + "ORDER BY\n"
            + "	material_master.mat_name asc \n"
            + "LIMIT :offset,:limit";
    
    
    public static String FETCH_ALL_ALLOCEDMATERIAL_SORT_BY_PROD_DATE_ASC = "SELECT\n"
            + "	material_master.*,SUM(mat_weight) as total_weight\n"
            + "FROM\n"
            + "	material_master INNER JOIN t_alloc_material\n"
            + "ON\n"
            + "	t_alloc_material.material_id = material_master.material_id "
            + " where t_alloc_material.active_status = :activeStatus \n"
            + "GROUP BY\n"
            + "	material_id\n"
            + "ORDER BY\n"
            + "	t_alloc_material.prod_date asc \n"
            + "LIMIT :offset,:limit";
    
    public static String SELECT_MATERIALS_MASTER_DETAILS_WITH_GRADE_PKG = "select \n"
            + "	material_id,mat_name,sub_mat_name,packing_type,grade,uom ,glaze,mat_mov_type\n"
            + "from\n"
            + "	material_master\n"
            + "where\n"
            + "active_status='Y'\n"
            + "and mat_name=:matName \n"
            + "and grade=:matGrade "
            + " and packing_type=:packingType \n"
            + "and sub_mat_name=:subName ;";
    
    public static String GET_BIN_ID_FROM_EQUAL_UNIQUE_MAT_COUNT_CHAMBER = "select\n"
            + "    bin.bin_id\n"
            + "from\n"
            + "	m_aisle as aisle,\n"
            + "    m_sub_bin as bin\n"
            + "where\n"
            + "	aisle.aisle_id= substring(bin.bin_id, 1, 5)\n"
            + "    and aisle.mat_mov_type = :matMovType\n"
            + "    and aisle.is_empty='Y'\n"
            + "    and aisle.active_status='Y'\n"
            + "    and bin.is_empty='Y'\n"
            + "    and bin.active_status='Y'"
            + "    and aisle.last_bin <= :matMaxCount \n"
            + "    and aisle.chamber=:chamber \n"
            + "order by bin.bin_id limit 1;";
    
    public static String UPDATE_REASON = "update arc_material set reason=:reason where id=:id";
}
