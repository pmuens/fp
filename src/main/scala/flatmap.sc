// `flatMap` is a `map` followed by a `flatten`
val names = List("Henry", "Ford", "Thomas", "Edison")

val flatMapRes = names.flatMap(name => name.split(""))

// first `map`
val mapRes = names.map(name => name.split(""))
// then `flatten`
val mapFlattenRes = mapRes.flatten

flatMapRes == mapFlattenRes
