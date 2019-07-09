package script.db

databaseChangeLog(logicalFilePath: 'motion_summary.groovy') {
    changeSet(id: '20190709', author: '19531') {
        createTable(tableName: "motion_summary") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'id', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'hand_user_id', type: 'BIGINT', remarks: '员工Id')
            column(name: 'hand_full_name', type: 'VARCHAR(80)', remarks: '姓名')
            column(name: 'gender', type: 'VARCHAR(20)', remarks: '性别')
            column(name: 'run_distance', type: 'DECIMAL(15,2)',remarks: '跑步距离')
            column(name: 'run_avg_speed', type: 'VARCHAR(40)', remarks: '跑步平均配速')
            column(name: 'walk_distance', type: 'DECIMAL(15,2)',remarks: '走路距离')
            column(name: 'walk_avg_speed', type: 'VARCHAR(40)', remarks: "走路平均配速")
            column(name: 'ride_distance', type: 'DECIMAL(15,2)',remarks: '骑行距离')
            column(name: 'ride_avg_speed', type: 'VARCHAR(40)', remarks: '骑行平均配速')
            column(name: 'other_distince', type: 'DECIMAL(15,2)',remarks: '其它类型距离')
            column(name: 'other_avg_speed', type: 'VARCHAR(40)', remarks: '其他类型配速')
            column(name: 'action_time', type: 'DATETIME',remarks: '汇总时间')
            column(name: 'status', type: 'VARCHAR(20)', remarks: "是否达标")
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue : "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue : "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed : "CURRENT_TIMESTAMP")
        }
    }
}