package script.db
databaseChangeLog(logicalFilePath: 'corn.groovy') {
    changeSet(id: '20190709', author: '19531') {
        createTable(tableName: "corn") {
            column(name: 'id', type: 'BIGINT UNSIGNED', remarks: 'Id', autoIncrement: true) {
                constraints(primaryKey: true)
            }
            column(name: 'cron', type: 'VARCHAR(40)', remarks: '定时器')
            column(name: 'purpose', type: 'VARCHAR(30)', remarks: '用途') {
                constraints(unique: true)
            }
            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT", defaultValue: "1")
            column(name: "CREATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT", defaultValue: "-1")
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}