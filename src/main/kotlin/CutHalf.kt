fun String.cutHalf(): Pair<String, String> {
    val amount = this.length / 2
    return this.take(amount) to this.drop(amount)
}
