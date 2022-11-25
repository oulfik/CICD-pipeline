
def call(String buildStatus, String buildName, Map config){
    println(buildStatus)
    def recipients = config.mail_settings[buildName][buildStatus.toLowerCase()]['send_to']
    print(recipients)
    println(recipients.getClass())



    echo 'executed!'
    return 'someEmail@gmail.com'
}