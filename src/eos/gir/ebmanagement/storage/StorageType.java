package eos.gir.ebmanagement.storage;


public enum StorageType {
    MYSQL,
    SQLITE,
    NONE;

    public static StorageType getStorageType(String typename) {
        for (StorageType type : values() ) {
            if ( type.name().equalsIgnoreCase(typename) ) {
                return type;
            }
        }

        if ( typename.equalsIgnoreCase("MySQL") ) {
            return MYSQL;
        }

        if ( typename.equalsIgnoreCase("SQLITE") ) {
            return SQLITE;
        }

        return NONE;
    }


}
