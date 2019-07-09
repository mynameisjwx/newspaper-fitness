package script.db

databaseChangeLog(logicalFilePath: 'motion_indicators.groovy') {
    changeSet(id: '20190704', author: '19531') {
        createTable(tableName: "motion_indicators") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'id', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'gender', type: 'VARCHAR(20)', remarks: '性别')
            column(name: 'motion_type', type: 'VARCHAR(36)', remarks: '运动类型')
            column(name: 'total_distance', type: 'DECIMAL(15,2)', remarks: '总距离') {
                constraints(unique: true)
            }
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