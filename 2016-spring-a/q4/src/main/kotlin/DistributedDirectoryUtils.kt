class DistributedDirectoryUtils {
    fun getFiles(dirName: String): Future<List<String>> {return Future { listOf() }
    }
    fun getSubDirectories(dirName: String): Future<List<String>> {return Future { listOf() }
    }
    fun <T> sequence(list: List<Future<T>>): Future<List<T>> {return Future { listOf() }
    }
}