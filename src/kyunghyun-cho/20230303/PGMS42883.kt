package `kyunghyun-cho`.`20230303`

/**
 * @author Kyunghyun Cho
 */

fun main() {
    val (number, k) = "4177252841" to 4 // 775841
    //val (number, k) = "7777" to 2
    println(solution(number, k))

}

fun solution(number: String, k: Int): String {
    var vk = k
    val origin = ArrayDeque<Char>().apply { this.addAll(number.toCharArray().toList()) }
    val answer = ArrayDeque<Char>()

    while(origin.isNotEmpty()){
        if(vk != 0 && answer.isNotEmpty()){
            val orig = origin.first()
            val answ = answer.last()
            if(answ < orig) {
                answer.removeLast()
                vk--
            }else{
                answer.addLast(origin.removeFirst())
            }
        }else{
            answer.addLast(origin.removeFirst())
        }
    }
    repeat(vk){
        answer.removeLast()
    }

    return answer.joinToString("")
}

