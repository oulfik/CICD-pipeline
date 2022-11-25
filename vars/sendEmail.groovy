import groovy.json.*

def call(String buildStatus, String buildName, Map config){
    println(buildStatus)
    def mailConfigJSON =  JsonOutput.toJson(config.mail_settings)
    println(mailConfigJSON)
    println(mailConfigJSON.getClass())
    def recipients = mailConfigJSON[buildName][buildStatus.toLowerCase()]['send_to']
    



    echo 'executed!'
    return 'someEmail@gmail.com'
}