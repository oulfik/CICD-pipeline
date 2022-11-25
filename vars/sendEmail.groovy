
def call(String buildStatus, String buildName, Map config){
    def recipients = config.mail_settings[buildName][buildStatus.toLowerCase()]['send_to']
    def subject = ""
    def body = ""

    if(buildStatus == "SUCCESS"){
        subject = "Pipeline has succeded: ${currentBuild.fullDisplayName}"
        body = "Success in ${env.BUILD_URL}"
    } else if(buildStatus == "FAILURE"){
        subject = "Pipeline has failed!: ${currentBuild.fullDisplayName}"
        body = "Failure in ${env.BUILD_URL}"
    }
   
    emailext(
        to: 'someEmail@gmail.com; another@gmail.com',
        subject: subject,
        body: body
    )

    echo 'E-Mails have been successfully submitted!'

}