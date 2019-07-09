package script.db
databaseChangeLog(logicalFilePath: 'hand_user.groovy') {
    changeSet(id: '20190704', author: '19531') {
        createTable(tableName: "hand_user") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'Id', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'user_number', type: 'VARCHAR(20)', remarks: '员工号')
            column(name: 'password', type: 'VARCHAR(32)', remarks: '密码') {
                constraints(unique: true)
            }
            column(name: 'gender', type: 'VARCHAR(20)', remarks: '性别')
            column(name: 'full_name', type: 'VARCHAR(40)', remarks: '姓名')
            column(name: 'wechat_number', type: 'VARCHAR(60)', remarks: '微信号')
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}