package script.db

databaseChangeLog(logicalFilePath: 'motion_summary.groovy') {
    changeSet(id: '20190709', author: '19531') {
        createTable(tableName: "motion_summary") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'id', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'hand_user_id', type: 'BIGINT', remarks: '性别')
            column(name: 'hand_full_name', type: 'VARCHAR(80)', remarks: '运动类型')
            column(name: 'gender', type: 'DECIMAL(15,2)', remarks: '总距离')
            column(name: 'total_distance_unit', type: 'VARCHAR(20)',remarks: '总距离的单位')
            column(name: 'single_distance', type: 'DECIMAL(15,2)', remarks: '单次距离')
            column(name: 'single_distance_unit', type: 'VARCHAR(20)',remarks: '单次距离单位')
            column(name: 'mini_speed', type: 'DECIMAL(15,2)', remarks: "每公里最低配速")
            column(name: 'mini_speed_unit', type: 'VARCHAR(20)',remarks: '每公里最低配速单位')
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue : "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
        }
    }
}