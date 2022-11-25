def call(String buildStatus, Map mailConfig){
    println(buildStatus)
    println(mailConfig)
    echo 'executed!'
    return 'someEmail@gmail.com'
}