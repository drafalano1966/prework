package com.example.introduction

fun main() {

    var neverNull: String = "This can't be null"            // 1
    println("value of var neverNull:  ${neverNull}")

    //neverNull = null                                        // 2

    var nullable: String? = "You can keep a null here"      // 3
    println("1st instance value of var nullable:  ${nullable}") // 9

    nullable = null                                         // 4
    println("2nd instance value of var nullable:  ${nullable}.\n This works because of null safety in String?")

    var inferredNonNull = "The compiler assumes non-null"   // 5
    println("value of var neverNull:  ${inferredNonNull}")

    //inferredNonNull = null                                  // 6

    println("This is the string length of  neverNull var: ${strLength(neverNull)}")                                    // 8
    if (nullable != null) {
        println("This is the string length of  neverNull var: ${strLength(nullable)}")
    }
    else {
        println("neverNull var is NULL")
    }

    println(" value of describeString function:  ${describeString(null)}")

}

fun strLength(notNull: String): Int {                   // 7
    return notNull.length
}

fun describeString(maybeString: String?): String {              // 1
    return if (maybeString != null && maybeString.length > 0) {        // 2
        "String of length ${maybeString.length}"
    } else {
        "Empty or null string"                           // 3
    }
}