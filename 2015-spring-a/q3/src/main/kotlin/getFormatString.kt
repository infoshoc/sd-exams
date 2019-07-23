fun getFormatString(format: String, models: List<Model>): String {
    val visitor = when (format) {
        "XML" -> XMLVisitor()
        "JSON" -> JSONVisitor()
        else -> throw Exception()
    }

    return visitor.visit(models.map { it.accept(visitor) })
}

