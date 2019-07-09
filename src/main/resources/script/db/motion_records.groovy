package script.db

databaseChangeLog(logicalFilePath: 'motion_records.groovy') {
    changeSet(id: '20190705', author: '19531') {
        createTable(tableName: "motion_records") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'id', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'hand_user_id', type: 'BIGINT', remarks: '用户Id')
            column(name: 'gender', type: 'VARCHAR(36)', remarks: '性别')
            column(name: 'motion_type', type: 'VARCHAR(36)', remarks: '运动类型')
            column(name: 'motion_distance', type: 'DECIMAL(15,2)',remarks: '运动距离')
            column(name: 'motion_speed', type: 'DECIMAL(15,2)', remarks: '使用时长')
            column(name: 'distance_unit', type: 'VARCHAR(20)',remarks: '距离单位')
            column(name: 'speed_unit', type: 'VARCHAR(20)', remarks: "配速单位")
            column(name: 'motion_time', type: 'DATETIME', remarks: '运动时间')
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue : "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
        }
    }
    changeSet(id: "20190706",author: '19531'){
        addColumn(tableName: 'motion_records'){
            column(name: 'img_url',type: 'VARCHAR(2000)',remarks: '图片地址',afterColumn:'motion_time')
        }
    }
    changeSet(id: '20190706-1',author: '19531'){
        addColumn(tableName: 'motion_records'){
            column(name: 'status',type: 'VARCHAR(20)',remarks: '是否达标',afterColumn:'img_url')
        }
    }
}