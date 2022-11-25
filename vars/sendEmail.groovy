import groovy.json.*

def call(String buildStatus, String buildName, Map config){
    println(buildStatus)
    println(config)
    def mailConfigJSON =  JsonOutput.toJson(config.mail_settings)
    def recipients = mailConfigJSON[buildName][buildStatus.toLowerCase()]['send_to']
    



    echo 'executed!'
    return 'someEmail@gmail.com'
}