import groovy.yaml.YamlSlurper

def call(String buildStatus, String buildName, Map config){
    println(buildStatus)
    def mailConfigJSON =  new YamlSlurper().parseText(config.mail_settings)
    println(mailConfigJSON)
    println(mailConfigJSON.getClass())
    def recipients = mailConfigJSON[buildName][buildStatus.toLowerCase()]['send_to']
    



    echo 'executed!'
    return 'someEmail@gmail.com'
}