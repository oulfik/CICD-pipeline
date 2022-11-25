import groovy.json.*

def call(String buildStatus, String buildName, Map config){
    println(buildStatus)
    println(mailConfig)
    def mailConfigJSON =  JsonOutput.toJson(config.mail_settings)



    echo 'executed!'
    return 'someEmail@gmail.com'
}