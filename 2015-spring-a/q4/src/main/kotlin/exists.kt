fun exists(startingDirectory: String, fileName: String): Future<Boolean> {
    val ddu = DistributedDirectoryUtils()

    return or(
            contains(ddu.getFiles(startingDirectory), fileName),
            ddu.getSubDirectories(startingDirectory).flatMap { contains(ddu.sequence(it.map { exists(it, fileName) }), true) }
    )
}
